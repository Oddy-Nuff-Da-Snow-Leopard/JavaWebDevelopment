DROP TABLE Orders;
DROP TABLE OrderStatus;
DROP TABLE CartItems;
DROP TABLE UsersCarts;

DROP TABLE Dishes;
DROP TABLE DishesCategories;

DROP TABLE Tokens;
DROP TABLE UsersData;
DROP TABLE Users;
DROP TABLE Roles;


CREATE TABLE Roles(
	roleId int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	role nvarchar2(8)
);
INSERT INTO Roles(role) VALUES ('admin');
INSERT INTO Roles(role) VALUES ('customer');
INSERT INTO Roles(role) VALUES ('manager');

CREATE TABLE Users(
	userId int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	email nvarchar2(64) NOT NULL,
	password nvarchar2(16) NOT NULL,
	roleId int DEFAULT 2 NOT NULL,
	isEnabled int DEFAULT 0 NOT NULL,
    FOREIGN KEY (roleId) REFERENCES Roles(roleId)
);

UPDATE USERS SET roleId = 1 WHERE userId = 1;
COMMIT;

CREATE TABLE Tokens(
	tokenId int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	hash nvarchar2(32) NOT NULL,
	creationDate date NOT NULL,
	userId int NOT NULL,
    FOREIGN KEY (userId) REFERENCES Users(userId)
);

CREATE TABLE UsersData(
	userId int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	firstName nvarchar2(20) NOT NULL,
	lastName nvarchar2(25) NOT NULL,
	gender nvarchar2(6) NOT NULL,
	username nvarchar2(20) NOT NULL,
	phoneNumber nvarchar2(19) NOT NULL,
    FOREIGN KEY (userId) REFERENCES Users(userId)
);

CREATE TABLE DishesCategories(
	categoryId int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	category nvarchar2(30) NOT NULL
);
INSERT INTO DishesCategories(category) VALUES ('Breakfast');
INSERT INTO DishesCategories(category) VALUES ('Dinner');
INSERT INTO DishesCategories(category) VALUES ('Lunch');
INSERT INTO DishesCategories(category) VALUES ('Dessert');
INSERT INTO DishesCategories(category) VALUES ('Wine');

CREATE TABLE Dishes(
	dishId int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	categoryId int NOT NULL,
	name nvarchar2(30) NOT NULL,
	description nvarchar2(50) NOT NULL,
	price decimal(5, 2) NOT NULL,
	imagePath nvarchar2(1024) NULL,
    FOREIGN KEY (categoryId) REFERENCES DishesCategories(categoryId)
);

INSERT INTO Dishes(categoryId, name, description, price, imagePath)
    VALUES (1, 'Some breakfast 1', 'Meat, Potatoes, Rice, Tomatoe', 10, 'resources/images/dishes/breakfast-1.jpg');
INSERT INTO Dishes(categoryId, name, description, price, imagePath)
    VALUES (1, 'Some breakfast 2', 'Meat, Potatoes, Rice, Tomatoe', 13, 'resources/images/dishes/breakfast-2.jpg');
INSERT INTO Dishes(categoryId, name, description, price, imagePath)
    VALUES (1, 'Some breakfast 3', 'Meat, Potatoes, Rice, Tomatoe', 17, 'resources/images/dishes/breakfast-3.jpg');
    
INSERT INTO Dishes(categoryId, name, description, price, imagePath)
    VALUES (2, 'Some dinner 1', 'Meat, Potatoes, Rice, Tomatoe', 22, 'resources/images/dishes/dinner-1.jpg');
INSERT INTO Dishes(categoryId, name, description, price, imagePath)
    VALUES (2, 'Some dinner 2', 'Meat, Potatoes, Rice, Tomatoe', 25, 'resources/images/dishes/dinner-2.jpg');
INSERT INTO Dishes(categoryId, name, description, price, imagePath)
    VALUES (2, 'Some dinner 3', 'Meat, Potatoes, Rice, Tomatoe', 26, 'resources/images/dishes/dinner-3.jpg');
    
INSERT INTO Dishes(categoryId, name, description, price, imagePath)
    VALUES (3, 'Some lunch 1', 'Meat, Potatoes, Rice, Tomatoe', 24, 'resources/images/dishes/lunch-1.jpg');
INSERT INTO Dishes(categoryId, name, description, price, imagePath)
    VALUES (3, 'Some lunch 2', 'Meat, Potatoes, Rice, Tomatoe', 23, 'resources/images/dishes/lunch-2.jpg');
INSERT INTO Dishes(categoryId, name, description, price, imagePath)
    VALUES (3, 'Some lunch 3', 'Meat, Potatoes, Rice, Tomatoe', 13, 'resources/images/dishes/lunch-3.jpg');
    
INSERT INTO Dishes(categoryId, name, description, price, imagePath)
    VALUES (4, 'Some dessert 1', 'Meat, Potatoes, Rice, Tomatoe', 14, 'resources/images/dishes/dessert-1.jpg');
INSERT INTO Dishes(categoryId, name, description, price, imagePath)
    VALUES (4, 'Some dessert 2', 'Meat, Potatoes, Rice, Tomatoe', 12, 'resources/images/dishes/dessert-2.jpg');
INSERT INTO Dishes(categoryId, name, description, price, imagePath)
    VALUES (4, 'Some dessert 3', 'Meat, Potatoes, Rice, Tomatoe', 17, 'resources/images/dishes/dessert-3.jpg');
    
INSERT INTO Dishes(categoryId, name, description, price, imagePath)
    VALUES (5, 'Some wine 1', 'Meat, Potatoes, Rice, Tomatoe', 45, 'resources/images/dishes/wine-1.jpg');
INSERT INTO Dishes(categoryId, name, description, price, imagePath)
    VALUES (5, 'Some wine 2', 'Meat, Potatoes, Rice, Tomatoe', 32, 'resources/images/dishes/wine-2.jpg');
INSERT INTO Dishes(categoryId, name, description, price, imagePath)
    VALUES (5, 'Some wine 3', 'Meat, Potatoes, Rice, Tomatoe', 19, 'resources/images/dishes/wine-3.jpg');


CREATE TABLE UsersCarts(
	userCartId int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	userId int NOT NULL,
    FOREIGN KEY (userId) REFERENCES Users(userId)
);

CREATE TABLE CartItems(
	cartItemId int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	userCartId int NOT NULL,
	dishId int NOT NULL,
	quantity int DEFAULT 1 NOT NULL,
    FOREIGN KEY (dishId) REFERENCES Dishes(dishId)
);

CREATE TABLE OrderStatus(
	statusId int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	status nvarchar2(30) NOT NULL
);
INSERT INTO OrderStatus(status) VALUES ('pending'); 
INSERT INTO OrderStatus(status) VALUES ('awaiting payment'); 
INSERT INTO OrderStatus(status) VALUES ('cancelled'); 
INSERT INTO OrderStatus(status) VALUES ('paid'); 
INSERT INTO OrderStatus(status) VALUES ('issued');

CREATE TABLE Orders(
	orderId int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	userCartId int NOT NULL ,
	statusId int DEFAULT 1 NOT NULL,
	totalPrice decimal(6, 2) NOT NULL,
	creationDate date NOT NULL,
	commentary nvarchar2(1024) NULL,
    FOREIGN KEY (userCartId) REFERENCES UsersCarts(userCartId),
    FOREIGN KEY (statusId) REFERENCES OrderStatus(statusId)
);

CREATE OR REPLACE PROCEDURE insert_user(
    in_email IN Users.email%TYPE,
    in_password IN Users.password%TYPE,
    out_inserted_row_id OUT int) AS
BEGIN
    INSERT INTO Users (email, password)
        VALUES(in_email, in_password) RETURNING userId INTO out_inserted_row_id;
END;

CREATE OR REPLACE PROCEDURE insert_user_data(
    firstName_ IN UsersData.firstName%TYPE,
    lastName_ IN UsersData.lastName%TYPE,
    gender_ IN UsersData.gender%TYPE,
    username_ IN UsersData.username%TYPE,
    phoneNumber_ IN UsersData.phoneNumber%TYPE) AS
BEGIN
    INSERT INTO UsersData(firstName, lastName, gender, username, phoneNumber)
        VALUES(firstName_, lastName_, gender_, username_, phoneNumber_);
END;

CREATE OR REPLACE PROCEDURE insert_user_cart(
    in_userId IN Users.userId%TYPE,
    out_inserted_row_id OUT int) AS
BEGIN
    INSERT INTO UsersCarts (userId)
        VALUES(in_userId) RETURNING userCartId INTO out_inserted_row_id;
END;

CREATE OR REPLACE PROCEDURE select_user_id_by_email(
    in_email IN Users.email%TYPE,
    out_userId OUT Users.userId%TYPE) AS
BEGIN
    SELECT userId INTO out_userId FROM Users WHERE email = in_email;
    EXCEPTION 
        WHEN OTHERS THEN out_userId := 0;
END;

CREATE OR REPLACE PROCEDURE insert_cart_item(
    in_userCartId IN CartItems.userCartId%TYPE,
    in_dishId IN CartItems.dishId%TYPE) AS
BEGIN
    INSERT INTO CartItems(userCartId, dishId)
        VALUES (in_userCartId, in_dishId);
END;

SELECT * FROM CartItems;

CREATE OR REPLACE PROCEDURE delete_cart_item_by_cart_item_id(
    in_cartItemId IN CartItems.cartItemId%TYPE) AS
BEGIN
    DELETE FROM CartItems WHERE cartItemId = in_cartItemId;
END;

CREATE OR REPLACE PROCEDURE insert_order(
    in_userCartId IN Orders.userCartId%TYPE,
    in_totalPrice IN Orders.totalPrice%TYPE,
    in_creationDate IN Orders.creationDate%TYPE) AS
BEGIN
    INSERT INTO Orders (userCartId, totalPrice, creationDate)
        VALUES(in_userCartId, in_totalPrice, in_creationDate);
END;

CREATE OR REPLACE PROCEDURE DELETE_USER_DATA(
    in_orderId IN Orders.orderId%TYPE,
    in_commentary IN Orders.commentary%TYPE) AS
BEGIN
    UPDATE Orders SET statusId = 2,
        commentary = in_commentary WHERE orderId = in_orderId;
END;


CREATE OR REPLACE PROCEDURE INSERT_DISH(
    in_orderId IN Orders.orderId%TYPE,
    in_commentary IN Orders.commentary%TYPE) AS
BEGIN
    UPDATE Orders SET statusId = 2,
        commentary = in_commentary WHERE orderId = in_orderId;
END;


CREATE OR REPLACE PROCEDURE UPDATE_ORDER_SET_STATUS_AWAITING_PAYMENT(
    in_orderId IN Orders.orderId%TYPE,
    in_commentary IN Orders.commentary%TYPE) AS
BEGIN
    UPDATE Orders SET statusId = 2,
        commentary = in_commentary WHERE orderId = in_orderId;
END;

CREATE OR REPLACE PROCEDURE UPDATE_ORDER_SET_STATUS_CANCELLED(
    in_orderId IN Orders.orderId%TYPE,
    in_commentary IN Orders.commentary%TYPE) AS
BEGIN
    UPDATE Orders SET statusId = 3,
        commentary = in_commentary WHERE orderId = in_orderId;
END;

CREATE INDEX usersData_index ON UsersData(lastName);

SELECT * FROM Users u1 INNER JOIN UsersData u2
ON u1.userId = u2.userId WHERE lastName = 'Alekseev';


DECLARE i int := 100;
BEGIN
    WHILE i < 10100 LOOP
        i := i - 1;
        INSERT INTO CartItems(userCartId, dishId, quantity)
            VALUES(i, 1, i);
    END LOOP;
END;

CREATE INDEX cartItems_index ON CartItems(quantity);
