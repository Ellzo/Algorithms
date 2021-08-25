import java.util.*;
public class RecursiveBinarySearch{
  //Create mid global variable without assigning it a value yet
  private static int mid;
  
  /*
  * Method to perform binary search
  */
  private static int binarySearch(int[] array, int low, int high, int num){
    //Perform the search till the method finds num
    //or when low bacomes larger than high
    if(low<=high){
      //Assign mid elment to the middle element between
      //low and high
      mid = low/2 + high/2;
      
      //If the element at the mid index equals num,
      //then it's found and return it
      if(array[mid] == num){
        return mid;
      
      //If the element at mid index is less than num,
      //then eleminate all elements before mid
      //and restart the process from mid+1 index
      }else if(array[mid] < num){
        return binarySearch(array, mid + 1, high, num);
        
      //If the element at mid index is larger than num,
      //then eleminate all elements after mid
      //and restart the process till mid-1 index
      }else{
	return binarySearch(array, low, mid - 1, num);
      }
    }else{
      //Return -1 if nothing found
      return -1;
    }
  }
  
  /*
  * Main method
  */
  public static void main(String[] args){
    //A try block to catch any errors
    try{
      //The array
      int[] array= {0,4,8,9,17,19,45};
      
      //Scanner object to scan the user input
      Scanner s = new Scanner(System.in);
      
      //Print to the user a msg informing him to enter a number
      System.out.println("Enter the number to be searched..");
      
      //The index of the number gets the value returned from
      //binarySearch method
      int index= binarySearch(array, 0, array.length-1, s.nextInt());
      
      //If index equals -1, then the number not found
      if(index == -1){
        System.out.println("Number not found");
      
      //Print index to user, if it is not equal -1
      }else{
        System.out.println("Number found at index: "+ index);
      }
      
    //Catch InputMismatchException error.
    //The exception is thrown when the user
    //enters a non-integer value
    }catch(InputMismatchException e){
      //Notify the user to enter an integer
      System.out.println("The item must be an integer, try again..");
      //Recall main method to restart the work
      main(args);
      
    //Catch any other exception the can be thrown  
    }catch(Exception e){
      //Notify the user that an error occured
      System.out.println("An error occured, try again..");
      //Recall main method to restart the work
      main(args);
      
    }
  }
}
