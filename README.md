# Ecommerce-API

Java RESTful API criada para a Testar os conhecimentos aprendidos no Decola Tech 2025, como base do projeto utilizei o repositório:
### [digitalinnovationone/santander-dev-week-2023-api](https://github.com/digitalinnovationone/santander-dev-week-2023-api)

Fiz algumas alterções, como mudar as camdadas de negocio para um pequeno E-commerce, fazendo a crianção so de cadastro de produtos.

## Principais Tecnologias
 - **Java 21**: Utilizaremos a versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
 - **Spring Boot 3**: Trabalharemos com a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
 - **Spring Data JPA**: Exploraremos como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
 - **OpenAPI (Swagger)**: Vamos criar uma documentação de API eficaz e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;

## Diagrama de Classes
```mermaid
classDiagram
    class Product {
        +Long id
        +String name
        +String description
        +double price
        +getId() : Long
        +getName() : String
        +getDescription() : String
        +getPrice() : double
        +setId(Long) : void
        +setName(String) : void
        +setDescription(String) : void
        +setPrice(double) : void
    }

    class ProductDTO {
        +String name
        +String description
        +double price
        +getName() : String
        +getDescription() : String
        +getPrice() : double
        +setName(String) : void
        +setDescription(String) : void
        +setPrice(double) : void
    }

    class ProductRepository {
        +List<Product> findAll()
        +Product save(Product)
        +Product findById(Long) : Optional<Product>
    }

    class ProductService {
        +ProductRepository productRepository
        +List<Product> findAll()
        +Product save(Product product)
        +Product findById(Long id)
    }

    class ProductController {
        +ProductService productService
        +List<Product> getAllProducts()
        +Product createProduct(Product product)
        +Product getProductById(Long id)
    }

    ProductController --> ProductService : Uses
    ProductService --> ProductRepository : Uses
    ProductController --> Product : Returns
    ProductService --> Product : Returns
    ProductDTO --> Product : Maps to
    Product --> ProductDTO : Maps from
```
