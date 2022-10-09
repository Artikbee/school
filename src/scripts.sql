select *
from student;

select *
from student
where age between 10 and 20;

select name
from student;

select name
from student
where name like '%s%';

SELECT *
FROM student
WHERE age < id;

SELECT *
FROM student
ORDER BY age;


SELECT *
FROM student,faculty
WHERE student.faculty_id =faculty.id
