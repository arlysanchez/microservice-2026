CREATE TABLE user_info (
    id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

/*INSERT INTO user_info (username, password)
    VALUES ('admin', '$2a$10$XQuIIvDce7gmvxvuHi6Zxez08lTVVG24bUk0uUOEL7wFYD0GBoU6i');
-------------------------------------------
*/