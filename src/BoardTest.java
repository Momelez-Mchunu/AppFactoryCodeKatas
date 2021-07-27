import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BoardTest 
{
    Board board;
    @BeforeEach void initialiseBooard()
    {
        board = new Board(10,10);
    }
    @Test void testNumNeighbours()
    {
        assertEquals(8,board.checkNeighbours(7,4).size());
    }
    @Test void testIsAlive()
    {
        board.setAlive(7,4);
        board.drawBoard();
        assertTrue(board.accessCell(7, 4).isAlive());

    }
    @Test void testIsDead()
    {
        board.setAlive(9,9);
        board.drawBoard();
        board.setDead(9,9);
        board.drawBoard();
        assertFalse(board.accessCell(9, 9).isAlive());
    }

}
