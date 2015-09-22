import java.util.Scanner;


public class Demo5 {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the First No ");
		int firstNumber = scanner.nextInt();
		System.out.println("Enter the Second No");
		int secondNumber = scanner.nextInt();
		System.out.println("Enter the Third No");
		int thirdNumber = scanner.nextInt();
		if(firstNumber>secondNumber && firstNumber>thirdNumber){
			System.out.println("First No is Greater");
		}
		else
		if(secondNumber>firstNumber && secondNumber > thirdNumber){
			System.out.println("Second No is Greater");
		}
		else
		{
			System.out.println("Third No is Greater");
		}

	}

}
