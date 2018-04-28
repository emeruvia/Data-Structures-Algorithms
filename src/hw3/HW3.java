package hw3;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HW3 {

	private static Scanner input;
	
	public static void main(String[] args) {
		readText("mapcampus.txt");
	}
	
	private static void readText(String path) {
		//reads the file, throws an error if there is no file to open
		try {
			input = new Scanner(new File(path));
		} catch (IOException e) {
			System.out.println("Error opening file...");
			System.exit(1);
		}
		String word;
		String line;  //stores the string of text from the .txt file
		try {
			//loops while there is still a new line in the .txt file
			while ((line = input.nextLine()) != null) {
				//separates the lines by words
				StringTokenizer st = new StringTokenizer(line);
				//loops while there are still more words in the line
				while (st.hasMoreTokens()) {
					word = st.nextToken();
					System.out.println(word);
				}
			}
		} catch (NoSuchElementException e) {
			//Do nothing
		}
		input.close();
	}
}
