public class ZigzagConversion {
    public static void printZigzag(String s, int numRows) {
        if (numRows == 1) {
            System.out.println(s);
            return;
        }

        // Create an array of StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Traverse the string and place the characters into rows
        for (int i = 0; i < s.length(); i++) {
            rows[currentRow].append(s.charAt(i));

            // If we're at the top or bottom row, change direction
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move up or down the rows
            currentRow += goingDown ? 1 : -1;
        }

        // Print the rows to form the zigzag pattern
        for (int i = 0; i < numRows; i++) {
            System.out.println(rows[i].toString());
        }
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        printZigzag(s, numRows);
    }
}
