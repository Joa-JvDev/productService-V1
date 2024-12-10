
# Product Microservice

We created a product service to be consumed by another service for orders. For this project, best practices were followed, including global exception handling and layered architecture.


## Scheme

![App Screenshot](![1](https://github.com/user-attachments/assets/e3cc1be1-da14-49c1-85ea-2c58cfc907cb))


## EndPoints Example

#### Get all items

```http
  GET /products/all
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `null` | `List<>` | **Required**. List all products |

#### Get item

```http
  GET /products/{id}
```

| Parameter |   Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `ProductDTO` | Return a product by id |





## FAQ

#### What is the utility?

Testing for another microservice



## Author

- [@Joaquin-JvDev](https://github.com/Joa-JvDev)

