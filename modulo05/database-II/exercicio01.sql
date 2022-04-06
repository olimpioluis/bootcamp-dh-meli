USE movies_db;

/* Mostrar o título e o nome do gênero de todas as séries. */
SELECT series.title, genres.name
FROM series
INNER JOIN genres ON series.genre_id = genres.id;

/* Mostrar o título dos episódios, o nome e sobrenome dos atores que trabalham em cada um deles. */
SELECT episodes.title, actors.first_name, actors.last_name
FROM episodes
INNER JOIN actor_episode ON actor_episode.episode_id = episodes.id
INNER JOIN actors ON actor_episode.actor_id = actors.id;

/* Mostrar o título de todas as séries e o número total de temporadas que cada uma delas possui. */
SELECT COUNT(*) AS Seasons, series.title AS Title
FROM series
INNER JOIN seasons ON series.id = seasons.serie_id
GROUP BY series.title;

/* Mostrar o nome de todos os gêneros e o número total de filmes de cada um, desde que seja maior ou igual a 3. */
SELECT COUNT(*) AS Quantity, genres.name as Genêro
FROM genres
INNER JOIN movies ON genres.id = movies.genre_id
GROUP BY genres.name
HAVING Quantity >= 3;

/* Mostrar apenas o nome e sobrenome dos atores que atuam em todos os filmes de Star Wars e que estes não se repitam. */
SELECT DISTINCT actors.first_name, actors.last_name
FROM actors
INNER JOIN actor_movie ON actors.id = actor_movie.actor_id
INNER JOIN movies ON movies.id = actor_movie.movie_id
WHERE movies.title LIKE 'La Guerra de las galaxias%';