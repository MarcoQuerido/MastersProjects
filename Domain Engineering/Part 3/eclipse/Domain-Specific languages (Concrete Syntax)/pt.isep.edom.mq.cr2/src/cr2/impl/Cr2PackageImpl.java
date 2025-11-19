/**
 */
package cr2.impl;

import cr2.Automatic;
import cr2.Comment;
import cr2.CommentType;
import cr2.Cr2Factory;
import cr2.Cr2Package;
import cr2.End;
import cr2.Feature;
import cr2.GradeType;
import cr2.Manual;
import cr2.Model;
import cr2.ModerationProcess;
import cr2.Review;
import cr2.ReviewType;
import cr2.Step;
import cr2.Subject;
import cr2.UserFeedback;
import cr2.ValidationStep;

import cr2.util.Cr2Validator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Cr2PackageImpl extends EPackageImpl implements Cr2Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userFeedbackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reviewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moderationProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validationStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass automaticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass manualEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum gradeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum reviewTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum commentTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see cr2.Cr2Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Cr2PackageImpl() {
		super(eNS_URI, Cr2Factory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link Cr2Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Cr2Package init() {
		if (isInited) return (Cr2Package)EPackage.Registry.INSTANCE.getEPackage(Cr2Package.eNS_URI);

		// Obtain or create and register package
		Object registeredCr2Package = EPackage.Registry.INSTANCE.get(eNS_URI);
		Cr2PackageImpl theCr2Package = registeredCr2Package instanceof Cr2PackageImpl ? (Cr2PackageImpl)registeredCr2Package : new Cr2PackageImpl();

		isInited = true;

		// Create package meta-data objects
		theCr2Package.createPackageContents();

		// Initialize created meta-data
		theCr2Package.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theCr2Package,
			 new EValidator.Descriptor() {
				 @Override
				 public EValidator getEValidator() {
					 return Cr2Validator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theCr2Package.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Cr2Package.eNS_URI, theCr2Package);
		return theCr2Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModel() {
		return modelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModel_Subject() {
		return (EReference)modelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModel_Name() {
		return (EAttribute)modelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSubject() {
		return subjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSubject_Name() {
		return (EAttribute)subjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSubject_Feature() {
		return (EReference)subjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSubject_Userfeedback() {
		return (EReference)subjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSubject_FeatureCount() {
		return (EAttribute)subjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFeature() {
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFeature_Name() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUserFeedback() {
		return userFeedbackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUserFeedback_Name() {
		return (EAttribute)userFeedbackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUserFeedback_Subject() {
		return (EReference)userFeedbackEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReview() {
		return reviewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getReview_GradeType() {
		return (EAttribute)reviewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getReview_ReviewType() {
		return (EAttribute)reviewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComment() {
		return commentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComment_Reply() {
		return (EAttribute)commentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComment_Moderation() {
		return (EAttribute)commentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComment_CommentType() {
		return (EAttribute)commentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComment_Moderationprocess() {
		return (EReference)commentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComment_HasModerationProcess() {
		return (EAttribute)commentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModerationProcess() {
		return moderationProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModerationProcess_Name() {
		return (EAttribute)moderationProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModerationProcess_CanDelete() {
		return (EAttribute)moderationProcessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModerationProcess_Step() {
		return (EReference)moderationProcessEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModerationProcess_StartStop() {
		return (EReference)moderationProcessEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStep() {
		return stepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStep_Name() {
		return (EAttribute)stepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEnd() {
		return endEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValidationStep() {
		return validationStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValidationStep_NextApprove() {
		return (EReference)validationStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValidationStep_NextReject() {
		return (EReference)validationStepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAutomatic() {
		return automaticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAutomatic_Method() {
		return (EAttribute)automaticEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getManual() {
		return manualEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getGradeType() {
		return gradeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getReviewType() {
		return reviewTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getCommentType() {
		return commentTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Cr2Factory getCr2Factory() {
		return (Cr2Factory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		modelEClass = createEClass(MODEL);
		createEReference(modelEClass, MODEL__SUBJECT);
		createEAttribute(modelEClass, MODEL__NAME);

		subjectEClass = createEClass(SUBJECT);
		createEAttribute(subjectEClass, SUBJECT__NAME);
		createEReference(subjectEClass, SUBJECT__FEATURE);
		createEReference(subjectEClass, SUBJECT__USERFEEDBACK);
		createEAttribute(subjectEClass, SUBJECT__FEATURE_COUNT);

		featureEClass = createEClass(FEATURE);
		createEAttribute(featureEClass, FEATURE__NAME);

		userFeedbackEClass = createEClass(USER_FEEDBACK);
		createEAttribute(userFeedbackEClass, USER_FEEDBACK__NAME);
		createEReference(userFeedbackEClass, USER_FEEDBACK__SUBJECT);

		reviewEClass = createEClass(REVIEW);
		createEAttribute(reviewEClass, REVIEW__GRADE_TYPE);
		createEAttribute(reviewEClass, REVIEW__REVIEW_TYPE);

		commentEClass = createEClass(COMMENT);
		createEAttribute(commentEClass, COMMENT__REPLY);
		createEAttribute(commentEClass, COMMENT__MODERATION);
		createEAttribute(commentEClass, COMMENT__COMMENT_TYPE);
		createEReference(commentEClass, COMMENT__MODERATIONPROCESS);
		createEAttribute(commentEClass, COMMENT__HAS_MODERATION_PROCESS);

		moderationProcessEClass = createEClass(MODERATION_PROCESS);
		createEAttribute(moderationProcessEClass, MODERATION_PROCESS__NAME);
		createEAttribute(moderationProcessEClass, MODERATION_PROCESS__CAN_DELETE);
		createEReference(moderationProcessEClass, MODERATION_PROCESS__STEP);
		createEReference(moderationProcessEClass, MODERATION_PROCESS__START_STOP);

		stepEClass = createEClass(STEP);
		createEAttribute(stepEClass, STEP__NAME);

		endEClass = createEClass(END);

		validationStepEClass = createEClass(VALIDATION_STEP);
		createEReference(validationStepEClass, VALIDATION_STEP__NEXT_APPROVE);
		createEReference(validationStepEClass, VALIDATION_STEP__NEXT_REJECT);

		automaticEClass = createEClass(AUTOMATIC);
		createEAttribute(automaticEClass, AUTOMATIC__METHOD);

		manualEClass = createEClass(MANUAL);

		// Create enums
		gradeTypeEEnum = createEEnum(GRADE_TYPE);
		reviewTypeEEnum = createEEnum(REVIEW_TYPE);
		commentTypeEEnum = createEEnum(COMMENT_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		reviewEClass.getESuperTypes().add(this.getUserFeedback());
		commentEClass.getESuperTypes().add(this.getUserFeedback());
		endEClass.getESuperTypes().add(this.getStep());
		validationStepEClass.getESuperTypes().add(this.getStep());
		automaticEClass.getESuperTypes().add(this.getValidationStep());
		manualEClass.getESuperTypes().add(this.getValidationStep());

		// Initialize classes and features; add operations and parameters
		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModel_Subject(), this.getSubject(), null, "subject", null, 1, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subjectEClass, Subject.class, "Subject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSubject_Name(), ecorePackage.getEString(), "name", null, 0, 1, Subject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubject_Feature(), this.getFeature(), null, "feature", null, 0, -1, Subject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubject_Userfeedback(), this.getUserFeedback(), this.getUserFeedback_Subject(), "userfeedback", null, 1, 2, Subject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubject_FeatureCount(), ecorePackage.getEBigInteger(), "featureCount", null, 0, 1, Subject.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeature_Name(), ecorePackage.getEString(), "name", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userFeedbackEClass, UserFeedback.class, "UserFeedback", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUserFeedback_Name(), ecorePackage.getEString(), "name", null, 0, 1, UserFeedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserFeedback_Subject(), this.getSubject(), this.getSubject_Userfeedback(), "subject", null, 0, 1, UserFeedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(reviewEClass, Review.class, "Review", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReview_GradeType(), this.getGradeType(), "gradeType", null, 0, 1, Review.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReview_ReviewType(), this.getReviewType(), "reviewType", null, 0, 1, Review.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commentEClass, Comment.class, "Comment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComment_Reply(), ecorePackage.getEBoolean(), "reply", null, 1, 1, Comment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComment_Moderation(), ecorePackage.getEBoolean(), "moderation", null, 1, 1, Comment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComment_CommentType(), this.getCommentType(), "commentType", null, 0, 1, Comment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComment_Moderationprocess(), this.getModerationProcess(), null, "moderationprocess", null, 0, 1, Comment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComment_HasModerationProcess(), ecorePackage.getEBoolean(), "hasModerationProcess", null, 1, 1, Comment.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(moderationProcessEClass, ModerationProcess.class, "ModerationProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModerationProcess_Name(), ecorePackage.getEString(), "name", null, 0, 1, ModerationProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModerationProcess_CanDelete(), ecorePackage.getEBoolean(), "canDelete", null, 1, 1, ModerationProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModerationProcess_Step(), this.getStep(), null, "step", null, 0, -1, ModerationProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModerationProcess_StartStop(), this.getValidationStep(), null, "startStop", null, 1, 1, ModerationProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stepEClass, Step.class, "Step", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStep_Name(), ecorePackage.getEString(), "name", null, 0, 1, Step.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(endEClass, End.class, "End", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(validationStepEClass, ValidationStep.class, "ValidationStep", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValidationStep_NextApprove(), this.getStep(), null, "nextApprove", null, 1, 1, ValidationStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidationStep_NextReject(), this.getStep(), null, "nextReject", null, 1, 1, ValidationStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(automaticEClass, Automatic.class, "Automatic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAutomatic_Method(), ecorePackage.getEString(), "method", null, 0, 1, Automatic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(manualEClass, Manual.class, "Manual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(gradeTypeEEnum, GradeType.class, "GradeType");
		addEEnumLiteral(gradeTypeEEnum, GradeType.CUSTOM);
		addEEnumLiteral(gradeTypeEEnum, GradeType.STARS);

		initEEnum(reviewTypeEEnum, ReviewType.class, "ReviewType");
		addEEnumLiteral(reviewTypeEEnum, ReviewType.ONLYGRADE);
		addEEnumLiteral(reviewTypeEEnum, ReviewType.ANNOTATED);

		initEEnum(commentTypeEEnum, CommentType.class, "CommentType");
		addEEnumLiteral(commentTypeEEnum, CommentType.SIMPLE);
		addEEnumLiteral(commentTypeEEnum, CommentType.RICHTEXT);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// gmf
		createGmfAnnotations();
		// gmf.diagram
		createGmf_1Annotations();
		// gmf.compartment
		createGmf_2Annotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
		// gmf.node
		createGmf_3Annotations();
		// gmf.link
		createGmf_4Annotations();
		// gmf.label
		createGmf_5Annotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			   "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			   "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
		   });
		addAnnotation
		  (subjectEClass,
		   source,
		   new String[] {
			   "constraints", "userFeedbackOfDifferentTypes"
		   });
		addAnnotation
		  (featureEClass,
		   source,
		   new String[] {
			   "constraints", "nameValidation nameMustBeUnique"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmfAnnotations() {
		String source = "gmf";
		addAnnotation
		  (this,
		   source,
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.diagram</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_1Annotations() {
		String source = "gmf.diagram";
		addAnnotation
		  (modelEClass,
		   source,
		   new String[] {
			   "diagram.extention", "cr2diagram"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.compartment</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_2Annotations() {
		String source = "gmf.compartment";
		addAnnotation
		  (getModel_Subject(),
		   source,
		   new String[] {
		   });
		addAnnotation
		  (getSubject_Feature(),
		   source,
		   new String[] {
			   "layout", "list"
		   });
		addAnnotation
		  (getModerationProcess_Step(),
		   source,
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
		addAnnotation
		  (subjectEClass,
		   source,
		   new String[] {
			   "userFeedbackOfDifferentTypes", "self.userfeedback->isUnique(oclType().name)"
		   });
		addAnnotation
		  (getSubject_FeatureCount(),
		   source,
		   new String[] {
			   "derivation", "self.feature->size()"
		   });
		addAnnotation
		  (featureEClass,
		   source,
		   new String[] {
			   "nameValidation", "not self.name.oclIsUndefined() and self.name.size() > 3 and self.name.substring(1,1).toUpper().compareTo(self.name.substring(1,1))=0",
			   "nameMustBeUnique", "Feature.allInstances()->isUnique(e | e.name)"
		   });
		addAnnotation
		  (getComment_HasModerationProcess(),
		   source,
		   new String[] {
			   "derivation", "not self.moderationprocess->isEmpty()"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.node</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_3Annotations() {
		String source = "gmf.node";
		addAnnotation
		  (subjectEClass,
		   source,
		   new String[] {
			   "label", "name"
		   });
		addAnnotation
		  (featureEClass,
		   source,
		   new String[] {
			   "label", "name"
		   });
		addAnnotation
		  (reviewEClass,
		   source,
		   new String[] {
			   "label", "name"
		   });
		addAnnotation
		  (commentEClass,
		   source,
		   new String[] {
			   "label", "name"
		   });
		addAnnotation
		  (moderationProcessEClass,
		   source,
		   new String[] {
			   "label", "name",
			   "phantom", "true"
		   });
		addAnnotation
		  (stepEClass,
		   source,
		   new String[] {
			   "label", "name"
		   });
		addAnnotation
		  (endEClass,
		   source,
		   new String[] {
			   "label", "name"
		   });
		addAnnotation
		  (validationStepEClass,
		   source,
		   new String[] {
			   "label", "name"
		   });
		addAnnotation
		  (automaticEClass,
		   source,
		   new String[] {
			   "label", "name"
		   });
		addAnnotation
		  (manualEClass,
		   source,
		   new String[] {
			   "label", "name"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.link</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_4Annotations() {
		String source = "gmf.link";
		addAnnotation
		  (getSubject_Userfeedback(),
		   source,
		   new String[] {
			   "target.decoration", "arrow"
		   });
		addAnnotation
		  (getValidationStep_NextApprove(),
		   source,
		   new String[] {
			   "target.decoration", "arrow"
		   });
		addAnnotation
		  (getValidationStep_NextReject(),
		   source,
		   new String[] {
			   "target.decoration", "arrow"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.label</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_5Annotations() {
		String source = "gmf.label";
		addAnnotation
		  (getSubject_FeatureCount(),
		   source,
		   new String[] {
			   "label.readOnly", "true"
		   });
	}

} //Cr2PackageImpl
