import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Getting the input
    System.out.print("Enter the size Of the Board : ");
    int n = sc.nextInt();
    int row = n;
    int col = n;
    if(n > 5 || n < 3 ){
      System.out.println("Invalid Size. Please Enter the valid Size");
    }
    else{
      char[][] board = new char[row][col];
      for(int i = 0; i<row; i++){
        for(int j = 0; j<col; j++){
          board[i][j] = ' ';
        }
      }
      char player = 'X';
      boolean isWon = false;
      int count = 0;
      while(!isWon){
        if(count >= (row*col)){
          printboard(board);
          System.out.println("Oops!! Match Tied");
          break;
        }
        printboard(board);
        System.out.print("Player "  + player + " enter : " );
        int r = sc.nextInt();
        int c = sc.nextInt();
        if(board[r][c] == ' '){
          board[r][c] = player;
          if(count >= row){
            isWon = haveWon(board, r, c, player);
          }
          if(isWon){
            printboard(board);
            System.out.println("Woohoo!! Player " + player + " has Won" );
          }
          else{
            player = player == 'X' ?'O' : 'X';
          }
        }
        else{
          System.out.println("Invalid Move. Enter Again..!!");
        }
        count++;
      }

    }
  }

  //Printing the Board
  public static void printboard(char[][] board){
    int row = board.length;
    int col = board[0].length;
    for(int i = 0; i<row; i++){
      for(int j = 0; j<col; j++){
        System.out.print(board[i][j] + " | ");
      }
      System.out.println();
    }
  }

  //Checking for the winner
  public static boolean haveWon(char[][] board, int row, int col, char player){
    int n = board.length;
    //Checking Rows
    boolean flag = true;
    for(int i = 0; i<n; i++){
      if(board[row][i] != player){
        flag = false;
        break;
      }
    }
    if(flag) return true;

    //Checking Columns
    flag = true;
    for(int i = 0; i<n; i++){
      if(board[i][col] != player){
        flag = false;
        break;
      }
    }
    if(flag) return true;

    //Checking Primary diagonal
    flag = true;
    for(int i = 0; i<n; i++){
      if(board[i][i] != player){
        flag = false;
        break;
      }
    }
    if(flag) return true;

    //Checking Secondary diagonal
    flag = true;
    int temp = n-1;
    for(int i = 0; i<n; i++){
      if(board[i][temp--] != player){
        flag = false;
        break;
      }
    }
    if(flag) return true;

    return false;
  }



}