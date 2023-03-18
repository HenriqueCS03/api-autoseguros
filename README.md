# Seguro-Automotivo

Uma API para seguro automotivo \
Link do figma: https://www.figma.com/file/DYSewiaigWu9uOcFgouMfL/AutoSeguros?node-id=0%3A1

## Endpoints

- [Login](#login)
    - [Cadastrar usuário](#cadastro-usuário)
    - [Fazer login](#fazer-login)

- [Cotação](#cotação)
    - [Cotar](#cotar)

- [Serviços](#serviços)
    - [listar todos](#listar-todos)
    - [Assinar serviço](#assinar-serviço)


## Login
### Cadastro usuário

`POST` /seguroautomotivo/api/cadastro 

**Campos da requisição** 

| campos | tipos | obrigatório | descrição 
|-------|-------|-----|-----
| email/ cpf | texto | sim | cpf ou email do usuário
| senha | texto | sim | a senha do usuário 

**Exemplo de corpo de requisição**

```js
{
    "email": "rogerio@gmail.com",
    "senha": "12345"
}
```

**Resposta**

| código | descrição
|----|---
| 201 | usuário cadastrado com sucesso 
| 400 | campos inválidos

---
### Fazer login

`POST` /seguroautomotivo/api/login

**Campos da requisição**

| campos | tipos | obrigatório | descrição 
|-------|-------|-----|-----
| email/ cpf| texto | sim | e-mail ou cpf do usuário que deseja logar app
| senha | texto | sim | senha do usuário que deseja logar no app

**Exemplo de corpo de requisição**

```js
{
    "email": "rogerio@gmail.com",
    "senha": "12345"
}
```

**Resposta**

| código | descrição
|----|---
| 201 | api recebeu os dados do usuário com sucesso 
| 400 | campos inválidos
| 404 | não existe usuário informado

-----
## Cotação

### Cotar

`POST` /seguroautomotivo/api/cotar

**Campos da requisição** 

| campos | tipos | obrigatório | descrição 
|-------|-------|-----|-----
| modelo | texto | sim | informar o modelo do veiculo
| ano | data | sim | informar a data do modelo do veiculo
| blindagem | boolean | sim | informar se o carro é ou não blindado
| cep | texto | sim | informar onde dorme o carro
| idadeMinima | boolean | sim | informar se há ou não condutores menores de 21 anos


 **Exemplo de corpo de requisição**

```js
{
    "cpf": "12345678987",
    "modelo": "Chevrolet Corsa",
    "ano": "2000",
    "blindagem": false,
    "cep": "06141-050",
    "idadeMinima": false
}
```


**Resposta**

| código | descrição
|----|---
| 201 | retorna a Cotação com sucesso
| 400 | campos invalidos

---
## Serviços

### Listar todos

`GET` /seguroautomotivo/api/lsServicos

 **Exemplo de corpo de resposta**

```js

{
  "servicos": {
    "id_servicos": 1,
    "lista_servicos": [
      {
        "servicoNome": "Roubo e Furto",
        "valor": 450
      },
      {
        "servicoNome": "Eventos Naturais",
        "valor": 600
      },
      {
        "servicoNome": "Incêndio",
        "valor": 800
      },
      {
        "servicoNome": "Colisão(Batida)",
        "valor": 1000
      },
      {
        "servicoNome": "Colisão(Perda Total)",
        "valor": 1500
      }
    ]
  }
}
```
**Resposta**

| código | descrição
|----|---
| 200 | dados dos serviços retornados 
| 404 |  não existe o serviço

---
### Assinar serviço

`POST` /seguroautomotivo/api/assinar

**Campos da requisição** 

| campos | tipos | obrigatório | descrição 
|-------|-------|-----|-----
| cliente | objeto | sim | dados do cliente
| cotacao | objeto | sim | os dados da cotação
| servico | objeto | sim | informações do serviços que o plano irá cobrir
| valorTotal | double | sim | resultado do plano previamente calculado



 **Exemplo de corpo de requisição**

```js
{
    "planoSeguro": {
    "cliente": {
        "id_cliente": 1
    },
    "cotacao": {
        "id_cotacao": 1
    },
    "servicos": {
        "id_servico": 1
    },
    "valorTotal": 3850.0
    }
}
```

**Resposta**

| código | descrição
|----|---
| 201 | retorna a o boleto para o pagamento da assinatura
| 400 | campos invalidos
