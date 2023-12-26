import java.util.Scanner;

class Peg {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] board = makeBoard();
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] != 1) continue; //not a .
                    if((j+2) >= 7 && (i+2) >= 7) continue; //off board - bottom right
                    if((j-2) <= 0 && (i+2) >= 7) continue; //off board - bottom left
                    if((j+2) >= 7 && (i-2) <= 0) continue; //off board - top right
                    if((j-2) <= 0 && (i-2) <= 0) continue; //off board - top left
                    if((j-2) <= 0) continue; //off board - left
                    if((i+2) >= 7) continue; //off board - down
                    if((i-2) <= 0) continue; //off board - up
                    
                    if(board[i][j+1] == 0 && board[i][j+2] == 0) count++;
                    if(board[i][j-1] == 0 && board[i][j-2] == 0) count++;
                    if(board[i+1][j] == 0 && board[i+2][j] == 0) count++;
                    if(board[i-1][j] == 0 && board[i-2][j] == 0) count++;
            }
        }
        System.out.println(count);
        
    }


    private static int[][] makeBoard() {
        int[][] board = new int[7][7];
        board[0][0] = -1; board[0][1] = -1; board[0][5] = -1; board[0][6] = -1;
        board[1][0] = -1; board[1][1] = -1; board[1][5] = -1; board[1][6] = -1; 
        board[5][0] = -1; board[5][1] = -1; board[5][5] = -1; board[5][6] = -1;
        board[6][0] = -1; board[6][1] = -1; board[6][5] = -1; board[6][6] = -1;
        for (int i = 0; i < board.length; i++) {
            String line = sc.nextLine().trim();
            int j;
            if(i == 0 || i == 1 || i == 5 || i == 6){
                for(j = 2; j<5; j++){
                    char temp = line.charAt(j-2);
                    if(line.charAt(j-2) == 'o') board[i][j] = 0;
                    else board[i][j] = 1;
                }
            }
            else{
                for(j = 0; j<7; j++){
                    if(line.charAt(j) == 'o') board[i][j] = 0;
                    else board[i][j] = 1;
                }
            }
        }
        return board;
    }

}