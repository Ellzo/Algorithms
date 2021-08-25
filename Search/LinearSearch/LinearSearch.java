public class LinearSearch{
	private static int search(int[] array, int item){
		//A loop for each item of the array
		for(int i=0; i<array.length ; i++){
			//Return the index of the item if found
			if(array[i] == item){
				return i;
			}
		}
		//Return -1 if nothing found
		return -1;
	}
	public static void main(String[] args){
		//Array
		int[] array = { 10, 5, 7, 0, -9, -17, 23 };

		//Initialize result variable
		//result gets the returned value from search method
		//Item to be searched is 2
		int result = search( array, 2 );

		if(result != -1){
			//Print the index of the item if result is not equal -1
			System.out.println("The item found at index: " + result );
		}else{
			//If result is equal -1, nothing was found
			System.out.println("Nothing found");
		}
	}
}
