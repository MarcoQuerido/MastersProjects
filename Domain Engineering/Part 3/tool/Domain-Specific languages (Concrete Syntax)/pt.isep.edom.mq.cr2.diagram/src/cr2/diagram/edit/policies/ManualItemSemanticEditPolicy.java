/*
* 
*/
package cr2.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import cr2.diagram.edit.commands.ValidationStepNextApproveCreateCommand;
import cr2.diagram.edit.commands.ValidationStepNextApproveReorientCommand;
import cr2.diagram.edit.commands.ValidationStepNextRejectCreateCommand;
import cr2.diagram.edit.commands.ValidationStepNextRejectReorientCommand;
import cr2.diagram.edit.parts.ValidationStepNextApproveEditPart;
import cr2.diagram.edit.parts.ValidationStepNextRejectEditPart;
import cr2.diagram.part.Cr2VisualIDRegistry;
import cr2.diagram.providers.Cr2ElementTypes;

/**
 * @generated
 */
public class ManualItemSemanticEditPolicy extends Cr2BaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ManualItemSemanticEditPolicy() {
		super(Cr2ElementTypes.Manual_3003);
	}

	/**
	* @generated
	*/
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (Cr2VisualIDRegistry.getVisualID(incomingLink) == ValidationStepNextApproveEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (Cr2VisualIDRegistry.getVisualID(incomingLink) == ValidationStepNextRejectEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (Cr2VisualIDRegistry.getVisualID(outgoingLink) == ValidationStepNextApproveEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (Cr2VisualIDRegistry.getVisualID(outgoingLink) == ValidationStepNextRejectEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (Cr2ElementTypes.ValidationStepNextApprove_4002 == req.getElementType()) {
			return getGEFWrapper(new ValidationStepNextApproveCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (Cr2ElementTypes.ValidationStepNextReject_4003 == req.getElementType()) {
			return getGEFWrapper(new ValidationStepNextRejectCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (Cr2ElementTypes.ValidationStepNextApprove_4002 == req.getElementType()) {
			return getGEFWrapper(new ValidationStepNextApproveCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (Cr2ElementTypes.ValidationStepNextReject_4003 == req.getElementType()) {
			return getGEFWrapper(new ValidationStepNextRejectCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ValidationStepNextApproveEditPart.VISUAL_ID:
			return getGEFWrapper(new ValidationStepNextApproveReorientCommand(req));
		case ValidationStepNextRejectEditPart.VISUAL_ID:
			return getGEFWrapper(new ValidationStepNextRejectReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
