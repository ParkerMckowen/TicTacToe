public class Minimax
{
    public static class Move
    {
        int moveRow;
        int moveCol;
        
        Move()
        {}
    
        public int getMoveRow()
        {
            return moveRow;
        }
        
        public int getMoveCol()
        {
            return moveCol;
        }
        
    }

    
    public static int[] outputBestMove(int outBoard[][])
    {
        int bestVal = -10000;
        int[] bestMove = new int[2];

        
        for (int i = 0; i < outBoard.length; i++)
        {
            for (int j = 0; j < outBoard[i].length; j++)
            {
                if (outBoard[i][j] == 0)
                {
                    outBoard[i][j] = 1;
                    int testVal = minimax(outBoard, 0, false);
                    outBoard[i][j] = 0;
                    
                    if (testVal > bestVal)
                    {
                        bestMove[0] = i;
                        bestMove[1] = j;
                        bestVal = testVal;
                    }
                }
            }
        }
        
        return bestMove;
    }
    
    //  - Returns +1 if 'O' is in a win state
    //  - Returns 0 if the neither 'x' or 'O' has won
    //  - Returns -1 if 'O' has lost
    public static int minimax(int board[][], int depth, boolean isMaximizing)
    {
        int score = scanBoard(board);
        
        if (score == 1)
        {
            return score;
        }
        
        else if (score == -1)
        {
            return -score;
        }
        
        else if (gameOver(board))
        {
            return 0;
        }
        
        
        if (isMaximizing)
        {
            int value = -10000;
    
            for (int i = 0; i < board.length; i++)
            {
                for (int j = 0; j < board.length; j++)
                {
                    if (board[i][j] == 0)
                    {
                        board[i][j] = -1;
                        value = Math.max(value, minimax(board, depth + 1, false));
                        board[i][j] = 0;
                    }
                }
            }
            
            return value;
        }
        
        else // Minimizing
        {
            int value = 10000;
    
            for (int i = 0; i < board.length; i++)
            {
                for (int j = 0; j < board.length; j++)
                {
                    if (board[i][j] == 0)
                    {
                        board[i][j] = 1;
                        value = Math.min(value, minimax(board, depth + 1, true));
                        board[i][j] = 1;
                    }
                }
            }
            
            return value;
            
        }
        

    }
    
    public static int scanBoard(int[][] board)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j] == 1 || board[i][j] == -1 ) //logic for if all values in a row are 'X'
                {
                    if (board[i][0] == 1)
                    {
                        return +1;
                    }
                    else if (board[i][0] == -1)
                    {
                        return -1;
                    }
                }
            }
        }
    
        // This for loop tests for the Horizontal win condition
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[j][i] == 1 || board[j][i] == -1 ) //logic for if all values in a row are 'X'
                {
                    if (board[0][j] == 1)
                    {
                        return +1;
                    }
                    else if (board[0][j] == -1)
                    {
                        return -1;
                    }
                }
            }
        }
    
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != 0)
        {
            if (board[1][1] == 1)
            {
                return +1;
            }
            else if (board[1][1] == -1)
            {
                return -1;
            }
        }
    
        if (board[2][2] == board[1][1] && board[1][1] == board[0][2] && board[1][1] != 0)
        {
            if (board[1][1] == 1)
            {
                return +1;
            }
            else if (board[1][1] == -1)
            {
                return -1;
            }
        }
        
        return 0;
    }
    
    
    
    public static boolean gameOver(int[][] board)
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
    
    
}
