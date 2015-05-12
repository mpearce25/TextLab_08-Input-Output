import java.io.*;
import java.util.ArrayList;

public class TextLab08_Matthew_Pearce {

	static ArrayList<String> namesList = new ArrayList<String>();

	public static void main(String args[]) throws IOException {

		ArrayList<String> namesList = new ArrayList<String>();

		System.out.println("\nTextLab08\n");
		readFile("Names1.txt");
		displayArray();
		sortArray();
		displayArray(); // Uncomment this line for 100 point version only.
		writeFile("Names2.txt");
	}

	public static void readFile(String fileName) throws IOException {

		BufferedReader file = new BufferedReader(new FileReader(fileName));
		String inString = file.readLine();
		while (inString != null) {
			namesList.add(inString);
			inString = file.readLine();
		}

		file.close();
	}

	public static void displayArray() {
		System.out.println("Names Array Contents\n");

		for (String name : namesList) {
			System.out.println(name);
		}
		System.out.println();
	}

	public static void sortArray() {
		
		boolean sorted;
		int p = 1;
		do {
			sorted = true;
			for (int q = 0; q < namesList.size() - p; q++)
				if (namesList.get(q).compareTo(namesList.get(q+1)) > 0) {
					swap(q, q + 1);
					sorted = false;
				}
			p++;
		} while (!sorted);

	}
	private static void swap(int x, int y) {

		String temp = namesList.get(x);
		namesList.set(x, namesList.get(y));
		namesList.set(y, temp);
	}

	public static void writeFile(String fileName) throws IOException {

		BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));
		for (String name : namesList) {
			outFile.write(name);
			outFile.newLine();
		}

		outFile.close();
	}
}

class ExpoInFile {

	private String fileName;
	private BufferedReader inFile;

	/**
	 * ExpoInFile constructor method. Associates external file name with
	 * internal file object. Constructs file object for reading in string values
	 * from external file.
	 **/
	public ExpoInFile(String s) throws IOException {
		fileName = s;
		inFile = new BufferedReader(new FileReader(fileName));
	}

	/**
	 * Returns a single string from external file to internal file object.
	 **/
	public String readString() throws IOException {
		String inString = inFile.readLine();
		return inString;
	}

	/**
	 * Closes file object.
	 **/
	public void closeFile() throws IOException {
		inFile.close();
	}

}

/**
 * The ExpoOutFile class handles data file for output. Data files are limited to
 * text files and only strings are transferred from internal file objects to
 * external hard drive files.
 **/
class ExpoOutFile {

	private String fileName;
	private BufferedWriter outFile;

	/**
	 * ExpoOutFile constructor method. Associates external file name with
	 * internal file object. Constructs file object for writing out string
	 * values to an external file.
	 **/
	public ExpoOutFile(String s) throws IOException {
		fileName = s;
		outFile = new BufferedWriter(new FileWriter(fileName));
	}

	/**
	 * Writes a single string from internal file object to external hard drive
	 * file.
	 **/
	public void writeString(String s) throws IOException {
		outFile.write(s);
	}

	/**
	 * Writes a single string from internal file object to external hard drive
	 * file. Additionally a linefeed/carriage return is added.
	 **/
	public void writelnString(String s) throws IOException {
		outFile.write(s);
		outFile.newLine();
	}

	/**
	 * Closes file object.
	 **/
	public void closeFile() throws IOException {
		outFile.close();
	}

}
