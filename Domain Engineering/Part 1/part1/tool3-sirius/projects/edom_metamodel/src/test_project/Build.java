/**
 */
package test_project;

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
 *   <li>{@link test_project.Build#getGroup <em>Group</em>}</li>
 *   <li>{@link test_project.Build#getVersion <em>Version</em>}</li>
 *   <li>{@link test_project.Build#getPlugin <em>Plugin</em>}</li>
 *   <li>{@link test_project.Build#getRepository <em>Repository</em>}</li>
 *   <li>{@link test_project.Build#getDependency <em>Dependency</em>}</li>
 *   <li>{@link test_project.Build#getMethod <em>Method</em>}</li>
 *   <li>{@link test_project.Build#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see test_project.Test_projectPackage#getBuild()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='mustHaveVersion stringSizeBetween3And15'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot mustHaveVersion='not self.version.oclIsUndefined()' stringSizeBetween3And15='(self.group.size() &gt; 3 and self.group.size() &lt; 15)'"
 * @generated
 */
public interface Build extends EObject {
	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute.
	 * @see #setGroup(String)
	 * @see test_project.Test_projectPackage#getBuild_Group()
	 * @model
	 * @generated
	 */
	String getGroup();

	/**
	 * Sets the value of the '{@link test_project.Build#getGroup <em>Group</em>}' attribute.
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
	 * @see test_project.Test_projectPackage#getBuild_Version()
	 * @model required="true"
	 * @generated
	 */
	int getVersion();

	/**
	 * Sets the value of the '{@link test_project.Build#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(int value);

	/**
	 * Returns the value of the '<em><b>Plugin</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.Plugin}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getBuild_Plugin()
	 * @model containment="true"
	 * @generated
	 */
	EList<Plugin> getPlugin();

	/**
	 * Returns the value of the '<em><b>Repository</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.Repository}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getBuild_Repository()
	 * @model containment="true"
	 * @generated
	 */
	EList<Repository> getRepository();

	/**
	 * Returns the value of the '<em><b>Dependency</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.Dependency}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependency</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getBuild_Dependency()
	 * @model containment="true"
	 * @generated
	 */
	EList<Dependency> getDependency();

	/**
	 * Returns the value of the '<em><b>Method</b></em>' containment reference list.
	 * The list contents are of type {@link test_project.Method}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' containment reference list.
	 * @see test_project.Test_projectPackage#getBuild_Method()
	 * @model containment="true"
	 * @generated
	 */
	EList<Method> getMethod();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see test_project.Test_projectPackage#getBuild_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link test_project.Build#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Build
