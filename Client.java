package Models;

import java.util.*;

public class Client
{
    private static int counter = 0;
    private String name, email;
    private double serialNumber;
    private ArrayList<Event> events = new ArrayList<>();

    public Client()
    {
        events = new ArrayList<>();
    }

    public Client(String name,String email)
    {
        this.name = name;
        this.email = email;
        serialNumber = counter++;
        events = new ArrayList<>();
        
        counter++;
    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(double serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public ArrayList<Event> getEvents()
    {
        return events;
    }

    public void setEvents(ArrayList<Event> events)
    {
        this.events = events;
    }

    public void displayClient(int i) 
    {
        System.out.println("Client " + (i + 1) + "\n" + "Client name = " + Employee.getClients().get(i).name +
                                   "\n" + "Client serial number = " + Employee.getClients().get(i).serialNumber +
                                   "\n" + "Client email = " + Employee.getClients().get(i).email +
                                   "\n");
    }
    
    public void displayEventsOfClient()
    {
        for (int i = 0; i < events.size(); i++)
        {
            System.out.println("Event " + (i + 1) + "\n" + "Event name = " + events.get(i).getName() +
                                      "\n" + "Category = " + events.get(i).getCategoryName() +
                                      "\n" + "Event place = " + events.get(i).getPlace() +
                                      "\n" + "Event description=" + events.get(i).getDescription() +
                                      "\n" + "Event number of available tickets = " + events.get(i).getNumberOfTickets() +
                                      "\n" + "Event time = " + events.get(i).getTime() +
                                      "\n");
        }
    }
}