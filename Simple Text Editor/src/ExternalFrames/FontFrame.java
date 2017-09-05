package ExternalFrames;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * This class is responsible for opening a new frame
 * and represent the font features of this program.
 */
public class FontFrame extends JFrame implements ActionListener {
	
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = -3324023068588572183L;
	
	/*
	 * JTextArea object to set the new font.
	 */
	private JTextArea textArea;
	
	/*
	 * An array and hashMap to store font types
	 * and styles.
	 */
	private String[] fontType;
	private HashMap<String, Integer> fontStyle;
	
	/*
	 * GUI components.
	 */
	private JComboBox<String> fontTypeComboBox;
	private JComboBox<String> fontStyleComboBox;
	private JTextField textField;
	private JButton submitButton, cancelButton;

	/*
	 * Constructor.
	 */
	public FontFrame(JTextArea textArea) {
		super("Font");
		
		this.textArea = textArea;
		
		fontType = new String[]{"Serif", "SansSerif", "Monospaced"};
		
		fontStyle = new HashMap<>();
		fontStyle.put("Plain", Font.PLAIN);
		fontStyle.put("Bold", Font.BOLD);
		fontStyle.put("Italic", Font.ITALIC);
		fontStyle.put("Bold and Italic", Font.BOLD | Font.ITALIC);
		
		initialize();
	}

	/*
	 * Initializing the graphical user interface features.
	 */
	private void initialize() {
		setSize(400,150);
		setLayout(new BorderLayout());
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel selectionPanel = new JPanel();
			selectionPanel.setLayout(new GridLayout(2, 3));
			selectionPanel.add(new JLabel("Font Type:"));
			selectionPanel.add(new JLabel("Font Style"));
			selectionPanel.add(new JLabel("Font Size"));
			
			fontTypeComboBox = new JComboBox<>(fontType);
			selectionPanel.add(fontTypeComboBox);
			fontStyleComboBox = new JComboBox<>(fontStyle.keySet().toArray(new String[0]));
			selectionPanel.add(fontStyleComboBox);
			textField = new JTextField(textArea.getFont().getSize() + "");
			selectionPanel.add(textField);
		add(selectionPanel, BorderLayout.PAGE_START);
		
		JPanel buttonPanel = new JPanel();
			submitButton = new JButton("Submit");
			submitButton.addActionListener(this);
			buttonPanel.add(submitButton);
			cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(this);
			buttonPanel.add(cancelButton);
		add(buttonPanel, BorderLayout.PAGE_END);
		
		setVisible(true);
	}
	
	/*
	 * Override method to takes the actions and make decide
	 * in order to that actions.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == submitButton.getActionCommand()) {
			String key = fontStyleComboBox.getSelectedItem().toString();
			textArea.setFont(new Font(
					fontTypeComboBox.getSelectedItem().toString(),
					fontStyle.get(key),
					Integer.parseInt(textField.getText())
					));
			this.dispose();
		}	
		else if(e.getActionCommand() == cancelButton.getActionCommand()) {
			this.dispose();
		}
	}
	
}
