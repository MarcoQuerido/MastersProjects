## Report

#### Notes

The demo was recreated in Eclipse.
factory.egl was modified so that the generated factory.java implements changes on different Article and Comment names.
Replicating the demo on the tool, the following error shows when running an Acceleo configuration:
java.lang.IllegalStateException: Workspace is closed.

#### Questions

It is based on templates or it offers other approaches? If based on templates, explain
how its features compare to CR2. If not based on templates, explain the mechanism used
to generate text.

EGL is a template-based language (i.e. EGL programs resemble the text that they generate), and provides several features that simplify and support the generation of text from models, including:

a sophisticated and language-independent merging engine (for preserving hand-written sections of generated text);

an extensible template system (for generating text to a variety of sources, such as a file on disk, a database server, or even as a response issued by a web server);

formatting algorithms (for producing generated text that is well-formatted and hence readable), and traceability mechanisms (for linking generated text with source models).

How can you manage the possible customization of generated code so that it is not lost
when the generation process is executed again? Does the tool provides any special
support for this (e.g. protected regions) or do you have to use patterns, like in this
example?

EGL provides language constructs that allow M2T transformations to designate regions of generated text as protected. Whenever an EGL program attempts to generate text, any protected regions that are encountered in the specified destination are preserved.

Example:
[%=out.startPreserve("/*", "*/", "anId", true)%]
System.out.println(foo);
[%=out.stopPreserve()%]