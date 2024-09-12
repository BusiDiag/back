-- Categories for Diagnosis score is temporary

CREATE TABLE Users (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       username VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role ENUM('admin', 'user') NOT NULL
);

CREATE TABLE Businesses (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            owner_id INT,
                            type ENUM('public', 'private') NOT NULL,
                            size VARCHAR(255),
                            status ENUM('active', 'inactive') NOT NULL,
                            date DATE,
                            FOREIGN KEY (owner_id) REFERENCES Users(id)
);

CREATE TABLE Questions (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           category ENUM('cat1', 'cat2', 'cat3', 'cat4') NOT NULL,
                           importance INT CHECK (importance BETWEEN 1 AND 5),
                           question_text TEXT NOT NULL
);

CREATE TABLE Diagnosis (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           business_id INT,
                           date DATE NOT NULL,
                           score_cat1 FLOAT DEFAULT 0,  -- Final score for category 1
                           score_cat2 FLOAT DEFAULT 0,  -- Final score for category 2
                           score_cat3 FLOAT DEFAULT 0,  -- Final score for category 3
                           score_cat4 FLOAT DEFAULT 0,  -- Final score for category 4
                           recommendations TEXT,
                           FOREIGN KEY (business_id) REFERENCES Businesses(id)
);

CREATE TABLE Responses (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           diagnosis_id INT,
                           question_id INT,
                           category ENUM('cat1', 'cat2', 'cat3', 'cat4') NOT NULL,
                           importance INT,
                           user_score INT CHECK (user_score BETWEEN 1 AND 5),
                           weighted_score FLOAT,
                           FOREIGN KEY (diagnosis_id) REFERENCES Diagnosis(id),
                           FOREIGN KEY (question_id) REFERENCES Questions(id)
);