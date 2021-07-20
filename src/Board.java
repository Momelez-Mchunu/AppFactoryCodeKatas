import java.util.Random;
import java.util.ArrayList;
public class Board 
{
    private int row,column;
    private Cells grid[][],updatedGrid[][];
    public Board(int row, int column)
    {
       this.row = row;
       this.column =  column;
       this.grid = new Cells[row][column];
       this.updatedGrid = new Cells[row][column];
       for (int i=0;i<row;i++)
       {
           for (int j=0;j<column;j++)
           {
              grid[i][j] = new Cells();
              updatedGrid[i][j] = new Cells();
           }
       }
       generateBoard();
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
                    grid[row][col].setAlive();
           } 
       }        
    }
    public ArrayList<Cells> checkNeighbours(int rowCheck,int colCheck)
    {
         int min_traverse = -1;
         int max_traverse = 2;
         int neighbourRow,neighbourCol;
         boolean isNeighbourValid;
         ArrayList<Cells> neighbours = new ArrayList<Cells>();
         for (int row=min_traverse;row<max_traverse;row++)
        {
            for (int col=min_traverse;col<max_traverse;col++)
            {
                neighbourRow = rowCheck + row;
                neighbourCol = colCheck + col;  
                isNeighbourValid = true;
                
                if ((neighbourRow == rowCheck) && (neighbourCol == colCheck))
                    isNeighbourValid = false;

                if ((neighbourRow < 0) || (neighbourRow >= this.row))
                    isNeighbourValid = false;

                if ((neighbourCol < 0 ) || (neighbourCol >= this.column))
                    isNeighbourValid = false;

                if (isNeighbourValid)
                    neighbours.add(grid[neighbourRow][neighbourCol]);
            }
        }
        return neighbours;
    }
    public void updateBoard()
    {
        /*ArrayList<Cells> dies =  new ArrayList<Cells>();
        ArrayList<Cells> lives =  new ArrayList<Cells>();*/
        ArrayList<Cells> countLivingNeighbours =new ArrayList<Cells>();
        ArrayList<Cells> neighbours;
        Cells currentCell;

        for (int row=0;row<grid.length;row++)
        {
            for (int col=0;col<grid[row].length;col++)
            {
                neighbours = checkNeighbours(row, col);
                for (int checkNeighbour=0;checkNeighbour<neighbours.size();checkNeighbour++)
                {
                    if (neighbours.get(checkNeighbour).isAlive())
                        countLivingNeighbours.add(neighbours.get(checkNeighbour));    
                }
                currentCell = grid[row][col];
                if (currentCell.isAlive())
                {
                    if ((countLivingNeighbours.size() < 2) ||  (countLivingNeighbours.size()> 3))
                    {
                        updatedGrid[row][col] = currentCell;
                        updatedGrid[row][col].setDead();
                    }   
                    if ((countLivingNeighbours.size() ==2) ||  (countLivingNeighbours.size()==3))
                    {
                        updatedGrid[row][col] = currentCell;
                        updatedGrid[row][col].setAlive();
                    }    
                }
                else
                {
                    if (countLivingNeighbours.size()==3)
                    {
                        updatedGrid[row][col] = currentCell;
                        updatedGrid[row][col].setAlive();

                    }
                }

            }
        }
        for (int i=0;i<updatedGrid.length;i++)
        {
            for (int j=0;j<updatedGrid[i].length;j++)
            {
                grid[i][j] = updatedGrid[i][j];
            }
        }
    }
}
