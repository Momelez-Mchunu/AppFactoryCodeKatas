import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BoardTest 
{
    Board board;
    @BeforeEach void initialiseBooard()
    {
        board = new Board(4,5);
    }
    @Test void testNumNeighbours()
    {
        assertEquals(8,board.checkNeighbours(2,3).size());
    }
    @Test void testIsAlive()
    {
        board.setAlive(2,2);
        board.drawBoard();
        assertTrue(board.accessCell(2, 2).isAlive());

    }
    @Test void testIsDead()
    {
        board.setAlive(3,4);
        board.drawBoard();
        board.setDead(3,4);
        board.drawBoard();
        assertFalse(board.accessCell(3, 4).isAlive());
    }
    @Test void testUpdateBoard()
    {
       board.setAlive(0,2);
       board.setAlive(1,2);
       board.setAlive(0,3);
       board.drawBoard();
       board.updateBoard();
       board.drawBoard();
       assertTrue(board.accessCell(1, 3).isAlive());
       
    }


}
