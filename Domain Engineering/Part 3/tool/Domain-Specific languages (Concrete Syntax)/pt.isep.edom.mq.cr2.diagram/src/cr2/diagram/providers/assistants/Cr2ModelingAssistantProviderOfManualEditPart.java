/*
 * 
 */
package cr2.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import cr2.diagram.edit.parts.AutomaticEditPart;
import cr2.diagram.edit.parts.EndEditPart;
import cr2.diagram.edit.parts.ManualEditPart;
import cr2.diagram.providers.Cr2ElementTypes;
import cr2.diagram.providers.Cr2ModelingAssistantProvider;

/**
 * @generated
 */
public class Cr2ModelingAssistantProviderOfManualEditPart extends Cr2ModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((ManualEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(ManualEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(Cr2ElementTypes.ValidationStepNextApprove_4002);
		types.add(Cr2ElementTypes.ValidationStepNextReject_4003);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((ManualEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(ManualEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof AutomaticEditPart) {
			types.add(Cr2ElementTypes.ValidationStepNextApprove_4002);
		}
		if (targetEditPart instanceof ManualEditPart) {
			types.add(Cr2ElementTypes.ValidationStepNextApprove_4002);
		}
		if (targetEditPart instanceof EndEditPart) {
			types.add(Cr2ElementTypes.ValidationStepNextApprove_4002);
		}
		if (targetEditPart instanceof AutomaticEditPart) {
			types.add(Cr2ElementTypes.ValidationStepNextReject_4003);
		}
		if (targetEditPart instanceof ManualEditPart) {
			types.add(Cr2ElementTypes.ValidationStepNextReject_4003);
		}
		if (targetEditPart instanceof EndEditPart) {
			types.add(Cr2ElementTypes.ValidationStepNextReject_4003);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((ManualEditPart) sourceEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(ManualEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == Cr2ElementTypes.ValidationStepNextApprove_4002) {
			types.add(Cr2ElementTypes.Automatic_3002);
			types.add(Cr2ElementTypes.Manual_3003);
			types.add(Cr2ElementTypes.End_3004);
		} else if (relationshipType == Cr2ElementTypes.ValidationStepNextReject_4003) {
			types.add(Cr2ElementTypes.Automatic_3002);
			types.add(Cr2ElementTypes.Manual_3003);
			types.add(Cr2ElementTypes.End_3004);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((ManualEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(ManualEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(Cr2ElementTypes.ValidationStepNextApprove_4002);
		types.add(Cr2ElementTypes.ValidationStepNextReject_4003);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((ManualEditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(ManualEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == Cr2ElementTypes.ValidationStepNextApprove_4002) {
			types.add(Cr2ElementTypes.Automatic_3002);
			types.add(Cr2ElementTypes.Manual_3003);
		} else if (relationshipType == Cr2ElementTypes.ValidationStepNextReject_4003) {
			types.add(Cr2ElementTypes.Automatic_3002);
			types.add(Cr2ElementTypes.Manual_3003);
		}
		return types;
	}

}
