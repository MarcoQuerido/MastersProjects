/*
* 
*/
package cr2.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

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
import cr2.diagram.edit.parts.ModerationProcessNameEditPart;
import cr2.diagram.edit.parts.SubjectEditPart;
import cr2.diagram.edit.parts.SubjectNameEditPart;
import cr2.diagram.edit.parts.SubjectUserfeedbackEditPart;
import cr2.diagram.edit.parts.ValidationStepNextApproveEditPart;
import cr2.diagram.edit.parts.ValidationStepNextRejectEditPart;
import cr2.diagram.part.Cr2DiagramEditorPlugin;
import cr2.diagram.part.Cr2VisualIDRegistry;
import cr2.diagram.providers.Cr2ElementTypes;
import cr2.diagram.providers.Cr2ParserProvider;

/**
 * @generated
 */
public class Cr2NavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		Cr2DiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
		Cr2DiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof Cr2NavigatorItem && !isOwnView(((Cr2NavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof Cr2NavigatorGroup) {
			Cr2NavigatorGroup group = (Cr2NavigatorGroup) element;
			return Cr2DiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof Cr2NavigatorItem) {
			Cr2NavigatorItem navigatorItem = (Cr2NavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	* @generated
	*/
	public Image getImage(View view) {
		switch (Cr2VisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.example.org/cr2?Model", Cr2ElementTypes.Model_1000); //$NON-NLS-1$
		case SubjectEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/cr2?Subject", Cr2ElementTypes.Subject_2001); //$NON-NLS-1$
		case ModerationProcessEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/cr2?ModerationProcess", //$NON-NLS-1$
					Cr2ElementTypes.ModerationProcess_2002);
		case FeatureEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/cr2?Feature", Cr2ElementTypes.Feature_3001); //$NON-NLS-1$
		case AutomaticEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/cr2?Automatic", Cr2ElementTypes.Automatic_3002); //$NON-NLS-1$
		case ManualEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/cr2?Manual", Cr2ElementTypes.Manual_3003); //$NON-NLS-1$
		case EndEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/cr2?End", Cr2ElementTypes.End_3004); //$NON-NLS-1$
		case SubjectUserfeedbackEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/cr2?Subject?userfeedback", //$NON-NLS-1$
					Cr2ElementTypes.SubjectUserfeedback_4001);
		case ValidationStepNextApproveEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/cr2?ValidationStep?nextApprove", //$NON-NLS-1$
					Cr2ElementTypes.ValidationStepNextApprove_4002);
		case ValidationStepNextRejectEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/cr2?ValidationStep?nextReject", //$NON-NLS-1$
					Cr2ElementTypes.ValidationStepNextReject_4003);
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = Cr2DiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && Cr2ElementTypes.isKnownElementType(elementType)) {
			image = Cr2ElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	* @generated
	*/
	public String getText(Object element) {
		if (element instanceof Cr2NavigatorGroup) {
			Cr2NavigatorGroup group = (Cr2NavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof Cr2NavigatorItem) {
			Cr2NavigatorItem navigatorItem = (Cr2NavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}

		return super.getText(element);
	}

	/**
	* @generated
	*/
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (Cr2VisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getModel_1000Text(view);
		case SubjectEditPart.VISUAL_ID:
			return getSubject_2001Text(view);
		case ModerationProcessEditPart.VISUAL_ID:
			return getModerationProcess_2002Text(view);
		case FeatureEditPart.VISUAL_ID:
			return getFeature_3001Text(view);
		case AutomaticEditPart.VISUAL_ID:
			return getAutomatic_3002Text(view);
		case ManualEditPart.VISUAL_ID:
			return getManual_3003Text(view);
		case EndEditPart.VISUAL_ID:
			return getEnd_3004Text(view);
		case SubjectUserfeedbackEditPart.VISUAL_ID:
			return getSubjectUserfeedback_4001Text(view);
		case ValidationStepNextApproveEditPart.VISUAL_ID:
			return getValidationStepNextApprove_4002Text(view);
		case ValidationStepNextRejectEditPart.VISUAL_ID:
			return getValidationStepNextReject_4003Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	* @generated
	*/
	private String getModel_1000Text(View view) {
		Model domainModelElement = (Model) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			Cr2DiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getSubject_2001Text(View view) {
		IParser parser = Cr2ParserProvider.getParser(Cr2ElementTypes.Subject_2001,
				view.getElement() != null ? view.getElement() : view,
				Cr2VisualIDRegistry.getType(SubjectNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			Cr2DiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getModerationProcess_2002Text(View view) {
		IParser parser = Cr2ParserProvider.getParser(Cr2ElementTypes.ModerationProcess_2002,
				view.getElement() != null ? view.getElement() : view,
				Cr2VisualIDRegistry.getType(ModerationProcessNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			Cr2DiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getFeature_3001Text(View view) {
		IParser parser = Cr2ParserProvider.getParser(Cr2ElementTypes.Feature_3001,
				view.getElement() != null ? view.getElement() : view,
				Cr2VisualIDRegistry.getType(FeatureNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			Cr2DiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getAutomatic_3002Text(View view) {
		IParser parser = Cr2ParserProvider.getParser(Cr2ElementTypes.Automatic_3002,
				view.getElement() != null ? view.getElement() : view,
				Cr2VisualIDRegistry.getType(AutomaticNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			Cr2DiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getManual_3003Text(View view) {
		IParser parser = Cr2ParserProvider.getParser(Cr2ElementTypes.Manual_3003,
				view.getElement() != null ? view.getElement() : view,
				Cr2VisualIDRegistry.getType(ManualNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			Cr2DiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getEnd_3004Text(View view) {
		IParser parser = Cr2ParserProvider.getParser(Cr2ElementTypes.End_3004,
				view.getElement() != null ? view.getElement() : view,
				Cr2VisualIDRegistry.getType(EndNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			Cr2DiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getSubjectUserfeedback_4001Text(View view) {
		IParser parser = Cr2ParserProvider.getParser(Cr2ElementTypes.SubjectUserfeedback_4001,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			Cr2DiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getValidationStepNextApprove_4002Text(View view) {
		IParser parser = Cr2ParserProvider.getParser(Cr2ElementTypes.ValidationStepNextApprove_4002,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			Cr2DiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getValidationStepNextReject_4003Text(View view) {
		IParser parser = Cr2ParserProvider.getParser(Cr2ElementTypes.ValidationStepNextReject_4003,
				view.getElement() != null ? view.getElement() : view, CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			Cr2DiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public void restoreState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public void saveState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	* @generated
	*/
	private boolean isOwnView(View view) {
		return ModelEditPart.MODEL_ID.equals(Cr2VisualIDRegistry.getModelID(view));
	}

}
