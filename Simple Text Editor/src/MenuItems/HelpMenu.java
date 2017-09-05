package MenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import ExternalFrames.AboutFrame;

/*
 * This class stores the Help menu's 
 * information which is just help screen
 * and the about screen.
 */
public class HelpMenu extends JMenu{
	
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 6280667872971563092L;
	
	/*
	 * JMenuItem object to create the menu
	 * items.
	 */
	private JMenuItem menuItem;
	
	/*
	 * Default constructor.
	 */
	public HelpMenu() {
		super("Help");
		
		initialize();
	}
	
	/*
	 * initialize method for declaring all the features 
	 * of the Help menu.
	 */
	private void initialize() {
		menuItem = new JMenuItem("About");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AboutFrame();
			}
		});
		add(menuItem);
	}
}
