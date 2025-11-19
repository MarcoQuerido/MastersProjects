
/*
 * 
 */
package cr2.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;

import cr2.diagram.providers.Cr2ElementTypes;

/**
 * @generated
 */
public class Cr2PaletteFactory {

	/**
	* @generated
	*/
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createObjects1Group());
		paletteRoot.add(createConnections2Group());
	}

	/**
	* Creates "Objects" palette tool group
	* @generated
	*/
	private PaletteContainer createObjects1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createAutomatic1CreationTool());
		paletteContainer.add(createComment2CreationTool());
		paletteContainer.add(createEnd3CreationTool());
		paletteContainer.add(createFeature4CreationTool());
		paletteContainer.add(createManual5CreationTool());
		paletteContainer.add(createModerationProcess6CreationTool());
		paletteContainer.add(createReview7CreationTool());
		paletteContainer.add(createSubject8CreationTool());
		return paletteContainer;
	}

	/**
	* Creates "Connections" palette tool group
	* @generated
	*/
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createNextApprove1CreationTool());
		paletteContainer.add(createNextReject2CreationTool());
		paletteContainer.add(createUserfeedback3CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createAutomatic1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Automatic1CreationTool_title,
				Messages.Automatic1CreationTool_desc, Collections.singletonList(Cr2ElementTypes.Automatic_3002));
		entry.setId("createAutomatic1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Cr2ElementTypes.getImageDescriptor(Cr2ElementTypes.Automatic_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createComment2CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.Comment2CreationTool_title, Messages.Comment2CreationTool_desc, null,
				null) {
		};
		entry.setId("createComment2CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createEnd3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.End3CreationTool_title,
				Messages.End3CreationTool_desc, Collections.singletonList(Cr2ElementTypes.End_3004));
		entry.setId("createEnd3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Cr2ElementTypes.getImageDescriptor(Cr2ElementTypes.End_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createFeature4CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Feature4CreationTool_title,
				Messages.Feature4CreationTool_desc, Collections.singletonList(Cr2ElementTypes.Feature_3001));
		entry.setId("createFeature4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Cr2ElementTypes.getImageDescriptor(Cr2ElementTypes.Feature_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createManual5CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Manual5CreationTool_title,
				Messages.Manual5CreationTool_desc, Collections.singletonList(Cr2ElementTypes.Manual_3003));
		entry.setId("createManual5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Cr2ElementTypes.getImageDescriptor(Cr2ElementTypes.Manual_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createModerationProcess6CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.ModerationProcess6CreationTool_title,
				Messages.ModerationProcess6CreationTool_desc,
				Collections.singletonList(Cr2ElementTypes.ModerationProcess_2002));
		entry.setId("createModerationProcess6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Cr2ElementTypes.getImageDescriptor(Cr2ElementTypes.ModerationProcess_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createReview7CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.Review7CreationTool_title, Messages.Review7CreationTool_desc, null,
				null) {
		};
		entry.setId("createReview7CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createSubject8CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Subject8CreationTool_title,
				Messages.Subject8CreationTool_desc, Collections.singletonList(Cr2ElementTypes.Subject_2001));
		entry.setId("createSubject8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Cr2ElementTypes.getImageDescriptor(Cr2ElementTypes.Subject_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createNextApprove1CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.NextApprove1CreationTool_title,
				Messages.NextApprove1CreationTool_desc,
				Collections.singletonList(Cr2ElementTypes.ValidationStepNextApprove_4002));
		entry.setId("createNextApprove1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Cr2ElementTypes.getImageDescriptor(Cr2ElementTypes.ValidationStepNextApprove_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createNextReject2CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.NextReject2CreationTool_title,
				Messages.NextReject2CreationTool_desc,
				Collections.singletonList(Cr2ElementTypes.ValidationStepNextReject_4003));
		entry.setId("createNextReject2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Cr2ElementTypes.getImageDescriptor(Cr2ElementTypes.ValidationStepNextReject_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createUserfeedback3CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.Userfeedback3CreationTool_title,
				Messages.Userfeedback3CreationTool_desc,
				Collections.singletonList(Cr2ElementTypes.SubjectUserfeedback_4001));
		entry.setId("createUserfeedback3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Cr2ElementTypes.getImageDescriptor(Cr2ElementTypes.SubjectUserfeedback_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
