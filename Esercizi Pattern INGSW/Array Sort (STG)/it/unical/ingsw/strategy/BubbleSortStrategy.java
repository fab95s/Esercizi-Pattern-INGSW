package it.unical.ingsw.strategy;

import it.unical.ingsw.interfaces.Strategy;

public class BubbleSortStrategy implements Strategy {

	@Override
	public int[] sort(int[] array) {
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array.length-1; j++) {
				if(array[j] > array[j+1]) {
					int tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
				}
			}
		}
		return array;
	}

}
