package Models;

public class Category
{
    protected String categoryName;

    public Category() {}

    public Category(String categoryName) 
    {
        this.categoryName = categoryName;
    }
    
    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }
     
    public String getCategoryName()
    {
        return categoryName;
    }
}