/*
* 
*/
package cr2.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import cr2.diagram.part.Cr2VisualIDRegistry;

/**
 * @generated
 */
public class Cr2NavigatorSorter extends ViewerSorter {

	/**
	* @generated
	*/
	private static final int GROUP_CATEGORY = 7004;

	/**
	* @generated
	*/
	private static final int SHORTCUTS_CATEGORY = 7003;

	/**
	* @generated
	*/
	public int category(Object element) {
		if (element instanceof Cr2NavigatorItem) {
			Cr2NavigatorItem item = (Cr2NavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return Cr2VisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
