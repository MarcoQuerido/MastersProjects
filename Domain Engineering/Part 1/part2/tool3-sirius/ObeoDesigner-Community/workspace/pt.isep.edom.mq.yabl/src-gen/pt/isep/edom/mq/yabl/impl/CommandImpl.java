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
import pt.isep.edom.mq.yabl.Prefix;
import pt.isep.edom.mq.yabl.YablPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.CommandImpl#getName <em>Name</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.CommandImpl#getCommandline <em>Commandline</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.CommandImpl#getModified <em>Modified</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CommandImpl extends MinimalEObjectImpl.Container implements Command {
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
	 * The default value of the '{@link #getCommandline() <em>Commandline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandline()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMANDLINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommandline() <em>Commandline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandline()
	 * @generated
	 * @ordered
	 */
	protected String commandline = COMMANDLINE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModified() <em>Modified</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModified()
	 * @generated
	 * @ordered
	 */
	protected EList<Prefix> modified;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return YablPackage.Literals.COMMAND;
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
			eNotify(new ENotificationImpl(this, Notification.SET, YablPackage.COMMAND__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCommandline() {
		return commandline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCommandline(String newCommandline) {
		String oldCommandline = commandline;
		commandline = newCommandline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YablPackage.COMMAND__COMMANDLINE, oldCommandline,
					commandline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Prefix> getModified() {
		if (modified == null) {
			modified = new EObjectContainmentEList<Prefix>(Prefix.class, this, YablPackage.COMMAND__MODIFIED);
		}
		return modified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case YablPackage.COMMAND__MODIFIED:
			return ((InternalEList<?>) getModified()).basicRemove(otherEnd, msgs);
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
		case YablPackage.COMMAND__NAME:
			return getName();
		case YablPackage.COMMAND__COMMANDLINE:
			return getCommandline();
		case YablPackage.COMMAND__MODIFIED:
			return getModified();
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
		case YablPackage.COMMAND__NAME:
			setName((String) newValue);
			return;
		case YablPackage.COMMAND__COMMANDLINE:
			setCommandline((String) newValue);
			return;
		case YablPackage.COMMAND__MODIFIED:
			getModified().clear();
			getModified().addAll((Collection<? extends Prefix>) newValue);
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
		case YablPackage.COMMAND__NAME:
			setName(NAME_EDEFAULT);
			return;
		case YablPackage.COMMAND__COMMANDLINE:
			setCommandline(COMMANDLINE_EDEFAULT);
			return;
		case YablPackage.COMMAND__MODIFIED:
			getModified().clear();
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
		case YablPackage.COMMAND__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case YablPackage.COMMAND__COMMANDLINE:
			return COMMANDLINE_EDEFAULT == null ? commandline != null : !COMMANDLINE_EDEFAULT.equals(commandline);
		case YablPackage.COMMAND__MODIFIED:
			return modified != null && !modified.isEmpty();
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
		result.append(", commandline: ");
		result.append(commandline);
		result.append(')');
		return result.toString();
	}

} //CommandImpl
