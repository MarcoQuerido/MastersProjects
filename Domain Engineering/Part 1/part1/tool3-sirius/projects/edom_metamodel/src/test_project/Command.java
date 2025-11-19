/**
 */
package test_project;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link test_project.Command#getCommandline <em>Commandline</em>}</li>
 *   <li>{@link test_project.Command#getModified <em>Modified</em>}</li>
 *   <li>{@link test_project.Command#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see test_project.Test_projectPackage#getCommand()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='stringSizeBetween3And15 mustHaveStatusCode'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot stringSizeBetween3And15='self.commandline.size() &gt; 3 and self.commandline.size() &lt; 15' mustHaveStatusCode='not self.commandline.oclIsUndefined() implies not self.contains.id.oclIsUndefined()'"
 * @generated
 */
public interface Command extends EObject {
	/**
	 * Returns the value of the '<em><b>Commandline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commandline</em>' attribute.
	 * @see #setCommandline(String)
	 * @see test_project.Test_projectPackage#getCommand_Commandline()
	 * @model
	 * @generated
	 */
	String getCommandline();

	/**
	 * Sets the value of the '{@link test_project.Command#getCommandline <em>Commandline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Commandline</em>' attribute.
	 * @see #getCommandline()
	 * @generated
	 */
	void setCommandline(String value);

	/**
	 * Returns the value of the '<em><b>Modified</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.Prefix}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modified</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getCommand_Modified()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Prefix> getModified();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see test_project.Test_projectPackage#getCommand_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link test_project.Command#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Command
