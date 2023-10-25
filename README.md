# workshop-springboot3-jpa
Workshop Application
Este é um projeto Java Spring Boot que demonstra uma aplicação de exemplo com entidades como Categoria, Pedido, Produto e Usuário.

Pré-requisitos
Java JDK 17
Spring Boot
Maven
Banco de dados MySQL

Configuração
Clone este repositório em sua máquina local:

bash
Copy code
git clone https://github.com/seu-usuario/workshop.git
Importe o projeto em sua IDE de desenvolvimento (como o IntelliJ IDEA ou Eclipse).

Configure as propriedades do banco de dados em src/main/resources/application.properties. Você precisará definir spring.datasource.url, spring.datasource.username e spring.datasource.password.

O arquivo application.properties é um arquivo de propriedades comuns usado em aplicativos Spring Boot para configurar várias partes do aplicativo, como banco de dados, servidor web, segurança, etc. Você pode definir as propriedades no formato chave=valor.

Aqui está um exemplo de um arquivo application.properties:

properties
Copy code
# Configuração do servidor web
server.port=8080
server.servlet.context-path=/myapp

# Configuração do banco de dados
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=myuser
spring.datasource.password=mypassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
Neste exemplo, definimos a porta do servidor, o contexto da servlet e as informações do banco de dados.

Endpoints da API
A API possui os seguintes endpoints:

/categories: Manipula categorias.
GET /categories: Retorna a lista de categorias.
GET /categories/{id}: Retorna uma categoria com o ID especificado.
/products: Manipula produtos.
GET /products: Retorna a lista de produtos.
GET /products/{id}: Retorna um produto com o ID especificado.
/orders: Manipula pedidos.
GET /orders: Retorna a lista de pedidos.
GET /orders/{id}: Retorna um pedido com o ID especificado.
/users: Manipula usuários.
GET /users: Retorna a lista de usuários.
GET /users/{id}: Retorna um usuário com o ID especificado.
POST /users: Cria um novo usuário.
PUT /users/{id}: Atualiza um usuário existente.
DELETE /users/{id}: Exclui um usuário.
Como usar
Você pode fazer solicitações HTTP para os endpoints da API usando ferramentas como Postman ou curl. Certifique-se de configurar o método, a URL e o corpo da solicitação, conforme necessário.

Autor
Cleiton Sousa
