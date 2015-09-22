import java.util.Scanner;


public class Demo4 {

	public static void main(String[] args) {
		// WAP two find out the greatest number b/w two numbers
		Scanner scanner = new Scanner(System.in);
		// Scanner is used to take input from the User
		
		System.out.println("Enter the First Number");
		int firstNumber = scanner.nextInt();  // It will take int input
		
		System.out.println("Enter the Second Number");
		int secondNumber = scanner.nextInt();
		if(firstNumber>secondNumber){  // true
			System.out.println("First Number is Greater");
		}
		if(firstNumber<secondNumber)
		
		{
			System.out.println("Second Number is Greater");
		}
		else
		{
			System.out.println("Both Numbers are Equal");
		}

	}

}
