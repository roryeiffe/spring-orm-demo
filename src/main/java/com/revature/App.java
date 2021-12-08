package com.revature;

import com.revature.dao.EmployeeDao;
import com.revature.entities.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        EmployeeDao dao = context.getBean("employeeDao", EmployeeDao.class);

        Scanner numberInput = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);

        boolean flag = true;
        while(flag){
            System.out.println("********************");
            System.out.println("PRESS 1: Add Employee");
            System.out.println("PRESS 2: Get All Employees");
            System.out.println("PRESS 3: Get Employee by Id");
            System.out.println("PRESS 4: Update Employee");
            System.out.println("PRESS 5: Delete Employee");
            System.out.println("PRESS 6: Quit");

            try {
                int choice = numberInput.nextInt();
                switch(choice){
                    case 1:
                        Employee e = new Employee();
                        System.out.print("Please enter your name=> ");
                        e.setName(stringInput.nextLine());
                        System.out.print("Please enter your email=> ");
                        e.setEmail(stringInput.nextLine());
                        dao.insert(e);
                        break;
                    case 2:
                        List<Employee> employees = dao.getAllEmployees();
                        for(Employee employee: employees) {
                            System.out.println(employee);
                        }
                        break;
                    case 3:
                        System.out.print("Please enter id=> ");
                        int id = numberInput.nextInt();
                        e = dao.getById(id);
                        System.out.println(e);
                        break;
                    case 4:
                        System.out.print("Please enter id=> ");
                        id = numberInput.nextInt();
                        e = dao.getById(id);
                        System.out.print("Please enter new name (empty if no change)=> ");
                        String name = stringInput.nextLine();
                        System.out.print("Please enter new email (empty if no change)=> ");
                        String email = stringInput.nextLine();
                        if(name.length() > 0) e.setName(name);
                        if(email.length() > 0) e.setEmail(email);
                        dao.update(e);
                        break;
                    case 5:
                        System.out.print("Please enter id to delete => ");
                        id = numberInput.nextInt();
                        dao.delete(id);
                        break;
                    case 6:
                        System.out.println("Thank you!");
                        System.out.println("Quitting...");
                        flag = false;
                }
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }



    }
}
