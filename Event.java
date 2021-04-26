package Models;

public class Event extends Category
{
    private String name, place, description;
    private int numberOfTickets, time;
    
    public Event() {}

    public Event(String name, String place, String description, int numberOfTickets, int time, String categoryName) 
    {
        super(categoryName);
        
        this.name = name;
        this.place = place;
        this.description = description;
        this.numberOfTickets = numberOfTickets;
        this.time = time;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPlace()
    {
        return place;
    }

    public void setPlace(String place)
    {
        this.place = place;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getNumberOfTickets()
    {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets)
    {
        this.numberOfTickets = numberOfTickets;
    }

    public int getTime()
    {
        return time;
    }

    public void setTime(int time)
    {
        this.time = time;
    }

    @Override
    public String getCategoryName()
    {
        return categoryName;
    }

    @Override
    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }
}