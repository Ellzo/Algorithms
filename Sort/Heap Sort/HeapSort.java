import java.util.Scanner;

public class HeapSort{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.print("Enter number of element: ");
		int array[] = new int[s.nextInt()];
		for(int i = 0; i < array.length; i++){
			System.out.print("Enter element at index " + i + " : ");
			array[i] = s.nextInt();
		}
		heapSort(array);
	}
	
	private static int[] heapSort(int[] array){
		for(int i = 0; i < array.length; i++){
			array = heapify(array, i);
		}
		
		for(int i = array.length - 1; i > 0; i--){
			array = deleteAndSort(array, i);
		}
		
		System.out.print("\n[");
		for(int i = 0; i < array.length; i++){
			System.out.print(" " + array[i] + " ");
		}
		System.out.println("]\n");
		
		return array;
	}
	
	private static int[] heapify(int[] array, int n){
		if(n != 0){
			if(array[n] > array[(n-1)/2]){
				int temp = array[n];
				array[n] = array[(n-1)/2];
				array[(n-1)/2] = temp;
				array = heapify(array, (n-1)/2);
			}
		}
		return array;
	}
	
	private static int[] deleteAndSort(int[] array, int n){
		int temp = array[n];
		array[n] = array[0];
		array[0] = temp;
		
		int i = 0;
		while(true){
			if((i + 1) * 2 < n){
				int maxIndex = (i + 1) * 2;
				if(array[maxIndex] < array[i * 2 + 1])
					maxIndex = i * 2 + 1;
				if(array[i] < array[maxIndex]){
					temp = array[maxIndex];
					array[maxIndex] = array[i];
					array[i] = temp;
				}
				i = maxIndex;
			}else{
				if(i * 2 + 1 < n){
					if(array[i] < array[i * 2 + 1]){
						temp = array[i * 2 + 1];
						array[i * 2 + 1] = array[i];
						array[i] = temp;
					}
				}
				break;
			}
		}
		return array;
	}
}
