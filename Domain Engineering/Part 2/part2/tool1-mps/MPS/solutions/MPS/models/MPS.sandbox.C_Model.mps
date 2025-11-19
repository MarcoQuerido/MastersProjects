<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:13542a3d-906b-46e8-9fab-902c55d91e9f(MPS.sandbox.C_Model)">
  <persistence version="9" />
  <languages>
    <use id="f78b8ab8-521b-4f70-bdf8-686edee277b6" name="YABL" version="0" />
  </languages>
  <imports />
  <registry>
    <language id="f78b8ab8-521b-4f70-bdf8-686edee277b6" name="YABL">
      <concept id="6132472644918541701" name="YABL.structure.Project" flags="ng" index="1ecpr$">
        <property id="8836922485660052584" name="name" index="VNI96" />
        <property id="6132472644918620670" name="version" index="1ed_Ev" />
        <child id="6132472644918620872" name="tasks" index="1ed_AD" />
        <child id="6132472644918620835" name="properties" index="1ed_B2" />
        <child id="6132472644918620844" name="attributes" index="1ed_Bd" />
        <child id="6132472644918620849" name="builds" index="1ed_Bg" />
      </concept>
      <concept id="6132472644918620768" name="YABL.structure.File" flags="ng" index="1ed_$1">
        <property id="6132472644918620769" name="filename" index="1ed_$0" />
        <child id="6132472644918620911" name="functions" index="1ed_Ae" />
      </concept>
      <concept id="6132472644918620772" name="YABL.structure.Model" flags="ng" index="1ed_$5">
        <child id="6132472644918620970" name="projects" index="1ed_xb" />
        <child id="1483502693153458880" name="rules" index="3WajWm" />
      </concept>
      <concept id="6132472644918620775" name="YABL.structure.Task" flags="ng" index="1ed_$6">
        <property id="8836922485660052604" name="name" index="VNI9i" />
        <property id="6132472644918620778" name="description" index="1ed_$b" />
        <property id="6132472644918620781" name="group" index="1ed_$c" />
        <child id="6132472644918620984" name="actions" index="1ed_xp" />
      </concept>
      <concept id="6132472644918620791" name="YABL.structure.Action" flags="ng" index="1ed_$m">
        <property id="8836922485660052551" name="name" index="VNI9D" />
        <property id="6132472644918620794" name="description" index="1ed_$r" />
        <property id="6132472644918620797" name="type" index="1ed_$s" />
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
        <child id="6132472644918620803" name="prefix" index="1ed_By" />
      </concept>
      <concept id="6132472644918620726" name="YABL.structure.Prefix" flags="ng" index="1ed__n">
        <property id="8836922485660052580" name="name" index="VNI9a" />
      </concept>
      <concept id="6132472644918620732" name="YABL.structure.Plugin" flags="ng" index="1ed__t">
        <property id="8836922485660052576" name="name" index="VNI9e" />
        <property id="6132472644918620738" name="type" index="1ed_$z" />
        <property id="6132472644918620733" name="id" index="1ed__s" />
      </concept>
      <concept id="6132472644918620677" name="YABL.structure.Property" flags="ng" index="1ed__$">
        <property id="8836922485660052587" name="name" index="VNI95" />
        <child id="6132472644918620833" name="attribute" index="1ed_B0" />
      </concept>
      <concept id="6132472644918620678" name="YABL.structure.Parameters" flags="ng" index="1ed__B">
        <property id="8836922485660052573" name="name" index="VNI9N" />
        <property id="6132472644918620681" name="value" index="1ed__C" />
      </concept>
      <concept id="6132472644918620685" name="YABL.structure.Rule" flags="ng" index="1ed__G">
        <property id="8836922485660052591" name="name" index="VNI91" />
        <child id="6132472644918620808" name="commands" index="1ed_BD" />
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
  <node concept="1ed_$5" id="3EhzfI1n6Nz">
    <property role="TrG5h" value="C_Model" />
    <node concept="1ecpr$" id="19P3joH$Sz4" role="1ed_xb">
      <property role="VNI96" value="Cproject" />
      <property role="1ed_Ev" value="1" />
      <node concept="1ed__$" id="19P3joHQGGk" role="1ed_B2">
        <property role="VNI95" value="Prop1" />
        <node concept="1ed__B" id="19P3joHQGGm" role="1ed_B0">
          <property role="VNI9N" value="Argv" />
          <property role="1ed__C" value="1" />
        </node>
      </node>
      <node concept="1ed_$6" id="19P3joH$Sz8" role="1ed_AD">
        <property role="VNI9i" value="Task1" />
        <property role="1ed_$b" value="Task1_desc" />
        <property role="1ed_$c" value="c.group" />
        <node concept="1ed_$m" id="19P3joHCf8A" role="1ed_xp">
          <property role="VNI9D" value="Action1" />
          <property role="1ed_$r" value="action_desc" />
          <property role="1ed_$s" value="Awesome_action" />
        </node>
      </node>
      <node concept="1ed_$J" id="19P3joH$Sz5" role="1ed_Bg">
        <property role="VNI9_" value="Build1" />
        <property role="1ed_$I" value="c.group.build" />
        <property role="1ed_$K" value="1" />
        <node concept="1ed__H" id="2$hoCtQ0xPr" role="1ed_AK">
          <property role="VNI9P" value="Method1" />
        </node>
        <node concept="1ed_$P" id="2$hoCtQ0xSj" role="1ed_AM">
          <property role="VNI9X" value="Dep1" />
          <property role="1ed_$Q" value="1" />
        </node>
        <node concept="1ed_$V" id="2$hoCtQ0y0R" role="1ed_AR">
          <property role="VNI93" value="Repo1" />
        </node>
        <node concept="1ed__t" id="2$hoCtQ0y2V" role="1ed_AV">
          <property role="VNI9e" value="Plugin1" />
          <property role="1ed__s" value="1" />
          <property role="1ed_$z" value="Plg1" />
        </node>
      </node>
      <node concept="1ed__B" id="19P3joHQGGo" role="1ed_Bd">
        <property role="VNI9N" value="Argv" />
        <property role="1ed__C" value="1" />
      </node>
    </node>
    <node concept="1ed__G" id="1imttrCOuwg" role="3WajWm">
      <property role="VNI91" value="Rule1" />
      <node concept="1ed__8" id="1imttrCOuwh" role="1ed_BD">
        <property role="VNI9x" value="Delete" />
        <node concept="1ed__n" id="2$hoCtQ9glp" role="1ed_By">
          <property role="VNI9a" value="Del" />
        </node>
      </node>
      <node concept="1ed_$1" id="1imttrCOuwi" role="1ed_BK">
        <property role="1ed_$0" value="Filename1" />
        <node concept="1ed_$W" id="1imttrCOuwj" role="1ed_Ae">
          <property role="VNI9Q" value="Func1" />
          <property role="1ed_$Z" value="argv" />
        </node>
      </node>
    </node>
  </node>
</model>

