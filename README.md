# OnlineMarket
SEF project

Link to Jira: https://jpanda.atlassian.net/secure/RapidBoard.jspa?rapidView=2&projectKey=OM&view=planning&selectedIssue=OM-1&issueLimit=100&atlOrigin=eyJpIjoiYzYwMzcxYTJjYWMyNDJjM2E3MWY5YWIzYTRjMGJmMDgiLCJwIjoiaiJ9

## Online Market
### Specification draft:

Team Members: Alexandra-Doris Ciorba, Paula-Christine Ciorba

### General Description:
The app intends to replace the classic market, bringing together local farmers with quality products and customers who are looking for local healthy food.

Admin --- includes ---> Farmer --- includes ---> Customer

#### Registration (for Customer and Farmer):
The user needs to first register into the application by selecting one of the 2 roles: farmer or user. Both roles require a unique username, a password and the basic information like full name, address and phone number. A default administrator already exits (user: admin/ pass: admin) – created by developer.

#### Login (for Customer, Farmer and Admin):
If the account was previous created by registering, the user can login. If the login is successful – username and password match with an account stored in the database, the users will be redirected to the product catalog. If the login is unsuccessful the person will be prompted to try again.

#### Browse products (for Customer, Farmer and Admin)
After login all the user are redirected to the product catalog. There all the products are displayed with a title, a short description and a thumbnail. By clicking on a product, they are sent to the product page. Through a drop-down the user filters the products by category (produce, meat, dairy, pantry and bakery).

#### View product and order (for Customer, Farmer and Admin)
Each product page has a title, description and a representative image. After selecting the desired quantity (by default 1, <= than stock) they can click “Order”. The order will be shown on the “My orders” page of the buyer (customer/farmer/admin) as well as of the seller (farmer/admin).

#### Manage products (for Farmer and Admin)
Where he can see his products add products and add new ones.

#### Manage orders (for Customer, Farmer and Admin)
On the “My orders” page all the orders placed by the user are listed with title, quantity, price and delivery specification. An order can have three statuses: pending, complete and canceled. The buyer (customer/farmer/admin) can only cancel an order. The seller (farmer/admin) can cancel an order if he cannot fulfill it or mark it as complete.

#### Customer
After login the customer is sent to “Product page”. Where he can browse products and place orders. On “My orders” page he sees the status of his orders (pending, complete or canceled) and he can cancel them if current status is pending.

#### Farmer
The farmer has all the capabilities of a user plus he can add and manage his products. In his account he has access to a “My products” page where all his existing products are listed. He can add new products. For a new product basic information is required: title, description, category, an image, existing stock and price per item.

On the “My orders” for the order for which he has the role of a seller he can change its status from pending to complete or canceled.

The transportation and payment method will be handled outside the system by the seller.

#### Administrator
The admin has all the capabilities of a farmer plus he can manage all existing users. In his account he has a “User page” where all the users are listed. He can change the type of a user (to Customer, Farmer or Administrator) or remove an account (this action is irreversible, after delete all data of that user will be lost).
