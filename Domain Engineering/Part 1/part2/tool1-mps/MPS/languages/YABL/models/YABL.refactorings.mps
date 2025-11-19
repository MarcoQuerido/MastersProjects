<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:9b5b2358-10ef-4f47-9e31-e91c89d758be(YABL.refactorings)">
  <persistence version="9" />
  <languages>
    <use id="3ecd7c84-cde3-45de-886c-135ecc69b742" name="jetbrains.mps.lang.refactoring" version="0" />
    <devkit ref="fbc25dd2-5da4-483a-8b19-70928e1b62d7(jetbrains.mps.devkit.general-purpose)" />
  </languages>
  <imports>
    <import index="wijr" ref="r:60a6a2c3-d2e8-4803-9f19-5038db2d7f1f(YABL.structure)" implicit="true" />
    <import index="wyt6" ref="6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.lang(JDK/)" implicit="true" />
  </imports>
  <registry>
    <language id="f3061a53-9226-4cc5-a443-f952ceaf5816" name="jetbrains.mps.baseLanguage">
      <concept id="1215693861676" name="jetbrains.mps.baseLanguage.structure.BaseAssignmentExpression" flags="nn" index="d038R">
        <child id="1068498886297" name="rValue" index="37vLTx" />
        <child id="1068498886295" name="lValue" index="37vLTJ" />
      </concept>
      <concept id="1202948039474" name="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" flags="nn" index="liA8E" />
      <concept id="1197027756228" name="jetbrains.mps.baseLanguage.structure.DotExpression" flags="nn" index="2OqwBi">
        <child id="1197027771414" name="operand" index="2Oq$k0" />
        <child id="1197027833540" name="operation" index="2OqNvi" />
      </concept>
      <concept id="1137021947720" name="jetbrains.mps.baseLanguage.structure.ConceptFunction" flags="in" index="2VMwT0">
        <child id="1137022507850" name="body" index="2VODD2" />
      </concept>
      <concept id="1068498886294" name="jetbrains.mps.baseLanguage.structure.AssignmentExpression" flags="nn" index="37vLTI" />
      <concept id="1225271408483" name="jetbrains.mps.baseLanguage.structure.IsNotEmptyOperation" flags="nn" index="17RvpY" />
      <concept id="1068580123155" name="jetbrains.mps.baseLanguage.structure.ExpressionStatement" flags="nn" index="3clFbF">
        <child id="1068580123156" name="expression" index="3clFbG" />
      </concept>
      <concept id="1068580123159" name="jetbrains.mps.baseLanguage.structure.IfStatement" flags="nn" index="3clFbJ">
        <child id="1068580123160" name="condition" index="3clFbw" />
        <child id="1068580123161" name="ifTrue" index="3clFbx" />
      </concept>
      <concept id="1068580123136" name="jetbrains.mps.baseLanguage.structure.StatementList" flags="sn" stub="5293379017992965193" index="3clFbS">
        <child id="1068581517665" name="statement" index="3cqZAp" />
      </concept>
      <concept id="1068580320020" name="jetbrains.mps.baseLanguage.structure.IntegerConstant" flags="nn" index="3cmrfG">
        <property id="1068580320021" name="value" index="3cmrfH" />
      </concept>
      <concept id="1068581242875" name="jetbrains.mps.baseLanguage.structure.PlusExpression" flags="nn" index="3cpWs3" />
      <concept id="1204053956946" name="jetbrains.mps.baseLanguage.structure.IMethodCall" flags="ng" index="1ndlxa">
        <reference id="1068499141037" name="baseMethodDeclaration" index="37wK5l" />
        <child id="1068499141038" name="actualArgument" index="37wK5m" />
      </concept>
      <concept id="1081773326031" name="jetbrains.mps.baseLanguage.structure.BinaryOperation" flags="nn" index="3uHJSO">
        <child id="1081773367579" name="rightExpression" index="3uHU7w" />
        <child id="1081773367580" name="leftExpression" index="3uHU7B" />
      </concept>
      <concept id="1073239437375" name="jetbrains.mps.baseLanguage.structure.NotEqualsExpression" flags="nn" index="3y3z36" />
      <concept id="1080120340718" name="jetbrains.mps.baseLanguage.structure.AndExpression" flags="nn" index="1Wc70l" />
    </language>
    <language id="3ecd7c84-cde3-45de-886c-135ecc69b742" name="jetbrains.mps.lang.refactoring">
      <concept id="7953996722066252915" name="jetbrains.mps.lang.refactoring.structure.NodeOperation" flags="nn" index="50M6j" />
      <concept id="7953996722066256458" name="jetbrains.mps.lang.refactoring.structure.RefactoringContext_ConceptFunctionParameter" flags="nn" index="50NuE" />
      <concept id="6895093993902236229" name="jetbrains.mps.lang.refactoring.structure.Refactoring" flags="ig" index="3SMa$L">
        <child id="6895093993902236381" name="doRefactorBlock" index="3SMaAD" />
        <child id="6895093993902310998" name="target" index="3SM$Oy" />
      </concept>
      <concept id="6895093993902310764" name="jetbrains.mps.lang.refactoring.structure.NodeTarget" flags="ng" index="3SM$So">
        <reference id="6895093993902310806" name="concept" index="3SM$Vy" />
      </concept>
      <concept id="1189694053795" name="jetbrains.mps.lang.refactoring.structure.DoRefactorClause" flags="in" index="3ZiDMR" />
    </language>
    <language id="7866978e-a0f0-4cc7-81bc-4d213d9375e1" name="jetbrains.mps.lang.smodel">
      <concept id="1138056022639" name="jetbrains.mps.lang.smodel.structure.SPropertyAccess" flags="nn" index="3TrcHB">
        <reference id="1138056395725" name="property" index="3TsBF5" />
      </concept>
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ng" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="3SMa$L" id="19P3joH9xxj">
    <property role="TrG5h" value="Task_Refactor" />
    <node concept="3ZiDMR" id="19P3joH9xxl" role="3SMaAD">
      <node concept="3clFbS" id="19P3joH9xxm" role="2VODD2">
        <node concept="3clFbJ" id="19P3joH9$so" role="3cqZAp">
          <node concept="3clFbS" id="19P3joH9$sq" role="3clFbx">
            <node concept="3clFbF" id="19P3joH9JgE" role="3cqZAp">
              <node concept="37vLTI" id="19P3joH9KqP" role="3clFbG">
                <node concept="3cpWs3" id="19P3joH9MPj" role="37vLTx">
                  <node concept="2OqwBi" id="19P3joH9NYd" role="3uHU7w">
                    <node concept="2OqwBi" id="19P3joH9NGP" role="2Oq$k0">
                      <node concept="2OqwBi" id="19P3joH9NfY" role="2Oq$k0">
                        <node concept="50NuE" id="19P3joH9MZv" role="2Oq$k0" />
                        <node concept="50M6j" id="19P3joH9Nz_" role="2OqNvi" />
                      </node>
                      <node concept="3TrcHB" id="19P3joH9NRu" role="2OqNvi">
                        <ref role="3TsBF5" to="wijr:7Ez3yT1ruLW" resolve="name" />
                      </node>
                    </node>
                    <node concept="liA8E" id="19P3joH9OAc" role="2OqNvi">
                      <ref role="37wK5l" to="wyt6:~String.substring(int)" resolve="substring" />
                      <node concept="3cmrfG" id="19P3joH9OKT" role="37wK5m">
                        <property role="3cmrfH" value="1" />
                      </node>
                    </node>
                  </node>
                  <node concept="2OqwBi" id="19P3joH9L3S" role="3uHU7B">
                    <node concept="2OqwBi" id="19P3joH9KTG" role="2Oq$k0">
                      <node concept="2OqwBi" id="19P3joH9KLo" role="2Oq$k0">
                        <node concept="50NuE" id="19P3joH9K$7" role="2Oq$k0" />
                        <node concept="50M6j" id="19P3joH9KT7" role="2OqNvi" />
                      </node>
                      <node concept="3TrcHB" id="19P3joH9L1y" role="2OqNvi">
                        <ref role="3TsBF5" to="wijr:7Ez3yT1ruLW" resolve="name" />
                      </node>
                    </node>
                    <node concept="liA8E" id="19P3joH9LG1" role="2OqNvi">
                      <ref role="37wK5l" to="wyt6:~String.substring(int,int)" resolve="substring" />
                      <node concept="3cmrfG" id="19P3joH9LLM" role="37wK5m">
                        <property role="3cmrfH" value="0" />
                      </node>
                      <node concept="3cmrfG" id="19P3joH9M$_" role="37wK5m">
                        <property role="3cmrfH" value="1" />
                      </node>
                    </node>
                  </node>
                </node>
                <node concept="2OqwBi" id="19P3joH9JQo" role="37vLTJ">
                  <node concept="2OqwBi" id="19P3joH9Jrz" role="2Oq$k0">
                    <node concept="50NuE" id="19P3joH9JgD" role="2Oq$k0" />
                    <node concept="50M6j" id="19P3joH9JFS" role="2OqNvi" />
                  </node>
                  <node concept="3TrcHB" id="19P3joH9K5Y" role="2OqNvi">
                    <ref role="3TsBF5" to="wijr:7Ez3yT1ruLW" resolve="name" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node concept="1Wc70l" id="19P3joHfsrt" role="3clFbw">
            <node concept="2OqwBi" id="19P3joH9_$a" role="3uHU7B">
              <node concept="2OqwBi" id="19P3joH9$WT" role="2Oq$k0">
                <node concept="2OqwBi" id="19P3joH9$Eb" role="2Oq$k0">
                  <node concept="50NuE" id="19P3joH9$t9" role="2Oq$k0" />
                  <node concept="50M6j" id="19P3joH9$NI" role="2OqNvi" />
                </node>
                <node concept="3TrcHB" id="19P3joH9_bR" role="2OqNvi">
                  <ref role="3TsBF5" to="wijr:7Ez3yT1ruLW" resolve="name" />
                </node>
              </node>
              <node concept="17RvpY" id="19P3joHfsnD" role="2OqNvi" />
            </node>
            <node concept="3y3z36" id="19P3joHfv$8" role="3uHU7w">
              <node concept="2OqwBi" id="19P3joHfy_o" role="3uHU7w">
                <node concept="2OqwBi" id="19P3joHfxgu" role="2Oq$k0">
                  <node concept="2OqwBi" id="19P3joHfwNR" role="2Oq$k0">
                    <node concept="2OqwBi" id="19P3joHfwjo" role="2Oq$k0">
                      <node concept="50NuE" id="19P3joHfvSH" role="2Oq$k0" />
                      <node concept="50M6j" id="19P3joHfwtK" role="2OqNvi" />
                    </node>
                    <node concept="3TrcHB" id="19P3joHfx7R" role="2OqNvi">
                      <ref role="3TsBF5" to="wijr:7Ez3yT1ruLW" resolve="name" />
                    </node>
                  </node>
                  <node concept="liA8E" id="19P3joHfy6W" role="2OqNvi">
                    <ref role="37wK5l" to="wyt6:~String.substring(int,int)" resolve="substring" />
                    <node concept="3cmrfG" id="19P3joHf$z0" role="37wK5m">
                      <property role="3cmrfH" value="0" />
                    </node>
                    <node concept="3cmrfG" id="19P3joHf_rK" role="37wK5m">
                      <property role="3cmrfH" value="1" />
                    </node>
                  </node>
                </node>
                <node concept="liA8E" id="19P3joHfyXk" role="2OqNvi">
                  <ref role="37wK5l" to="wyt6:~String.toUpperCase()" resolve="toUpperCase" />
                </node>
              </node>
              <node concept="2OqwBi" id="19P3joHfu6R" role="3uHU7B">
                <node concept="2OqwBi" id="19P3joHftxE" role="2Oq$k0">
                  <node concept="2OqwBi" id="19P3joHft4T" role="2Oq$k0">
                    <node concept="50NuE" id="19P3joHfsPO" role="2Oq$k0" />
                    <node concept="50M6j" id="19P3joHftlF" role="2OqNvi" />
                  </node>
                  <node concept="3TrcHB" id="19P3joHftHh" role="2OqNvi">
                    <ref role="3TsBF5" to="wijr:7Ez3yT1ruLW" resolve="name" />
                  </node>
                </node>
                <node concept="liA8E" id="19P3joHfuEA" role="2OqNvi">
                  <ref role="37wK5l" to="wyt6:~String.substring(int,int)" resolve="substring" />
                  <node concept="3cmrfG" id="19P3joHfz6c" role="37wK5m">
                    <property role="3cmrfH" value="0" />
                  </node>
                  <node concept="3cmrfG" id="19P3joHf$0p" role="37wK5m">
                    <property role="3cmrfH" value="1" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node concept="3SM$So" id="19P3joH9xxn" role="3SM$Oy">
      <ref role="3SM$Vy" to="wijr:5kqUQ4rbb9B" resolve="Task" />
    </node>
  </node>
</model>

