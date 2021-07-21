import java.util.Random;
import java.util.ArrayList;
public class Board 
{
    private int row,column;
    private Cells grid[][],updatedGrid[][];
    public Board(int row, int column)
    {
    /* 
     * Constructor used to initialise the Grid made up of cells
     * @param row
     * @param column
     * 
     * */
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
        /**
         * Iterate through the grid and draw board based on cell status
         */
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
        /**
         * Generate random board, where a cell has 50% chance of either starting out as dead or alive
         */
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
        /**
         * Calculate the number of neighbours a cell has 
         * @param rowCheck
         * @param colCheck
         * @return ArrayList<Cells>
         */
         int min_traverse = -1;
         int max_traverse = 2;
         int neighbourRow,neighbourCol;
         boolean isNeighbourValid;
         ArrayList<Cells> neighbours = new ArrayList<Cells>();
         for (int row=min_traverse;row<max_traverse;row++) // Loop from -1 to 1, As the neighbours are 1 row left/right of current row
        {
            for (int col=min_traverse;col<max_traverse;col++)// Loop from -1 to 1, As the neighbours are 1 column up/down of current row
            {
                neighbourRow = rowCheck + row;
                neighbourCol = colCheck + col;   
                isNeighbourValid = true;

                if ((neighbourRow == rowCheck) && (neighbourCol == colCheck)) // if the row/column are the same as the row/column being checked 
                    isNeighbourValid = false;

                if ((neighbourRow < 0) || (neighbourRow >= this.row))//Cannot have a -ve row number nor can the row be greater than that of vverall grid
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
        /**
         * Generate the next generation of cells based on the previous generation
         */
        ArrayList<Cells> neighbours=null;
        Cells currentCell=null;
        boolean neighbourStatus = false;
        int sizeOfLivingNeighbours;

        for (int row=0;row<grid.length;row++)
        {
            for (int col=0;col<grid[row].length;col++)
            {
                sizeOfLivingNeighbours = 0;
                neighbours = checkNeighbours(row, col);
                for (Cells checkNeighbour:neighbours) // Loop through the neighbours list to find living neighbours
                {
                    neighbourStatus = checkNeighbour.isAlive();
                    if (neighbourStatus==true)
                        sizeOfLivingNeighbours++;
                }
                currentCell = grid[row][col];
                if (currentCell.isAlive())
                {
                    if (sizeOfLivingNeighbours < 2 ||  sizeOfLivingNeighbours> 3)
                    {
                        updatedGrid[row][col] = currentCell;
                        updatedGrid[row][col].setDead();
                    }   
                    if (sizeOfLivingNeighbours==2 ||  sizeOfLivingNeighbours==3)
                    {
                        updatedGrid[row][col] = currentCell;
                        updatedGrid[row][col].setAlive();
                    }    
                }
                else
                {
                    if (sizeOfLivingNeighbours==3)
                    {
                        updatedGrid[row][col] = currentCell;
                        updatedGrid[row][col].setAlive();
                    }
                    else
                    {
                        updatedGrid[row][col] = currentCell;
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
