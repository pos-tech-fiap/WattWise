# WattWise
Project to energy save

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