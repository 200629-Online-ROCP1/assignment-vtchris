package com.revature.eval.java.core;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {
	
	public static void main(String[] args) {
		EvaluationService es = new EvaluationService();
				
		
		System.out.println(es.getScrabbleScore("cabbage"));
		System.out.println(es.cleanPhoneNumber("1-800-222-5353"));
		System.out.println(es.printMegaBytesAndKiloBytes(2500));
		System.out.println(es.areEqualByThreeDecimalPlaces(3.0, 3.0));
		System.out.println(EvaluationService.SpeedConverter.printConversion(1.5));
		System.out.println(es.wordCount("One Fish Two Fish"));
		System.out.println(es.wordCount("one,\ntwo,\nthree"));
		System.out.println(es.isArmstrongNumber(123));
		System.out.println(es.isArmstrongNumber(153));
		System.out.println(es.calculatePrimeFactorsOf(8));
		System.out.println(es.calculateNthPrime(100));
		System.out.println(es.isPangram("the quick brown fox jumps over the lazy dog"));
		
	}
	/**
	 * 1.A Speed Converter - Convert to MilesPerHour
	 * 
	 * Write a method called toMilesPerHour that has 1 parameter of type double with
	 * the name kilometersPerHour. This method needs to return the rounded value of
	 * the calculation of type long.
	 * 
	 * If the parameter kilometersPerHour is less than 0, the method toMilesPerHour
	 * needs to return -1 to indicate an invalid value.
	 * 
	 * Otherwise if it is positive, calculate the value of miles per hour, round it
	 * and return it. For conversion and rounding use Math.round().
	 */
	static class SpeedConverter {

		public static long toMilesPerHour(double kph) {
			if(kph > 0) {
				return (long) Math.round(kph * .62);
			}else {
				return -1;
			}
		}

		/**
		 * 1.B Speed Converter - Print Conversion
		 * 
		 * Write another method called printConversion with 1 parameter of type double
		 * with the name kilometersPerHour. This method needs to return a String and
		 * needs to calculate milesPerHour from the kilometersPerHour parameter.
		 * 
		 * The String should print in the format: "XX km/h = YY mi/h"
		 * 
		 * XX represents the original value kilometersPerHour. YY represents the rounded
		 * milesPerHour from the kilometersPerHour parameter.
		 * 
		 * If the parameter kilometersPerHour is < 0, then print the text "Invalid
		 * Value"
		 */
		public static String printConversion(double kph) {
			long mph = EvaluationService.SpeedConverter.toMilesPerHour(kph);
			
			if(mph < 0) {
				return "Invalid Value";
			}else {
				return  kph + " km/h = " + mph + " mi/h";
			}
			
		}
	}

	/**
	 * 2. MegaBytes and KiloBytes
	 * 
	 * Write a method called printMegaBytesAndKiloBytes that has 1 parameter of type
	 * int with the name kiloBytes.
	 * 
	 * The method should return a String and it needs to calculate the megabytes and
	 * remaining kilobytes from the kilobytes parameter.
	 * 
	 * Then it needs to print a message in the format "XX KB = YY MB and ZZ KB".
	 * 
	 * XX represents the original value kiloBytes. YY represents the calculated
	 * megabytes. ZZ represents the calculated remaining kilobytes.
	 * 
	 * For examples, when the parameter kiloBytes is 2500 it needs to print "2500 KB
	 * = 2 MB and 452 KB"
	 * 
	 * If the parameter kiloBytes is less than 0 then print the text "Invalid
	 * Value".
	 */
	public String printMegaBytesAndKiloBytes(int kb) {
		
		if(kb < 0) {
			return "Invalid Value";
		}
		int MB = kb/1024;
		int KB = 0;
		if(kb - (MB * 1024) > 0) {
			KB = kb - (MB * 1024);
		}
		
		return kb + " KB = " + MB + " MB and " + KB + " KB";		
	}

	/**
	 * 3. Barking Dog
	 * 
	 * We have a dog that loves to bark. We need to wake up if the dog is barking at
	 * night!
	 * 
	 * Write a method shouldWakeUp that has 2 parameters.
	 * 
	 * 1st parameter should be of type boolean and be named "barking". It represents
	 * if our dog is currently barking. 2nd parameter represents the hour of the day
	 * and is of type int with the name hourOfDay and has a valid range of 0-23.
	 * 
	 * We have to wake up if the dog is barking before 8 or after 22 hours, so in
	 * that case return true.
	 * 
	 * In all other cases return false.
	 * 
	 * If the hourOfDay parameter is less than 0 or greater than 23, return false.
	 */
	public boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
		if(isBarking && (hourOfDay < 8 || hourOfDay >= 22)) {
			return true;
		}else {
			return false;
		}
		
	}

	/**
	 * 4. DecimalComparator
	 * 
	 * Write a method areEqualByThreeDecimalPlaces with two parameters of type
	 * double.
	 * 
	 * The method should return boolean and it needs to return true if two double
	 * numbers are the same up to three decimal places.
	 * 
	 * Otherwise, return false;
	 */
	public boolean areEqualByThreeDecimalPlaces(double firstNum, double secondNum) {
				
		firstNum = this.truncateDouble(firstNum,3);
		secondNum = this.truncateDouble(secondNum,3);
		
		return firstNum == secondNum;
	
	}
	private double truncateDouble(double num, int decimalPlaces) {
		double truncated = 0; 
		
		try {
			truncated = Double.valueOf(String.valueOf(num).substring(0,String.valueOf(num).indexOf(".")+decimalPlaces+1));
		}catch (IndexOutOfBoundsException e){
			truncated = Double.valueOf(String.valueOf(num));
		}		
		 return truncated;
	}

	/**
	 * 5. Teen Number Checker
	 * 
	 * We'll say that a number is "teen" if it is in the range 13 -19 (inclusive).
	 * Write a method named hasTeen with 3 parameters of type int.
	 * 
	 * The method should return boolean and it needs to return true if ONE of the
	 * parameters is in range 13(inclusive) - 19 (inclusive). Otherwise return
	 * false.
	 */
	static class TeenNumberChecker {

		public static boolean hasTeen(int x, int y, int z) {			
			return (isTeen(x) || isTeen(y) || isTeen(z));
		}

		// We can initialize isTeen method first
		// Then pass the parameter to hasTeen method

		public static boolean isTeen(int number) {
			return number >= 13 && number < 20; 
			
		}
	}

	/**
	 * 6. Minutes To Years and Days Calculator
	 * 
	 * Write a method printYearsAndDays with parameter of type long named minutes.
	 * The method should not return anything (void) and it needs to calculate the
	 * years and days from the minutes parameter.
	 * 
	 * If the parameter is less than 0, print text "Invalid Value".
	 * 
	 * Otherwise, if the parameter is valid then it needs to print a message in the
	 * format "XX min = YY y and ZZ d".
	 * 
	 * XX represents the original value minutes. YY represents the calculated years.
	 * ZZ represents the calculated days.
	 */
	public String printYearsAndDays(long minutes) {
		if(minutes < 0) {
			return "Invalid Value";
		}
		int years = (int)Math.floor(minutes/525_600);
		int days = (int)Math.floor((minutes - (years * 525_600))/1440);
		
		return minutes + " min = " + years + " y and " + days + " d";
	}
	/**
	 * 7. Number In Word
	 * 
	 * Write a method called printNumberInWord. The method has one parameter number
	 * which is the whole number. The method needs to print "ZERO", "ONE", "TWO",
	 * ... "NINE", "OTHER" if the int parameter number is 0, 1, 2, .... 9 or other
	 * for any other number including negative numbers. You can use if-else
	 * statement or switch statement whatever is easier for you.
	 */
	public String printNumberInWord(int number) {
		String strNbr = "";
		switch(number) {
			case 0:
				strNbr = "ZERO";
				break;
			case 1:
				strNbr = "ONE";
				break;
			case 2:
				strNbr = "TWO";
				break;
			case 3:
				strNbr = "THREE";
				break;
			case 4:
				strNbr = "FOUR";
				break;
			case 5:
				strNbr = "FIVE";
				break;
			case 6:
				strNbr = "SIX";
				break;
			case 7:
				strNbr = "SEVEN";
				break;
			case 8:
				strNbr = "EIGHT";
				break;
			case 9:
				strNbr = "NINE";
				break;
			default:
				strNbr = "other";
		}
		return strNbr;
	}

	/**
	 * 8. Greatest Common Divisor
	 * 
	 * Write a method named getGreatestCommonDivisor with two parameters of type int
	 * named first and second.
	 * 
	 * If one of the parameters is < 10, the method should return -1 to indicate an
	 * invalid value. The method should return the greatest common divisor of the
	 * two numbers (int).
	 * 
	 * The greatest common divisor is the largest positive integer that can fully
	 * divide each of the integers (i.e. without leaving a remainder).
	 * 
	 * For example 12 and 30: 12 can be divided by 1, 2, 3, 4, 6, 12 30 can be
	 * divided by 1, 2, 3, 5, 6, 10, 15, 30
	 * 
	 * The greatest common divisor is 6 since both 12 and 30 can be divided by 6,
	 * and there is no resulting remainder.
	 */
	public int getGreatestCommonDivisor(int first, int second) {
		if(first < 10 || second < 10) {
			return -1;
		}
		
		while(second > 0) {
			int x = second;
			second = first % second;
			first = x;
		}
		return first;
	}

	/**
	 * 9. First and Last Digit Sum
	 * 
	 * Write a method named sumFirstAndLastDigit with one parameter of type int
	 * called number.
	 * 
	 * The method needs to find the first and the last digit of the parameter number
	 * passed to the method, using a loop and return the sum of the first and the
	 * last digit of that number.
	 * 
	 * If the number is negative then the method needs to return -1 to indicate an
	 * invalid value.
	 */
	public int sumFirstAndLastDigit(int num) {
		if(num < 0) {
			return -1;
		}
		int num1 = Integer.parseInt(Integer.toString(num).substring(0,1));
		int num2 = num % 10;
		
		return num1+num2;
	}

	/**
	 * 10. Reverse String
	 * 
	 * Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 */
	public String reverse(String string) {
		String reversed = "";
		for(int i=string.length()-1;i>=0;i--) {
			reversed += string.charAt(i);
		}
 		return reversed;
	}

	/**
	 * 11. Acronyms
	 * 
	 * Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 */
	public String acronym(String phrase) {
		String acronym = "";
		String[] strings = phrase.split(" ");
				
		for(int i=0;i<strings.length;i++) {
			acronym += strings[i].charAt(0);
		}
		
		return acronym;
	}

	/**
	 * 12. Triangles
	 * 
	 * Determine if a triangle is equilateral, isosceles, or scalene. An equilateral
	 * triangle has all three sides the same length. An isosceles triangle has at
	 * least two sides the same length.
	 * 
	 * (It is sometimes specified as having exactly two sides the same length, but
	 * for the purposes of this exercise we'll say at least two.) A scalene triangle
	 * has all sides of different lengths.
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			return this.sideOne == this.sideTwo  && this.sideOne == this.sideThree;
		}

		public boolean isIsosceles() {
			return this.sideOne == this.sideTwo  || this.sideOne == this.sideThree || this.sideTwo == this.sideThree;
		}

		public boolean isScalene() {
			return this.sideOne != this.sideTwo  || this.sideOne != this.sideThree || this.sideTwo != this.sideThree;
		}

	}

	/**
	 * 13. Scrabble Score
	 * 
	 * Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 */
	public int getScrabbleScore(String string) {
		int score = 0;
		
		for(int i=0;i<string.length();i++) {
			score += letterScore(string.charAt(i));
		}
		return score;
	}
	
	private static int letterScore(char l) {
		
		switch(l) {
		case 'd':
		case 'g':
			return 2;
		case 'b':
		case 'c':
		case 'm':
		case 'p':
			return 3;
		case 'f':
		case 'h':
		case 'v':
		case 'w':
		case 'y':
			return 4;
		case 'k':
			return 5;
		case 'j':
		case 'x':
			return 8;
		case 'q':
		case 'z':
			return 10;
		default:
			return 1;
		}
	}

	/**
	 * 14. Clean the Phone Number
	 * 
	 * Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		string = string.replaceAll("[^0-9]", "");
		
		if(string.charAt(0) == '1') {	
			string = string.substring(1);
		}
		if(string.length() != 10) {
			throw new IllegalArgumentException();
		}else {
			return string;
		}
		
	}

	/**
	 * 15. Recurring Word Counter
	 * 
	 * Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 */
	public Map<String, Integer> wordCount(String string) {
		string = string.replace("\n", "");
		string = string.replace(",", " ");
	
		String[] words = string.toLowerCase().split(" ");
		Map<String, Integer> wordCounts = new HashMap<String, Integer>();
		
		for(int i = 0;i<words.length;i++) {
			// Determine if word is already in map
			Integer count = wordCounts.get(words[i]);
			if(count == null) {
				// If word is not there, add it
				wordCounts.put(words[i], 1);
			}else {
				// If word is there, increment the count
				wordCounts.put(words[i], count+1);
			}			
		}
		
		return wordCounts;
	}

	/**
	 * 16. Armstrong Number
	 * 
	 * An Armstrong number is a number that is the sum of its own digits each raised
	 * to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 */
	public boolean isArmstrongNumber(int input) {
		String[] digits = String.valueOf(input).split("");
		int pow = digits.length;
		int result = 0;
		
		for(int i=0;i<digits.length;i++) {
			result += Math.pow(Integer.parseInt(digits[i]), pow);
		}
				
		return input == result;
	}

	/**
	 * 17. Prime Factors
	 * 
	 * Compute the prime factors of a given natural number. A prime number is only
	 * evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> factors = new ArrayList<Long>();
		System.out.println("Primes follow");
		for(int i = 2;i<=l;i++) {
			while(l % i == 0) {
				l /= i;
				factors.add((long)i);				
			}
		}
		
		return factors;
	}

	/**
	 * 18. Calculate Nth Prime
	 * 
	 * Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 */
	public int calculateNthPrime(int k) {
		if(k == 0) {
			throw new IllegalArgumentException();
		}
		int count = 0;
		int i = 1;
		while(count < k) {	
			++i;
			if(primeChecker(i) == true) {
				count++;
			}		
		}
		return i;
		
	}

	public static boolean primeChecker(long n) {		
		for(int i = 2;i<n;i++) {
			while(n % i == 0) {
				return false;				
			}
		}
		return true;
	}
	
	/**
	 * 19. Pangram
	 * 
	 * Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		string = string.replace(" ", "");
		String[] letters = string.toLowerCase().split("");
		Map<String,Integer> uniqueLetters = new HashMap<String,Integer>();
		
		for(int i = 0;i<letters.length;i++) {
			// Determine if letter is already in map
			if(uniqueLetters.get(letters[i]) == null) {
				// If letter is not there, add it
				uniqueLetters.put(letters[i], 1);
			}
			
		}		
		return uniqueLetters.size()  == 26;
	}

	/**
	 * 20. Sum of Multiples 
	 * 
	 * Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		return 0;
	}
	
	/**
	 * 21. Three Magic Numbers
	 * 
	 * You work at a casino in Las Vegas.  Your job is to program a slot machine to
	 * return 3 random numbers using the java.util.Random class.
	 * 
	 * Write a method to return an int array of 3 random numbers between 1 - 100.
	 * Generate the 3 random numbers (1 - 100 inclusive) using the java.util.Random class.
	 */
	
	public int[] threeLuckyNumbers() {
		int[] numbers = { randomNum(0,100), randomNum(0,100), randomNum(0,100)};
		
		return numbers;
	}
	
	public int randomNum(int low, int high) {
		return (int)(((Math.random() * (high - low)) + low)+1);
	}
	
	/*
	 * 22. Easy Guessing Game
	 * 
	 * Create a program to generate a number between the given range:
	 * int x = minimum
	 * iny y = maximum (inclusive)
	 * 
	 * You must use the Math.random class to generate a random number between x and y.
	 */
	
	public int guessingGame(int x, int y) {
		return (int)(Math.random() * y) + x;
	}
}
