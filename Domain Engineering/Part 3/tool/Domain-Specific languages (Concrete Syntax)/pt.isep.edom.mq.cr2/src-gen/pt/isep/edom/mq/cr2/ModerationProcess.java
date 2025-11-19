/**
 */
package pt.isep.edom.mq.cr2;

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
 *   <li>{@link pt.isep.edom.mq.cr2.ModerationProcess#getName <em>Name</em>}</li>
 *   <li>{@link pt.isep.edom.mq.cr2.ModerationProcess#isCanDelete <em>Can Delete</em>}</li>
 *   <li>{@link pt.isep.edom.mq.cr2.ModerationProcess#getStep <em>Step</em>}</li>
 *   <li>{@link pt.isep.edom.mq.cr2.ModerationProcess#getStartStop <em>Start Stop</em>}</li>
 * </ul>
 *
 * @see pt.isep.edom.mq.cr2.Cr2Package#getModerationProcess()
 * @model
 * @generated
 */
public interface ModerationProcess extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see pt.isep.edom.mq.cr2.Cr2Package#getModerationProcess_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link pt.isep.edom.mq.cr2.ModerationProcess#getName <em>Name</em>}' attribute.
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
	 * @see pt.isep.edom.mq.cr2.Cr2Package#getModerationProcess_CanDelete()
	 * @model
	 * @generated
	 */
	boolean isCanDelete();

	/**
	 * Sets the value of the '{@link pt.isep.edom.mq.cr2.ModerationProcess#isCanDelete <em>Can Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Can Delete</em>' attribute.
	 * @see #isCanDelete()
	 * @generated
	 */
	void setCanDelete(boolean value);

	/**
	 * Returns the value of the '<em><b>Step</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.cr2.Step}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step</em>' containment reference list.
	 * @see pt.isep.edom.mq.cr2.Cr2Package#getModerationProcess_Step()
	 * @model containment="true"
	 * @generated
	 */
	EList<Step> getStep();

	/**
	 * Returns the value of the '<em><b>Start Stop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Stop</em>' reference.
	 * @see #setStartStop(ValidationStep)
	 * @see pt.isep.edom.mq.cr2.Cr2Package#getModerationProcess_StartStop()
	 * @model required="true"
	 * @generated
	 */
	ValidationStep getStartStop();

	/**
	 * Sets the value of the '{@link pt.isep.edom.mq.cr2.ModerationProcess#getStartStop <em>Start Stop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Stop</em>' reference.
	 * @see #getStartStop()
	 * @generated
	 */
	void setStartStop(ValidationStep value);

} // ModerationProcess
