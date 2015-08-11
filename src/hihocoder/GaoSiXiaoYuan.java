package hihocoder;

import java.util.Scanner;

public class GaoSiXiaoYuan {
	static int n;
	static int m;
	static double[][] a;
	static double[] b;
	static double[] value;

	public static void main(String[] args) {
		a = new double[501][1002];
		b = new double[1002];
		value = new double[1002];
		final Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			n = sc.nextInt();
			m = sc.nextInt();
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = sc.nextInt();
				}
				b[i] = sc.nextInt();
			}
			doGaoXiXiaoYuan();
		}
		sc.close();
	}

	private static void doGaoXiXiaoYuan() {
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			if(a[i][i]==0) {
				flag = false;
				for(int j = i+1;j<m;j++) {
					if(a[j][i]!=0) {
						swap(j,i);
						flag = true;
					}
				}
				if(!flag) {
					printResult(1);
					return;
				}
			}
			for (int j = i + 1; j < m; j++) { // 删除掉i+1行起第i列元素
				final double coff = a[j][i] / a[i][i];
				for (int k = 0; k < n ; k++) {
					a[j][k] = a[j][k] - a[i][k]*coff;
				}
				b[j] -= b[i] * coff;
			}
		}
		for (int i = 0; i < m; i++) {
			flag = false;
			for (int j = 0; j < n; j++) {
				if (a[i][j] != 0) {
					flag = true;
					break;
				}
			}
			if (!flag && b[i] != 0) {
				printResult(2);
				return;
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				b[i] -= a[i][j] * value[j];
			}
			value[i] = b[i] / a[i][i];
		}	 	
		for (int i = 0; i < n; i++) {
			System.out.printf("%d\n", (int)(value[i]+0.5));
		}

	}

	private static void printResult(int i) {
		switch (i) {
		case 1:
			System.out.println("Many solutions");
			break;
		case 2:
			System.out.println("No solutions");

		}
	}

	private static void swap(int row1, int row2) {
		if(row1==row2) {
			return;
		}
		double tmp;
		for (int i = 0; i < n; i++) {
			tmp = a[row1][i];
			a[row1][i] = a[row2][i];
			a[row2][i] = tmp;
		}
	}

}
