import java.util.HashSet;
import java.util.Iterator;

public class SingleNumber {
	/*
	 * Given an array of integers, 
	 * every element appears twice except for one. Find that single one.
	 */
	
	//M1
	public static int singleNumber(int[] A){
		int x = 0;
		for(int a : A){
			x = x ^ a;
		}
		return x;
	}
	
	//M2
	public static int singleNumber1(int[] A){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int a : A){
			if(!set.add(a)){
				set.remove(a);
			}
		}
		Iterator<Integer> i = set.iterator();
		return i.next();
	}
	
	public static void main(String[] args) {
		int A[] = {1,2,4,3,3,2,5,6,1,6,5};
		System.out.println(SingleNumber.singleNumber(A));
		System.out.println(SingleNumber.singleNumber1(A));
	}

}
