/*
* 
*/
package cr2.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

import cr2.Cr2Package;
import cr2.Model;
import cr2.diagram.edit.parts.AutomaticEditPart;
import cr2.diagram.edit.parts.AutomaticNameEditPart;
import cr2.diagram.edit.parts.EndEditPart;
import cr2.diagram.edit.parts.EndNameEditPart;
import cr2.diagram.edit.parts.FeatureEditPart;
import cr2.diagram.edit.parts.FeatureNameEditPart;
import cr2.diagram.edit.parts.ManualEditPart;
import cr2.diagram.edit.parts.ManualNameEditPart;
import cr2.diagram.edit.parts.ModelEditPart;
import cr2.diagram.edit.parts.ModerationProcessEditPart;
import cr2.diagram.edit.parts.ModerationProcessModerationProcessStepCompartmentEditPart;
import cr2.diagram.edit.parts.ModerationProcessNameEditPart;
import cr2.diagram.edit.parts.SubjectEditPart;
import cr2.diagram.edit.parts.SubjectFeatureCountEditPart;
import cr2.diagram.edit.parts.SubjectNameEditPart;
import cr2.diagram.edit.parts.SubjectSubjectFeatureCompartmentEditPart;
import cr2.diagram.edit.parts.SubjectUserfeedbackEditPart;
import cr2.diagram.edit.parts.ValidationStepNextApproveEditPart;
import cr2.diagram.edit.parts.ValidationStepNextRejectEditPart;
import cr2.diagram.edit.parts.WrappingLabel2EditPart;
import cr2.diagram.edit.parts.WrappingLabel3EditPart;
import cr2.diagram.edit.parts.WrappingLabelEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class Cr2VisualIDRegistry {

	/**
	* @generated
	*/
	private static final String DEBUG_KEY = "pt.isep.edom.mq.cr2.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	* @generated
	*/
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (ModelEditPart.MODEL_ID.equals(view.getType())) {
				return ModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return cr2.diagram.part.Cr2VisualIDRegistry.getVisualID(view.getType());
	}

	/**
	* @generated
	*/
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	* @generated
	*/
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				Cr2DiagramEditorPlugin.getInstance()
						.logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	* @generated
	*/
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (Cr2Package.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass()) && isDiagram((Model) domainElement)) {
			return ModelEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = cr2.diagram.part.Cr2VisualIDRegistry.getModelID(containerView);
		if (!ModelEditPart.MODEL_ID.equals(containerModelID) && !"cr2".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (ModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = cr2.diagram.part.Cr2VisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case ModelEditPart.VISUAL_ID:
			if (Cr2Package.eINSTANCE.getSubject().isSuperTypeOf(domainElement.eClass())) {
				return SubjectEditPart.VISUAL_ID;
			}
			if (Cr2Package.eINSTANCE.getModerationProcess().isSuperTypeOf(domainElement.eClass())) {
				return ModerationProcessEditPart.VISUAL_ID;
			}
			break;
		case SubjectSubjectFeatureCompartmentEditPart.VISUAL_ID:
			if (Cr2Package.eINSTANCE.getFeature().isSuperTypeOf(domainElement.eClass())) {
				return FeatureEditPart.VISUAL_ID;
			}
			break;
		case ModerationProcessModerationProcessStepCompartmentEditPart.VISUAL_ID:
			if (Cr2Package.eINSTANCE.getAutomatic().isSuperTypeOf(domainElement.eClass())) {
				return AutomaticEditPart.VISUAL_ID;
			}
			if (Cr2Package.eINSTANCE.getManual().isSuperTypeOf(domainElement.eClass())) {
				return ManualEditPart.VISUAL_ID;
			}
			if (Cr2Package.eINSTANCE.getEnd().isSuperTypeOf(domainElement.eClass())) {
				return EndEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = cr2.diagram.part.Cr2VisualIDRegistry.getModelID(containerView);
		if (!ModelEditPart.MODEL_ID.equals(containerModelID) && !"cr2".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (ModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = cr2.diagram.part.Cr2VisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ModelEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case ModelEditPart.VISUAL_ID:
			if (SubjectEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ModerationProcessEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SubjectEditPart.VISUAL_ID:
			if (SubjectNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SubjectFeatureCountEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SubjectSubjectFeatureCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModerationProcessEditPart.VISUAL_ID:
			if (ModerationProcessNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ModerationProcessModerationProcessStepCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FeatureEditPart.VISUAL_ID:
			if (FeatureNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AutomaticEditPart.VISUAL_ID:
			if (AutomaticNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ManualEditPart.VISUAL_ID:
			if (ManualNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EndEditPart.VISUAL_ID:
			if (EndNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SubjectSubjectFeatureCompartmentEditPart.VISUAL_ID:
			if (FeatureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModerationProcessModerationProcessStepCompartmentEditPart.VISUAL_ID:
			if (AutomaticEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ManualEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EndEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SubjectUserfeedbackEditPart.VISUAL_ID:
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ValidationStepNextApproveEditPart.VISUAL_ID:
			if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ValidationStepNextRejectEditPart.VISUAL_ID:
			if (WrappingLabel3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	* User can change implementation of this method to handle some specific
	* situations not covered by default logic.
	* 
	* @generated
	*/
	private static boolean isDiagram(Model element) {
		return true;
	}

	/**
	* @generated
	*/
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	* @generated
	*/
	public static boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case SubjectSubjectFeatureCompartmentEditPart.VISUAL_ID:
		case ModerationProcessModerationProcessStepCompartmentEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case ModelEditPart.VISUAL_ID:
			return false;
		case FeatureEditPart.VISUAL_ID:
		case AutomaticEditPart.VISUAL_ID:
		case ManualEditPart.VISUAL_ID:
		case EndEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		* @generated
		*/
		@Override

		public int getVisualID(View view) {
			return cr2.diagram.part.Cr2VisualIDRegistry.getVisualID(view);
		}

		/**
		* @generated
		*/
		@Override

		public String getModelID(View view) {
			return cr2.diagram.part.Cr2VisualIDRegistry.getModelID(view);
		}

		/**
		* @generated
		*/
		@Override

		public int getNodeVisualID(View containerView, EObject domainElement) {
			return cr2.diagram.part.Cr2VisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		* @generated
		*/
		@Override

		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return cr2.diagram.part.Cr2VisualIDRegistry.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isCompartmentVisualID(int visualID) {
			return cr2.diagram.part.Cr2VisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isSemanticLeafVisualID(int visualID) {
			return cr2.diagram.part.Cr2VisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

}
