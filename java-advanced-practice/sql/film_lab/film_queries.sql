-- 1
SELECT *
FROM movies
WHERE (release_date > '2010-12-31') AND duration_minutes > 120;

-- 2
SELECT *
FROM movies
WHERE budget_usd > 100000000
  AND box_office_usd IS NOT null;

-- 3
SELECT movies.country_id,countries.country_name, count(movies.country_id) AS film_count
FROM movies
   RIGHT JOIN countries
   ON movies.country_id = countries.country_id
GROUP BY movies.country_id, countries.country_name
HAVING count(movies.country_id) >= 50
ORDER BY country_id;

-- 4
SELECT count(*) FILTER ( WHERE box_office_usd IS NULL ) AS null_counter, count(*) FILTER ( WHERE box_office_usd IS NULL ) * 100.0 / count(*) AS null_percentage
FROM movies;

-- 5
SELECT age_rating,
      AVG(duration_minutes) AS avg_min
FROM movies
GROUP BY age_rating;

-- 6
SELECT EXTRACT(YEAR FROM release_date) AS release_year,
       count(*)
FROM movies
GROUP BY release_year
ORDER BY release_year;

-- 7
SELECT m.title,
       s.studio_name,
       c.country_name,
       l.language_name
FROM movies m
   LEFT JOIN studios s
       on m.studio_id = s.studio_id
   LEFT JOIN countries c
       on s.country_id = c.country_id
   LEFT JOIN languages l on m.original_language_id = l.language_id;

-- 8
SELECT genre_name, STRING_AGG(m.title, ' | ')
FROM movies m
   LEFT JOIN movie_genres mg
       ON mg.movie_id = m.movie_id
   LEFT JOIN genres g
       ON mg.genre_id = g.genre_id
GROUP BY genre_name;

-- 9
SELECT p.first_name || ' ' || p.last_name AS person_name, mc.character_name, m.title, EXTRACT(YEAR FROM release_date) AS release_year
FROM movies m
   LEFT JOIN movie_cast mc
       ON m.movie_id = mc.movie_id
   LEFT JOIN people p ON p.person_id = mc.person_id;

-- 10
SELECT p.first_name || ' ' || p.last_name AS director,
       m.title,
       AVG(r.rating) AS average_rating
FROM movies m
   LEFT JOIN movie_crew mc
       ON m.movie_id = mc.movie_id
   LEFT JOIN film_lab.people p
       on mc.person_id = p.person_id
   LEFT JOIN ratings r
       ON m.movie_id = r.movie_id
WHERE job = 'Director'
GROUP BY p.person_id, m.movie_id;

-- 11
SELECT p.first_name || ' ' || p.last_name AS director_name,
       COUNT(DISTINCT m.movie_id)
FROM movies m
    JOIN movie_crew mc
        ON m.movie_id = mc.movie_id
        AND mc.job = 'Director'
    JOIN people p
   ON mc.person_id = p.person_id
GROUP BY p.person_id;

-- 12
SELECT
    p.first_name || ' ' || p.last_name AS actor_name,
    COUNT(DISTINCT m.movie_id) AS movie_counter,
    COUNT(DISTINCT mG.genre_id) AS genre_counter
FROM movies m
     JOIN movie_cast mc
       ON m.movie_id = mc.movie_id
     JOIN people p ON mc.person_id = p.person_id
     JOIN movie_genres mg ON m.movie_id = mg.movie_id
GROUP BY p.person_id
HAVING COUNT(DISTINCT mg.genre_id) >= 2
ORDER BY movie_counter DESC;

-- 13
SELECT u.user_id
FROM users u
WHERE EXISTS(
    SELECT 1
    FROM ratings r
    WHERE r.user_id = u.user_id
)
AND NOT EXISTS(
    SELECT 1
    FROM reviews rw
    WHERE rw.user_id = u.user_id
);

-- 14
SELECT m.movie_id, m.title
FROM movies m
    LEFT JOIN ratings r
        ON m.movie_id = r.movie_id
WHERE r.movie_id IS NULL;

-- 15
SELECT *
FROM users u
WHERE EXISTS(
    SELECT 1
    FROM watchlists wl
    WHERE wl.user_id = u.user_id
)
AND NOT EXISTS(
    SELECT 1
    FROM ratings r
    WHERE u.user_id = r.user_id
);

-- 16
SELECT
    m.title AS movie_title,
    string_agg(DISTINCT pa.first_name || ' ' || pa.last_name, ', ') AS actors,
    STRING_AGG(DISTINCT pd.first_name || ' ' || pd.last_name, ', ') AS directors,
    STRING_AGG(DISTINCT g.genre_name, ', ') AS genres,
    s.studio_name
FROM movies m
    LEFT JOIN movie_cast actor ON m.movie_id = actor.movie_id
    LEFT JOIN movie_crew director ON m.movie_id = director.movie_id
        AND director.job = 'Director'
    LEFT JOIN people pa ON actor.person_id = pa.person_id
    LEFT JOIN people pd ON director.person_id = pd.person_id
    LEFT JOIN studios s ON m.studio_id = s.studio_id
    LEFT JOIN movie_genres mg ON m.movie_id = mg.movie_id
    LEFT JOIN genres g ON mg.genre_id = g.genre_id
GROUP BY m.movie_id, s.studio_id;