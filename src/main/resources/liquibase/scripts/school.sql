-- liquibase formatted sql



-- changeset usov:2
CREATE INDEX student_name_find ON student (name);

-- changeset usov:3
CREATE INDEX faculty_name_or_color_find ON faculty (name, color);