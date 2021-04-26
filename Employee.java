package Models;

import java.util.*;

public class Employee extends AbstractModels.SystemUser
{
    private static ArrayList<Event> events = new ArrayList<>();
    private static ArrayList<Client> clients = new ArrayList<>();
    private static ArrayList<Category> categories = new ArrayList<>();
    private static ArrayList<Admin> admins = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();
    
    private static boolean check = true;
    private static boolean employee = false;
    private static boolean admin = false;
    
    public Employee()
    {
        super();
    }
    
    public Employee(String email, String password) 
    {
      super(email, password);
    }
    
    public static ArrayList<Event> getEvents()
    {
        return events;
    }

    public static void setEvents(ArrayList<Event> events)
    {
        Employee.events = events;
    }

    public static ArrayList<Client> getClients()
    {
        return clients;
    }

    public static void setClients(ArrayList<Client> clients)
    {
        Employee.clients = clients;
    }

    public static ArrayList<Category> getCategories()
    {
        return categories;
    }

    public static void setCategories(ArrayList<Category> categories)
    {
        Employee.categories = categories;
    }

    public static ArrayList<Admin> getAdmins()
    {
        return admins;
    }

    public static void setAdmins(ArrayList<Admin> admins)
    {
        Employee.admins = admins;
    }

    public static ArrayList<Employee> getEmployees()
    {
        return employees;
    }

    public static void setEmployees(ArrayList<Employee> employees)
    {
        Employee.employees = employees;
    }

    public static boolean isCheck() {
        return check;
    }

    public static void setCheck(boolean check) {
        Employee.check = check;
    }

    public static boolean isEmployee() {
        return employee;
    }

    public static void setEmployee(boolean employee) {
        Employee.employee = employee;
    }

    public static boolean isAdmin() {
        return admin;
    }

    public static void setAdmin(boolean admin) {
        Employee.admin = admin;
    }
    
    public void addClient(int index, Client cli)
    {
        clients.add(index, cli);
    }

    public void displayClient(int i) 
    {
        System.out.println("Client " + (i + 1) + "\n" + "Client name = " + clients.get(i).getName() +
                                   "\n" + "Client serial number = " + clients.get(i).getSerialNumber() +
                                   "\n" + "Client email = " + clients.get(i).getEmail() +
                                   "\n");
        
        for (int j = 0; j < events.size(); i++)
        {
            for (int k = 0; k < clients.get(i).getEvents().size(); k++)
            {
                if (events.get(i).equals(clients.get(i).getEvents().get(k)))
                {
                    System.out.println("Client booked events = " + clients.get(i).getEvents().get(k));
                }
            }
        }
    }
    
    public void displayClientsData() 
    {
        if (clients.isEmpty())
        {
            System.out.println("There are no clients\nTry creating one.");
        }
        else
        {
            for (int i = 0; i < clients.size(); i++)
            {
                System.out.println("Client " + (i + 1) + "\n" + "Client name = " + clients.get(i).getName() +
    //                                       "\n" + "Client serial number = " + clients.get(i).getSerialNumber() +
    //                                       "\n" + "email = " + clients.get(i).getEmail()  +
                                           "\n");
            }
        }
    }
    
    public void removeClient(int i)
    {
        clients.remove(clients.get(i));
    }
    
    public void displayEventsOfCategory(String cat)
    {
        for (int i = 0; i < events.size(); i++)
        {
            if (cat.contentEquals(events.get(i).getCategoryName()))
            {
                System.out.println("Event " + (i + 1) + "\n" + "Event name = " + events.get(i).getName() +
                                          "\n" + "Event place = " + events.get(i).getPlace() +
                                          "\n" + "Event description = " + events.get(i).getDescription() +
                                          "\n" + "Event number of available tickets = " + events.get(i).getNumberOfTickets() +
                                          "\n" + "Event time = " + events.get(i).getTime() +
                                          "\n");
            }
        }
    }
 
    public void searchEvent(String name)
    {
        if (events.isEmpty())
        {
            System.out.println("There are no events\nTry creating one.\n");
        }
        else
        {
            for (int i = 0; i < events.size(); i++)
            {
                if (name.contentEquals(events.get(i).getName()))
                {
                    System.out.println("Event " + (i + 1)+ "\n" + "Event name = " + events.get(i).getName() +
                                              "\n" + "Event place = " + events.get(i).getPlace() +
                                              "\n" + "Event description = " + events.get(i).getDescription() +
                                              "\n" + "Event number of available tickets = " + events.get(i).getNumberOfTickets() +
                                              "\n" + "Event time = " + events.get(i).getTime() +
                                              "\n");
                }
            }
        }
    }
    
    public void displayEvents() 
    {
        Admin.displayEvents();
    }
    
    public void bookEvent(int cli, Event eve)
    {
        if (events.get(events.indexOf(eve)).getNumberOfTickets() > 0)
        {
            clients.get(cli).getEvents().add(eve);
            
            events.get(events.indexOf(eve)).setNumberOfTickets(events.get(events.indexOf(eve)).getNumberOfTickets() - 1);
        }
        else
        {
            System.out.println("Sorry! there are no available tickets in this event");
        }
    }
    
    public void unbookEvent(int cli ,Event eve)
    {
        clients.get(cli).getEvents().remove(eve);
       
        events.get(events.indexOf(eve)).setNumberOfTickets(events.get(events.indexOf(eve)).getNumberOfTickets() + 1);
    }
   
    @Override
    public  void logIn()
    {
        boolean found = false;
        
        employees.add(new Employee("emp", "emp"));
        employees.add(new Employee("emp1", "emp1"));
           
        System.out.println("\t\t\t\t\tSIGN IN: ");
        System.out.print("\nUser name: ");
        
        inputEmail = input.next();
        
        System.out.print("\nPassword: "); 
        
        inputPassword = input.next();
         
        for (int i = 0; i < employees.size(); i++)
        {
            if (inputEmail.equalsIgnoreCase(employees.get(i).email) && inputPassword.equalsIgnoreCase(employees.get(i).password))
            {
                admin = false;
                check = false;
                found = true;
                employee = true;
            }
        }
        
        if (!found)
        {
            System.out.println("You entered wrong user name or password\nTry again");
          
            admin = false;
            employee = false;
            check = true;
        }
    }
    
    @Override
    public void signUp()
    {
        String s;
        String p;
        System.out.print("Enter email : ");
        s=input.next();
        System.out.print("Enter password : ");
        p=input.next();
        
        employees.add(new Employee(s,p));
         System.out.println("you signed up as employee"); 
    }

}