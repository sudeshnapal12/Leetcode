
public class CodingBat_Recursion {

	public int factorial(int n) {
		if (n == 1 || n == 0)
			return n;
		return n * factorial(n - 1);
	}

	public int bunnyEars(int bunnies) {
		if (bunnies == 0)
			return 0;
		if (bunnies == 1)
			return 2;
		return 2 + bunnyEars(bunnies - 1);
	}

	public int fibonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public int bunnyEars2(int bunnies) {
		if (bunnies == 0)
			return 0;
		if (bunnies % 2 == 0)
			return 3 + bunnyEars2(bunnies - 1);
		else {
			return 2 + bunnyEars2(bunnies - 1);
		}
	}

	public int triangle(int rows) {
		if (rows == 0)
			return 0;
		return rows + triangle(rows - 1);
	}

	public int sumDigits(int n) {
		if (n == 0)
			return 0;
		return n % 10 + sumDigits(n / 10);
	}

	public int count7(int n) {
		if (n == 0)
			return 0;
		if (n % 10 == 7)
			return 1 + count7(n / 10);
		else
			return count7(n / 10);
	}

	public int count8(int n) {
		if (n == 0)
			return 0;
		if (n % 10 == 8 && n % 100 == 88)
			return 2 + count8(n / 10);
		else if (n % 10 == 8)
			return 1 + count8(n / 10);
		else
			return count8(n / 10);
	}

	public int powerN(int base, int n) {
		if (n == 0)
			return 1;
		return base * powerN(base, n - 1);
	}

	public int countX(String str) {
		if (str == "" || str == null || str.length() == 0)
			return 0;
		if (str.substring(str.length() - 1, str.length()).equals("x")) {
			return 1 + countX(str.substring(0, str.length() - 1));
		} else
			return countX(str.substring(0, str.length() - 1));
	}

	public int countHi(String str) {
		if (str == "" || str == null || str.length() <= 1)
			return 0;
		if (str.substring(str.length() - 2, str.length()).equals("hi")) {
			return 1 + countHi(str.substring(0, str.length() - 1));
		} else {
			return countHi(str.substring(0, str.length() - 1));
		}
	}

	public String changeXY(String str) {
		if (str == null)
			return null;
		if (str.equals("") || str.length() == 0) {
			return "";
		}
		if (str.charAt(str.length() - 1) == 'x') {
			return changeXY(str.substring(0, str.length() - 1)) + "y";
		} else {
			return changeXY(str.substring(0, str.length() - 1)) + str.charAt(str.length() - 1);
		}
	}

	public String changePi(String str) {
		if (str == null)
			return null;
		if (str.equals("") || str.length() < 2) {
			return str;
		}
		if (str.substring(str.length() - 2, str.length()).equals("pi")) {
			return changePi(str.substring(0, str.length() - 2)) + "3.14";
		} else {
			return changePi(str.substring(0, str.length() - 1)) + str.charAt(str.length() - 1);
		}
	}

	public String noX(String str) {
		if (str == null)
			return str;
		if (str.equals("") || str.length() < 1) {
			return str;
		}
		if (str.charAt(str.length() - 1) == 'x') {
			return noX(str.substring(0, str.length() - 1));
		} else {
			return noX(str.substring(0, str.length() - 1)) + str.charAt(str.length() - 1);
		}
	}

	public boolean array6(int[] nums, int index) {
		if (index < nums.length && nums[index] == 6) {
			return true;
		} else if (index < nums.length && nums[index] != 6) {
			return array6(nums, index + 1);
		} else {
			return false;
		}
	}

	public int array11(int[] nums, int index) {
		if (index < nums.length && nums[index] == 11) {
			return 1 + array11(nums, index + 1);
		} else if (index < nums.length && nums[index] != 11) {
			return array11(nums, index + 1);
		} else {
			return 0;
		}
	}

	public boolean array220(int[] nums, int index) {
		if (index < nums.length - 1 && nums[index + 1] == 10 * nums[index]) {
			return true;
		} else if (index >= nums.length - 1) {
			return false;
		} else {
			return array220(nums, index + 1);
		}
	}

	public String allStar(String str) {
		if (str == null || str.equals("") || str.length() == 1) {
			return str;
		} else {
			return allStar(str.substring(0, str.length() - 1)) + "*" + str.charAt(str.length() - 1);
		}
	}

	public String pairStar(String str) {
		if (str == null || str.equals("") || str.length() < 2) {
			return str;
		}
		if (str.charAt(str.length() - 1) == str.charAt(str.length() - 2)) {
			return pairStar(str.substring(0, str.length() - 1)) + "*" + str.charAt(str.length() - 1);
		} else {
			return pairStar(str.substring(0, str.length() - 1)) + str.charAt(str.length() - 1);
		}
	}

	public String endX(String str) {
		if (str == null || str.equals("") || str.length() == 1) {
			return str;
		}
		if (str.charAt(0) == 'x') {
			return endX(str.substring(1)) + "x";
		} else {
			return str.charAt(0) + endX(str.substring(1));
		}
	}

	public int countPairs(String str) {
		if (str == null || str.equals("") || str.length() < 3) {
			return 0;
		}

		if (str.charAt(0) == str.charAt(2)) {
			return 1 + countPairs(str.substring(1));
		}
		return countPairs(str.substring(1));
	}

	public int countAbc(String str) {
		if (str == null || str.equals("") || str.length() < 3) {
			return 0;
		}
		if (str.substring(0, 3).equals("abc")) {
			return 1 + countAbc(str.substring(3));
		} else if (str.substring(0, 3).equals("aba")) {
			return 1 + countAbc(str.substring(2));
		} else {
			return countAbc(str.substring(1));
		}
	}

	public int count11(String str) {
		if (str.length() < 2) {
			return 0;
		}
		if (str.substring(0, 2).equals("11")) {
			return 1 + count11(str.substring(2));
		} else {
			return count11(str.substring(1));
		}
	}

	public String stringClean(String str) {
		if (str.length() < 2) {
			return str;
		}
		if (str.charAt(0) == str.charAt(1)) {
			return stringClean(str.substring(1));
		} else {
			return str.charAt(0) + stringClean(str.substring(1));
		}
	}

	public int countHi2(String str) {
		if (str.length() == 2 && str.equals("hi"))
			return 1;
		if (str.length() < 3)
			return 0;
		if (str.charAt(0) == 'x' && str.substring(1, 3).equals("hi")) {
			return countHi2(str.substring(3));
		} else if (str.substring(0, 2).equals("hi")) {
			return 1 + countHi2(str.substring(2));
		} else {
			return countHi2(str.substring(1));
		}
	}

	// REVISE FROM
	// HERE/////////////////////////////////////////////////////////////////////////////////////////////////
	public String parenBit(String str) {
		if (str.length() < 2)
			return str;
		if (str.charAt(0) == '(') {
			if (str.charAt(str.length() - 1) == ')') {
				return str;
			} else {
				return parenBit(str.substring(0, str.length() - 1));
			}
		} else {
			return parenBit(str.substring(1));
		}
	}

	public boolean nestParen(String str) {
		if (str.length() == 1) {
			return false;
		} else if (str.length() == 0) {
			return true;
		}
		if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
			return nestParen(str.substring(1, str.length() - 1));
		} else {
			return false;
		}
	}
	
	public int strCount(String str, String sub) {
		if(str.length() < sub.length())
			return 0;
		if(str.substring(0, sub.length()).equals(sub)){
			return 1+ strCount(str.substring(sub.length()), sub);
		}else{
			return strCount(str.substring(1), sub);
		}
	}
	
	public boolean strCopies(String str, String sub, int n) {
		if(n == strCopiesFN(str, sub))
			return true;
		else
			return false;
	}
	
	public int strCopiesFN(String str, String sub) {
		  if(str.length()<sub.length())
			  return 0;
		  if(str.substring(0, sub.length()).equals(sub)){
			  return 1+ strCopiesFN(str.substring(1), sub);
		  }else{
			  return strCopiesFN(str.substring(1), sub);
		  }
	}

	public int strDist(String str, String sub) {
		  if(str.length() < sub.length())
			  return 0;
		  if(str.substring(0, sub.length()).equals(sub)){
			  if(str.substring(str.length()-sub.length()).equals(sub)){
				  return str.length();
			  }else{
				  return strDist(str.substring(0, str.length()-1), sub);
			  }
		  }else{
			  return strDist(str.substring(1), sub);
		  }
	}
	
	public static void main(String[] args) {
		CodingBat_Recursion c = new CodingBat_Recursion();
		System.out.println("Factorial :" + c.factorial(2));
		System.out.println("bunnyEars :" + c.bunnyEars(5));
		System.out.println("Fibonacci :" + c.fibonacci(2));
		System.out.println("Bunny ears 2 : " + c.bunnyEars2(5));
		System.out.println("traingle : " + c.triangle(3));
		System.out.println("sumDigits : " + c.sumDigits(126));
		System.out.println("count 7 : " + c.count7(1237));
		System.out.println("count 8 : " + c.count8(88888));
		System.out.println("powerN : " + c.powerN(3, 4));
		System.out.println("countX : " + c.countX("xxhixx"));
		System.out.println("countHi : " + c.countHi("xxhixhix"));
		System.out.println("changeXY : " + c.changeXY("xhixhix"));
		System.out.println("changePI : " + c.changePi("xpix"));
		System.out.println("nox : " + c.noX("xaxb"));
		int nums[] = { 1, 4 };
		System.out.println("array6 : " + c.array6(nums, 0));
		int nums1[] = { 1, 2, 11, 11 };
		System.out.println("array11 : " + c.array11(nums1, 0));
		int nums2[] = { 1, 2, 10 };
		System.out.println("array220 : " + c.array220(nums2, 0));
		System.out.println("allstart : " + c.allStar("hello"));
		System.out.println("pairStart : " + c.pairStar("hello"));
		System.out.println("endX : " + c.endX("xxre"));
		System.out.println("count pairs : " + c.countPairs("AxAxA"));
		System.out.println("count abc : " + c.countAbc("abaxxaba"));
		System.out.println("count 11: " + c.count11("11abc11"));
		System.out.println("string clean: " + c.stringClean("yyzzza"));
		System.out.println("count hi2 " + c.countHi2("hixhhi"));
		System.out.println("parent bit : " + c.parenBit("xyz(abc)123"));
		System.out.println("nested paran : " + c.nestParen("(((x))"));
		System.out.println("strCount : "+c.strCount("catcowcat", "cat"));
		System.out.println("strCopies : "+c.strCopies("iiijjj", "ii", 2));
		System.out.println("strDist : "+c.strDist("cccatcowcatxx", "cat"));
	}

}
