package ru.hogwarts.school.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter
@Setter


@Entity
public class Avatar {

    @Id
    @GeneratedValue
    private Long id;
    private String filePath; // храниться путь до файла на диске
    private long fileSize; // размер файла в байтах
    private String mediaType; // тип файла
    private byte[] data; // храниться информация о файле

    @OneToOne
    private Student student;
}
