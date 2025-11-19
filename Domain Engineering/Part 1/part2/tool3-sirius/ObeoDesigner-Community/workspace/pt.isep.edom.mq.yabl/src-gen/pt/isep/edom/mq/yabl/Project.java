/**
 */
package pt.isep.edom.mq.yabl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pt.isep.edom.mq.yabl.Project#getName <em>Name</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Project#getVersion <em>Version</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Project#getTask <em>Task</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Project#getParameters <em>Parameters</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Project#getDescription <em>Description</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Project#getProperty <em>Property</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Project#getBuild <em>Build</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Project#getTargets <em>Targets</em>}</li>
 * </ul>
 *
 * @see pt.isep.edom.mq.yabl.YablPackage#getProject()
 * @model
 * @generated
 */
public interface Project extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see pt.isep.edom.mq.yabl.YablPackage#getProject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link pt.isep.edom.mq.yabl.Project#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(int)
	 * @see pt.isep.edom.mq.yabl.YablPackage#getProject_Version()
	 * @model
	 * @generated
	 */
	int getVersion();

	/**
	 * Sets the value of the '{@link pt.isep.edom.mq.yabl.Project#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(int value);

	/**
	 * Returns the value of the '<em><b>Task</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.yabl.Task}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task</em>' containment reference list.
	 * @see pt.isep.edom.mq.yabl.YablPackage#getProject_Task()
	 * @model containment="true"
	 * @generated
	 */
	EList<Task> getTask();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.yabl.Parameters}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see pt.isep.edom.mq.yabl.YablPackage#getProject_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameters> getParameters();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' containment reference.
	 * @see #setDescription(Description)
	 * @see pt.isep.edom.mq.yabl.YablPackage#getProject_Description()
	 * @model containment="true"
	 * @generated
	 */
	Description getDescription();

	/**
	 * Sets the value of the '{@link pt.isep.edom.mq.yabl.Project#getDescription <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' containment reference.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(Description value);

	/**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.yabl.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' containment reference list.
	 * @see pt.isep.edom.mq.yabl.YablPackage#getProject_Property()
	 * @model containment="true"
	 * @generated
	 */
	EList<Property> getProperty();

	/**
	 * Returns the value of the '<em><b>Build</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.yabl.Build}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Build</em>' containment reference list.
	 * @see pt.isep.edom.mq.yabl.YablPackage#getProject_Build()
	 * @model containment="true"
	 * @generated
	 */
	EList<Build> getBuild();

	/**
	 * Returns the value of the '<em><b>Targets</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.yabl.File}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targets</em>' containment reference list.
	 * @see pt.isep.edom.mq.yabl.YablPackage#getProject_Targets()
	 * @model containment="true"
	 * @generated
	 */
	EList<File> getTargets();

} // Project
