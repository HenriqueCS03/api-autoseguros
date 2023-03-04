# Seguro-Automotivo

Uma API para seguro automotivo

## Endpoints

- Login
    - [Cadastrar usuário](#cadastro-usuário)
    - 

- Serviços
    - listar todos
    -


## Login
### Cadastro usuário

`POST` /seguroautomotivo/api/cadastro 

**Campos da requisição** 

| campos | tipos | obrigatório | descrição 
|-------|-------|-----|-----
| id_cliente |  int  | sim | o id da conta que será gerado pela sequence
| ds_email | texto | sim | descrição de seu e-mail
| ds_senha | texto | sim | descrição de sua senha 

**Exemplo de corpo de requisição**

```js
{
    id_cliente: 1,
    ds_email: "rogerio@gmail.com.br",
    ds_senha: "12345"
}
```

**Resposta**

| código | descrição
|----|---
| 201 | usuário cadastrado com sucesso 
| 400 | campos inválidos

## Listar serviços

`GET` /seguroautomotivo/api/servicos

 **Exemplo de corpo de resposta**

```js
{

}
```
**Resposta**

| código | descrição
|----|---
| 200 | dados dos serviços retornados 
| 404 |  não existe o serviço


## Cotação

`POST` /seguroautomotivo/api/cotacao

**Campos da requisição** 

| campos | tipos | obrigatório | descrição 
|-------|-------|-----|-----

| 


 **Exemplo de corpo de requisição**

```js
{

}
```

**Resposta**

| código | descrição
|----|---
| 201 | 
| 400 | 


