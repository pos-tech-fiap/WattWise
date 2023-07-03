# WattWise
Project to energy save

## API para o cadastro de pessoas

**TODOS os IDs usados são do tipo UUID**

Endpoints:

* **GET** `/person/{id}`
    * Busca uma pessoa por id
*  **GET** `/person`
    * Busca todas as pessoas cadastradas
* **POST** `/person`
    * Cria uma pessoa
    * Aceita um JSON com as seguintes informações:
        * `String name` - nome da pessoa **Obrigatório**
        * `Date brithDate`  - data de nascimento **Obrigatório**
        * `String email` - email **Obrigatório**
        * `Number phone` - telefone
        * `String gender` - gênero da pessoa
        * `String kinship` - parentesco
            * Valores aceitos: `RELATIVE`, `FRIEND` e `TENANT` - parente, amigo e inquilino respectivamente
* **PUT** `/person/{id}`
    * Edita uma pessoa
    * Aceita um JSON com as seguintes informações:
        * `String name` - nome da pessoa **Obrigatório**
        * `Date brithDate`  - data de nascimento **Obrigatório**
        * `String email` - email **Obrigatório**
        * `Number phone` - telefone
        * `String gender` - gênero da pessoa
        * `String kinship` - parentesco
            * Valores aceitos: `RELATIVE`, `FRIEND` e `TENANT` - parente, amigo e inquilino respectivamente
* **DELETE** `/person/{id}`
    *  Excluí uma pessoa