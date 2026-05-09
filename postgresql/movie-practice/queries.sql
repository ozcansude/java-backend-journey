SELECT * FROM movies;

SELECT *
FROM movies
WHERE year>2000;

SELECT *
FROM movies
WHERE director LIKE
      'Christopher Nolan';

SELECT *
FROM movies
ORDER BY year;

SELECT *
FROM movies
WHERE title LIKE '%The%';

SELECT count(*) FROM movies;

SELECT director, count(*)
FROM movies
GROUP BY director;


SELECT *
FROM movies
WHERE year BETWEEN 1990 AND 2010;

UPDATE movies
SET year = 2026
WHERE title = 'Avatar';




DELETE FROM movies
WHERE title = 'Avatar';

SELECT *
FROM movies;