
public class AddDigits {
	
	/*
	 * Given a non-negative integer number,
	 * repeatedly add all its digits until the result has only one digit.
	 */
	//M1 -- Bruteforce
	public static int addDigits1(int num){
		if(num <10)
			return num;
		
		int digit = 0;
		while(num>0){
			digit += num % 10;
			num /= 10;
		}
		return addDigits1(digit);
	}
	
	//M1.1 -- BruteForce
	public static int addDigits11(int num){
		while(num>10){
			num = addDigitsHelper(num);
		}
		return num;
	}
	
	private static int addDigitsHelper(int num) {
		int digit = 0;
		while(num > 0){
			digit += num%10;
			num /= 10;
		}
		return digit;
		
	}

	//M2
	public static int addDigits2(int num){
		String s = String.valueOf(num);
		int sum = 0;
		for(int i=0; i<s.length(); i++){
			sum += s.charAt(i) - '0';
		}
		if(sum < 10){
			return sum;
		}else{
			return addDigits2(sum);
		}
	}
	
	//M3 - O(1)
	public static int addDigits3(int num){
		if(num<=0)
			return 0;
		else
			return (num-1)%9 + 1;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("sum from M1 is "+AddDigits.addDigits1(319));
		System.out.println("sum from M1 is "+AddDigits.addDigits11(319));
		System.out.println("sum from M2 is "+AddDigits.addDigits2(319));
		System.out.println("sum from M2 is "+AddDigits.addDigits3(319));
	}

}
//for M2
//Let's enumerate numbers from 1 - 19, 
//in out 
//1   1
//2   2
//3   3
// ...
//9   9
//10  1
//11  2
//12  3
//13  4
//14  5
//...
//19  1
//20  2
//21  3
//
//...
//28  1
//29  2
//30  3
//...
//
// So the result = (n - 1) % 9 + 1
