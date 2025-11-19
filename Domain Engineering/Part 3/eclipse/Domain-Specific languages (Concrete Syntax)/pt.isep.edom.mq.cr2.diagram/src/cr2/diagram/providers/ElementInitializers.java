/*
 * 
 */
package cr2.diagram.providers;

import cr2.diagram.part.Cr2DiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	* @generated
	*/
	public static ElementInitializers getInstance() {
		ElementInitializers cached = Cr2DiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			Cr2DiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
