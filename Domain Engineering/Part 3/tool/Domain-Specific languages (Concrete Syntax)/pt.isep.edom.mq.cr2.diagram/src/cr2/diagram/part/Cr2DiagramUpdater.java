/*
* 
*/
package cr2.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import cr2.Automatic;
import cr2.Cr2Package;
import cr2.End;
import cr2.Feature;
import cr2.Manual;
import cr2.Model;
import cr2.ModerationProcess;
import cr2.Step;
import cr2.Subject;
import cr2.UserFeedback;
import cr2.ValidationStep;
import cr2.diagram.edit.parts.AutomaticEditPart;
import cr2.diagram.edit.parts.EndEditPart;
import cr2.diagram.edit.parts.FeatureEditPart;
import cr2.diagram.edit.parts.ManualEditPart;
import cr2.diagram.edit.parts.ModelEditPart;
import cr2.diagram.edit.parts.ModerationProcessEditPart;
import cr2.diagram.edit.parts.ModerationProcessModerationProcessStepCompartmentEditPart;
import cr2.diagram.edit.parts.SubjectEditPart;
import cr2.diagram.edit.parts.SubjectSubjectFeatureCompartmentEditPart;
import cr2.diagram.edit.parts.SubjectUserfeedbackEditPart;
import cr2.diagram.edit.parts.ValidationStepNextApproveEditPart;
import cr2.diagram.edit.parts.ValidationStepNextRejectEditPart;
import cr2.diagram.providers.Cr2ElementTypes;

/**
 * @generated
 */
public class Cr2DiagramUpdater {

	/**
	* @generated
	*/
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null || view.getElement().eIsProxy();
	}

	/**
	* @generated
	*/
	public static List<Cr2NodeDescriptor> getSemanticChildren(View view) {
		switch (Cr2VisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getModel_1000SemanticChildren(view);
		case SubjectSubjectFeatureCompartmentEditPart.VISUAL_ID:
			return getSubjectSubjectFeatureCompartment_7001SemanticChildren(view);
		case ModerationProcessModerationProcessStepCompartmentEditPart.VISUAL_ID:
			return getModerationProcessModerationProcessStepCompartment_7002SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<Cr2NodeDescriptor> getModel_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Model modelElement = (Model) view.getElement();
		LinkedList<Cr2NodeDescriptor> result = new LinkedList<Cr2NodeDescriptor>();
		{
			Subject childElement = modelElement.getSubject();
			int visualID = Cr2VisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SubjectEditPart.VISUAL_ID) {
				result.add(new Cr2NodeDescriptor(childElement, visualID));
			}
		}
		Resource resource = modelElement.eResource();
		for (Iterator<EObject> it = getPhantomNodesIterator(resource); it.hasNext();) {
			EObject childElement = it.next();
			if (childElement == modelElement) {
				continue;
			}
			if (Cr2VisualIDRegistry.getNodeVisualID(view, childElement) == ModerationProcessEditPart.VISUAL_ID) {
				result.add(new Cr2NodeDescriptor(childElement, ModerationProcessEditPart.VISUAL_ID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<Cr2NodeDescriptor> getSubjectSubjectFeatureCompartment_7001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Subject modelElement = (Subject) containerView.getElement();
		LinkedList<Cr2NodeDescriptor> result = new LinkedList<Cr2NodeDescriptor>();
		for (Iterator<?> it = modelElement.getFeature().iterator(); it.hasNext();) {
			Feature childElement = (Feature) it.next();
			int visualID = Cr2VisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FeatureEditPart.VISUAL_ID) {
				result.add(new Cr2NodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<Cr2NodeDescriptor> getModerationProcessModerationProcessStepCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		ModerationProcess modelElement = (ModerationProcess) containerView.getElement();
		LinkedList<Cr2NodeDescriptor> result = new LinkedList<Cr2NodeDescriptor>();
		for (Iterator<?> it = modelElement.getStep().iterator(); it.hasNext();) {
			Step childElement = (Step) it.next();
			int visualID = Cr2VisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == AutomaticEditPart.VISUAL_ID) {
				result.add(new Cr2NodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ManualEditPart.VISUAL_ID) {
				result.add(new Cr2NodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EndEditPart.VISUAL_ID) {
				result.add(new Cr2NodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Iterator<EObject> getPhantomNodesIterator(Resource resource) {
		return resource.getAllContents();
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getContainedLinks(View view) {
		switch (Cr2VisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getModel_1000ContainedLinks(view);
		case SubjectEditPart.VISUAL_ID:
			return getSubject_2001ContainedLinks(view);
		case ModerationProcessEditPart.VISUAL_ID:
			return getModerationProcess_2002ContainedLinks(view);
		case FeatureEditPart.VISUAL_ID:
			return getFeature_3001ContainedLinks(view);
		case AutomaticEditPart.VISUAL_ID:
			return getAutomatic_3002ContainedLinks(view);
		case ManualEditPart.VISUAL_ID:
			return getManual_3003ContainedLinks(view);
		case EndEditPart.VISUAL_ID:
			return getEnd_3004ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getIncomingLinks(View view) {
		switch (Cr2VisualIDRegistry.getVisualID(view)) {
		case SubjectEditPart.VISUAL_ID:
			return getSubject_2001IncomingLinks(view);
		case ModerationProcessEditPart.VISUAL_ID:
			return getModerationProcess_2002IncomingLinks(view);
		case FeatureEditPart.VISUAL_ID:
			return getFeature_3001IncomingLinks(view);
		case AutomaticEditPart.VISUAL_ID:
			return getAutomatic_3002IncomingLinks(view);
		case ManualEditPart.VISUAL_ID:
			return getManual_3003IncomingLinks(view);
		case EndEditPart.VISUAL_ID:
			return getEnd_3004IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getOutgoingLinks(View view) {
		switch (Cr2VisualIDRegistry.getVisualID(view)) {
		case SubjectEditPart.VISUAL_ID:
			return getSubject_2001OutgoingLinks(view);
		case ModerationProcessEditPart.VISUAL_ID:
			return getModerationProcess_2002OutgoingLinks(view);
		case FeatureEditPart.VISUAL_ID:
			return getFeature_3001OutgoingLinks(view);
		case AutomaticEditPart.VISUAL_ID:
			return getAutomatic_3002OutgoingLinks(view);
		case ManualEditPart.VISUAL_ID:
			return getManual_3003OutgoingLinks(view);
		case EndEditPart.VISUAL_ID:
			return getEnd_3004OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getModel_1000ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getSubject_2001ContainedLinks(View view) {
		Subject modelElement = (Subject) view.getElement();
		LinkedList<Cr2LinkDescriptor> result = new LinkedList<Cr2LinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Subject_Userfeedback_4001(modelElement));
		return result;
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getModerationProcess_2002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getFeature_3001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getAutomatic_3002ContainedLinks(View view) {
		Automatic modelElement = (Automatic) view.getElement();
		LinkedList<Cr2LinkDescriptor> result = new LinkedList<Cr2LinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ValidationStep_NextApprove_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ValidationStep_NextReject_4003(modelElement));
		return result;
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getManual_3003ContainedLinks(View view) {
		Manual modelElement = (Manual) view.getElement();
		LinkedList<Cr2LinkDescriptor> result = new LinkedList<Cr2LinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ValidationStep_NextApprove_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ValidationStep_NextReject_4003(modelElement));
		return result;
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getEnd_3004ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getSubject_2001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getModerationProcess_2002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getFeature_3001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getAutomatic_3002IncomingLinks(View view) {
		Automatic modelElement = (Automatic) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<Cr2LinkDescriptor> result = new LinkedList<Cr2LinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ValidationStep_NextApprove_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ValidationStep_NextReject_4003(modelElement, crossReferences));
		return result;
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getManual_3003IncomingLinks(View view) {
		Manual modelElement = (Manual) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<Cr2LinkDescriptor> result = new LinkedList<Cr2LinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ValidationStep_NextApprove_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ValidationStep_NextReject_4003(modelElement, crossReferences));
		return result;
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getEnd_3004IncomingLinks(View view) {
		End modelElement = (End) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<Cr2LinkDescriptor> result = new LinkedList<Cr2LinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ValidationStep_NextApprove_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_ValidationStep_NextReject_4003(modelElement, crossReferences));
		return result;
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getSubject_2001OutgoingLinks(View view) {
		Subject modelElement = (Subject) view.getElement();
		LinkedList<Cr2LinkDescriptor> result = new LinkedList<Cr2LinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Subject_Userfeedback_4001(modelElement));
		return result;
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getModerationProcess_2002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getFeature_3001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getAutomatic_3002OutgoingLinks(View view) {
		Automatic modelElement = (Automatic) view.getElement();
		LinkedList<Cr2LinkDescriptor> result = new LinkedList<Cr2LinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ValidationStep_NextApprove_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ValidationStep_NextReject_4003(modelElement));
		return result;
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getManual_3003OutgoingLinks(View view) {
		Manual modelElement = (Manual) view.getElement();
		LinkedList<Cr2LinkDescriptor> result = new LinkedList<Cr2LinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ValidationStep_NextApprove_4002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_ValidationStep_NextReject_4003(modelElement));
		return result;
	}

	/**
	* @generated
	*/
	public static List<Cr2LinkDescriptor> getEnd_3004OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	private static Collection<Cr2LinkDescriptor> getIncomingFeatureModelFacetLinks_ValidationStep_NextApprove_4002(
			Step target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<Cr2LinkDescriptor> result = new LinkedList<Cr2LinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == Cr2Package.eINSTANCE.getValidationStep_NextApprove()) {
				result.add(new Cr2LinkDescriptor(setting.getEObject(), target,
						Cr2ElementTypes.ValidationStepNextApprove_4002, ValidationStepNextApproveEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<Cr2LinkDescriptor> getIncomingFeatureModelFacetLinks_ValidationStep_NextReject_4003(
			Step target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<Cr2LinkDescriptor> result = new LinkedList<Cr2LinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == Cr2Package.eINSTANCE.getValidationStep_NextReject()) {
				result.add(new Cr2LinkDescriptor(setting.getEObject(), target,
						Cr2ElementTypes.ValidationStepNextReject_4003, ValidationStepNextRejectEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<Cr2LinkDescriptor> getOutgoingFeatureModelFacetLinks_Subject_Userfeedback_4001(
			Subject source) {
		LinkedList<Cr2LinkDescriptor> result = new LinkedList<Cr2LinkDescriptor>();
		for (Iterator<?> destinations = source.getUserfeedback().iterator(); destinations.hasNext();) {
			UserFeedback destination = (UserFeedback) destinations.next();
			result.add(new Cr2LinkDescriptor(source, destination, Cr2ElementTypes.SubjectUserfeedback_4001,
					SubjectUserfeedbackEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<Cr2LinkDescriptor> getOutgoingFeatureModelFacetLinks_ValidationStep_NextApprove_4002(
			ValidationStep source) {
		LinkedList<Cr2LinkDescriptor> result = new LinkedList<Cr2LinkDescriptor>();
		Step destination = source.getNextApprove();
		if (destination == null) {
			return result;
		}
		result.add(new Cr2LinkDescriptor(source, destination, Cr2ElementTypes.ValidationStepNextApprove_4002,
				ValidationStepNextApproveEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<Cr2LinkDescriptor> getOutgoingFeatureModelFacetLinks_ValidationStep_NextReject_4003(
			ValidationStep source) {
		LinkedList<Cr2LinkDescriptor> result = new LinkedList<Cr2LinkDescriptor>();
		Step destination = source.getNextReject();
		if (destination == null) {
			return result;
		}
		result.add(new Cr2LinkDescriptor(source, destination, Cr2ElementTypes.ValidationStepNextReject_4003,
				ValidationStepNextRejectEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		* @generated
		*/
		@Override

		public List<Cr2NodeDescriptor> getSemanticChildren(View view) {
			return Cr2DiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<Cr2LinkDescriptor> getContainedLinks(View view) {
			return Cr2DiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<Cr2LinkDescriptor> getIncomingLinks(View view) {
			return Cr2DiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<Cr2LinkDescriptor> getOutgoingLinks(View view) {
			return Cr2DiagramUpdater.getOutgoingLinks(view);
		}
	};

}
