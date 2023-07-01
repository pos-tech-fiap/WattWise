# WattWise
Project to energy save

## API para cadastro de endereços
Permite ao usuário gerenciar os dados de endereços do sistema WattWise.

## Endpoints:

**TODOS os IDs usados são do tipo UUID**
* **GET** `/addresses/{id}`
    * Busca um endereço por id
*  **GET** `/addresses`
    * Busca todos as endereços cadastradas
* **POST** `/addresses`
    * Cria um novo endereço
    * Aceita um JSON com as seguintes informações.
    * Os campos com * são **obrigatórios**.
    * ```json
      {
      "street"*: "string", 
      "number"*: Integer,
      "complement": "string",
      "neighborhood": "string",
      "city"*: "string"
      "state"*: "string"
      "zipcode"*: Integer
      }
      ```

* **PUT** `/addresses/{id}`
    * Edita um endereço
    * Aceita um JSON com as seguintes informações.
    * Os campos com * são **obrigatórios**.
  * ```json
      {
      "street"*: "string", 
      "number"*: Integer,
      "complement": "string",
      "neighborhood": "string",
      "city"*: "string"
      "state"*: "string"
      "zipcode"*: Integer
      }
      ```
* **DELETE** `/addresses/{id}`
    *  Exclui um endereço