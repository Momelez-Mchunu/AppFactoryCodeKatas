import java.util.Random;
public class Board 
{
    private int row,column;
    private Cells grid[][];
    public Board(int row, int column)
    {
       this.row = row;
       this.column =  column;
       this.grid = new Cells[row][column];
    }

    public void drawBoard()
    {
       for (int row=0;row<grid.length;row++)
       {
           for (int col=0;col<grid[row].length;col++)
           {
               System.out.print(grid[row][col].printStatus());
           }
           System.out.println();
       }
    }
    public void generateBoard()
    {
        Random random = new Random();
        for (int row=0;row<grid.length;row++)
       {
           for (int col=0;col<grid[row].length;col++)
           {
               if (random.nextInt(2)==1)
                    grid[row][column].setAlive();
                else
                    grid[row][column].setDead();
           }
           
       }
        
        
    }
    


}
