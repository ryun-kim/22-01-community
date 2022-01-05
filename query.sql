CREATE TABLE t_user(
                       iuser INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
                       uid VARCHAR(15) UNIQUE NOT NULL,
                       upw VARCHAR(100)  NOT NULL,
                       nm VARCHAR(10) NOT NULL,
                       gender TINYINT CHECK(gender IN (1,2)) not null,
                       profileimg VARCHAR(50) ,
                       rdt DATETIME DEFAULT CURRENT_TIMESTAMP(),
                       mdt DATETIME DEFAULT CURRENT_TIMESTAMP()
);