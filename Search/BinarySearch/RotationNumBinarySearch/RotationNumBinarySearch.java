import java.util.Scanner;

public class RotationNumBinarySearch{
   public static void main(String[] args){
      Scanner s = new Scanner(System.in);
      
      System.out.println("Please Enter Array\'s Items Count: ");
      
      int count = s.nextInt();
      
      int[] array = new int[count];
      
      System.out.println("Enter Array\'s Items: ");
      
      for(int i = 0; i < count; i++ ){
         array[i] = s.nextInt();
      }
      
      System.out.println();
      
      System.out.println("Number of rotations: " + countRotations(array));
      
      s.close();
   }
   
   private static int countRotations(int[] array){
      int low = 0;
      int high = array.length - 1;
      int mid;
      
      while(low <= high){
         if(array[low] <= array[high])
            return low;
            
         mid = (low + high)/2;
         
         if(array[mid] < array[mid + 1] && array[mid] < array[mid - 1])
            return mid;
            
         else if(array[mid] < array[low])
            high = mid - 1;
         else
            low = mid + 1;
      }
      
      return low;
   }

}
