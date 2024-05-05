# E-Commerce-Tivonte-Brown

This is a project for the back-end of an e-commerce app

Tech Stack:
Postman to send HTTP Requests using JSON objects
Javalin broadcasting on http://localhost:7070/
Maven to organize Java project and software
JDBC connects to database
SQL to manipulate database
Dbeaver to access database
Docker to host PostgreSQL server

App allows you to register and login users

Add products to your cart
Look at cart
Delete items from your cart
Checkout
And view your personal order history

Admins can also:
Create new products
Update existing products
Delete products
View all order history

App requires a resources folder in \E-Commerce App\src\main with a application.properties file to run. Application.properties file requires (without quotation marks):

url=”insert postgresql server here”
username=”insert server username”
password=”insert password here”

secret=”insert 256 bit secret key”