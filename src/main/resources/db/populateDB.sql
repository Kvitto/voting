DELETE FROM roles;
DELETE FROM meals;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, phone, password) VALUES
  ('User', 'user@yandex.ru', 89201452365, 'password'),
  ('Admin', 'admin@gmail.com', 89654123789, 'admin');

INSERT INTO restaurants (name, email, phone) VALUES
  ('Grand', 'grand@yandex.ru', 5557555),
  ('Cardinal', 'cardinal@gmail.com', 5555777);

INSERT INTO roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (restaurant_id, description, price)
VALUES (100002, 'Steak', 10.00),
       (100002, 'Potato', 3.00),
       (100002, 'Salad', 4.50),
       (100002, 'Cafe', 2.50),
       (100003, 'Beef', 11.00),
       (100003, 'Asparagus', 2.50),
       (100003, 'Salad', 5.00),
       (100003, 'Cafe', 2.00);

INSERT INTO votes (user_id, restaurant_id)
VALUES (100000, 100002);
