import java.util.Scanner;

public class BubbleSort{
	public static void main(String[] args){
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter 5 numbers to sort: ");
		int[] nums= new int[5];
		for(int i=0;i<5;i++){
			 nums[i]=scanner.nextInt();
		}
		System.out.println("numbers: ");
		for(int j=0;j<nums.length;j++){
			for(int i=0;i<nums.length-1;i++){
			if(nums[j]<nums[i]){
				int a=nums[i];
				nums[i]=nums[j];
				nums[j]=a;		
				
			}}
		}
		for(int k=0;k<nums.length;k++){
			System.out.println(nums[k]);
		}
	}
}
