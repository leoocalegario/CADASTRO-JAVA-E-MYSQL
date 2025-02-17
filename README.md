# Sistema de Cadastro de Usuários

## Descrição do Projeto

Este projeto consiste em um sistema completo de cadastro de usuários, desenvolvido utilizando a IDE NetBeans e o phpMyAdmin para gerenciamento do banco de dados. O sistema permite realizar operações essenciais, como:

- Cadastro de novos usuários
- Alteração de dados de usuários cadastrados
- Exclusão de usuários
- Integração com a API pública **ViaCep** para preenchimento automático do endereço
- Exibição de estatísticas através de gráficos, mostrando a quantidade de alterações e exclusões realizadas

## Tecnologias Utilizadas

- **Java (NetBeans)**: Desenvolvimento do backend e lógica de negócio.
- **MySQL (phpMyAdmin)**: Banco de dados para armazenar as informações dos usuários.
- **API ViaCep**: Consulta automática de endereços a partir do CEP informado.
- **JavaFX / JFreeChart**: Utilização de gráficos para exibição das estatísticas do sistema.

## Funcionalidades Principais

### 1. **Cadastro de Usuário**
- Formulário completo com nome, e-mail, telefone, endereço e outros dados.
- Integração com a API **ViaCep** para preenchimento automático do endereço.
- Validação de dados antes do cadastro.

### 2. **Alteração de Cadastro**
- Possibilidade de editar as informações do usuário.
- Registros das alterações feitas para controle interno.

### 3. **Exclusão de Usuários**
- Remoção de cadastros de usuários.
- Registro de exclusões para fins estatísticos.

### 4. **Tela de Estatísticas**
- Dois gráficos interativos mostrando:
  - Quantidade de alterações feitas nos cadastros.
  - Quantidade de exclusões realizadas.

