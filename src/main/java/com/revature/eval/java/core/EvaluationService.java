package com.revature.eval.java.core;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// method separates input phrase into an array of individual words
		// then adds the first letter (character at index 0) of each
		// to the newAcronym variable
		String[] words = phrase.split(" |-");
		String newAcronym = new String("");
		for (int i = 0; i < words.length; i++)
		{
			newAcronym = newAcronym + words[i].charAt(0);
		}
		return newAcronym.toUpperCase();
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
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
			// triangle is equilateral only if ALL 3 sides are equal
			// if 1 == 2 and 2 == 3, 1 == 3 and it triangle is equilateral
			if (getSideOne() == getSideTwo() && getSideTwo() == getSideThree() ) {
				return true;
			}
			else {
			return false;
			}
		}

		public boolean isIsosceles() {
			// triangle is isosceles if two or more sides are equal
			// any set of two sides will qualify so all combinations must be checked
			if (getSideOne() == getSideTwo() || getSideTwo() == getSideThree() ||
					getSideOne() == getSideThree() ) {
				return true;
			}
			else {
			return false;
			}
		}

		public boolean isScalene() {
			// triangle is scalene if no sides are equal to another
			// if any two sides are equal the triangle is not scalene, return false
			if (getSideOne() == getSideTwo() || getSideTwo() == getSideThree() ||
					getSideOne() == getSideThree() ) {
				return false;
			}
			else {
			return true;
			}
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		
		// create a map to contain letter/score pairs
		Map<String, Integer> letterScore = new HashMap<String, Integer>();
		// add letters scoring 1 point
		letterScore.put("a", 1);
		letterScore.put("e", 1);
		letterScore.put("i", 1);
		letterScore.put("o", 1);
		letterScore.put("u", 1);
		letterScore.put("l", 1);
		letterScore.put("n", 1);
		letterScore.put("r", 1);
		letterScore.put("s", 1);
		letterScore.put("t", 1);
		
		// add letters scoring 2
		letterScore.put("d", 2);
		letterScore.put("g", 2);
		
		// etc. for all remaining letters
		letterScore.put("b", 3);
		letterScore.put("c", 3);
		letterScore.put("m", 3);
		letterScore.put("p", 3);
		
		letterScore.put("f", 4);
		letterScore.put("h", 4);
		letterScore.put("v", 4);
		letterScore.put("w", 4);
		letterScore.put("y", 4);
		
		letterScore.put("k", 5);
		
		letterScore.put("j", 8);
		letterScore.put("x", 8);
		
		letterScore.put("q", 10);
		letterScore.put("z", 10);

		// convert the input word into an array of single character strings
		String lower = string.toLowerCase();
		String[] word = lower.split("");
		// provide a variable to contain the total score of the word
		int wordScore = 0;
		
		// for each letter in the word, add the score to the wordScore
		for (int letter = 0; letter < word.length; letter++)
		{
			int score = letterScore.get(word[letter]);
			wordScore = wordScore + score;
		}
		// return total score
		return wordScore;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
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
		
		// first remove white space
		String noWhiteSpace = string.replaceAll("\\s+", "");
		
		// now remove punctuation
		String noPunctuation = noWhiteSpace.replaceAll("[^a-zA-Z0-9]", "");
		
		// if more than 10 chars it is not a valid phone number
		if (noPunctuation.length() >= 11) {
			throw new IllegalArgumentException("phone number was too long");
		}
		
		// if any non-number characters exist the entire number is invalid
		for (int i = 0; i < noPunctuation.length(); i++) {
            if (!Character.isDigit(noPunctuation.charAt(i) ) ) {
            	throw new IllegalArgumentException("string contained non-numeric characters");
            }
		}
		
		// if none of above problems exist string should now be cleaned
		return noPunctuation;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		
		// first split the input into individual words
		String[] words = string.split("[^\\w']+");
		// create map to store results
		Map<String, Integer> wordTallies = new HashMap<String, Integer>();
		
		for (int i = 0; i < words.length; i++) {
			if (wordTallies.containsKey(words[i]) ) {
				wordTallies.put(words[i], wordTallies.get(words[i]) + 1) ;
			} else {
				wordTallies.put(words[i], 1);
			}
		}
		
		return wordTallies;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	
	//assume sorting based off of numbers
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			
			//should return the index of the number input by caller
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		
		// create variable for ay to append to end of words
		// and split input into individual words
		// create result string to recreate final pig Latin phrase
		String ay = "ay";
		String result = "";
		String[] words = string.split(" ");
		
		// for each word input, if the first letter is a vowel, add ay to the end
		// start by making an array of vowels for comparison
		String[] vowels = {"a", "e", "i", "o", "u"};
		// and array for consonants (y is counted as one for this)
		String[] consonants = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v",
				"w", "x", "y", "z"};
		for (int i = 0; i < words.length; i++) {
				String firstLetter = words[i].substring(0, 1);
				String firstTwoLetters = words[i].substring(0, 2);
				String firstThreeLetters = words[i].substring(0, 3);
			
				for (int j = 0; j < vowels.length; j++) {
					// if first letter is a vowel add ay
					if (firstLetter.equals(vowels[j])) {
						words[i] = words[i].concat(ay);
					}	
				}
				
				// if first two letters are th (or qu) move them to end and add ay
				if (firstTwoLetters.equals("th") || firstTwoLetters.equals("qu")) {
					String temp = words[i].substring(0, 2);
					words[i] = words[i].substring(2);
					words[i] = words[i].concat(temp).concat(ay);
				} else if (firstThreeLetters.equals("sch")) {
					String temp = words[i].substring(0, 3);
					words[i] = words[i].substring(3);
					words[i] = words[i].concat(temp).concat(ay);
					// else the first letter is a regular consonant sound
				} else {
				for (int j = 0; j < consonants.length; j++) {
					// if first letter is a consonant move to end and add ay
					if (firstLetter.equals(consonants[j])) {
						String temp = words[i].substring(0, 1);
						words[i] = words[i].substring(1);
						words[i] = words[i].concat(temp).concat(ay);
					}	
				}
				}
		}
		result = result.concat(words[0]);

		if (words.length > 1) {
			for (int i = 1; i < words.length; i++) {
				result = result.concat(" ").concat(words[i]);
			}
		}
		
		return result;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// take input and convert it into an array of single digit strings
		String numberInput = String.valueOf(input);
		String[] number = numberInput.split("");
		
		// total variable to be compared with input later
	    int total = 0;
		
	    // for each digit, raise it to the power equal to the number of digits in input and add
	    // result to the total
		for (int i = 0; i < number.length; i++)
		{
			int digit = Integer.parseInt(number[i]);
			double power = Math.pow(digit, number.length);
			total = total + (int)power;
		}
		
		// if total of each digit raised to the number of
		// digits is the same as input, Armstrong# = true
		if (total == input) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		
		List<Long> primeFactors = new ArrayList<>();
		Long factor = 2L;
		Long input = l;
		while (input != 1) {
			if (input % factor == 0) {
				input = input / factor;
				primeFactors.add(factor);
			} else {
				factor++;
			}
		}
		return primeFactors;
		
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			return null;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		
		// if input is 0 or less the number is invalid
		if (i <= 0) {
			throw new IllegalArgumentException("0 and less cannot be prime!");
		}
		
		int nth = i;
		
		// one number, 2, is assumed to be prime
		int primesFound = 1;
		// current number being evaluated
		int current = 3;
		
		// create ArrayList to contain prime numbers, add first/assumed prime 2
		ArrayList<Integer> primeList = new ArrayList<>();
		primeList.add(2);
		
		while (primesFound < nth) {
			int primesThisLoop = 0;
			for(int prime:primeList) {
				if (current % prime == 0)	{
					current++;
				} else {
					primesThisLoop++;
				}
			}
			if (primesThisLoop == primeList.size() ) {
				primeList.add(current);
				primesFound++;
				current++;
			}
		}
		
		return primeList.get(primeList.size() - 1);
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			
			// first remove spaces from input
			String uncoded = string.replaceAll("\\s", "");
			uncoded = uncoded.toLowerCase();
			String noPunctuation = uncoded.replaceAll("[^a-zA-Z0-9]", "");
			String[] letters = noPunctuation.split("");		
			
			Map<String, String> encoding = new HashMap<String, String>();
			// map links each letter to its opposite according to cipher
			encoding.put("a", "z");
			encoding.put("b", "y");
			encoding.put("c", "x");
			encoding.put("d", "w");
			encoding.put("e", "v");
			encoding.put("f", "u");
			encoding.put("g", "t");
			encoding.put("h", "s");
			encoding.put("i", "r");
			encoding.put("j", "q");
			encoding.put("k", "p");
			encoding.put("l", "o");
			encoding.put("m", "n");
			encoding.put("n", "m");
			encoding.put("o", "l");
			encoding.put("p", "k");
			encoding.put("q", "j");
			encoding.put("r", "i");
			encoding.put("s", "h");
			encoding.put("t", "g");
			encoding.put("u", "f");
			encoding.put("v", "e");
			encoding.put("w", "d");
			encoding.put("x", "c");
			encoding.put("y", "b");
			encoding.put("z", "a");
			
			// make variable to reassemble the string
			String output = "";
						
			for (int i = 0; i < letters.length; i++) {
				if (Character.isDigit(letters[i].charAt(0) ) ) {
					output = output + (letters[i]);
					} else if (! Character.isDigit(letters[i].charAt(0) ) ) {
					letters[i] = encoding.get(letters[i]);
					output = output + (letters[i]);
				}
				if ((i + 1) % 5 == 0 && i != 0 && i + 1 != letters.length) {
					output = output + (" ");
				}
			}
			return output;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// first remove spaces from input
			String coded = string.replaceAll("\\s", "");
			String[] codeLetters = coded.split("");
				
			Map<String, String> decoding = new HashMap<String, String>();
			// map links each letter to its opposite according to cipher
			decoding.put("a", "z");
			decoding.put("b", "y");
			decoding.put("c", "x");
			decoding.put("d", "w");
			decoding.put("e", "v");
			decoding.put("f", "u");
			decoding.put("g", "t");
			decoding.put("h", "s");
			decoding.put("i", "r");
			decoding.put("j", "q");
			decoding.put("k", "p");
			decoding.put("l", "o");
			decoding.put("m", "n");
			decoding.put("n", "m");
			decoding.put("o", "l");
			decoding.put("p", "k");
			decoding.put("q", "j");
			decoding.put("r", "i");
			decoding.put("s", "h");
			decoding.put("t", "g");
			decoding.put("u", "f");
			decoding.put("v", "e");
			decoding.put("w", "d");
			decoding.put("x", "c");
			decoding.put("y", "b");
			decoding.put("z", "a");
			
			// make variable to reassemble the string
			String output = "";
			
			for (int i = 0; i < codeLetters.length; i++) {
				if (! Character.isDigit(codeLetters[i].charAt(0) ) ) {
					codeLetters[i] = decoding.get(codeLetters[i]);
					output = output.concat(codeLetters[i]); 
				} else {
					output = output.concat(codeLetters[i]);
				}
			}
			return output;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		String isbn = string.replaceAll("[\\s\\-()]", "");
		String[] splitIsbn = isbn.split("");
		int total = 0;
		
		// if any of the first 9 characters aren't a digit, invalid
		for (int i = 0; i < splitIsbn.length - 1; i++) {
			if (!Character.isDigit( (splitIsbn[i].charAt(0) ) ) ) {
				return false;
			}
		}
		
		// if last character isn't a digit or X, invalid
		if (!Character.isDigit( (splitIsbn[9].charAt(0) ) ) ) {
			if (!splitIsbn[9].toUpperCase().equals("X")) {
				return false;
				
			// if it is X replace with 10
			} else {
			total = total + (10 * 1);
			}
			
			// if last character is a digit compute as normal
		} else {
			total = total + (Integer.parseInt(splitIsbn[9]) * 1);
		}
		
		total = total + (Integer.parseInt(splitIsbn[0]) * 10);
		total = total + (Integer.parseInt(splitIsbn[1]) * 9);
		total = total + (Integer.parseInt(splitIsbn[2]) * 8);
		total = total + (Integer.parseInt(splitIsbn[3]) * 7);
		total = total + (Integer.parseInt(splitIsbn[4]) * 6);
		total = total + (Integer.parseInt(splitIsbn[5]) * 5);
		total = total + (Integer.parseInt(splitIsbn[6]) * 4);
		total = total + (Integer.parseInt(splitIsbn[7]) * 3);
		total = total + (Integer.parseInt(splitIsbn[8]) * 2);
		
		
		if (total % 11 == 0) {
			return true;
		} else {		
			return false;
		}
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		
		String[] input = string.split("");
			
			Map<String, Boolean> alphabetChecklist = new HashMap<String, Boolean>();
			alphabetChecklist.put("a", false);
			alphabetChecklist.put("b", false);
			alphabetChecklist.put("c", false);
			alphabetChecklist.put("d", false);
			alphabetChecklist.put("e", false);
			alphabetChecklist.put("f", false);
			alphabetChecklist.put("g", false);
			alphabetChecklist.put("h", false);
			alphabetChecklist.put("i", false);
			alphabetChecklist.put("j", false);
			alphabetChecklist.put("k", false);
			alphabetChecklist.put("l", false);
			alphabetChecklist.put("m", false);
			alphabetChecklist.put("n", false);
			alphabetChecklist.put("o", false);
			alphabetChecklist.put("p", false);
			alphabetChecklist.put("q", false);
			alphabetChecklist.put("r", false);
			alphabetChecklist.put("s", false);
			alphabetChecklist.put("t", false);
			alphabetChecklist.put("u", false);
			alphabetChecklist.put("v", false);
			alphabetChecklist.put("w", false);
			alphabetChecklist.put("x", false);
			alphabetChecklist.put("y", false);
			alphabetChecklist.put("z", false);		
		
		for (int i = 0; i < input.length; i++) {
			if (alphabetChecklist.containsKey(input[i]) ) {
				alphabetChecklist.put(input[i], true);
			}	
		}
		
		for(String key: alphabetChecklist.keySet()) {
			if(alphabetChecklist.get(key) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
        //In case,time not included
        if(given instanceof LocalDate) {
            LocalDateTime time = LocalDateTime.of((LocalDate) given, LocalTime.MIN);
            return time.plus(Duration.ofSeconds(1000000000l));
        }
        //if time is included
        LocalDateTime time = LocalDateTime.from(given);
        return time.plus(Duration.ofSeconds(1000000000l));
    }
	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		return 0;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// first remove white space
		String cleanedString = string.replaceAll("\\s+", "");
		// provide integer to hold results of test
		int runningTotal = 0;
		
		// strings 1 length or less are invalid
		if (cleanedString.length() <= 1) {
			return false;
		}
		
		for (int i = 0; i < cleanedString.length(); i++) {

			// if any non-number characters exist the entire number is invalid
            if (!Character.isDigit(cleanedString.charAt(i) ) ) {
                return false;
            }
		}
		
		int rightCharIndex = cleanedString.length() - 1;
		
		for (int i = rightCharIndex - 1; i >= 0; i -= 2) {
			int current =  Integer.parseInt(cleanedString.substring(i, i + 1) );
			if (current * 2 < 10) {
				current = current * 2;
			} else {
				current = (current * 2) - 9;
			}
			runningTotal = runningTotal + current;
		}
		
		for (int i = rightCharIndex; i >= 0; i -= 2) {
			int current =  Integer.parseInt(cleanedString.substring(i, i + 1) );
			runningTotal = runningTotal + current;
		}
		
		// cleanedString.substring(i, i + 1)
		if (runningTotal % 10 == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		return 0;
	}

}
