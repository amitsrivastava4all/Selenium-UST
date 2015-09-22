
public class OperatorsInJava {

	public static void main(String[] args) {
	 // Arithmetic Operator
	// + - * / % (Modulues)
	/*System.out.println(10 + 20);
	System.out.println(10-5);
	System.out.println(10 * 5);
	System.out.println(10/2);
	System.out.println(10%2);*/
	
	// Relational Operator
	// > < >= <= == !=
	//System.out.println(100>20);
	//System.out.println(100>1000);
	/*System.out.println(100>=100);
	System.out.println(10==10);
	System.out.println(10!=10);*/
	
	// Logical Operator
	// && , || , !
	//System.out.println(100>20 && 50 > 59);
	//System.out.println(100>20 || 50 >59);
	//System.out.println(!(100>200));
	
	// PreFix and PostFix operator
	int w = 100;
	//int e = w++;    // (Postfix) First Assign the value and then Increment it
	int e = ++w; //(Prefix) First Increment it and then Assign it
	System.out.println("W is "+w);
	System.out.println("E is "+e);
	

	}

}
