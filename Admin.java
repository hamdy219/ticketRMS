package Models;

public class Admin extends AbstractModels.SystemUser
{
    public Admin()
    {
      super();
    }
    
    public Admin(String email, String password)
    {
      super(email, password);
    }
    
    public void addCategory(int index, Category cat)
    {
        Employee.getCategories().add(index, cat);
    }
  
    public void editCategory(int index ,Category cat)
    {
        Employee.getCategories().set(index, cat);
       
    }
 
    public void deleteCategory(int index)
    {
        Employee.getCategories().remove(index);
    }
      
    public void displayCategory()
    {
        if (Employee.getCategories().isEmpty())
        {
            System.out.println("Ther are no categories\nTry to create one.\n");
        }
        else
        {
            for(int i = 0; i < Employee.getCategories().size(); i++)
            {
                System.out.println("Category " + (i + 1) + ": " + Employee.getCategories().get(i).getCategoryName());
            }
        }
    }
    
    public void addEvent(int index, Event eve)
    {
        Employee.getEvents().add(index, eve);
    }
    
    public void editEvent(int index, Event e2)
    {
        Employee.getEvents().set(index, e2);
    }
    
    public void deleteEvent(int index)
    {
        Employee.getEvents().remove(index);
    }
    
    public static void displayEvents()
    {
        if (Employee.getEvents().isEmpty())
        {
            System.out.println("Ther are no events\nTry to create one.\n");
        }
        else
        {
            for (int i = 0; i < Employee.getEvents().size(); i++)
            {
                System.out.println("Event " + (i + 1) + "\n" + "Event name = " + Employee.getEvents().get(i).getName() +
                                          "\n" + "Event category = " + Employee.getEvents().get(i).getCategoryName() +
                                          "\n" + "Event place = " + Employee.getEvents().get(i).getPlace() +
                                          "\n" + "Event description = " + Employee.getEvents().get(i).getDescription() +
                                          "\n" + "Event number of available tickets = " + Employee.getEvents().get(i).getNumberOfTickets() +
                                          "\n" + "Event time=" + Employee.getEvents().get(i).getTime() +
                                          "\n");
            }
        }
    }
       
    @Override
    public void logIn()
    {
        boolean found = false;
        
        Employee.getAdmins().add(new Admin("adm", "adm"));
        Employee.getAdmins().add(new Admin("adm1", "adm1"));
        
        System.out.println("\t\t\t\t\tSIGN IN: ");
        System.out.print("\nUser name: "); 
        
        inputEmail = input.next();
         
        System.out.print("\n Password: "); 
        
        inputPassword = input.next();
         
        for (int i = 0; i < Employee.getAdmins().size(); i++)
        {
            if(inputEmail.equalsIgnoreCase(Employee.getAdmins().get(i).email) && inputPassword.equalsIgnoreCase(Employee.getAdmins().get(i).password))
            {
               Employee.setAdmin(true);
               Employee.setCheck(false);
               found = true;
               Employee.setEmployee(false);
            }
        }
        
        if (!found)
        {
            System.out.println("You entered wrong user name or password\nTry again");  

            Employee.setAdmin(false);
            Employee.setEmployee(false);
            Employee.setCheck(true);
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
        
        Employee.getAdmins().add(new Admin(s,p));
         System.out.println("you signed up as admin"); 
    }

}