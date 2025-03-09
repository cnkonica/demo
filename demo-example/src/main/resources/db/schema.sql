DROP TABLE IF EXISTS orm_user;

CREATE TABLE orm_user (
                          id SERIAL PRIMARY KEY, -- Auto-increment in PostgreSQL
                          name VARCHAR(32) NOT NULL UNIQUE, -- Unique username
                          password VARCHAR(32), -- Encrypted password
                          salt VARCHAR(32), -- Encryption salt
                          email VARCHAR(32) UNIQUE, -- Unique email
                          phone_number VARCHAR(15) UNIQUE, -- Unique phone number
                          status SMALLINT DEFAULT NULL, -- Status (-1: Deleted, 0: Disabled, 1: Enabled)
                          create_time TIMESTAMP DEFAULT NOW(), -- Creation time with default value
                          last_login_time TIMESTAMP, -- Last login time
                          last_update_time TIMESTAMP DEFAULT NOW() -- Last update time with default value
);


