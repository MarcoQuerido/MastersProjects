/**
 */
package cr2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Moderation Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cr2.ModerationProcess#getName <em>Name</em>}</li>
 *   <li>{@link cr2.ModerationProcess#isCanDelete <em>Can Delete</em>}</li>
 *   <li>{@link cr2.ModerationProcess#getStep <em>Step</em>}</li>
 *   <li>{@link cr2.ModerationProcess#getStartStop <em>Start Stop</em>}</li>
 * </ul>
 *
 * @see cr2.Cr2Package#getModerationProcess()
 * @model annotation="gmf.node label='name' phantom='true'"
 * @generated
 */
public interface ModerationProcess extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see cr2.Cr2Package#getModerationProcess_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cr2.ModerationProcess#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Can Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Can Delete</em>' attribute.
	 * @see #setCanDelete(boolean)
	 * @see cr2.Cr2Package#getModerationProcess_CanDelete()
	 * @model required="true"
	 * @generated
	 */
	boolean isCanDelete();

	/**
	 * Sets the value of the '{@link cr2.ModerationProcess#isCanDelete <em>Can Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Can Delete</em>' attribute.
	 * @see #isCanDelete()
	 * @generated
	 */
	void setCanDelete(boolean value);

	/**
	 * Returns the value of the '<em><b>Step</b></em>' containment reference list.
	 * The list contents are of type {@link cr2.Step}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step</em>' containment reference list.
	 * @see cr2.Cr2Package#getModerationProcess_Step()
	 * @model containment="true"
	 *        annotation="gmf.compartment"
	 * @generated
	 */
	EList<Step> getStep();

	/**
	 * Returns the value of the '<em><b>Start Stop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Stop</em>' reference.
	 * @see #setStartStop(ValidationStep)
	 * @see cr2.Cr2Package#getModerationProcess_StartStop()
	 * @model required="true"
	 * @generated
	 */
	ValidationStep getStartStop();

	/**
	 * Sets the value of the '{@link cr2.ModerationProcess#getStartStop <em>Start Stop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Stop</em>' reference.
	 * @see #getStartStop()
	 * @generated
	 */
	void setStartStop(ValidationStep value);

} // ModerationProcess
