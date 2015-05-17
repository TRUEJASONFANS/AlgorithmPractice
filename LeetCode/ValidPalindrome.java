package LeetCode;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null)
			return true;
		int i = 0, j = s.length() - 1;
		while (i < j) {
			char c1 = s.charAt(i);
			char c2 = s.charAt(j);
			while (i < s.length() && !alphanumericed(c1 = s.charAt(i))) {
				i++;
			}
			while (j >= 0 && !alphanumericed(c2 = s.charAt(j))) {
				j--;
			}
			if (String.valueOf(c1).equalsIgnoreCase(String.valueOf(c2))) {
				i++;
				j--;
			} 
			else if(i>=j)
				return true;
			else
				return false;
		}
		return true;
	}

	private boolean alphanumericed(char c) {
		if (c >= 'a' && c <= 'z')
			return true;
		if (c >= 'A' && c <= 'Z')
			return true;
		if (c >= '0' && c <= '9')
			return true;
		return false;
	}
}
