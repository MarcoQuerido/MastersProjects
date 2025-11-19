## Report

#### Questions

- Q1
  * How does the constraints support of your tool compares to EMF and Ecore?

OCL provides a modeling language that allows the behavior to be embedded within the structural metamodels or provided as a complement to those meta-models. As a modeling language, OCL understands the models and so OCL code is much more compact than the equivalent Java. OCL code can be statically checked, whereas the corresponding Java code often uses reflection and so cannot be checked.
Eclipse OCL is an implementation of the OMG OCL 2.4 specification for use with Ecore and UML metamodels.

- Q2
  * The tool supports a language similar to OCL (a DSL for constraints)? Or constrains
are specified in code (in a GPL)?

Acceleo 3 implements the MTL standard, and provides a query language similar to OCL (with some extensions). It provides relatively good static validation and auto-completion when editing your expressions, but AQL is even better, and faster. For new modelers, prefer AQL over Acceleo/MTL.


- Q3
  * What APIs are available to validate "programmatically" models in your tool? How do they compare to EMF?

The OCLinEcore language provides a textual Concrete Syntax that makes both Ecore and OCL accessible to users. Examples may be found in OCLinEcore Library Metamodel and OCLinEcore Helpers.
The OCLinEcore tooling provides a rich editing environment based on Xtext with strong semantic checking.
OCLinEcore is more than just an editor for OCL in Ecore, it is useful for
• providing a coherent textual view of an Ecore meta-model
• providing syntax sugar for some Ecore conventions
• editing and validating OCL
• integrating OCL into Ecore

- Q4
  * Does the tool have support to interactively execute queries on models (instances)? How does it compare to the query expressions of OCL?

Eclipse OCL supports OCL execution
• interactive entry and evaluation using the Interactive OCL console.
• programmatic entry and evaluation using the Java API
EMF support for generated models enables OCL execution of
• constraints, operation bodies and property initializers using the Java API
EMF support for dynamic models enables OCL execution of
• constraints using the Validation Delegate API
• operation bodies using the Invocation Delegate API
• property initializers using the Setting Delegate API
• queries using the Query Delegate API
