
public class ArraysDemo {

	public static void main(String[] args) {
		int x = 10; // Variable hold the Single Value
		x = 20;
		int y[] = {100,200,300,400,500, 78, 656, 444,6,8,9};
		// Array Hold the Multiple Values 
		// Older Style to Traverse an Array
		/*for(int i = 0 ; i<y.length ; i++){
			System.out.println(y[i]);
		}*/
		// From Java 5 Onwards , Enhance for Loop
		for(int i : y){
			if(i==300){
				continue;
			}
			System.out.println(i);
		}

	}

}
