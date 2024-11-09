## Serviço de validação de autorização de operação com cartão de crédito
Serviço para controle transacional de autorizações de operação com cartão de crédito

Esse projeto visa demonstrar a estruturação da arquitetura hexagonal de maneira simples e objetiva.

Onde as regras de negócio ficam na camada de domínio.

Esse padrão de arquitetura permite que as tecnologias fiquem isoladas ou desacopladas, possibilitando que novas tecnologias sejam utilizadas, sem impactar nas regras de negócio pré estabelecidas.


### Pré-requisitos:
- Executar o comando docker-compose.yml:
  - ``docker-compose up -d``

A execução do docker-compose.yml cria os containers para POSTGRESQL e RABBITMQ.
Também existe um script para criação do banco de dados necessário para o Serviço.

### Execução dos Testes do serviço:
  - ``mvn clean install && mvn test``
    - Nesta primeira versão foi priorizado os testes unitários.

### Execução do Serviço:
  - ``mvn clean install && mvn spring-boot:run``

### Execução do endpoint:
  - ``http://localhost:8080/credcard-transaction-service/v1/transaction`` (POST), pode ser utilizado o Postman para executar o endpoint.

### TODO - Próximos passos:
- Separação das camadas de aplicação (core), domínio, inbound e outbound em submódulos
  - Essa separação é importante para aplicação de padrões clean arch e onion arch, garantindo ainda mais o isolamento de regras de negócio e tecnologias aplicadas.
- Aumento da cobertura dos testes unitários até atingir 100%;
- Inclusão de testes de integração para garantir que as regras de negócio estejam em conformidade com as tecnologias utilizadas
  - Também garantirá cobertura funcional e lógica;
- Inclusão de endpoints para CRUD, facilitando os testes manuais e a utilização do serviço.
- Uso do RabbitMQ para processamentos assíncronos e distribuídos;
- Utilização do recurso SYNCHRONIZED do Java em pontos importantes, como atualização do saldo, evitando que a concorrência permita uso indevido de valores.

#### Considerações finais:

O projeto foi desenvolvido com o intuito de demonstrar a estruturação da arquitetura hexagonal, a aplicação de regras de negócio na camada de domínio, mantendo a centralização e reaproveitamento dessas regras.

