package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        Map<String,String> map = new HashMap<String,String>();
        Map<String,String> map2 = new HashMap<String,String>();
        String[] words = str.split(" ");
        if(words.length!=pattern.length()){
            return false;
        }
        for(int i=0;i<pattern.length()&&i<words.length;i++) {
        	String c = pattern.charAt(i)+"";
            if(map.containsKey(c)) {
                if(!map.get(c).equals(words[i])){
                    return false;
                }
            }
            else {
               map.put(c,words[i]);
               if(map2.containsKey(words[i])) {
            	   return false;
               }
               else { 
            	   map2.put(words[i],c);
               }
            }
        }
        return true;
    }

	public static void main(String[] args) {
		boolean flag = new WordPattern().wordPattern("aa","dog do") ;
		if(flag) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
	}

}
