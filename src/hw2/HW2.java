package hw2;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class HW2 {
  
  private static Scanner input = null;
  //ArrayList that stores all the words in the txt file
  private static List<String> wordList = new ArrayList<>();
  private static List<Integer> lineList = new ArrayList<>();
  public static void main(String[] args) {
    ReadText("testText.txt");

    AVLTree avlTree = new AVLTree();

    int i = 0;
    for (String s : wordList) {
			 
      System.out.println(s + "\t" + lineList.get(i));
      i++;
    }
    
  }
  
  /**
   * Method reads a text file and stores the answers in a list
   *
   * @param path, Directory path of the .txt file
   */
  private static void ReadText(String path) {
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
      while ((line = input.nextLine()) != null) {
        StringTokenizer st = new StringTokenizer(line);
        while (st.hasMoreTokens()) {
          parsedWord = st.nextToken();
          wordLength = parsedWord.length();
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