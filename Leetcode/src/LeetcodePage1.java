import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LeetcodePage1 {

	public static int hammingDistance(int x, int y) {
		int ans = x ^ y;
		int count = 0;
		while (ans > 0) {
			if (ans % 2 == 1) {
				count++;
			}
			ans = ans / 2;
		}
		return count;
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			}
		}
		for (int i = 1; i <= nums.length; i++) {
			if (!map.containsKey(i)) {
				list.add(i);
			}
		}
		return list;
	}

	public static List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<>();
		int fizz = 0;
		int buzz = 0;
		for (int i = 1; i <= n; i++) {
			fizz++;
			buzz++;
			if (fizz == 3 && buzz == 5) {
				list.add("FizzBuzz");
				fizz = 0;
				buzz = 0;
			} else if (fizz == 3) {
				list.add("Fizz");
				fizz = 0;
			} else if (buzz == 5) {
				list.add("Buzz");
				buzz = 0;
			} else {
				list.add(String.valueOf(i));
			}
		}
		return list;
	}

	public static char findTheDifference(String s, String t) {
		char res = '\0';
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				int val = (int) map.get(s.charAt(i)) + 1;
				map.put(s.charAt(i), val);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		for (int j = 0; j < t.length(); j++) {
			if (map.containsKey(t.charAt(j))) {
				int val = (int) map.get(t.charAt(j)) - 1;
				map.put(t.charAt(j), val);
				if (val == 0)
					map.remove(t.charAt(j));
			} else {
				return t.charAt(j);
			}
		}
		return res;

	}

	public static int islandPerimeter(int[][] grid) {
		int prev = -1;
		int next = -1;
		int up = -1;
		int down = -1;
		int perimeter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					if (j == 0)
						prev = 0;
					else
						prev = grid[i][j - 1];

					if (i == 0)
						up = 0;
					else
						up = grid[i - 1][j];

					if (i == grid.length - 1)
						down = 0;
					else
						down = grid[i + 1][j];

					if (j == grid[i].length - 1)
						next = 0;
					else
						next = grid[i][j + 1];

					perimeter += 4 - (up + down + next + prev);
				}

			}
		}
		return perimeter;
	}

	public static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int count = 0;
		int j = 0;
		for (int i = 0; i < g.length && j < s.length;) {
			if (g[i] <= s[j]) {
				count++;
				i++;
				j++;
			} else
				j++;
		}
		return count;
	}

	public static void moveZeroes(int[] nums) {
		int numIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				int temp = nums[i];
				nums[i] = nums[numIndex];
				nums[numIndex] = temp;
				numIndex++;
			}
		}
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		int arr[] = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			arr[magazine.charAt(i) - 'a']++;
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			if (--arr[ransomNote.charAt(i) - 'a'] < 0)
				return false;
		}
		return true;
	}

	public static boolean canConstruct2(String ransomNote, String magazine) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < magazine.length(); i++) {
			int val;
			if (map.containsKey(magazine.charAt(i)))
				val = map.get(magazine.charAt(i)) + 1;
			else
				val = 1;
			map.put(magazine.charAt(i), val);
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			if (map.containsKey(ransomNote.charAt(i))) {
				int val = map.get(ransomNote.charAt(i));
				val--;
				if (val < 0)
					return false;
				map.put(ransomNote.charAt(i), val);
			} else
				return false;
		}
		return true;
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

	public static int[] intersection(int[] nums1, int[] nums2) {

		HashSet<Integer> sets = new HashSet<>();
		for (int j = 0; j < nums1.length; j++)
			sets.add(nums1[j]);

		HashSet<Integer> intersect = new HashSet<>();
		for (int i = 0; i < nums2.length; i++) {
			if (sets.contains(nums2[i]))
				intersect.add(nums2[i]);
		}

		int[] res = new int[intersect.size()];
		int i = 0;
		for (int num : intersect) {
			res[i] = num;
			i++;
		}
		return res;
	}

	public static boolean isPowerOfThree(int n) {
		int power = 1;
		int i = 0;
		while (power < n) {
			power = (int) Math.pow(3, i);
			if (power > n || n >= Integer.MAX_VALUE)
				return false;
			else if (power == n)
				return true;

			i++;
		}
		return false;
	}

	public static int firstUniqChar(String s) {
		int count[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			if (count[s.charAt(i) - 'a'] == 1)
				return i;
		}
		return -1;
	}

	public static int titleToNumber(String s) {
		int res = 0;
		int k = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			res += (s.charAt(i) - 'A' + 1) * Math.pow(26, k);
			k++;
		}
		return res;
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int count[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		for (int j = 0; j < t.length(); j++) {
			if (count[t.charAt(j) - 'a'] == 0)
				return false;
			else {
				count[t.charAt(j) - 'a']--;
			}
		}
		return true;
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
		int cnt[] = new int[100];
		char ch = s.charAt(0);
		boolean noteq = false;
		for (int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i) - 'A']++;
			if (ch != s.charAt(i))
				noteq = true;
		}
		if (!noteq)
			return s.length();

		int len = 0;
		int single = 0;
		boolean flag = false;

		for (int i = 0; i < cnt.length; i++) {

			if (cnt[i] > 1) {
				if (cnt[i] % 2 == 0)
					len += cnt[i];
				else {
					len += cnt[i] - 1;
					flag = true;
				}
			}
			if (cnt[i] == 1)
				single++;
		}

		if (single > 0 || flag) {
			return 1 + len;
		} else
			return len;
	}

	public static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.add(nums[i]) == false)
				return true;
		}
		return false;
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			if (map.containsKey(nums1[i]))
				map.put(nums1[i], map.get(nums1[i]) + 1);
			else
				map.put(nums1[i], 1);
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i])) {
				list.add(nums2[i]);
				int val = map.get(nums2[i]) - 1;
				if (val == 0) {
					map.remove(nums2[i]);
				} else {
					map.put(nums2[i], val);
				}
			}
		}
		int ans[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			ans[i] = list.get(i);
		return ans;
	}

	// public List<String> readBinaryWatch(int num) {
	//
	// }

	public static String addStrings(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		int i = num1.length();
		int j = num2.length();
		int min = (len1 < len2) ? len1 : len2;
		int val, carry = 0, rem, prevCarry = 0;
		String res = "";
		while (min > 0) {
			val = prevCarry + (num1.charAt(i - 1) - 48) + (num2.charAt(j - 1) - 48);
			carry = val / 10;
			rem = val % 10;
			res += rem;
			prevCarry = carry;
			i--;
			j--;
			min--;
		}
		while (i > 0) {
			val = prevCarry + (num1.charAt(i - 1) - 48);
			carry = val / 10;
			rem = val % 10;
			res += rem;
			prevCarry = carry;
			i--;
		}
		while (j > 0) {
			val = prevCarry + (num2.charAt(j - 1) - 48);
			carry = val / 10;
			rem = val % 10;
			res += rem;
			prevCarry = carry;
			j--;

		}
		if (carry != 0) {
			res += carry;
		}
		return new StringBuilder(res).reverse().toString();
	}

	public static String toHex(int num) {
		if (num == 0)
			return "0";
		StringBuilder sb = new StringBuilder();
		boolean neg = false;
		if (num < 0) {
			neg = true;
			num = -num;
		}
		while (num > 0) {
			int val = num % 16;
			num = num / 16;
			switch (val) {
			case 10:
				sb.append('a');
				break;
			case 11:
				sb.append('b');
				break;
			case 12:
				sb.append('c');
				break;
			case 13:
				sb.append('d');
				break;
			case 14:
				sb.append('e');
				break;
			case 15:
				sb.append('f');
				break;
			default:
				sb.append(val);
				break;
			}
		}
		int add = 1;
		if (neg) {
			StringBuilder sbNeg = new StringBuilder();
			if (sb.length() != 8) {
				int zero = 8 - sb.length();
				for (int i = 0; i < zero; i++)
					sb.append("0");
			}
			sb.reverse();
			for (int i = 7; i >= 0; i--) {
				int val = 0;
				switch (sb.charAt(i)) {
				case 'a':
					val = 15 - 10 + add;
					break;
				case 'b':
					val = 15 - 11 + add;
					break;
				case 'c':
					val = 15 - 12 + add;
					break;
				case 'd':
					val = 15 - 13 + add;
					break;
				case 'e':
					val = 15 - 14 + add;
					break;
				case 'f':
					val = 15 - 15 + add;
					break;
				default:
					val = 15 - (sb.charAt(i) - '0') + add;
					break;
				}
				add = val / 16;
				val = val % 16;
				switch (val) {
				case 10:
					sbNeg.append('a');
					break;
				case 11:
					sbNeg.append('b');
					break;
				case 12:
					sbNeg.append('c');
					break;
				case 13:
					sbNeg.append('d');
					break;
				case 14:
					sbNeg.append('e');
					break;
				case 15:
					sbNeg.append('f');
					break;
				default:
					sbNeg.append(val);
					break;
				}
			}
			return sbNeg.reverse().toString();
		} else
			return sb.reverse().toString();
	}

	public static int countSegments(String s) {
		if (s == null || s.equals(""))
			return 0;
		else if (s.trim().length() == 0) {
			return 0;
		} else {
			return s.trim().replaceAll(" +", " ").split(" ").length;
		}
	}

	public static boolean repeatedSubstringPattern(String str) {
		if (str.length() == 1 || str.length() == 0 || str == null)
			return false;

		int len = str.length();
		for (int i = len / 2; i >= 1; i--) {
			if (len % i == 0) {
				String substr = "";
				// String substr = new String(new char[len /
				// divisors.get(i)]).replace("\0",
				// str.substring(0, divisors.get(i)));
				for (int j = 0; j < len / i; j++) {
					substr += str.substring(0, i);
					if (!str.substring(0, substr.length()).equals(substr))
						break;
				}
				if (substr.equals(str))
					return true;
			}
		}
		return false;
	}

	public static boolean isPowerOfTwo(int n) {
		for (int i = 0; i < 32; i++) {
			if (n == Math.pow(2, i)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isPowerOfTwo2(int n) {
		while (n != 1) {
			if (n % 2 != 0)
				return false;
			n = n >> 1;
		}
		return true;
	}

	public boolean isPowerOfThree2(int n) {
		for (int i = 0; i < 32; i++) {
			if (n == Math.pow(3, i)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isHappy(int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		while (n != 1) {
			int sum = 0;
			while (n != 0) {
				int digit = n % 10;
				sum += digit * digit;
				n = n / 10;
			}
			if (map.containsKey(sum)) {
				return false;
			} else
				map.put(sum, 1);
			n = sum;
		}
		if (n == 1)
			return true;
		return false;
	}

	public static int climbStairs(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else if (n == 2)
			return 2;
		else {
			int i = 3;
			int steps = 0;
			int bfr = 2;
			int bfrbfr = 1;
			while (n >= i) {
				steps = bfr + bfrbfr;
				bfrbfr = bfr;
				bfr = steps;
				i++;
			}
			return steps;
		}

	}

	public static int hammingWeight(int n) {

		int count = 0;
		while (n != 0) {
			count += (n & 1);
			n = n >>> 1;
		}
		return count;
	}

	// TLE aa gya
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		List<Integer> profit = new ArrayList<>();
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[i] <= prices[j]) {
					profit.add(prices[j] - prices[i]);
				}
			}
		}
		if (profit.isEmpty())
			return 0;
		else
			return Collections.max(profit);
	}

	public static int maxProfit2(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		int max[] = new int[prices.length];
		int min[] = new int[prices.length];
		min[0] = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < min[i - 1]) {
				min[i] = prices[i];
			} else {
				min[i] = min[i - 1];
			}
		}

		max[prices.length - 1] = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			if (prices[i] > max[i + 1]) {
				max[i] = prices[i];
			} else {
				max[i] = prices[i + 1];
			}
		}

		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			int p = max[i] - min[i];
			if (maxProfit < p) {
				maxProfit = p;
			}
		}

		return maxProfit;
	}

	//without extra space and in one pass
	public static int maxProfit3(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		
		int max = 0; 
		int min = Integer.MAX_VALUE;
		for(int i=0; i<prices.length; i++){
			min = Math.min(prices[i], min);
			max = Math.max(max, prices[i]-min);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println("Hamming distance " + hammingDistance(1, 4));
		int nums[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(findDisappearedNumbers(nums));
		System.out.println(fizzBuzz(15));

		int grid[][] = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		System.out.println(islandPerimeter(grid));

		System.out.println(findTheDifference("a", "aa"));

		int g[] = { 1, 2, 3 };
		int s[] = { 3 };
		System.out.println(findContentChildren(g, s));

		int numZeros[] = { 0, 1, 0, 3, 12 };
		moveZeroes(numZeros);
		System.out.println(Arrays.toString(numZeros));

		System.out.println(canConstruct2("a", "b"));

		int nums1[] = { 1, 2, 3 };
		System.out.println("Min number of moves : " + minMoves(nums1));

		System.out.println("Power of three : " + isPowerOfThree(2147483647));

		int[] nums11 = { 1 }, nums22 = { 1 };
		System.out.println("Intersect: " + Arrays.toString(intersection(nums11, nums22)));

		System.out.println(firstUniqChar("loveleetcode"));

		System.out.println("Excel sheet column number " + titleToNumber("AAB"));

		System.out.println("Is anagram: " + isAnagram("car", "rat"));

		int[] numsMajor = { 6, 5, 5 };
		System.out.println("Majority element more than n/2 times : " + majorityElement(numsMajor));

		System.out.println("Longest palindrome " + longestPalindrome("abbabaaa"));

		System.out.println("Contains duplicate array " + containsDuplicate(numsMajor));

		int a[] = { 1, 2, 2, 1 };
		int b[] = { 2, 2 };
		System.out.println("Intersect array2 all elements " + Arrays.toString(intersect(a, b)));

		System.out.println("Add strings : " + addStrings("1", "99999"));

		System.out.println("Convert number to Hex : " + toHex(-2147483648));

		System.out.println("count segments " + countSegments("     "));
		System.out.println("Repeated substring pattern: " + repeatedSubstringPattern("ababac"));

		System.out.println("Power of two : " + isPowerOfTwo2(16));

		System.out.println("Happy number : " + isHappy(19));

		System.out.println("Climb stairs : " + climbStairs(44));
		System.out.println("Hamming weight " + hammingWeight(11));

		int prices[] = { 2,1 };
		System.out.println("Best time to buy and sell stock " + maxProfit3(prices));
	}

}
