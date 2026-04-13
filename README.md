# Product System em Java ☕

Sistema de gerenciamento de produtos desenvolvido em **Java**, aplicando conceitos de **Programação Orientada a Objetos (POO)**, validações robustas e boas práticas de organização de código.

---

## Funcionalidades

#### Cadastro de produtos com diferentes tipos:
  - Produto comum
  - Produto usado (com data de fabricação)
  - Produto importado (com taxa de importação)
#### Validação de dados do usuário:
  - Preços e taxas sempre numéricos e positivos
  - Datas válidas no formato `DD/MM/YYYY`
  - Tratamento de erros sem encerrar a aplicação

---

## Conceitos Aplicados

- **Herança** — classes especializadas (`UsedProduct`, `ImportedProduct`)
- **Polimorfismo** — comportamento específico em `priceTag()`
- **Encapsulamento** — atributos privados e métodos públicos
- **Validação de dados** — tratamento de erros e inputs inválidos
- **Separação de responsabilidades** — uso de camada `services`

---

## Estrutura do Projeto

```text
product-system-java/
 ├── src/
 │   ├── application/
 │   │   └── Program.java
 │   ├── entities/
 │   │   ├── Product.java
 │   │   ├── UsedProduct.java
 │   │   └── ImportedProduct.java
 │   └── services/
 │       └── ProductService.java
 ├── .gitignore
 └── README.md
```

---

## ▶️ Como Executar

### 1. Compile o projeto

```bash
javac -d bin src/application/Program.java src/entities/*.java src/services/*.java
```

### 2. Execute

```bash
java -cp bin application.Program
```

---

## Exemplo de Uso

```text
--- Product Registration ---
Number of products: 2

Product #1
Type [c=common, u=used, i=imported]: i
Name: Tablet
Price: 800
Customs fee: 100

Product #2
Type [c=common, u=used, i=imported]: u
Name: Laptop
Price: 2000
Manufacture date (DD/MM/YYYY): 15/03/2023

--- Price Tags ---
Tablet $900.00 (Customs fee: $100.00)
Laptop (used) $2000.00 (Manufacture date: 15/03/2023)
```

---

## Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos **(POO)**
- API de datas (`SimpleDateFormat`)
- Validações e tratamento de exceções

---

## Autor

**Matheus Pereira** <br> 
- Estudante de Engenharia de Software Faculdade de Nova Serrana <br>
- Apaixonado por desenvolvimento desktop em Python <br>
- GitHub: https://github.com/MatheusPereiira

---
