/*
* 
*/
package cr2.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import cr2.diagram.edit.commands.ModerationProcessCreateCommand;
import cr2.diagram.edit.commands.SubjectCreateCommand;
import cr2.diagram.providers.Cr2ElementTypes;

/**
 * @generated
 */
public class ModelItemSemanticEditPolicy extends Cr2BaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ModelItemSemanticEditPolicy() {
		super(Cr2ElementTypes.Model_1000);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (Cr2ElementTypes.Subject_2001 == req.getElementType()) {
			return getGEFWrapper(new SubjectCreateCommand(req));
		}
		if (Cr2ElementTypes.ModerationProcess_2002 == req.getElementType()) {
			return getGEFWrapper(new ModerationProcessCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	* @generated
	*/
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	* @generated
	*/
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		* @generated
		*/
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}

	}

}
