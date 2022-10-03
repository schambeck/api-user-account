CREATE TABLE IF NOT EXISTS user_account (
    id VARCHAR(36) PRIMARY KEY DEFAULT (uuid()),
    username VARCHAR(256) NOT NULL,
    email VARCHAR(256),
    first_name VARCHAR(256),
    last_name VARCHAR(256)
);

CREATE UNIQUE INDEX idx_user_account_username ON user_account (username);
