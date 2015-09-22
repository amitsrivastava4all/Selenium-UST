import java.util.Scanner;


public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		int result = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the First No");
		int firstNo = scanner.nextInt();
		System.out.println("Enter the Second No");
		int secondNo = scanner.nextInt();
		// try is a block where exception is generated
		try
		{
		 result = firstNo / secondNo;
		}
		// Handler Block of an Exception and it is write immediately
		// after the try block
		catch(ArithmeticException e){
			System.out.println("U Divide a No with zero ");
		}
		System.out.println("Result is "+result);

	}

}
