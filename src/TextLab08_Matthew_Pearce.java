import java.io.*;
import java.util.ArrayList;

public class TextLab08_Matthew_Pearce {

	static ArrayList<String> namesList = new ArrayList<String>();

	public static void main(String args[]) throws IOException {

		ArrayList<String> namesList = new ArrayList<String>();

		System.out.println("\nTextLab08\n");
		readFile("Names1.txt");
		
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
				if (namesList.get(q +1).compareTo(namesList.get(q)) < 0) {
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



