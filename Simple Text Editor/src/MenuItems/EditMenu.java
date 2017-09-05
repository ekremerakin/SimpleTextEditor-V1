package MenuItems;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

/*
 * EditMenu class is responsible for the
 * text actions like cutting, copying, pasting 
 * and selecting all the text inside the textArea.
 */
public class EditMenu extends JMenu {
	
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 3085668888434152159L;

	/*
	 * JMenuItem object to create the menu
	 * items.
	 */
	private JMenuItem menuItem;
	
	/*
	 * Action objects for cut, copy and paste.
	 */
	private Action cutAction = null;
	private Action copyAction = null;
	private Action pasteAction = null;
	
	/*
	 * Constructor.
	 */
	public EditMenu() {
		super("Edit");
	
		initialize();
	}

	/*
	 * Initializing the required menu items and 
	 * their actions.
	 */
	private void initialize() {
		cutAction = new DefaultEditorKit.CutAction();
		cutAction.putValue(Action.NAME, "Cut");
		add(cutAction);
		
		copyAction = new DefaultEditorKit.CopyAction();
		copyAction.putValue(Action.NAME, "Copy");
		add(copyAction);
		
		pasteAction = new DefaultEditorKit.PasteAction();
		pasteAction.putValue(Action.NAME, "Paste");
		add(pasteAction);
		
		menuItem = new JMenuItem("Delete", KeyEvent.VK_DELETE);
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Robot robot = new Robot();
					
					robot.keyPress(KeyEvent.VK_BACK_SPACE);

					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(menuItem);
		
		addSeparator();
		
		menuItem = new JMenuItem("Select All");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Robot robot = new Robot();
					
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_A);

					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_A);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		add(menuItem);
	}
}
