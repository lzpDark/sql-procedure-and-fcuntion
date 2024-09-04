CREATE DATABASE IF NOT EXISTS test;
USE test;

# example 1
CREATE TABLE IF NOT EXISTS Clients (
    id int primary key,
    name varchar(20));

# procedure in example 1
DELIMITER //

CREATE PROCEDURE IF NOT EXISTS GetAllClients()
BEGIN
    SELECT * FROM Clients;
end //

# insert some data
INSERT IGNORE INTO Clients (id, name) values (1, 'client1'), (2, 'client2');

# call procedure 1
CALL GetAllClients();

# example 2
CREATE TABLE IF NOT EXISTS Customers (
    CustomerID INT PRIMARY KEY,
    FirstName VARCHAR(20),
    SecondName VARCHAR(20),
    Email VARCHAR(40));

CREATE TABLE IF NOT EXISTS Orders (
    OrderID INT PRIMARY KEY,
    CustomerID INT,
    TotalAmount DOUBLE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID));

# insert data in example 2
INSERT IGNORE INTO Customers (CustomerID, FirstName, SecondName, Email) VALUE (1, '1f', '1s','1@exmaple.com');
INSERT IGNORE INTO Customers (CustomerID, FirstName, SecondName, Email) VALUE (2, '2f', '2s','2@exmaple.com');
INSERT IGNORE INTO Customers (CustomerID, FirstName, SecondName, Email) VALUE (3, '3f', '3s','3@exmaple.com');

INSERT IGNORE INTO Orders (OrderID, CustomerID, TotalAmount) VALUE (1, 1, 10.2);
INSERT IGNORE INTO Orders (OrderID, CustomerID, TotalAmount) VALUE (2, 1, 10.3);
INSERT IGNORE INTO Orders (OrderID, CustomerID, TotalAmount) VALUE (3, 2, 20.5);
INSERT IGNORE INTO Orders (OrderID, CustomerID, TotalAmount) VALUE (4, 3, 40.8);

# function in example 2
DELIMITER //

CREATE FUNCTION IF NOT EXISTS GetTotalRevenue()
RETURNS DECIMAL(10, 2)
DETERMINISTIC
BEGIN
    RETURN (SELECT SUM(TotalAmount) FROM Orders);
end //

# invoke function
SELECT GetTotalRevenue();

# procedure in example 2
DELIMITER //

CREATE PROCEDURE IF NOT EXISTS GEtCustomerOrderDetails (
    IN customer_id INT,
    OUT customer_name VARCHAR(50),
    OUT total_orders INT,
    OUT total_spent DECIMAL(10, 2))
BEGIN
    SELECT CONCAT(Customers.FirstName, Customers.SecondName) INTO customer_name
    FROM Customers
    WHERE CustomerID = customer_id;

    SELECT COUNT(*) INTO total_orders
    FROM Orders
    WHERE CustomerID = customer_id;

    SELECT SUM(Orders.TotalAmount) INTO total_spent
    FROM Orders
    WHERE CustomerID = customer_id;
end //

# call procedure in example 2
CALL GetCustomerOrderDetails(1, @name, @order_count, @total_spent);
SELECT @name, @order_count, @total_spent;
