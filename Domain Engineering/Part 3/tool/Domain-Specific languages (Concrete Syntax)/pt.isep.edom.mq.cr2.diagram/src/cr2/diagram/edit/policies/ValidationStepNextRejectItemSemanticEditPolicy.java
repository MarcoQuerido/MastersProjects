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
public class ValidationStepNextRejectItemSemanticEditPolicy extends Cr2BaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ValidationStepNextRejectItemSemanticEditPolicy() {
		super(Cr2ElementTypes.ValidationStepNextReject_4003);
	}

	/**
	* @generated
	*/
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
