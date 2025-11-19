/**
 */
package test_project;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link test_project.Rule#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link test_project.Rule#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link test_project.Rule#getTarget <em>Target</em>}</li>
 *   <li>{@link test_project.Rule#getCommands <em>Commands</em>}</li>
 *   <li>{@link test_project.Rule#getType <em>Type</em>}</li>
 *   <li>{@link test_project.Rule#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see test_project.Test_projectPackage#getRule()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='stringSizeBetween3And15'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot stringSizeBetween3And15='self.type.size() &gt; 3 and self.type.size() &lt; 15'"
 * @generated
 */
public interface Rule extends EObject {
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getRule_Attributes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Property> getAttributes();

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.File}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getRule_Dependencies()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<File> getDependencies();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.File}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getRule_Target()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<File> getTarget();

	/**
	 * Returns the value of the '<em><b>Commands</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.Command}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commands</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getRule_Commands()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Command> getCommands();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see test_project.Test_projectPackage#getRule_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link test_project.Rule#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see test_project.Test_projectPackage#getRule_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link test_project.Rule#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Rule
