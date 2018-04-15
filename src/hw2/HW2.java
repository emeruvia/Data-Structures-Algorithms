package hw2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;

/**
 * @author: ...7569
 * @assignmnet: HomeWork 2
 * @date: 4/15/2018
 * @Purpose: The purpose of this program was to learn how AvlTree works, The
 *  program will read a .txt file and then store all the words in a list,
 *  after that it will insert the words one by one to the self-balancing tree
 *  creating the AVL Tree. It will then print the balanced result of the
 *  tree (case un-sensitive), and the line number in which they appeared.
 */
public class HW2 {
	
	//Scanner used to scan the user input, in this case a .txt file
	private static Scanner input = null;
	//ArrayList that stores all the words in the txt file
	private static List<String> wordList = new ArrayList<>();
	private static List<Integer> lineList = new ArrayList<>();
	
	public static void main(String[] args) {
		ReadText("testText.txt"); //name of the .txt file that is being read
		AVLTree avlTree = new AVLTree();  //Creates an avlTree object
		int i = 0;  //Counter for the line list.
		for (String s : wordList) {
			//inserts the words and line number into the tree.
			avlTree.insert(s, lineList.get(i));
			i++;
		}
		avlTree.print();  //prints the result of the tree
	}
	
	/**
	 * Method reads a text file and stores the answers in a list
	 *
	 * @param path, Directory path of the .txt file
	 */
	private static void ReadText(String path) {
		//reads the file, throws an error if there is no file to open
		try {
			input = new Scanner(new File(path));
		} catch (IOException e) {
			System.out.println("Error opening file...");
			System.exit(1);
		}
		String line;  //stores the string of text from the .txt file
		String parsedWord;  //Stores the word of the parsed word
		int wordLength; //Stores the length of the word
		int lineNum = 1;  //Stores the number of line
		try {
			//loops while there is still a new line in the .txt file
			while ((line = input.nextLine()) != null) {
				//separates the lines by words
				StringTokenizer st = new StringTokenizer(line);
				//loops while there are still more words in the line
				while (st.hasMoreTokens()) {
					parsedWord = st.nextToken();
					wordLength = parsedWord.length();
					//Regex gets rid of all punctuation
					if (parsedWord.matches(".*\\p{Punct}")) {
						parsedWord = parsedWord.substring(0, wordLength - 1);
					}
					//add the word to the list
					wordList.add(parsedWord);
					lineList.add(lineNum);
				}
				lineNum++;
			}
		} catch (NoSuchElementException e) {
			//Do nothing
		}
		input.close();
	}
}