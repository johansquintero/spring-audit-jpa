USE jpa_audit_db;
CREATE TABLE history(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    operation VARCHAR(255),
    user VARCHAR(255),
    date_event TIMESTAMP
);