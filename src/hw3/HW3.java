package hw3;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class HW3 {
	
	private static Scanner input;
	private static ArrayList<String> intersection;
	
	public static void main(String[] args) {
		readText("mapcampus.txt");
		System.out.println("Before Sorting");
		System.out.println(intersection);
		System.out.println("After Sorting");
		new QuickSort(intersection);
		System.out.println(intersection);
	}
	
	private static void readText(String path) {
		//reads the file, throws an error if there is no file to open
		try {
			input = new Scanner(new File(path));
		} catch (IOException e) {
			System.out.println("Error opening file...");
			System.exit(1);
		}
		intersection = new ArrayList<>();
		String word;
		String line;
		boolean duplicate = false;
		try {
			while ((line = input.nextLine()) != null) {
				StringTokenizer st = new StringTokenizer(line);
				while (st.hasMoreTokens()) {
					word = st.nextToken();
					for (String s : intersection) {
						if (s.equals(word)) {
							duplicate = true;
							break;
						}
					}
					if (!duplicate) {
						intersection.add(word);
					}
					duplicate = false;
					break;
				}
			}
		} catch (NoSuchElementException e) {
			//Do nothing
		}
		input.close();
	}
}
