package interview.string;

public class StringToNumber {

	public static void main(String[] args) {
		String inNum = "1234";

		//mySolution(inNum); 
		int i = stringToint(inNum);
		System.out.println(" i  =>> " + i );

	}

	private static void mySolution(String inNum) {
		char[] chars = inNum.toCharArray();
		int finVal = 0;
		char cZero = '0';
		int zero = cZero;
		System.out.println(" zero =>> " + zero);
		for (int i = chars.length - 1; i >= 0; i--) {

			int temp = chars[i] - zero;
			int pwrFactor = chars.length - i - 1;
			System.out.println(" temp =>> " + temp + " pwrFactor " + pwrFactor);
			int result = temp;
			while (pwrFactor > 0) {
				result = result * 10;
				pwrFactor--;
			}
			System.out.println(" result =>> " + result);

			finVal = finVal + result;
			System.out.println(" final " + finVal);

		}
	}
	
	//https://javahungry.blogspot.com/2014/02/how-to-convert-string-to-int-in-java-without-using-integer-parseint-method-code-with-example.html
	 public static int stringToint( String str ){
	        int i = 0, number = 0;
	        boolean isNegative = false;
	        int len = str.length();
	        if( str.charAt(0) == '-' ){
	            isNegative = true;
	            i = 1;
	        }
	        while( i < len ){
	            number *= 10;
	            number += ( str.charAt(i++) - '0' );
	        }
	        if( isNegative )
	        number = -number;
	        return number;
	    }   

}
