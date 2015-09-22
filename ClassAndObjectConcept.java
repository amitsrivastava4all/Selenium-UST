/*
 * Object is a Instance of a Class
 * Object is a Real World thing.
 * Sachin T, MS Dhoni, Rahul D all r objects
 * and they belongs to Category / Class is called Batsman
 */
// Class must be a Noun , e.g
// Customer , Person , Human , Employee, Student , Course, Account
class Employee // Class should be start with Capital Letter
{  // Class Start
	// private it is a predefine keyword and it will limit the 
	// scope of a member var (with in the class)
	private int id;  // Member Variable of a Class
	private String name;
	private double salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	// Method 
	
/*	// Local Var of Id
	public void setId(int id){
		if(id>0){
		//this.id = id;
			//id = i;
		}
		else{
			System.out.println("Wrong Id cant take it");
		}
		
	}
	public int getId(){
		return id;
	}*/
}   // Class End
public class ClassAndObjectConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee ram = new Employee(); // ram is a Object of Employee class
		// new is a Keyword , which create a new Memory for Employee
		/*ram.id = -1001;  // 77.id = 1001
		ram.name ="Ram Kumar";
		ram.salary = -9090.0;*/
		ram.setId(-1001);
	
		System.out.println(ram.getId());
		
		Employee mike = new Employee();
		mike.setId(999);
		System.out.println(mike.getId());
		/*System.out.println(ram.id);  // 77(ReferenceNO).id 
		System.out.println(ram.name);
		System.out.println(ram.salary);*/
	}

}
