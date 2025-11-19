/**
 */
package cr2;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cr2.Feature#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see cr2.Cr2Package#getFeature()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='nameValidation nameMustBeUnique'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot nameValidation='not self.name.oclIsUndefined() and self.name.size() &gt; 3 and self.name.substring(1,1).toUpper().compareTo(self.name.substring(1,1))=0' nameMustBeUnique='Feature.allInstances()-&gt;isUnique(e | e.name)'"
 *        annotation="gmf.node label='name'"
 * @generated
 */
public interface Feature extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see cr2.Cr2Package#getFeature_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cr2.Feature#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Feature
