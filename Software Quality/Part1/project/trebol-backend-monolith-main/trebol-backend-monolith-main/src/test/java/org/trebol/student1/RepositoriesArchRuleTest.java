package org.trebol.student1;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Repository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "org.trebol.jpa.repositories")
public class RepositoriesArchRuleTest {
  @ArchTest
  public static final ArchRule servicesShouldBeServiceImpl =
    classes().that()
      .areAnnotatedWith(Repository.class)
      .should().haveSimpleNameEndingWith("Repository");
  @ArchTest
  public static final ArchRule repositoryClassesShouldResideInRepositoryPackage =
    classes().that()
      .areAnnotatedWith(org.springframework.stereotype.Repository.class)
      .should().resideInAPackage("..repositories..");

  @ArchTest
  public static final ArchRule repositoryShouldBeAnnotatedWithRepository =
    classes().that()
      .resideInAPackage("..repositories..")
      .and()
      .haveSimpleNameNotContaining("Test")
      .should().beAnnotatedWith(Repository.class);

}
