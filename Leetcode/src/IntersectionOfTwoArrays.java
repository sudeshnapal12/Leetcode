import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfTwoArrays {
	/*
	 * Given two arrays, write a function to compute their intersection.
	 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
	 * 
	 * Note: Each element in the result must be unique. The result can be in any
	 * order.
	 */
	
	//M1- HashSet
	//T(n) = O(n)
	public static int[] intersection(int a[], int b[]){
		HashSet<Integer> set1 = new HashSet<Integer>();
		for(int i:a){
			set1.add(i);
		}
		
		HashSet<Integer> set2 = new HashSet<Integer>();
		for(int i:b){
			if(set1.contains(i))
			set2.add(i);
		}
		
		int result[] = new int[set2.size()];
		int k = 0;
		for(int i : set2){
			result[k] = i;
			k++;
		}
		
		return result;
	}
	
	//M2 
	//T(n) = O(m+n)+sortig complexity
	public static Object[] intersection(int a[], int b[], int m, int n){
		List<Integer> result = new ArrayList<Integer>();
		Arrays.sort(a);
		Arrays.sort(b);
		int i=0, j=0;
		while(i<m && j<n){
			if(a[i]<b[j]){
				i++;
			}else if(b[j]<a[i]){
				j++;
			}else { //both elements are equal
				if(result.isEmpty() || a[i]!=result.get(result.size()-1))
					result.add(a[i]);
				i++;
				j++;
				
			}
		}
		return result.toArray();
	}
	
	public static void main(String[] args) {
		int[] arr1 = {2,3,5,1,55,2,6,1,43,5,7,67,8,3};
		int[] arr2 = {2,4,6,2,2,7,8,9,3,2,3,4,6,8,9,0};
		System.out.println(Arrays.toString(IntersectionOfTwoArrays.
				intersection(arr1, arr2)));
		System.out.println(Arrays.toString(
				IntersectionOfTwoArrays.
				intersection(arr1, arr2, arr1.length, arr2.length)));
	}
}
