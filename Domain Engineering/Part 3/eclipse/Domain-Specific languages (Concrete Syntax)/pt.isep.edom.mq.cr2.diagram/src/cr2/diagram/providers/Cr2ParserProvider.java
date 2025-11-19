/*
 * 
 */
package cr2.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import cr2.Cr2Package;
import cr2.diagram.edit.parts.AutomaticNameEditPart;
import cr2.diagram.edit.parts.EndNameEditPart;
import cr2.diagram.edit.parts.FeatureNameEditPart;
import cr2.diagram.edit.parts.ManualNameEditPart;
import cr2.diagram.edit.parts.ModerationProcessNameEditPart;
import cr2.diagram.edit.parts.SubjectFeatureCountEditPart;
import cr2.diagram.edit.parts.SubjectNameEditPart;
import cr2.diagram.parsers.MessageFormatParser;
import cr2.diagram.part.Cr2VisualIDRegistry;

/**
 * @generated
 */
public class Cr2ParserProvider extends AbstractProvider implements IParserProvider {

	/**
	* @generated
	*/
	private IParser subjectName_5002Parser;

	/**
	* @generated
	*/
	private IParser getSubjectName_5002Parser() {
		if (subjectName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { Cr2Package.eINSTANCE.getSubject_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			subjectName_5002Parser = parser;
		}
		return subjectName_5002Parser;
	}

	/**
	* @generated
	*/
	private IParser subjectFeatureCount_5003Parser;

	/**
	* @generated
	*/
	private IParser getSubjectFeatureCount_5003Parser() {
		if (subjectFeatureCount_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { Cr2Package.eINSTANCE.getSubject_FeatureCount() };
			MessageFormatParser parser = new MessageFormatParser(features);
			subjectFeatureCount_5003Parser = parser;
		}
		return subjectFeatureCount_5003Parser;
	}

	/**
	* @generated
	*/
	private IParser moderationProcessName_5007Parser;

	/**
	* @generated
	*/
	private IParser getModerationProcessName_5007Parser() {
		if (moderationProcessName_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { Cr2Package.eINSTANCE.getModerationProcess_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			moderationProcessName_5007Parser = parser;
		}
		return moderationProcessName_5007Parser;
	}

	/**
	* @generated
	*/
	private IParser featureName_5001Parser;

	/**
	* @generated
	*/
	private IParser getFeatureName_5001Parser() {
		if (featureName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { Cr2Package.eINSTANCE.getFeature_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			featureName_5001Parser = parser;
		}
		return featureName_5001Parser;
	}

	/**
	* @generated
	*/
	private IParser automaticName_5004Parser;

	/**
	* @generated
	*/
	private IParser getAutomaticName_5004Parser() {
		if (automaticName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { Cr2Package.eINSTANCE.getStep_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			automaticName_5004Parser = parser;
		}
		return automaticName_5004Parser;
	}

	/**
	* @generated
	*/
	private IParser manualName_5005Parser;

	/**
	* @generated
	*/
	private IParser getManualName_5005Parser() {
		if (manualName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { Cr2Package.eINSTANCE.getStep_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			manualName_5005Parser = parser;
		}
		return manualName_5005Parser;
	}

	/**
	* @generated
	*/
	private IParser endName_5006Parser;

	/**
	* @generated
	*/
	private IParser getEndName_5006Parser() {
		if (endName_5006Parser == null) {
			EAttribute[] features = new EAttribute[] { Cr2Package.eINSTANCE.getStep_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			endName_5006Parser = parser;
		}
		return endName_5006Parser;
	}

	/**
	* @generated
	*/
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case SubjectNameEditPart.VISUAL_ID:
			return getSubjectName_5002Parser();
		case SubjectFeatureCountEditPart.VISUAL_ID:
			return getSubjectFeatureCount_5003Parser();
		case ModerationProcessNameEditPart.VISUAL_ID:
			return getModerationProcessName_5007Parser();
		case FeatureNameEditPart.VISUAL_ID:
			return getFeatureName_5001Parser();
		case AutomaticNameEditPart.VISUAL_ID:
			return getAutomaticName_5004Parser();
		case ManualNameEditPart.VISUAL_ID:
			return getManualName_5005Parser();
		case EndNameEditPart.VISUAL_ID:
			return getEndName_5006Parser();
		}
		return null;
	}

	/**
	* Utility method that consults ParserService
	* @generated
	*/
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	* @generated
	*/
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(Cr2VisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(Cr2VisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	* @generated
	*/
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (Cr2ElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	* @generated
	*/
	private static class HintAdapter extends ParserHintAdapter {

		/**
		* @generated
		*/
		private final IElementType elementType;

		/**
		* @generated
		*/
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		* @generated
		*/
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
