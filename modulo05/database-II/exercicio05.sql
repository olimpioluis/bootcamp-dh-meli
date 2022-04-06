USE movies_db;

-- Adicione um gênero à tabela de gêneros.
INSERT INTO `genres`
VALUES (
	13,'2011-07-04 03:00:00',NULL,'Ação',13,1
);
 
-- Adicione um filme à tabela de filmes.
INSERT INTO `movies`
VALUES (
	22,NULL,NULL,'Vingadores',9.1,1,'2012-05-04 00:00:00',90,13
);

-- Associe o filme do ponto 1. com o gênero criado no ponto 2.
UPDATE `movies` SET `genre_id` = 13 WHERE `id` = 22;

-- Modifique a tabela de atores para que pelo menos um ator tenha o filme adicionado no ponto 1 como favorito.
UPDATE movies SET genre_id = 13 WHERE id = 1;

-- Crie uma tabela temporária da tabela filmes. 
CREATE TEMPORARY TABLE movies_temp(
	(SELECT * FROM movies)
);

ALTER TABLE movies_temp
ADD PRIMARY KEY (`id`);

-- Elimine dessa tabela temporária todos os filmes que ganharam menos de 5 prêmios.
DELETE FROM movies_temp WHERE awards < 5 AND id <> 0;

-- Obtenha a lista de todos os gêneros que possuem pelo menos um filme.
SELECT COUNT(movies.genre_id) AS total_movies, genres.name
FROM movies
INNER JOIN genres ON genres.id = movies.genre_id
GROUP BY movies.genre_id;

-- Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios.
SELECT actors.first_name, actors.last_name, movies.title AS movie_title, movies.awards AS movie_awards
FROM actors
INNER JOIN movies ON movies.id = actors.favorite_movie_id
WHERE actors.favorite_movie_id = movies.id AND movies.awards > 3;

-- Crie um índice no nome na tabela de filmes.
ALTER TABLE movies
ADD INDEX movies_idx (title);

-- Crie um índice no nome na tabela de filmes.
SHOW INDEX FROM movies;