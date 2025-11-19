/*
 * 
 */
package cr2.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import cr2.diagram.edit.parts.EndEditPart;
import cr2.diagram.providers.Cr2ElementTypes;
import cr2.diagram.providers.Cr2ModelingAssistantProvider;

/**
 * @generated
 */
public class Cr2ModelingAssistantProviderOfEndEditPart extends Cr2ModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((EndEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(EndEditPart target) {
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
		return doGetTypesForSource((EndEditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(EndEditPart target, IElementType relationshipType) {
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
