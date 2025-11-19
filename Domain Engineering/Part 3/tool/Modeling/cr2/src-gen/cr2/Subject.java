/**
 */
package cr2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subject</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cr2.Subject#getName <em>Name</em>}</li>
 *   <li>{@link cr2.Subject#getFeature <em>Feature</em>}</li>
 *   <li>{@link cr2.Subject#getUserfeedback <em>Userfeedback</em>}</li>
 * </ul>
 *
 * @see cr2.Cr2Package#getSubject()
 * @model
 * @generated
 */
public interface Subject extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see cr2.Cr2Package#getSubject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cr2.Subject#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' containment reference.
	 * @see #setFeature(Feature)
	 * @see cr2.Cr2Package#getSubject_Feature()
	 * @model containment="true"
	 * @generated
	 */
	Feature getFeature();

	/**
	 * Sets the value of the '{@link cr2.Subject#getFeature <em>Feature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' containment reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(Feature value);

	/**
	 * Returns the value of the '<em><b>Userfeedback</b></em>' containment reference list.
	 * The list contents are of type {@link cr2.UserFeedback}.
	 * It is bidirectional and its opposite is '{@link cr2.UserFeedback#getSubject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Userfeedback</em>' containment reference list.
	 * @see cr2.Cr2Package#getSubject_Userfeedback()
	 * @see cr2.UserFeedback#getSubject
	 * @model opposite="subject" containment="true" required="true" upper="2"
	 * @generated
	 */
	EList<UserFeedback> getUserfeedback();

} // Subject
