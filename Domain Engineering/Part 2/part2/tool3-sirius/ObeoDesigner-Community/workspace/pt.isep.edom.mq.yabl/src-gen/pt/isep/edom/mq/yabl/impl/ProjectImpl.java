/**
 */
package pt.isep.edom.mq.yabl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pt.isep.edom.mq.yabl.Build;
import pt.isep.edom.mq.yabl.Description;
import pt.isep.edom.mq.yabl.File;
import pt.isep.edom.mq.yabl.Parameters;
import pt.isep.edom.mq.yabl.Project;
import pt.isep.edom.mq.yabl.Property;
import pt.isep.edom.mq.yabl.Task;
import pt.isep.edom.mq.yabl.YablPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.ProjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.ProjectImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.ProjectImpl#getTask <em>Task</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.ProjectImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.ProjectImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.ProjectImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.ProjectImpl#getBuild <em>Build</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.ProjectImpl#getTargets <em>Targets</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProjectImpl extends MinimalEObjectImpl.Container implements Project {
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
	 * The cached value of the '{@link #getTask() <em>Task</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTask()
	 * @generated
	 * @ordered
	 */
	protected EList<Task> task;

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
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> property;

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
		return YablPackage.Literals.PROJECT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, YablPackage.PROJECT__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, YablPackage.PROJECT__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Task> getTask() {
		if (task == null) {
			task = new EObjectContainmentEList<Task>(Task.class, this, YablPackage.PROJECT__TASK);
		}
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Parameters> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameters>(Parameters.class, this,
					YablPackage.PROJECT__PARAMETERS);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					YablPackage.PROJECT__DESCRIPTION, oldDescription, newDescription);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
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
				msgs = ((InternalEObject) description).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - YablPackage.PROJECT__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject) newDescription).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - YablPackage.PROJECT__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YablPackage.PROJECT__DESCRIPTION, newDescription,
					newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Property> getProperty() {
		if (property == null) {
			property = new EObjectContainmentEList<Property>(Property.class, this, YablPackage.PROJECT__PROPERTY);
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Build> getBuild() {
		if (build == null) {
			build = new EObjectContainmentEList<Build>(Build.class, this, YablPackage.PROJECT__BUILD);
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
			targets = new EObjectContainmentEList<File>(File.class, this, YablPackage.PROJECT__TARGETS);
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
		case YablPackage.PROJECT__TASK:
			return ((InternalEList<?>) getTask()).basicRemove(otherEnd, msgs);
		case YablPackage.PROJECT__PARAMETERS:
			return ((InternalEList<?>) getParameters()).basicRemove(otherEnd, msgs);
		case YablPackage.PROJECT__DESCRIPTION:
			return basicSetDescription(null, msgs);
		case YablPackage.PROJECT__PROPERTY:
			return ((InternalEList<?>) getProperty()).basicRemove(otherEnd, msgs);
		case YablPackage.PROJECT__BUILD:
			return ((InternalEList<?>) getBuild()).basicRemove(otherEnd, msgs);
		case YablPackage.PROJECT__TARGETS:
			return ((InternalEList<?>) getTargets()).basicRemove(otherEnd, msgs);
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
		case YablPackage.PROJECT__NAME:
			return getName();
		case YablPackage.PROJECT__VERSION:
			return getVersion();
		case YablPackage.PROJECT__TASK:
			return getTask();
		case YablPackage.PROJECT__PARAMETERS:
			return getParameters();
		case YablPackage.PROJECT__DESCRIPTION:
			return getDescription();
		case YablPackage.PROJECT__PROPERTY:
			return getProperty();
		case YablPackage.PROJECT__BUILD:
			return getBuild();
		case YablPackage.PROJECT__TARGETS:
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
		case YablPackage.PROJECT__NAME:
			setName((String) newValue);
			return;
		case YablPackage.PROJECT__VERSION:
			setVersion((Integer) newValue);
			return;
		case YablPackage.PROJECT__TASK:
			getTask().clear();
			getTask().addAll((Collection<? extends Task>) newValue);
			return;
		case YablPackage.PROJECT__PARAMETERS:
			getParameters().clear();
			getParameters().addAll((Collection<? extends Parameters>) newValue);
			return;
		case YablPackage.PROJECT__DESCRIPTION:
			setDescription((Description) newValue);
			return;
		case YablPackage.PROJECT__PROPERTY:
			getProperty().clear();
			getProperty().addAll((Collection<? extends Property>) newValue);
			return;
		case YablPackage.PROJECT__BUILD:
			getBuild().clear();
			getBuild().addAll((Collection<? extends Build>) newValue);
			return;
		case YablPackage.PROJECT__TARGETS:
			getTargets().clear();
			getTargets().addAll((Collection<? extends File>) newValue);
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
		case YablPackage.PROJECT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case YablPackage.PROJECT__VERSION:
			setVersion(VERSION_EDEFAULT);
			return;
		case YablPackage.PROJECT__TASK:
			getTask().clear();
			return;
		case YablPackage.PROJECT__PARAMETERS:
			getParameters().clear();
			return;
		case YablPackage.PROJECT__DESCRIPTION:
			setDescription((Description) null);
			return;
		case YablPackage.PROJECT__PROPERTY:
			getProperty().clear();
			return;
		case YablPackage.PROJECT__BUILD:
			getBuild().clear();
			return;
		case YablPackage.PROJECT__TARGETS:
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
		case YablPackage.PROJECT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case YablPackage.PROJECT__VERSION:
			return version != VERSION_EDEFAULT;
		case YablPackage.PROJECT__TASK:
			return task != null && !task.isEmpty();
		case YablPackage.PROJECT__PARAMETERS:
			return parameters != null && !parameters.isEmpty();
		case YablPackage.PROJECT__DESCRIPTION:
			return description != null;
		case YablPackage.PROJECT__PROPERTY:
			return property != null && !property.isEmpty();
		case YablPackage.PROJECT__BUILD:
			return build != null && !build.isEmpty();
		case YablPackage.PROJECT__TARGETS:
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
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", version: ");
		result.append(version);
		result.append(')');
		return result.toString();
	}

} //ProjectImpl
