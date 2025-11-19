/**
 */
package test_project;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link test_project.Project#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link test_project.Project#getName <em>Name</em>}</li>
 *   <li>{@link test_project.Project#getVersion <em>Version</em>}</li>
 *   <li>{@link test_project.Project#getProperties <em>Properties</em>}</li>
 *   <li>{@link test_project.Project#getParameters <em>Parameters</em>}</li>
 *   <li>{@link test_project.Project#getDescription <em>Description</em>}</li>
 *   <li>{@link test_project.Project#getBuild <em>Build</em>}</li>
 *   <li>{@link test_project.Project#getTargets <em>Targets</em>}</li>
 * </ul>
 *
 * @see test_project.Test_projectPackage#getProject()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='mustHaveNameAndUpperCase mustHaveVersion stringSizeBetween3And15'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot mustHaveNameAndUpperCase='not self.name.oclIsUndefined() and self.name.substring(1, 1).toUpper().compareTo(self.name.substring(1,1))=0' mustHaveVersion='not self.version.oclIsUndefined()' stringSizeBetween3And15='(self.name.size() &gt; 3 and self.name.size() &lt; 15)'"
 * @generated
 */
public interface Project extends EObject {
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.Task}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getProject_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Task> getAttributes();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see test_project.Test_projectPackage#getProject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link test_project.Project#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(int)
	 * @see test_project.Test_projectPackage#getProject_Version()
	 * @model required="true"
	 * @generated
	 */
	int getVersion();

	/**
	 * Sets the value of the '{@link test_project.Project#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(int value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getProject_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<Property> getProperties();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.Parameters}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getProject_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameters> getParameters();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' containment reference.
	 * @see #setDescription(Description)
	 * @see test_project.Test_projectPackage#getProject_Description()
	 * @model containment="true"
	 * @generated
	 */
	Description getDescription();

	/**
	 * Sets the value of the '{@link test_project.Project#getDescription <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' containment reference.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(Description value);

	/**
	 * Returns the value of the '<em><b>Build</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.Build}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Build</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getProject_Build()
	 * @model containment="true"
	 * @generated
	 */
	EList<Build> getBuild();

	/**
	 * Returns the value of the '<em><b>Targets</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.File}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targets</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getProject_Targets()
	 * @model containment="true"
	 * @generated
	 */
	EList<File> getTargets();

} // Project
