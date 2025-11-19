<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:09ad67cd-c4f3-4f5e-9b07-27c5243e5436(YABL.intentions)">
  <persistence version="9" />
  <languages>
    <use id="d7a92d38-f7db-40d0-8431-763b0c3c9f20" name="jetbrains.mps.lang.intentions" version="1" />
    <devkit ref="fbc25dd2-5da4-483a-8b19-70928e1b62d7(jetbrains.mps.devkit.general-purpose)" />
  </languages>
  <imports>
    <import index="wijr" ref="r:60a6a2c3-d2e8-4803-9f19-5038db2d7f1f(YABL.structure)" implicit="true" />
    <import index="4w20" ref="r:7bae1001-0948-4dc5-931e-758e626ae802(YABL.behavior)" implicit="true" />
  </imports>
  <registry>
    <language id="f3061a53-9226-4cc5-a443-f952ceaf5816" name="jetbrains.mps.baseLanguage">
      <concept id="1197027756228" name="jetbrains.mps.baseLanguage.structure.DotExpression" flags="nn" index="2OqwBi">
        <child id="1197027771414" name="operand" index="2Oq$k0" />
        <child id="1197027833540" name="operation" index="2OqNvi" />
      </concept>
      <concept id="1137021947720" name="jetbrains.mps.baseLanguage.structure.ConceptFunction" flags="in" index="2VMwT0">
        <child id="1137022507850" name="body" index="2VODD2" />
      </concept>
      <concept id="1070475926800" name="jetbrains.mps.baseLanguage.structure.StringLiteral" flags="nn" index="Xl_RD">
        <property id="1070475926801" name="value" index="Xl_RC" />
      </concept>
      <concept id="1068580123155" name="jetbrains.mps.baseLanguage.structure.ExpressionStatement" flags="nn" index="3clFbF">
        <child id="1068580123156" name="expression" index="3clFbG" />
      </concept>
      <concept id="1068580123136" name="jetbrains.mps.baseLanguage.structure.StatementList" flags="sn" stub="5293379017992965193" index="3clFbS">
        <child id="1068581517665" name="statement" index="3cqZAp" />
      </concept>
      <concept id="1204053956946" name="jetbrains.mps.baseLanguage.structure.IMethodCall" flags="ng" index="1ndlxa">
        <reference id="1068499141037" name="baseMethodDeclaration" index="37wK5l" />
      </concept>
    </language>
    <language id="d7a92d38-f7db-40d0-8431-763b0c3c9f20" name="jetbrains.mps.lang.intentions">
      <concept id="1192794744107" name="jetbrains.mps.lang.intentions.structure.IntentionDeclaration" flags="ig" index="2S6QgY" />
      <concept id="1192794782375" name="jetbrains.mps.lang.intentions.structure.DescriptionBlock" flags="in" index="2S6ZIM" />
      <concept id="1192795911897" name="jetbrains.mps.lang.intentions.structure.ExecuteBlock" flags="in" index="2Sbjvc" />
      <concept id="1192796902958" name="jetbrains.mps.lang.intentions.structure.ConceptFunctionParameter_node" flags="nn" index="2Sf5sV" />
      <concept id="2522969319638091381" name="jetbrains.mps.lang.intentions.structure.BaseIntentionDeclaration" flags="ig" index="2ZfUlf">
        <reference id="2522969319638198290" name="forConcept" index="2ZfgGC" />
        <child id="2522969319638198291" name="executeFunction" index="2ZfgGD" />
        <child id="2522969319638093993" name="descriptionFunction" index="2ZfVej" />
      </concept>
    </language>
    <language id="7866978e-a0f0-4cc7-81bc-4d213d9375e1" name="jetbrains.mps.lang.smodel">
      <concept id="1179409122411" name="jetbrains.mps.lang.smodel.structure.Node_ConceptMethodCall" flags="nn" index="2qgKlT" />
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ng" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="2S6QgY" id="4wLui6_Vt3G">
    <property role="TrG5h" value="GeneratePlantUml" />
    <ref role="2ZfgGC" to="wijr:5kqUQ4rbb9$" resolve="Model" />
    <node concept="2S6ZIM" id="4wLui6_Vt3H" role="2ZfVej">
      <node concept="3clFbS" id="4wLui6_Vt3I" role="2VODD2">
        <node concept="3clFbF" id="4wLui6_Vt8S" role="3cqZAp">
          <node concept="Xl_RD" id="4wLui6_Vt8R" role="3clFbG">
            <property role="Xl_RC" value="Generate PlantUml" />
          </node>
        </node>
      </node>
    </node>
    <node concept="2Sbjvc" id="4wLui6_Vt3J" role="2ZfgGD">
      <node concept="3clFbS" id="4wLui6_Vt3K" role="2VODD2">
        <node concept="3clFbF" id="4wLui6_Vtfd" role="3cqZAp">
          <node concept="2OqwBi" id="4wLui6_Vu37" role="3clFbG">
            <node concept="2Sf5sV" id="4wLui6_Vtfc" role="2Oq$k0" />
            <node concept="2qgKlT" id="4wLui6_VulY" role="2OqNvi">
              <ref role="37wK5l" to="4w20:5EguLrwD2pj" resolve="generatePlantuml" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
</model>

