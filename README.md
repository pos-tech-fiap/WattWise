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
    * Aceita um JSON com as seguintes informações:
    * ```json
      {
      "street": "string", //OBRIGATÓRIO 
      "number": Integer, //OBRIGATÓRIO
      "complement": "string",
      "neighborhood": "string",
      "city": "string", //OBRIGATÓRIO
      "state": "string", //OBRIGATÓRIO
      "zipcode": Integer //OBRIGATÓRIO
      }
      ```

* **PUT** `/addresses/{id}`
    * Edita um endereço
    * Aceita um JSON com as seguintes informações:
  * ```json
      {
      "street": "string", //OBRIGATÓRIO
      "number": Integer, //OBRIGATÓRIO
      "complement": "string", 
      "neighborhood": "string", 
      "city": "string", //OBRIGATÓRIO
      "state": "string", //OBRIGATÓRIO
      "zipcode": Integer //OBRIGATÓRIO
      }
      ```
* **DELETE** `/addresses/{id}`
    *  Exclui um endereço