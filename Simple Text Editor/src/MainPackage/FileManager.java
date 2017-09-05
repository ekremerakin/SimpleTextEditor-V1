package MainPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * FileManager class is responsible for creating files, 
 * opening files and saving files via BufferedReader and
 * BufferedWriter classes.
 */
public class FileManager {
	
	/*
	 * Required objects for input and output.
	 */
	private BufferedReader bufferedReader = null;
	private BufferedWriter bufferedWriter = null;
	
	/*
	 * This method creates a new file via BufferedWriter object.
	 */
	public void createNewFile(File file) throws IOException {
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write("");
		} finally {
			if(bufferedWriter != null)
				bufferedWriter.close();
		}
	}
	
	/*
	 * This method opens a file via BufferedReader object and
	 * displays all the text inside the text file to the user
	 * interface.
	 */
	public String openFile(File file) throws IOException {
		String output = "";
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
		
			String temp;
			while((temp = bufferedReader.readLine()) != null) {
				output += temp + "\n";
			}
		} finally {
			if(bufferedReader != null)
				bufferedReader.close();
		}
		return output;
	}
	
	/*
	 * This method saves a file via BufferedWriter object.
	 */
	public void saveFile(File file, String text) throws IOException {
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write(text);
		} finally {
			if(bufferedWriter != null)
				bufferedWriter.close();
		}
	}
	
}
