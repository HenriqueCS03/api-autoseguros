# Seguro-Automotivo

Uma API para seguro automotivo

## Endpoints

- [Login](#login)
    - [Cadastrar usuário](#cadastro-usuário)
    - [Fazer login](#fazer-login)

- [Cotação](#cotação)
    -[Cotar](#cotar)

- [Serviços](#serviços)
    - [listar todos](#listar-todos)
    - [Assinar serviço](#assinar-serviço)


## Login
### Cadastro usuário

`POST` /seguroautomotivo/api/cadastro 

**Campos da requisição** 

| campos | tipos | obrigatório | descrição 
|-------|-------|-----|-----
| email | texto | sim |  o e-mail do usuário
| ds_senha | texto | sim | a senha do usuário 

**Exemplo de corpo de requisição**

```js
{
    email: "rogerio@gmail.com",
    senha: "12345"
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
| email | texto | sim | e-mail do usuário que deseja logar app
| senha | texto | sim | senha do usuário que deseja logar no app

**Exemplo de corpo de requisição**

```js
{
    email: "rogerio@gmail.com",
    senha: "12345"
}
```

**Resposta**

| código | descrição
|----|---
| 201 | api recebeu os dados do usuário com sucesso 
| 400 | campos inválidos

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
| CEP | texto | sim | informar onde dorme o carro
| CPF | texto | sim | informar o cpf de quem ta fazendo o seguro
| idadeMinima | boolean | sim | informar se há ou não condutores menores de 21 anos




 **Exemplo de corpo de requisição**

```js
{
    modelo: "Chevrolet Corsa"
    ano: "2000"
    blindagem: false
    CEP: "06141-050"
    CPF: "111.444.777-35"
    idadeMinima: false
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
    servicos: [
        "Roubo e furto",
        "Eventos naturais",
        "Incêndio",
        "Colisão simples",
        "Colisão severa"
    ]
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
| dadosVeiculo | objeto | sim | os dados do veiculo
| plano | objeto | sim | informaçõe do que o plano ira cobrir




 **Exemplo de corpo de requisição**

```js
{
    dadosVeiculo: [
        modelo: "Chevrolet Corsa"
        ano: "2000"
        blindagem: false
        CEP: "06141-050"
        CPF: "111.444.777-35"
        idadeMinima: false
    ],
    plano: [
        Roubo e furto: true,
        Eventos naturais: true,
        Incêndio: false,
        Colisão simples: false,
        Colisão severa: false
    ]

}
```

**Resposta**

| código | descrição
|----|---
| 201 | retorna a o boleto para o pagamento da assinatura
| 400 | campos invalidos
