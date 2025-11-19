/**
 */
package pt.isep.edom.mq.yabl;

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
 *   <li>{@link pt.isep.edom.mq.yabl.Rule#getName <em>Name</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Rule#getType <em>Type</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Rule#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Rule#getCommands <em>Commands</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Rule#getDepencencies <em>Depencencies</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Rule#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see pt.isep.edom.mq.yabl.YablPackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see pt.isep.edom.mq.yabl.YablPackage#getRule_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link pt.isep.edom.mq.yabl.Rule#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see pt.isep.edom.mq.yabl.YablPackage#getRule_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link pt.isep.edom.mq.yabl.Rule#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.yabl.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see pt.isep.edom.mq.yabl.YablPackage#getRule_Attributes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Property> getAttributes();

	/**
	 * Returns the value of the '<em><b>Commands</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.yabl.Command}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commands</em>' containment reference list.
	 * @see pt.isep.edom.mq.yabl.YablPackage#getRule_Commands()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Command> getCommands();

	/**
	 * Returns the value of the '<em><b>Depencencies</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.yabl.File}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depencencies</em>' containment reference list.
	 * @see pt.isep.edom.mq.yabl.YablPackage#getRule_Depencencies()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<File> getDepencencies();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.yabl.File}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference list.
	 * @see pt.isep.edom.mq.yabl.YablPackage#getRule_Target()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<File> getTarget();

} // Rule
