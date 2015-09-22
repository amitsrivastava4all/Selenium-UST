
public class Demo2 {

	public static void main(String[] args) {
		// Variable - It is used to hold the Value and that value can be
		// change
		// Constant - Constant r fixed and cant be change in future
		final int firstNumber = 100;
		//firstNumber++;
		System.out.println("First Number is "+firstNumber);
		
		// Keyword - r the reserverd words and it has some special
		// meaning for the Compiler
		// e.g int , float , public , final , static etc.
		
		// Data Types
		// 1. numbers
		// 2. char
		// 3. boolean
		// 4. String
		//**********************************************************
		
		float e = 10.10f; //4 Byte
		double r = e;  // Implicit Type Casting  
		float w = 10.20f;
		float y = (float)90.10;  //Explicit Type Casting
		float z = w + y;
		System.out.println("Sum is "+z);
		

	}

}
