package ExternalFrames;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import MainPackage.GUI;

/*
 * This class is responsible to give a choice screen for
 * the users that forgot to save the file before closing
 * the program.
 */
public class ExitFrame extends JFrame implements ActionListener {
		
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 6471769455324345583L;
	
	/*
	 * ExitFrame's user interface components.
	 */
	private JLabel label;
	private JPanel southPanel;
	private JButton save, dontSave, cancel;
	
	/*
	 * GUI object.
	 */
	private GUI mainFrame;
	
	/*
	 * Constructor.
	 */
	public ExitFrame(GUI mainFrame) {
		super("Text Editor");
		
		this.mainFrame = mainFrame;
		
		initialize();
	}
	
	/*
	 * This method initializes all the properties for this
	 * frame.
	 */
	private void initialize() {
		setLayout(new BorderLayout());
		
		label = new JLabel("Do you want to save the file?", SwingConstants.CENTER);
		add(label, BorderLayout.CENTER);
		
		southPanel = new JPanel();
		save = new JButton("Save");
		save.addActionListener(this);
		southPanel.add(save);
		dontSave = new JButton("Don't Save");
		dontSave.addActionListener(this);
		southPanel.add(dontSave);
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		southPanel.add(cancel);
		add(southPanel, BorderLayout.SOUTH);
		
		setSize(300,150);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/*
	 * Override method for performing actions.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == save.getActionCommand()){
			mainFrame.saveOnClose();
		}
		if(e.getActionCommand() == dontSave.getActionCommand()){
			System.exit(0);
		}
		if(e.getActionCommand() == cancel.getActionCommand()){
			mainFrame.setVisible(true);
			this.dispose();
		}
	}

}