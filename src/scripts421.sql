ALTER TABLE student
    ADD CHECK (age > 16),
    ALTER COLUMN name SET NOT NULL,
    ADD CONSTRAINT name_unique UNIQUE (name),
    ALTER COLUMN age SET DEFAULT 20;

ALTER TABLE faculty
    ADD CONSTRAINT facultyNameAndColor_unique UNIQUE (name,color);

