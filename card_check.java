import java.util.Scanner;
class card_check{
    /** Return true if the card number is valid */
    public static boolean isValid (long number){
        boolean cardValid =
			(getSize(number) >= 13 && getSize(number) <= 16) && ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0) && (prefixMatched(number, 5) || prefixMatched(number, 6) || prefixMatched(number, 37) || prefixMatched(number, 4));
		return cardValid;
    };
    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number){
        String individualNumber = number + "";
        int total = 0;
        for (int i = getSize(number) - 2; i >= 0; i -=2){
            total += getDigit(Integer.parseInt(individualNumber.charAt(i)+ "") * 2);
        };
        return total;
    };
    
  /** Return this number if it is a single digit, otherwise,
   * return the sum of the two digits */
  public static int getDigit(int number){
    if(number >= 10){
        return ((number / 10) + (number % 10));
    } 
    else{
        return number;
    }
  };

  /** Return sum of odd-place digits in number */
  public static int sumOfOddPlace(long number){
    String individualNumber = number + "";
    int total = 0;
    for(int i = getSize(number) - 1; i >=0; i -=2){
        total += Integer.parseInt(individualNumber.charAt(i)+ "");
    }
    return total;
  };

  /** Return true if the number d is a prefix for number */
  public static boolean prefixMatched(long number, int d){
    return getPrefix(number, getSize(d))==d;
  };

  /** Return the number of digits in d */
  public static int getSize(long d){
    String numberCheck = d + "";
    return numberCheck.length();
  };

  /** Return the first k number of digits from number. If the
   * number of digits in number is less than k, return number. */
  public static long getPrefix(long number, int k){
    if(getSize(number) > k){
        String num = number + "";
        return Long.parseLong(num.substring(0,k));
    }
    return number;
  };
  public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter a credit card number as a long integer: ");
      long number = input.nextLong();
      System.out.println(number + " is " + (isValid(number)?"valid":"invalid")); 
      input.close();
  }
};