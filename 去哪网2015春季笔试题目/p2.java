import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringNumberDuplicate {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner sc = new Scanner(System.in);
		// while(sc.hasNext()){
		// String s = sc.next();
		// duplicateAccordingNumber(s);
		// }
		String s = "a3ab2c4";
		duplicateAccordingNumber(s);
	}

	private static void duplicateAccordingNumber(String s) {
		// TODO Auto-generated method stub
		Pattern regex = Pattern.compile("([a-zA-Z]+)([1-9]+[0-9]*)");
		Pattern regex2 = Pattern.compile("[1-9]+[0-9]*$");
		Pattern regex3 = Pattern.compile("^[a-zA-Z]+");
		Matcher m = regex.matcher(s);

		StringBuffer sb = new StringBuffer();
		int i = 0;
		boolean result = m.find();
		while (result) {
			String token = m.group(0);
			System.out.println(token);
			Matcher m2 = regex2.matcher(token);
			Matcher m3 = regex3.matcher(token);
			if (m2.find()&&m3.find()) {	
				int time = Integer.valueOf(m2.group(0));
				String tmp = m3.group(0);
				System.out.println(time);
				for(int j=0;j<time;j++) {
					sb.append(tmp);
				}
			}
			result = m.find();
			i++;
		}
		System.out.println(sb);
	}

}
