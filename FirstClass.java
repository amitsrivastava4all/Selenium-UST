
public class FirstClass {

	// Execution or Starting point of Your Program
	public static void main(String[] args) {
		//System.out.println("Hello Java ");
		byte x = 10;  // 1 byte (Memory)
		// 1 Byte ----> 8 Bit
		/*
		  8 Bit ---> 7 Bit is for Number and 1 Bit is for + , -
		  Bit is made of 0 and 1 so the Base is 2 
		  -2 ^ 7 to 2 ^ 7 -1
		  -128 to 127
		 */
		int a = 10;  // a is a Variable and it store 10 and it is of int type
		// 4 byte (Memory)
		/*
		 * 4 Byte = 32 Bit
		 * 32 Bit ---> 1 Bit for Sign (+,-) and 31 Bit for Number
		 * -2 ^ 31 to 2 ^ 31 - 1
		 * 
		 */
		int b = 20;
		int c =  a + b;
		System.out.println("Sum of A and B is "+c);

	}

}
