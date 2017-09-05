package MenuItems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import ExternalFrames.ExitFrame;
import MainPackage.FileManager;
import MainPackage.GUI;

/*
 * This class stores the File menu's 
 * information.
 */
public class FileMenu extends JMenu {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 9157905295939742516L;

	/*
	 * JMenuItem object to create the menu
	 * items.
	 */
	private JMenuItem menuItem;
	
	/*
	 * FileChooser object.
	 */
	private JFileChooser fileChooser;
	
	/*
	 * GUI object.
	 */
	private GUI gui;
	
	/*
	 * JTextArea object.
	 */
	private JTextArea textArea;
	
	/*
	 * FileManager object.
	 */
	private FileManager fileManager;
	
	/*
	 * Constructor.
	 */
	public FileMenu(JFileChooser fileChooser, GUI gui, JTextArea textArea) {
		super("File");
		
		this.fileChooser = fileChooser;
		this.gui = gui;
		this.textArea = textArea;
		
		fileManager = new FileManager();
		
		initialize();
	}

	/*
	 * initialize method for declaring all the features 
	 * of the File menu.
	 */
	private void initialize() {
		/*
		 * Shortcut for opening the menu.
		 */
		setMnemonic(KeyEvent.VK_F);
		
		/*
		 * New menu item.
		 * Following lines opens new empty file in a given 
		 * directory with a CTRL+N shortcut.
		 */
		menuItem = new JMenuItem("New...");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					fileChooser.setDialogTitle("New File");
					int fileCondition = fileChooser.showSaveDialog(gui);
					if(fileCondition == JFileChooser.APPROVE_OPTION) {
						File file = fileChooser.getSelectedFile();
						fileManager.createNewFile(file);
						gui.setTitle(file.getName() + "- TextEditor");
						textArea.setEditable(true);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		add(menuItem);
		
		/*
		 * Open menu item.
		 * Following lines opens a text file in a given 
		 * directory with a CTRL+O shortcut.
		 */
		menuItem = new JMenuItem("Open...");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					fileChooser.setDialogTitle("Open");
					int fileCondition = fileChooser.showOpenDialog(gui);
					if(fileCondition == JFileChooser.APPROVE_OPTION) {
						File file = fileChooser.getSelectedFile();
						String input = fileManager.openFile(file);
						
						gui.setTitle(file.getName() + "- TextEditor");
						textArea.setEditable(true);
						textArea.setText(input);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(menuItem);
		
		/*
		 * Save menu item.
		 * Following lines saves the current file in current 
		 * directory with a CTRL+S shortcut.
		 */
		menuItem = new JMenuItem("Save");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					File file = fileChooser.getSelectedFile();
					fileManager.saveFile(file, textArea.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		add(menuItem);
		
		/*
		 * Save as menu item.
		 * Following lines saves a file with what ever name or
		 * directory the user wants.
		 */
		menuItem = new JMenuItem("Save as...");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChooser.setDialogTitle("Save as");
				File file = new File(".");
				fileChooser.setSelectedFile(new File(file.getAbsolutePath()));
				
				
				try {
					int fileCondition = fileChooser.showSaveDialog(gui);
					if(fileCondition == JFileChooser.APPROVE_OPTION) {
						file = fileChooser.getSelectedFile();
						fileManager.saveFile(file, textArea.getText());
					} else {
						fileChooser.setSelectedFile(null);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(menuItem);
		
		addSeparator();
		
		/*
		 * Exit menu item.
		 * Following lines closes the application. If the user
		 * wants to quit without saving a file, there would 
		 * be a new frame opens and worn the user to save
		 * the file.
		 */
		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.getSelectedFile() != null) {
					new ExitFrame(gui);
					setVisible(false);
				}
				else
					System.exit(0);
			}
		});
		add(menuItem);
	}

}