package Week3;

import java.util.ArrayList;

public class VisitorPatternOriginal {
	public static void main(String[] args){
		SUTDVisitor visitor = new SUTDVisitor();
		Employee epe = new Employee();
		epe.accept(visitor);
		Professor NOOB = new Professor("YOU ARE SUCH A NOOB!",666);
		NOOB.accept(visitor);
	}
}

interface Visitor {
	public void visit(Employee employee);
	public void visit(Professor professor);
	public void visit(AdminStuff adminStuff);
	public void visit(Student student);
}
class SUTDVisitor implements Visitor {

	@Override
	public void visit(Employee employee) {
		SUTD oneSUTD = new SUTD ();
		ArrayList<Employee> employee1 = oneSUTD.getEmployee();
		for (int i =0; i < employee1.size(); i++) {
			if (employee1.get(i) instanceof Professor) {
				System.out.println("Prof: " + ((Professor) employee1.get(i)).getName() + ((Professor) employee1.get(i)).getNo_of_publications());
			}
			if (employee1.get(i) instanceof AdminStuff) {
				System.out.println("Prof: " + ((AdminStuff) employee1.get(i)).getName() + ((AdminStuff) employee1.get(i)).getEfficiency());
			}
			if (employee1.get(i) instanceof Student) {
				System.out.println("Prof: " + ((Student) employee1.get(i)).getName() + ((Student) employee1.get(i)).getGPA());
			}
		}
	}

	@Override
	public void visit(Professor professor) {
		System.out.println("Go away Trash, check your employee not prof");
	}

	@Override
	public void visit(AdminStuff adminStuff) {
		System.out.println("Go away Trash, check your employee not admin");
	}

	@Override
	public void visit(Student student) {
		System.out.println("Go away Trash, check your employee not student");
	}
}

interface Element {
	public void accept(Visitor visitor);
}



class SUTD {
	private ArrayList<Employee> employee;

	public SUTD () {
		employee = new ArrayList<Employee>();
		employee.add(new Professor("Sun Jun", 0));
		employee.add(new AdminStuff("Stacey", 5));
		employee.add(new Student("Allan", 3));
	}

	public ArrayList<Employee> getEmployee () {
		return employee;
	}

}

class Employee implements Element{

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

class Professor extends Employee implements Element {
	private String name;
	private int no_of_publications;

	public Professor (String name, int no_of_publications) {
		this.name = name;
		this.no_of_publications = no_of_publications;
	}

	public String getName () {
		return name;
	}

	public int getNo_of_publications() {
		return no_of_publications;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

class AdminStuff extends Employee implements Element{
	private String name;
	private float efficiency;

	public AdminStuff (String name, float efficiency) {
		this.name = name;
		this.efficiency = efficiency;
	}

	public String getName() {
		return name;
	}

	public float getEfficiency() {
		return efficiency;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

class Student extends Employee implements Element{
	private String name;
	private float GPA;

	public Student (String name, float GPA) {
		this.name = name;
		this.GPA = GPA;
	}

	public String getName() {
		return name;
	}

	public float getGPA() {
		return GPA;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}