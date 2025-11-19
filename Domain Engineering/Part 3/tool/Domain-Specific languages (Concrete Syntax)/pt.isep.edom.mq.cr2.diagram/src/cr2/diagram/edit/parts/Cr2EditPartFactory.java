/*
 * 
 */
package cr2.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import cr2.diagram.part.Cr2VisualIDRegistry;

/**
 * @generated
 */
public class Cr2EditPartFactory implements EditPartFactory {

	/**
	* @generated
	*/
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (Cr2VisualIDRegistry.getVisualID(view)) {

			case ModelEditPart.VISUAL_ID:
				return new ModelEditPart(view);

			case SubjectEditPart.VISUAL_ID:
				return new SubjectEditPart(view);

			case SubjectNameEditPart.VISUAL_ID:
				return new SubjectNameEditPart(view);

			case SubjectFeatureCountEditPart.VISUAL_ID:
				return new SubjectFeatureCountEditPart(view);

			case ModerationProcessEditPart.VISUAL_ID:
				return new ModerationProcessEditPart(view);

			case ModerationProcessNameEditPart.VISUAL_ID:
				return new ModerationProcessNameEditPart(view);

			case FeatureEditPart.VISUAL_ID:
				return new FeatureEditPart(view);

			case FeatureNameEditPart.VISUAL_ID:
				return new FeatureNameEditPart(view);

			case AutomaticEditPart.VISUAL_ID:
				return new AutomaticEditPart(view);

			case AutomaticNameEditPart.VISUAL_ID:
				return new AutomaticNameEditPart(view);

			case ManualEditPart.VISUAL_ID:
				return new ManualEditPart(view);

			case ManualNameEditPart.VISUAL_ID:
				return new ManualNameEditPart(view);

			case EndEditPart.VISUAL_ID:
				return new EndEditPart(view);

			case EndNameEditPart.VISUAL_ID:
				return new EndNameEditPart(view);

			case SubjectSubjectFeatureCompartmentEditPart.VISUAL_ID:
				return new SubjectSubjectFeatureCompartmentEditPart(view);

			case ModerationProcessModerationProcessStepCompartmentEditPart.VISUAL_ID:
				return new ModerationProcessModerationProcessStepCompartmentEditPart(view);

			case SubjectUserfeedbackEditPart.VISUAL_ID:
				return new SubjectUserfeedbackEditPart(view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

			case ValidationStepNextApproveEditPart.VISUAL_ID:
				return new ValidationStepNextApproveEditPart(view);

			case WrappingLabel2EditPart.VISUAL_ID:
				return new WrappingLabel2EditPart(view);

			case ValidationStepNextRejectEditPart.VISUAL_ID:
				return new ValidationStepNextRejectEditPart(view);

			case WrappingLabel3EditPart.VISUAL_ID:
				return new WrappingLabel3EditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	* @generated
	*/
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	* @generated
	*/
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
	}

}
