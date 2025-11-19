<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:60a6a2c3-d2e8-4803-9f19-5038db2d7f1f(YABL.structure)">
  <persistence version="9" />
  <languages>
    <use id="c72da2b9-7cce-4447-8389-f407dc1158b7" name="jetbrains.mps.lang.structure" version="9" />
    <devkit ref="fbc25dd2-5da4-483a-8b19-70928e1b62d7(jetbrains.mps.devkit.general-purpose)" />
  </languages>
  <imports>
    <import index="tpck" ref="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" implicit="true" />
  </imports>
  <registry>
    <language id="c72da2b9-7cce-4447-8389-f407dc1158b7" name="jetbrains.mps.lang.structure">
      <concept id="1169125787135" name="jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration" flags="ig" index="PkWjJ">
        <property id="6714410169261853888" name="conceptId" index="EcuMT" />
        <child id="1071489727083" name="linkDeclaration" index="1TKVEi" />
        <child id="1071489727084" name="propertyDeclaration" index="1TKVEl" />
      </concept>
      <concept id="1169127622168" name="jetbrains.mps.lang.structure.structure.InterfaceConceptReference" flags="ig" index="PrWs8">
        <reference id="1169127628841" name="intfc" index="PrY4T" />
      </concept>
      <concept id="1071489090640" name="jetbrains.mps.lang.structure.structure.ConceptDeclaration" flags="ig" index="1TIwiD">
        <property id="1096454100552" name="rootable" index="19KtqR" />
        <reference id="1071489389519" name="extends" index="1TJDcQ" />
        <child id="1169129564478" name="implements" index="PzmwI" />
      </concept>
      <concept id="1071489288299" name="jetbrains.mps.lang.structure.structure.PropertyDeclaration" flags="ig" index="1TJgyi">
        <property id="241647608299431129" name="propertyId" index="IQ2nx" />
        <reference id="1082985295845" name="dataType" index="AX2Wp" />
      </concept>
      <concept id="1071489288298" name="jetbrains.mps.lang.structure.structure.LinkDeclaration" flags="ig" index="1TJgyj">
        <property id="1071599776563" name="role" index="20kJfa" />
        <property id="1071599893252" name="sourceCardinality" index="20lbJX" />
        <property id="1071599937831" name="metaClass" index="20lmBu" />
        <property id="241647608299431140" name="linkId" index="IQ2ns" />
        <reference id="1071599976176" name="target" index="20lvS9" />
      </concept>
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ng" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="1TIwiD" id="5kqUQ4raRQ5">
    <property role="EcuMT" value="6132472644918541701" />
    <property role="TrG5h" value="Project" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="1TJgyi" id="7Ez3yT1ruLC" role="1TKVEl">
      <property role="IQ2nx" value="8836922485660052584" />
      <property role="TrG5h" value="name" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyi" id="5kqUQ4rbb7Y" role="1TKVEl">
      <property role="IQ2nx" value="6132472644918620670" />
      <property role="TrG5h" value="version" />
      <ref role="AX2Wp" to="tpck:fKAQMTA" resolve="integer" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbbaz" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620835" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="properties" />
      <property role="20lbJX" value="fLJekj5/_0__n" />
      <ref role="20lvS9" node="5kqUQ4rbb85" resolve="Property" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbbaG" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620844" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="attributes" />
      <property role="20lbJX" value="fLJekj5/_0__n" />
      <ref role="20lvS9" node="5kqUQ4rbb86" resolve="Parameters" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbbaL" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620849" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="builds" />
      <property role="20lbJX" value="fLJekj6/_1__n" />
      <ref role="20lvS9" node="5kqUQ4rbb9e" resolve="Build" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbbb8" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620872" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="tasks" />
      <property role="20lbJX" value="fLJekj5/_0__n" />
      <ref role="20lvS9" node="5kqUQ4rbb9B" resolve="Task" />
    </node>
    <node concept="1TJgyj" id="1imttrCJPI8" role="1TKVEi">
      <property role="IQ2ns" value="1483502693153463176" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="targets" />
      <property role="20lbJX" value="fLJekj5/_0__n" />
      <ref role="20lvS9" node="5kqUQ4rbb9w" resolve="File" />
    </node>
  </node>
  <node concept="1TIwiD" id="5kqUQ4rbb85">
    <property role="EcuMT" value="6132472644918620677" />
    <property role="TrG5h" value="Property" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="1TJgyi" id="7Ez3yT1ruLF" role="1TKVEl">
      <property role="IQ2nx" value="8836922485660052587" />
      <property role="TrG5h" value="name" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbbax" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620833" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="attribute" />
      <property role="20lbJX" value="fLJekj4/_1" />
      <ref role="20lvS9" node="5kqUQ4rbb86" resolve="Parameters" />
    </node>
  </node>
  <node concept="1TIwiD" id="5kqUQ4rbb86">
    <property role="EcuMT" value="6132472644918620678" />
    <property role="TrG5h" value="Parameters" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="1TJgyi" id="7Ez3yT1ruLt" role="1TKVEl">
      <property role="IQ2nx" value="8836922485660052573" />
      <property role="TrG5h" value="name" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyi" id="5kqUQ4rbb89" role="1TKVEl">
      <property role="IQ2nx" value="6132472644918620681" />
      <property role="TrG5h" value="value" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
  </node>
  <node concept="1TIwiD" id="5kqUQ4rbb8c">
    <property role="EcuMT" value="6132472644918620684" />
    <property role="TrG5h" value="Method" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="1TJgyi" id="7Ez3yT1ruLr" role="1TKVEl">
      <property role="IQ2nx" value="8836922485660052571" />
      <property role="TrG5h" value="name" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
  </node>
  <node concept="1TIwiD" id="5kqUQ4rbb8d">
    <property role="EcuMT" value="6132472644918620685" />
    <property role="TrG5h" value="Rule" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="1TJgyi" id="7Ez3yT1ruLJ" role="1TKVEl">
      <property role="IQ2nx" value="8836922485660052591" />
      <property role="TrG5h" value="name" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbba8" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620808" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="commands" />
      <property role="20lbJX" value="fLJekj6/_1__n" />
      <ref role="20lvS9" node="5kqUQ4rbb8D" resolve="Command" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbbaa" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620810" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="attributes" />
      <property role="20lbJX" value="fLJekj5/_0__n" />
      <ref role="20lvS9" node="5kqUQ4rbb85" resolve="Property" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbbad" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620813" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="dependencies" />
      <property role="20lbJX" value="fLJekj5/_0__n" />
      <ref role="20lvS9" node="5kqUQ4rbb9w" resolve="File" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbbah" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620817" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="target" />
      <property role="20lbJX" value="fLJekj6/_1__n" />
      <ref role="20lvS9" node="5kqUQ4rbb9w" resolve="File" />
    </node>
  </node>
  <node concept="1TIwiD" id="5kqUQ4rbb8D">
    <property role="EcuMT" value="6132472644918620713" />
    <property role="TrG5h" value="Command" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="1TJgyi" id="7Ez3yT1ruLf" role="1TKVEl">
      <property role="IQ2nx" value="8836922485660052559" />
      <property role="TrG5h" value="name" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbba3" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620803" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="prefix" />
      <ref role="20lvS9" node="5kqUQ4rbb8Q" resolve="Prefix" />
    </node>
  </node>
  <node concept="1TIwiD" id="5kqUQ4rbb8Q">
    <property role="EcuMT" value="6132472644918620726" />
    <property role="TrG5h" value="Prefix" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="1TJgyi" id="7Ez3yT1ruL$" role="1TKVEl">
      <property role="IQ2nx" value="8836922485660052580" />
      <property role="TrG5h" value="name" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
  </node>
  <node concept="1TIwiD" id="5kqUQ4rbb8W">
    <property role="EcuMT" value="6132472644918620732" />
    <property role="TrG5h" value="Plugin" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="1TJgyi" id="5kqUQ4rbb8X" role="1TKVEl">
      <property role="IQ2nx" value="6132472644918620733" />
      <property role="TrG5h" value="id" />
      <ref role="AX2Wp" to="tpck:fKAQMTA" resolve="integer" />
    </node>
    <node concept="1TJgyi" id="7Ez3yT1ruLw" role="1TKVEl">
      <property role="IQ2nx" value="8836922485660052576" />
      <property role="TrG5h" value="name" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyi" id="5kqUQ4rbb92" role="1TKVEl">
      <property role="IQ2nx" value="6132472644918620738" />
      <property role="TrG5h" value="type" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
  </node>
  <node concept="1TIwiD" id="5kqUQ4rbb9e">
    <property role="EcuMT" value="6132472644918620750" />
    <property role="TrG5h" value="Build" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="1TJgyi" id="7Ez3yT1ruLb" role="1TKVEl">
      <property role="IQ2nx" value="8836922485660052555" />
      <property role="TrG5h" value="name" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyi" id="5kqUQ4rbb9f" role="1TKVEl">
      <property role="IQ2nx" value="6132472644918620751" />
      <property role="TrG5h" value="group" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyi" id="5kqUQ4rbb9h" role="1TKVEl">
      <property role="IQ2nx" value="6132472644918620753" />
      <property role="TrG5h" value="version" />
      <ref role="AX2Wp" to="tpck:fKAQMTA" resolve="integer" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbbbh" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620881" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="methods" />
      <property role="20lbJX" value="fLJekj5/_0__n" />
      <ref role="20lvS9" node="5kqUQ4rbb8c" resolve="Method" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbbbj" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620883" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="dependencies" />
      <property role="20lbJX" value="fLJekj5/_0__n" />
      <ref role="20lvS9" node="5kqUQ4rbb9k" resolve="Dependency" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbbbm" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620886" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="repositories" />
      <property role="20lbJX" value="fLJekj5/_0__n" />
      <ref role="20lvS9" node="5kqUQ4rbb9q" resolve="Repository" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbbbq" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620890" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="plugins" />
      <property role="20lbJX" value="fLJekj5/_0__n" />
      <ref role="20lvS9" node="5kqUQ4rbb8W" resolve="Plugin" />
    </node>
  </node>
  <node concept="1TIwiD" id="5kqUQ4rbb9k">
    <property role="EcuMT" value="6132472644918620756" />
    <property role="TrG5h" value="Dependency" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="1TJgyi" id="7Ez3yT1ruLj" role="1TKVEl">
      <property role="IQ2nx" value="8836922485660052563" />
      <property role="TrG5h" value="name" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyi" id="5kqUQ4rbb9n" role="1TKVEl">
      <property role="IQ2nx" value="6132472644918620759" />
      <property role="TrG5h" value="version" />
      <ref role="AX2Wp" to="tpck:fKAQMTA" resolve="integer" />
    </node>
  </node>
  <node concept="1TIwiD" id="5kqUQ4rbb9q">
    <property role="EcuMT" value="6132472644918620762" />
    <property role="TrG5h" value="Repository" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="1TJgyi" id="7Ez3yT1ruLH" role="1TKVEl">
      <property role="IQ2nx" value="8836922485660052589" />
      <property role="TrG5h" value="name" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
  </node>
  <node concept="1TIwiD" id="5kqUQ4rbb9t">
    <property role="EcuMT" value="6132472644918620765" />
    <property role="TrG5h" value="Function" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="1TJgyi" id="7Ez3yT1ruLo" role="1TKVEl">
      <property role="IQ2nx" value="8836922485660052568" />
      <property role="TrG5h" value="name" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyi" id="5kqUQ4rbb9u" role="1TKVEl">
      <property role="IQ2nx" value="6132472644918620766" />
      <property role="TrG5h" value="variables" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
  </node>
  <node concept="1TIwiD" id="5kqUQ4rbb9w">
    <property role="EcuMT" value="6132472644918620768" />
    <property role="TrG5h" value="File" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="1TJgyi" id="5kqUQ4rbb9x" role="1TKVEl">
      <property role="IQ2nx" value="6132472644918620769" />
      <property role="TrG5h" value="filename" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbbbF" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620907" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="target" />
      <property role="20lbJX" value="fLJekj5/_0__n" />
      <ref role="20lvS9" node="5kqUQ4rbb9w" resolve="File" />
    </node>
    <node concept="1TJgyj" id="19P3joH6DRE" role="1TKVEi">
      <property role="IQ2ns" value="1329983791293963754" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="prerequisites" />
      <property role="20lbJX" value="fLJekj5/_0__n" />
      <ref role="20lvS9" node="5kqUQ4rbb9w" resolve="File" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbbbJ" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620911" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="functions" />
      <property role="20lbJX" value="fLJekj6/_1__n" />
      <ref role="20lvS9" node="5kqUQ4rbb9t" resolve="Function" />
    </node>
    <node concept="1TJgyj" id="1imttrCJOeR" role="1TKVEi">
      <property role="IQ2ns" value="1483502693153457079" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="attributes" />
      <property role="20lbJX" value="fLJekj5/_0__n" />
      <ref role="20lvS9" node="5kqUQ4rbb86" resolve="Parameters" />
    </node>
  </node>
  <node concept="1TIwiD" id="5kqUQ4rbb9$">
    <property role="EcuMT" value="6132472644918620772" />
    <property role="TrG5h" value="Model" />
    <property role="19KtqR" value="true" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="1TJgyj" id="5kqUQ4rbbcE" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620970" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="projects" />
      <property role="20lbJX" value="fLJekj6/_1__n" />
      <ref role="20lvS9" node="5kqUQ4raRQ5" resolve="Project" />
    </node>
    <node concept="1TJgyj" id="1imttrCJOF0" role="1TKVEi">
      <property role="IQ2ns" value="1483502693153458880" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="rules" />
      <property role="20lbJX" value="fLJekj6/_1__n" />
      <ref role="20lvS9" node="5kqUQ4rbb8d" resolve="Rule" />
    </node>
    <node concept="PrWs8" id="5EguLrwD2_G" role="PzmwI">
      <ref role="PrY4T" to="tpck:h0TrEE$" resolve="INamedConcept" />
    </node>
  </node>
  <node concept="1TIwiD" id="5kqUQ4rbb9B">
    <property role="EcuMT" value="6132472644918620775" />
    <property role="TrG5h" value="Task" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="1TJgyi" id="7Ez3yT1ruLW" role="1TKVEl">
      <property role="IQ2nx" value="8836922485660052604" />
      <property role="TrG5h" value="name" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyi" id="5kqUQ4rbb9E" role="1TKVEl">
      <property role="IQ2nx" value="6132472644918620778" />
      <property role="TrG5h" value="description" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyi" id="5kqUQ4rbb9H" role="1TKVEl">
      <property role="IQ2nx" value="6132472644918620781" />
      <property role="TrG5h" value="group" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyi" id="5kqUQ4rbb9L" role="1TKVEl">
      <property role="IQ2nx" value="6132472644918620785" />
      <property role="TrG5h" value="enable" />
      <ref role="AX2Wp" to="tpck:fKAQMTB" resolve="boolean" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbbcN" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620979" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="script" />
      <ref role="20lvS9" node="5kqUQ4rbb9Q" resolve="Script" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbbcP" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620981" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="defaultTask" />
      <ref role="20lvS9" node="5kqUQ4rbb9B" resolve="Task" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbbcS" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620984" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="actions" />
      <property role="20lbJX" value="fLJekj5/_0__n" />
      <ref role="20lvS9" node="5kqUQ4rbb9R" resolve="Action" />
    </node>
    <node concept="1TJgyj" id="5kqUQ4rbbcW" role="1TKVEi">
      <property role="IQ2ns" value="6132472644918620988" />
      <property role="20lmBu" value="fLJjDmT/aggregation" />
      <property role="20kJfa" value="attributes" />
      <property role="20lbJX" value="fLJekj5/_0__n" />
      <ref role="20lvS9" node="5kqUQ4rbb86" resolve="Parameters" />
    </node>
  </node>
  <node concept="1TIwiD" id="5kqUQ4rbb9Q">
    <property role="EcuMT" value="6132472644918620790" />
    <property role="TrG5h" value="Script" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="1TJgyi" id="7Ez3yT1ruLL" role="1TKVEl">
      <property role="IQ2nx" value="8836922485660052593" />
      <property role="TrG5h" value="name" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
  </node>
  <node concept="1TIwiD" id="5kqUQ4rbb9R">
    <property role="EcuMT" value="6132472644918620791" />
    <property role="TrG5h" value="Action" />
    <ref role="1TJDcQ" to="tpck:gw2VY9q" resolve="BaseConcept" />
    <node concept="1TJgyi" id="7Ez3yT1ruL7" role="1TKVEl">
      <property role="IQ2nx" value="8836922485660052551" />
      <property role="TrG5h" value="name" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyi" id="5kqUQ4rbb9U" role="1TKVEl">
      <property role="IQ2nx" value="6132472644918620794" />
      <property role="TrG5h" value="description" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
    <node concept="1TJgyi" id="5kqUQ4rbb9X" role="1TKVEl">
      <property role="IQ2nx" value="6132472644918620797" />
      <property role="TrG5h" value="type" />
      <ref role="AX2Wp" to="tpck:fKAOsGN" resolve="string" />
    </node>
  </node>
</model>

