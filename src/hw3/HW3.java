package hw3;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class HW3 {
	
	private static Scanner input;
	private static ArrayList<String> intersection;
	private static ArrayList<IntersectionNode> nodeList;
	
	public static void main(String[] args) {
		readText("mapcampus.txt");
		new QuickSort(intersection);
		System.out.println(intersection);
		for (IntersectionNode node : nodeList) {
			System.out.println(node.toString());
		}

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
		nodeList = new ArrayList<>();
		IntersectionNode node;
		String word;
		String line;
		boolean duplicate = false;
		try {
			while ((line = input.nextLine()) != null) {
				StringTokenizer st = new StringTokenizer(line);
				StringTokenizer st2 = new StringTokenizer(line);
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
				while (st.hasMoreTokens()) {
					node = new IntersectionNode(st2.nextToken());
					node.setStreet(st2.nextToken());
					node.setEdge(st2.nextToken());
					node.setDir(st2.nextToken());
					node.setDist(st2.nextToken());
					node.setSpeed(Integer.valueOf(st2.nextToken()));
					nodeList.add(node);
					break;
				}
			}
		} catch (NoSuchElementException e) {
			//Do nothing
		}
		
		input.close();
	}
}
