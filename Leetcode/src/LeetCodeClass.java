
public class LeetCodeClass {

	int[] sums;

	public LeetCodeClass(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i - 1] + nums[i];
		}
		this.sums = nums;
	}

	//Revise
	public int sumRange(int i, int j) {
		if (i == 0) {
			return sums[j];
		}
		return sums[j] - sums[i - 1];
	}

	public static void main(String[] args) {
		int nums[] = { -2, 1, -3, 123, 4, -3, 6, -7 };
		LeetCodeClass l = new LeetCodeClass(nums);
		System.out.println("Range Sum Query - Immutable " + l.sumRange(0, 0));
		System.out.println("Range Sum Query - Immutable " +l.sumRange(2, 5));
		System.out.println("Range Sum Query - Immutable " +l.sumRange(0, 5));

	}
}
