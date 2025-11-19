# EDOM Project, Part 1, Tool 2

In this folder you should add **all** artifacts developed for part 1 of the EDOM Project, related to tool 2.

You should also include in this file the report for this part of the project (only for tool 2).

**Note:** If for some reason you need to bypass these guidelines please ask for directions with your teacher and **always** state the exceptions in your commits and issues in bitbucket.

Following there are examples of proposed sections for the report.

## Description of the Tool

Xtext é uma framework de desenvolvimento de linguagens de programação e linguagens específicas de domínios. Xtext define a sua linguagem usando uma poderosa linguagem gramatical. Como resultado obtém uma infra-estrutura completa, incluindo parser, linker, typechecker, compilador bem como suporte de edição para o Eclipse, qualquer editor que suporte o Protocolo de Servidor de Linguagem e o seu navegador web favorito.


## How to Setup and Install

Para usufruir da ferramenta XText teremos de seguir vários passos:

-Aceder a (https://www.eclipse.org/Xtext/#intro-quotes) para conhecer a ferramenta e conseguir fazer o download.
![Scheme](images/fig1.png)

-Posteriormente fazer o download do EclipseIDE através do link (https://www.eclipse.org/downloads/), de acordo com a versão que o sistema operativo suporte.

-Depois de instalado e configurado, fazer a criação de um projeto novo. Aceder à barra de cima na opção "Help" e em seguida selecionar "Install New Software" (fig2.png).
![Scheme](images/fig2.png)

-De seguida para instalar o XText no Eclipse teremos de aceder às "Releases" uma vez que, contém todos os componentes necessários e opcionais e dependências do XText.
![Scheme](images/fig3.png)

-Posteriormente, novamente dentro do Eclipse teremos de inserir o link da página anterior, "Releases"(fig.3.png), adicionando e selecionando todos os ficheiros que são disponibilizados. 

-Fazer o download de todos e confirmar.

![Scheme](images/fig4.png)

-Depois de tudo instalado é necessário reiniciar o Eclipse e assim, o XText está pronto a ser usado.

## Implementation of the Metamodel

NOTA: Antes de começar a construção do metamodel temos de confirmar se o Eclipse tem os updates necessários para fazer a modelação. Isto é, aceder a Help -> Install new Software.. -> Selecionar o caminho do Eclipse -> Modelling, instalando tudo.

-Criámos então o nosso meta modelo abrindo um novo Ecore Modeling Project criando um projeto do tipo Ecore. Ainda na criação selecionar o Design, em Select viewpoints, de forma a poder fazer a modelação do meta modelo. 

-Temos então ao nosso dispor a ferramenta pronta para desenvolver o metamodelo.

-A realização do metamodelo do grupo deverá ficar da seguinte forma:

![Scheme](images/EDOM MetaModel_XText.jpg)

## Implementation of Constraints and Refactorings

O metamodelo desenvolvido terá algumas coinstraints associadas.

*1. Como garantir que o nome não é vazio e começa por maiúsculas.

![Scheme](images/constraints1.jpg)

*2. Como garantir que a version não é vazia.

![Scheme](images/constraints2.jpg)

*3. Obrigatório ter um statusCode.

![Scheme](images/constraints3.jpg)

*4. Cada string deve ter entre 3 a 15 caracteres.

![Scheme](images/constraints4.jpg)


Posteriormente, para realizar as refactorings teremos de, dentro da localização onde foi criado o metamodelo, fazer a criação de de uma nova transformação. Para isso selecionar dentro da pasta do metamodelo, New->Others->Atl file. 
Daremos o nome ao módulo de feature2upperCase. 

![Scheme](images/atl1.jpg)

Teremos de definir o input e o output do modelo.

![Scheme](images/atl2.jpg)

Na próxima imagem está explícito um exemplo de tranformação aplicado ao nosso modelo:

![Scheme](images/atl3.jpg)

## Implementation of the Visualizations

Para visualizar o metamodelo vamos utilizar um plantUML. 

Deverá ficar da seguinte forma.

![Scheme](images/Make_puml.png)

A representação gráfica foi gerada derivado ao ficheiro do metamodelo como se pode observar.

![Scheme](images/puml1.jpg)

![Scheme](images/puml2.jpg)

## Implementation of Models (instances)

![Scheme](images/edom_activity7.jpg)

## Execution of Constraints and Refactorings

Relativamente as constraints realizadas no metamodelo:
![Scheme](images/exconstraints1.jpg)

-Erros encontrados 
 
![Scheme](images/exconstraints2.jpg)

-Feita a validação dos erros



Relativamente as constraints encontrados na implementação do Models(instances)

![Scheme](images/models_constraints.jpg)

![Scheme](images/models_constraints2.jpg)

![Scheme](images/models_constraints3.jpg)

![Scheme](images/models_constraints4.jpg)

![Scheme](images/models_constraints5.jpg)

![Scheme](images/models_constraints6.jpg)

-Sendo que os constrangimentos foram todos corrigidos e validados.

## Generation/Execution of Visualizations

![Scheme](images/uml_activity7.jpg)