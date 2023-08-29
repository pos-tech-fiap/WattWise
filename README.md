# WattWise
Project to energy save

---

# Documentação

## Rodar o banco de dados

Parar rodar o banco de dados, é necessário executar o Dockerfile, com os seguintes comandos:

```sql
docker build -f Dockerfile -t wattwise-local .

docker network create pg_network

docker run -d --network pg_network  -p 5432:5432 -v $(pwd):/wattwise/ wattwise-local
```

Opcional: para rodar o pgAdmin:

```sql
docker run -d --network pg_network -p 5050:5050 --name pgadmin-container -e PGADMIN_DEFAULT_EMAIL=user@example.com -e PGADMIN_DEFAULT_PASSWORD=SuperSecretPassword dpage/pgadmin4
```

## API para o cadastro de eletrodomesticos
Permite ao usuário gerenciar os cadastros de eletrodomésticos do sistema WattWise.

**TODOS os IDs usados são do tipo UUID**

### Endpoints:

* **GET** `/electronic/{id}`
    * Busca uma eletrodoméstico por id
    * Exemplo de entrada: `/electronic/d63c6013-0fd2-4863-a2a9-023059b55906`
    * Exemplo de JSON de Saída:
      * ```JSON
        {
        "id": "d63c6013-0fd2-4863-a2a9-023059b55906",
        "name": "TV",
        "model": "LG Plus",        
        "power": "100W"
        }
        ```

* **GET** `/electronic`
    * Busca todos os eletrodomésticos cadastrados
    * Exemplo de JSON de Saída:
      * ```JSON
        [
           {
           "id": "d63c6013-0fd2-4863-a2a9-023059b55906",
           "name": "TV",
           "model": "LG Plus",        
           "power": "100W"
           },
           {
           "id": "o4x87814-0yd7-4861-a5y4-0540859b50155",
           "name": "Freezer",
           "model": "Brastemp Ultra",        
           "power": "150W"
           }
        ]
         ```
* **POST** `/electronic`
    * Cria um eletrodoméstico
    * Aceita um JSON com as seguintes informações:
        * `String name` - nome do equipamento **Obrigatório**
        * `String model` - modelo do equipamento **Obrigatório**
        * `String power` - potência do equipamento  **Obrigatório**

    * Exemplo de JSON de Entrada:
      * ```JSON
        {
        "name": "TV",
        "model": "LG Plus",        
        "power": "100W"
        }
        ```
    * Exemplo de JSON de Saída:
      * ```JSON
        {
        "id": "d63c6013-0fd2-4863-a2a9-023059b55906",
        "name": "TV",
        "model": "LG Plus",        
        "power": "100W"
        }
        ```
* **PUT** `/electronic/{id}`
    * Edita um eletrodoméstico por id
    * Exemplo de entrada: `/electronic/d63c6013-0fd2-4863-a2a9-023059b55906`
    * Aceita um JSON com as seguintes informações:
        * `String name` - nome do equipamento **Obrigatório**
        * `String model` - modelo do equipamento **Obrigatório**
        * `String power` - potência do equipamento  **Obrigatório**
    * Exemplo de JSON de Entrada:
      * ```JSON
        {
        "name": "Monitor",
        "model": "XTI",        
        "power": "80W"
        }
        ```
    * Exemplo de JSON de Saída:
      * ```JSON
        {
        "id": "d63c6013-0fd2-4863-a2a9-023059b55906",
        "name": "Monitor",
        "model": "XTI",        
        "power": "80W"
        }
        ```
* **DELETE** `/electronic/{id}`
    * Exclui um eletrodomésticos
    * Exemplo de entrada: `/electronic/d63c6013-0fd2-4863-a2a9-023059b55906`
    * Exemplo de Saída: Eletrodomésticos removido com sucesso.

## API para o cadastro de endereços
Permite ao usuário gerenciar os dados de endereços do sistema WattWise.

**TODOS os IDs usados são do tipo UUID**

### Endpoints:

* **GET** `/addresses/{id}`
    * Busca uma endereço por id
    * Exemplo de entrada: `/addresses/d63c6013-0fd2-4863-a2a9-023059b55906`
    * Exemplo de JSON de Saída:
      * ```JSON
        {
        "id": "d63c6013-0fd2-4863-a2a9-023059b55906",
        "street": "Emoções Street",
        "number": 255,        
        "complement": "",
        "neighborhood": "Bairro Esperança",
        "city": "Jacareí",
        "state": "Sao Paulo",
        "zipCode": 12309380
        }
        ```

* **GET** `/addresses`
    * Busca todos os endereços cadastrados
    * Exemplo de JSON de Saída:
      * ```JSON
        [
           {
           "id": "u87c6013-0fd2-4863-a2a9-023059b55741",
           "street": "Emoções Street",
           "number": 255,        
           "complement": "",
           "neighborhood": "Bairro Esperança",
           "city": "Jacareí",
           "state": "Sao Paulo",
           "zipCode": 12309380
           },
           {
           "id": "f93c6013-0fd2-4863-a2a9-023059b5599i",
           "street": "Sandal Street",
           "number": 1380,        
           "complement": "Ap. B",
           "neighborhood": "Garden Girls",
           "city": "Boston",
           "state": "Massachussets",
           "zipCode": 445978
           }
        ]
         ```
* **POST** `/addresses`
    * Cria um endereço
    * Aceita um JSON com as seguintes informações:
        * `String street` - nome da rua **Obrigatório**
        * `Integer number`  - número da casa/apartamento **Obrigatório**
        * `String complement` - complemento
        * `String neighborhood` - bairro
        * `String city` - cidade **Obrigatório**
        * `String state` - estado **Obrigatório**
        * `integer zipCode` - código postal **Obrigatório**

    * Exemplo de JSON de Entrada:
      * ```JSON
        {
        "street": "Sandal Street",
        "number": 1380,        
        "complement": "Ap. B",
        "neighborhood": "Garden Girls",
        "city": "Boston",
        "state": "Massachussets",
        "zipCode": 445978
        }
        ```
    * Exemplo de JSON de Saída:
      * ```JSON
        {
        "id": "cd1013cc-bc61-4970-88c1-9d3f85a4b3f1",
        "street": "Sandal Street",
        "number": 1380,        
        "complement": "Ap. B",
        "neighborhood": "Garden Girls",
        "city": "Boston",
        "state": "Massachussets",
        "zipCode": 445978
        }
        ```
* **PUT** `/addresses/{id}`
    * Edita um endereço por id
    * Exemplo de entrada: `/addresses/d63c6013-0fd2-4863-a2a9-023059b55906`
    * Aceita um JSON com as seguintes informações:
        * `String street` - nome da rua **Obrigatório**
        * `Integer number`  - número da casa/apartamento **Obrigatório**
        * `String complement` - complemento
        * `String neighborhood` - bairro
        * `String city` - cidade **Obrigatório**
        * `String state` - estado **Obrigatório**
        * `integer zipCode` - código postal **Obrigatório**
    * Exemplo de JSON de Entrada:
      * ```JSON
        {
        "street": "Sandal Street",
        "number": 1380,        
        "complement": "Ap. B",
        "neighborhood": "Garden Girls",
        "city": "Boston",
        "state": "Massachussets",
        "zipCode": 445978
        }
        ```
    * Exemplo de JSON de Saída:
      * ```JSON
        {
        "id": "d63c6013-0fd2-4863-a2a9-023059b55906",
        "street": "Sandal Street",
        "number": 1380,        
        "complement": "Ap. B",
        "neighborhood": "Garden Girls",
        "city": "Boston",
        "state": "Massachussets",
        "zipCode": 445978
        }
        ```
* **DELETE** `/addresses/{id}`
    * Exclui um endereço
    * Exemplo de entrada: `/addresses/d63c6013-0fd2-4863-a2a9-023059b55906`
    * Exemplo de Saída: Endereço removido com sucesso.

## API para o cadastro de pessoas

**TODOS os IDs usados são do tipo UUID**

### Endpoints:

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
    * Exemplo de entrada: `/person/d63c6013-0fd2-4863-a2a9-023059b55906`
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
    * Exclui uma pessoa
    * Exemplo de entrada: `/person/ba1e8bec-cea3-4ca7-a7da-9cee42b087ea`
    * Exemplo de Saída: Pessoa removida com sucesso