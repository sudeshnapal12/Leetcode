import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Easy {

	public boolean containsDuplicate(int[] arr) {
		HashSet<Integer> h = new HashSet<Integer>();
		for (int i : arr) {
			h.add(i);
		}
		if (arr.length > h.size())
			return true;
		else
			return false;
	}

	public int firstUniqChar(String s) {
		if (s.length() == 0)
			return -1;
		else if (s.length() == 1)
			return 0;
		else {
			for (int i = 0; i < s.length();) {
				// System.out.println(String.valueOf(s.charAt(i)));
				// System.out.println(s.substring(i+1));
				String sub = s.substring(0, i) + s.substring(i + 1);
				if (sub.contains(String.valueOf(s.charAt(i)))) {
					i++;
				} else {
					if (i == s.length())
						return -1;

					return i;
				}
			}
			return -1;
		}

	}

	public int firstUniqChar1(String s) {
		if (s.length() == 0)
			return -1;
		else if (s.length() == 1)
			return 0;
		else {
			int hash[] = new int[200];
			for (int i = 0; i < s.length(); i++) {
				hash[(s.charAt(i))]++;
			}
			for (int i = 0; i < s.length(); i++) {
				if (hash[(s.charAt(i))] == 1)
					return i;
			}
			return -1;
		}
	}

	public boolean isPowerOfTwo(int n) {
		if (n == 0)
			return false;
		if (n == 1)
			return true;

		int k = -1;
		for (int i = 1; n >= Math.pow(2, i); i++) {
			k = (n % (int) Math.pow(2, i));
			if (k != 0)
				return false;
		}
		if (k == 0)
			return true;
		else
			return false;

	}

	public boolean isAnagram(String s, String t) {
		if (t.length() != s.length())
			return false;

		int arr[] = new int[256];
		int arr1[] = new int[256];
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i)]++;
		}
		for (int i = 0; i < t.length(); i++) {
			arr1[t.charAt(i)]++;
		}
		if (Arrays.equals(arr, arr1))
			return true;
		else
			return false;
	}

	public static int max(LinkedList<Integer> c) {
		int max = c.get(0);
		for (int i = 0; i < c.size(); i++) {
			if (max < c.get(i)) {
				max = c.get(i);
			}
		}
		return max;
	}

	public String removeKdigits(String num, int k) {
		LinkedList<Integer> ans = new LinkedList<Integer>();
		boolean flag = false; // 1st time take k next time take k-1
		for (int i = 0; i < num.length(); i++) {
			ans.add(Character.getNumericValue(num.charAt(i)));
		}
		int removed = 0;
		for (int n = 0; n <= num.length() - k && removed < k; n++) {
			LinkedList<Integer> temp = new LinkedList<Integer>();
			int adding = flag ? k - 1 : k;
			for (int i = 0; i < adding; i++) {
				temp.add(ans.get(n + i));
			}
			flag = true;
			int max = max(temp);
			ans.remove(Integer.valueOf(max));
			removed++;
		}

		String ansStr = "";
		for (int i = 0; i < ans.size(); i++) {
			ansStr += ans.get(i);
		}
		int x = 0;
		if (ansStr != "")
			x = Integer.parseInt(ansStr);
		return String.valueOf(x);

	}

	public String removeKDigits1(String num, int k) {
		if (k == 0) {
			int x = 0;
			if (num != "")
				x = Integer.parseInt(num);
			return String.valueOf(x);
		} else {
			LinkedList<Integer> ans = new LinkedList<Integer>();
			for (int i = 0; i < num.length(); i++) {
				ans.add(Character.getNumericValue(num.charAt(i)));
			}

			LinkedList<Integer> temp = new LinkedList<Integer>();
			for (int i = 0; i < k; i++) {
				temp.add(ans.get(i));
			}
			int max = max(temp);
			ans.remove(Integer.valueOf(max));

			String ansStr = "";
			for (int i = 0; i < ans.size(); i++) {
				ansStr += ans.get(i);
			}
			return removeKDigits1(ansStr, k - 1);
		}
	}

	// Remove duplicates from sorted list
	public ListNode deleteDuplicates(ListNode head) {
		ListNode copy = head;
		ListNode next = null;
		if (head == null || head.next == null)
			return head;
		while (head != null && head.next != null) {
			next = head.next;
			if (head.val == next.val) {
				head.next = next.next;
				next = null;
			} else {
				head = head.next;
			}

		}
		return copy;
	}

	public void moveZeroes(int[] nums) {
		int noOfZeros = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				noOfZeros++;
			} else {
				int temp = nums[i - noOfZeros];
				nums[i - noOfZeros] = nums[i];
				nums[i] = temp;
			}
		}
		System.out.println("move zeros " + nums);
	}

	public boolean isPowerOfFour(int num) {

		for (int i = 0; i < 32; i++) {
			if (Math.pow(4, i) == num)
				return true;
		}
		return false;
	}

	int[][] fractalmatrix() {
		int n = 8;
		int res[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				res[i][j] = (((n - i - 1) & (n - j - 1)) == 0) ? 1 : 0;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
		return res;
	}

	public String reverseVowels(String s) {
		String v = "";
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0, j = s.length() - 1; i < s.length() && j >= 0;) {
			while (!(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I'
					|| s.charAt(i) == 'O' || s.charAt(i) == 'U') && j > 0) {
				j--;
			}
			char y = s.charAt(j);
			while (!(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I'
					|| s.charAt(i) == 'O' || s.charAt(i) == 'U') && i < s.length()) {
				i++;
			}
			sb.setCharAt(i, y);
		}

		return sb.toString();
	}

	public int titleToNumber(String s) {
		int y = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			int x = Integer.valueOf(s.charAt(i)) - 64;
			x = (int) ((x) * Math.pow(26, (s.length() - 1 - i)));
			y = y + x;
		}
		y += Integer.valueOf(s.charAt(s.length() - 1)) - 64;
		return y;

	}

	public String countAndSay1(int n) {
		if (n == 1)
			return "1";

		String output = "";
		String input = "1";
		for (int k = 0; k < n; k++) {
			int count = 1;
			for (int i = 1; i < input.length(); i++) {
				if (input.charAt(i) == input.charAt(i - 1)) {
					count++;
				} else {
					output = output + count + input.charAt(i - 1);
					count = 1;
				}
			}
			output = output + count + input.charAt(input.length() - 1);
			count = 1;
			input = output;
			output = "";
		}
		return input;

	}

	public boolean isPalindrome(int x) {
		String s = String.valueOf(x);
		if (s.charAt(0) == '-')
			s = s.substring(1);
		int end = s.length() - 1;
		for (int i = 0; i < s.length() / 2;) {

			if (s.charAt(i) == s.charAt(end)) {
				i++;
				end--;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isPalindrome_noSpace(int x) {
		// single digit
		if (x / 10 == 0)
			return true;
		if (x < 0)
			return false;

		int digits = 0;
		int num = x;
		while (num != 0) {
			digits++;
			num /= 10;
		}
		while (x != 0) {
			int end = x % 10;
			int start = x / (int) (Math.pow(10, digits - 1));

			if (start != end)
				return false;
			x = (int) (x % Math.pow(10, digits - 1));
			x = x / 10;
			digits = digits - 2;
		}
		return true;
	}

	public int hammingWeights(long n) {

		int wt = 0;
		while (n != 0) {
			long digit = n % 2;
			n = n / 2;
			if (digit == 1)
				wt++;
		}
		return wt;

	}

	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int count = 0;
		for (int i = 1; i < 33; i++) {
			if (getBit(n, i) == true) {
				count++;
			}
		}
		return count;
	}

	public boolean getBit(int n, int i) {
		return (n & (1 << i)) != 0;
	}

	public int trailingZeroes(int n) {
		if (n == 0)
			return 0;
		int count = 0;
		int p = 5;
		int orig = n;
		while (p <= n) {
			count += n / p;
			p *= 5;
			n = orig;
		}
		return count;
	}

	public int thirdMax(int[] nums) {
		int max = Integer.MIN_VALUE;
		int secMax = Integer.MIN_VALUE;
		int thirdMax = Integer.MIN_VALUE;
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		if (nums.length == 1)
			return nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				thirdMax = secMax;
				secMax = max;
				max = nums[i];
			} else if (nums[i] != max && nums[i] > secMax) {
				thirdMax = secMax;
				secMax = nums[i];
			} else if (nums[i] != secMax && nums[i] != max && nums[i] > thirdMax) {
				thirdMax = nums[i];
			}
		}
		return thirdMax;

	}

	public boolean canConstruct(String ransomNote, String magazine) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int m = 0; m < magazine.length(); m++) {
			int count = 0;
			if (map.containsKey(magazine.charAt(m)))
				count = map.get(magazine.charAt(m));

			map.put(magazine.charAt(m), ++count);
		}
		for (int r = 0; r < ransomNote.length(); r++) {
			int count = 0;
			if (map.containsKey(ransomNote.charAt(r)))
				count = map.get(ransomNote.charAt(r));
			else
				return false;
			map.put(ransomNote.charAt(r), --count);
			if (count == 0)
				map.remove(ransomNote.charAt(r));
		}
		return true;
	}

	public boolean canConstruct1(String ransomNote, String magazine) {
		if (ransomNote.equals(magazine))
			return true;
		if (ransomNote == null)
			return true;
		int j = 0;
		for (int i = 0; i < magazine.length(); i++) {
			int k = i;
			while (j < ransomNote.length() && k < magazine.length()) {
				if (ransomNote.charAt(j) == magazine.charAt(k)) {
					k++;
					j++;
				} else {
					break;
				}
			}
			if (j == ransomNote.length())
				return true;

		}
		return false;
	}

	public int rob(int[] nums) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < nums.length; i++)
			if (map.get(nums[i]) == null) {
				map.put(nums[i], new ArrayList<Integer>(i));
			} else {
				ArrayList<Integer> z = map.get(nums[i]);
				z.add(i);
				map.put(nums[i], z);
			}

		Arrays.sort(nums);
		int sum = 0;
		boolean[] b = new boolean[nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {
			sum += nums[i];
			b[map.get(nums[i]).get(0)] = true;
		}
		System.out.println(nums.toString());
		return 0;
	}

	public int hammingDistance(int x, int y) {
		String a = "";
		String b = "";
		while(x>0){
			a += x%2;
			x = x/2;
		}
		while(y>0){
			b += y%2;
			y = y/2;
		}
//		a = a+x;
//		b = b+y;
		int j=0;
		a = new StringBuilder(a).reverse().toString();
		b = new StringBuilder(b).reverse().toString();
		for(int i=0; i<a.length() && i<b.length(); i++){
			if(a.charAt(i) != b.charAt(i)){
				j++;
			}				
		}
		if(a.length() > b.length())
			j += a.length() - b.length();
		else
			j += b.length() - a.length();
		return j;
	}

	public static void main(String[] args) {
		Easy e = new Easy();

		
		int arr[] = { 1 };
		System.out.println(e.containsDuplicate(arr));

		String s = "loveleetcode";
		System.out.println(e.firstUniqChar1(s));

		System.out.println("Power of two = " + e.isPowerOfTwo(0));

		System.out.println("Anagram " + e.isAnagram("aacc", "acca"));

		System.out.println("Remove k digits " + e.removeKDigits1("43214321", 4));

		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next = new ListNode(2);
		System.out.println(e.deleteDuplicates(node));

		int nums[] = { 0, 1, 0, 3, 12 };
		e.moveZeroes(nums);
		System.out.println(e.isPowerOfFour(4));

		e.titleToNumber("BA");
		e.countAndSay1(3);
		System.out.println(e.isPalindrome(12321));
		System.out.println(e.isPalindrome_noSpace(12321));
		e.hammingWeights(2147483648L);
		System.out.println(e.trailingZeroes(25));
		System.out.println("hello" + e.canConstruct("bjaajgea",
				"affhiiicabhbdchbidghccijjbfjfhjeddgggbajhidhjchiedhdibgeaecffbbbefiabjdhggihccec"));
		// e.rob(nums);

		e.fractalmatrix();

		String str = "hello";
		

		System.out.println(e.hammingDistance(1,4));
//		System.out.println(e.reverseVowels(str));
	}

}
