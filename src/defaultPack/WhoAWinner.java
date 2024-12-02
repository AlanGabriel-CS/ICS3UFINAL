package defaultPack;
import javax.swing.JOptionPane;
public class WhoAWinner {
	public static void main(String[] args) {
		boolean valid = false;
		int numOfPlayers = 0;
		menu();
		// Number of players
		while (!valid) {
			try {
				numOfPlayers = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of players: ").trim());
				if (numOfPlayers == 6 || numOfPlayers == 7) {
					JOptionPane.showMessageDialog(null, "Players: " + numOfPlayers);
					System.out.println("NUMBER OF PLAYERS:" + numOfPlayers);
					valid = true;
				} else {
					JOptionPane.showMessageDialog(null, "Only 6 or 7 players, try again.");
					valid = false;
				}
			} catch (NumberFormatException players) {
				JOptionPane.showMessageDialog(null, "Your amount is not a valid input!");
				valid = false;
			}
		}
		String enteredPlayers[] = new String[numOfPlayers];
		int playerWins[] = new int[numOfPlayers];
		input(enteredPlayers, playerWins);
		// graph and getting average from return value
		double avrg = getGraph(enteredPlayers, numOfPlayers, playerWins);
		// printed wins
		printWins(playerWins);
		// highest value
		int highestVal = maxValue(playerWins);
		System.out.println("Most Wins: " + highestVal);
		// lowest value
		int lowestVal = minValue(playerWins);
		System.out.println("Fewest Wins: " + lowestVal);
		// lowest to highest
		int sortLow[] = sortWinsLow(playerWins);
		System.out.print("Sorted Wins: ");
		for (int i = 0; i < sortLow.length; i++) {
			if (i < sortLow.length - 1) {
				System.out.print(sortLow[i] + ", ");
			} else {
				System.out.print(sortLow[i]);
			}
		}
		System.out.println();
		// highest to lowest
		int sortHigh[] = sortWinsHigh(playerWins);
		System.out.print("Sorted Wins Reverse: ");
		for (int i = 0; i < sortHigh.length; i++) {
			if (i < sortHigh.length - 1) {
				System.out.print(sortHigh[i] + ", ");
			} else {
				System.out.print(sortHigh[i]);
			}
		}
		System.out.println();
		// average
		System.out.printf("%s %-1.1f%n", "Average:", avrg);
		// median
		double median = median(playerWins, sortLow);
		System.out.printf("%s %-1.1f%n", "Median:", median);
		// longest name
		String longestName = longestName(enteredPlayers);
		System.out.println("Longest Name: " + longestName);
	}
	public static void menu() {
		System.out.println("   .-=========-. " + "\n   \\'-=======-'/ " + "\n   _|   .=.   |_ " + "\n  ((|  {{1}}  |)) "
				+ "\n   \\|   /|\\   |/ " + "\n    \\__ '`' __/ " + "\n      _`) (`_ " + "\n    _/_______\\_ "
				+ "\n   /___________\\" + "\n\n WHO IS THE WINNER?");
	}
	public static void input(String enteredPlayers[], int playerWins[]) {
		boolean valid = false;
		valid = false;
		// Mr. Miller input
		enteredPlayers[0] = "Mr. Miller";
		JOptionPane.showMessageDialog(null, "Player #" + 1 + ": " + enteredPlayers[0]);
		System.out.println("Player #" + 1 + ": " + enteredPlayers[0]);
		// Number of wins for Mr. Miller
		while (!valid) {
			try {
				playerWins[0] = Integer.parseInt(JOptionPane.showInputDialog("Enter in Player#" + 1 + " Wins:"));
				JOptionPane.showMessageDialog(null, "Player #" + 1 + " Wins: " + playerWins[0]);
				System.out.println("Player #" + 1 + " Wins: " + playerWins[0]);
				valid = true;
			} catch (NumberFormatException players) {
				JOptionPane.showMessageDialog(null, "Your amount is not a valid input");
				valid = false;
			}
		}
		valid = false;
		// Name and wins of the other players
		for (int i = 1; i < enteredPlayers.length; i++) {
			while (!valid) {
				try {
					enteredPlayers[i] = (JOptionPane.showInputDialog("Enter in Player #" + (i + 1) + ":")).trim();
					if (!enteredPlayers[i].equals("")) {
						JOptionPane.showMessageDialog(null, "Player #" + (i + 1) + ": " + enteredPlayers[i]);
						System.out.println("Player #" + (i + 1) + ": " + enteredPlayers[i]);
						valid = true;
					} else {
						JOptionPane.showMessageDialog(null, "Please enter a valid input");
						valid = false;
					}
				} catch (NumberFormatException players) {
					JOptionPane.showMessageDialog(null, "Please enter a valid input");
					valid = false;
				}
			}
			valid = false;
			while (!valid) {
				try {
					playerWins[i] = Integer
							.parseInt(JOptionPane.showInputDialog("Enter in Player#" + (i + 1) + " Wins:").trim());
					JOptionPane.showMessageDialog(null, "Player #" + (i + 1) + " Wins: " + playerWins[i]);
					System.out.println("Player #" + (i + 1) + " Wins: " + playerWins[i]);
					valid = true;
				} catch (NumberFormatException players) {
					JOptionPane.showMessageDialog(null, "Your amount is not a valid input");
					valid = false;
				}
			}
			valid = false;
		}
	}
	public static double getGraph(String enteredPlayers[], int numOfPlayers, int playerWins[]) {
		String xNumWins = "";
		double avrg = 0.0;
		double diff = 0.0;
		int sum = 0;
		int len = enteredPlayers.length;
		// Largest name for spacing
		int big = enteredPlayers[0].length();
		for (int i = 0; i < len; i++) {
			if (enteredPlayers[i].length() > big) {
				big = enteredPlayers[i].length();
			}
		}
		// Largest number of wins for spacing
		int numWins = playerWins[0];
		for (int i = 0; i < len; i++) {
			if (playerWins[i] > numWins) {
				numWins = playerWins[i];
			}
		}
		// Headings
		System.out.println();
		System.out.printf("%" + (big + numWins + 11) + "s\n\n", "Who's a Winner");
		System.out.printf("%" + (-big - 10) + "s %" + (-numWins - 10) + "s %-15s\n", "Player", "Wins",
				"Wins above average");
		// Finding average
		for (int i = 0; i < len; i++) {
			sum += playerWins[i];
		}
		avrg = (double) sum / len;
		// Inputs under each column
		for (int i = 0; i < len; i++) {
			System.out.printf("%" + (-big - 11) + "s", enteredPlayers[i]);
			for (int j = 0; j < playerWins[i]; j++) {
				xNumWins += "x";
			}
			System.out.printf("%" + (-numWins - 11) + "s", xNumWins);
			if (avrg > playerWins[i]) {
				diff = avrg - playerWins[i];
				System.out.printf("%s %-1.1f \n", "-", diff);
			} else {
				diff = playerWins[i] - avrg;
				System.out.printf("%s %-1.1f \n", "+", diff);
			}
			xNumWins = "";
		}
		System.out.println("\nWin Stats:");
		return avrg;
	}
	public static void printWins(int playerWins[]) {
		int len = playerWins.length;
		System.out.print("Wins: ");
		for (int i = 0; i < len; i++) {
			if (i + 1 == len) {
				System.out.print(playerWins[i]);
			} else {
				System.out.print(playerWins[i] + ", ");
			}
		}
		System.out.println();
	}
	public static int maxValue(int playerWins[]) {
		int highest = playerWins[0];
		int len = playerWins.length;
		for (int i = 1; i < len; i++) {
			if (playerWins[i] > highest) {
				highest = playerWins[i];
			}
		}
		return highest;
	}
	public static int minValue(int playerWins[]) {
		int lowest = playerWins[0];
		int len = playerWins.length;
		for (int i = 1; i < len; i++) {
			if (playerWins[i] < lowest) {
				lowest = playerWins[i];
			}
		}
		return lowest;
	}
	public static int[] sortWinsLow(int playerWins[]) {
		int len = playerWins.length;
		int sortWins[] = new int[len];
		for (int i = 0; i < len; i++) {
			sortWins[i] = playerWins[i];
		}
		int temp;
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				if (sortWins[i] > sortWins[j]) {
					// Rearranges smaller element to be at an earlier position
					temp = sortWins[i];
					sortWins[i] = sortWins[j];
					sortWins[j] = temp;
				}
			}
		}
		return sortWins;
	}
	public static int[] sortWinsHigh(int playerWins[]) {
		int len = playerWins.length;
		int sortWins[] = new int[len];
		for (int i = 0; i < len; i++) {
			sortWins[i] = playerWins[i];
		}
		int temp;
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				if (sortWins[i] < sortWins[j]) {
					// Rearranges larger element to be at an earlier position
					temp = sortWins[i];
					sortWins[i] = sortWins[j];
					sortWins[j] = temp;
				}
			}
		}
		return sortWins;
	}
	public static double median(int playerWins[], int sortLow[]) {
		int len = playerWins.length;
		double twoAvrg = 0;
		if (len == 7) {
			// odd number means one middle number
			twoAvrg = sortLow[2];
		} else {
			if (len == 6) {
				// even number means middle of two middle numbers
				twoAvrg = (double) (sortLow[2] + sortLow[3]) / 2;
			}
		}
		return twoAvrg;
	}
	public static String longestName(String enteredPlayers[]) {
		int len = enteredPlayers.length;
		String big = enteredPlayers[0];
		for (int i = 0; i < len; i++) {
			// length of current element is bigger than "big" -> becomes big
			if (enteredPlayers[i].length() > big.length()) {
				big = enteredPlayers[i];
			}
		}
		return big;
	}
}
