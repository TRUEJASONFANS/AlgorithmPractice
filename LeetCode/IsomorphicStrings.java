package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
    	 if(s==null&&t==null)
    		 return true;
    	 else if(s==null||t==null) 
    		 return false;
    	 else {
	    	 Map<Character,Character>  map = new HashMap<Character,Character> (); 
	    	 for(int i=0;i<s.length();i++) {
	    		 Character c1 = s.charAt(i);
	    		 Character c2 = t.charAt(i);
	    		 if(map.containsKey(c1)) {
	    			 if(map.get(c1)!=c2) {
	    				 return false;
	    			 }
	    		 }
	    		 else if(map.containsValue(c2))
	    			 return false;
	    		 else {
	    			 map.put(c1, c2);
	    		 }
	    	 }
	    	 return true;
    	}
    }

}

