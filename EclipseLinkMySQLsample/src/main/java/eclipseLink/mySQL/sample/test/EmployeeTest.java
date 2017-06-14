package eclipseLink.mySQL.sample.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import eclipseLink.mySQL.sample.dao.EmployeeDAO;
import eclipseLink.mySQL.sample.dao.EmployeeDAOImpl;
import eclipseLink.mySQL.sample.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EmployeeDAO employeeService = new EmployeeDAOImpl(entityManager);

		entityTransaction.begin();
		Employee employee = employeeService.insertEmployee(1, "Samed", "Savas", 1000);
		Employee employee2 = employeeService.insertEmployee(2, "Büþra", "Karnucu", 10000);
		Employee employee3 = employeeService.insertEmployee(3, "Ahmet", "Balcý", 10000);
		entityTransaction.commit();

		System.out.println("Eklenen : " + employee.getID()+" - "+employee.getName()+" - "+employee.getSurname()+" - "+employee.getSalary());
		System.out.println("Eklenen : " + employee2.getID()+" - "+employee2.getName()+" - "+employee2.getSurname()+" - "+employee2.getSalary());
		System.out.println("Eklenen : " + employee3.getID()+" - "+employee3.getName()+" - "+employee3.getSurname()+" - "+employee3.getSalary());
		System.out.println();
		
		Employee employee4 = employeeService.findEmployee(3);
		System.out.println("3 ID No'lu kullanýcý : " + employee4.getID()+" - "+employee4.getName()+" - "+employee4.getSurname()+" - "+employee4.getSalary());
		System.out.println();
		
		entityTransaction.begin();
		Employee employee5 = employeeService.raiseEmployeeSalary(1, 1000);
		entityTransaction.commit();

		System.out.println("Maaþý güncellenen 1 ID no'lu kullanýcý : " +employee5.getName()+" "+employee5.getSurname());
		System.out.println();
		
		entityTransaction.begin();
		employeeService.removeEmployee(3);
		entityTransaction.commit();
		System.out.println("3 ID no'lu kullanýcý silindi.");
		System.out.println();
		
		System.out.println("Veri tabanýndaki tüm kullanýcýlar");
		List<Employee> employees = employeeService.findAllEmployees();
		for (Employee emp : employees) {
			System.out.println(emp.getID()+" - "+emp.getName()+" - "+emp.getSurname()+" - "+emp.getSalary());
		}
		System.out.println();
		
		entityTransaction.begin();
		employeeService.removeEmployee(1);
		entityTransaction.commit();
		System.out.println("1 ID no'lu kullanýcý silindi !");
		System.out.println();
		
		System.out.println("Veri tabanýndaki tüm kullanýcýlar :");
		List<Employee> employees2 = employeeService.findAllEmployees();
		for (Employee emp : employees2) {
			System.out.println(emp.getID()+" - "+emp.getName()+" - "+emp.getSurname()+" - "+emp.getSalary());
		}

	}
}