# 💰 Controle Financeiro

Uma aplicação web desenvolvida para auxiliar no gerenciamento de finanças pessoais. O sistema permite o registo de receitas e despesas, oferecendo uma visão clara do saldo atual e um histórico detalhado das transações.

## 🚀 Sobre o Projeto

O **Controle Financeiro** é uma aplicação Fullstack que utiliza a robustez do ecossistema Spring para garantir a integridade das transações financeiras. O objetivo principal é fornecer uma interface simples e responsiva para que o utilizador possa categorizar as suas entradas e saídas monetárias e visualizar o impacto no seu saldo final automaticamente.

## 🛠️ Tecnologias Utilizadas

### Backend
* **Java 17**: Linguagem base do projeto.
* **Spring Boot 3.5.7**: Framework principal para configuração e inicialização da aplicação.
* **Spring Data JPA**: Para abstração da camada de persistência e manipulação de dados.
* **PostgreSQL**: Banco de dados relacional utilizado para armazenar as transações.

### Frontend
* **Thymeleaf**: Motor de templates (Template Engine) para renderização dinâmica das páginas HTML no servidor.
* **HTML5 & CSS3**: Estruturação semântica e estilização personalizada (layout responsivo e moderno).

### Ferramentas
* **Maven**: Gestão de dependências e build do projeto.

## ✨ Funcionalidades

* **Registo de Receitas**: Formulário dedicado para cadastro de entradas (salários, ganhos extras), incluindo data, descrição e valor.
* **Registo de Despesas**: Formulário para cadastro de saídas (contas, compras), impactando negativamente o saldo.
* **Extrato Financeiro**:
    * Listagem cronológica de todas as transações (Receitas e Despesas).
    * Diferenciação visual entre receitas e despesas.
    * Cálculo automático dos totais de entradas, saídas e **Saldo Final** consolidado.
* **Persistência de Dados**: Uso de herança com estratégia `SINGLE_TABLE` no banco de dados para gerir as entidades `Transacao`, `Receita` e `Despesa` de forma otimizada.

## ⚙️ Configuração do Banco de Dados

O projeto está configurado para ligar-se a um banco PostgreSQL local. Antes de executar, certifique-se de que criou uma base de dados chamada `controle_financeiro_db` e que as configurações no ficheiro `src/main/resources/application.properties` correspondem ao seu ambiente:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/controle_financeiro_db
spring.datasource.username=postgres
spring.datasource.password=sua_senha_aqui
