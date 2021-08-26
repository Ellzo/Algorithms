import java.util.Scanner;

public class QuickSort{
   private static int[] array;
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      System.out.print("Enter number of elements: ");
      int length = s.nextInt();
      array = new int[length];
      for(int i = 0; i < array.length; i++){
         System.out.print("Enter element n°" + (i+1) + " : ");
         array[i] = s.nextInt();
      }
      
      System.out.println("\nSorting...");
      quickSort(0, length - 1);
      System.out.println("Sort Completed!\n");
      for(int i = 0; i < length; i++)
         System.out.println("Item at index " + i + " is: " + array[i]);
   }
   
   private static void quickSort(int low, int high){
      if(low < high){
         int p = partition(low, high);
         quickSort(low, p);
         quickSort(p + 1, high);
      }
   }
  
  private static int partition(int low, int high){
     int pivot = array[low];
     int i = high + 1;
     for(int j = high; j > low; j--){
        if(array[j] >= pivot){
           i--;
           swap(i, j);
        }
     }
     swap(i-1, low);
     return i-1;
  }
  
  private static void swap(int a, int b){
     int temp = array[b];
     array[b] = array[a];
     array[a] = temp;
  }
}
