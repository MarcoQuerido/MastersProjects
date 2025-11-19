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

import pt.isep.edom.mq.yabl.Command;
import pt.isep.edom.mq.yabl.File;
import pt.isep.edom.mq.yabl.Property;
import pt.isep.edom.mq.yabl.Rule;
import pt.isep.edom.mq.yabl.YablPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.RuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.RuleImpl#getType <em>Type</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.RuleImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.RuleImpl#getCommands <em>Commands</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.RuleImpl#getDepencencies <em>Depencencies</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.RuleImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleImpl extends MinimalEObjectImpl.Container implements Rule {
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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> attributes;

	/**
	 * The cached value of the '{@link #getCommands() <em>Commands</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommands()
	 * @generated
	 * @ordered
	 */
	protected EList<Command> commands;

	/**
	 * The cached value of the '{@link #getDepencencies() <em>Depencencies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepencencies()
	 * @generated
	 * @ordered
	 */
	protected EList<File> depencencies;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected EList<File> target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return YablPackage.Literals.RULE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, YablPackage.RULE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YablPackage.RULE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Property> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Property>(Property.class, this, YablPackage.RULE__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Command> getCommands() {
		if (commands == null) {
			commands = new EObjectContainmentEList<Command>(Command.class, this, YablPackage.RULE__COMMANDS);
		}
		return commands;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<File> getDepencencies() {
		if (depencencies == null) {
			depencencies = new EObjectContainmentEList<File>(File.class, this, YablPackage.RULE__DEPENCENCIES);
		}
		return depencencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<File> getTarget() {
		if (target == null) {
			target = new EObjectContainmentEList<File>(File.class, this, YablPackage.RULE__TARGET);
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case YablPackage.RULE__ATTRIBUTES:
			return ((InternalEList<?>) getAttributes()).basicRemove(otherEnd, msgs);
		case YablPackage.RULE__COMMANDS:
			return ((InternalEList<?>) getCommands()).basicRemove(otherEnd, msgs);
		case YablPackage.RULE__DEPENCENCIES:
			return ((InternalEList<?>) getDepencencies()).basicRemove(otherEnd, msgs);
		case YablPackage.RULE__TARGET:
			return ((InternalEList<?>) getTarget()).basicRemove(otherEnd, msgs);
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
		case YablPackage.RULE__NAME:
			return getName();
		case YablPackage.RULE__TYPE:
			return getType();
		case YablPackage.RULE__ATTRIBUTES:
			return getAttributes();
		case YablPackage.RULE__COMMANDS:
			return getCommands();
		case YablPackage.RULE__DEPENCENCIES:
			return getDepencencies();
		case YablPackage.RULE__TARGET:
			return getTarget();
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
		case YablPackage.RULE__NAME:
			setName((String) newValue);
			return;
		case YablPackage.RULE__TYPE:
			setType((String) newValue);
			return;
		case YablPackage.RULE__ATTRIBUTES:
			getAttributes().clear();
			getAttributes().addAll((Collection<? extends Property>) newValue);
			return;
		case YablPackage.RULE__COMMANDS:
			getCommands().clear();
			getCommands().addAll((Collection<? extends Command>) newValue);
			return;
		case YablPackage.RULE__DEPENCENCIES:
			getDepencencies().clear();
			getDepencencies().addAll((Collection<? extends File>) newValue);
			return;
		case YablPackage.RULE__TARGET:
			getTarget().clear();
			getTarget().addAll((Collection<? extends File>) newValue);
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
		case YablPackage.RULE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case YablPackage.RULE__TYPE:
			setType(TYPE_EDEFAULT);
			return;
		case YablPackage.RULE__ATTRIBUTES:
			getAttributes().clear();
			return;
		case YablPackage.RULE__COMMANDS:
			getCommands().clear();
			return;
		case YablPackage.RULE__DEPENCENCIES:
			getDepencencies().clear();
			return;
		case YablPackage.RULE__TARGET:
			getTarget().clear();
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
		case YablPackage.RULE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case YablPackage.RULE__TYPE:
			return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
		case YablPackage.RULE__ATTRIBUTES:
			return attributes != null && !attributes.isEmpty();
		case YablPackage.RULE__COMMANDS:
			return commands != null && !commands.isEmpty();
		case YablPackage.RULE__DEPENCENCIES:
			return depencencies != null && !depencencies.isEmpty();
		case YablPackage.RULE__TARGET:
			return target != null && !target.isEmpty();
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
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //RuleImpl
