package hw3;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class HW3 {
	
	private static Scanner input;
	private static ArrayList<String> intersection;
	private static ArrayList<IntersectionNode> sortedNodeList = new ArrayList<>();
	
	public static void main(String[] args) {
		readText("mapcampus.txt");
		System.out.println(intersection);
//		createGraph("mapcampus.txt");
		for (IntersectionNode node : sortedNodeList) {
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
		IntersectionNode node;
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
		new QuickSort(intersection);
		for (String s : intersection) {
			sortedNodeList.add(new IntersectionNode(s));
		}
		input.close();
	}
	
	private static void createGraph(String path) {
		//reads the file, throws an error if there is no file to open
		try {
			input = new Scanner(new File(path));
		} catch (IOException e) {
			System.out.println("Error opening file...");
			System.exit(1);
		}
		IntersectionNode node;
		String word;
		String line;
		for (String s : intersection) {
			try {
				while ((line = input.nextLine()) != null) {
					StringTokenizer st = new StringTokenizer(line);
					while (st.hasMoreTokens()) {
						word = st.nextToken();
						if (s.equals(word)) {
							node = new IntersectionNode(s);
//							node.setStreet(st.nextToken());
//							node.setEdge(st.nextToken());
//							st.nextToken();
//							node.setDir(st.nextToken());
//							node.setDist(st.nextToken());
//							node.setSpeed(Integer.valueOf(st.nextToken()));
							sortedNodeList.add(node);
							break;
						} else {
							break;
						}
					}
				}
			} catch (NoSuchElementException e) {
				//do nothing
			}
			try {
				input = new Scanner(new File(path));
			} catch (IOException e) {
				//do nothing
			}
		}
		input.close();
	}
	
	private static void shortestPath(String to, String from) {
	
	}
}
