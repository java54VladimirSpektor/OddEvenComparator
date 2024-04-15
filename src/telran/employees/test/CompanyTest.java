package telran.employees.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.employees.*;

class CompanyTest {
private static final long ID1 = 123;
private static final int SALARY1 = 1000;
private static final String DEPARTMENT1 = "Development";
private static final long ID2 = 120;
private static final int SALARY2 = 2000;
private static final long ID3 = 125;
private static final int SALARY3 = 3000;
private static final String DEPARTMENT2 = "QA";
private static final long ID4 = 200;
private static final String DEPARTMENT4 = "Audit";
private static final float FACTOR1=1.2f;
private static final int HOURS1=100;
private static final int WAGE1=20;

Employee empl1 = new Employee(ID1, SALARY1, DEPARTMENT1);
Employee empl2 = new Employee(ID2, SALARY2, DEPARTMENT1);
Employee empl3 = new Employee(ID3, SALARY3, DEPARTMENT2);
Employee empl4=  new Manager(ID2, SALARY1, DEPARTMENT1, FACTOR1);
Employee empl5=  new WageEmployee(ID1, SALARY3, DEPARTMENT1, HOURS1, WAGE1);

Company company;
@BeforeEach
void setCompany() {
	//before each test there will be created new object company 
	// with array of the given employee objects
	company = new Company(new Employee[] {empl1, empl2, empl3});
}
	@Test
	void testAddEmployee()
	{
		Employee empl = new Employee(ID4, SALARY1, DEPARTMENT1);
		company.addEmployee(empl);
		assertThrowsExactly(IllegalStateException.class,
				() -> company.addEmployee(empl));
		assertThrowsExactly(IllegalStateException.class,
				() -> company.addEmployee(empl1));
	}

	@Test
	void testGetEmployee() {
		assertEquals(empl1, company.getEmployee(ID1));
		assertNull(company.getEmployee(ID4));
	}

	@Test
	void testRemoveEmployee() {
		assertEquals(empl1, company.removeEmployee(ID1));
		assertThrowsExactly(NoSuchElementException.class,
				() -> company.removeEmployee(ID1));
	}

	@Test
	void testGetDepartmentBudget() {
		assertEquals(1000, empl1.computeSalary());
		assertEquals(0, company.getDepartmentBudget(DEPARTMENT4));
		assertEquals(empl1.computeSalary()+empl2.computeSalary(), company.getDepartmentBudget(DEPARTMENT1));
	}

	@Test
	void testIterator() {
		Employee[] expected = {empl2, empl1, empl3};
		Iterator<Employee> it = company.iterator();
		int index = 0;
		while(it.hasNext()) {
			assertEquals(expected[index++], it.next());
		}
		assertEquals(expected.length, index);
		assertThrowsExactly(NoSuchElementException.class, it::next);
	}
	@Test
	void testGetDepartments() {
		String[]expected= {DEPARTMENT1,DEPARTMENT2};
		assertArrayEquals(expected, company.getDepartments());
	}

}