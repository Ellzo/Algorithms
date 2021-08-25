import java.util.Scanner;

public class CircularArrayBinarySearch{
   private static int binarySearch(int[] array, int num){
      
      int low = 0;
      int high = array.length - 1;
         
      int mid;
      while(low <= high){
         mid = (low + high)/2;
         if(array[mid] == num)
            return mid;
         else if(array[mid] <= array[high]){
            if(array[mid] < num && array[high] >= num)
               low = mid + 1;
            else
               high = mid - 1;
         }else{
            if(array[mid] > num && array[low] <= num)
               high = mid - 1;
            else
               low = mid + 1;
         }
      }
      
      return -1;
   }
   
   public static void main(String[] args){
      int[] array = {18, 19, 27, 39, -11, -8, -7, 0, 1, 13, 15, 16, 17};

      
      Scanner s = new Scanner(System.in);
      
      System.out.println("Enter the item that you\'re looking for: ");
      
      int index = binarySearch(array, s.nextInt());
      
      if(index == -1)
         System.out.println("Item not found");
      else
         System.out.println("Found at index: " + index);
      
      s.close();
   }
}
