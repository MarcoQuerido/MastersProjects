/**
 */
package pt.isep.edom.mq.yabl;

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
 *   <li>{@link pt.isep.edom.mq.yabl.Command#getName <em>Name</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Command#getCommandline <em>Commandline</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Command#getModified <em>Modified</em>}</li>
 * </ul>
 *
 * @see pt.isep.edom.mq.yabl.YablPackage#getCommand()
 * @model
 * @generated
 */
public interface Command extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see pt.isep.edom.mq.yabl.YablPackage#getCommand_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link pt.isep.edom.mq.yabl.Command#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Commandline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commandline</em>' attribute.
	 * @see #setCommandline(String)
	 * @see pt.isep.edom.mq.yabl.YablPackage#getCommand_Commandline()
	 * @model
	 * @generated
	 */
	String getCommandline();

	/**
	 * Sets the value of the '{@link pt.isep.edom.mq.yabl.Command#getCommandline <em>Commandline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Commandline</em>' attribute.
	 * @see #getCommandline()
	 * @generated
	 */
	void setCommandline(String value);

	/**
	 * Returns the value of the '<em><b>Modified</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.yabl.Prefix}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modified</em>' containment reference list.
	 * @see pt.isep.edom.mq.yabl.YablPackage#getCommand_Modified()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Prefix> getModified();

} // Command
