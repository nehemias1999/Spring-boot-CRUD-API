# Spring-boot-CRUD-API
Spring boot API to perform CRUD operations on products.

---
## HOW TO USE

### GET ALL

Request: <br>
URI: /products/getAll?[page=pageNumber&size=sizeNumber&sort=fieldName,order] <br>
HTTP Verb: GET <br>
Body: None <br>

Response: <br>
HTTP Status: <br>
200 OK if the products were successfully retrieved <br>
404 NOT FOUND if the products list cannot be found, or it's empty <br>
Response Body Type: JSON <br>
Example Response Body: <br>
    [
        {
        "id":1,
        "name":"pencil",
        "description":"black pencil",
        "stock":10,
        "base_price":200.0,
        "cost_price":150.0
        },
        {
        "id":3,
        "name":"rubber",
        "description":"rubber",
        "stock":50,
        "base_price":300.0,
        "cost_price":200.0
        }
    ]

---

### GET

Request: <br>
URI: /products/get/{id} <br>
HTTP Verb: GET <br>
Body: None <br>

Response: <br>
HTTP Status: <br>
200 OK if the product was successfully retrieved <br>
404 NOT FOUND if the product cannot be found <br>
Response Body Type: JSON <br>
Example Response Body: <br>
    {
        "id":1,
        "name":"pencil",
        "description":"black pencil",
        "stock":10,
        "base_price":200.0,
        "cost_price":150.0
    }

---

### CREATE

Request: <br>
URI: /products/create <br>
HTTP Verb: POST <br>
Body: <br>
    {
        "name":"pencil",
        "description":"black pencil",
        "stock":10,
        "base_price":200.0,
        "cost_price":150.0
    }

() "id" field is created by the database. <br>
() "name" field receive a not null string value between 1 and 255 length. <br>
() "description" field receive a not null string value between 1 and 255 length. <br>
() "stock" field receive a not null integer value larger than 0. <br>
() "base_price" field receive a not null double value larger than 0. <br>
() "cost_price" field receive a not null double value larger than 0. <br>

Response: <br>
HTTP Status: <br>
201 CREATED if the product was successfully retrieved <br>
400 BAD REQUEST if any value in an input field is invalid <br>
Response Body Type: JSON <br>
Example Response Body: <br>
    {
        "id":1,
        "name":"pencil",
        "description":"black pencil",
        "stock":10,
        "base_price":200.0,
        "cost_price":150.0
    }

--- 

### UPDATE

Request: <br>
URI: /products/update/{id} <br>
HTTP Verb: PUT <br>
Body: <br>
    {
        "name":"new pencil",
        "description":"blue pencil",
        "stock":20,
        "base_price":200.0,
        "cost_price":150.0
    }

Response: <br>
HTTP Status: <br>
200 OK if the product was successfully updated <br>
400 BAD REQUEST if any value in an input field is invalid <br>
404 NOT FOUND if the product cannot be found <br>
Response Body Type: JSON <br>
Example Response Body: <br>
    {
        "id":1,
        "name":"new pencil",
        "description":"blue pencil",
        "stock":20,
        "base_price":200.0,
        "cost_price":150.0
    }

---

### DELETE

Request: <br>
URI: /products/delete/{id} <br>
HTTP Verb: DELETE <br>
Body: <br>

Response: <br>
HTTP Status: <br>
204 NO CONTENT if the product was successfully deleted <br>
204 NOT FOUND if the product cannot be found <br>
Response Body Type: JSON <br>
Example Response Body: <br>

---