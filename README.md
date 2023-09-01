# WattWise
Project to energy save

---

# Documentação

## Rodar o banco de dados

Parar rodar o banco de dados, é necessário executar o Dockerfile, com os seguintes comandos:

```
docker build -f Dockerfile -t wattwise-local .
docker run -p 5432:5432 -v $(pwd):/wattwise/ wattwise-local
```


## Coleção do Postman 
Permite ao usuário gerenciar os cadastros do sistema WattWise.
A coleção para testes encontra-se anexada aos arquivos deste repositório em ./documentations 

```
https://documenter.getpostman.com/view/14838966/2s9Y5ctg2S
```
## Aplicação
Para testar a aplicação é necessario subir a aplicação na porta 8080