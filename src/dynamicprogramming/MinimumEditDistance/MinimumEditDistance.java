package dynamicprogramming.MinimumEditDistance;

public class MinimumEditDistance {

	public static void main(String[] args) {
		//String str1 = "azced";
		//String str2 = "abcdef";
		String str2 = "ppp";
		String str1 = "ccc";
		int distance = findMinimumEditDistance(str1, str2);

	}

	private static int findMinimumEditDistance(String str1, String str2) {

		int matrix[][] = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i < matrix.length; i++) {
			matrix[i][0] = i;
		}

		for (int j = 0; j < matrix[0].length; j++) {
			matrix[0][j] = j;
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					matrix[i][j] = matrix[i - 1][j - 1];
				} else {
					matrix[i][j] = minimum(matrix[i - 1][j - 1], matrix[i - 1][j], matrix[i][j - 1]) + 1;
				}

			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);

			}
			System.out.println("");
		}

		printEditSequence(matrix, str1, str2);
		return matrix[str1.length()][str2.length()];
	}

	private static void printEditSequence(int[][] matrix, String str1, String str2) {

		int i = matrix.length - 1;
		int j = matrix[0].length - 1;

		while (true) {

			if (i == 0 || j == 0) {
				break;
			}
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				i--;
				j--;
			} else if (matrix[i][j] == matrix[i - 1][j - 1] + 1) {
				System.out.println("replace character " + str1.charAt(i - 1) + " at position " + (i - 1)
						+ " in str1  by character  " + str2.charAt(j - 1) + " from str2 at position "
						+ (j - 1));
				i--;
				j--;
			} else if (matrix[i][j] == matrix[i][j - 1] + 1) {

				System.out
						.println("add character " + str2.charAt(j - 1) + " in str1 at position " + i);
				j--;
			} else if (matrix[i][j] == matrix[i - 1][j] + 1) {

				System.out.println("delete character " + str1.charAt(i - 1) + " at position " + (i - 1));
				i--;
			}

			else {
				System.out.println("kuchh gadbad hai daya");
			}

		}

	}

	private static int minimum(int i, int j, int k) {
		int d = Math.min(i, j);
		return Math.min(d, k);
	}

}
