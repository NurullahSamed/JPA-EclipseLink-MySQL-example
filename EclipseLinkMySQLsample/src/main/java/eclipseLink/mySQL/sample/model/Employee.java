package eclipseLink.mySQL.sample.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    
    @Id
    private int id;
    private String name;
    private String surname;
    private int salary;

    public Employee() {
	super();
    }

    public Employee(int id, String name, String surname, int salary) {
	super();
	this.id = id;
	this.name = name;
	this.surname = surname;
	this.salary = salary;
    }

    public void setSalary(int salary){
    	this.salary = salary;
    }
    
    public int getID(){
    	return id;
    }
    public String getName(){
    	return name;
    }
    public String getSurname(){
    	return surname;
    }
    public int getSalary(){
    	return salary;
    }
    

}