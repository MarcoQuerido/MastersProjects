/**
 */
package pt.isep.edom.mq.yabl;

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
 *   <li>{@link pt.isep.edom.mq.yabl.File#getFilename <em>Filename</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.File#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.File#getFunctions <em>Functions</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.File#getTask <em>Task</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.File#getPrerequisites <em>Prerequisites</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.File#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see pt.isep.edom.mq.yabl.YablPackage#getFile()
 * @model
 * @generated
 */
public interface File extends EObject {
	/**
	 * Returns the value of the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filename</em>' attribute.
	 * @see #setFilename(String)
	 * @see pt.isep.edom.mq.yabl.YablPackage#getFile_Filename()
	 * @model
	 * @generated
	 */
	String getFilename();

	/**
	 * Sets the value of the '{@link pt.isep.edom.mq.yabl.File#getFilename <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filename</em>' attribute.
	 * @see #getFilename()
	 * @generated
	 */
	void setFilename(String value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.yabl.Parameters}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see pt.isep.edom.mq.yabl.YablPackage#getFile_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameters> getAttributes();

	/**
	 * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.yabl.Function}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functions</em>' containment reference list.
	 * @see pt.isep.edom.mq.yabl.YablPackage#getFile_Functions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Function> getFunctions();

	/**
	 * Returns the value of the '<em><b>Task</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.yabl.Task}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task</em>' containment reference list.
	 * @see pt.isep.edom.mq.yabl.YablPackage#getFile_Task()
	 * @model containment="true"
	 * @generated
	 */
	EList<Task> getTask();

	/**
	 * Returns the value of the '<em><b>Prerequisites</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.yabl.File}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prerequisites</em>' containment reference list.
	 * @see pt.isep.edom.mq.yabl.YablPackage#getFile_Prerequisites()
	 * @model containment="true"
	 * @generated
	 */
	EList<File> getPrerequisites();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.yabl.File}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference list.
	 * @see pt.isep.edom.mq.yabl.YablPackage#getFile_Target()
	 * @model containment="true"
	 * @generated
	 */
	EList<File> getTarget();

} // File
