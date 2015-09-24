package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SurroundedRegions {
	private static final int LENGTH = 4;

	public void solve(char[][] board) {
		solve(board,'X','O');
	}
	private  void solve(char[][] board,char x ,char o) {
		if (board == null || board.length == 0 ) {
			return;
		}
		int m = board.length;
		int n = board[0].length;
		boolean v[][] = new boolean[m][n];
		
		//遍历四周即可
		for (int i = 0; i < m; i++) {
			if (board[i][0] == o && !v[i][0]) {
				int index = i * n + 0;
				bfsSearch(index, board, v, o);
			}
			if (board[i][n - 1] == o && !v[i][n - 1]) {
				int index = i * n + n - 1;
				bfsSearch(index, board, v, o);
			}
		}
		for (int j = 0; j < n; j++) {
			if (board[0][j] == o && !v[0][j]) {
				int index = j;
				bfsSearch(index, board, v, o);
			}
			if (board[m - 1][j] == o && !v[m - 1][j]) {
				int index = (m - 1) * n + j;
				bfsSearch(index, board, v, o);
			}
		}
		for (int i = 1; i < m - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (!v[i][j]) {
					board[i][j] = x;
				}
			}
		}
	
	}
	/**
	 * bfsSeach 如果index所属集合可以走出去不修改，否则修改
	 * @param index
	 * @param queue
	 * @param board
	 * @param v
	 * @param o 
	 */
	private void bfsSearch(int index, char[][] board,boolean[][] v, char o) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(index);
		int m = board.length, n = board[0].length;
		v[index/n][index%n] = true;
		int dir[][] = new int[][] {{0,-1},{0,1},{1,0},{-1,0}};
		while (!queue.isEmpty()) {
			int top = queue.poll();
			int x = top / n;
			int y = top % n;
			for (int i = 0; i < LENGTH; i++) {
				int nextX = x + dir[i][0];
				int nextY = y + dir[i][1];
				if(nextX >=0 && nextX < m && nextY >= 0 && nextY < n) {
					if (board[nextX][nextY] == o && !v[nextX][nextY]) {
						queue.add(nextX*n+nextY);
						v[nextX][nextY] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
	  Scanner scanner = new Scanner(System.in);
	  int length = 4;
	  int n = 6;
      char[][] ch= new char[length][];
      for(int i = 0 ; i < length;i++) {
    	  ch[i] = new char[n];
    	  String s = scanner.nextLine();
    	  int j = 0;
			for (char c : s.toCharArray()) {
				if (c != ' ') {
					ch[i][j] = c;
					j++;
				}
			}
      }
      new SurroundedRegions().solve(ch);
      System.out.println();
		for(int i=0;i<length;i++) {
			for(int j=0;j< n;j++) {
				System.out.print(ch[i][j]);
			}
			System.out.println();
		}

      scanner.close();
	}

}
