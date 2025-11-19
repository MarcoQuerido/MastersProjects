# EDOM Project, Part 2, Tool 1

In this folder you should add **all** artifacts developed for part 2 of the EDOM Project, related to tool 1.

You should also include in this file the report for this part of the project (only for tool 1).

**Note:** If for some reason you need to bypass these guidelines please ask for directions with your teacher and **always** state the exceptions in your commits and issues in bitbucket.

## Activity 1: Design Concrete Syntax for the DSL

### Implemetantion of the syntax of the metamodel
Para a implementação da sintaxe do metamodelo (Structure, no caso do MPS) foi usada a funcionalidade Editor, existente no MPS. Esta tem como objetivo de conseguirmos implementar cada um dos "Concept" da Structure com uma representação personalizada.

Podemos visualizar na seguinte imagem a implementação do editor do Concept *Project*.

![Project Editor](./img/editorMPS.png)

Foi necessário implementar, para cada um dos conceitos, um Editor semelhante ao referido acima. Assim, esta implementação segue as regras definidas pela equipa (criar uma dsl textual, semelhante ao JSON). Tendo como exemplo:


    Model: {
        name = "YABL",
        project = Project {
            name = name,
            version = version,
            attributes = Tasks:
                            Task {
                                name = name,
                                description = description,
                                group = group,
                                enabled = enabled,
                                action = Actions:
                                            Action {
                                                name = name,
                                                description = description,
                                                type = type
                                            },
                                attributes = Parameters:
                                                Parameters {
                                                    name = name,
                                                    value = value
                                                },
                                task = Task,
                                script = Scripts:
                                            Script {
                                                name = name
                                            } 
                            }
        }
    }

 ## Implementation of the syntax of Java Model   

![New](./img/textualDsl.png)

## Activity 2: Specify Common Features for Applications of the Domain

Esta é uma parte que está explicada na parte da equipa.

## Activity 3: Implement Prototypes of Applications of the Domain

Nesta Atividade, o objetivo era implementar um protótipo simples. No meu caso eu tentei criar um protótipo para um projeto Java e C.

## Activity 4: Identify Commonality and Variability in the Code

Esta é uma parte que está explicada na parte da equipa.

Para este protótipo existem diferentes menus de apresentação que são feitos em cascade menu, e como saída existe a opção de voltar para trás até sair da aplicação.

## Activity 5: Design and Implement Code Generation

Para geração de código na ferramenta MPS, foi necessário recorrer à funcionalidade Generator existente na ferramenta.

Esta funcionalidade permite definir como é que cada classe é gerada e que "Concept" deve ter como input, permitindo deste modo, aceder a todas as propriedades deste "Concept".
De modo a ser possível aceder ao modelo, a ferramenta disponibiliza diversos "Macros". Com isto, conseguimos interagir com o "Structure" criado. No âmbito deste projeto foram implementados 2 tipos de macros:

* Macros de LOOP, estes permitem iterar sobre relações de algo para muitos. Como por exemplo, é possível percorrer todos os atributos de um Model:
![Loop Macro](./img/Loop_Macro.png)

* Macros de Property, estes permitem aceder ao valor de uma determinada propriedade;
![Property Macro](./img/Property_Macro.PNG)

* Macros de If, estes permitem adicionar código com base se uma condição é verdadeira ou não:
![If Macro](./img/If_Macro.PNG)

## Activity 6: Generate Applications

## Limitations

Os principais problemas encontrados na geração de código em MPS são os seguintes:

* A geração de código gera corretamente as classes java em questão, no entanto, estas ficam guardadas em ficheiros .mps que apresentam a estrutura .xml, como tal, de forma a poder executar o projeto fora da IDE do MPS, foi necessário copiar o conteúdo de cada classe gerada para um ficheiro .java colocando este ficheiro no diretório pretendido.
