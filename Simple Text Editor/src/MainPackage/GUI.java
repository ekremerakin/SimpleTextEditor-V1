package MainPackage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ExternalFrames.ExitFrame;
import MenuItems.EditMenu;
import MenuItems.FileMenu;
import MenuItems.FormatMenu;
import MenuItems.HelpMenu;


/*
 * This class includes graphical user interface components.
 * It is the key part of the program. Since it's a text editor, 
 * it's better to have an user interface which get the job done
 * without a problem.
 * 
 * There are few bugs at this version. But, that bugs are not 
 * effect the programs flow. 
 */
public class GUI extends JFrame {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 3206847208968227199L;

	/*
	 * Swing components.
	 */
	private JMenuBar menuBar;
	private JTextArea textArea;
	private JFileChooser fileChooser;
	
	/*
	 * FileManager object.
	 */
	private FileManager fileManager;
	
	/*
	 * Constructor takes FileManager object as a parameter.
	 * It creates all the 
	 */
	public GUI(FileManager fileManager) {
		super("Text Editor");
		this.fileManager = fileManager;

		fileChooser = new JFileChooser();
		
		setLayout(new BorderLayout());
		menuBar = new JMenuBar();

		initialize();
	}
	
	/*
	 * This method initialize all the properties for 
	 * the user interface like menus, textArea and some
	 * other important frame features.
	 */
	private void initialize() {
		setTextArea();
		setMenuProperties();
		
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(fileChooser.getSelectedFile() != null) 
					new ExitFrame(GUI.this);
				else
					System.exit(0);
			}
		});
		setVisible(true);
	}
	
	/*
	 * Setting the textArea properties.
	 */
	private void setTextArea() {
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		textArea.setMargin(new Insets(5, 5, 5, 5));
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(200,200));
		add(scrollPane, BorderLayout.CENTER);
	}
	
	/*
	 * Setting the menu properties while using the classes 
	 * inside the MenuItems package.
	 */
	private void setMenuProperties() {
		FileMenu fileMenu = new FileMenu(fileChooser, GUI.this, textArea);
		menuBar.add(fileMenu);

		EditMenu editMenu = new EditMenu();
		menuBar.add(editMenu);
		
		FormatMenu formatMenu = new FormatMenu(textArea);		
		menuBar.add(formatMenu);
		
		HelpMenu helpMenu = new HelpMenu();
		menuBar.add(helpMenu);
		
		add(menuBar, BorderLayout.NORTH);
	}
	
	/*
	 * This method is responsible for saving files while closing
	 * the application if it's required.
	 */
	public void saveOnClose() {
		try {
			File file = fileChooser.getSelectedFile();
			fileManager.saveFile(file, textArea.getText());
			System.exit(0);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}