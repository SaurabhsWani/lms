create database library;

use library;

CREATE TABLE book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) UNIQUE NOT NULL
);


CREATE TABLE member (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    member_id VARCHAR(20) UNIQUE NOT NULL
);


CREATE TABLE borrowing (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    book_id BIGINT NOT NULL,
    member_id BIGINT NOT NULL,
    borrowed_date DATE NOT NULL,
    return_date DATE,
    FOREIGN KEY (book_id) REFERENCES book(id),
    FOREIGN KEY (member_id) REFERENCES member(id)
);

INSERT INTO book (title, author, isbn) VALUES 
('Effective Java', 'Joshua Bloch', '161-9821356680'),
('Spring Boot in Action', 'Craig Walls', '161-9817292545'),
('Java Concurrency in Practice', 'Brian Goetz', '161-9821349606'),
('Building Microservices with Spring Boot', 'Felipe Gutierrez', '161-9884231647'),
('Artificial Intelligence: A Modern Approach', 'Stuart Russell and Peter Norvig', '161-9836042594'),
('Hands-On Artificial Intelligence with Java for Beginners', 'Nisheeth Joshi', '161-9889537559'),
('Deep Learning for Java Developers', 'Skrzypinski', '161-9888470315'),
('Generative AI with Python and TensorFlow', 'Joseph Babcock', '161-9839219535'),
('Spring Microservices in Action', 'John Carnell', '161-9817293986'),
('Practical Artificial Intelligence with Swift', 'Mars Geldard, Tim Nugent, and Paris Buttfield-Addison', '161-9892094828');
