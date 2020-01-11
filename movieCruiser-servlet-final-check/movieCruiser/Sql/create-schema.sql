-- CREATE MOVIES TABLE

CREATE TABLE `moviecruiser`.`movies` (
  `mov_id` INT NOT NULL AUTO_INCREMENT,
  `mov_title` VARCHAR(100) NULL,
  `mov_box_office` BIGINT NULL,
  `mov_box_office` BIGINT NULL,
  `mov_active` VARCHAR(100) NULL,
  `mov_date_of_launch` DATE NULL,
  `mov_genre` VARCHAR(45) NULL,
  `mov_has_teaser` VARCHAR(3) NULL,
  PRIMARY KEY (`mov_id`));




-- CREATE USER TABLE

CREATE TABLE `moviecruiser`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT,
  `us_name` VARCHAR(60) NULL,
  PRIMARY KEY (`us_id`));




-- CREATE FAVORITES TABLE

CREATE TABLE `moviecruiser`.`favorites` (
  `fav_id` INT NOT NULL AUTO_INCREMENT,
  `fav_us_id` INT NULL,
  `fav_mov_id` INT NULL,
  PRIMARY KEY (`fav_id`),
  INDEX `fav_us_id_idx` (`fav_us_id` ASC) VISIBLE,
  INDEX `fav_mov_id_idx` (`fav_mov_id` ASC) VISIBLE,
  CONSTRAINT `fav_us_id`
    FOREIGN KEY (`fav_us_id`)
    REFERENCES `moviecruiser`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fav_mov_id`
    FOREIGN KEY (`fav_mov_id`)
    REFERENCES `moviecruiser`.`movies` (`mov_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- INSERT DATA IN MOVIES TABLE

INSERT INTO `moviecruiser`.`movies` (`mov_id`, `mov_title`, `mov_box_office`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_has_teaser`) VALUES ('1', 'Avatar', '2787965087', 1, '2019-05-08', 'Science Fiction', 1);
INSERT INTO `moviecruiser`.`movies` (`mov_id`, `mov_title`, `mov_box_office`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_has_teaser`) VALUES ('2', 'The Avengers', '1518812988', 1, '2019-03-13', 'Super Hero', 0);
INSERT INTO `moviecruiser`.`movies` (`mov_id`, `mov_title`, `mov_box_office`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_has_teaser`) VALUES ('3', 'Titanic', '2187463944', 1, '2018-03-09', 'Romance', 0);
INSERT INTO `moviecruiser`.`movies` (`mov_id`, `mov_title`, `mov_box_office`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_has_teaser`) VALUES ('4', 'Jurassic World', '1671713208', 0, '2020-05-09', 'Science Fiction', 1);
INSERT INTO `moviecruiser`.`movies` (`mov_id`, `mov_title`, `mov_box_office`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_has_teaser`) VALUES ('5', 'Avengers: End Game', '2750760348', 1, '202-08-09', 'Superhero', 1);




select mov_id, mov_title, mov_box_office, mov_active, mov_date_of_launch, mov_genre, mov_has_teaser from moviecruiser.movies;


-- INSERTING DATA INTO USER TABLE

INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('1', 'Hemant');
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('2', 'Iftesam');


-- ALTER TABLE DATA
UPDATE `moviecruiser`.`movies` SET `mov_date_of_launch` = '2020-08-09' WHERE (`mov_id` = '5');


-- 1.	View Movie List(TYUC001)  
 SELECT mov_id, mov_title, mov_box_office, mov_active, mov_date_of_launch, mov_genre, mov_has_teaser from moviecruiser.movies where mov_active = 1 and mov_date_of_launch > (select CURDATE());



-- 3.	Edit Movie (TYUC003)
select mov_id, mov_title, mov_box_office, mov_active, mov_date_of_launch, mov_genre, mov_has_teaser from moviecruiser.movies where mov_id = '1';

update moviecruiser.movies
set mov_title = 'Life In a Metro', mov_box_office = 5435434, mov_active = 1, mov_date_of_launch = '2020-01-01', mov_genre = 'Romantic', mov_has_teaser = '0'
where mov_id = 4;



-- 4.	Add to Favorites (TYUC004)

INSERT INTO `moviecruiser`.`favorites` (`fav_id`, `fav_us_id`, `fav_mov_id`) VALUES ('1', '1', '1');
INSERT INTO `moviecruiser`.`favorites` (`fav_id`, `fav_us_id`, `fav_mov_id`) VALUES ('2', '1', '3');
INSERT INTO `moviecruiser`.`favorites` (`fav_id`, `fav_us_id`, `fav_mov_id`) VALUES ('3', '1', '5');



-- 5.	View Favorites (TYUC005) get all movies in a particular user’s favorite list
select mov_id, mov_title, mov_box_office, mov_active, mov_date_of_launch, mov_genre, mov_has_teaser from moviecruiser.movies
inner join favorites on
fav_mov_id = mov_id
where fav_us_id = 1;


-- View Favorites (TYUC005) get the total gross of all movies in a particular user’s favorite list
select count(fav_id) as Total_Favorites from moviecruiser.movies inner join favorites on fav_mov_id = mov_id where fav_us_id = 1;

-- 6.	Remove Item from Cart (TYUC006)
delete from `moviecruiser`.`favorites` where fav_us_id = 1 and  fav_mov_id = 1 limit 1;



-- 7. Alter table data

UPDATE `moviecruiser`.`movies` SET `mov_has_teaser` = '1', `mov_active` = '1' WHERE (`mov_id` = '1');
UPDATE `moviecruiser`.`movies` SET `mov_has_teaser` = '0', `mov_active` = '1' WHERE (`mov_id` = '2');
UPDATE `moviecruiser`.`movies` SET `mov_has_teaser` = '0', `mov_active` = '0' WHERE (`mov_id` = '3');
UPDATE `moviecruiser`.`movies` SET `mov_has_teaser` = '0', `mov_active` = '1' WHERE (`mov_id` = '4');
UPDATE `moviecruiser`.`movies` SET `mov_has_teaser` = '1', `mov_active` = '1' WHERE (`mov_id` = '5');
