/**
 */
package pt.isep.edom.atb.cr2;

import java.math.BigInteger;
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
 *   <li>{@link pt.isep.edom.atb.cr2.Subject#getName <em>Name</em>}</li>
 *   <li>{@link pt.isep.edom.atb.cr2.Subject#getUserFeedback <em>User Feedback</em>}</li>
 *   <li>{@link pt.isep.edom.atb.cr2.Subject#getFeature <em>Feature</em>}</li>
 *   <li>{@link pt.isep.edom.atb.cr2.Subject#getFeatureCount <em>Feature Count</em>}</li>
 * </ul>
 *
 * @see pt.isep.edom.atb.cr2.Cr2Package#getSubject()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='userFeedbackOfDifferentTypes'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot userFeedbackOfDifferentTypes='self.userFeedback-&gt;isUnique(oclType().name)'"
 * @generated
 */
public interface Subject extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see pt.isep.edom.atb.cr2.Cr2Package#getSubject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link pt.isep.edom.atb.cr2.Subject#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>User Feedback</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.atb.cr2.UserFeedback}.
	 * It is bidirectional and its opposite is '{@link pt.isep.edom.atb.cr2.UserFeedback#getSubject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Feedback</em>' containment reference list.
	 * @see pt.isep.edom.atb.cr2.Cr2Package#getSubject_UserFeedback()
	 * @see pt.isep.edom.atb.cr2.UserFeedback#getSubject
	 * @model opposite="subject" containment="true" required="true" upper="2"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<UserFeedback> getUserFeedback();

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.atb.cr2.Feature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' containment reference list.
	 * @see pt.isep.edom.atb.cr2.Cr2Package#getSubject_Feature()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Feature> getFeature();

	/**
	 * Returns the value of the '<em><b>Feature Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Count</em>' attribute.
	 * @see pt.isep.edom.atb.cr2.Cr2Package#getSubject_FeatureCount()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.feature-&gt;size()'"
	 * @generated
	 */
	BigInteger getFeatureCount();

} // Subject
