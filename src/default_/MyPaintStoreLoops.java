package default_;
import java.util.Scanner;
public class MyPaintStoreLoops {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choiceNum = 0;
		int totalCans = 0;
		int size = 0;
		int rows = 0;
		int columns = 0;
		boolean validInput = false;
		displayMenu();
		while (!validInput) {
			System.out.print("Enter your choice (1-6): ");
			String choiceStr = input.nextLine();
			try {
				choiceNum = Integer.parseInt(choiceStr);
				if (choiceNum < 1 || choiceNum > 6) {
					System.out.println("Your input is an invalid option");
				} else {
					System.out.println("User Option: " + choiceNum);
					validInput = true;
				}
			} catch (NumberFormatException a) {
				System.out.println("Your input is an invalid option.");
			}
		}
		switch (choiceNum) {
		case 1:
			rows = getNumberOfRows();
			columns = getNumberOfColumns();
			totalCans = rows * columns;
			System.out.println("You will need: " + totalCans + " number of cans");
			displayRectangle(rows, columns);
			break;
		case 2:
			rows = getNumberOfRowsOdd();
			totalCans = rows * rows;
			System.out.println("You will need: " + totalCans + " number of cans");
			displayPyramid(rows);
			break;
		case 3:
			rows = getNumberOfRowsOdd();
			totalCans = rows * rows;
			System.out.println("You will need: " + totalCans + " number of cans");
			displayPyramidDown(rows);
			break;
		case 4:
			rows = getNumberOfRowsOdd();
			totalCans = rows * rows / 2 + 1;
			System.out.println("You will need: " + totalCans + " number of cans");
			displayDiamond(rows);
			break;
		case 5:
			rows = getNumberOfRows();
			displaySignatureRow(rows, totalCans);
			break;
		case 6:
			size = getNumberOfSize();
			totalCans = (size * 2) - 1;
			System.out.println("You will need: " + totalCans + " number of cans");
			displayAnyX(size);
			break;
		}
	}
	private static void displayMenu() {
		System.out.println("   "
				+ "____");
		System.out.println(" /      \\ ");
		System.out.println("/ ______ \\ ");
		System.out.println("|  Alan  | ");
		System.out.println("| Paint  | ");
		System.out.println("| Store  | ");
		System.out.println("| Display| ");
		System.out.println("| Centre | ");
		System.out.println("| ______ | ");
		System.out.println("|        | ");
		System.out.println("|        | ");
		System.out.println("| PAINT  | ");
		System.out.println("|  CAN   | ");
		System.out.println("|________| ");
		System.out.println();
		System.out.println("Welcome to Alan's Paint Store Display Centre!");
		System.out.println();
		System.out.println("Paint Store Display Centre");
		System.out.println("1) Rectangle Display");
		System.out.println("2) Pyramid (Odd Can's Only)");
		System.out.println("3) Upside Down Pyramid (Odd Can's Only)");
		System.out.println("4) Diamond Display (Odd Can's Only)");
		System.out.println("5) Signature rowsArrangement Ways?");
		System.out.println("6) Display X (Any Odd Value)");
	}
	private static int getNumberOfRows() {
		Scanner scanner = new Scanner(System.in);
		int rows = 0;
		boolean validInput = false;
		while (!validInput) {
			System.out.print("Enter the number of rows: ");
			String rowStr = scanner.nextLine();
			try {
				rows = Integer.parseInt(rowStr);
				validInput = true;
			} catch (NumberFormatException b) {
				System.out.println("Your input is invalid.");
			}
		}
		return rows;
	}
	private static int getNumberOfRowsOdd() {
		Scanner scanner = new Scanner(System.in);
		int rows = 0;
		boolean validInput = false;
		while (!validInput) {
			System.out.print("Enter the number of rows: ");
			String rowStr = scanner.nextLine();
			try {
				rows = Integer.parseInt(rowStr);
				if (rows % 2 == 1) {
					validInput = true;
				} else {
					System.out.println("Your input should be an odd value.");
					validInput = false;
				}
			} catch (NumberFormatException c) {
				System.out.println("Your input is invalid.");
			}
		}
		return rows;
	}
	private static int getNumberOfColumns() {
		Scanner scanner = new Scanner(System.in);
		int columns = 0;
		boolean validInput = false;
		while (!validInput) {
			System.out.print("Enter the number of columns: ");
			String columnStr = scanner.nextLine();
			try {
				columns = Integer.parseInt(columnStr);
				validInput = true;
			} catch (NumberFormatException c) {
				System.out.println("Your input is invalid.");
			}
		}
		return columns;
	}
	public static void displayRectangle(int rows, int columns) {
		Scanner input1 = new Scanner(System.in);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print("x");
			}
			System.out.println();
		}
	}
	public static void displayPyramid(int rows) {
		Scanner input2 = new Scanner(System.in);
		int k = 1;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= rows - i; j++) {
				System.out.print(" ");
			}
			while (k <= i * 2 - 1) {
				k++;
				System.out.print("x");
			}
			k = 1;
			System.out.println();
		}
	}
	public static void displayPyramidDown(int rows) {
		Scanner input3 = new Scanner(System.in);
		int i = rows;
		while (i >= 1) {
			int j = i;
			while (j < rows + 1) {
				System.out.print(" ");
				j++;
			}
			int k = 1;
			while (k <= 2 * i - 1) {
				System.out.print("x");
				k++;
			}
			System.out.println();
			i--;
		}
	}
	public static void displayDiamond(int rows) {
		Scanner input4 = new Scanner(System.in);
		rows++;
		displayPyramid(rows / 2);
		rows--;
		displayPyramidDown(rows / 2);
	}
	private static void displaySignatureRow(int rows, int totalCans) {
		Scanner input5 = new Scanner(System.in);
		totalCans = rows;
		for (int i = rows - 1; i >= 1; i--) {
			totalCans *= i;
		}
		System.out.println("You will need: " + totalCans + " number of cans");
		System.out.println(rows + "! = " + totalCans);
	}
	private static int getNumberOfSize() {
		Scanner input6 = new Scanner(System.in);
		boolean validInput = false;
		int size = 0;
		while (!validInput) {
			System.out.print("Enter a value for the size (Odd Number): ");
			String lengthStr = input6.nextLine();
			try {
				size = Integer.parseInt(lengthStr);
				if (size % 2 == 1) {
					validInput = true;
				} else {
					System.out.println("Your input should be an odd value.");
					validInput = false;
				}
			} catch (NumberFormatException d) {
				System.out.println("Your input is invalid.");
			}
		}
		return size;
	}
	private static void displayAnyX(int size) {
		upperX(size);
		lowerX(size);
	}
	public static void upperX(int size) {
		int spaces = 0;
		int xCount = size;
		while (xCount > 0) {
			for (int i = 0; i < spaces; i++) {
				System.out.print(" ");
			}
			System.out.print("X");
			for (int i = 0; i < xCount - 2; i++) {
				System.out.print(" ");
			}
			if (xCount > 2) {
				System.out.print("X");
			}
			System.out.println();
			spaces++;
			xCount -= 2;
		}
	}
	public static void lowerX(int size) {
		int spaces = size / 2;
		int xCount = 2;
		while (xCount <= size) {
			for (int i = 1; i < spaces; i++) {
				System.out.print(" ");
			}
			System.out.print("X");
			for (int i = 0; i < xCount - 1; i++) {
				System.out.print(" ");
			}
			if (xCount > 1) {
				System.out.print("X");
			}
			System.out.println();
			spaces--;
			xCount += 2;
		}
	}
}
