import java.util.Scanner;

public class SelectionSort{

   private static int[] selectionSort(int[] array){
      System.out.println("\nSorting...");
      int min;
      for(int i = 0; i < array.length; i++){
         min = i;
         for(int j = i + 1; j < array.length; j++){
            if(array[j] < array[min]){
               min = j;
            }
         }
         if(min != i){
            array[i] += array[min];
            array[min] = array[i] - array[min];
            array[i] -= array[min];
         }
      }
      
      System.out.println("Sort ends!\n");
      
      return array;
   }
   
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      System.out.print("Enter number of items: ");
      int length = s.nextInt();
      int[] array = new int[length];
      for(int i = 0; i < length; i++){
         System.out.print("Enter item n°" + (i + 1) + ": ");
         array[i] = s.nextInt();
      }
      array = selectionSort(array);
      for(int i = 0; i < length; i++)
         System.out.println("Item n°" + (i + 1) + " is: " + array[i]);
   }
}
