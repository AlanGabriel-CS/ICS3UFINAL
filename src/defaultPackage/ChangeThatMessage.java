package defaultPackage;

import java.util.Scanner;

public class ChangeThatMessage {
	public static void main(String[] args) {
		String msg = null, alternateWord, reverseWord, vowelWord = "";
		int numWords = 0;
		int numVowels = 0;
		String numInWord = "0123456789";
		boolean validInput = false;
		boolean hasNumber = false;
		Scanner input = new Scanner(System.in);
		welcome();
		while (!validInput) {
			System.out.print("\nEnter Phrase (Up to 6 Words): ");
			msg = input.nextLine().trim().replaceAll("\\s+", " ");
			System.out.println(msg);
			if (countWords(new StringBuilder(msg)) > 6) {
				System.out.println("Your phrase should have up to 6 words.");
				validInput = false;
			} else {
				hasNumber = false;
				for (int i = 0; i < msg.length(); i++) {
					if (numInWord.indexOf(msg.charAt(i)) != -1) {
						hasNumber = true;
						break;
					}
				}
				if (hasNumber) {
					System.out.println("Your phrase shouldn't have numbers.");
					validInput = false;
				} else {
					validInput = true;
				}
			}
		}
		validInput = false;
		StringBuilder msgBuilder = new StringBuilder(msg);
		upperCase(msgBuilder);
		lowerCase(msgBuilder);
		numWords = countWords(msgBuilder);
		System.out.println("NUMBER OF WORDS: " + numWords);
		numVowels = numOfVowels(msgBuilder.toString());
		System.out.println("NUMBER OF VOWELS: " + numVowels);
		vowelWord = vowelUpperCase(msgBuilder);
		System.out.println("VOWELS AS UPPERCASE: " + vowelWord);
		alternateWord = alternateLetters(msgBuilder);
		System.out.println("ALTERNATE MSG: " + alternateWord);
		reverseWord = reverseMsg(msgBuilder);
		System.out.println("REVERSED MSG: " + reverseWord);
		numWords = countSpecialWords(msgBuilder);
		System.out.println("SPECIAL WORDS (be, the): " + numWords);
		System.out.println("Word Stack: ");
		printWordStack(msgBuilder);
	}

	public static void upperCase(StringBuilder msg) {
		String upperMsg;
		upperMsg = msg.toString().toUpperCase();
		System.out.println();
		System.out.print("UPPER: " + upperMsg);
	}

	public static void lowerCase(StringBuilder msg) {
		String lowerMsg;
		lowerMsg = msg.toString().toLowerCase();
		System.out.println();
		System.out.println("LOWER: " + lowerMsg);
	}

	public static int countWords(StringBuilder msg) {
		int numWords = 0;
		char myChar;
		for (int i = 0; i < msg.length(); i++) {
			myChar = msg.charAt(i);
			if (myChar == ' ') {
				numWords++;
			}
		}
		numWords++;
		return numWords;
	}

	public static String vowelUpperCase(StringBuilder msg) {
		StringBuilder upperVowel = new StringBuilder();
		char myChar, upperChar;
		String vowels = "aeiou";
		String lowerMsg = (msg.toString()).toLowerCase();
		for (int i = 0; i < lowerMsg.length(); i++) {
			myChar = lowerMsg.charAt(i);
			if (vowels.indexOf(myChar) == -1) {
				upperVowel.append(myChar);
			} else {
				upperChar = Character.toUpperCase(myChar);
				upperVowel.append(upperChar);
			}
		}
		return upperVowel.toString();
	}

	public static int numOfVowels(String msg) {
		String lowerMsg = msg.toLowerCase();
		String vowels = "aeiou";
		int nubVowels = 0;
		char myChar;
		for (int i = 0; i < lowerMsg.length(); i++) {
			myChar = lowerMsg.charAt(i);
			if (vowels.indexOf(myChar) != -1) {
				nubVowels++;
			}
		}
		return nubVowels;
	}

	public static String alternateLetters(StringBuilder msg) {
		StringBuilder altCaseWord = new StringBuilder();
		char upOrLow;
		for (int i = 0; i < msg.length(); i++) {
			upOrLow = msg.charAt(i);
			if (i % 2 != 0) {
				altCaseWord.append(Character.toLowerCase(upOrLow));
			} else {
				altCaseWord.append(Character.toUpperCase(upOrLow));
			}
		}
		return altCaseWord.toString();
	}

	public static String reverseMsg(StringBuilder msg) {
		char reverseChar;
		int count = msg.length();
		StringBuilder reverse = new StringBuilder();
		while (count > 0) {
			reverseChar = msg.charAt(count - 1);
			reverse.append(reverseChar);
			count--;
		}
		return reverse.toString();
	}

	public static int countSpecialWords(StringBuilder msg) {
		int numWords = 0;
		int idx = 0;
		String lowMsg = (msg.toString()).toLowerCase();
		idx = lowMsg.indexOf("be");
		while (idx != -1) {
			if (idx != -1 || (idx += 2) == ' ') {
				numWords++;
				idx++;
				idx = lowMsg.indexOf("be", idx);
			}
		}
		idx = lowMsg.indexOf("the");
		while (idx != -1) {
			if (idx != -1 || (idx += 3) == ' ') {
				numWords++;
				idx++;
				idx = lowMsg.indexOf("the", idx);
			}
		}
		return numWords;
	}

	public static void printWordStack(StringBuilder msg) {
		int midBeg = msg.length() / 2 - 1;
		int midEnd = msg.length() / 2 + 1;
		int count = msg.length() / 2;
		if (msg.indexOf(" ") != -1) {
			System.out.println("More than one word.");
		} else {
			if (msg.length() % 2 == 0) {
				while (midBeg >= 0 && midEnd <= msg.length()) {
					for (int i = 0; i < count; i++) {
						System.out.print(" ");
					}
					String stack = msg.substring(midBeg, midEnd);
					System.out.println(stack);
					midBeg--;
					midEnd++;
					count--;
				}
			} else {
				System.out.println("Word must be even number of letters.");
			}
		}
	}

	public static void welcome() {
		System.out.printf(
						" ()    ()  ()     / \n" +
						"()      ()  ()   / \n" +
						" ______________ /___\n" +
						"  \\           /   /\n" +
						"   \\^^^^^^^^^/^^^/\n" +
						"    \\    ___/   /\n" +
						"     \\  (   )  /\n" +
						"      \\ (___) /\n" +
						"       \\/    /\n" +
						"        \\   /\n" +
						"         \\ /\n" +
						"         |-|\n" +
						"         |-|\n" +
						"         |-|\n" +
						"         |-|\n" +
						"         |-|\n" +
						"         / \\ \n" +
						"        /; ;\\ \n" +
						"    ============= ");
	}

}
