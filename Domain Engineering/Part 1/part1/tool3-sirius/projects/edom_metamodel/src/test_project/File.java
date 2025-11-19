/**
 */
package test_project;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link test_project.File#getFilename <em>Filename</em>}</li>
 *   <li>{@link test_project.File#getFuntions <em>Funtions</em>}</li>
 *   <li>{@link test_project.File#getTarget <em>Target</em>}</li>
 *   <li>{@link test_project.File#getPrerequisite <em>Prerequisite</em>}</li>
 *   <li>{@link test_project.File#getTasks <em>Tasks</em>}</li>
 *   <li>{@link test_project.File#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see test_project.Test_projectPackage#getFile()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='stringSizeBetween3And15'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot stringSizeBetween3And15='self.filename.size() &gt; 3 and self.filename.size() &lt; 15'"
 * @generated
 */
public interface File extends EObject {
	/**
	 * Returns the value of the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filename</em>' attribute.
	 * @see #setFilename(String)
	 * @see test_project.Test_projectPackage#getFile_Filename()
	 * @model
	 * @generated
	 */
	String getFilename();

	/**
	 * Sets the value of the '{@link test_project.File#getFilename <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filename</em>' attribute.
	 * @see #getFilename()
	 * @generated
	 */
	void setFilename(String value);

	/**
	 * Returns the value of the '<em><b>Funtions</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.Function}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Funtions</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getFile_Funtions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Function> getFuntions();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.File}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getFile_Target()
	 * @model containment="true"
	 * @generated
	 */
	EList<File> getTarget();

	/**
	 * Returns the value of the '<em><b>Prerequisite</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.File}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prerequisite</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getFile_Prerequisite()
	 * @model containment="true"
	 * @generated
	 */
	EList<File> getPrerequisite();

	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.Task}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getFile_Tasks()
	 * @model containment="true"
	 * @generated
	 */
	EList<Task> getTasks();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.Parameters}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getFile_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameters> getAttributes();

} // File
