# Desafio: Backend de Catálogo de Produtos de um Ecommerce

Este repositório contém a parte do Backend com Java, para o desafio para construção de um sistema de gerenciamento de catálogo de produtos em um aplicativo de ecommerce.

## Pré-requisitos

- Git
- Docker e Docker Compose instalados
- Banco de dados PostgreSQL configurado (gerenciado pelo Docker)

## Estrutura do Projeto

Este repositório é parte de uma aplicação que depende do frontend para funcionar corretamente, onde poderá ser feito o clone do mesmo no seguinte repositório: https://github.com/mhenriqueo/desafio-ecommerce-frontend. 

O `docker-compose.yml` do projeto backend ou frontend, deve ser colocado em um diretório que contenha tanto o repositório do frontend quanto o do backend.

### Passos para rodar o projeto

1. Clone ambos os repositórios do desafio ecommerce (frontend e backend) em um diretório específico na sua máquina local. O diretório do projeto pode ser algo como:

    ```bash
    /meu/projeto/
    ├── desafio-ecommerce-frontend
    └── desafio-ecommerce-backend
    ```

2. Adicione o arquivo `docker-compose.yml` no diretório raiz (onde estão os dois repositórios).

3. Navegue até o diretório onde o `docker-compose.yml` está localizado e execute o seguinte comando para construir e iniciar os containers:

    ```bash
    docker compose up --build
    ```

4. O backend estará disponível no `http://localhost:8083`. No entanto, o frontend precisa ser acessado para interagir com o backend.

### Observações

- O banco de dados PostgreSQL será iniciado automaticamente pelo Docker, com o usuário e a senha configurados no `docker-compose.yml`.
- O frontend será responsável por interagir com o backend. Para acessar o frontend, abra o navegador em `http://localhost`.
- Certifique-se de que ambos os projetos estão na mesma estrutura de diretório para que o `docker-compose.yml` funcione corretamente.

