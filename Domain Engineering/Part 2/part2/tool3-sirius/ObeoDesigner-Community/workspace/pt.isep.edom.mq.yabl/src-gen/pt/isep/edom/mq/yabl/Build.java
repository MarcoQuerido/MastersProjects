/**
 */
package pt.isep.edom.mq.yabl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Build</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pt.isep.edom.mq.yabl.Build#getGroup <em>Group</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Build#getVersion <em>Version</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Build#getName <em>Name</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Build#getPlugin <em>Plugin</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Build#getRepository <em>Repository</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Build#getDependency <em>Dependency</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.Build#getMethod <em>Method</em>}</li>
 * </ul>
 *
 * @see pt.isep.edom.mq.yabl.YablPackage#getBuild()
 * @model
 * @generated
 */
public interface Build extends EObject {
	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute.
	 * @see #setGroup(String)
	 * @see pt.isep.edom.mq.yabl.YablPackage#getBuild_Group()
	 * @model
	 * @generated
	 */
	String getGroup();

	/**
	 * Sets the value of the '{@link pt.isep.edom.mq.yabl.Build#getGroup <em>Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group</em>' attribute.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(int)
	 * @see pt.isep.edom.mq.yabl.YablPackage#getBuild_Version()
	 * @model
	 * @generated
	 */
	int getVersion();

	/**
	 * Sets the value of the '{@link pt.isep.edom.mq.yabl.Build#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see pt.isep.edom.mq.yabl.YablPackage#getBuild_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link pt.isep.edom.mq.yabl.Build#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Plugin</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.yabl.Plugin}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin</em>' containment reference list.
	 * @see pt.isep.edom.mq.yabl.YablPackage#getBuild_Plugin()
	 * @model containment="true"
	 * @generated
	 */
	EList<Plugin> getPlugin();

	/**
	 * Returns the value of the '<em><b>Repository</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.yabl.Repository}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository</em>' containment reference list.
	 * @see pt.isep.edom.mq.yabl.YablPackage#getBuild_Repository()
	 * @model containment="true"
	 * @generated
	 */
	EList<Repository> getRepository();

	/**
	 * Returns the value of the '<em><b>Dependency</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.yabl.Dependency}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependency</em>' containment reference list.
	 * @see pt.isep.edom.mq.yabl.YablPackage#getBuild_Dependency()
	 * @model containment="true"
	 * @generated
	 */
	EList<Dependency> getDependency();

	/**
	 * Returns the value of the '<em><b>Method</b></em>' containment reference list.
	 * The list contents are of type {@link pt.isep.edom.mq.yabl.Method}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' containment reference list.
	 * @see pt.isep.edom.mq.yabl.YablPackage#getBuild_Method()
	 * @model containment="true"
	 * @generated
	 */
	EList<Method> getMethod();

} // Build
