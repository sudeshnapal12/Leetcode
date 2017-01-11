import java.util.HashMap;

public class Revise {
	
	public boolean isPowerOfTwo(int n) {
	    return n>0 && (n&n-1)==0;
	}
	
	public boolean isAnagram(String s, String t){
		if(s.length()!= t.length())
			return false;
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++){
			if(map.containsKey(s.charAt(i))){
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			}else{
				map.put(s.charAt(i), 1);
			}
		}
		
		for(int i=0; i<s.length(); i++){
			if(map.containsKey(t.charAt(i))){
				if(map.get(t.charAt(i))==1)
					map.remove(t.charAt(i));
				else{
					map.put(t.charAt(i), map.get(t.charAt(i))-1);
				}
			}
		}
		
		if(map.size()==0)
			return true;
		else
			return false;
	}
	
	public String reverseString(String s){
		return new StringBuilder(s).reverse().toString();
	}
	
	public static void main(String[] args) {
		Revise r = new Revise();
		System.out.println("Power of two = "+r.isPowerOfTwo(0));
		
		System.out.println("Anagram "+ r.isAnagram("aacc", "acca"));
		
		System.out.println(r.reverseString("hello"));
	}

}
