package org.HackerRank.NPuzzle.NPuzzle;

import java.util.Hashtable;
import java.util.Scanner;

public class Solution {

	Hashtable<Integer, Integer> heuristicValue;
	Integer[][] goalMap;
	Integer[][] grid;
	int N;

	public Solution(int k) {
		// TODO Auto-generated constructor stub
		heuristicValue = new Hashtable<Integer, Integer>();
		goalMap = new Integer[k][k];
		N = k;
		int count = 0;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				goalMap[i][j] = count++;
			}
		}
	}

	public void setGrid(int k) {
		Scanner in = new Scanner(System.in);
		this.grid = new Integer[k][k];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				grid[i][j] = in.nextInt();
				this.setHeuristicValue(i, j, grid[i][j]);
			}
		}
		in.close();
	}

	public int getHeuristicValue(int key) {
		return this.heuristicValue.get(key);
	}

	public void setHeuristicValue(int row, int col, int cell) {
		int goalRow, goalCol;
		goalRow = 0;
		while (goalRow < N && cell > (goalRow + 1) * N - 1)
			goalRow++;
		goalCol = cell - goalRow * N;
		int value = Math.abs(goalRow - row) + Math.abs(goalCol - col);
		this.heuristicValue.put(cell, value);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		in.close();
		Solution s = new Solution(k);
		s.setGrid(k);

		in.close();
	}

}
