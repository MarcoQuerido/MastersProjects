/*
 * 
 */
package cr2.diagram.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

import cr2.diagram.edit.parts.Cr2EditPartFactory;
import cr2.diagram.edit.parts.ModelEditPart;
import cr2.diagram.part.Cr2VisualIDRegistry;

/**
 * @generated
 */
public class Cr2EditPartProvider extends DefaultEditPartProvider {

	/**
	* @generated
	*/
	public Cr2EditPartProvider() {
		super(new Cr2EditPartFactory(), Cr2VisualIDRegistry.TYPED_INSTANCE, ModelEditPart.MODEL_ID);
	}

}
