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

import pt.isep.edom.mq.yabl.File;
import pt.isep.edom.mq.yabl.Function;
import pt.isep.edom.mq.yabl.Parameters;
import pt.isep.edom.mq.yabl.Task;
import pt.isep.edom.mq.yabl.YablPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.FileImpl#getFilename <em>Filename</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.FileImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.FileImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.FileImpl#getTask <em>Task</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.FileImpl#getPrerequisites <em>Prerequisites</em>}</li>
 *   <li>{@link pt.isep.edom.mq.yabl.impl.FileImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FileImpl extends MinimalEObjectImpl.Container implements File {
	/**
	 * The default value of the '{@link #getFilename() <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilename()
	 * @generated
	 * @ordered
	 */
	protected static final String FILENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFilename() <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilename()
	 * @generated
	 * @ordered
	 */
	protected String filename = FILENAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameters> attributes;

	/**
	 * The cached value of the '{@link #getFunctions() <em>Functions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctions()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> functions;

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
	 * The cached value of the '{@link #getPrerequisites() <em>Prerequisites</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrerequisites()
	 * @generated
	 * @ordered
	 */
	protected EList<File> prerequisites;

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
	protected FileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return YablPackage.Literals.FILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFilename() {
		return filename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFilename(String newFilename) {
		String oldFilename = filename;
		filename = newFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YablPackage.FILE__FILENAME, oldFilename, filename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Parameters> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Parameters>(Parameters.class, this, YablPackage.FILE__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Function> getFunctions() {
		if (functions == null) {
			functions = new EObjectContainmentEList<Function>(Function.class, this, YablPackage.FILE__FUNCTIONS);
		}
		return functions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Task> getTask() {
		if (task == null) {
			task = new EObjectContainmentEList<Task>(Task.class, this, YablPackage.FILE__TASK);
		}
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<File> getPrerequisites() {
		if (prerequisites == null) {
			prerequisites = new EObjectContainmentEList<File>(File.class, this, YablPackage.FILE__PREREQUISITES);
		}
		return prerequisites;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<File> getTarget() {
		if (target == null) {
			target = new EObjectContainmentEList<File>(File.class, this, YablPackage.FILE__TARGET);
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
		case YablPackage.FILE__ATTRIBUTES:
			return ((InternalEList<?>) getAttributes()).basicRemove(otherEnd, msgs);
		case YablPackage.FILE__FUNCTIONS:
			return ((InternalEList<?>) getFunctions()).basicRemove(otherEnd, msgs);
		case YablPackage.FILE__TASK:
			return ((InternalEList<?>) getTask()).basicRemove(otherEnd, msgs);
		case YablPackage.FILE__PREREQUISITES:
			return ((InternalEList<?>) getPrerequisites()).basicRemove(otherEnd, msgs);
		case YablPackage.FILE__TARGET:
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
		case YablPackage.FILE__FILENAME:
			return getFilename();
		case YablPackage.FILE__ATTRIBUTES:
			return getAttributes();
		case YablPackage.FILE__FUNCTIONS:
			return getFunctions();
		case YablPackage.FILE__TASK:
			return getTask();
		case YablPackage.FILE__PREREQUISITES:
			return getPrerequisites();
		case YablPackage.FILE__TARGET:
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
		case YablPackage.FILE__FILENAME:
			setFilename((String) newValue);
			return;
		case YablPackage.FILE__ATTRIBUTES:
			getAttributes().clear();
			getAttributes().addAll((Collection<? extends Parameters>) newValue);
			return;
		case YablPackage.FILE__FUNCTIONS:
			getFunctions().clear();
			getFunctions().addAll((Collection<? extends Function>) newValue);
			return;
		case YablPackage.FILE__TASK:
			getTask().clear();
			getTask().addAll((Collection<? extends Task>) newValue);
			return;
		case YablPackage.FILE__PREREQUISITES:
			getPrerequisites().clear();
			getPrerequisites().addAll((Collection<? extends File>) newValue);
			return;
		case YablPackage.FILE__TARGET:
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
		case YablPackage.FILE__FILENAME:
			setFilename(FILENAME_EDEFAULT);
			return;
		case YablPackage.FILE__ATTRIBUTES:
			getAttributes().clear();
			return;
		case YablPackage.FILE__FUNCTIONS:
			getFunctions().clear();
			return;
		case YablPackage.FILE__TASK:
			getTask().clear();
			return;
		case YablPackage.FILE__PREREQUISITES:
			getPrerequisites().clear();
			return;
		case YablPackage.FILE__TARGET:
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
		case YablPackage.FILE__FILENAME:
			return FILENAME_EDEFAULT == null ? filename != null : !FILENAME_EDEFAULT.equals(filename);
		case YablPackage.FILE__ATTRIBUTES:
			return attributes != null && !attributes.isEmpty();
		case YablPackage.FILE__FUNCTIONS:
			return functions != null && !functions.isEmpty();
		case YablPackage.FILE__TASK:
			return task != null && !task.isEmpty();
		case YablPackage.FILE__PREREQUISITES:
			return prerequisites != null && !prerequisites.isEmpty();
		case YablPackage.FILE__TARGET:
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
		result.append(" (filename: ");
		result.append(filename);
		result.append(')');
		return result.toString();
	}

} //FileImpl
