
public class BitManipulation_add_sub {

	public static int add(int a, int b) {
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}
	
	public static int sub(int a, int b){
		while(b!=0){
			int borrow = (~a) & b;
			a = a^b;
			b = borrow << 1;
		}
		return a;
	}
	
	public static int negative(int x){
		return (~x)+1;
	}

	public static void main(String[] args) {
		System.out.println(add(2, 3));
		System.out.println(sub(2,3));
		System.out.println(negative(3));
	}

}
