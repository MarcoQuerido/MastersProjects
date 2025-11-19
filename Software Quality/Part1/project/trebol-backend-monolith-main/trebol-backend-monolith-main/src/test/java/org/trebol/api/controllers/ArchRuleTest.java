package org.trebol.api.controllers;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(packages = "org.trebol")
public class ArchRuleTest {


  /*Layer
  This fitness function checks that the architecture is properly layered and that the Controller layer may not be accessed by any other layer,
  the Service layer may only be accessed by the Controller layer,
  and the Repository layer may only be accessed by the Service layer.*/
  @ArchTest
  public static final ArchRule layeredArchitecture = layeredArchitecture().consideringOnlyDependenciesInLayers()
    .layer("Controller").definedBy("..controllers..")
    .layer("Service").definedBy("..services..")
    .layer("Repository").definedBy("..repositories..")
    .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
    .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
    .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service");

  /*Cycle
  This fitness function checks that there are no cycles in the dependencies between packages that match the pattern ..(services).(*)...
  This checks that there are no circular dependencies between different services packages.*/
  @ArchTest
  public static final ArchRule noCyclesInPackageDependencies =
    slices().matching("..(org.trebol).(*)..").should().beFreeOfCycles();

}
