package MainPackage;
import javax.swing.SwingUtilities;

/*
 * Main class just creates a FileManager object and 
 * GUI swing object. All other codes were written in
 * other classes.
 * 
 * For overview of this program, you can check my 
 * personal blog:
 * ekremerakin.wordpress.com
 */
public class MainClass {

	/*
	 * FileManager object.
	 */
	private static FileManager fileManager;
	
	/*
	 * Main class
	 */
	public static void main(String[] args) {
		fileManager = new FileManager();
		SwingUtilities.invokeLater(new Runnable() {	
			@Override
			public void run() {
				new GUI(fileManager);
			}
		});
	}
}
