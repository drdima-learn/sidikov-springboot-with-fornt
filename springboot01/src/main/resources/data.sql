DELETE FROM USERS;
ALTER SEQUENCE global_seq RESTART WITH 100000;


/*INSERT INTO users (id, first_name, last_name, login, password, role, state)
          VALUES (100000,'vasilii', 'pupkin', 'vasya', '1234', 'USER', 'ACTIVE');

INSERT INTO users (id, first_name, last_name, login, password, role, state)
VALUES (100001,'masha', 'rasputina', 'masha', '1234', 'USER', 'ACTIVE');

INSERT INTO users (id, first_name, last_name, login, password, role, state)
VALUES (100002,'petya', 'petrov', 'petya', '1234', 'USER', 'ACTIVE');*/



INSERT INTO users (first_name, last_name, login, password, role, state)
VALUES ('vasilii', 'pupkin', 'vasya', '{noop}1234', 'USER', 'ACTIVE');

INSERT INTO users (first_name, last_name, login, password, role, state)
VALUES ('masha', 'rasputina', 'masha', '{noop}1234', 'ADMIN', 'ACTIVE');

INSERT INTO users (first_name, last_name, login, password, role, state)
VALUES ('petya', 'petrov', 'petya', '{noop}1234', 'USER', 'ACTIVE');


