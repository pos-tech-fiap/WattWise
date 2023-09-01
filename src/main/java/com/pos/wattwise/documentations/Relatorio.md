# Relatório Tech Challenge

A arquitetura escolhida foi o monolito, pela facilidade de implementação, já que estamos no início do projeto. As dependências usadas foram: Validation, Spring Boot Web e Dev Tools.
Para fazer a persistência e utilizar o banco de dados, acrescentamos a JPA e Postgres às dependências. Nessa fase, decidimos por um banco de dados rodando em container, e por isso, acrescentamos o Docker à nossa API.

### Fase 1:
O uso do Lombok foi um problema para a maioria dos integrantes do grupo. Em um dos casos, o código estava correto e, ao testar o endpoint de getAll, o programa só estava devolvendo o primeiro objeto salvo e não uma lista com todos os objetos. Ao usar os getters e setters da IDE, o programa passou a funcionar corretamente. Em outro caso, o código não chegava a rodar pelo mesmo motivo. Atualmente, e em decorrência do tempo perdido, não avaliamos como uma boa escolha para o projeto, e por isso, decidimos por não usá-lo no projeto.

Para um integrante, a maior dificuldade durante o desenvolvimento do projeto, foi entender o tratamento de dados e hierarquias: onde recebê-los, para onde enviar, onde salvar. Isso reflete diretamente no desenvolvimento do Controller e do Repository, já que, nessa etapa, ainda não estamos usando um banco de dados. É um processo complexo e que demanda tempo para entender o porquê de chamar alguns métodos, porque, de modo geral, é como se fosse um decoreba. Porém, ao decorrer do tempo e com o desenvolvimento dos endpoints, a compreensão de como funciona o fluxo ficou um pouco mais clara.

### Fase 2:
As maiores dificuldades foram conseguir entender e modelar os relacionamentos entres as tabelas e conseguir desenvolver a regra de negócio para o funcionamento e medição do consumo de energia.
Também tivemos um pouco de dificuldade em acertar a configuração do Docker para usar a relação do pgAdmin com o banco de dados.
