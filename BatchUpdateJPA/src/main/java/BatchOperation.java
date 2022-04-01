import javax.persistence.*;
import java.util.ArrayList;

public class BatchOperation {
   static int entityCount = 10;
   static int batchSize = 5;

    public static void batchInsert(){
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("employee_persistence_xml");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {/**Batch Insert */
            entityTransaction.begin();
            for (int i = 0; i < entityCount; i++) {
                if (i > 0 && i % batchSize == 0) {/**this if will work till 2nd last commit */
                    entityTransaction.commit();
                    entityTransaction.begin();
                    entityManager.clear();/**After each commit you need to clear the context present*/
                }
                Employee employee = new Employee("EmpName-"+i,"designation-"+i,"city-"+i,1200+i);
                entityManager.persist(employee);
            }
            entityTransaction.commit();
        } catch (RuntimeException e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw e;
        }finally {
            entityManager.close();
        }
    }

    public static void batchDelete(){
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("employee_persistence_xml");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Query firstIdQuery = entityManager.createQuery("FROM Employee");
        ArrayList<Employee> employeeList= (ArrayList<Employee>) firstIdQuery.getResultList();
        Employee tempEmployee = employeeList.get(0);
        int firstIdFromDB=tempEmployee.getId();

        try {/**Batch Insert */
            entityTransaction.begin();
            for (int i = firstIdFromDB; i < firstIdFromDB+entityCount; i++) {
                if (i > firstIdFromDB && i % batchSize == 0) {/**this if will work till 2nd last commit */
                    entityTransaction.commit();
                    entityTransaction.begin();
                    entityManager.clear();/**After each commit you need to clear the context present*/
                }
                Employee employee = entityManager.find(Employee.class,i);
                entityManager.remove(employee);
            }
            entityTransaction.commit();
        } catch (RuntimeException e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw e;
        }finally {
            entityManager.close();
        }
    }
}
