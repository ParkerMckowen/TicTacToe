import java.util.Scanner;

public class TicTacToe extends Minimax
{
    
    public static class Board
    {
        public int[][] board;
        public int winner;
    
    
        Board()
        {
            this.board = new int[3][3];
            this.winner = 0;
            
            for (int i = 0; i < board.length; i++)
            {
                for (int j = 0; j < board.length; j++)
                {
                    board[i][j] = 0;
                }
            }
        }
    
    
        public int getBoardVal(int row, int col)
        {
            return this.board[row][col];
        }
        
        public int getWinner()
        {
            return this.winner;
        }
        
        public void setWinner(int winnerVar)
        {
            this.winner = winnerVar;
        }
        
        public int[][] getBoard()
        {
            return this.board;
        }
        
        public void setBoard(int row, int col, int player)
        {
            this.board[row][col] = player;
        }
    
    
        public void drawBoard()
        {
            System.out.println("\n|TicTacToe|");
            System.out.println("===========");
    
            for (int i = 0; i < board.length; i++)
            {
                for (int j = 0; j < board.length; j++)
                {
                    System.out.print(board[i][j] + " ");
                }
                System.out.print("\n");
            }
        }
        
        public boolean gameOver()
        {
            boolean flag = false;
            
            // This for loop tests for the Horizontal win condition
            for (int i = 0; i < 3; i++)
            {
                int count = 0;
                for (int j = 0; j < 3; j++)
                {
                    if (board[i][j] == 1 || board[i][j] == -1 ) //logic for if all values in a row are 'X'
                    {
                        count++;
                    }
                }
                if (count == 3)
                {
                    flag = true;
                }
            }
    
            // This for loop tests for the Horizontal win condition
            for (int i = 0; i < 3; i++)
            {
                int count = 0;
                for (int j = 0; j < 3; j++)
                {
                    if (board[j][i] == 1 || board[j][i] == -1 ) //logic for if all values in a row are 'X'
                    {
                        count++;
                    }
                }
                if (count == 3)
                {
                    flag = true;
                }
            }
    
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != 0)
            {
                flag = true;
            }
    
            if (board[2][2] == board[1][1] && board[1][1] == board[0][2] && board[1][1] != 0)
            {
                flag = true;
            }
            
            return flag;
        }
        
        
        public void makeMove(int movePos, int playerType)
        {
            switch (movePos)
            {
    
                case 1:
                    setBoard(0, 0, playerType);
                    break;
    
                case 2:
                    setBoard(0, 1, playerType);
                    break;
    
                case 3:
                    setBoard(0, 2, playerType);
                    break;
    
                case 4:
                    setBoard(1, 0, playerType);
                    break;
    
                case 5:
                    setBoard(1, 1, playerType);
                    break;
    
                case 6:
                    setBoard(1, 2, playerType);
                    break;
    
                case 7:
                    setBoard(2, 0, playerType);
                    break;
    
                case 8:
                    setBoard(2, 1, playerType);
                    break;
    
                case 9:
                    setBoard(2, 2, playerType);
                    break;
    
            }
        }
    }
 
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Board newBoard = new Board();
    
        

    
        while (!newBoard.gameOver())
        {
            newBoard.drawBoard();
            
            System.out.print("Your move[1-9]: ");
            int playerMove = scanner.nextInt();
            newBoard.makeMove(playerMove, 1);
    
            int[] cpuMove = outputBestMove(newBoard.getBoard());
            newBoard.setBoard(cpuMove[0], cpuMove[1], -1);

        }
    
        newBoard.drawBoard();
        System.out.println("Game Over!");

    }
}
    
    
