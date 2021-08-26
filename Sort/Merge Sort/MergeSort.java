import java.util.Scanner;

public class MergeSort{
   private static int[] array;
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      System.out.print("Enter elements count: ");
      int length = s.nextInt();
      array = new int[length];
      for(int i = 0; i < length; i++){
         System.out.print("Enter element at index " + i + " : ");
         array[i] = s.nextInt();
      }
      System.out.println("\nSorting...");
      mergeSort(0, length - 1);
      System.out.println("Sort Completed!\n");
      for(int i = 0; i < length; i++)
         System.out.println("Item at index " + i + " is: " + array[i]);
      s.close();
   }
   
   private static void mergeSort(int startIndex, int lastIndex){
      if(lastIndex > startIndex){
         int mid = (startIndex + lastIndex)/2;
         mergeSort(startIndex, mid);
         mergeSort(mid + 1, lastIndex);
         merge(startIndex, mid, lastIndex);
      }
   }
   
   private static void merge(int p, int q, int r){
      int[] subArray = new int[r - p + 1];
      int i = p;
      int j = q  + 1;
      int k = 0;
      while(i <= q && j <= r){
         if(array[i] < array[j])
            subArray[k++] = array[i++];
         else
            subArray[k++] = array[j++];
      }
      
      while(i <= q)
         subArray[k++] = array[i++];
         
      while(j <= r)
         subArray[k++] = array[j++];
      
      for(; r >= p; r--)
         array[r] = subArray[--k];
   }
}
