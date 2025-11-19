/*
 * 
 */
package cr2.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import cr2.diagram.providers.Cr2ElementTypes;
import cr2.diagram.providers.Cr2ModelingAssistantProvider;

/**
 * @generated
 */
public class Cr2ModelingAssistantProviderOfSubjectEditPart extends Cr2ModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(Cr2ElementTypes.Feature_3001);
		return types;
	}

}
