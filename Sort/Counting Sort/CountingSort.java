import java.util.Scanner;

public class CountingSort{
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Number of elements: ");
		int length = s.nextInt();
		
		int array[] = new int[length];
		int range = 0;
		
		for(int i = 0; i < length; i++){
			System.out.print("Enter element at index " + i + " : ");
			array[i] = s.nextInt();
			if(array[i] > range){
				range = array[i];
			}
		}
		
		System.out.println("\nSorting...");
		array = countingSort(array, range);
		System.out.println("Sort Completed!\n");
		
		System.out.print("[");
		for(int i = 0; i < length - 1; i++){
			System.out.print(" " + array[i] + ",");
		}
		System.out.println(" " + array[length - 1] + " ]");
	}
	
	private static int[] countingSort(int[] array, int range){
		int[] count = new int[range + 1];
		
		for(int i = 0; i < array.length; i++){
			for(int j = array[i]; j < count.length; j++){
				count[j] += 1;
			}
		}
		
		int newArray[] = new int[array.length];
		for(int i = 0; i < array.length; i++){
			int t = array[i];
			newArray[count[t] - 1] = t;
			--count[t];
		}
		
		return newArray;
	}
}
