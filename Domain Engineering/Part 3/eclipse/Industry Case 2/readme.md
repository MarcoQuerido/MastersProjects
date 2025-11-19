# EDOM Project, Part 3 Industry Cases (Apache Isis)


• Model-Driven Engineering

– Principles
* For instance, how they address "models+transformations=software"?

Min 2:35 - 5:51 = Application logic and demonstration 
"This framework, the way it's building a metamodel of the domain, and then it is effectively creating a representation of that domain in this user interface... the power of the metamodel"


– Model-Driven Architecture (MDA) and UML
* e.g, Are MDA or any of its principles followed?

Min 10:26 - 11:12
Ubiquitous language and the ability to iterate the application quickly according to the business person.

Min 27:08 - 31:00 
DDD principles and metamodel other uses (Security, Published Events, Auditing, Commands, Static Analysis, ElasticSearch, Metrics, OpenTracing, SequenceDiagrams)

Metamodel Download XML (Domain inferring from different versions is the same)

DCI allows behaviour to be contributed across modules within the bounded context


– Integrating MDSE in the Development Process
* e.g, How does the case relate to Domain-Driven Design?

Min 1:34 - 2:34 = Domain model example (pet clinic)
Min 2:35 - 5:51 = Application logic and demonstration 
"This framework, the way it's building a metamodel of the domain, and then it is effectively creating a representation of that domain in this user interface... the power of the metamodel"

The application is based purely on it's domain (pet clinic, pets, owners and pet visits to clinic)

* e.g., How does the case relates to Tests oriented approaches (e.g., Test-Driven Development)?

Min 22:50 - 26:51 = Testing framework supports DDD tests and throw expections (declarative and imperative business rules)
"Subcutaneous" testing 

GraphQL
 
* e.g., How does the case relates do Agile approaches?

- Constraints

Min 14:08 - 14:53 = The user can't pay with negative values nor pay above the payment value

Supporting methods are part of the metamodel, and the framework is querying the supporting methods to provide UX.

- Transformations

Min 18:46 - 20:04 = A REST Api is generated from the same metamodel that is driving the UI
Min 20:05 - 22:50 = A Swagger Api is generated as well, they're "different projections of the metamodel"
Min 34:38 - 38:38 = Merge new concepts and mix-ins into the metamodel

