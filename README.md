
# Product Microservice

We created a product service to be consumed by another service for orders. For this project, best practices were followed, including global exception handling and layered architecture.


## Scheme

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)


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

