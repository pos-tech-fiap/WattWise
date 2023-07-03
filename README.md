# WattWise
Project to energy save

---

# Documentação

## API para cadastro de endereços
Permite ao usuário gerenciar os dados de endereços do sistema WattWise.

### Endpoints:

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

## API para o cadastro de eletrodomésticos

**TODOS os IDs usados são do tipo UUID**

###Endpoints:

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

## API para o cadastro de eletrodomesticos

**TODOS os IDs usados são do tipo UUID**

### Endpoints:

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

## API para o cadastro de pessoas

**TODOS os IDs usados são do tipo UUID**

###Endpoints:

* **GET** `/person/{id}`
    * Busca uma pessoa por id
    * Exemplo de entrada: `/person/d63c6013-0fd2-4863-a2a9-023059b55906`
    * Exemplo de JSON de Saída:
        * ```JSON
          {
          "id": "d63c6013-0fd2-4863-a2a9-023059b55906",
          "name": "Roger de Águas",
          "gender": "Masculino",        
          "birthDate": "2021-11-21T00:00:00.000+00:00",
          "email": "roger.aguas@email.com",
          "phone": 47999885566,
          "kinship": "RELATIVE"
          }
          ```

* **GET** `/person`
    * Busca todas as pessoas cadastradas
    * Exemplo de JSON de Saída:
    * ```JSON
      [
        {
        "id": "d63c6013-0fd2-4863-a2a9-023059b55906",
        "name": "Roger de Águas",
        "gender": "Masculino",
        "birthDate": "2021-11-21T00:00:00.000+00:00",
        "email": "roger.aguas@email.com",
        "phone": 47999885566,
        "kinship": "RELATIVE"
        },
        {
        "id": "ba1e8bec-cea3-4ca7-a7da-9cee42b087ea",
        "name": "Davi Gilmar",
        "gender": "Masculino",
        "birthDate": "2020-10-10T00:00:00.000+00:00",
        "email": "davi.gilmar@email.com",
        "phone": 47999885566,
        "kinship": null
        }
      ]
      ```
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
    * Exemplo de JSON de Entrada:
      * ```JSON
        {
        "name": "Roger de Águas",
        "birthDate": "2021-11-21",
        "email": "roger.aguas@email.com",
        "phone": "47999885566",
        "gender": "Masculino",
        "kinship": "RELATIVE"
        }
        ```
    * Exemplo de JSON de Saída:
      * ```JSON
        {
        "id": "cd1013cc-bc61-4970-88c1-9d3f85a4b3f1",
        "name": "Roger de Águas",
        "gender": "Masculino",        
        "birthDate": "2021-11-21T00:00:00.000+00:00",
        "email": "roger.aguas@email.com",
        "phone": 47999885566,
        "kinship": "RELATIVE"
        }
        ```
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
    * Exemplo de JSON de Entrada:
      * ```JSON
        {
          "name": "Roger Waters",
          "gender": "Homem",
          "birthDate": "2021-11-21",
          "email": "roger.aguas@email.com",
          "phone": 47999885566,
          "kinship": "FRIEND"
        }
        ```
    * Exemplo de JSON de Saída:
        * ```JSON
          {
            "id": "d63c6013-0fd2-4863-a2a9-023059b55906",
            "name": "Roger Waters",
            "gender": "Homem",
            "birthDate": "2021-11-21T00:00:00.000+00:00",
            "email": "roger.aguas@email.com",
            "phone": 47999885566,
            "kinship": "FRIEND"
          }
          ```
* **DELETE** `/person/{id}`
    * Excluí uma pessoa
    * Exemplo de entrada: `/person/ba1e8bec-cea3-4ca7-a7da-9cee42b087ea`
    * Exemplo de Saída: Pessoa removida com sucesso