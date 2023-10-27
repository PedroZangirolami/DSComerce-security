# Projeto DSComerce

Projeto criado com Java e Spring Boot é o backend de uma aplicação de negocio estruturado e foi adicionado segurança ao projeto adicionando um login com web token JWT 
e controle de acesso baseado em permissões de acordo com o perfil de cada usuário utilizando o spring security.

## Funcionalidades:

Autenticação:
|Metodo http|EndPoints|Descrição|
|---|---|---|
|POST|/oauth2/token|Executa o login e retorna o token do usuário|

Usuário:
|Metodo http|EndPoints|Descrição|
|---|---|---|
|GET|/users/me|Retorna o usuário logado|

Produtos:
|Metodo http|EndPoints|Descrição|
|---|---|---|
|GET|/products/:id|Retorna um produto pelo id|
|GET|/products?size=12&page=0&sort=name&name=|Faz um busca paginada de todos os produtos|
|POST|/products|Insere um produto|
|PUT|/products/:id|Atualiza informações de um produtto|
|DELETE|/products/:id|Exclui um produto pelo id|

Categorias:
|Metodo http|EndPoints|Descrição|
|---|---|---|
|GET|/categories|Retorna todas as categorias de produtos|

Pedidos:
|Metodo http|EndPoints|Descrição|
|---|---|---|
|GET|/orders/:id|Retorna um pedido pelo id|
|POST|/orders|Insere um novo pedido|
