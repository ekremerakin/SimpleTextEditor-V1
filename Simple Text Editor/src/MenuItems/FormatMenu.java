package MenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import ExternalFrames.FontFrame;

/*
 * This class stores the Format menu's 
 * information which is font information.
 */
public class FormatMenu extends JMenu {
	
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 8055306658316956087L;
	
	/*
	 * JMenuItem object to create the menu
	 * items.
	 */
	private JMenuItem menuItem;
	
	private JTextArea textArea;
	
	/*
	 * Default constructor.
	 */
	public FormatMenu(JTextArea textArea) {
		super("Format");
		
		this.textArea = textArea;
		initialize();
	}
	
	/*
	 * initialize method for declaring all the features 
	 * of the Format menu.
	 */
	private void initialize() {
		menuItem = new JMenuItem("Font");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FontFrame(textArea);
			}
		});
		add(menuItem);
	}
}
