import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String emp_name;
    String designation;
    String city;
    float salary;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Employee(){}
    public Employee(String emp_name, String designation, String city, float salary) {
        this.emp_name = emp_name;
        this.designation = designation;
        this.city = city;
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", emp_name='" + emp_name + '\'' +
                ", designation='" + designation + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                '}';
    }

    public void acceptEmployeeDetails() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Employee Name: ");
        this.setEmp_name(bufferedReader.readLine());
        System.out.println("Enter Employee Designation: ");
        this.setDesignation(bufferedReader.readLine());
        System.out.println("Enter Employee City: ");
        this.setCity(bufferedReader.readLine());
        System.out.println("Enter Employee Salary: ");
        this.setSalary(Float.parseFloat(bufferedReader.readLine()));
    }

}
