package main;

public class Subroutine {
	
	public static void main(String[] args) {
		
		int randomNumber = generateInt(20, 30);
		System.out.println("the random number is " + randomNumber) ;
		int[] arr = new int [randomNumber];
		System.out.println("the memory addres is "  + arr);
		//display the array -> it should be zeroes at this point
		display(arr);
		
		//fill the array
		fillArray(arr);
		
		display(arr);
		
		bubbleSort(arr);
		//display(arr);
		//end of main driver method
	}
	
	public static void bubbleSort(int [] nums) {
		
		boolean sorted = false;
		int count = 0;
		
		while(sorted == false) {
		
		//make a for loop and go through all the numbers
			for (int i = 0; i < nums.length-1; i++) {
			
			//save the left and right sides of the sub-array to integers
				int left = nums[i];
				int right = nums[i+1];
				if (right < left) {
				
					//System.out.println("the number of" + right + " is less than" + left+ " so we must swap them");
					nums[i] = right;
					nums[i + 1] = left;
					//start at the beginning
					i = 0;
					count = 0;
					
					try {
						for (int k = 0; k < 200; k++) {
							System.out.println("");
						}
						
						display(nums);
						System.out.println("\n\n");
						Thread.sleep(30);
					}catch (Exception e) {
						System.out.println(e);
					}
					
					//continue;
			}else {
				count ++;
				if( count > nums.length - 1) {
					
					//System.out.println("we for all the way to the end and we didnt need to make any swaps");
				sorted = true;
				break;
				}
			}
		// end of the for loop
		}
			//end of while loop
		}
		//end of the bubbleSort method
	}
	
	public static void fillArray(int [] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = generateInt(-100, 100);
		}
		
		//end of fillArray method
	}
	//this will display the elements of the array on a single line
	public static void display(int [] nums) {
		System.out.print("\n[ ");
		for (int i = 0; i < nums.length; i++) {
			if( i == nums.length-1) {
				System.out.print(nums[i] + " ] \n");
			}else {
				System.out.print(nums[i]+ ", ");
			}
			
			//end of for loop
		}
	}
	
	

	public static  int generateInt(int min, int max) {
		
		int rand = (int) (Math.random() * (max - min)) + min;
		return rand;
		
		
		
		
		
		//end of generate int function
	}
	
	
//end of subroutine class
}
