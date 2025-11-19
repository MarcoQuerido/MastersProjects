/**
 */
package test_project;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link test_project.Function#getVariables <em>Variables</em>}</li>
 *   <li>{@link test_project.Function#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see test_project.Test_projectPackage#getFunction()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='stringSizeBetween3And15'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot stringSizeBetween3And15='self.variables.size() &gt; 3 and self.variables.size() &lt; 15'"
 * @generated
 */
public interface Function extends EObject {
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' attribute.
	 * @see #setVariables(String)
	 * @see test_project.Test_projectPackage#getFunction_Variables()
	 * @model
	 * @generated
	 */
	String getVariables();

	/**
	 * Sets the value of the '{@link test_project.Function#getVariables <em>Variables</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variables</em>' attribute.
	 * @see #getVariables()
	 * @generated
	 */
	void setVariables(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see test_project.Test_projectPackage#getFunction_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link test_project.Function#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Function
