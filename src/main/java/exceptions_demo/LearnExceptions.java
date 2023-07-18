package exceptions_demo;

public class LearnExceptions {
	
	public static void main(String[] args) {
//		
//		int[] arr = {2,3,4,5,65,6};
//		
//		System.out.println(arr[6]);
//		
		
		// Exceptions and how to catch them
		int var = 1;
		int result;		
		
		try {
			System.out.println("Try block");
			result = 100 / var;
		} catch (ArithmeticException e) {
//			System.out.println("0 input is not accepted");
//			result = 0;
			System.out.println("Exception caught");;
		} finally {
			// Finally always runs no matter if exception happens or not
			System.out.println("Finally block");
			// Close resources
		}
		
//		System.out.println(result);
	}

}
