import java.util.Scanner;

public class HackerRankBitManipulation {

	public int maxXor(int l, int r) {
		int max = l ^ r;
		for (int i = l; i <= r; i++) {
			for (int j = l; j <= r; j++) {
				int val = i ^ j;
				if (max < val)
					max = val;
			}
		}
		return max;
	}

	// finding maxbit where bit differs
	public int maxXor2(int l, int r) {
		int x = l ^ r;
		int i = 1;
		while (x != 0) {
			x = x >> 1;
			i = i * 2;
		}
		return i - 1;
	}

	public int maxXor3(int l, int r) {
		int x = l ^ r;
		int i = 1;
		while (x != 0) {
			x = x >> 1;
			i = i << 1;
		}
		return i - 1;
	}

	public int maxXor4(int l, int r) {
		int bitCount = (int) (Math.log(l ^ r) / Math.log(2));
		return (2 << bitCount) - 1;
	}

	public static boolean isPowerOfTwo2(int n) {
		while (n != 1) {
			if (n % 2 != 0)
				return false;
			n = n >> 1;
		}
		return true;
	}

	public void counter() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			String res = "Louise";
			boolean flag = true;
			while (num != 1) {
				if (flag) {
					res = "Louise";
					flag = false;
				} else {
					res = "Richard";
					flag = true;
				}

				if (isPowerOfTwo2(num)) {
					num = num - (num / 2);
				} else {
					int count = 1;
					int temp = num;
					while (temp != 1) {
						temp = temp >> 1;
						count = count << 1;
					}
					num = num - count;
				}
			}
			System.out.println(res);
		}
	}

	public int flippingBits(int n) {
		int ans = 0;
		for(int i=0; i<32; i++){
			ans = ans + ~(n&1);
			System.out.println(Integer.toBinaryString(ans));
			ans = ans<<1;
			n = n>>1;
		}
		return ans;
	}

	public static void main(String[] args) {
		HackerRankBitManipulation h = new HackerRankBitManipulation();
		System.out.println("Maximizing xor : " + h.maxXor4(10, 15));
//		h.counter();
		
		System.out.println("Flipping bits : "+ h.flippingBits(1));
	}
}
