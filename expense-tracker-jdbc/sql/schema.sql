CREATE TABLE IF NOT EXISTS categories(
    category_id INTEGER PRIMARY KEY ,
    category_name VARCHAR NOT NULL UNIQUE );

CREATE TABLE IF NOT EXISTS expenses(
    expense_id  INTEGER PRIMARY KEY ,
    category_id INTEGER REFERENCES categories(category_id), -- FOREIGN KEY
    expense_amount NUMERIC(10,2) CHECK (expense_amount > 0), -- 570,47
    description VARCHAR(200)
);