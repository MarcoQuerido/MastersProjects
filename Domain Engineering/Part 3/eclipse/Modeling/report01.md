## Report

#### Questions

- Q1
  * How do the modeling concepts of your tool compare to EMF and Ecore? What are the options available for creating metamodels?

Sirius relies heavily on the Eclipse platform, and reuses (and extends) many of the standard Eclipse frameworks, in particular the Eclipse Modeling Platform. It has the same base modeling concepts of EMF and Ecore (create, edit and visualize EMF models) and is composed of a set of Eclipse editors (diagrams, tables and trees). It allows the user to create many types of metamodels, like Ecore Models, Ecore Modeling Projects, EMF Generator Models and EMF Projects.

- Q2
  * How does code generation for the model compares between EMF and your tool? If the tool does not generate code explain how it works.

EMF allows the user to generate code from existing models (Generate Model Code, Edit Code and Editor Code options), creating a class for every concept of the model.
Sirius's code generation. Sirius's code generation works the same way.

- Q3
  * What APIs are available to manage models in your tool? How they compare to EMF?

The central concept of Sirius’s API is the Session. In Sirius, all data are stored in EMF models: the semantic models themselves obviously, but also the representations (diagrams, tables) and the viewpoint configuration (the Viewpoint Specification Models). A session is a wrapper around a Transactional Editing Domain and its Resource Set. It ensures the consistency of the models inside the editing domain, from the platform’s point of view; for example it makes sure the representation files correctly reference all the semantic models they need to in order to handle the representations in the session. The session also provides high-level, Sirius-specific services through its own APIs and support classes and interfaces.
In the standard UI, each Modeling Project corresponds to exactly one Session, and each session contains its own Editing Domain and Resource Set. This means that sessions (and thus modeling projects) are isolated from each other.
The representation files ( *.aird files) can be though as the serialized form of a Session, and symmetrically a session is the runtime incarnation of a representation file (or more precisely of the unique top-level representation file in a modeling project).

- Q4
  * How models are persisted in your tool? How does it compare to EMF?

EMF allows to store the model content via the EMF persistence framework. EMF provides XMI and XML persistence provider. By default EMF uses XMI (XML Metadata Interchange).
Sirius's model persistence works the same way.


