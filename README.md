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
| carro | objeto | sim | informar todos os dados do objeto carro
| usoDoCarro | texto | sim | informar se o carro é ou não blindado
| blindagem | boolean | sim | informar se o carro é ou não blindado
| endereco | objeto | sim | informar todos os dados do objeto endereco
| idadeMinima | boolean | sim | informar se há ou não condutores menores de 21 anos


 **Exemplo de corpo de requisição**

```js
{
  "cotacao": {
    "carro": {
      "placa": "MOV-3961",
      "modelo": "Honda Civic",
      "ano": "2017"
    },
    "usoDoCarro": "Particular",
    "blindagem": false,
    "endereco": {
      "cep": "06141-050",
      "logradouro": "Rua Mário Barreto",
      "numero": 227,
      "complemento": "Enfrente ao Mercado Baratão"
    },
    "idadeMinima": false
  }
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
