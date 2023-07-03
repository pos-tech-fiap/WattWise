# Relatório Tech Challenge

A arquitetura escolhida foi o monolito, pela facilidade de implementação, já que estamos no início do projeto. As dependências usadas foram: Validation, Spring Boot Web, Dev Tools e Postman.

## Dificuldades

O uso do Lombok foi um problema para a maioria dos integrantes do grupo. Em um dos casos, o código estava correto e, ao testar o endpoint de getAll, o programa só estava devolvendo o primeiro objeto salvo e não uma lista com todos os objetos. Ao usar os getters e setters da IDE, o programa passou a funcionar corretamente. Em outro caso, o código não chegava a rodar pelo mesmo motivo. Atualmente, e em decorrência do tempo perdido, não avaliamos como uma boa escolha para o projeto, e por isso, decidimos por não usá-lo no projeto.

Para um integrante, a maior dificuldade durante o desenvolvimento do projeto, foi entender o tratamento de dados e hierarquias: onde recebê-los, para onde enviar, onde salvar. Isso reflete diretamente no desenvolvimento do Controller e do Repository, já que, nessa etapa, ainda não estamos usando um banco de dados. É um processo complexo e que demanda tempo para entender o porquê de chamar alguns métodos, porque, de modo geral, é como se fosse um decoreba. Porém, ao decorrer do tempo e com o desenvolvimento dos endpoints, a compreensão de como funciona o fluxo ficou um pouco mais clara.
