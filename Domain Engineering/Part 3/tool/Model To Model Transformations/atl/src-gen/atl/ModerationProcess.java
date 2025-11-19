/**
 */
package pt.isep.edom.atb.cr2;

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
 *   <li>{@link pt.isep.edom.atb.cr2.ModerationProcess#getName <em>Name</em>}</li>
 *   <li>{@link pt.isep.edom.atb.cr2.ModerationProcess#getStep <em>Step</em>}</li>
 *   <li>{@link pt.isep.edom.atb.cr2.ModerationProcess#getStartStep <em>Start Step</em>}</li>
 * </ul>
 *
 * @see pt.isep.edom.atb.cr2.Cr2Package#getModerationProcess()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='oneEndStepMandatory'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot oneEndStepMandatory='self.step-&gt;select(e | e.oclIsTypeOf(End))-&gt;size()=1'"
 * @generated
 */
public interface ModerationProcess extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see pt.isep.edom.atb.cr2.Cr2Package#getModerationProcess_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link pt.isep.edom.atb.cr2.ModerationProcess#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Step</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.atb.cr2.Step}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step</em>' containment reference list.
	 * @see pt.isep.edom.atb.cr2.Cr2Package#getModerationProcess_Step()
	 * @model containment="true"
	 * @generated
	 */
	EList<Step> getStep();

	/**
	 * Returns the value of the '<em><b>Start Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Step</em>' reference.
	 * @see #setStartStep(ValidationStep)
	 * @see pt.isep.edom.atb.cr2.Cr2Package#getModerationProcess_StartStep()
	 * @model required="true"
	 * @generated
	 */
	ValidationStep getStartStep();

	/**
	 * Sets the value of the '{@link pt.isep.edom.atb.cr2.ModerationProcess#getStartStep <em>Start Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Step</em>' reference.
	 * @see #getStartStep()
	 * @generated
	 */
	void setStartStep(ValidationStep value);

} // ModerationProcess
