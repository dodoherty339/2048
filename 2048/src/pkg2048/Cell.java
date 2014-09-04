package pkg2048;
 
public class Cell
{   
    private Integer value;
   
    public Cell()
    {
        this.value=null;
    }
   
    protected boolean isCellOpen()
    {
        boolean openClose = true;
               
        if(getValue()!=null)
        {
            openClose = false;
        }
       
        return openClose;
    }
   
    protected void setValue(Integer value)
    {
       this.value=value;
    }
   
    protected Integer getValue()
    {
        return value;
    }
}
