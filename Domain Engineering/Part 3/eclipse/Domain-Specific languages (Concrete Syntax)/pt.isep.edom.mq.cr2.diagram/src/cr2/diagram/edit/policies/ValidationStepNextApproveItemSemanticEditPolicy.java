/*
* 
*/
package cr2.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import cr2.diagram.providers.Cr2ElementTypes;

/**
 * @generated
 */
public class ValidationStepNextApproveItemSemanticEditPolicy extends Cr2BaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ValidationStepNextApproveItemSemanticEditPolicy() {
		super(Cr2ElementTypes.ValidationStepNextApprove_4002);
	}

	/**
	* @generated
	*/
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
