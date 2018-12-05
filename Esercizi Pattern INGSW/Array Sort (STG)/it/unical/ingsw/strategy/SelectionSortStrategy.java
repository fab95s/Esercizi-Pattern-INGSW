package it.unical.ingsw.strategy;

import it.unical.ingsw.interfaces.Strategy;

public class SelectionSortStrategy implements Strategy {

	@Override
	public int[] sort(int[] array) {
		for(int i=0; i<array.length; i++) {
			int min = i;
			for(int j=i+1; j<array.length; j++) {
				if(array[min] > array[j]) {
					min = j;
				}
			}
			if(min != i) {
				int tmp = array[min];
				array[min] = array[i];
				array[i] = tmp;
			}
		}
		return array;
	}

}
