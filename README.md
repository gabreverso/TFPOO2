# Batalha Naval

Este é um jogo de Batalha Naval simples implementado em Java com uma interface gráfica usando Swing.

## Funcionalidades

- Interface gráfica para jogar Batalha Naval.
- Dois tabuleiros de 6x6 para cada jogador.
- Adição automática de navios aleatórios em cada tabuleiro.
- Alternância entre jogadores para realizar ataques.
- Verificação de vitória para determinar o vencedor do jogo.

## Como Jogar

1. Certifique-se de ter o JDK (Java Development Kit) instalado em sua máquina.
2. Clone ou baixe este repositório para sua máquina local.
3. Abra o projeto em sua IDE Java de preferência.
4. Execute a classe `TF_BatalhaNaval.java` para iniciar o jogo.
5. Siga as instruções na interface gráfica para jogar.

Alternativamente, você pode compilar e executar o projeto usando a linha de comando:

```bash
javac src/main/java/com/mycompany/tf_batalhanaval/*.java
java src/main/java/com/mycompany/tf_batalhanaval/TF_BatalhaNaval
```

## Padrões de Projeto e Princípios de Design

### Padrões de Projeto Utilizados:

1. **Singleton**: Utilizado na classe `Game` para garantir que apenas uma instância do jogo seja criada durante a execução.
2. **Command**: Implementado na classe `AtaquePosicao` para encapsular solicitações como objetos, permitindo que os clientes parametrize solicitações com diferentes operações.
3. **Factory Method**: Utilizado na classe `NavioFactoryImpl` para fornecer uma interface para criar instâncias de objetos de classe `Navio` sem especificar suas classes concretas.
4. **Observer**: Implementado através da interface `GameObserver` para permitir que observadores sejam notificados sobre eventos relacionados ao jogo.

### Princípios de Design Aplicados:

1. **Single Responsibility Principle (SRP)**: Cada classe tem uma única responsabilidade bem definida. Por exemplo, a classe `Game` é responsável por gerenciar o estado do jogo e as regras, enquanto a classe `TF_BatalhaNaval` cuida da interface gráfica do usuário.
2. **Open/Closed Principle (OCP)**: O código é projetado para ser aberto para extensão, mas fechado para modificação. Isso é alcançado usando interfaces e classes abstratas, permitindo que novos comportamentos sejam adicionados sem alterar o código existente.
3. **Dependency Inversion Principle (DIP)**: As dependências são injetadas por meio de interfaces, não de implementações concretas. Isso facilita a troca de implementações e melhora a testabilidade e a flexibilidade do código.
