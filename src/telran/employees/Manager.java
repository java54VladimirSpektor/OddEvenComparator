package telran.employees;

public class Manager extends Employee {

	private float factor;
	//Constructor of class Manager must take factor (see UML schema)
	public Manager(long id, int basicSalary, String department,float factor) {
		super(id, basicSalary, department);
		this.factor=factor;
	}
	
	public float getFactor() {
		return factor;
	}
	public void setFactor(float factor) {
		this.factor = factor;
	}
	@Override
	public int computeSalary(){
		
		return (int) (super.computeSalary()*factor);
		
	}

}