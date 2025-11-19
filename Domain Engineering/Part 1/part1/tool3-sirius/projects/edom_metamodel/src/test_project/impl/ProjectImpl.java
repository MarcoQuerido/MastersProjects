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
import test_project.Description;
import test_project.File;
import test_project.Parameters;
import test_project.Project;
import test_project.Property;
import test_project.Task;
import test_project.Test_projectPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link test_project.impl.ProjectImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link test_project.impl.ProjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link test_project.impl.ProjectImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link test_project.impl.ProjectImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link test_project.impl.ProjectImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link test_project.impl.ProjectImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link test_project.impl.ProjectImpl#getBuild <em>Build</em>}</li>
 *   <li>{@link test_project.impl.ProjectImpl#getTargets <em>Targets</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProjectImpl extends EObjectImpl implements Project {
	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Task> attributes;

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
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> properties;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameters> parameters;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected Description description;

	/**
	 * The cached value of the '{@link #getBuild() <em>Build</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuild()
	 * @generated
	 * @ordered
	 */
	protected EList<Build> build;

	/**
	 * The cached value of the '{@link #getTargets() <em>Targets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargets()
	 * @generated
	 * @ordered
	 */
	protected EList<File> targets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Test_projectPackage.Literals.PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Task> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Task>(Task.class, this, Test_projectPackage.PROJECT__ATTRIBUTES);
		}
		return attributes;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Test_projectPackage.PROJECT__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Test_projectPackage.PROJECT__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Property> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<Property>(Property.class, this, Test_projectPackage.PROJECT__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Parameters> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameters>(Parameters.class, this, Test_projectPackage.PROJECT__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Description getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescription(Description newDescription, NotificationChain msgs) {
		Description oldDescription = description;
		description = newDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Test_projectPackage.PROJECT__DESCRIPTION, oldDescription, newDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(Description newDescription) {
		if (newDescription != description) {
			NotificationChain msgs = null;
			if (description != null)
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Test_projectPackage.PROJECT__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Test_projectPackage.PROJECT__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Test_projectPackage.PROJECT__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Build> getBuild() {
		if (build == null) {
			build = new EObjectContainmentEList<Build>(Build.class, this, Test_projectPackage.PROJECT__BUILD);
		}
		return build;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<File> getTargets() {
		if (targets == null) {
			targets = new EObjectContainmentEList<File>(File.class, this, Test_projectPackage.PROJECT__TARGETS);
		}
		return targets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Test_projectPackage.PROJECT__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case Test_projectPackage.PROJECT__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case Test_projectPackage.PROJECT__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case Test_projectPackage.PROJECT__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case Test_projectPackage.PROJECT__BUILD:
				return ((InternalEList<?>)getBuild()).basicRemove(otherEnd, msgs);
			case Test_projectPackage.PROJECT__TARGETS:
				return ((InternalEList<?>)getTargets()).basicRemove(otherEnd, msgs);
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
			case Test_projectPackage.PROJECT__ATTRIBUTES:
				return getAttributes();
			case Test_projectPackage.PROJECT__NAME:
				return getName();
			case Test_projectPackage.PROJECT__VERSION:
				return getVersion();
			case Test_projectPackage.PROJECT__PROPERTIES:
				return getProperties();
			case Test_projectPackage.PROJECT__PARAMETERS:
				return getParameters();
			case Test_projectPackage.PROJECT__DESCRIPTION:
				return getDescription();
			case Test_projectPackage.PROJECT__BUILD:
				return getBuild();
			case Test_projectPackage.PROJECT__TARGETS:
				return getTargets();
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
			case Test_projectPackage.PROJECT__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Task>)newValue);
				return;
			case Test_projectPackage.PROJECT__NAME:
				setName((String)newValue);
				return;
			case Test_projectPackage.PROJECT__VERSION:
				setVersion((Integer)newValue);
				return;
			case Test_projectPackage.PROJECT__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case Test_projectPackage.PROJECT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameters>)newValue);
				return;
			case Test_projectPackage.PROJECT__DESCRIPTION:
				setDescription((Description)newValue);
				return;
			case Test_projectPackage.PROJECT__BUILD:
				getBuild().clear();
				getBuild().addAll((Collection<? extends Build>)newValue);
				return;
			case Test_projectPackage.PROJECT__TARGETS:
				getTargets().clear();
				getTargets().addAll((Collection<? extends File>)newValue);
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
			case Test_projectPackage.PROJECT__ATTRIBUTES:
				getAttributes().clear();
				return;
			case Test_projectPackage.PROJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Test_projectPackage.PROJECT__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case Test_projectPackage.PROJECT__PROPERTIES:
				getProperties().clear();
				return;
			case Test_projectPackage.PROJECT__PARAMETERS:
				getParameters().clear();
				return;
			case Test_projectPackage.PROJECT__DESCRIPTION:
				setDescription((Description)null);
				return;
			case Test_projectPackage.PROJECT__BUILD:
				getBuild().clear();
				return;
			case Test_projectPackage.PROJECT__TARGETS:
				getTargets().clear();
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
			case Test_projectPackage.PROJECT__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case Test_projectPackage.PROJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Test_projectPackage.PROJECT__VERSION:
				return version != VERSION_EDEFAULT;
			case Test_projectPackage.PROJECT__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case Test_projectPackage.PROJECT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case Test_projectPackage.PROJECT__DESCRIPTION:
				return description != null;
			case Test_projectPackage.PROJECT__BUILD:
				return build != null && !build.isEmpty();
			case Test_projectPackage.PROJECT__TARGETS:
				return targets != null && !targets.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", version: ");
		result.append(version);
		result.append(')');
		return result.toString();
	}

} //ProjectImpl
