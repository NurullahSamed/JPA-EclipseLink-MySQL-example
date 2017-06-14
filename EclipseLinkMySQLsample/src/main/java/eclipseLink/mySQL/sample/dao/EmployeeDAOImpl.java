package eclipseLink.mySQL.sample.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import eclipseLink.mySQL.sample.model.Employee;


public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Employee insertEmployee(int id, String name, String surname, int salary) {
		Employee employee = new Employee(id, name, surname, salary);
		entityManager.persist(employee);
		return employee;
	}

	public Employee findEmployee(int id) {
		return entityManager.find(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		Query query = entityManager.createQuery("Select e from Employee e");
		return query.getResultList();

	}

	public void removeEmployee(int id) {
		Employee employee = findEmployee(id);
		if (employee != null) {
			entityManager.remove(employee);			
		}
	}

	public Employee raiseEmployeeSalary(int id, int raise) {
		Employee employee = findEmployee(id);
		if (employee != null) {
			employee.setSalary(employee.getSalary() + raise);
		}
		return employee;

	}

}