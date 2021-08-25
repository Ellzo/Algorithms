import java.util.Scanner;

public class FirstIndexBinarySearch{
   private static int binarySearch(int[] array, int num){
    int high = array.length - 1;
    
    int low = 0;
    
    int mid;
    int result = -1;
    while(low <= high){
    	mid = (low+high)/2;
    
    	if(array[mid] == num){
    		result = mid;
    		high = mid - 1;
    	}else if(array[mid] < num){
    		low = mid + 1;
    	}else{
    		high = mid - 1;
    	}
    }
    
    return result;
  }
   
   
   public static void main(String[]args){
      int[] array= {-2,-1,-1,-1,0,0,3,4,4,8,17,19,19,19,19,48,500,500,500,510};
      
      Scanner s = new Scanner(System.in);
      
      System.out.println("Enter a number: ");
      
      int index = binarySearch(array, s.nextInt());
      
      //If index equals -1, then the number not found
      if(index == -1){
        System.out.println("Number not found");
      
      //Print index to user, if it is not equal -1
      }else{
        System.out.println("Number found at index: "+ index);
      }
   
   }
}
