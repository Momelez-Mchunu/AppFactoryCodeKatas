public class Cells 
{
    private String status;
    public Cells()
    {
        this.status ="dead";
    }

    public void setDead()
    {
        status = "dead";
    }

    public void setAlive()
    {
        status = "alive";
    }

    public boolean isAlive()
    {
        boolean flag;
        if (status.equals("alive"))
            flag = true;
        else
           flag = false;
        return flag;
        
    }
    public String printStatus()
    {
        String result;
        if (isAlive())
           result = "0";
        else
           result =".";
        return result;
    }
    
}
