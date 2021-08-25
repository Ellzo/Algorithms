/*
* Import Scanner and InputMismatchException classes from java.util
*/
import java.util.Scanner;
import java.util.InputMismatchException;

public class JumpSearch{
  
  /*
  * Method to perform jump search.
  */
  private static int jumpSearch(int[] array, int item){
    //Method starts the search from first index,
    //i.g. index 0.
    int low=0;
    
    //Jump size is the square root of the length of the array.
    final double size= Math.sqrt(array.length);
    
    //Initially, high gets low.
    int high= low;
    
    //If the item isn't bounded between the array range,
    //then there is no need to perform the search
    //and simpely return -1.
    if(array[low] > item || array[array.length - 1] < item){
      return -1;
    }
    
    //A loop to perform the search.
    while(true){
      //If high exceeded the index of the last element,
      //perform a linear search from low index
      //to the last element.
      if(high >= array.length){
          return linearSearch(array, low, array.length-1, item);
      }
      
      //If element at index high equals the item, return high.
      if(array[high] == item){
        return high;
      }
      
      //If the item if between low and high,
      //perform a linear search between the two indexes.
      if(array[low] < item && array[high] > item){
        return linearSearch(array, low, high, item);
      }
      
      //Low gets high.
      low= high;
      //Increase high by the jump size each time.
      high += size;
      
    }
  }
  
  /*
  *  Method to perform linear search.
  */
  private static int linearSearch(int[] array, int low, int high, int item){
    //Loop to perform linear search between low and high.
    for(;low <= high; low++){
      if(array[low] == item){
        return low;
      }
    }
    
    //Return -1 if nothing found.
    return -1;
  }
  
  /*
  *  Main method.
  */
  public static void main(String[] args){
    //A try/catch block to catch any exception that may occur.
    try{
      //The array.
      int[] array= {-7,-4,0,1,5,9};
      
      //A Scanner object to read input from the user.
      Scanner s= new Scanner(System.in);
      
      //Display a message to the user to enter a number.
      System.out.print("Enter a number : ");
      
      //Get the index of the number entered from the user.
      int index= jumpSearch(array, s.nextInt());
      
      //If index equals -1, nothing found.
      if(index == -1){
        System.out.println("Number doesn\'t exist in the array.");
        
      //If index isn't equal -1, print it to the user.
      }else{
        System.out.println("Number found at index: " + index);
      }
      
    //Catch InputMismatchException.
    //This exception is thrown when the user enters a non-integer value.
    }catch(InputMismatchException e){
      //Notify the user to enter an integer.
      System.out.println("The item to be searched must be a integer, try again...");
      
      //Recall the main method
      main(args);
      
    //Catch any other exception that may occur.  
    }catch(Exception e){
      //Notify the user that an error occurred.
      System.out.println("An error occurred, try again...");
      
      //Recall the main method.
      main(args);
    }
  }

}
