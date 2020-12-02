import java.util.Scanner;

public class TicTacToe
{
    //***************************************
    //Defining the board as a global variable
    //***************************************
    public static char[][] board = {{'1', '|', '2', '|', '3'},
                                    {'-', '|', '-', '|', '-'},
                                    {'4', '|', '5', '|', '6'},
                                    {'-', '|', '-', '|', '-'},
                                    {'7', '|', '8', '|', '9'}};
    
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int moveSelection;
        
        while (!playerWin(board))
        {
            drawBoard(board);
            System.out.print("Move location [1-9]: ");
            moveSelection = scanner.nextInt();
    
            makeMove(moveSelection);
        }
        

        drawBoard(board);
        System.out.println("Player Wins!!\n\n");
    }
    
    
    //**********************************
    //Function to test for win condition
    //**********************************
    public static boolean playerWin(char[][] board)
    {
        boolean flag = false;
        
        // This for loop tests for the Horizontal win condition for 'X'
        for (int i = 0; i < board.length; i++)
        {
            int count = 0;
            for (int j = 0; j < board[i].length; j++)
            {
                if (j % 2 == 0 && board[i][j] == 'X') //logic for if all values in a row are 'X'
                {
                    count++;
                }
            }
            
            if (count == 3)
            {
                flag = true;
            }
        }
    
        // This for loop tests for the Vertical win condition for 'X'
        // It is just the horizontal loop but I flipped the "i" and "j"
        for (int i = 0; i < board.length; i++)
        {
            int count = 0;
            for (int j = 0; j < board[i].length; j++)
            {
                if (j % 2 == 0 && board[j][i] == 'X') //logic for if all values in a column are 'X'
                {
                    count++;
                }
            }
        
            if (count == 3)
            {
                flag = true;
            }
        }
    
        // This for loop tests for the Diagonal win condition for 'X'
        // This for loop is incomplete***********************************************************
        for (int i = 0; i < board.length; i++)
        {
            int count = 0;
            for (int j = 0; j < board[i].length; j++)
            {
                if ((i == 0 || i == 4) && (j == 0 || j == 4) && board[i][j] == 'X') //logic for if all values in a corner are 'X'
                {
                
                }
            }
        
            if (count == 3)
            {
                flag = true;
            }
        }
        
        
        return flag;
    }
    
    
    //**********************************
    //Function that makes the players move based on position choice
    //**********************************
    public static void makeMove(int movePos)
    {
        switch(movePos){
            
            case 1:
                board[0][0] = 'X';
                break;
            case 2:
                board[0][2] = 'X';
                break;
            case 3:
                board[0][4] = 'X';
                break;
            case 4:
                board[2][0] = 'X';
                break;
            case 5:
                board[2][2] = 'X';
                break;
            case 6:
                board[2][4] = 'X';
                break;
            case 7:
                board[4][0] = 'X';
                break;
            case 8:
                board[4][2] = 'X';
                break;
            case 9:
                board[4][4] = 'X';
                break;
        }
    }
    
    
    
    //**********************************
    //Function to draw the board
    //**********************************
    public static void drawBoard(char[][] board)
    {
        System.out.println("\n|TicTacToe|Player: X|");
        System.out.println("=====================");
        
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board.length; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    
}
