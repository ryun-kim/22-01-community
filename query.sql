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

CREATE TABLE t_board_category(
                    icategory INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
                    nm VARCHAR(1t_user0) NOT NULL,
	                orderby TINYINT NOT NULL DEFAULT 0
);

CREATE TABLE t_board(
                        iboard INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
                        icategory INT UNSIGNED NOT NULL,
                        title VARCHAR(100) NOT NULL,
                        ctnt TEXT NOT NULL,
                        iuser INT UNSIGNED NOT NULL,
                        hits INT UNSIGNED DEFAULT 0,
                        isdel TINYINT UNSIGNED DEFAULT 0,
                        rdt DATETIME DEFAULT CURRENT_TIMESTAMP,
                        mdt DATETIME DEFAULT CURRENT_TIMESTAMP
);