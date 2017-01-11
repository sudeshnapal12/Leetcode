import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

public class LeetcodeRevise {
	public static int hammingDistance2(int x, int y) {
		int xor = x ^ y;
		int count = 0;
		while (xor > 0) {
			count += xor & 1;
			xor = xor >> 1;
		}
		return count;
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]) - 1;
			if (nums[val] > 0) {
				nums[val] = -nums[val];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				list.add(i + 1);
			}
		}
		return list;

	}

	public static String reverseString(String s) {
		char chr[] = s.toCharArray();
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			char tmp = chr[i];
			chr[i] = chr[j];
			chr[j] = tmp;
			i++;
			j--;
		}
		return new String(chr);
	}

	public static String reverseString2(String s) {
		byte chr[] = s.getBytes();
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			byte tmp = chr[i];
			chr[i] = chr[j];
			chr[j] = tmp;
			i++;
			j--;
		}
		return new String(chr);
	}

	public static String reverseString3(String s) {
		char chr[] = s.toCharArray();
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			chr[i] = (char) (chr[i] ^ chr[j]);
			chr[j] = (char) (chr[i] ^ chr[j]);
			chr[i] = (char) (chr[i] ^ chr[j]);
			i++;
			j--;
		}
		return new String(chr);
	}

	public static char findTheDifference(String s, String t) {
		char ch = 0;
		for (int i = 0; i < s.length(); i++) {
			ch = (char) (ch ^ s.charAt(i));
		}
		for (int j = 0; j < t.length(); j++) {
			ch = (char) (ch ^ t.charAt(j));
		}
		return ch;
	}

	public static char findTheDifference2(String s, String t) {
		int sCode = 0;
		int tCode = 0;
		for (int i = 0; i < s.length(); i++) {
			sCode += s.charAt(i);
		}
		for (int j = 0; j < t.length(); j++) {
			tCode += t.charAt(j);
		}
		return (char) (tCode - sCode);
	}

	public static int minMoves(int[] nums) {
		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (min > nums[i])
				min = nums[i];
		}
		int moves = 0;
		for (int i = 0; i < nums.length; i++) {
			moves += nums[i] - min;
		}
		return moves;

	}

	public static int majorityElement(int[] nums) {
		// Arrays.sort(nums);
		// return nums[nums.length/2];

		int count = 1;
		int major = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				count++;
				major = nums[i];
			} else if (nums[i] == major) {
				count++;
			} else {
				count--;
			}
		}
		return major;
	}

	public static int longestPalindrome(String s) {
		List<Character> list = new ArrayList<>();
		int evenPairsCnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (list.contains(s.charAt(i))) {
				evenPairsCnt++;
				list.remove(Character.valueOf(s.charAt(i)));
			} else {
				list.add(s.charAt(i));
			}
		}
		if (list.size() > 0)
			return 2 * evenPairsCnt + 1;
		else
			return 2 * evenPairsCnt;
	}

	public static List<String> readBinaryWatch(int num) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 60; j++) {
				if (Integer.bitCount(i | j << 4) == num)
					// if(Integer.bitCount(i+j*16) == num)
					// if(Integer.bitCount(i*64+j)==num)
					// if(Integer.bitCount(i<<6 | j) == num)
					// if(Integer.bitCount(i)+Integer.bitCount(j)==num)
					list.add(String.format("%d:%02d", i, j));
			}
		}
		return list;
	}
	
	public static int digitSum(int n){
		int sum = 0;
		while(n!=0){
			int tmp = n%10;
			sum = sum+ tmp*tmp;
			n = n/10;
		}
		return sum;
	}
	 public static boolean isHappy(int n) {
		 int fast = n, slow = n;
		 do{
			 slow = digitSum(slow);
			 fast = digitSum(fast);
			 fast = digitSum(fast);
		 }while(fast!=slow);
		 if(slow==1)
			 return true;
		 return false;
	 }

	public static int numberOfBoomerangs(int[][] points) {
		int res = 0;
		for (int i = 0; i < points.length; i++) {
			HashMap<Double, Integer> map = new HashMap<>();
			for (int j = 0; j < points.length; j++) {
				int x = points[i][0];
				int y = points[i][1];
				int x1 = points[j][0];
				int y1 = points[j][1];
				double dist = (x - x1) *(x - x1) + (y - y1) * (y - y1);
				if (map.containsKey(dist)) {
					int val = map.get(dist)+1;
					map.put(dist, val);
				} else {
					map.put(dist, 1);
				}
			}
			for(int val : map.values()){
				res += val *(val-1);
			}
		}
		return res;
	}
	
	public static boolean isValidSudoku(char[][] board) {
		
		for(int i=0; i<board.length; i++){
			HashSet<Character> row = new HashSet<>();
			HashSet<Character> col = new HashSet<>();
			HashSet<Character> cube = new HashSet<>();
			for(int j=0; j<board[i].length; j++){
				if(board[i][j]!='.' && row.add(board[i][j])==false){
					return false;
				}				
				if(board[j][i]!='.' && col.add(board[j][i])==false){
					return false;
				}
				//Actual stuff is here... calculating row and col index in cube
				int rowIndex = 3*(i%3) + j/3;
				int colIndex = 3*(i/3) + j%3;
				if(board[rowIndex][colIndex]!='.' && cube.add(board[rowIndex][colIndex])==false){
					return false;
				}
			}		
		}
		return true;
	}
	public static int arrangeCoins(int n) {
		return (int)(-1 + Math.sqrt(1+(long)n*8))/2;
	}
	
	public static int thirdMax(int[] nums) {
		TreeSet<Integer> set = new TreeSet<>();
		for(int num: nums){
			set.add(num);
			if(set.size()>3){
				set.pollFirst();
			}
		}
		return set.size()<3 ? set.last(): set.first();
	}

	public static void main(String[] args) {
		System.out.println(hammingDistance2(1, 4));
		int nums[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(findDisappearedNumbers(nums));
		System.out.println(reverseString("helle"));
		System.out.println(reverseString2("helle"));
		System.out.println(reverseString3("helle"));
		System.out.println(findTheDifference("a", "aa"));
		System.out.println(findTheDifference2("a", "aa"));

		int nums1[] = { 1, 2, 3 };
		System.out.println("Min number of moves x	" + minMoves(nums1));

		int[] numsMajor = { 6, 5, 5 };
		System.out.println("Majority element more than n/2 times : " + majorityElement(numsMajor));

		System.out.println("Longest palindrome (possible with given characters in string)" + longestPalindrome("abbabaaa"));

		System.out.println("Binary watch : " + readBinaryWatch(1));
		
		System.out.println("Happy number using cycle : "+ isHappy(7) );

//		int[][] points = { { 0, 0 }, { 1, 0 }, { 2, 0 } };
		int[][] points = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
		System.out.println("Bloomerang : " + numberOfBoomerangs(points));
		
		char[][] board = new char[][]{
			{'.','.','4','.','.','.','6','3','.'},
			{'.','.','.','.','.','.','.','.','.'},
			{'5','.','.','.','.','.','.','9','.'},
			{'.','.','.','5','6','.','.','.','.'},
			{'4','3','.','.','.','.','.','.','1'},
			{'.','.','.','7','.','.','.','.','.'},
			{'.','.','.','4','.','.','.','.','.'},
			{'.','.','.','.','.','.','.','.','.'},
			{'.','.','.','.','.','.','.','.','.'}};
	System.out.println("Valid soduku "+ isValidSudoku(board));
	
	System.out.println("Arrange coins " + arrangeCoins(5));
	
	int nums3max[] = {2,2,3,1};
	System.out.println("Third Maximum number " + thirdMax(nums3max));

	}
}
