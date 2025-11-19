<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:91c63eac-19f9-4b4b-b3df-7633ec0f1de0(MPS.sandbox)">
  <persistence version="9" />
  <languages>
    <use id="f78b8ab8-521b-4f70-bdf8-686edee277b6" name="YABL" version="0" />
    <engage id="f78b8ab8-521b-4f70-bdf8-686edee277b6" name="YABL" />
  </languages>
  <imports />
  <registry>
    <language id="f78b8ab8-521b-4f70-bdf8-686edee277b6" name="YABL">
      <concept id="6132472644918541701" name="YABL.structure.Project" flags="ng" index="1ecpr$">
        <property id="8836922485660052584" name="name" index="VNI96" />
        <property id="6132472644918620670" name="version" index="1ed_Ev" />
        <child id="6132472644918620872" name="tasks" index="1ed_AD" />
        <child id="6132472644918620835" name="properties" index="1ed_B2" />
        <child id="6132472644918620837" name="settings" index="1ed_B4" />
        <child id="6132472644918620849" name="builds" index="1ed_Bg" />
        <child id="6132472644918620855" name="extensionPoints" index="1ed_Bm" />
        <child id="6132472644918620862" name="scripts" index="1ed_Bv" />
        <child id="400737634310317671" name="rules" index="1gJtaA" />
      </concept>
      <concept id="6132472644918620768" name="YABL.structure.File" flags="ng" index="1ed_$1">
        <property id="6132472644918620769" name="filename" index="1ed_$0" />
        <child id="6132472644918620907" name="depends" index="1ed_Aa" />
        <child id="6132472644918620911" name="functions" index="1ed_Ae" />
      </concept>
      <concept id="6132472644918620771" name="YABL.structure.Prerequisite" flags="ng" index="1ed_$2">
        <property id="8836922485660052582" name="name" index="VNI98" />
        <child id="6132472644918620929" name="wildcards" index="1ed_xw" />
      </concept>
      <concept id="6132472644918620772" name="YABL.structure.Model" flags="ng" index="1ed_$5">
        <child id="6132472644918620970" name="projects" index="1ed_xb" />
      </concept>
      <concept id="6132472644918620775" name="YABL.structure.Task" flags="ng" index="1ed_$6">
        <property id="8836922485660052604" name="name" index="VNI9i" />
        <property id="6132472644918620778" name="description" index="1ed_$b" />
        <property id="6132472644918620781" name="group" index="1ed_$c" />
        <property id="6132472644918620785" name="enable" index="1ed_$g" />
        <child id="6132472644918620981" name="defaultTask" index="1ed_xk" />
        <child id="6132472644918620984" name="actions" index="1ed_xp" />
        <child id="6132472644918620988" name="attributes" index="1ed_xt" />
      </concept>
      <concept id="6132472644918620774" name="YABL.structure.DefaultTask" flags="ng" index="1ed_$7">
        <property id="8836922485660052561" name="name" index="VNI9Z" />
      </concept>
      <concept id="6132472644918620791" name="YABL.structure.Action" flags="ng" index="1ed_$m">
        <property id="8836922485660052551" name="name" index="VNI9D" />
        <property id="6132472644918620794" name="description" index="1ed_$r" />
        <property id="6132472644918620797" name="type" index="1ed_$s" />
      </concept>
      <concept id="6132472644918620790" name="YABL.structure.Script" flags="ng" index="1ed_$n">
        <property id="8836922485660052593" name="name" index="VNI9v" />
        <child id="6132472644918620977" name="task" index="1ed_xg" />
      </concept>
      <concept id="6132472644918620750" name="YABL.structure.Build" flags="ng" index="1ed_$J">
        <property id="8836922485660052555" name="name" index="VNI9_" />
        <property id="6132472644918620751" name="group" index="1ed_$I" />
        <property id="6132472644918620753" name="version" index="1ed_$K" />
        <child id="6132472644918620881" name="methods" index="1ed_AK" />
        <child id="6132472644918620883" name="dependencies" index="1ed_AM" />
        <child id="6132472644918620886" name="repositories" index="1ed_AR" />
        <child id="6132472644918620890" name="plugins" index="1ed_AV" />
      </concept>
      <concept id="6132472644918620756" name="YABL.structure.Dependency" flags="ng" index="1ed_$P">
        <property id="8836922485660052563" name="name" index="VNI9X" />
        <property id="6132472644918620759" name="version" index="1ed_$Q" />
      </concept>
      <concept id="6132472644918620762" name="YABL.structure.Repository" flags="ng" index="1ed_$V">
        <property id="8836922485660052589" name="name" index="VNI93" />
      </concept>
      <concept id="6132472644918620765" name="YABL.structure.Function" flags="ng" index="1ed_$W">
        <property id="8836922485660052568" name="name" index="VNI9Q" />
        <property id="6132472644918620766" name="variables" index="1ed_$Z" />
      </concept>
      <concept id="6132472644918620713" name="YABL.structure.Command" flags="ng" index="1ed__8">
        <property id="8836922485660052559" name="name" index="VNI9x" />
        <child id="6132472644918620801" name="contains" index="1ed_Bw" />
        <child id="6132472644918620803" name="modified" index="1ed_By" />
      </concept>
      <concept id="6132472644918620714" name="YABL.structure.StatusCode" flags="ng" index="1ed__b">
        <property id="8836922485660052598" name="name" index="VNI9o" />
        <property id="6132472644918620715" name="id" index="1ed__a" />
        <property id="6132472644918620717" name="description" index="1ed__c" />
      </concept>
      <concept id="6132472644918620727" name="YABL.structure.ExtensionPoint" flags="ng" index="1ed__m">
        <property id="8836922485660052566" name="name" index="VNI9S" />
        <child id="6132472644918620968" name="targets" index="1ed_x9" />
      </concept>
      <concept id="6132472644918620726" name="YABL.structure.Prefix" flags="ng" index="1ed__n">
        <property id="8836922485660052580" name="name" index="VNI9a" />
      </concept>
      <concept id="6132472644918620729" name="YABL.structure.Wildcard" flags="ng" index="1ed__o">
        <property id="8836922485660052609" name="name" index="VNIaJ" />
        <property id="6132472644918620730" name="wildcards" index="1ed__r" />
        <child id="6132472644918620914" name="functions" index="1ed_Aj" />
        <child id="6132472644918620918" name="files" index="1ed_An" />
      </concept>
      <concept id="6132472644918620728" name="YABL.structure.Target" flags="ng" index="1ed__p">
        <property id="8836922485660052602" name="name" index="VNI9k" />
        <child id="6132472644918620933" name="attributes" index="1ed_x$" />
        <child id="6132472644918620945" name="prerequisites" index="1ed_xK" />
      </concept>
      <concept id="6132472644918620732" name="YABL.structure.Plugin" flags="ng" index="1ed__t">
        <property id="8836922485660052576" name="name" index="VNI9e" />
        <property id="6132472644918620738" name="type" index="1ed_$z" />
        <property id="6132472644918620733" name="id" index="1ed__s" />
      </concept>
      <concept id="6132472644918620673" name="YABL.structure.Setting" flags="ng" index="1ed__w">
        <property id="8836922485660052595" name="name" index="VNI9t" />
        <property id="5202072230014779518" name="description" index="3HLv_v" />
      </concept>
      <concept id="6132472644918620677" name="YABL.structure.Property" flags="ng" index="1ed__$">
        <property id="8836922485660052587" name="name" index="VNI95" />
        <child id="6132472644918620833" name="attributes" index="1ed_B0" />
      </concept>
      <concept id="6132472644918620678" name="YABL.structure.Parameters" flags="ng" index="1ed__B">
        <property id="8836922485660052573" name="name" index="VNI9N" />
        <property id="6132472644918620681" name="value" index="1ed__C" />
      </concept>
      <concept id="6132472644918620685" name="YABL.structure.Rule" flags="ng" index="1ed__G">
        <property id="8836922485660052591" name="name" index="VNI91" />
        <child id="6132472644918620808" name="commands" index="1ed_BD" />
        <child id="6132472644918620810" name="attributes" index="1ed_BF" />
        <child id="6132472644918620813" name="dependencies" index="1ed_BG" />
        <child id="6132472644918620817" name="target" index="1ed_BK" />
      </concept>
      <concept id="6132472644918620684" name="YABL.structure.Method" flags="ng" index="1ed__H">
        <property id="8836922485660052571" name="name" index="VNI9P" />
      </concept>
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ng" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="1ed_$5" id="7Ez3yT1_Qw5">
    <property role="TrG5h" value="Model" />
    <node concept="1ecpr$" id="7Ez3yT1_Qw6" role="1ed_xb">
      <property role="1ed_Ev" value="1" />
      <property role="VNI96" value="Project" />
      <node concept="1ed__G" id="7Ez3yT1_QwY" role="1gJtaA">
        <property role="VNI91" value="Rl1" />
        <node concept="1ed__8" id="7Ez3yT1_QwZ" role="1ed_BD">
          <property role="VNI9x" value="Cmd1" />
          <node concept="1ed__b" id="7Ez3yT1_Qx0" role="1ed_Bw">
            <property role="VNI9o" value="Sc1" />
            <property role="1ed__a" value="1" />
            <property role="1ed__c" value="sc1" />
          </node>
          <node concept="1ed__n" id="7Ez3yT1_Qx1" role="1ed_By">
            <property role="VNI9a" value="Pfx1" />
          </node>
        </node>
        <node concept="1ed__$" id="7Ez3yT1_Qx2" role="1ed_BF">
          <property role="VNI95" value="Ppt1" />
          <node concept="1ed__B" id="7Ez3yT1_Qxg" role="1ed_B0">
            <property role="VNI9N" value="Name" />
            <property role="1ed__C" value="banana" />
          </node>
        </node>
        <node concept="1ed_$1" id="7Ez3yT1_Qx3" role="1ed_BG">
          <property role="1ed_$0" value="Fl1" />
          <node concept="1ed_$W" id="7Ez3yT1_Qx4" role="1ed_Ae">
            <property role="VNI9Q" value="Function1" />
            <property role="1ed_$Z" value="argv" />
          </node>
        </node>
        <node concept="1ed_$1" id="7Ez3yT1_Qx5" role="1ed_BK">
          <property role="1ed_$0" value="Fl1" />
          <node concept="1ed_$W" id="7Ez3yT1_Qx6" role="1ed_Ae">
            <property role="VNI9Q" value="Function1" />
            <property role="1ed_$Z" value="argv" />
          </node>
        </node>
      </node>
      <node concept="1ed_$6" id="7Ez3yT1_QwQ" role="1ed_AD">
        <property role="VNI9i" value="Tsk1" />
        <property role="1ed_$b" value="task_1" />
        <property role="1ed_$c" value="group_test" />
        <property role="1ed_$g" value="true" />
        <node concept="1ed__B" id="7Ez3yT1_QwW" role="1ed_xt">
          <property role="VNI9N" value="Pmt1" />
          <property role="1ed__C" value="1" />
        </node>
        <node concept="1ed_$m" id="7Ez3yT1_QwU" role="1ed_xp">
          <property role="VNI9D" value="Action1" />
          <property role="1ed_$r" value="action1" />
          <property role="1ed_$s" value="Action_type" />
        </node>
        <node concept="1ed_$7" id="7Ez3yT1_QwR" role="1ed_xk">
          <property role="VNI9Z" value="Tsk1" />
        </node>
      </node>
      <node concept="1ed__m" id="7Ez3yT1_Qwm" role="1ed_Bm">
        <property role="VNI9S" value="Expt1" />
        <node concept="1ed__p" id="7Ez3yT1_Qwo" role="1ed_x9">
          <property role="VNI9k" value="Target1" />
          <node concept="1ed_$2" id="7Ez3yT1_Qww" role="1ed_xK">
            <property role="VNI98" value="Pr1" />
            <node concept="1ed__o" id="7Ez3yT1_Qwy" role="1ed_xw">
              <property role="VNIaJ" value="Wc1" />
              <property role="1ed__r" value="wc1" />
              <node concept="1ed_$W" id="7Ez3yT1_Qwz" role="1ed_Aj">
                <property role="VNI9Q" value="Function1" />
                <property role="1ed_$Z" value="argv" />
              </node>
              <node concept="1ed_$1" id="7Ez3yT1_Qw$" role="1ed_An">
                <property role="1ed_$0" value="Fl1" />
                <node concept="1ed_$W" id="7Ez3yT1_Qw_" role="1ed_Ae">
                  <property role="VNI9Q" value="Function1" />
                  <property role="1ed_$Z" value="argv" />
                </node>
              </node>
            </node>
          </node>
          <node concept="1ed__B" id="7Ez3yT1_Qws" role="1ed_x$">
            <property role="VNI9N" value="Dir" />
            <property role="1ed__C" value="C:\User" />
          </node>
        </node>
      </node>
      <node concept="1ed__$" id="7Ez3yT1_Qwa" role="1ed_B2">
        <property role="VNI95" value="Property1" />
        <node concept="1ed__B" id="7Ez3yT1_Qwc" role="1ed_B0">
          <property role="VNI9N" value="Dir" />
          <property role="1ed__C" value="C:\User" />
        </node>
      </node>
      <node concept="1ed__w" id="7Ez3yT1_Qw7" role="1ed_B4">
        <property role="VNI9t" value="Setting" />
        <property role="3HLv_v" value="setting_desc" />
      </node>
      <node concept="1ed_$J" id="7Ez3yT1_Qw8" role="1ed_Bg">
        <property role="VNI9_" value="First_build" />
        <property role="1ed_$I" value="group_test" />
        <property role="1ed_$K" value="1" />
        <node concept="1ed__t" id="7Ez3yT1_Qwk" role="1ed_AV">
          <property role="VNI9e" value="Plugin" />
          <property role="1ed__s" value="1" />
          <property role="1ed_$z" value="Test plugin" />
        </node>
        <node concept="1ed_$V" id="7Ez3yT1_Qwi" role="1ed_AR">
          <property role="VNI93" value="Repo1" />
        </node>
        <node concept="1ed_$P" id="7Ez3yT1_Qwg" role="1ed_AM">
          <property role="VNI9X" value="Depend1" />
          <property role="1ed_$Q" value="1" />
        </node>
        <node concept="1ed__H" id="7Ez3yT1_Qwe" role="1ed_AK">
          <property role="VNI9P" value="Method1" />
        </node>
      </node>
      <node concept="1ed_$n" id="7Ez3yT1_Qw9" role="1ed_Bv">
        <property role="VNI9v" value="Sc1" />
        <node concept="1ed_$6" id="7Ez3yT1_QwE" role="1ed_xg">
          <property role="VNI9i" value="Tsk1" />
          <property role="1ed_$b" value="task_1" />
          <property role="1ed_$c" value="group_test" />
          <property role="1ed_$g" value="true" />
          <node concept="1ed__B" id="7Ez3yT1_QwO" role="1ed_xt">
            <property role="VNI9N" value="Pmt1" />
            <property role="1ed__C" value="1" />
          </node>
          <node concept="1ed_$m" id="7Ez3yT1_QwI" role="1ed_xp">
            <property role="VNI9D" value="Action1" />
            <property role="1ed_$r" value="action1" />
            <property role="1ed_$s" value="Action_type" />
          </node>
          <node concept="1ed_$7" id="7Ez3yT1_QwF" role="1ed_xk">
            <property role="VNI9Z" value="Tsk1" />
          </node>
        </node>
      </node>
    </node>
  </node>
  <node concept="1ed_$5" id="3EhzfI1kNPX">
    <property role="TrG5h" value="Java_Model" />
    <node concept="1ecpr$" id="3EhzfI1kNPY" role="1ed_xb">
      <property role="VNI96" value="JavaProject" />
      <property role="1ed_Ev" value="1" />
      <node concept="1ed__G" id="3EhzfI1kNQc" role="1gJtaA">
        <property role="VNI91" value="Build" />
        <node concept="1ed__8" id="3EhzfI1kNQd" role="1ed_BD">
          <property role="VNI9x" value="BuildCommand" />
          <node concept="1ed__b" id="3EhzfI1kNQe" role="1ed_Bw">
            <property role="VNI9o" value="SC1" />
            <property role="1ed__a" value="1" />
            <property role="1ed__c" value="Status code 1" />
          </node>
          <node concept="1ed__n" id="3EhzfI1kNQf" role="1ed_By">
            <property role="VNI9a" value="Prefix1" />
          </node>
        </node>
        <node concept="1ed__$" id="3EhzfI1kNQg" role="1ed_BF">
          <property role="VNI95" value="Property" />
          <node concept="1ed__B" id="3EhzfI1kNR_" role="1ed_B0">
            <property role="VNI9N" value="GradlewBuild" />
            <property role="1ed__C" value="gradlew build" />
          </node>
        </node>
        <node concept="1ed_$1" id="3EhzfI1kNQh" role="1ed_BG">
          <property role="1ed_$0" value="JarFile" />
          <node concept="1ed_$W" id="3EhzfI1kNQi" role="1ed_Ae">
            <property role="VNI9Q" value="Main" />
            <property role="1ed_$Z" value="argv" />
          </node>
          <node concept="1ed_$W" id="3EhzfI1n6Nw" role="1ed_Ae">
            <property role="VNI9Q" value="Gets" />
            <property role="1ed_$Z" value="string" />
          </node>
        </node>
        <node concept="1ed_$1" id="3EhzfI1kNQj" role="1ed_BK">
          <property role="1ed_$0" value="Class1" />
          <node concept="1ed_$W" id="3EhzfI1kNQk" role="1ed_Ae">
            <property role="VNI9Q" value="Main" />
            <property role="1ed_$Z" value="argv" />
          </node>
        </node>
        <node concept="1ed_$1" id="3EhzfI1kNQ$" role="1ed_BK">
          <property role="1ed_$0" value="Class2" />
          <node concept="1ed_$W" id="3EhzfI1kNQ_" role="1ed_Ae">
            <property role="VNI9Q" value="Gets" />
            <property role="1ed_$Z" value="string" />
          </node>
        </node>
      </node>
      <node concept="1ed_$6" id="3EhzfI1kNQ2" role="1ed_AD">
        <property role="VNI9i" value="DeleteTempTask" />
        <property role="1ed_$b" value="This task will delete temporary files" />
        <property role="1ed_$c" value="java.group" />
        <property role="1ed_$g" value="true" />
        <node concept="1ed__B" id="3EhzfI1n6OP" role="1ed_xt">
          <property role="VNI9N" value="GradleCleanTmp" />
          <property role="1ed__C" value="gradlew cleanBuildCache" />
        </node>
        <node concept="1ed_$m" id="3EhzfI1kNQ6" role="1ed_xp">
          <property role="VNI9D" value="DeleTempFiles" />
          <property role="1ed_$r" value="This action deletes temporary files" />
          <property role="1ed_$s" value="Delete" />
        </node>
        <node concept="1ed_$7" id="3EhzfI1kNQ8" role="1ed_xk">
          <property role="VNI9Z" value="DeleteTempTask" />
        </node>
      </node>
      <node concept="1ed__w" id="3EhzfI1kNPZ" role="1ed_B4">
        <property role="VNI9t" value="Setting1" />
        <property role="3HLv_v" value="setting1 description" />
      </node>
      <node concept="1ed_$J" id="3EhzfI1kNQ0" role="1ed_Bg">
        <property role="VNI9_" value="Build1" />
        <property role="1ed_$I" value="java.group" />
        <property role="1ed_$K" value="1" />
      </node>
      <node concept="1ed_$n" id="3EhzfI1kNQ1" role="1ed_Bv">
        <property role="VNI9v" value="Sc1" />
      </node>
    </node>
  </node>
  <node concept="1ed_$5" id="3EhzfI1n6Nz">
    <property role="TrG5h" value="C_Model" />
    <node concept="1ecpr$" id="3EhzfI1n6NC" role="1ed_xb">
      <property role="VNI96" value="CProject" />
      <property role="1ed_Ev" value="1" />
      <node concept="1ed__G" id="3EhzfI1n6ND" role="1gJtaA">
        <property role="VNI91" value="Build" />
        <node concept="1ed__8" id="3EhzfI1n6NE" role="1ed_BD">
          <property role="VNI9x" value="BuildCommand" />
          <node concept="1ed__b" id="3EhzfI1n6NF" role="1ed_Bw">
            <property role="VNI9o" value="SC1" />
            <property role="1ed__a" value="1" />
            <property role="1ed__c" value="Status code 1" />
          </node>
          <node concept="1ed__n" id="3EhzfI1n6NG" role="1ed_By">
            <property role="VNI9a" value="Prefix1" />
          </node>
        </node>
        <node concept="1ed__$" id="3EhzfI1n6NH" role="1ed_BF">
          <property role="VNI95" value="Property" />
          <node concept="1ed__B" id="3EhzfI1n6NI" role="1ed_B0">
            <property role="VNI9N" value="MakeBuild" />
            <property role="1ed__C" value="cc -c" />
          </node>
        </node>
        <node concept="1ed_$1" id="3EhzfI1n6NJ" role="1ed_BG">
          <property role="1ed_$0" value="LibFile" />
          <node concept="1ed_$W" id="3EhzfI1n6NK" role="1ed_Ae">
            <property role="VNI9Q" value="Function1" />
            <property role="1ed_$Z" value="argv" />
          </node>
        </node>
        <node concept="1ed_$1" id="3EhzfI1n6NM" role="1ed_BK">
          <property role="1ed_$0" value="Cfile1" />
          <node concept="1ed_$1" id="3EhzfI1n6Oz" role="1ed_Aa">
            <property role="1ed_$0" value="CHeaderfile1" />
            <node concept="1ed_$W" id="3EhzfI1n6O$" role="1ed_Ae">
              <property role="VNI9Q" value="Main" />
              <property role="1ed_$Z" value="argv" />
            </node>
          </node>
          <node concept="1ed_$W" id="3EhzfI1n6NN" role="1ed_Ae">
            <property role="VNI9Q" value="Main" />
            <property role="1ed_$Z" value="argv" />
          </node>
        </node>
        <node concept="1ed_$1" id="3EhzfI1n6NO" role="1ed_BK">
          <property role="1ed_$0" value="Cfile2" />
          <node concept="1ed_$1" id="3EhzfI1n6OJ" role="1ed_Aa">
            <property role="1ed_$0" value="CHeaderfile1" />
            <node concept="1ed_$W" id="3EhzfI1n6OK" role="1ed_Ae">
              <property role="VNI9Q" value="Gets" />
              <property role="1ed_$Z" value="string" />
            </node>
          </node>
          <node concept="1ed_$W" id="3EhzfI1n6NP" role="1ed_Ae">
            <property role="VNI9Q" value="Gets" />
            <property role="1ed_$Z" value="string" />
          </node>
        </node>
        <node concept="1ed_$1" id="3EhzfI1n6Oh" role="1ed_BK">
          <property role="1ed_$0" value="CHeaderfile1" />
          <node concept="1ed_$W" id="3EhzfI1n6Oi" role="1ed_Ae">
            <property role="VNI9Q" value="Main" />
            <property role="1ed_$Z" value="argv" />
          </node>
        </node>
        <node concept="1ed_$1" id="3EhzfI1n6Op" role="1ed_BK">
          <property role="1ed_$0" value="CHeaderfile2" />
          <node concept="1ed_$W" id="3EhzfI1n6Oq" role="1ed_Ae">
            <property role="VNI9Q" value="Gets" />
            <property role="1ed_$Z" value="string" />
          </node>
        </node>
      </node>
      <node concept="1ed_$6" id="3EhzfI1n6NQ" role="1ed_AD">
        <property role="VNI9i" value="DeleteTempTask" />
        <property role="1ed_$b" value="This task will delete temporary files" />
        <property role="1ed_$c" value="c.group" />
        <property role="1ed_$g" value="true" />
        <node concept="1ed__B" id="3EhzfI1n6ON" role="1ed_xt">
          <property role="VNI9N" value="MakeDeleteTemp" />
          <property role="1ed__C" value="rm temp" />
        </node>
        <node concept="1ed_$m" id="3EhzfI1n6NR" role="1ed_xp">
          <property role="VNI9D" value="DeleTempFiles" />
          <property role="1ed_$r" value="This action deletes temporary files" />
          <property role="1ed_$s" value="Delete" />
        </node>
        <node concept="1ed_$7" id="3EhzfI1n6NS" role="1ed_xk">
          <property role="VNI9Z" value="DeleteTempTask" />
        </node>
      </node>
      <node concept="1ed__w" id="3EhzfI1n6NT" role="1ed_B4">
        <property role="VNI9t" value="Setting1" />
        <property role="3HLv_v" value="setting1 description" />
      </node>
      <node concept="1ed_$J" id="3EhzfI1n6NU" role="1ed_Bg">
        <property role="VNI9_" value="Build1" />
        <property role="1ed_$I" value="c.group" />
        <property role="1ed_$K" value="1" />
      </node>
      <node concept="1ed_$n" id="3EhzfI1n6NV" role="1ed_Bv">
        <property role="VNI9v" value="Sc1" />
      </node>
    </node>
  </node>
</model>

