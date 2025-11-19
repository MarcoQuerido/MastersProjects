/**
 */
package test_project;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link test_project.Task#getName <em>Name</em>}</li>
 *   <li>{@link test_project.Task#getDescription <em>Description</em>}</li>
 *   <li>{@link test_project.Task#getGroup <em>Group</em>}</li>
 *   <li>{@link test_project.Task#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link test_project.Task#getAction <em>Action</em>}</li>
 *   <li>{@link test_project.Task#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link test_project.Task#getTask <em>Task</em>}</li>
 *   <li>{@link test_project.Task#getScript <em>Script</em>}</li>
 * </ul>
 *
 * @see test_project.Test_projectPackage#getTask()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='mustHaveNameAndUpperCase stringSizeBetween3And15'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot mustHaveNameAndUpperCase='not self.name.oclIsUndefined() and self.name.substring(1, 1).toUpper().compareTo(self.name.substring(1,1))=0' stringSizeBetween3And15='(self.name.size() &gt; 3 and self.name.size() &lt; 15) and (self.description.size() &gt; 3 \n\t\t\tand self.description.size() &lt; 15) and (self.group.size() &gt; 3 and self.group.size() &lt; 15) '"
 * @generated
 */
public interface Task extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see test_project.Test_projectPackage#getTask_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link test_project.Task#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see test_project.Test_projectPackage#getTask_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link test_project.Task#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute.
	 * @see #setGroup(String)
	 * @see test_project.Test_projectPackage#getTask_Group()
	 * @model
	 * @generated
	 */
	String getGroup();

	/**
	 * Sets the value of the '{@link test_project.Task#getGroup <em>Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group</em>' attribute.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(String value);

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see test_project.Test_projectPackage#getTask_Enabled()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link test_project.Task#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.Action}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getTask_Action()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getAction();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.Parameters}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getTask_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameters> getAttributes();

	/**
	 * Returns the value of the '<em><b>Task</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.Task}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getTask_Task()
	 * @model containment="true"
	 * @generated
	 */
	EList<Task> getTask();

	/**
	 * Returns the value of the '<em><b>Script</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script</em>' reference.
	 * @see #setScript(Script)
	 * @see test_project.Test_projectPackage#getTask_Script()
	 * @model
	 * @generated
	 */
	Script getScript();

	/**
	 * Sets the value of the '{@link test_project.Task#getScript <em>Script</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script</em>' reference.
	 * @see #getScript()
	 * @generated
	 */
	void setScript(Script value);

} // Task
