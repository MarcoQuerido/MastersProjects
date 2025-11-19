/*
 * 
 */
package cr2.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import cr2.Cr2Package;
import cr2.diagram.edit.parts.AutomaticEditPart;
import cr2.diagram.edit.parts.EndEditPart;
import cr2.diagram.edit.parts.FeatureEditPart;
import cr2.diagram.edit.parts.ManualEditPart;
import cr2.diagram.edit.parts.ModelEditPart;
import cr2.diagram.edit.parts.ModerationProcessEditPart;
import cr2.diagram.edit.parts.SubjectEditPart;
import cr2.diagram.edit.parts.SubjectUserfeedbackEditPart;
import cr2.diagram.edit.parts.ValidationStepNextApproveEditPart;
import cr2.diagram.edit.parts.ValidationStepNextRejectEditPart;
import cr2.diagram.part.Cr2DiagramEditorPlugin;

/**
 * @generated
 */
public class Cr2ElementTypes {

	/**
	* @generated
	*/
	private Cr2ElementTypes() {
	}

	/**
	* @generated
	*/
	private static Map<IElementType, ENamedElement> elements;

	/**
	* @generated
	*/
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			Cr2DiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType Model_1000 = getElementType("pt.isep.edom.mq.cr2.diagram.Model_1000"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Subject_2001 = getElementType("pt.isep.edom.mq.cr2.diagram.Subject_2001"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType ModerationProcess_2002 = getElementType(
			"pt.isep.edom.mq.cr2.diagram.ModerationProcess_2002"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Feature_3001 = getElementType("pt.isep.edom.mq.cr2.diagram.Feature_3001"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Automatic_3002 = getElementType("pt.isep.edom.mq.cr2.diagram.Automatic_3002"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Manual_3003 = getElementType("pt.isep.edom.mq.cr2.diagram.Manual_3003"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType End_3004 = getElementType("pt.isep.edom.mq.cr2.diagram.End_3004"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType SubjectUserfeedback_4001 = getElementType(
			"pt.isep.edom.mq.cr2.diagram.SubjectUserfeedback_4001"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType ValidationStepNextApprove_4002 = getElementType(
			"pt.isep.edom.mq.cr2.diagram.ValidationStepNextApprove_4002"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType ValidationStepNextReject_4003 = getElementType(
			"pt.isep.edom.mq.cr2.diagram.ValidationStepNextReject_4003"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	* @generated
	*/
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	* @generated
	*/
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	* Returns 'type' of the ecore object associated with the hint.
	* 
	* @generated
	*/
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Model_1000, Cr2Package.eINSTANCE.getModel());

			elements.put(Subject_2001, Cr2Package.eINSTANCE.getSubject());

			elements.put(ModerationProcess_2002, Cr2Package.eINSTANCE.getModerationProcess());

			elements.put(Feature_3001, Cr2Package.eINSTANCE.getFeature());

			elements.put(Automatic_3002, Cr2Package.eINSTANCE.getAutomatic());

			elements.put(Manual_3003, Cr2Package.eINSTANCE.getManual());

			elements.put(End_3004, Cr2Package.eINSTANCE.getEnd());

			elements.put(SubjectUserfeedback_4001, Cr2Package.eINSTANCE.getSubject_Userfeedback());

			elements.put(ValidationStepNextApprove_4002, Cr2Package.eINSTANCE.getValidationStep_NextApprove());

			elements.put(ValidationStepNextReject_4003, Cr2Package.eINSTANCE.getValidationStep_NextReject());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	* @generated
	*/
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	* @generated
	*/
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Model_1000);
			KNOWN_ELEMENT_TYPES.add(Subject_2001);
			KNOWN_ELEMENT_TYPES.add(ModerationProcess_2002);
			KNOWN_ELEMENT_TYPES.add(Feature_3001);
			KNOWN_ELEMENT_TYPES.add(Automatic_3002);
			KNOWN_ELEMENT_TYPES.add(Manual_3003);
			KNOWN_ELEMENT_TYPES.add(End_3004);
			KNOWN_ELEMENT_TYPES.add(SubjectUserfeedback_4001);
			KNOWN_ELEMENT_TYPES.add(ValidationStepNextApprove_4002);
			KNOWN_ELEMENT_TYPES.add(ValidationStepNextReject_4003);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	* @generated
	*/
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case ModelEditPart.VISUAL_ID:
			return Model_1000;
		case SubjectEditPart.VISUAL_ID:
			return Subject_2001;
		case ModerationProcessEditPart.VISUAL_ID:
			return ModerationProcess_2002;
		case FeatureEditPart.VISUAL_ID:
			return Feature_3001;
		case AutomaticEditPart.VISUAL_ID:
			return Automatic_3002;
		case ManualEditPart.VISUAL_ID:
			return Manual_3003;
		case EndEditPart.VISUAL_ID:
			return End_3004;
		case SubjectUserfeedbackEditPart.VISUAL_ID:
			return SubjectUserfeedback_4001;
		case ValidationStepNextApproveEditPart.VISUAL_ID:
			return ValidationStepNextApprove_4002;
		case ValidationStepNextRejectEditPart.VISUAL_ID:
			return ValidationStepNextReject_4003;
		}
		return null;
	}

	/**
	* @generated
	*/
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {

		/**
		* @generated
		*/
		@Override

		public boolean isKnownElementType(IElementType elementType) {
			return cr2.diagram.providers.Cr2ElementTypes.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override

		public IElementType getElementTypeForVisualId(int visualID) {
			return cr2.diagram.providers.Cr2ElementTypes.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return cr2.diagram.providers.Cr2ElementTypes.getElement(elementTypeAdapter);
		}
	};

}
