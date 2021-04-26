package Main;

import Models.Admin;
import Models.Category;
import Models.Client;
import Models.Employee;
import Models.Event;

import java.util.*;

public class main
{
    
    // function to handle InputMisMatchException
    // raised when input is expected to be int
    // but recieved other
    public static int getInt(String str)
    {
        Scanner input = new Scanner(System.in);
        
        int value = -1;
        
        try
        {
            value = input.nextInt();
        }
        catch(InputMismatchException e)
        {
            System.out.println("Please Enter an Integer only.");
            System.out.print(str);
        }
        finally
        {
            return value;
        }
    }
    
    // same as getInt but for first choice input
    public static int getFirstChoice()
    {
        Scanner input = new Scanner(System.in);
        
        int value = -1;
        
        try
        {
            value = input.nextInt();
        }
        catch(InputMismatchException e)
        {
            System.out.println("Please Enter an Integer only.\n");
            System.out.println("1- Enter(1) to sign in as Admin: ");
            System.out.println("2- Enter(2) to sign in as Employee: ");
            System.out.println("3- Enter(3) to sign up as Admin: ");
            System.out.println("4- Enter(4) to sign up as Employee: ");
            System.out.print("Your choice: ");
        }
        finally
        {
            return value;
        }
    }
    
    // same as getInt but for second choice input
    public static int getSecondChoice()
    {
        Scanner input = new Scanner(System.in);
        
        int value = -1;
        
        try
        {
            value = input.nextInt();
        }
        catch(InputMismatchException e)
        {
            System.out.println("Please Enter an Integer only.\n");
            System.out.println("1- Enter(1) to add category: ");
            System.out.println("2- Enter(2) to Edit category: ");
            System.out.println("3- Enter(3) to Delete category: ");
            System.out.println("4- Enter(4) to Display All categories: ");
            System.out.println("5- Enter(5) to add Event: ");
            System.out.println("6- Enter(6) to Edit Event: ");
            System.out.println("7- Enter(7) to Delete Event: ");
            System.out.println("8- Enter(8) to Display All Events: ");
            System.out.println("9- Enter(9) to Sign out: ");
            System.out.println("10- Enter(0) to Exit: ");
            System.out.print("Your choice: ");
        }
        finally
        {
            return value;
        }
    }
    
    // same as getInt but for third choice input
    public static int getThirdChoice()
    {
        Scanner input = new Scanner(System.in);
        
        int value = -1;
        
        try
        {
            value = input.nextInt();
        }
        catch(InputMismatchException e)
        {
            System.out.println("Please Enter an Integer only.\n");
            System.out.println("1- Enter(1) to add client: ");
            System.out.println("2- Enter(2) to remove client: ");
            System.out.println("3- Enter(3) to display all clients data: ");
            System.out.println("4- Enter(4) to display client data: ");
            System.out.println("5- Enter(5) to display event of category: ");
            System.out.println("6- Enter(6) to Book event to client: ");
            System.out.println("7- Enter(7) to UnBook event to client: ");
            System.out.println("8- Enter(8) to Search event by name: ");
            System.out.println("9- Enter(9) to display event details: ");    
            System.out.println("10- Enter(10) to Sign out: ");
            System.out.println("11- Enter(0) to Exit: ");
            System.out.print("Your choice: ");
        }
        finally
        {
            return value;
        }
    }
    
    public static void main(String[] args)
    {
        // variable to hold value of user input
        int choice = -1;
        
        // boolean to check for lifetime of application
        Boolean all = true;
        
        Scanner input = new Scanner(System.in);
        
        Employee employee = new Employee();
        Admin admin = new Admin();
        
        while (all)
        {
            
            // check if user isnt logged in
            while (Employee.isCheck())  
            {
                System.out.println("\t\t\t\t\tSign in");
                System.out.println("1- Enter(1) to sign in as Admin: ");
                System.out.println("2- Enter(2) to sign in as Employee: ");
                System.out.println("3- Enter(3) to sign up as Admin: ");
                System.out.println("4- Enter(4) to sign up as Employee: ");
                System.out.print("Your choice: ");
                
                // checking if choice's value changed
                // it will stay -1 as long as input is not integer,
                // and will continue asking user for input until int is passed
                while (choice == -1)
                {
                    choice = getFirstChoice();
                }
                
                switch (choice)
                {
                    case 1:
                        admin.logIn();
                        
                        // reset choice value
                        choice = -1;
                        break;
                        
                    case 2:
                        employee.logIn();
                        
                        choice = -1;
                        break;
                        
                       case 3:
                        admin.signUp();
                        
                        choice = -1;
                        break;
                        
                    case 4:
                        employee.signUp();
                        
                        choice = -1;
                        break;
                        
                    default:
                        System.out.println("Wrong Input\nTry again");
                        
                        Employee.setAdmin(false);;
                        Employee.setEmployee(false);
                        Employee.setCheck(true);
                        choice=-1;
                        
                        break;
                }
            }
            
            // check if user logged in as an admin
            while (Employee.isAdmin())
            {
                System.out.println("\t\t\t\t\tAdmin menu");
                System.out.println("1- Enter(1) to add category: ");
                System.out.println("2- Enter(2) to Edit category: ");
                System.out.println("3- Enter(3) to Delete category: ");
                System.out.println("4- Enter(4) to Display All categories: ");
                System.out.println("5- Enter(5) to add Event: ");
                System.out.println("6- Enter(6) to Edit Event: ");
                System.out.println("7- Enter(7) to Delete Event: ");
                System.out.println("8- Enter(8) to Display All Events: ");
                System.out.println("9- Enter(9) to Sign out: ");
                System.out.println("10- Enter(0) to Exit: ");
                System.out.print("Your choice: ");
                
                while (choice == -1)
                {
                    choice = getSecondChoice();
                }

                // add category
                if (choice == 1)
                {
                    String categoryName;
                        
                    System.out.print("\nEnter category name: ");

                    categoryName = input.next();

                    Category cat = new Category(categoryName);

                    admin.addCategory(Employee.getCategories().size(), cat);

                    System.out.println("\nCategory added\nThere are " + Employee.getCategories().size() + " categories");
                    
                    choice = -1;
                }
                
                // edit category
                else if (choice == 2)
                {
                    int i = -1;
                    String categoryName;

                    admin.displayCategory();
                        
                    if (!Employee.getCategories().isEmpty())
                    {
                        System.out.print("\nEnter the number of category you want to edit: ");

                        while (i == -1)
                        {
                            i = getInt("\nEnter the number of category you want to edit: ");
                        }

                        System.out.print("\nEnter the new category name: ");

                        categoryName = input.next();

                        Category cat = new Category(categoryName);

                        admin.editCategory(i - 1, cat);

                        System.out.println("\nCategory edited\nThere are " + Employee.getCategories().size() + " categories");
                    }
                    
                    choice = -1;
                }
                
                // delete category
                else if (choice == 3)
                {
                    int i = -1;    

                    admin.displayCategory();
                        
                    if (!Employee.getCategories().isEmpty())
                    {
                        System.out.print("\nEnter the number of category you want to delete: ");

                        while (i == -1)
                        {
                            i = getInt("\nEnter the number of category you want to delete: ");
                        }

                        admin.deleteCategory(i - 1);

                        System.out.println("\nCategory deleted\nThere are " + Employee.getCategories().size() + " categories");
                    }
                    
                    choice = -1;
                }
      
                // display categories data
                else if (choice == 4)
                {
                    admin.displayCategory();
                    
                    choice = -1;
                }
    
                // add event
                else if (choice == 5)
                {
                    int eventNumberOfTickets = -1;
                    int eventTime = -1;
                    String eventName, eventCategory, eventDescription, eventPlace;
                    
                    System.out.print("\nEnter Event name: ");
                        
                    eventName = input.next();

                    System.out.print("\nEnter Event place: ");

                    eventPlace = input.next();

                    System.out.print("\nEnter Event description: ");

                    eventDescription = input.next();

                    System.out.print("\nEnter number of available tickets: ");

                    while (eventNumberOfTickets == -1)
                    {
                        eventNumberOfTickets = getInt("\nEnter number of available tickets: ");
                    }

                    System.out.print("\nEnter Event time: ");

                    while (eventTime == -1)
                    {
                        eventTime = getInt("\nEnter Event time: ");
                    }

                    System.out.print("\nEnter category: ");

                    eventCategory = input.next();

                    Event eve = new Event(eventName, eventPlace, eventDescription, eventNumberOfTickets, eventTime, eventCategory);

                    admin.addEvent(Employee.getEvents().size(), eve);

                    System.out.println("\nEvent added\nThere are " + Employee.getEvents().size() + " events");
                    
                    choice = -1;
                }
    
                // edit event
                else if (choice == 6)
                {
                    int i = -1;
                    int eventNumberOfTickets = -1;
                    int eventTime = -1;
                    String eventName, eventCategory, eventDescription, eventPlace;
            
                    Admin.displayEvents();
                        
                    if (!Employee.getCategories().isEmpty())
                    {
                        System.out.print("\nEnter the number of event you want to edit: ");

                        while (i == -1)
                        {
                            i = getInt("\nEnter the number of event you want to edit: ");
                        }

                        System.out.print("\nEnter new Event name: ");

                        eventName = input.next();

                        System.out.print("\nEnter new Event place: ");

                        eventPlace = input.next();

                        System.out.print("\nEnter new Event description: ");

                        eventDescription = input.next();

                        System.out.print("\nEnter new number of available tickets: ");

                        while (eventNumberOfTickets == -1)
                        {
                            eventNumberOfTickets = getInt("\nEnter new number of available tickets: ");
                        }

                        System.out.print("\nEnter new Event time: ");

                        while (eventTime == -1)
                        {
                            eventTime = getInt("\nEnter new Event time: ");
                        }

                        System.out.print("\nEnter new category: ");

                        eventCategory = input.next();

                        Event eve = new Event(eventName, eventPlace, eventDescription, eventNumberOfTickets, eventTime, eventCategory);

                        admin.editEvent(i - 1, eve);

                        System.out.println("\nEvent edited\nThere are " + Employee.getEvents().size() + " events");
                    }
                    
                    choice = -1;
                }
    
                // delete event
                else if (choice == 7)
                {
                    int i = -1;    

                    Admin.displayEvents();
                        
                    if (!Employee.getCategories().isEmpty())
                    {
                        System.out.print("\nEnter the number of event you want to delete: ");

                        while (i == -1)
                        {
                            i = getInt("\nEnter the number of event you want to delete: ");
                        }

                        admin.deleteEvent(i - 1);

                        System.out.println("\nEvent deleted\nThere are " + Employee.getEvents().size() + " events");
                    }
                    
                    choice = -1;
                }
    
                // display events data
                else if (choice == 8)
                {
                    Admin.displayEvents();
                    
                    choice = -1;
                }
    
                // log out
                else if (choice == 9)
                {
                    Employee.setAdmin(false);
                    Employee.setCheck(true);
                    
                    choice = -1;
                }
       
                // exit
                else if (choice == 0)
                {
                    Employee.setAdmin(false);
                    Employee.setCheck(false);
                    all = false;
                    Employee.setEmployee(false);
                    
                    choice = -1;
                }
                
                else
                {
                    choice = -1;
                    
                    System.out.println("\nPlease enter only one of the specified values\n");
                }
            }
            
            // check if user logged in as an employee
            while(Employee.isEmployee())
            {
                System.out.println("\t\t\t\t\tEmployee menu"); 
                System.out.println("1- Enter(1) to add client: ");
                System.out.println("2- Enter(2) to remove client: ");
                System.out.println("3- Enter(3) to display all clients data: ");
                System.out.println("4- Enter(4) to display client data: ");
                System.out.println("5- Enter(5) to display event of category: ");
                System.out.println("6- Enter(6) to Book event to client: ");
                System.out.println("7- Enter(7) to UnBook event to client: ");
                System.out.println("8- Enter(8) to Search event by name: ");
                System.out.println("9- Enter(9) to display event details: ");    
                System.out.println("10- Enter(10) to Sign out: ");
                System.out.println("11- Enter(0) to Exit: ");
                System.out.print("Your choice: ");
    
                while (choice == -1)
                {
                    choice = getThirdChoice();
                }
    
                // add client
                if (choice == 1)
                {
                    String clientName, clientEmail;

                    System.out.print("\nEnter client name: ");

                    clientName = input.next();

                    System.out.print("\nEnter client email: ");

                    clientEmail = input.next();

                    Client cli = new Client(clientName, clientEmail);

                    employee.addClient(Employee.getClients().size(), cli);

                    System.out.println("\nClient added\nThere are " + Employee.getClients().size() + " clients");
                    
                    choice = -1;
                }
                
                // remove client
                else if (choice == 2)
                {
                    int i = -1;   
                    
                    employee.displayClientsData();

                    if (!Employee.getClients().isEmpty())
                    {
                        System.out.print("\nEnter the number of client you want to delete: ");

                        while (i == -1)
                        {
                            i = getInt("\nEnter the number of client you want to delete: ");
                        }

                        employee.removeClient(i - 1);

                        System.out.println("\nClient deleted\nThere are " + Employee.getClients().size() + " clients");
                    }
                    
                    choice = -1;
                }
                
                // display clients data
                else if (choice == 3)
                {
                    employee.displayClientsData();
                    
                    choice = -1;
                }
      
                // display one client data
                else if (choice == 4)
                {
                    int i = -1;
                    
                    employee.displayClientsData();
                        
                    if (!Employee.getCategories().isEmpty())
                    {
                        System.out.print("\nEnter the number of client you want to display: ");

                        while (i == -1)
                        {
                            i = getInt("\nEnter the number of client you want to display: ");
                        }

                        employee.displayClient(i - 1);
                    }
                    
                    choice = -1;
                }
    
                // display event of category
                else if (choice == 5)
                {
                    String cat;
                    
                    if (!Employee.getEvents().isEmpty())
                    {
                        System.out.print("\nEnter category name: ");

                        cat = input.next();

                        employee.displayEventsOfCategory(cat);
                    }
                    else
                    {
                        System.out.println("Ther are no events\nTry to create one.\n");
                    }
                    
                    choice = -1;
                }
    
                // book event to client
                else if (choice == 6)
                {
                    int i = -1;
                    int j = -1;
            
                    employee.displayClientsData();
                        
                    if (!Employee.getClients().isEmpty())
                    {
                        System.out.print("\nEnter the number of client: ");

                        while (i == -1)
                        {
                            i = getInt("\nEnter the number of client: ");
                        }

                        employee.displayEvents();

                        System.out.print("\nEnter the number of event: ");

                        while (j == -1)
                        {
                            j = getInt("\nEnter the number of event: ");
                        }

                        employee.bookEvent(i - 1, Employee.getEvents().get(j - 1));
                    }
                    
                    choice = -1;
                }
    
                // unbook event from client
                else if (choice == 7)
                {
                    int i = -1;
                    int j = -1;

                    if (!Employee.getClients().isEmpty())
                    {
                        System.out.print("\nEnter the number of client: ");

                        while (i == -1)
                        {
                            i = getInt("\nEnter the number of client: ");
                        }

                        employee.displayEvents();

                        if (!Employee.getEvents().isEmpty())
                        {
                            System.out.print("\nEnter the number of event: ");

                            while (j == -1)
                            {
                                j = getInt("\nEnter the number of event: ");
                            }

                            employee.unbookEvent(i - 1, Employee.getEvents().get(j - 1));
                        }
                    }
                    else
                    {
                        System.out.println("There are no clients\nTry to create one.\n");
                    }
                    
                    choice = -1;
                }
    
                // search event
                else if (choice == 8)
                {
                    String name;
                        
                    if (!Employee.getEvents().isEmpty())
                    {
                        System.out.print("\nEnter event name: ");

                        name = input.next();

                        employee.searchEvent(name);
                    }
                    
                    choice = -1;
                }
                
                // display event details
                else if (choice == 9)
                {
                    employee.displayEvents();
                    
                    choice = -1;
                }
    
                // log out
                else if (choice == 10)
                {
                    Employee.setEmployee(false);
                    Employee.setCheck(true);
                    
                    choice = -1;
                }
       
                // exit
                else if (choice == 0)
                {
                    Employee.setAdmin(false);
                    Employee.setCheck(false);
                    all = false;
                    Employee.setEmployee(false);
                    
                    choice = -1;
                }
                
                else
                {
                    choice = -1;
                    
                    System.out.println("\nPlease enter only one of the specified values\n");
                }
            }
        }
    }
}