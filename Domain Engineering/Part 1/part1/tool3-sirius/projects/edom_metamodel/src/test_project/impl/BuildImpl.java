/**
 */
package test_project.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import test_project.Build;
import test_project.Dependency;
import test_project.Method;
import test_project.Plugin;
import test_project.Repository;
import test_project.Test_projectPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Build</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link test_project.impl.BuildImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link test_project.impl.BuildImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link test_project.impl.BuildImpl#getPlugin <em>Plugin</em>}</li>
 *   <li>{@link test_project.impl.BuildImpl#getRepository <em>Repository</em>}</li>
 *   <li>{@link test_project.impl.BuildImpl#getDependency <em>Dependency</em>}</li>
 *   <li>{@link test_project.impl.BuildImpl#getMethod <em>Method</em>}</li>
 *   <li>{@link test_project.impl.BuildImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BuildImpl extends EObjectImpl implements Build {
	/**
	 * The default value of the '{@link #getGroup() <em>Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected String group = GROUP_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final int VERSION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected int version = VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPlugin() <em>Plugin</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlugin()
	 * @generated
	 * @ordered
	 */
	protected EList<Plugin> plugin;

	/**
	 * The cached value of the '{@link #getRepository() <em>Repository</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepository()
	 * @generated
	 * @ordered
	 */
	protected EList<Repository> repository;

	/**
	 * The cached value of the '{@link #getDependency() <em>Dependency</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependency()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> dependency;

	/**
	 * The cached value of the '{@link #getMethod() <em>Method</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethod()
	 * @generated
	 * @ordered
	 */
	protected EList<Method> method;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BuildImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Test_projectPackage.Literals.BUILD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGroup() {
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGroup(String newGroup) {
		String oldGroup = group;
		group = newGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Test_projectPackage.BUILD__GROUP, oldGroup, group));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(int newVersion) {
		int oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Test_projectPackage.BUILD__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Plugin> getPlugin() {
		if (plugin == null) {
			plugin = new EObjectContainmentEList<Plugin>(Plugin.class, this, Test_projectPackage.BUILD__PLUGIN);
		}
		return plugin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Repository> getRepository() {
		if (repository == null) {
			repository = new EObjectContainmentEList<Repository>(Repository.class, this, Test_projectPackage.BUILD__REPOSITORY);
		}
		return repository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Dependency> getDependency() {
		if (dependency == null) {
			dependency = new EObjectContainmentEList<Dependency>(Dependency.class, this, Test_projectPackage.BUILD__DEPENDENCY);
		}
		return dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Method> getMethod() {
		if (method == null) {
			method = new EObjectContainmentEList<Method>(Method.class, this, Test_projectPackage.BUILD__METHOD);
		}
		return method;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Test_projectPackage.BUILD__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Test_projectPackage.BUILD__PLUGIN:
				return ((InternalEList<?>)getPlugin()).basicRemove(otherEnd, msgs);
			case Test_projectPackage.BUILD__REPOSITORY:
				return ((InternalEList<?>)getRepository()).basicRemove(otherEnd, msgs);
			case Test_projectPackage.BUILD__DEPENDENCY:
				return ((InternalEList<?>)getDependency()).basicRemove(otherEnd, msgs);
			case Test_projectPackage.BUILD__METHOD:
				return ((InternalEList<?>)getMethod()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Test_projectPackage.BUILD__GROUP:
				return getGroup();
			case Test_projectPackage.BUILD__VERSION:
				return getVersion();
			case Test_projectPackage.BUILD__PLUGIN:
				return getPlugin();
			case Test_projectPackage.BUILD__REPOSITORY:
				return getRepository();
			case Test_projectPackage.BUILD__DEPENDENCY:
				return getDependency();
			case Test_projectPackage.BUILD__METHOD:
				return getMethod();
			case Test_projectPackage.BUILD__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Test_projectPackage.BUILD__GROUP:
				setGroup((String)newValue);
				return;
			case Test_projectPackage.BUILD__VERSION:
				setVersion((Integer)newValue);
				return;
			case Test_projectPackage.BUILD__PLUGIN:
				getPlugin().clear();
				getPlugin().addAll((Collection<? extends Plugin>)newValue);
				return;
			case Test_projectPackage.BUILD__REPOSITORY:
				getRepository().clear();
				getRepository().addAll((Collection<? extends Repository>)newValue);
				return;
			case Test_projectPackage.BUILD__DEPENDENCY:
				getDependency().clear();
				getDependency().addAll((Collection<? extends Dependency>)newValue);
				return;
			case Test_projectPackage.BUILD__METHOD:
				getMethod().clear();
				getMethod().addAll((Collection<? extends Method>)newValue);
				return;
			case Test_projectPackage.BUILD__NAME:
				setName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Test_projectPackage.BUILD__GROUP:
				setGroup(GROUP_EDEFAULT);
				return;
			case Test_projectPackage.BUILD__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case Test_projectPackage.BUILD__PLUGIN:
				getPlugin().clear();
				return;
			case Test_projectPackage.BUILD__REPOSITORY:
				getRepository().clear();
				return;
			case Test_projectPackage.BUILD__DEPENDENCY:
				getDependency().clear();
				return;
			case Test_projectPackage.BUILD__METHOD:
				getMethod().clear();
				return;
			case Test_projectPackage.BUILD__NAME:
				setName(NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Test_projectPackage.BUILD__GROUP:
				return GROUP_EDEFAULT == null ? group != null : !GROUP_EDEFAULT.equals(group);
			case Test_projectPackage.BUILD__VERSION:
				return version != VERSION_EDEFAULT;
			case Test_projectPackage.BUILD__PLUGIN:
				return plugin != null && !plugin.isEmpty();
			case Test_projectPackage.BUILD__REPOSITORY:
				return repository != null && !repository.isEmpty();
			case Test_projectPackage.BUILD__DEPENDENCY:
				return dependency != null && !dependency.isEmpty();
			case Test_projectPackage.BUILD__METHOD:
				return method != null && !method.isEmpty();
			case Test_projectPackage.BUILD__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (group: ");
		result.append(group);
		result.append(", version: ");
		result.append(version);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //BuildImpl
