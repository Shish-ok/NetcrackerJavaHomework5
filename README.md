# NetcrackerJavaHomework5

Здравствуй, Глеб!

Ссылка на обзор ДЗ: https://youtu.be/c4kmvl8fPGg

Код для создания БД:

CREATE DATABASE homework5;

CREATE TABLE employees (

    id serial PRIMARY KEY,
    
    surname character varying(255) NOT NULL,
    
    name character varying(255) NOT NULL,
    
    lastname character varying(255) NOT NULL,
    
    age integer NOT NULL,
    
    salary integer NOT NULL,
    
    email character varying(30) NOT NULL,
    
    company character varying(255)
    
);
