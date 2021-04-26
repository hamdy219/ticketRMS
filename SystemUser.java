package AbstractModels;

import java.util.*;

public abstract class SystemUser
{
    public String email, password, inputEmail, inputPassword;
    public Scanner input;
    
    public SystemUser()
    {
        input = new Scanner(System.in);
    }
    
    public SystemUser(String email, String password)
    {
        this.email = email;
        this.password = password;
        input = new Scanner(System.in);
    }
    
    public abstract void logIn();
    public abstract void signUp();
}