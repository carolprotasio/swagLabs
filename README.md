# SwagLabs - Projeto de Automação de Teste

Este projeto de automação de testes foi desenvolvido com o objetivo de aprofundar os estudos em **Selenium WebDriver** e **Programação Orientada a Objetos (POO)**, aplicando boas práticas de desenvolvimento de software e testes automatizados.

Os teste automatizados foram realizado no [SwagLabs](https://www.saucedemo.com/), que é  uma plataforma de demonstração oferecida pela Sauce Labs. Utilizada principalmente para fins educacionais e de treinamento em automação de testes, esta plataforma simula uma loja online e oferece uma variedade de funcionalidades essenciais, proporcionando um ambiente ideal para a criação e execução de testes automatizados.

<img src="https://github.com/carolprotasio/swagLabs/blob/main/src/test/java/assets/loginInfo.png" alt="Product Info" width="600"/>
<img src="https://github.com/carolprotasio/swagLabs/blob/main/src/test/java/assets/productInfo.png" alt="Product Info" width="600"/>

## Funcionalidades Testadas

- **Login**: Permite que os usuários realizem login com diferentes níveis de acesso, validando tanto credenciais corretas quanto incorretas.
- **Produtos**: Exibe uma lista de produtos disponíveis para compra, incluindo funcionalidades de filtragem e ordenação, permitindo testes de usabilidade e integridade dos dados apresentados.
- **Carrinho de Compras**: Facilita a adição, visualização e remoção de produtos no carrinho, garantindo que as operações de manipulação de itens sejam corretamente validadas.
- **Checkout**: Engloba todo o processo de finalização da compra, desde a inserção das informações do cliente até a confirmação do pedido, assegurando que todas as etapas do fluxo de compra sejam devidamente testadas.
- **Navegação**: Inclui links de navegação para diversas seções do site, como logout, sobre, todos os itens e redefinir estado do aplicativo, permitindo a validação da acessibilidade e funcionalidade dos links.

![](https://github.com/carolprotasio/swagLabs/blob/main/src/test/java/assets/overViewTests.png)

## Tecnologias Utilizadas

- IntelliJ (Java IDE);
- Selenium;
- JUnit;
- Wedriver;
- Webdriver Manager;
- Bibliotecas Maven;
- Bibliotecas JavaFaker.  

## Pré-requisitos

- JDK 8 ou superior
- Maven
- IntelliJ IDEA ou qualquer IDE de sua preferência

## Instalação

1. Clone o repositório:
   ```sh
   git clone https://github.com/carolprotasio/swagLabs.git

# Cenários de Teste e Critérios de Aceitação
## 📦 Funcionalidade dos Produtos
### CT-001: Adicionar um produto ao carrinho com sucesso
**Cenário:** Usuário seleciona um único produto da lista e o adiciona ao carrinho.
**Critérios de Aceitação:** O produto deve aparecer no carrinho com o nome e o preço corretos.

### CT-002: Adicionar todos os 6 produtos ao carrinho com sucesso
**Cenário:** Usuário seleciona todos os produtos disponíveis na lista e os adiciona ao carrinho.
**Critérios de Aceitação:** Todos os produtos devem aparecer no carrinho com os nomes e preços corretos.

### CT-003: Filtrar produto de Z para A
**Cenário:** Usuário aplica um filtro para ordenar os produtos em ordem alfabética inversa.
**Critérios de Aceitação:** A lista de produtos deve ser exibida em ordem alfabética de Z para A.

### CT-004: Filtrar produto por preço (baixo para alto)
**Cenário:** Usuário aplica um filtro para ordenar os produtos do menor para o maior preço.
**Critérios de Aceitação:** A lista de produtos deve ser exibida com os preços ordenados do menor para o maior.

### CT-005: Filtrar produto por preço (alto para baixo)
**Cenário:** Usuário aplica um filtro para ordenar os produtos do maior para o menor preço.
**Critérios de Aceitação:** A lista de produtos deve ser exibida com os preços ordenados do maior para o menor.

### CT-006: Adicionar um produto e confirmar o nome no carrinho
**Cenário:** Usuário adiciona um produto específico ao carrinho.
**Critérios de Aceitação:** O nome do produto deve aparecer corretamente no carrinho.

![ProdutoTest](https://github.com/carolprotasio/swagLabs/blob/main/src/test/java/assets/products.png)

## 🔑 Funcionalidade do Login
### CT-001: Login com sucesso
**Cenário:** Usuário insere credenciais válidas e realiza o login.
**Critérios de Aceitação:** Usuário deve ser redirecionado para a página inicial.

### CT-002: Login com nome de usuário inválido
**Cenário:** Usuário insere um nome de usuário inválido.
**Critérios de Aceitação:** Uma mensagem de erro deve ser exibida.

### CT-003: Login com senha inválida
**Cenário:** Usuário insere uma senha inválida.
**Critérios de Aceitação:** Uma mensagem de erro deve ser exibida.

### CT-004: Login com todos os campos vazios
**Cenário:** Usuário tenta realizar o login sem preencher nenhum campo.
**Critérios de Aceitação:** Uma mensagem de erro deve ser exibida.

### CT-005: Login com campo de senha vazio
**Cenário:** Usuário tenta realizar o login sem preencher o campo de senha.
**Critérios de Aceitação:** Uma mensagem de erro deve ser exibida.

### CT-006: Login com campo de nome de usuário vazio
**Cenário:** Usuário tenta realizar o login sem preencher o campo de nome de usuário.
**Critérios de Aceitação:** Uma mensagem de erro deve ser exibida.

### CT-007: Verificar botão de login clicável com campos vazios
**Cenário:** Usuário verifica se o botão de login é clicável com os campos vazios.
**Critérios de Aceitação:** O botão de login não deve ser clicável.

![LoginTest](https://github.com/carolprotasio/swagLabs/blob/main/src/test/java/assets/login.png)

## ☰ Funcionalidade da Navegação
### CT-001: Validar link de logout na navegação

**Cenário:** Usuário verifica se o link de logout está presente e funcional.
**Critérios de Aceitação:** O link de logout deve estar presente e redirecionar o usuário para a página de login.

### CT-002: Validar link sobre na navegação
**Cenário:** Usuário verifica se o link 'Sobre' está presente e funcional.
**Critérios de Aceitação:** O link 'Sobre' deve estar presente e redirecionar o usuário para a página correspondente.

### CT-003: Validar link de todos os itens na navegação
**Cenário:** Usuário verifica se o link 'Todos os Itens' está presente e funcional.
**Critérios de Aceitação:** O link 'Todos os Itens' deve estar presente e redirecionar o usuário para a página de produtos.

### CT-004: Validar link de redefinir estado do aplicativo na navegação
**Cenário:** Usuário verifica se o link 'Redefinir Estado do Aplicativo' está presente e funcional.
**Critérios de Aceitação:** O link 'Redefinir Estado do Aplicativo' deve estar presente e redefinir o estado do aplicativo.

![NavegacaoTest](https://github.com/carolprotasio/swagLabs/blob/main/src/test/java/assets/navigation.png)

## 🛒 Funcionalidade de Checkout do Produto
### CT-001: Adicionar um produto ao carrinho e validar checkout com sucesso
**Cenário:** Usuário adiciona um produto ao carrinho e conclui o processo de checkout.
**Critérios de Aceitação:** O processo de checkout deve ser concluído com sucesso, e uma confirmação deve ser exibida.

### CT-002: Adicionar um produto ao carrinho e validar checkout com sucesso
**Cenário:** Usuário adiciona um produto ao carrinho e conclui o processo de checkout.
**Critérios de Aceitação:** O processo de checkout deve ser concluído com sucesso, e uma confirmação deve ser exibida.

### CT-003: Adicionar dois produtos ao carrinho e validar checkout com sucesso
**Cenário:** Usuário adiciona dois produtos ao carrinho e conclui o processo de checkout.
**Critérios de Aceitação:** O processo de checkout deve ser concluído com sucesso, e uma confirmação deve ser exibida.

### CT-004: Adicionar dois produtos e validar o valor total
**Cenário:** Usuário adiciona dois produtos ao carrinho.
**Critérios de Aceitação:** O valor total no carrinho deve ser calculado e exibido corretamente.

![CheckoutTest](https://github.com/carolprotasio/swagLabs/blob/main/src/test/java/assets/checkout.png)
####
![AllTest](https://github.com/carolprotasio/swagLabs/blob/main/src/test/java/assets/allTests.png)

## Conclusão
Este projeto de automação de testes para o SwagLabs não só aprimorou as habilidades em Selenium WebDriver e Programação Orientada a Objetos (POO), mas também demonstrou a importância de criar testes robustos e abrangentes para garantir a qualidade e a confiabilidade das aplicações web. Através da automação das funcionalidades principais como login, navegação, manipulação de produtos, e processos de checkout, conseguimos validar eficientemente a integridade e a usabilidade da plataforma. Este projeto serve como uma base sólida para futuras expansões e implementações de testes automatizados em diferentes contextos e aplicações.
