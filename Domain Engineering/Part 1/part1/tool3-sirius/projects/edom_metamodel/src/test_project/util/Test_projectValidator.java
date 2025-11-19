/**
 */
package test_project.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import test_project.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see test_project.Test_projectPackage
 * @generated
 */
public class Test_projectValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final Test_projectValidator INSTANCE = new Test_projectValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "test_project";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Test_projectValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return Test_projectPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case Test_projectPackage.TASK:
				return validateTask((Task)value, diagnostics, context);
			case Test_projectPackage.ACTION:
				return validateAction((Action)value, diagnostics, context);
			case Test_projectPackage.PROJECT:
				return validateProject((Project)value, diagnostics, context);
			case Test_projectPackage.PARAMETERS:
				return validateParameters((Parameters)value, diagnostics, context);
			case Test_projectPackage.PROPERTY:
				return validateProperty((Property)value, diagnostics, context);
			case Test_projectPackage.RULE:
				return validateRule((Rule)value, diagnostics, context);
			case Test_projectPackage.DESCRIPTION:
				return validateDescription((Description)value, diagnostics, context);
			case Test_projectPackage.BUILD:
				return validateBuild((Build)value, diagnostics, context);
			case Test_projectPackage.REPOSITORY:
				return validateRepository((Repository)value, diagnostics, context);
			case Test_projectPackage.PLUGIN:
				return validatePlugin((Plugin)value, diagnostics, context);
			case Test_projectPackage.DEPENDENCY:
				return validateDependency((Dependency)value, diagnostics, context);
			case Test_projectPackage.METHOD:
				return validateMethod((Method)value, diagnostics, context);
			case Test_projectPackage.FUNCTION:
				return validateFunction((Function)value, diagnostics, context);
			case Test_projectPackage.FILE:
				return validateFile((File)value, diagnostics, context);
			case Test_projectPackage.MODEL:
				return validateModel((Model)value, diagnostics, context);
			case Test_projectPackage.COMMAND:
				return validateCommand((Command)value, diagnostics, context);
			case Test_projectPackage.PREFIX:
				return validatePrefix((Prefix)value, diagnostics, context);
			case Test_projectPackage.SCRIPT:
				return validateScript((Script)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTask(Task task, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(task, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(task, diagnostics, context);
		if (result || diagnostics != null) result &= validateTask_mustHaveNameAndUpperCase(task, diagnostics, context);
		if (result || diagnostics != null) result &= validateTask_stringSizeBetween3And15(task, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the mustHaveNameAndUpperCase constraint of '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String TASK__MUST_HAVE_NAME_AND_UPPER_CASE__EEXPRESSION = "not self.name.oclIsUndefined() and self.name.substring(1, 1).toUpper().compareTo(self.name.substring(1,1))=0";

	/**
	 * Validates the mustHaveNameAndUpperCase constraint of '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTask_mustHaveNameAndUpperCase(Task task, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.TASK,
				 task,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "mustHaveNameAndUpperCase",
				 TASK__MUST_HAVE_NAME_AND_UPPER_CASE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the stringSizeBetween3And15 constraint of '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String TASK__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION = "(self.name.size() > 3 and self.name.size() < 15) and (self.description.size() > 3 \n" +
		"\t\t\tand self.description.size() < 15) and (self.group.size() > 3 and self.group.size() < 15) ";

	/**
	 * Validates the stringSizeBetween3And15 constraint of '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTask_stringSizeBetween3And15(Task task, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.TASK,
				 task,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "stringSizeBetween3And15",
				 TASK__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAction(Action action, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(action, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(action, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(action, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(action, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(action, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(action, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(action, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(action, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(action, diagnostics, context);
		if (result || diagnostics != null) result &= validateAction_mustHaveNameAndUpperCase(action, diagnostics, context);
		if (result || diagnostics != null) result &= validateAction_stringSizeBetween3And15(action, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the mustHaveNameAndUpperCase constraint of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ACTION__MUST_HAVE_NAME_AND_UPPER_CASE__EEXPRESSION = "not self.name.oclIsUndefined() and self.name.substring(1, 1).toUpper().compareTo(self.name.substring(1,1))=0";

	/**
	 * Validates the mustHaveNameAndUpperCase constraint of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAction_mustHaveNameAndUpperCase(Action action, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.ACTION,
				 action,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "mustHaveNameAndUpperCase",
				 ACTION__MUST_HAVE_NAME_AND_UPPER_CASE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the stringSizeBetween3And15 constraint of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ACTION__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION = "(self.name.size() > 3 and self.name.size() < 15) and (self.description.size() > 3 and self.description.size() < 15)\n" +
		"\t\t\tand (self.type.size() > 3 and self.type.size() < 15)";

	/**
	 * Validates the stringSizeBetween3And15 constraint of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAction_stringSizeBetween3And15(Action action, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.ACTION,
				 action,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "stringSizeBetween3And15",
				 ACTION__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProject(Project project, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(project, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(project, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(project, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(project, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(project, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(project, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(project, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(project, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(project, diagnostics, context);
		if (result || diagnostics != null) result &= validateProject_mustHaveNameAndUpperCase(project, diagnostics, context);
		if (result || diagnostics != null) result &= validateProject_mustHaveVersion(project, diagnostics, context);
		if (result || diagnostics != null) result &= validateProject_stringSizeBetween3And15(project, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the mustHaveNameAndUpperCase constraint of '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String PROJECT__MUST_HAVE_NAME_AND_UPPER_CASE__EEXPRESSION = "not self.name.oclIsUndefined() and self.name.substring(1, 1).toUpper().compareTo(self.name.substring(1,1))=0";

	/**
	 * Validates the mustHaveNameAndUpperCase constraint of '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProject_mustHaveNameAndUpperCase(Project project, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.PROJECT,
				 project,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "mustHaveNameAndUpperCase",
				 PROJECT__MUST_HAVE_NAME_AND_UPPER_CASE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the mustHaveVersion constraint of '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String PROJECT__MUST_HAVE_VERSION__EEXPRESSION = "not self.version.oclIsUndefined()";

	/**
	 * Validates the mustHaveVersion constraint of '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProject_mustHaveVersion(Project project, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.PROJECT,
				 project,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "mustHaveVersion",
				 PROJECT__MUST_HAVE_VERSION__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the stringSizeBetween3And15 constraint of '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String PROJECT__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION = "(self.name.size() > 3 and self.name.size() < 15)";

	/**
	 * Validates the stringSizeBetween3And15 constraint of '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProject_stringSizeBetween3And15(Project project, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.PROJECT,
				 project,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "stringSizeBetween3And15",
				 PROJECT__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameters(Parameters parameters, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(parameters, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(parameters, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(parameters, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(parameters, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(parameters, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(parameters, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(parameters, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(parameters, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(parameters, diagnostics, context);
		if (result || diagnostics != null) result &= validateParameters_mustHaveNameAndUpperCase(parameters, diagnostics, context);
		if (result || diagnostics != null) result &= validateParameters_stringSizeBetween3And15(parameters, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the mustHaveNameAndUpperCase constraint of '<em>Parameters</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String PARAMETERS__MUST_HAVE_NAME_AND_UPPER_CASE__EEXPRESSION = "not self.name.oclIsUndefined() and self.name.substring(1, 1).toUpper().compareTo(self.name.substring(1,1))=0";

	/**
	 * Validates the mustHaveNameAndUpperCase constraint of '<em>Parameters</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameters_mustHaveNameAndUpperCase(Parameters parameters, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.PARAMETERS,
				 parameters,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "mustHaveNameAndUpperCase",
				 PARAMETERS__MUST_HAVE_NAME_AND_UPPER_CASE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the stringSizeBetween3And15 constraint of '<em>Parameters</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String PARAMETERS__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION = "(self.name.size() > 3 and self.name.size() < 15) and (self.value.size() > 3 and self.value.size() < 15)";

	/**
	 * Validates the stringSizeBetween3And15 constraint of '<em>Parameters</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameters_stringSizeBetween3And15(Parameters parameters, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.PARAMETERS,
				 parameters,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "stringSizeBetween3And15",
				 PARAMETERS__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty(Property property, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(property, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRule(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(rule, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(rule, diagnostics, context);
		if (result || diagnostics != null) result &= validateRule_stringSizeBetween3And15(rule, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the stringSizeBetween3And15 constraint of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String RULE__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION = "self.type.size() > 3 and self.type.size() < 15";

	/**
	 * Validates the stringSizeBetween3And15 constraint of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRule_stringSizeBetween3And15(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.RULE,
				 rule,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "stringSizeBetween3And15",
				 RULE__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDescription(Description description, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(description, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBuild(Build build, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(build, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(build, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(build, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(build, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(build, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(build, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(build, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(build, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(build, diagnostics, context);
		if (result || diagnostics != null) result &= validateBuild_mustHaveVersion(build, diagnostics, context);
		if (result || diagnostics != null) result &= validateBuild_stringSizeBetween3And15(build, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the mustHaveVersion constraint of '<em>Build</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String BUILD__MUST_HAVE_VERSION__EEXPRESSION = "not self.version.oclIsUndefined()";

	/**
	 * Validates the mustHaveVersion constraint of '<em>Build</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBuild_mustHaveVersion(Build build, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.BUILD,
				 build,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "mustHaveVersion",
				 BUILD__MUST_HAVE_VERSION__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the stringSizeBetween3And15 constraint of '<em>Build</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String BUILD__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION = "(self.group.size() > 3 and self.group.size() < 15)";

	/**
	 * Validates the stringSizeBetween3And15 constraint of '<em>Build</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBuild_stringSizeBetween3And15(Build build, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.BUILD,
				 build,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "stringSizeBetween3And15",
				 BUILD__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRepository(Repository repository, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(repository, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validateRepository_mustHaveNameAndUpperCase(repository, diagnostics, context);
		if (result || diagnostics != null) result &= validateRepository_stringSizeBetween3And15(repository, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the mustHaveNameAndUpperCase constraint of '<em>Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String REPOSITORY__MUST_HAVE_NAME_AND_UPPER_CASE__EEXPRESSION = "not self.name.oclIsUndefined() and self.name.substring(1, 1).toUpper().compareTo(self.name.substring(1,1))=0";

	/**
	 * Validates the mustHaveNameAndUpperCase constraint of '<em>Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRepository_mustHaveNameAndUpperCase(Repository repository, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.REPOSITORY,
				 repository,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "mustHaveNameAndUpperCase",
				 REPOSITORY__MUST_HAVE_NAME_AND_UPPER_CASE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the stringSizeBetween3And15 constraint of '<em>Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String REPOSITORY__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION = "self.name.size() > 3 and self.name.size() < 15";

	/**
	 * Validates the stringSizeBetween3And15 constraint of '<em>Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRepository_stringSizeBetween3And15(Repository repository, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.REPOSITORY,
				 repository,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "stringSizeBetween3And15",
				 REPOSITORY__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlugin(Plugin plugin, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(plugin, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(plugin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(plugin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(plugin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(plugin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(plugin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(plugin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(plugin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(plugin, diagnostics, context);
		if (result || diagnostics != null) result &= validatePlugin_mustHaveNameAndUpperCase(plugin, diagnostics, context);
		if (result || diagnostics != null) result &= validatePlugin_stringSizeBetween3And15(plugin, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the mustHaveNameAndUpperCase constraint of '<em>Plugin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String PLUGIN__MUST_HAVE_NAME_AND_UPPER_CASE__EEXPRESSION = "not self.name.oclIsUndefined() and self.name.substring(1, 1).toUpper().compareTo(self.name.substring(1,1))=0";

	/**
	 * Validates the mustHaveNameAndUpperCase constraint of '<em>Plugin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlugin_mustHaveNameAndUpperCase(Plugin plugin, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.PLUGIN,
				 plugin,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "mustHaveNameAndUpperCase",
				 PLUGIN__MUST_HAVE_NAME_AND_UPPER_CASE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the stringSizeBetween3And15 constraint of '<em>Plugin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String PLUGIN__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION = "(self.name.size() > 3 and self.name.size() < 15) and (self.type.size() > 3 and self.type.size() < 15)";

	/**
	 * Validates the stringSizeBetween3And15 constraint of '<em>Plugin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlugin_stringSizeBetween3And15(Plugin plugin, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.PLUGIN,
				 plugin,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "stringSizeBetween3And15",
				 PLUGIN__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependency(Dependency dependency, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(dependency, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(dependency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(dependency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(dependency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(dependency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(dependency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(dependency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(dependency, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(dependency, diagnostics, context);
		if (result || diagnostics != null) result &= validateDependency_mustHaveVersion(dependency, diagnostics, context);
		if (result || diagnostics != null) result &= validateDependency_stringSizeBetween3And15(dependency, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the mustHaveVersion constraint of '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String DEPENDENCY__MUST_HAVE_VERSION__EEXPRESSION = "not self.version.oclIsUndefined()";

	/**
	 * Validates the mustHaveVersion constraint of '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependency_mustHaveVersion(Dependency dependency, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.DEPENDENCY,
				 dependency,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "mustHaveVersion",
				 DEPENDENCY__MUST_HAVE_VERSION__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the stringSizeBetween3And15 constraint of '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String DEPENDENCY__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION = "(self.group.size() > 3 and self.group.size() < 15)";

	/**
	 * Validates the stringSizeBetween3And15 constraint of '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependency_stringSizeBetween3And15(Dependency dependency, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.DEPENDENCY,
				 dependency,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "stringSizeBetween3And15",
				 DEPENDENCY__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMethod(Method method, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(method, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(method, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(method, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(method, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(method, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(method, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(method, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(method, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(method, diagnostics, context);
		if (result || diagnostics != null) result &= validateMethod_stringSizeBetween3And15(method, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the stringSizeBetween3And15 constraint of '<em>Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String METHOD__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION = "self.property.size() > 3 and self.property.size() < 15";

	/**
	 * Validates the stringSizeBetween3And15 constraint of '<em>Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMethod_stringSizeBetween3And15(Method method, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.METHOD,
				 method,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "stringSizeBetween3And15",
				 METHOD__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunction(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(function, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(function, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunction_stringSizeBetween3And15(function, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the stringSizeBetween3And15 constraint of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String FUNCTION__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION = "self.variables.size() > 3 and self.variables.size() < 15";

	/**
	 * Validates the stringSizeBetween3And15 constraint of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunction_stringSizeBetween3And15(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.FUNCTION,
				 function,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "stringSizeBetween3And15",
				 FUNCTION__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFile(File file, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(file, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(file, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(file, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(file, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(file, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(file, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(file, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(file, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(file, diagnostics, context);
		if (result || diagnostics != null) result &= validateFile_stringSizeBetween3And15(file, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the stringSizeBetween3And15 constraint of '<em>File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String FILE__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION = "self.filename.size() > 3 and self.filename.size() < 15";

	/**
	 * Validates the stringSizeBetween3And15 constraint of '<em>File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFile_stringSizeBetween3And15(File file, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.FILE,
				 file,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "stringSizeBetween3And15",
				 FILE__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModel(Model model, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(model, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCommand(Command command, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(command, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(command, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(command, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(command, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(command, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(command, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(command, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(command, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(command, diagnostics, context);
		if (result || diagnostics != null) result &= validateCommand_stringSizeBetween3And15(command, diagnostics, context);
		if (result || diagnostics != null) result &= validateCommand_mustHaveStatusCode(command, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the stringSizeBetween3And15 constraint of '<em>Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String COMMAND__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION = "self.commandline.size() > 3 and self.commandline.size() < 15";

	/**
	 * Validates the stringSizeBetween3And15 constraint of '<em>Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCommand_stringSizeBetween3And15(Command command, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.COMMAND,
				 command,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "stringSizeBetween3And15",
				 COMMAND__STRING_SIZE_BETWEEN3_AND15__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the mustHaveStatusCode constraint of '<em>Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String COMMAND__MUST_HAVE_STATUS_CODE__EEXPRESSION = "not self.commandline.oclIsUndefined() implies not self.contains.id.oclIsUndefined()";

	/**
	 * Validates the mustHaveStatusCode constraint of '<em>Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCommand_mustHaveStatusCode(Command command, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(Test_projectPackage.Literals.COMMAND,
				 command,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "mustHaveStatusCode",
				 COMMAND__MUST_HAVE_STATUS_CODE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrefix(Prefix prefix, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(prefix, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScript(Script script, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(script, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //Test_projectValidator
