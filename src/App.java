import java.util.Scanner;
public class App {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        if (args.length<2 || args.length>2)
        {
            
            System.out.println("Enter number of rows: ");
            int rows = Integer.parseInt(sc.nextLine());
            System.out.println("Enter number of columns: ");
            int columns = Integer.parseInt(sc.nextLine());
            Board game = new Board(rows,columns);
            game.drawBoard();
            String input= "";
            while (!(input.equals("quit")))
            {
                System.out.println("Press enter for new generation or type 'quit' to exit");
                input = sc.nextLine();
                if (input.equals(""))
                {
                    game.updateBoard();
                    game.drawBoard();
                }
            } 
        }
        else  
        {
            try {
                int rows = Integer.parseInt(args[0]);
                int columns = Integer.parseInt(args[1]);
                Board game = new Board(rows,columns,0);
                game.drawBoard();
                String input= "";
                while (!(input.equals("quit")))
                {
                    System.out.println("Press enter for new generation or type 'quit' to exit");
                    input = sc.nextLine();
                    if (input.equals(""))
                    {
                        game.updateBoard();
                        game.drawBoard();
                    }
                }   
            } catch (Exception e) {
                System.out.println("Please leave space between your integers");
            }
        }
        sc.close(); 
    }
}