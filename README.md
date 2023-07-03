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
    * Exclui um endereço

## API para o cadastro de eletrodomesticos
**TODOS os IDs usados são do tipo UUID**
Endpoints:

* **GET** `/electronic/{id}`
    * Busca um eletrodomestico por id
*  **GET** `/electronic`
    * Busca todos as eletrotomesticos cadastradas
* **POST** `/electronic`
    * Cria um novo eletrodomestico
    * Aceita um JSON com as seguintes informações:
        * `String name` - nome do equipamento **Obrigatório**
        * `String model` - modelo do equipamento **Obrigatório**
        * `String power` - potência do equipamento  **Obrigatório**
* **PUT** `/electronic/{id}`
    * Edita um eletrodomestico
    * Aceita um JSON com as seguintes informações:
        * `String name` - nome do equipamento **Obrigatório**
        * `String model` - modelo do equipamento **Obrigatório**
        * `String power` - potência do equipamento  **Obrigatório**
* **DELETE** `/electronic/{id}`
    *  Excluí um eletrodomestico

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

API para o cadastro de eletrodomesticos
**TODOS os IDs usados são do tipo UUID**
Endpoints:

* **GET** `/electronic/{id}`
    * Busca um eletrodomestico por id
*  **GET** `/electronic`
    * Busca todos as eletrotomesticos cadastradas
* **POST** `/electronic`
    * Cria um novo eletrodomestico
    * Aceita um JSON com as seguintes informações:
        * `String name` - nome do equipamento **Obrigatório**
        * `String model` - modelo do equipamento **Obrigatório**
        * `String power` - potência do equipamento  **Obrigatório**
* **PUT** `/electronic/{id}`
    * Edita um eletrodomestico
    * Aceita um JSON com as seguintes informações:
        * `String name` - nome do equipamento **Obrigatório**
        * `String model` - modelo do equipamento **Obrigatório**
        * `String power` - potência do equipamento  **Obrigatório**
* **DELETE** `/electronic/{id}`
    *  Excluí um eletrodomestico