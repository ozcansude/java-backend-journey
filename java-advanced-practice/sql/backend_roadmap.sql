
CREATE TABLE IF NOT EXISTS public.students (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    age SMALLINT NOT NULL CHECK (age >= 0)
);
INSERT INTO students(name,surname,email,age)
VALUES ('sude','ozcan','ozcanssudee@gmail.com',22),
       ('berke','dinler','dinlerberke@gmail.com',21),
       ('iklima','yesilli','iklimayesilli@gmail.com',21),
       ('mustafa','ozcan','ozcanmustf@gmail.com',26),
       ('rabia','ozcan','rabia@gmail.com',17);

CREATE TABLE IF NOT EXISTS public.courses(
    course_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

INSERT INTO courses( name)
VALUES ('java'),
       ( 'PostgreSQL'),
       ( 'AI'),
       ('API'),
       ('pyhton');

SELECT * FROM courses;
SELECT * FROM students;