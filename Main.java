package ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private List<Employee> employeeList = new ArrayList<>();

    private void showOptions(){
        System.out.println("\n1: Add New Employee"+
                "\n2: Print Employee List"+
                "\n3: Search Employee By Name"+
                "\n4: Remove Employee By ID"+
                "\n5:Exit");

    }

    private void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    private void removeEmployeeById(int id){

        for (Iterator<Employee> iterator = employeeList.iterator(); iterator.hasNext();){
            Employee employee = iterator.next();
            if (employee.getId()==id){
                iterator.remove();
            }
        }

        showEmployeeList();
    }
    private void searchEmployeeByName(String name){
        for (Employee employee:employeeList){
            if (employee.getName().equals(name)){
                System.out.println("Information about employee: "+employee.getName());
                System.out.println(employee.getId()+" "+employee.getSalary());
            }
        }
    }
    private void removeAllEmployeeFromList(List<Employee> employeeList){
        employeeList.removeAll(employeeList);
        System.out.println(employeeList);
    }

    private void showEmployeeList(){
        for (Employee employee:employeeList){
            System.out.println(employee.getId()+" "+employee.getName()+" "+employee.getSalary());
        }
    }

    private Employee takeEmployeeInput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Employee Name: ");
        String name = scan.nextLine();
        System.out.println("Enter Employee ID: ");
        int id = scan.nextInt();
        System.out.println("Enter Employee Salary: ");
        int salary = scan.nextInt();

        Employee newEmployee = new Employee(id,name,salary);

        return newEmployee;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        int option;
        do {
            main.showOptions();
            option = scan.nextInt();

            switch (option){
                case 1:
                    Employee employee = main.takeEmployeeInput();
                    main.addEmployee(employee);
                    break;
                case 2:
                    main.showEmployeeList();
                    break;
                case 3:
                    System.out.println("Enter the Employee Name to Search:");
                    String search = scan.next();
                    main.searchEmployeeByName(search);
                    break;
                case 4:
                    System.out.println("Enter the Employee ID to Remove from the List");
                    int remove = scan.nextInt();
                    main.removeEmployeeById(remove);
                    break;
                case 5:
                    System.exit(1);
                    break;
            }

        } while (option!=5);

//        Employee employee1 = new Employee(1,"Naren",50000);
//        Employee employee2 = new Employee(2,"visalatchi",60000);
//        Employee employee3 = new Employee(3,"Nikhilesh",10000);
//        Employee employee4 = new Employee(4,"Hai",100000);
//        Employee employee5 = new Employee(5,"logu",50000);
//
//        main.addEmployee(employee1);
//        main.addEmployee(employee2);
//        main.addEmployee(employee3);
//        main.addEmployee(employee4);
//        main.addEmployee(employee5);
//
//        main.showEmployeeList();
//        System.out.println("----------------------------------");
//
//        main.removeEmployeeById(2);
//        System.out.println("----------------------------------");
//        main.searchEmployeeByName("Naren");
//        System.out.println("----------------------------------");
//        main.removeAllEmployeeFromList(main.employeeList);


    }
}
