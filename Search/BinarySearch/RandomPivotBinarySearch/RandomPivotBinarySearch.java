import java.util.*;
public class RandomPivotBinarySearch{

  private static int binarySearch(int[] array, int num){
    //The initial value of high variable is the last index,
    //i.e. array.length -1
    int high = array.length -1;
    
    //The initial value of low variable is the the first index,
    //i.e. 0 index;
    int low = 0;
    
    //Create pivot variable without assigning it a value yet
    int pivot;
    
    //Perform the search till the method finds num
    //or when low bacomes larger than high
    while(low<=high){
      //Assign pivot a random number between low and high
      pivot = new Random().nextInt(high-low) + low;
      
      //If the element at pivot index equals num,
      //then it's found and return it
      if(array[pivot] == num){
        return pivot;
      
      //If the element at pivot index is less than num,
      //then eleminate all elements before pivot
      //and restart the process from pivot+1 index
      }else if(array[pivot] < num){
        low = pivot + 1;
        
      //If the element at pivot index is larger than num,
      //then eleminate all elements after pivot
      //and restart the process till pivot-1 index
      }else{
	high = pivot - 1;
      }
    }
    
    //Return -1 if nothing found
    return -1;
  }
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
      int index= binarySearch(array, s.nextInt());
      
      //If index equals -1, then the number not found
      if(index == -1){
        System.out.println("Number not found");
      
      //Print index to user, if it is not equal -1
      }else{
        System.out.println("Number found at index: "+ index);
      }
      
    //Catch InputMismatchException error
    //The exception is thrown when the user
    //enter a non-integer value
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
