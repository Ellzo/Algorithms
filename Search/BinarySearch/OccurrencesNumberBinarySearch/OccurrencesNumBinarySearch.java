import java.util.Scanner;

public class OccurrencesNumBinarySearch{
	private static int occNum(int[] array, int num){
   		int first = firstIndexBinarySearch(array, num);
   		if(first == -1){
   			return 0;
   		}else{
   			return (lastIndexBinarySearch(array, num) - first + 1);
   		}
   	}

	private static int firstIndexBinarySearch(int[] array, int num){
		int low = 0;
		int high = array.length -1;
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
  
	private static int lastIndexBinarySearch(int[] array, int num){
		int low = 0;
		int high = array.length -1;
		int mid;
		int result = -1;
		while(low <= high){
			mid = (low+high)/2;
			if(array[mid] == num){
				result = mid;
				low = mid + 1;
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
      		
      		int occs = occNum(array, s.nextInt());
      		
      		if(occs == 0){
        		System.out.println("Number not found");
      		}else{
        		System.out.println("Occurrences number is: "+ occs);
      		}
	}
}
