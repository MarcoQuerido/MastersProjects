/*
* 
*/
package cr2.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import cr2.diagram.edit.commands.FeatureCreateCommand;
import cr2.diagram.providers.Cr2ElementTypes;

/**
 * @generated
 */
public class SubjectSubjectFeatureCompartmentItemSemanticEditPolicy extends Cr2BaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public SubjectSubjectFeatureCompartmentItemSemanticEditPolicy() {
		super(Cr2ElementTypes.Subject_2001);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (Cr2ElementTypes.Feature_3001 == req.getElementType()) {
			return getGEFWrapper(new FeatureCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
