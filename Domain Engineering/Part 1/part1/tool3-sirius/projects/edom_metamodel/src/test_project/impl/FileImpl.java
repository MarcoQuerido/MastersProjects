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

import test_project.File;
import test_project.Function;
import test_project.Parameters;
import test_project.Task;
import test_project.Test_projectPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link test_project.impl.FileImpl#getFilename <em>Filename</em>}</li>
 *   <li>{@link test_project.impl.FileImpl#getFuntions <em>Funtions</em>}</li>
 *   <li>{@link test_project.impl.FileImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link test_project.impl.FileImpl#getPrerequisite <em>Prerequisite</em>}</li>
 *   <li>{@link test_project.impl.FileImpl#getTasks <em>Tasks</em>}</li>
 *   <li>{@link test_project.impl.FileImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FileImpl extends EObjectImpl implements File {
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
	 * The cached value of the '{@link #getFuntions() <em>Funtions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFuntions()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> funtions;

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
	 * The cached value of the '{@link #getPrerequisite() <em>Prerequisite</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrerequisite()
	 * @generated
	 * @ordered
	 */
	protected EList<File> prerequisite;

	/**
	 * The cached value of the '{@link #getTasks() <em>Tasks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTasks()
	 * @generated
	 * @ordered
	 */
	protected EList<Task> tasks;

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
		return Test_projectPackage.Literals.FILE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Test_projectPackage.FILE__FILENAME, oldFilename, filename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Function> getFuntions() {
		if (funtions == null) {
			funtions = new EObjectContainmentEList<Function>(Function.class, this, Test_projectPackage.FILE__FUNTIONS);
		}
		return funtions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<File> getTarget() {
		if (target == null) {
			target = new EObjectContainmentEList<File>(File.class, this, Test_projectPackage.FILE__TARGET);
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<File> getPrerequisite() {
		if (prerequisite == null) {
			prerequisite = new EObjectContainmentEList<File>(File.class, this, Test_projectPackage.FILE__PREREQUISITE);
		}
		return prerequisite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Task> getTasks() {
		if (tasks == null) {
			tasks = new EObjectContainmentEList<Task>(Task.class, this, Test_projectPackage.FILE__TASKS);
		}
		return tasks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Parameters> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Parameters>(Parameters.class, this, Test_projectPackage.FILE__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Test_projectPackage.FILE__FUNTIONS:
				return ((InternalEList<?>)getFuntions()).basicRemove(otherEnd, msgs);
			case Test_projectPackage.FILE__TARGET:
				return ((InternalEList<?>)getTarget()).basicRemove(otherEnd, msgs);
			case Test_projectPackage.FILE__PREREQUISITE:
				return ((InternalEList<?>)getPrerequisite()).basicRemove(otherEnd, msgs);
			case Test_projectPackage.FILE__TASKS:
				return ((InternalEList<?>)getTasks()).basicRemove(otherEnd, msgs);
			case Test_projectPackage.FILE__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
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
			case Test_projectPackage.FILE__FILENAME:
				return getFilename();
			case Test_projectPackage.FILE__FUNTIONS:
				return getFuntions();
			case Test_projectPackage.FILE__TARGET:
				return getTarget();
			case Test_projectPackage.FILE__PREREQUISITE:
				return getPrerequisite();
			case Test_projectPackage.FILE__TASKS:
				return getTasks();
			case Test_projectPackage.FILE__ATTRIBUTES:
				return getAttributes();
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
			case Test_projectPackage.FILE__FILENAME:
				setFilename((String)newValue);
				return;
			case Test_projectPackage.FILE__FUNTIONS:
				getFuntions().clear();
				getFuntions().addAll((Collection<? extends Function>)newValue);
				return;
			case Test_projectPackage.FILE__TARGET:
				getTarget().clear();
				getTarget().addAll((Collection<? extends File>)newValue);
				return;
			case Test_projectPackage.FILE__PREREQUISITE:
				getPrerequisite().clear();
				getPrerequisite().addAll((Collection<? extends File>)newValue);
				return;
			case Test_projectPackage.FILE__TASKS:
				getTasks().clear();
				getTasks().addAll((Collection<? extends Task>)newValue);
				return;
			case Test_projectPackage.FILE__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Parameters>)newValue);
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
			case Test_projectPackage.FILE__FILENAME:
				setFilename(FILENAME_EDEFAULT);
				return;
			case Test_projectPackage.FILE__FUNTIONS:
				getFuntions().clear();
				return;
			case Test_projectPackage.FILE__TARGET:
				getTarget().clear();
				return;
			case Test_projectPackage.FILE__PREREQUISITE:
				getPrerequisite().clear();
				return;
			case Test_projectPackage.FILE__TASKS:
				getTasks().clear();
				return;
			case Test_projectPackage.FILE__ATTRIBUTES:
				getAttributes().clear();
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
			case Test_projectPackage.FILE__FILENAME:
				return FILENAME_EDEFAULT == null ? filename != null : !FILENAME_EDEFAULT.equals(filename);
			case Test_projectPackage.FILE__FUNTIONS:
				return funtions != null && !funtions.isEmpty();
			case Test_projectPackage.FILE__TARGET:
				return target != null && !target.isEmpty();
			case Test_projectPackage.FILE__PREREQUISITE:
				return prerequisite != null && !prerequisite.isEmpty();
			case Test_projectPackage.FILE__TASKS:
				return tasks != null && !tasks.isEmpty();
			case Test_projectPackage.FILE__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
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
		result.append(" (filename: ");
		result.append(filename);
		result.append(')');
		return result.toString();
	}

} //FileImpl
