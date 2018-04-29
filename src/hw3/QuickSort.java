package hw3;

import java.util.ArrayList;

class QuickSort {
	
	private static ArrayList<String> list = new ArrayList<>();
	
	QuickSort(ArrayList<String> list) {
		this.list = list;
		quickSort(0, list.size() - 1);
	}
	
	static void quickSort(int start, int end) {
		if (start < end) {
			int index = partition(list, start, end);
			quickSort(start, index - 1);
			quickSort(index + 1, end);
		}
	}
	
	static int partition(ArrayList<String> list, int start, int end) {
		String pivot = list.get(end);
		int index = start;
		String temp;
		for (int i = start; i < end; i++) {
			int compare = list.get(i).compareTo(pivot);
			if (compare < 0) {
				//Swap the values
				temp = list.get(index);
				list.set(index, list.get(i));
				list.set(i, temp);
				index++;
			}
		}
		list.set(end, list.get(index));
		list.set(index, pivot);
		return index;
	}
}
