ACME Spiele - Sistema de Gerenciamento de Contratos de Jogos

Visao Geral

ACME Spiele é uma aplicação desenvolvida em Java que implementa um sistema completo de gerenciamento de contratos e licenciamento de jogos digitais. A aplicação permite cadastrar clientes (individuais e corporativos), gerenciar um catálogo de jogos com diferentes categorias, estabelecer contratos entre clientes e jogos, e gerar relatórios operacionais.

O projeto foi desenvolvido com foco em Programação Orientada a Objetos, utilizando padrões como herança, polimorfismo e modelagem de dados estruturada.

Funcionalidades Principais

Gestão de Clientes:
- Cadastro de clientes individuais (com CPF)
- Cadastro de clientes corporativos (com CNPJ e nome fantasia)
- Atualização de dados de clientes
- Validação de números de cliente únicos

Gerenciamento de Jogos:
- Cadastro de jogos com informações de código, nome, ano de lançamento, valor por minuto
- Classificação de jogos por categorias (AVENTURA, ESTRATEGIA, CORRIDA)
- Busca de jogos por código ou categoria
- Remoção de jogos com cascata de contratos

Administração de Contratos:
- Criação de contratos entre clientes e jogos, especificando período de contratação
- Validação de clientes e jogos existentes
- Remoção de contratos associados a jogos removidos
- Busca de contratos ativos

Relatórios Operacionais:
- Listagem de todos os contratos cadastrados
- Identificação do cliente com maior valor agregado em contratos
- Busca de jogos por categoria
- Filtros por cliente e jogo

Requisitos do Sistema

Java Development Kit (JDK) versão 8 ou superior
Compilador javac
Sistema operacional com suporte a Java (Linux, Windows, macOS)

Estrutura de Diretórios

trabalho1_prog_orientada_a_objetos/Projeto/
|
+-- src/                          # Código-fonte
|   +-- Main.java                # Classe principal (ponto de entrada)
|   +-- app/
|   |   +-- ACMESpiele.java      # Lógica principal da aplicação
|   |   +-- GerenciadorIOArquivos.java  # Gerenciador de entrada/saída
|   +-- dados/
|       +-- Cliente.java          # Classe abstrata de cliente
|       +-- ClienteIndividual.java
|       +-- ClienteCorporativo.java
|       +-- Clientes.java         # Coleção de clientes
|       +-- Jogo.java            # Modelo de jogo
|       +-- Jogos.java           # Coleção de jogos
|       +-- Contrato.java        # Modelo de contrato
|       +-- Contratos.java       # Coleção de contratos
|       +-- Categoria.java       # Enumeração de categorias
|
+-- bin/                          # Arquivos compilados (.class)
|
+-- datain.txt                    # Arquivo de entrada de dados
+-- dataout.txt                   # Arquivo de saída gerado
+-- dataoutesperada.txt          # Arquivo com saída esperada (referência)
+-- README.md                     # Este arquivo

Como Compilar e Executar

Compilacao

Navegue até o diretório do projeto:

    cd Projeto

Execute o comando de compilação:

    javac -d bin src/app/*.java src/dados/*.java src/Main.java

Este comando compila todos os arquivos Java e coloca os arquivos .class no diretório bin/.

Execucao

Para executar a aplicação:

    java -cp bin Main

A aplicação lerá dados do arquivo datain.txt e gravará os resultados em dataout.txt.

Formato de Entrada e Saída

Entrada

O arquivo datain.txt contém sequências de dados estruturados em blocos:

1. Clientes Individuais (terminado por -1)
2. Clientes Corporativos (terminado por -1)
3. Cadastro de Jogos (terminado por -1)
4. Cadastro de Contratos (terminado por -1)
5. Operacoes e Consultas

Exemplo de entrada parcial:

    11
    Papaleguas
    bipbip@email.com
    111111111-11
    -1
    55
    Stark Industries Corp. Ltd.
    stark@stark.com
    55555555/0001-55
    Industrias Stark
    -1

Saida

A saída é formatada com prefixos numéricos indicando qual operação gerou cada linha:

- 1: Cadastro de cliente individual
- 2: Cadastro de cliente corporativo
- 3: Cadastro de jogo
- 4: Cadastro de contrato
- 5-10: Operações e relatórios

Exemplo de saída:

    1:11;Papaleguas;bipbip@email.com;111111111-11
    2:55;Stark Industries Corp. Ltd.;stark@stark.com;55555555/0001-55;Industrias Stark
    3:555;God of War;2000;5.5;AVENTURA
    4:1111;11;11;555
    10:11;Papaleguas;bipbip@email.com;13.2

Arquitetura

O projeto segue o paradigma de Programação Orientada a Objetos:

Hierarquia de Classes:
- Cliente (abstrata): Define interface comum para tipos de cliente
  - ClienteIndividual: Especialização para pessoa física
  - ClienteCorporativo: Especialização para pessoa jurídica

Coleções:
- Clientes, Jogos, Contratos: Gerenciam acesso e busca de entidades

Gerenciamento de I/O:
- GerenciadorIOArquivos: Abstrai leitura/escrita de arquivo e redirecionamento de stdout

Principais Operacoes Implementadas

Passo 1-4: Cadastro de dados (clientes individuais, corporativos, jogos e contratos)
Passo 5: Busca de jogo por código
Passo 6: Listar jogos de uma categoria específica
Passo 7: Atualizar nome de cliente
Passo 8: Remover jogo e seus contratos associados
Passo 9: Listar todos os contratos cadastrados
Passo 10: Identificar cliente com maior valor agregado em contratos

Tratamento de Erros

A aplicação inclui validações para:
- Números/códigos duplicados
- Clientes ou jogos inexistentes na busca
- Categorias de jogos inválidas
- Contratos órfãos após remoção de jogos

Tecnologias e Padroes

Linguagem: Java
Paradigma: Programação Orientada a Objetos
Padrões de Design:
  - Iterator Pattern: Iteração sobre coleções
  - Strategy Pattern: Especialização de tipos de cliente
  - Factory Pattern: Criação de instâncias de entidades

Autores

Pedro Henrique Barbieri (pedro-barbieri) - Desenvolvido como atividade acadêmica de Programação Orientada a Objetos.

Licenca

Este projeto é fornecido como material educacional.

