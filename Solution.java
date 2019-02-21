import java.util.regex.*;
public class Solution{

	public static final String[] units = { "", "One", "Two", "Three", "Four",
			"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };

	public static final String[] tens = { 
			"", 		// 0
			"",		// 1
			"Twenty", 	// 2
			"Thirty", 	// 3
			"Forty", 	// 4
			"Fifty", 	// 5
			"Sixty", 	// 6
			"Seventy",	// 7
			"Eighty", 	// 8
			"Ninety" 	// 9
	};

	// function to convert a number into word.
	public static String convert(final int n) {

		if (n < 20) {
			return units[n]+", ";
		}

		if (n < 100) {
			return tens[n / 10] + ((n % 10 != 0) ? "-" : "") + units[n % 10]+", ";
		}

		if (n < 1000) {
			return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " and " : " ") + convert(n % 100);
		}

		if (n == 1000 ) {
			return "One Thousand";
		}

		return convert(n / 100000) + "Lakh" + ((n % 100000 != 0) ? " " : ", ") + convert(n % 100000);


	}

	// function to count letters in a string avoiding spaces and hypens 
	public static int countLetters(final String s){
		int c=0;
		for(int i=0; i<s.length(); i++){

			if(Pattern.matches("[a-zA-Z]", s.substring(i,i+1))){
				// System.out.print(" m"+i+":"+s.substring(i,i+1));
				c++;
			}
			else
				continue;

		}
		return c;
	}


	public static void main(String[] args){

		String s="";

		for (int i=1; i<=1000;i++){
			s += convert(i);
			
		}
		System.out.println(s);
		System.out.println("\n Number of letters used to write numbers from 1 to 1000 in words : "+ countLetters(s));

	}
}