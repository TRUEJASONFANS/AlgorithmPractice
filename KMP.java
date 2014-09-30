import java.util.Scanner;

public class KMP {
	public String str;
	public String pattern;

	public static void getNext(String pattern, int[] next) {
		char[] p = pattern.toCharArray();
		next[0] = -1;
		int k = -1;
		int j = 0;
		int len = p.length - 1;
		while (j <= len - 1) {
			if (k == -1 || p[k] == p[j]) {//如果为第一个元素，则很明显next[1] = 0;否则如果前缀等于后缀(p0--pk equal to pj-k--pj，
				k++;
				j++;
				next[j] = k;
			} else {
				k = next[k];//如果p[k]!=p[j],则寻找更小的最大公共长度，k = next[k];因为p0--p(next[k]) equal to pj-next[k]--pj-1
			}
		}
	}

	public static int KmpMatch(String str1, String pattern) {
		int[] next = new int[pattern.length()];
		char[] s = str1.toCharArray();
		char[] p = pattern.toCharArray();
		getNext(pattern, next);
		int i = 0, j = 0, matchSum = 0;
		while (i < s.length) {
			if (j == -1 || s[i] == p[j]) {
				i++;
				j++;
				if (j == p.length) {//如果匹配模式串完成
					matchSum++;
					j = 0;
				}
			} else {
				j = next[j];
			}
		}
		return matchSum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n-- > 0) {
			String str1 = sc.nextLine();
			String str2 = sc.nextLine();
			System.out.println("result:" + KmpMatch(str2, str1));
		}
		
		sc.close();
	}
}
