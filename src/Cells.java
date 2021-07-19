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
         if (status.equals("alive"))
            return true;
        return false;
    }
    public String printStatus()
    {
        if (isAlive())
           return "0";
        return ".";
    }
    
}
