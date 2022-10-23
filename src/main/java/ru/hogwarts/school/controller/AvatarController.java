package ru.hogwarts.school.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.service.AvatarService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

@RestController
public class AvatarController {

    private final AvatarService avatarService;
    // consumes означает,
    // что приложение ожидает в запросе тип содержимого multipart/form-data

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @GetMapping("{id}")
    public ResponseEntity<String> downloadAvatar(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Avatar avatar = avatarService.findAvatar(id);
        if (avatar == null) {
            return ResponseEntity.notFound().build();
        }

        Path path = Path.of(avatar.getFilePath());
        try (InputStream is = Files.newInputStream(path);
             OutputStream os = response.getOutputStream()
        ) {
            response.setStatus(200);
            response.setContentType(avatar.getMediaType());
            response.setContentLength((int) avatar.getFileSize());
            is.transferTo(os);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}/data")
    public ResponseEntity<byte[]> downloadAvatar(@PathVariable Long id)  {
        Avatar avatar = avatarService.findAvatar(id);
        if (avatar == null) {
            return ResponseEntity.notFound().build();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(avatar.getMediaType()));
        headers.setContentLength(avatar.getData().length);

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(avatar.getData());
    }

    @GetMapping("/kk")
    public ResponseEntity<Collection<Avatar>> readAllAvatar(@RequestParam("page") int pageNumber,
                                            @RequestParam("size") int pageSize){
        Collection<Avatar> avatars = avatarService.getAllAvatar(pageNumber, pageSize);
        return ResponseEntity.ok(avatars);

    }

    @PostMapping(value = "{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadAvatar(@PathVariable Long id, @RequestParam MultipartFile file) throws IOException {
        Avatar avatar = avatarService.uploadAvatar(id, file);
        if (file.getSize() >= 1024 * 340) {
            return ResponseEntity.badRequest().body("File is too big");
        }
        if (avatar == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }




}
