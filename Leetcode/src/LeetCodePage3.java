import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MinStack {

	Stack<Integer> stk;
	Stack<Integer> minStk;

	/** initialize your data structure here. */
	public MinStack() {
		stk = new Stack<Integer>();
		minStk = new Stack<Integer>();
	}

	public void push(int x) {
		stk.push(x);
		if (minStk.isEmpty()) {
			minStk.push(x);
		} else {
			if (minStk.peek() > x) {
				minStk.push(x);
			} else {
				minStk.push(minStk.peek());
			}
		}
	}

	public void pop() {
		if (!stk.isEmpty())
			stk.pop();
		if (!minStk.isEmpty())
			minStk.pop();
	}

	public int top() {
		return stk.peek();
	}

	public int getMin() {
		return minStk.peek();
	}
}

class MinStack2 {
	Stack<Long> stk;
	long min = Integer.MAX_VALUE;

	public MinStack2() {
		stk = new Stack<Long>();
	}

	public void push(int x) {
		if (stk.isEmpty()) {
			stk.push((long) 0);
			min = x;
		} else {
			// push val - older min
			stk.push(x - min);
			// then update min
			if (x < min) {
				min = x;
			}
		}
	}

	public void pop() {
		if (!stk.isEmpty()) {
			Long pop = stk.pop();
			// minimum changed when pop is negative
			if (pop < 0) {
				min = min - pop;
			}
		}
	}

	public int top() {
		if (stk.peek() <= 0) {
			return (int) min;
		} else {
			return (int) (min + stk.peek());
		}
	}

	public int getMin() {
		return (int) min;
	}
}

// Queue using Two Stacks //O(n) push and O(1) pop
class QueueUsingStacks {
	Stack<Integer> stk;
	Stack<Integer> reverse;

	public QueueUsingStacks() {
		stk = new Stack<>();
		reverse = new Stack<>();
	}

	public void push(int x) {
		while (!stk.isEmpty()) {
			reverse.push(stk.pop());
		}
		stk.push(x);
		while (!reverse.isEmpty()) {
			stk.push(reverse.pop());
		}
	}

	public void pop() {
		if (!stk.isEmpty())
			stk.pop();
	}

	public int peek() {
		return stk.peek();
	}

	public boolean empty() {
		return stk.isEmpty();
	}
}

// Push pop amortized cost O(1) each
class QueueUsingStacks2 {
	Stack<Integer> stk;
	Stack<Integer> reverse;
	int front;

	public QueueUsingStacks2() {
		stk = new Stack<>();
		reverse = new Stack<>();
	}

	public void push(int x) {
		if (stk.isEmpty()) {
			front = x;
			stk.push(x);
		} else {
			stk.push(x);
		}
	}

	public void pop() {
		if (reverse.isEmpty()) {
			while (!stk.isEmpty()) {
				reverse.push(stk.pop());
			}
		}
		reverse.pop();
	}

	public int peek() {
		if (!reverse.isEmpty()) {
			return reverse.peek();
		} else {
			return front;
		}

	}

	public boolean empty() {
		return stk.isEmpty() && reverse.isEmpty();
	}
}

// Implement Stack using Queues //push : O(1) pop O(n)
class StackUsingQueues {
	Queue<Integer> queue;
	Queue<Integer> reverse;
	int top;

	public StackUsingQueues() {
		queue = new LinkedList<>();
		reverse = new LinkedList<>();
	}

	public void push(int x) {
		queue.offer(x);
		top = x;
	}

	public void pop() {
		while (queue.size() > 1) {
			top = queue.poll();
			reverse.offer(top);
		}

		queue.poll();

		Queue<Integer> temp = reverse;
		reverse = queue;
		queue = temp;
	}

	public int top() {
		return top;
	}

	public boolean empty() {
		return queue.isEmpty();
	}
}

// Implement Stack using Queues //push : O(n) pop O(1)
class StackUsingQueues2 {
	Queue<Integer> queue;
	Queue<Integer> reverse;
	int top;

	public StackUsingQueues2() {
		queue = new LinkedList<>();
		reverse = new LinkedList<>();
	}

	public void push(int x) {
		reverse.offer(x);
		top = x;
		while (!queue.isEmpty()) {
			reverse.offer(queue.poll());
		}
		Queue<Integer> temp = reverse;
		reverse = queue;
		queue = temp;
	}

	public void pop() {
		if (!queue.isEmpty()) {
			queue.poll();
		}
		if (!queue.isEmpty()) {
			top = queue.peek();
		}
	}

	public int top() {
		return top;
	}

	public boolean empty() {
		return queue.isEmpty();
	}
}

// Implement Stack using single Queue //push : O(n) pop O(1)
class StackUsingQueues3 {
	Queue<Integer> queue;
	// int top;

	public StackUsingQueues3() {
		queue = new LinkedList<>();
	}

	public void push(int x) {
		// top = x;
		queue.offer(x);
		int size = queue.size();
		while (size > 1) {
			queue.offer(queue.poll());
			size--;
		}
	}

	public void pop() {
		if (!queue.isEmpty()) {
			queue.poll();
		}
		// if(!queue.isEmpty()){
		// top = queue.peek();
		// }
	}

	public int top() {
		return queue.peek();
	}

	public boolean empty() {
		return queue.isEmpty();
	}
}

public class LeetCodePage3 {

	public int thirdMax(int[] nums) {
		long max = Long.MIN_VALUE;
		long secMax = Long.MIN_VALUE;
		long thirdMax = Long.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (max < nums[i]) {
				thirdMax = secMax;
				secMax = max;
				max = nums[i];
			} else if (secMax < nums[i] && nums[i] != max) {
				thirdMax = secMax;
				secMax = nums[i];
			} else if (thirdMax < nums[i] && nums[i] != max && nums[i] != secMax) {
				thirdMax = nums[i];
			}
		}
		if (thirdMax == Long.MIN_VALUE) {
			thirdMax = max;
		}
		return (int) thirdMax;
	}

	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int res[] = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				res[0] = map.get(nums[i]);
				res[1] = i;
			} else {
				map.put(target - nums[i], i);
			}
		}
		return res;
	}

	public int strStr(String haystack, String needle) {
		for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
			int j;
			for (j = 0; j < needle.length();) {
				if (haystack.charAt(i + j) == needle.charAt(j)) {
					j++;
				} else {
					break;
				}
			}
			if (j == needle.length())
				return i;
		}
		return -1;
	}

	public int reverse(int x) {
		boolean neg = false;
		if (x < 0) {
			neg = true;
			x = -x;
		}
		String s = String.valueOf(x);
		String ans = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			ans = ans + s.charAt(i);
		}
		try {
			if (neg)
				return -Integer.valueOf(ans);
			else
				return Integer.valueOf(ans);
		} catch (Exception e) {
			return 0;
		}
	}

	public int reverse2(int x) {
		int res = 0;
		int k = 0;
		while (x != 0) {
			int digit = x % 10;
			res = res * 10 + digit;
			if ((res - digit) / 10 != res) {
				return 0;
			}
			k++;
			x = x / 10;
		}

		return res;
	}

	public String convert(String s, int numRows) {
		String str[] = new String[numRows];
		for (int i = 0, j = 0; j < numRows && i < s.length(); j++, i++) {
			str[j] = str[j] + s.charAt(i);
			if (j == numRows - 1) {
				j = numRows - 1;
			}
		}
		String res = "";
		for (int i = 0; i < numRows; i++) {
			res += str[i].substring(4);
		}
		return res;
	}

	public boolean isBadVersion(int version) {
		if (version >= 1702766719) {
			return true;
		} else {
			return false;
		}
	}

	public int firstBadVersion(int n) {
		long low = 1;
		long high = n;
		long mid = (low + high) / 2;
		while (high - low > 1) {
			mid = (low + high) / 2;
			if (isBadVersion((int) mid) == true) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return isBadVersion((int) low) ? (int) low : (int) high;
	}

	public boolean isPalindrome(String s) {
		// Character.isLetterOrDigit(ch) use
		// THISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
		if (s == null)
			return true;
		s = s.toLowerCase();
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			while (start < s.length() && !((s.charAt(start) >= 'a' && s.charAt(start) <= 'z')
					|| (s.charAt(start) >= '0' && s.charAt(start) <= '9'))) {
				start++;
			}
			while (end >= 0 && !((s.charAt(end) >= 'a' && s.charAt(end) <= 'z')
					|| (s.charAt(end) >= '0' && s.charAt(end) <= '9'))) {
				end--;
			}
			if (start < s.length() && end >= 0) {
				if (s.charAt(start) == s.charAt(end)) {
					start++;
					end--;
				} else {
					return false;
				}
			}

		}
		return true;
	}

	public String convertToTitle(int n) {
		String res = "";
		if (n < 0)
			return res;
		char c[] = { 'd', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		while (n != 0) {
			int digit = n % 26;
			if (digit == 0)
				digit = 26;
			res = c[digit] + res;
			n = (n - digit) / 26;
		}
		return res;
	}

	public int compareVersion(String version1, String version2) {
		String v1Split[] = version1.split("\\.");
		String v2Split[] = version2.split("\\.");
		int len1 = v1Split.length;
		int len2 = v2Split.length;
		int minLen = len1 < len2 ? len1 : len2;
		int i;
		for (i = 0; i < minLen; i++) {
			if (Integer.valueOf(v1Split[i]) > Integer.valueOf(v2Split[i])) {
				return 1;
			} else if (Integer.valueOf(v1Split[i]) < Integer.valueOf(v2Split[i])) {
				return -1;
			}
		}
		if (len1 > len2) {
			while (i < len1) {
				// if(v2Split[i].equals("0+")) dont do because there can be
				// 1.00.0.0000 and 1.0 grrrrrrrrrrrrrr
				if (Integer.valueOf(v1Split[i]) == 0) {
					i++;
				} else {
					break;
				}
			}
			if (i == len1)
				return 0;
			else
				return 1;
		} else if (len1 < len2) {
			while (i < len2) {
				if (Integer.valueOf(v2Split[i]) == 0) {
					i++;
				} else {
					break;
				}
			}
			if (i == len2)
				return 0;
			else
				return -1;
		} else {
			return 0;
		}
	}

	// let me try again using that conditional operator
	// LOL you did it in one shot why didnt u try this before
	// anyway good for me, realized test cases like 1.000.00 :D
	public int compareVersion2(String version1, String version2) {
		String v1Split[] = version1.split("\\.");
		String v2Split[] = version2.split("\\.");
		int len1 = v1Split.length;
		int len2 = v2Split.length;
		int maxLen = len1 > len2 ? len1 : len2;
		int i;
		for (i = 0; i < maxLen; i++) {
			int v1 = i < len1 ? Integer.valueOf(v1Split[i]) : 0;
			int v2 = i < len2 ? Integer.valueOf(v2Split[i]) : 0;
			if (v1 > v2) {
				return 1;
			} else if (v1 < v2) {
				return -1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		LeetCodePage3 l = new LeetCodePage3();
		int nums[] = { 2, 2, 3, 1 };
		System.out.println("Third Maximum number " + l.thirdMax(nums));

		int arr[] = { 2, 7, 11, 15 };
		System.out.println("Two sum " + Arrays.toString(l.twoSum(arr, 9)));

		System.out.println("Implement strstr " + l.strStr("TutorialsPoint", "Point"));

		// 1534236469
		System.out.println("Reverse Integer " + l.reverse2(1534236469));

		MinStack2 minStack2 = new MinStack2();
		minStack2.push(-2);
		minStack2.push(0);
		minStack2.push(-3);
		System.out.println("MinStack min :: " + minStack2.getMin()); // Returns
																		// -3.
		minStack2.pop();
		System.out.println("MinStack min :: " + minStack2.top()); // Returns 0.
		System.out.println("MinStack min :: " + minStack2.getMin()); // Returns
																		// -2.

		QueueUsingStacks2 q = new QueueUsingStacks2();
		q.push(42);
		q.pop();
		q.push(14);
		System.out.println("Queue using stacks : " + q.peek());
		q.push(28);
		System.out.println("Queue using stacks : " + q.peek());
		q.push(60);
		q.push(78);
		q.pop();
		q.pop();

		StackUsingQueues s = new StackUsingQueues();
		s.push(42);
		s.pop();
		s.push(14);
		System.out.println("Stack using queues : " + s.top());
		s.push(28);
		System.out.println("Stack using queues : " + s.top());
		s.push(60);
		s.push(78);
		s.pop();
		s.pop();

		System.out.println("is bad version : " + l.firstBadVersion(2126753390));

		System.out.println("Is palindrome alphanumeric : " + l.isPalindrome(".,"));

		System.out.println("Excel sheet column title : " + l.convertToTitle(1000));

		// "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000"
		// "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000"
		System.out.println("Compare Version Numbers : " + l.compareVersion2(
				"19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000",
				"19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000"));

		System.out.println("ZigZag Conversion " + l.convert("PAYPALISHIRING", 3));
	}

}
