import java.util.Scanner;

public class InsertionSort{

	private static int[] insertionSort(int[] array){

	   if(array.length < 2){
	      return array;
	   }
	   
	   System.out.println("\nSorting...");
	   
	   for(int i = 1; i < array.length; i++){
	      for(int j = i; j > 0 && array[j] < array[j-1]; j--){
		 array[j] += array[j-1];
	         array[j-1] = array[j] - array[j-1];
	         array[j] -= array[j-1]; 
	      }
	   }
	   
	   System.out.println("Sort Completed!\n");
	   
	   return array;
	}

	public static void main(String[] args){

	   Scanner s = new Scanner(System.in);

	   System.out.print("Enter Number of Elements: ");
	   int length = s.nextInt();
	   
	   int array[] = new int[length];
	   
	   for(int i = 0; i < length; i++){
	      System.out.print("Enter Element at Index " + i + " : ");
	      array[i] = s.nextInt();
	   }
	   
	   array = insertionSort(array);
	   for(int i = 0; i < array.length; i++)
	   	System.out.println("Item at index " + i + " is: " + array[i]);
	   
	   s.close();
	   System.out.println("\n*******");
	}

}
