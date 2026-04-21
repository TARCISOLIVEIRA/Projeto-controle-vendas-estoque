# 🛒 Sistema de Controle de Vendas e Estoque

## 📌 Descrição
O Sistema de Controle de Vendas e Estoque é uma aplicação desenvolvida em Java utilizando Swing para interface gráfica e MySQL como banco de dados.  
O objetivo do sistema é auxiliar no gerenciamento de produtos, fornecedores e vendas, proporcionando maior controle e organização para o usuário.

---

## 🎯 Objetivo
Facilitar o controle de:
- Cadastro de produtos
- Cadastro de fornecedores
- Registro de vendas
- Controle de estoque

---

## ⚙️ Tecnologias Utilizadas
- Java (Swing)
- MySQL
- JDBC (conexão com banco de dados)
- NetBeans (IDE utilizada)

---

## 🧩 Funcionalidades

### 📦 Produtos
- Cadastro de produtos
- Atualização de dados
- Exclusão de produtos
- Listagem de produtos

### 🏢 Fornecedores
- Cadastro de fornecedores
- Associação com produtos
- Listagem de fornecedores

### 💰 Vendas
- Registro de vendas
- Cálculo automático do total
- Associação de produtos à venda

### 📊 Estoque
- Controle de quantidade de produtos
- Atualização automática após vendas

---

## 🗃️ Banco de Dados
O sistema utiliza as seguintes tabelas principais:
- tb_clientes
- tb_fornecedores
- tb_funcionarios
- tb_produtos
- tb_vendas
- tb_itensvendas



Com relacionamento entre produtos e fornecedores através de chave estrangeira.

## 📁 tb_clientes

```sql
CREATE TABLE tb_clientes (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) DEFAULT NULL,
  rg VARCHAR(30) DEFAULT NULL,
  cpf VARCHAR(20) DEFAULT NULL,
  email VARCHAR(200) DEFAULT NULL,
  telefone VARCHAR(30) DEFAULT NULL,
  celular VARCHAR(30) DEFAULT NULL,
  cep VARCHAR(20) DEFAULT NULL,
  endereco VARCHAR(255) DEFAULT NULL,
  numero INT DEFAULT NULL,
  complemento VARCHAR(200) DEFAULT NULL,
  bairro VARCHAR(100) DEFAULT NULL,
  cidade VARCHAR(100) DEFAULT NULL,
  estado VARCHAR(2) DEFAULT NULL,
  PRIMARY KEY (id));


```

## 📁 tb_fornecedores 

```sql
CREATE TABLE tb_fornecedores (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) DEFAULT NULL,
  cnpj VARCHAR(30) DEFAULT NULL,
  email VARCHAR(200) DEFAULT NULL,
  telefone VARCHAR(30) DEFAULT NULL,
  celular VARCHAR(30) DEFAULT NULL,
  cep VARCHAR(20) DEFAULT NULL,
  endereco VARCHAR(255) DEFAULT NULL,
  numero INT DEFAULT NULL,
  complemento VARCHAR(200) DEFAULT NULL,
  bairro VARCHAR(100) DEFAULT NULL,
  cidade VARCHAR(100) DEFAULT NULL,
  estado VARCHAR(2) DEFAULT NULL,
  PRIMARY KEY (id));


```

## 📁 tb_funcionarios 

```sql
CREATE TABLE tb_funcionarios (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) DEFAULT NULL,
  rg VARCHAR(30) DEFAULT NULL,
  cpf VARCHAR(30) DEFAULT NULL,
  email VARCHAR(200) DEFAULT NULL,
  senha VARCHAR(255) DEFAULT NULL,
  cargo VARCHAR(100) DEFAULT NULL,
  nivel_acesso VARCHAR(50) DEFAULT NULL,
  telefone VARCHAR(30) DEFAULT NULL,
  celular VARCHAR(30) DEFAULT NULL,
  cep VARCHAR(20) DEFAULT NULL,
  endereco VARCHAR(255) DEFAULT NULL,
  numero INT DEFAULT NULL,
  complemento VARCHAR(200) DEFAULT NULL,
  bairro VARCHAR(100) DEFAULT NULL,
  cidade VARCHAR(100) DEFAULT NULL,
  estado VARCHAR(2) DEFAULT NULL,
  PRIMARY KEY (id));


```

## 📁 tb_produtos
```sql
CREATE TABLE tb_produtos (
  id int  NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(100) DEFAULT  NULL,
  preco DECIMAL(10,2) DEFAULT NULL,
  qtd_estoque INT NOT  NULL,
  for_id int NOT NULL,
  PRIMARY KEY(id),
  CONSTRAINT fk_produto_fornecedor FOREIGN KEY (for_id) REFERENCES tb_fornecedores (id));

```

## 📁 tb_vendas
```sql
CREATE TABLE tb_vendas (
  id int  NOT NULL AUTO_INCREMENT,
  cliente_id int DEFAULT  NULL,
  data_venda date DEFAULT NULL,
  total_venda decimal(10,2) DEFAULT  NULL,
  observacoes text ,
 numero_nota int default null,
 funciona5io_id int default null,
  PRIMARY KEY(id),
  KEY fk_vendas_cliente(cliente_id),
 Key fk_funcionarios (funcionários_id),
CONSTRAINT fk_funcionarios FOREIGN KEY (funcionarios_id) REFERENCES tb_funcionarios (id)),
CONSTRAINT fk_vendas_cliente FOREIGN KEY (cliente_id) REFERENCES tb_clientes(id));


```
## 📁 tb_itensvendas
```sql
CREATE TABLE tb_itensvendas (
  id int  NOT NULL AUTO_INCREMENT,
  venda_id int DEFAULT  NULL,
  produto_id int DEFAULT  NULL,
  qtd  int  DEFAULT NULL,
  subtotal decimal(10,2) DEFAULT  NULL,
  PRIMARY KEY(id),
  KEY venda_id(venda_id),
   KEY produto_id(produto_id),
  CONSTRAINT tb_itensvendas_ibkf_1 FOREIGN KEY (venda_id) REFERENCES tb_vendas (id),
  CONSTRAINT tb_itensvendas_ibkf_2 FOREIGN KEY (produto_id) REFERENCES tb_produtos (id));

```

## 📁 tb_alerta_estoque
```sql
CREATE TABLE tb_alerta_estoque (
Id int not null auto increment,
Produto_id int default null, descricao varchar (255) default null,
Data_alerta datetime default current_timestamp,
Primary key(id);


```


## Equipe:
- Carlos Sampaio
- Cresleis
- Masili 
- Tarciso dos Santos

## Faculdade
![Grau Técnico](https://grau.com.br/wp-content/themes/grau/assets/images/logo.svg)
  
