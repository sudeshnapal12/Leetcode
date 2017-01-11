import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LeetCodePage2 {

	public boolean isUgly(int num) {
		if (num == 0)
			return true;
		int two = 2, three = 3, five = 5;
		while (num % 30 == 0) {
			num = num / 30;
		}
		while (num % 15 == 0) {
			num = num / 15;
		}
		while (num % 6 == 0) {
			num = num / 6;
		}
		while (num % 10 == 0) {
			num = num / 10;
		}
		while (num % two == 0) {
			num = num / two;
		}
		while (num % three == 0) {
			num = num / three;
		}
		while (num % five == 0) {
			num = num / five;
		}
		if (num == 1)
			return true;
		else
			return false;
	}

	public int removeElement(int[] nums, int val) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[index] = nums[i];
				index++;
			}
		}
		return index;
	}

	public String reverseVowels(String s) {
		StringBuilder sbr = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I'
					|| s.charAt(i) == 'O' || s.charAt(i) == 'U') {
				sbr.append(s.charAt(i));
			}
		}
		sbr.reverse();
		int j = 0;
		StringBuilder newsbr = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I'
					|| s.charAt(i) == 'O' || s.charAt(i) == 'U') {
				newsbr.append(sbr.charAt(j));
				j++;
			} else {
				newsbr.append(s.charAt(i));
			}
		}
		return newsbr.toString();
	}

	public String reverseVowels2(String s) {
		String vowels = "aeiouAEIOU";
		int start = 0;
		int end = s.length() - 1;
		StringBuilder sbr = new StringBuilder(s);
		while (start < end) {
			if (vowels.contains(String.valueOf(s.charAt(start))) && vowels.contains(String.valueOf(s.charAt(end)))) {
				sbr.setCharAt(start, s.charAt(end));
				sbr.setCharAt(end, s.charAt(start));
				start++;
				end--;
			} else if (vowels.contains(String.valueOf(s.charAt(start)))) {
				end--;
			} else if (vowels.contains(String.valueOf(s.charAt(end)))) {
				start++;
			} else {
				start++;
				end--;
			}
		}
		return sbr.toString();
	}

	public int trailingZeroes(int n) {
		int count = 0;
		long a = 1;
		while ((n / a) != 0) {
			a = a * 5;
			count += n / a;
		}
		return count;
	}

	public List<List<Integer>> pascalsTriangle(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (numRows == 0) {
			return res;
		}

		List<Integer> first = new ArrayList<Integer>();
		first.add(1);
		if (numRows == 1) {
			res.add(first);
			return res;
		}

		List<Integer> prev = new ArrayList<Integer>();
		prev.add(1);
		prev.add(1);
		if (numRows == 1) {
			res.add(prev);
			return res;
		}

		numRows = numRows - 2;
		res.add(first);
		res.add(prev);
		while (numRows != 0) {
			numRows--;
			List<Integer> curr = new ArrayList<>();
			curr.add(1);
			for (int i = 1; i < prev.size();) {
				int sum = prev.get(i - 1) + prev.get(i);
				i = i + 1;
				curr.add(sum);
			}
			curr.add(1);
			res.add(curr);
			prev = curr;
		}
		return res;
	}

	public boolean isIsomorphic(String s, String t) {
		if (s == null && t == null) {
			return true;
		} else if (s == null || t == null) {
			return false;
		} else {
			Map<Character, Integer> sMap = new HashMap<>();
			Map<Character, Integer> tMap = new HashMap<>();
			String sCode = "";
			String tCode = "";
			int sNum = 0;
			int tNum = 0;
			// given s and t are of same length
			for (int i = 0; i < s.length(); i++) {
				char sch = s.charAt(i);
				if (!sMap.containsKey(sch))
					sMap.put(sch, ++sNum);
				sCode = sCode + sMap.get(sch);

				char tch = t.charAt(i);
				if (!tMap.containsKey(tch))
					tMap.put(tch, ++tNum);
				tCode = tCode + tMap.get(tch);
			}
			if (sCode.equals(tCode))
				return true;
			else
				return false;
		}
	}

	// tle aa gya let me try again
	public boolean isIsomorphic2(String s, String t) {
		if (s == null && t == null) {
			return true;
		} else if (s == null || t == null) {
			return false;
		} else {
			Map<Character, String> sMap = new HashMap<>();
			Map<Character, String> tMap = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				char sch = s.charAt(i);
				char tch = t.charAt(i);
				if (sMap.containsKey(sch) && tMap.containsKey(tch)) {
					if (sMap.get(sch).equals(tMap.get(tch))) {
						sMap.put(sch, sMap.get(sch) + i);
						tMap.put(tch, tMap.get(tch) + i);
					} else {
						return false;
					}
				} else if (!sMap.containsKey(sch) && !tMap.containsKey(tch)) {
					sMap.put(sch, i + "");
					tMap.put(tch, i + "");
				} else {
					return false;
				}
			}
			return true;
		}
	}

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		int start = 0;
		while (i < nums.length) {
			if (nums[start] == nums[i]) {
				i++;
			} else {
				start++;
				nums[start] = nums[i];
				i++;
			}
		}
		return start + 1;
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1;
		int index = m + n - 1;
		while (i >= 0 || j >= 0) {
			if ((i >= 0 && j >= 0 && nums1[i] > nums2[j]) || (j == -1 && i >= 0)) {
				nums1[index] = nums1[i];
				index--;
				i--;
			} else if ((i >= 0 && j >= 0 && nums1[i] < nums2[j]) || (i == -1 && j >= 0)) {
				nums1[index] = nums2[j];
				index--;
				j--;
			} else if (i >= 0 && j >= 0 && nums1[i] == nums2[j]) {
				nums1[index] = nums1[i];
				i--;
				index--;
				nums1[index] = nums2[j];
				j--;
				index--;
			}
		}
	}

	public int[] plusOne(int[] digits) {
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + carry;
			carry = sum / 10;
			digits[i] = sum % 10;
		}
		if (carry == 1) {
			int newDigits[] = new int[digits.length + 1];
			newDigits[0] = carry;
			for (int i = 1; i < newDigits.length; i++) {
				newDigits[i] = digits[i - 1];
			}
			return newDigits;
		} else
			return digits;

	}

	public int[] plusOne2(int[] digits) {
		int len = digits.length;
		for (int i = len - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			} else {
				digits[i] = 0;
			}
		}
		int newDigits[] = new int[len + 1];
		newDigits[0] = 1;
		return newDigits;
	}

	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		while (i >= 0 || j >= 0) {
			int x = i >= 0 ? a.charAt(i) - '0' : 0;
			int y = j >= 0 ? b.charAt(j) - '0' : 0;
			int sum = x + y + carry;
			if (sum % 2 == 0) {
				carry = sum / 2;
				sb.append(0);
			} else {
				sb.append(1);
				carry = sum / 2;
			}
			i--;
			j--;
		}
		if (carry == 1)
			sb.append(carry);
		return sb.reverse().toString();
	}

	public boolean wordPattern(String pattern, String str) {
		HashMap<Character, String> map = new HashMap<>();
		if (pattern.length() != str.split(" ").length)
			return false;

		for (int i = 0; i < pattern.length(); i++) {
			if (!map.containsKey(pattern.charAt(i))) {
				if (map.values().contains(str.split(" ")[i])) {
					return false;
				} else {
					map.put(pattern.charAt(i), str.split(" ")[i]);
				}

			} else {
				if (map.get(pattern.charAt(i)).equals(str.split(" ")[i])) {
					continue;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int x[] = new int[] { A, C, E, G };
		int y[] = new int[] { B, D, F, H };
		int area_sum = (C - A) * (D - B) + (G - E) * (H - F);
		Arrays.sort(x);
		Arrays.sort(y);

		// No overlap
		if (((Math.abs(C - A) + Math.abs(G - E)) <= Math.abs(x[3] - x[0]))
				|| ((Math.abs(D - B) + Math.abs(H - F)) <= Math.abs(y[3] - y[0])))
			return area_sum;
		int area_common = (x[2] - x[1]) * (y[2] - y[1]);
		return area_sum - area_common;
	}

	public boolean distinctRow(char[] row) {
		int num[] = new int[10];
		for (int i = 0; i < 9; i++) {
			if (row[i] == '.')
				continue;
			else {
				if (num[row[i] - '0'] == 0)
					num[row[i] - '0']++;
				else
					return false;
			}
		}
		return true;
	}

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			if (distinctRow(board[i]) == false)
				return false;
		}

		char col[] = new char[9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				col[j] = board[j][i];
			}
			if (distinctRow(col) == false)
				return false;
		}
		// //diag
		// for(int i=0; i<9; i++){
		// col[i] = board[i][i];
		// }
		// if(distinctRow(col) == false)
		// return false;
		//
		// //diag
		// for(int i=0; i<9; i++){
		// col[i] = board[i][8-i];
		// }
		// if(distinctRow(col) == false)
		// return false;

		int k = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 3; j++) {
				col[k++] = board[i][j];
			}
			if (k == 9 && distinctRow(col) == false)
				return false;
			else if (k == 9 && distinctRow(col))
				k = 0;
		}

		k = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 3; j < 6; j++) {
				col[k++] = board[i][j];
			}
			if (k == 9 && distinctRow(col) == false)
				return false;
			else if (k == 9 && distinctRow(col))
				k = 0;
		}

		k = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 6; j < 9; j++) {
				col[k++] = board[i][j];
			}
			if (k == 9 && distinctRow(col) == false)
				return false;
			else if (k == 9 && distinctRow(col))
				k = 0;
		}

		return true;
	}

	public int arrangeCoins(int n) {
		if (n == 0)
			return 0;

		long x = (long) (Math.sqrt(n) * Math.sqrt(2));
		long sum1 = x * (x + 1) / 2;
		// long sum2 = (x - 1) * (x) / 2;
		if (sum1 > n) {
			return (int) x - 1;
		} else
			return (int) x;
		// int i=0;
		// int sum = 0;
		// while(sum<=n){
		// i++;
		// sum += i;
		// }
		// return i-1;
	}

	public List<Integer> getRow(int rowIndex) {
		List<Integer> prev = new ArrayList<>(rowIndex + 1);
		if (rowIndex == 0) {
			prev.add(1);
			return prev;
		} else if (rowIndex == 1) {
			prev.add(1);
			prev.add(1);
			return prev;
		} else {
			prev.add(1);
			prev.add(1);
			while (rowIndex - 1 > 0) {
				prev.set(0, 1);
				int tempPrev = prev.get(0);
				for (int i = 1; i < prev.size(); i++) {
					int tempNext = prev.get(i);
					prev.set(i, tempPrev + prev.get(i));
					tempPrev = tempNext;
				}
				prev.add(1);
				rowIndex--;
			}
		}
		return prev;
	}

	public boolean isAnagram(String s, String p) {
		if (s.length() == p.length()) {
			int chr[] = new int[26];
			for (int i = 0; i < s.length(); i++) {
				chr[s.charAt(i) - 'a']++;
			}
			for (int i = 0; i < p.length(); i++) {
				if (chr[p.charAt(i) - 'a'] == 0)
					return false;
				else
					chr[p.charAt(i) - 'a']--;
			}
			for (int i = 0; i < 26; i++) {
				if (chr[i] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		for (int j = 0; j < s.length() - p.length() + 1; j++) {
			String subStr = s.substring(j, j + p.length());
			if (isAnagram(subStr, p)) {
				res.add(j);
			}
		}
		return res;
	}

	public boolean isValidParenthesis(String s) {
		if (s == null)
			return true;
		Stack<Character> stk = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stk.push(s.charAt(i));
			} else if (s.charAt(i) == ')' && !stk.isEmpty() && stk.peek() == '(') {
				stk.pop();
			} else if (s.charAt(i) == '}' && !stk.isEmpty() && stk.peek() == '{') {
				stk.pop();
			} else if (s.charAt(i) == ']' && !stk.isEmpty() && stk.peek() == '[') {
				stk.pop();
			} else {
				return false;
			}
		}
		if (stk.size() != 0) {
			return false;
		}
		return true;
	}

	public void rotate(int[] nums, int k) {
		if (k > nums.length)
			k = k - nums.length;
		int temp[] = new int[k];
		for (int i = 0; i < k; i++) {
			temp[i] = nums[nums.length - (k - i)];
		}
		for (int i = nums.length - 1; i > k - 1; i--) {
			nums[i] = nums[i - k];
		}
		for (int i = 0; i < k; i++) {
			nums[i] = temp[i];
		}
	}

	// my method without extra space.
	public void rotate2(int[] nums, int k) {
		if (k > nums.length)
			k = k - nums.length;

		int p = 0;
		for (int i = k - 1; i >= 0; i--) {
			int temp = nums[i];
			nums[i] = nums[nums.length - 1 - p];
			nums[nums.length - 1 - p] = temp;
			p++;
		}

		if (2 * k < nums.length) {
			p = 0;
			for (int i = k; i < 2 * k; i++) {
				int temp = nums[i];
				nums[i] = nums[nums.length - k + p];
				nums[nums.length - k + p] = temp;
				p++;
			}
		}
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < Math.min(nums.length, j + k); j++) {
				if (i != j && nums[i] == nums[j] && Math.abs(j - i) <= k) {
					return true;
				}
			}
		}
		return false;
	}

	// TLE aa gya so second try
	public boolean containsNearbyDuplicate2(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if (Math.abs(map.get(nums[i]) - i) <= k) {
					return true;
				} else {
					map.put(nums[i], i);
				}
			} else {
				map.put(nums[i], i);
			}

		}
		return false;
	}

	// after seeing leetcode, I saw they used HashSet. Let me give HashSet try.
	// duplicate matlab hashset..
	// REMEMBER#########################################################################
	public boolean containsNearbyDuplicate3(int[] nums, int k) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				set.remove(nums[i - k - 1]);// k ke pehle wala element I am
											// removing
			}
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		return false;
	}

	public int myAtoi(String str) {
		if (str == null || str.equals("") || str.length() == 0)
			return 0;
		str = str.trim();
		boolean isNeg = false;
		if (str.charAt(0) == '-') {
			isNeg = true;
			str = str.substring(1);
		} else if (str.charAt(0) == '+') {
			str = str.substring(1);
		}
		if (str.length() == 0)
			return 0;
		int res = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				int val = (str.charAt(i) - '0');
				if ((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && val > 7)) { // overflow
																									// happened
					return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				}
				res = res * 10 + val;
			} else {
				break;
			}
		}
		return isNeg ? -res : res;
	}

	int guess(int num) {
		int myNum = 1702766719;
		if (myNum > num)
			return 1;
		else if (myNum < num)
			return -1;
		else if (myNum == num)
			return 0;
		else
			return -100;
	}

	public int guessNumber(int n) {
		int mid = (1 + n) / 2;
		int low = 1;
		int high = n;
		if (guess(n) == 0)
			return n;
		while (low <= high) {
			mid = low + (high - low) / 2;

			if (guess(mid) == 0) {
				return mid;
			} else if (guess(mid) == -1) {
				high = mid - 1;
			} else if (guess(mid) == 1) {
				low = mid + 1;
			} else {
				break;
			}
		}
		return mid;
	}

	public String getHintBullsAndCows(String secret, String guess) {
		int A = 0;// bull
		int B = 0;// cow
		StringBuilder s = new StringBuilder(secret);
		StringBuilder g = new StringBuilder(guess);
		int j = 0;
		for (int i = 0; i < Math.min(secret.length(), guess.length()); i++) {
			if (s.charAt(j) == g.charAt(j)) {
				s.deleteCharAt(j);
				g.deleteCharAt(j);
				A++;
			} else {
				j++;
			}
		}
		for (int i = 0; i < g.length(); i++) {
			if (s.toString().contains(g.charAt(i) + "")) {
				s.deleteCharAt(s.indexOf(g.charAt(i) + ""));
				B++;
			}
		}
		return A + "A" + B + "B";
	}

	// let me try using map
	public String getHintBullsAndCows2(String secret, String guess) {
		int bull = 0;
		int cow = 0;
		int s[] = new int[10];
		int g[] = new int[10];
		for (int i = 0; i < Math.min(secret.length(), guess.length()); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				bull++;
			} else {
				s[secret.charAt(i) - '0']++;
				g[guess.charAt(i) - '0']++;
			}
		}
		for (int i = 0; i < 10; i++) {
			cow = cow + Math.min(s[i], g[i]);
		}
		return bull + "A" + cow + "B";
	}

	// in one pass.. bhai sahab this is some level... some awesome solution
	public String getHintBullsAndCows3(String secret, String guess) {
		int cows = 0;
		int bulls = 0;
		int temp[] = new int[10];// because only 10 different digits are
									// possible
		for (int i = 0; i < secret.length(); i++) {
			int s = secret.charAt(i) - '0';
			int g = guess.charAt(i) - '0';
			if (s == g) {
				bulls++;
			} else {
				if (temp[s] > 0)
					cows++;
				if (temp[g] < 0)
					cows++;
				temp[s]--;
				temp[g]++;
			}
		}
		return bulls + "A" + cows + "B";
	}

	public int findNthDigit(int n) {
		int i=0;
		int temp = n;
		while(temp>=0){
			temp = temp - 9 * (int)Math.pow(10, i) * (i+1);
			i++;
		}
		i--;
		temp = temp + 2*9 * (int)Math.pow(10, i) * (i+1);
		
	}

	public int rob(int[] nums) {
		// List<Integer> list = new ArrayList<>();
		// List<Integer> sortedList = new ArrayList<>();
		// for(int i=0; i<nums.length; i++){
		// list.add(nums[i]);
		// sortedList.add(nums[i]);
		// }
		// Collections.sort(sortedList);
		// int maxMoney = 0;
		// int k = 0;
		// for(int i=0; i<list.size(); i++){
		// maxMoney += sortedList.get(k);
		// k++;
		// int index = list.indexOf(sortedList.get(k));
		// list.set(index, -1);
		// list.set(index-1, -1);
		// list.set(index+1, -1);
		// }
		return 0;
	}

	public static void main(String[] args) {
		LeetCodePage2 l = new LeetCodePage2();

		System.out.println("is ugly : " + l.isUgly(0));

		int nums[] = { 4, 5 };
		System.out.println(Arrays.toString(nums) + " val = 4");
		System.out.println("removeElement : " + l.removeElement(nums, 4));

		System.out.println("reverse vowels " + l.reverseVowels2("leetcode"));

		System.out.println("Trailing zeros: " + l.trailingZeroes(1808548329));

		System.out.println("Pascal's triangle " + l.pascalsTriangle(0));

		System.out.println("Isomorphc Strings " + l.isIsomorphic2("aba", "baa"));

		int nums1[] = { 1 };
		System.out.println("Remove duplicates from array : " + l.removeDuplicates(nums1));

		nums1 = new int[] { 1, 1, 2, 3, 4, 5, 10 };
		int bigNums1[] = new int[11];
		for (int i = 0; i < nums1.length; i++) {
			bigNums1[i] = nums1[i];
		}
		int nums2[] = { 0, 2, 5, 8 };
		System.out.println("Merge sorted array : ");
		l.merge(bigNums1, nums1.length, nums2, nums2.length);
		System.out.println(Arrays.toString(bigNums1));

		int digits[] = { 9, 9, 9 };
		System.out.println("Plus one " + Arrays.toString(l.plusOne2(digits)));

		System.out.println("add binary " + l.addBinary("1010", "1011"));

		System.out.println("wordPattern " + l.wordPattern("abba", "dog dog dog dog"));

		System.out.println("Rectangle area " + l.computeArea(-2, -2, 2, 2, -4, -4, -3, -3));

		char[][] board = new char[][] { { '.', '.', '4', '.', '.', '.', '6', '3', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '5', '.', '.', '.', '.', '.', '.', '9', '.' },
				{ '.', '.', '.', '5', '6', '.', '.', '.', '.' }, { '4', '3', '.', '.', '.', '.', '.', '.', '1' },
				{ '.', '.', '.', '7', '.', '.', '.', '.', '.' }, { '.', '.', '.', '4', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' } };
		System.out.println("Valid soduku " + l.isValidSudoku(board));

		System.out.println("Pascal's Traingle II : " + l.getRow(2));

		System.out.println("Find all anagrams in a String " + l.findAnagrams("abcabcd", "abc"));

		System.out.println("Valid parenthesis : " + l.isValidParenthesis(" ]"));

		int rot[] = { -1, 2, 3, 4, 5, 6, 7 };
		l.rotate2(rot, 3);
		System.out.println("Rotate array : " + Arrays.toString(rot));

		int dupl[] = { 1, 2, 1 };
		System.out.println("Contains duplicate : " + l.containsNearbyDuplicate3(dupl, 2));

		// System.out.println("String to integer : "+ l.myAtoi(" -0012a42"));
		// System.out.println("String to integer : " + l.myAtoi("+-2"));
		// System.out.println("String to integer : " + l.myAtoi("
		// 10522545459"));
		// System.out.println("String to integer : " + l.myAtoi(""));
		System.out.println("String to integer : " + l.myAtoi("2147483648"));

		System.out.println("Guess Number Higher or Lower " + l.guessNumber(2126753390));

		System.out.println("Bulls and Cows : " + l.getHintBullsAndCows3("11", "01"));

		// 1804289383
		System.out.println("Arrange coins " + l.arrangeCoins(5));
	}

}
