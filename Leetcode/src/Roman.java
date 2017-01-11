
public class Roman {

	public static int convert(char c) {
		int val = 0;
		switch (c) {
		case 'I':
			val = 1;
			break;
		case 'V':
			val = 5;
			break;
		case 'X':
			val = 10;
			break;
		case 'L':
			val = 50;
			break;
		case 'C':
			val = 100;
			break;
		case 'D':
			val = 500;
			break;
		case 'M':
			val = 1000;
			break;
		default:
			break;
		}
		return val;
	}

	public int romanToInt(String s) {
		int val = 0;
		int cur = convert(s.charAt(0));
		for (int i = 0; i < s.length() - 1; i++) {
			int next = convert(s.charAt(i + 1));
			if (cur < next)
				val = val - cur;
			else
				val = val + cur;			
			
			cur = next;
		}
		return val + cur;
	}

	public static void main(String[] args) {
		Roman r = new Roman();
		System.out.println(r.romanToInt("CML"));
	}

}
