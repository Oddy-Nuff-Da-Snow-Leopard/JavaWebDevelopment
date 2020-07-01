USE master;

DROP DATABASE Appetizer;
CREATE DATABASE Appetizer;

USE Appetizer;

DROP TABLE Roles;
DROP TABLE Users;
DROP TABLE UsersData;
DROP TABLE Tokens;

DROP TABLE DishesCategories;
DROP TABLE Dishes;

DROP TABLE UsersCarts;
DROP TABLE CartItems;
DROP TABLE OrderStatus;
DROP TABLE Orders;


CREATE TABLE Roles(
	[roleId] int IDENTITY(1, 1) PRIMARY KEY,
	[role] varchar(8)
);
INSERT INTO Roles VALUES ('admin'), ('customer'), ('manager');

CREATE TABLE Users(
	[userId] int IDENTITY(1, 1) PRIMARY KEY,
	[email] varchar(64) NOT NULL,
	[password] nvarchar(16) NOT NULL,
	[roleId] int NOT NULL DEFAULT 2 FOREIGN KEY REFERENCES Roles(roleId),
	[isEnabled] binary(1) NOT NULL DEFAULT 0
);

CREATE TABLE Tokens(
	[tokenId] int IDENTITY(1, 1) PRIMARY KEY,
	[hash] varchar(32) NOT NULL,
	[creationDate] datetime NOT NULL,
	[userId] int NOT NULL FOREIGN KEY REFERENCES Users(userId)
);
SELECT * FROM Tokens;

UPDATE USERS SET roleId = 1 WHERE userId = 2;

CREATE TABLE UsersData(
	[userId] int IDENTITY(1, 1) PRIMARY KEY FOREIGN KEY REFERENCES Users(userId),
	[firstName] varchar(20) NOT NULL,
	[lastName] varchar(25) NOT NULL,
	[gender] varchar(6) NOT NULL,
	[username] varchar(20) NOT NULL,
	[phoneNumber] varchar(19) NOT NULL
);


CREATE TABLE DishesCategories(
	[categoryId] int IDENTITY(1, 1) PRIMARY KEY,
	[category] varchar(30) NOT NULL
);
INSERT INTO DishesCategories VALUES
 ('salads'), ('beverages'), ('shit');


CREATE TABLE Dishes(
	[dishId] int IDENTITY(1, 1) PRIMARY KEY,
	[categoryId] int NOT NULL FOREIGN KEY REFERENCES DishesCategories(categoryId),
	[name] varchar(30) NOT NULL,
	[description] varchar(50) NOT NULL,
	[price] decimal(5, 2) NOT NULL,
	[imagePath] varchar(max) NULL
);

INSERT INTO Dishes VALUES
(1, 'Grilled Beef with potatoes', 'Meat1, Potatoes, Rice, Tomatoe', 20, 'resources/images/chef-1.jpg'),
(2, 'Grilled Beef with potatoes', 'Meat1, Potatoes, Rice, Tomatoe', 20, 'resources/images/chef-1.jpg'),
(3, 'Grilled Beef with potatoes', 'Meat1, Potatoes, Rice, Tomatoe', 20, 'resources/images/chef-1.jpg'),
(3, 'Grilled Beef with potatoes', 'Meat3, Potatoes, Rice, Tomatoe', 22, 'resources/images/chef-1.jpg'),
(2, 'Grilled Beef with potatoes', 'Meat3, Potatoes, Rice, Tomatoe', 22, 'resources/images/chef-1.jpg'),
(1, 'Grilled Beef with potatoes', 'Meat3, Potatoes, Rice, Tomatoe', 22, 'resources/images/chef-1.jpg'),
(1, 'Grilled Beef with potatoes', 'Meat3, Potatoes, Rice, Tomatoe', 22, 'resources/images/chef-1.jpg'),
(1, 'Grilled Beef with potatoes', 'Meat3, Potatoes, Rice, Tomatoe', 22, 'resources/images/chef-1.jpg'),
(3, 'Grilled Beef with potatoes', 'Meat3, Potatoes, Rice, Tomatoe', 22, 'resources/images/chef-1.jpg');


CREATE TABLE UsersCarts(
	[userCartId] int IDENTITY(1, 1) PRIMARY KEY,
	[userId] int NOT NULL FOREIGN KEY REFERENCES Users(userId)
);

CREATE TABLE CartItems(
	[cartItemId] int IDENTITY(1, 1) PRIMARY KEY,
	[userCartId] int NOT NULL,
	[dishId] int NOT NULL FOREIGN KEY REFERENCES Dishes(dishId),
	[quantity] int NOT NULL DEFAULT '1'
);

CREATE TABLE OrderStatus(
	[statusId] int IDENTITY(1, 1) PRIMARY KEY,
	[status] varchar(30) NOT NULL
);
INSERT INTO OrderStatus VALUES ('pending'), ('awaiting payment'), ('cancelled'), ('paid'), ('issued');

CREATE TABLE Orders(
	[orderId] int IDENTITY(1, 1) PRIMARY KEY,
	[userCartId] int NOT NULL FOREIGN KEY REFERENCES UsersCarts(userCartId),
	[statusId] int NOT NULL DEFAULT '1' FOREIGN KEY REFERENCES OrderStatus(statusId),
	[totalPrice] decimal(6, 2) NOT NULL,
	[creationDate] datetime NOT NULL,
	[comment] varchar(max) NULL
);