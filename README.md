<div align="center">

#  Storage — ERP SaaS

### Gestão de estoque, produtos e fornecedores para o seu negócio

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow?style=flat-square)

</div>

---

##  Sobre o projeto

O **Storage** é um sistema ERP no modelo **SaaS** voltado para pequenas e médias empresas que precisam controlar estoque, produtos e fornecedores de forma simples, segura e escalável. O objetivo é oferecer uma solução multi-cliente, acessível via web, com foco em performance e boas práticas de arquitetura.

##  Funcionalidades

-  **Gestão de Produtos** — cadastro, edição e controle de estoque
-  **Gestão de Fornecedores** — vínculo de fornecedores a produtos via relação muitos-para-muitos
-  **Leitura de QR Code no checkout** — reconhecimento rápido de produtos usando ZXing
-  **Serialização segura** — camada de DTOs isolando as entidades JPA da API
-  **Controle transacional** — regras de negócio centralizadas em serviços `@Transactional`

##  Decisões técnicas

Algumas escolhas de arquitetura que guiam o desenvolvimento do projeto:

- **QR Code com apenas o SKU** — o código gerado carrega somente o identificador do produto (SKU), nunca o preço, evitando que o valor seja manipulado ou exposto no próprio código.
- **Entidades associativas** (`ProductSupplier` / `SupplierProduct`) — usadas para modelar corretamente relações muitos-para-muitos entre produtos e fornecedores, permitindo atributos extras na relação (ex: preço de compra, prazo de entrega).
- **DTOs dedicados** — toda serialização de entrada/saída passa por DTOs, evitando problemas de serialização do Hibernate (proxies, lazy loading) e desacoplando o modelo de domínio da API.
- **Lógica de mapeamento dentro dos serviços transacionais** — a conversão entre entidade e DTO acontece dentro dos métodos `@Transactional`, garantindo que relações *lazy* sejam carregadas corretamente antes da serialização.

## Tecnologias

- **Java** + **Spring Boot**
- **Spring Data JPA / Hibernate**
- **Lombok**
- **Jackson** (serialização JSON)
- **ZXing** (geração/leitura de QR Code)
- **Banco de dados relacional** *(ajustar: PostgreSQL / MySQL)*

##  Como executar

```bash
# Clonar o repositório
git clone https://github.com/coelhotechne/storage.git
cd storage

# Configurar variáveis de ambiente / application.properties
# (dados de conexão com o banco, porta, etc.)

# Rodar com Maven
./mvnw spring-boot:run
```

> Ajuste o comando acima caso o projeto use Gradle em vez de Maven.

##  Roadmap

- [ ] Multi-tenancy (isolamento de dados por cliente)
- [ ] Módulo de vendas / checkout completo
- [ ] Versão desktop (avaliando Electron, Tauri, PWA ou .NET MAUI/WebView2)
- [ ] Relatórios e dashboards de estoque

##  Licença

*Defina a licença do projeto aqui (ex: MIT, proprietária, etc).*

##  Contato

Desenvolvido por **[Coelho Techne](https://github.com/coelhotechne)**
✉️ coelhotechne@outlook.com.br
