# Demo E-Commerce Backend (Spring Boot + MongoDB)

This is a simple backend application for an e-commerce platform built using **Spring Boot** and **MongoDB**. 
It demonstrates how to manage a product catalog, handle user information, and set up basic order handling 
(focused on the product catalog for this version).

### Features
1. Spring Boot 3.x
2. MongoDB integration
3. Product catalog CRUD (Create, Read, Update, Delete)
4. Basic structure for user and order management
5. Environment variable handling with `.env`
6. Modular and scalable codebase

### Tech Stack
- **Java 17+**
- **Spring Boot**
- **Spring Data MongoDB**
- **MongoDB Atlas or Local MongoDB**
- **Lombok**
- **Dotenv for .env support**

### Project Structure
```
src
└── main
├── java
│ └── com.example.ecommerce
│ ├── EcommerceApplication.java # Main Spring Boot class
│ ├── model
│ │ └── Product.java # Product entity
│ ├── repository
│ │ └── ProductRepository.java # MongoDB repository
│ └── controller
│ └── ProductController.java # REST controller
└── resources
└── application.properties
```

### ⚙️ Getting Started
##### 1. Clone the Repo
```bash
git clone https://github.com/Ochwada/E_Commerce-Mongodb-Springboot.git
cd E_Commerce-Mongodb-Springboot
```

##### 2.  Set Up .env
   Create a .env file in the root with your MongoDB connection string:

```ini
MONGODB_URI=mongodb+srv://<username>:<password>@cluster.mongodb.net/ecommerce?retryWrites=true&w=majority
```

### Product API Endpoints

| Method | Endpoint         | Description         |
|--------|------------------|---------------------|
| GET    | `/products`      | List all products   |
| POST   | `/products`      | Add a new product   |
| GET    | `/products/{id}` | Get product by ID   |
| PUT    | `/products/{id}` | Update a product    |
| DELETE | `/products/{id}` | Delete a product    |

#### Contributing
Feel free to fork this project and submit pull requests or issues. Collaboration is welcome!