--
-- PostgreSQL database dump
--

-- Dumped from database version 11.9
-- Dumped by pg_dump version 11.9

-- Started on 2022-02-12 09:34:35

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF-8';
SET standard_conforming_strings = on;

SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

SET SEARCH_PATH to "Mahjong";




CREATE SEQUENCE IF NOT EXISTS country_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;


ALTER SEQUENCE country_id_seq OWNER TO "Mahjong";

CREATE TABLE IF NOT EXISTS country (
    id bigint NOT NULL CONSTRAINT country_pkey PRIMARY KEY DEFAULT nextval('country_id_seq'::regclass),
	version integer NOT NULL,
    created timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    deleted boolean NOT NULL,
    updated timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    code character varying(255) NOT NULL COLLATE pg_catalog."default",
    name character varying(255) NOT NULL COLLATE pg_catalog."default",
    nationality character varying(255) NOT NULL COLLATE pg_catalog."default"
);


ALTER TABLE country OWNER TO "Mahjong";


CREATE SEQUENCE IF NOT EXISTS person_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;


ALTER SEQUENCE person_id_seq OWNER TO "Mahjong";


CREATE TABLE IF NOT EXISTS person (
    id bigint NOT NULL CONSTRAINT person_pkey PRIMARY KEY DEFAULT nextval('person_id_seq'::regclass),
	version integer NOT NULL,
    created timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    deleted boolean NOT NULL,
    updated timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    birthday date,
    all_names character varying(255) COLLATE pg_catalog."default",
    surnames character varying(255) COLLATE pg_catalog."default",
    country_id bigint,
	
	FOREIGN KEY (country_id) REFERENCES country(id)
);


ALTER TABLE person OWNER TO "Mahjong";



CREATE SEQUENCE IF NOT EXISTS player_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE player_id_seq OWNER TO "Mahjong";

CREATE TABLE IF NOT EXISTS player (
    id bigint NOT NULL CONSTRAINT player_pkey PRIMARY KEY DEFAULT nextval('player_id_seq'::regclass),
	version integer NOT NULL,
    created timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    deleted boolean NOT NULL,
    updated timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    nickname character varying(255) NOT NULL COLLATE pg_catalog."default",
    person_id bigint,
	
	FOREIGN KEY (person_id) REFERENCES person(id)
);


ALTER TABLE player OWNER TO "Mahjong";






CREATE SEQUENCE IF NOT EXISTS uma_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE uma_id_seq OWNER TO "Mahjong";

CREATE TABLE IF NOT EXISTS uma (
    id bigint NOT NULL CONSTRAINT uma_pkey PRIMARY KEY DEFAULT nextval('uma_id_seq'::regclass),
	version integer NOT NULL,
    created timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    deleted boolean NOT NULL,
    updated timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    first_place integer NOT NULL,
    fourth_place integer,
    name character varying(255) NOT NULL COLLATE pg_catalog."default",
    second_place integer NOT NULL,
    third_place integer NOT NULL
);

ALTER TABLE uma OWNER TO "Mahjong";





CREATE SEQUENCE IF NOT EXISTS ruleset_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;


ALTER SEQUENCE ruleset_id_seq OWNER TO "Mahjong";

CREATE TABLE IF NOT EXISTS ruleset (
    id bigint NOT NULL CONSTRAINT ruleset_pkey PRIMARY KEY DEFAULT nextval('ruleset_id_seq'::regclass),
	version integer NOT NULL,
    created timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    deleted boolean NOT NULL,
    updated timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    aka boolean NOT NULL,
    chonbo integer NOT NULL,
    game_type character varying(255) NOT NULL COLLATE pg_catalog."default",
    in_points integer NOT NULL,
    name character varying(255) NOT NULL COLLATE pg_catalog."default",
    oka integer NOT NULL,
    out_points integer NOT NULL,
    rounding boolean NOT NULL,
    sanma boolean NOT NULL,
    sudden_death boolean NOT NULL,
    uma_id bigint NOT NULL,
	
	FOREIGN KEY (uma_id) REFERENCES uma(id)
);


ALTER TABLE ruleset OWNER TO "Mahjong";




CREATE SEQUENCE IF NOT EXISTS season_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;


ALTER SEQUENCE season_id_seq OWNER TO "Mahjong";

CREATE TABLE IF NOT EXISTS season (
    id bigint NOT NULL CONSTRAINT season_pkey PRIMARY KEY DEFAULT nextval('season_id_seq'::regclass),
	version integer NOT NULL,
    created timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    deleted boolean NOT NULL,
    updated timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    end_date date,
    season_name character varying(255) COLLATE pg_catalog."default",
    season_number integer NOT NULL,
    ranked_games_count boolean NOT NULL,
    start_date date NOT NULL,
    ruleset_id bigint NOT NULL,
	
	FOREIGN KEY (ruleset_id) REFERENCES ruleset(id)
);


ALTER TABLE season OWNER TO "Mahjong";



CREATE SEQUENCE IF NOT EXISTS tournament_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;


ALTER SEQUENCE tournament_id_seq OWNER TO "Mahjong";

CREATE TABLE IF NOT EXISTS tournament (
    id bigint NOT NULL CONSTRAINT tournament_pkey PRIMARY KEY DEFAULT nextval('tournament_id_seq'::regclass),
	version integer NOT NULL,
    created timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    deleted boolean NOT NULL,
    updated timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    end_date date,
    name character varying(255) COLLATE pg_catalog."default",
    start_date date,
    tournament_type character varying(255) COLLATE pg_catalog."default",
    ruleset_id bigint NOT NULL,
    tournament_id bigint,
	
	FOREIGN KEY (tournament_id) REFERENCES season(id),
	FOREIGN KEY (ruleset_id) REFERENCES ruleset(id)

);


ALTER TABLE tournament OWNER TO "Mahjong";





CREATE SEQUENCE IF NOT EXISTS game_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;


ALTER SEQUENCE game_id_seq OWNER TO "Mahjong";

CREATE TABLE IF NOT EXISTS game (
    game_type character varying(31) NOT NULL,
    id bigint NOT NULL CONSTRAINT game_pkey PRIMARY KEY DEFAULT nextval('game_id_seq'::regclass),
	version integer NOT NULL,
    created timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    deleted boolean NOT NULL,
    updated timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    date_played date NOT NULL,
    game_length character varying(255) NOT NULL COLLATE pg_catalog."default",
    location bytea,
    ruleset_id bigint NOT NULL,
    season_id bigint,
    tournament_id bigint,
	
	FOREIGN KEY (tournament_id) REFERENCES tournament(id),
	FOREIGN KEY (season_id) REFERENCES season(id),
	FOREIGN KEY (ruleset_id) REFERENCES ruleset(id)
);


ALTER TABLE game OWNER TO "Mahjong";




CREATE SEQUENCE IF NOT EXISTS dan_points_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;


ALTER SEQUENCE dan_points_id_seq OWNER TO "Mahjong";

CREATE TABLE IF NOT EXISTS dan_points (
    id bigint NOT NULL CONSTRAINT dan_points_pkey PRIMARY KEY DEFAULT nextval('dan_points_id_seq'::regclass),
	version integer NOT NULL,
    created timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    deleted boolean NOT NULL,
    updated timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    sanma boolean NOT NULL,
    value integer NOT NULL,
    game_id bigint NOT NULL,
    player_id bigint NOT NULL,
	
	FOREIGN KEY (player_id) REFERENCES player(id),
	FOREIGN KEY (game_id) REFERENCES game(id)
);


ALTER TABLE dan_points OWNER TO "Mahjong";






CREATE SEQUENCE IF NOT EXISTS location_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;



ALTER SEQUENCE location_id_seq OWNER TO "Mahjong";

CREATE TABLE IF NOT EXISTS location (
    id bigint NOT NULL CONSTRAINT location_pkey PRIMARY KEY DEFAULT nextval('location_id_seq'::regclass),
	version integer NOT NULL,
    created timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    deleted boolean NOT NULL,
    updated timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    address character varying(255) COLLATE pg_catalog."default",
    name character varying(255) NOT NULL COLLATE pg_catalog."default",
    online character varying(255) COLLATE pg_catalog."default"
);


ALTER TABLE location OWNER TO "Mahjong";



CREATE SEQUENCE IF NOT EXISTS player_account_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;


ALTER SEQUENCE player_account_id_seq OWNER TO "Mahjong";

CREATE TABLE IF NOT EXISTS player_account (
    id bigint NOT NULL CONSTRAINT player_account_pkey PRIMARY KEY DEFAULT nextval('player_account_id_seq'::regclass),
	version integer NOT NULL,
    created timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    deleted boolean NOT NULL,
    updated timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    account_id character varying(255) NOT NULL COLLATE pg_catalog."default",
    game_account character varying(255) NOT NULL COLLATE pg_catalog."default",
    player_id bigint,
	
	FOREIGN KEY (player_id) REFERENCES player(id)
);


ALTER TABLE player_account OWNER TO "Mahjong";




CREATE SEQUENCE IF NOT EXISTS player_game_result_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;


ALTER SEQUENCE player_game_result_id_seq OWNER TO "Mahjong";

CREATE TABLE IF NOT EXISTS player_game_result (
    id bigint NOT NULL CONSTRAINT game_result_pkey PRIMARY KEY DEFAULT nextval('player_game_result_id_seq'::regclass),
	version integer NOT NULL,
    created timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    deleted boolean NOT NULL,
    updated timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    chonbo integer,
    final_position integer,
    final_score integer NOT NULL,
    score integer,
    starting_wind integer,
    game_id bigint,
    player_id bigint,
	
	FOREIGN KEY (player_id) REFERENCES player(id),
	FOREIGN KEY (game_id) REFERENCES game(id)
);


ALTER TABLE player_game_result OWNER TO "Mahjong";










CREATE SEQUENCE IF NOT EXISTS rate_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
ALTER SEQUENCE rate_id_seq OWNER TO "Mahjong";

CREATE TABLE IF NOT EXISTS rate (
    id bigint NOT NULL CONSTRAINT rate_pkey PRIMARY KEY DEFAULT nextval('rate_id_seq'::regclass),
	version integer NOT NULL,
    created timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    deleted boolean NOT NULL,
    updated timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    sanma boolean NOT NULL,
    value integer NOT NULL,
    game_id bigint NOT NULL,
    player_id bigint NOT NULL,
	
	FOREIGN KEY (player_id) REFERENCES player(id),
	FOREIGN KEY (game_id) REFERENCES game(id)
);


ALTER TABLE rate OWNER TO "Mahjong";




CREATE SEQUENCE IF NOT EXISTS season_points_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;


ALTER SEQUENCE season_points_id_seq OWNER TO "Mahjong";

CREATE TABLE IF NOT EXISTS season_points (
    id bigint NOT NULL CONSTRAINT season_points_pkey PRIMARY KEY DEFAULT nextval('season_points_id_seq'::regclass),
	version integer NOT NULL,
    created timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    deleted boolean NOT NULL,
    updated timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    sanma boolean NOT NULL,
    value integer NOT NULL,
    game_id bigint NOT NULL,
    player_id bigint NOT NULL,
	
	FOREIGN KEY (game_id) REFERENCES game(id),
	FOREIGN KEY (player_id) REFERENCES player(id)
);


ALTER TABLE season_points OWNER TO "Mahjong";





CREATE SEQUENCE IF NOT EXISTS season_uma_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;


ALTER SEQUENCE season_uma_id_seq OWNER TO "Mahjong";

CREATE TABLE IF NOT EXISTS season_uma (
    season bytea,
    id bigint NOT NULL CONSTRAINT season_uma_pkey PRIMARY KEY DEFAULT nextval('season_uma_id_seq'::regclass),
	version integer NOT NULL,
	FOREIGN KEY (id) REFERENCES uma(id)
);


ALTER TABLE season_uma OWNER TO "Mahjong";


CREATE SEQUENCE IF NOT EXISTS tournament_results_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE tournament_results_id_seq OWNER TO "Mahjong";

CREATE TABLE IF NOT EXISTS tournament_results (
    id bigint NOT NULL CONSTRAINT tournament_results_pkey PRIMARY KEY DEFAULT nextval('tournament_results_id_seq'::regclass),
	version integer NOT NULL,
    created timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    deleted boolean NOT NULL,
    updated timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    final_placement integer,
    points integer,
    player_id bigint NOT NULL,
    season_id bigint NOT NULL,
    tournament_id bigint NOT NULL,
	
	FOREIGN KEY (tournament_id) REFERENCES tournament(id),
	FOREIGN KEY (season_id) REFERENCES season(id),
	FOREIGN KEY (player_id) REFERENCES player(id)
);


ALTER TABLE tournament_results OWNER TO "Mahjong";


























