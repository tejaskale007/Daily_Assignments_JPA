package dao;

import com.bean.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class EmployeeDao {
   public static EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("employee_persistence_xml");

   public static void insertEmployeeDetails() throws IOException {
        Employee employee = new Employee();
        employee.acceptEmployeeDetails();
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        System.out.println("Employee Data Added");
        entityManager.close();
    }

    public static Object findEmployeeById() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        System.out.println("Enter Id to Search: ");
        Employee employee = entityManager.find(Employee.class, Integer.parseInt(bufferedReader.readLine()));
        entityManager.close();
        if(employee!=null)
            return employee;
        else
            return ("Employee Doesn't Exist");
    }

    public static void fetchAllEmployees(){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        List<Employee> employeeList =  entityManager.createQuery("from Employee").getResultList();
        for(Employee employee:employeeList)
            System.out.println(employee);
    }

    public static void updateEmployee() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        System.out.println("Enter Id to Update Record: ");
        Employee employee = entityManager.find(Employee.class, Integer.parseInt(bufferedReader.readLine()));
        if(employee!=null) {
            employee.acceptEmployeeDetails();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            System.out.println("Employee Updated");
        }
        else
            System.out.println("ID not Found");
        entityManager.close();
    }

    public static void deleteEmployee() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        System.out.println("Enter Id to Delete Record: ");
        Employee employee = entityManager.find(Employee.class, Integer.parseInt(bufferedReader.readLine()));
        if(employee!=null) {
            entityManager.remove(employee);
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        else
            System.out.println("No record found");
   }
}
