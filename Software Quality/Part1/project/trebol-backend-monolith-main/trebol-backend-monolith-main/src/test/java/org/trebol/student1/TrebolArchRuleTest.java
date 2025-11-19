package org.trebol.student1;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Repository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(packages = "org.trebol")
public class TrebolArchRuleTest {

  @ArchTest
  public static final ArchRule classesShouldBeFreeOfCycles = slices().matching("org.trebol.(*)..").should().beFreeOfCycles();

  @ArchTest
  public static final ArchRule layeredArchitecture =
    layeredArchitecture().consideringOnlyDependenciesInLayers()
    .layer("Controller").definedBy("org.trebol.api.controllers..")
    .layer("Service").definedBy("org.trebol.api.services.impl..")
    .layer("Repository").definedBy("org.trebol.jpa.repositories..")
    .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
    .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
    .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service");

  @ArchTest
  public static final ArchRule repositoriesShouldNotDependOnEachOther =
    noClasses().that()
      .resideInAnyPackage("org.trebol.jpa.repositories..")
      .and()
      .haveSimpleNameNotContaining("Test")
      .and()
      .areNotInterfaces()
      .should().dependOnClassesThat().resideInAnyPackage("org.trebol.api.services.impl..", "org.trebol.api.controllers..")
      .allowEmptyShould(true);

  @ArchTest
  public static final ArchRule controllersShouldDependsOnServicesAndRepositories =
    classes().that()
      .resideInAnyPackage("org.trebol.api.controllers..")
      .and()
      .haveSimpleNameNotContaining("Test")
      .and()
      .areNotInterfaces()
      .should().dependOnClassesThat().resideInAnyPackage("org.trebol.api.services.impl..", "org.trebol.jpa.repositories..");

  @ArchTest
  public static final ArchRule serviceShouldDependsOnRepository =
    classes().that()
      .resideInAPackage("org.trebol.api.services.impl..")
      .and()
      .areNotInterfaces()
      .and()
      .haveSimpleNameEndingWith("ServiceImpl")
      .and()
      .haveSimpleNameNotContaining("Test")
      .should().dependOnClassesThat().resideInAnyPackage("org.trebol.jpa.repositories..");
}
