package com.bean;

import dao.EmployeeDao;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DriverApplication {
    public static void main(String[] args) throws IOException {
        int choice = 0;
        EmployeeDao employeeDao = new EmployeeDao();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (choice != 100) {
            System.out.println("Enter Choice:\n1.Insert Employee Details\n2.Find By ID\n3.Fetch All Records\n4.Update Record\n5.Delete\n100.Exit");
            choice = Integer.parseInt(bufferedReader.readLine());
            switch (choice) {
                case 1:
                    employeeDao.insertEmployeeDetails();
                    break;
                case 2:
                    System.out.println(employeeDao.findEmployeeById());
                    break;
                case 3:
                    employeeDao.fetchAllEmployees();
                    break;
                case 4:
                    employeeDao.updateEmployee();
                    break;
                case 5:
                    employeeDao.deleteEmployee();
                    break;
            }
        }
    }
}
/*
Mar 30, 2022 2:19:02 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@43f9dd56] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Mar 30, 2022 2:19:02 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Enter Choice:
1.Insert Employee Details
2.Find By ID
3.Fetch All Records
4.Update Record
5.Delete
100.Exit
3
Hibernate:
    select
        employee0_.id as id1_0_,
        employee0_.city as city2_0_,
        employee0_.designation as designat3_0_,
        employee0_.emp_name as emp_name4_0_,
        employee0_.salary as salary5_0_
    from
        Employee employee0_
Employee{id=4, emp_name='Rohit Kanderi', designation='ASE-Intern', city='Noida', salary=9900.0}
Employee{id=5, emp_name='Tejas Shivaji Kale', designation='ASE-Intern', city='Pune-Maharashtra', salary=9009.0}
Enter Choice:
1.Insert Employee Details
2.Find By ID
3.Fetch All Records
4.Update Record
5.Delete
100.Exit
1
Enter Employee Name:
Deepak Kumar
Enter Employee Designation:
Intern
Enter Employee City:
Bihar
Enter Employee Salary:
9900
Hibernate:
    select
        next_val as id_val
    from
        hibernate_sequence for update

Hibernate:
    update
        hibernate_sequence
    set
        next_val= ?
    where
        next_val=?
Hibernate:
    insert
    into
        Employee
        (city, designation, emp_name, salary, id)
    values
        (?, ?, ?, ?, ?)
Employee Data Added
Enter Choice:
1.Insert Employee Details
2.Find By ID
3.Fetch All Records
4.Update Record
5.Delete
100.Exit
3
Hibernate:
    select
        employee0_.id as id1_0_,
        employee0_.city as city2_0_,
        employee0_.designation as designat3_0_,
        employee0_.emp_name as emp_name4_0_,
        employee0_.salary as salary5_0_
    from
        Employee employee0_
Employee{id=4, emp_name='Rohit Kanderi', designation='ASE-Intern', city='Noida', salary=9900.0}
Employee{id=5, emp_name='Tejas Shivaji Kale', designation='ASE-Intern', city='Pune-Maharashtra', salary=9009.0}
Employee{id=6, emp_name='Deepak Kumar', designation='Intern', city='Bihar', salary=9900.0}
Enter Choice:
1.Insert Employee Details
2.Find By ID
3.Fetch All Records
4.Update Record
5.Delete
100.Exit
4
Enter Id to Update Record:
4
Hibernate:
    select
        employee0_.id as id1_0_0_,
        employee0_.city as city2_0_0_,
        employee0_.designation as designat3_0_0_,
        employee0_.emp_name as emp_name4_0_0_,
        employee0_.salary as salary5_0_0_
    from
        Employee employee0_
    where
        employee0_.id=?
Enter Employee Name:
Rohit Kanderi
Enter Employee Designation:
ASE-Intern
Enter Employee City:
Delhi-India
Enter Employee Salary:
9899
Hibernate:
    update
        Employee
    set
        city=?,
        designation=?,
        emp_name=?,
        salary=?
    where
        id=?
Employee Updated
Enter Choice:
1.Insert Employee Details
2.Find By ID
3.Fetch All Records
4.Update Record
5.Delete
100.Exit
3
Hibernate:
    select
        employee0_.id as id1_0_,
        employee0_.city as city2_0_,
        employee0_.designation as designat3_0_,
        employee0_.emp_name as emp_name4_0_,
        employee0_.salary as salary5_0_
    from
        Employee employee0_
Employee{id=4, emp_name='Rohit Kanderi', designation='ASE-Intern', city='Delhi-India', salary=9899.0}
Employee{id=5, emp_name='Tejas Shivaji Kale', designation='ASE-Intern', city='Pune-Maharashtra', salary=9009.0}
Employee{id=6, emp_name='Deepak Kumar', designation='Intern', city='Bihar', salary=9900.0}
Enter Choice:
1.Insert Employee Details
2.Find By ID
3.Fetch All Records
4.Update Record
5.Delete
100.Exit
5
Enter Id to Delete Record:
4
Hibernate:
    select
        employee0_.id as id1_0_0_,
        employee0_.city as city2_0_0_,
        employee0_.designation as designat3_0_0_,
        employee0_.emp_name as emp_name4_0_0_,
        employee0_.salary as salary5_0_0_
    from
        Employee employee0_
    where
        employee0_.id=?
Hibernate:
    delete
    from
        Employee
    where
        id=?
Enter Choice:
1.Insert Employee Details
2.Find By ID
3.Fetch All Records
4.Update Record
5.Delete
100.Exit
2
Enter Id to Search:
4
Hibernate:
    select
        employee0_.id as id1_0_0_,
        employee0_.city as city2_0_0_,
        employee0_.designation as designat3_0_0_,
        employee0_.emp_name as emp_name4_0_0_,
        employee0_.salary as salary5_0_0_
    from
        Employee employee0_
    where
        employee0_.id=?
Employee Doesn't Exist
Enter Choice:
1.Insert Employee Details
2.Find By ID
3.Fetch All Records
4.Update Record
5.Delete
100.Exit
2
Enter Id to Search:
5
Hibernate:
    select
        employee0_.id as id1_0_0_,
        employee0_.city as city2_0_0_,
        employee0_.designation as designat3_0_0_,
        employee0_.emp_name as emp_name4_0_0_,
        employee0_.salary as salary5_0_0_
    from
        Employee employee0_
    where
        employee0_.id=?
Employee{id=5, emp_name='Tejas Shivaji Kale', designation='ASE-Intern', city='Pune-Maharashtra', salary=9009.0}
Enter Choice:
1.Insert Employee Details
2.Find By ID
3.Fetch All Records
4.Update Record
5.Delete
100.Exit
100

Process finished with exit code 0
 */