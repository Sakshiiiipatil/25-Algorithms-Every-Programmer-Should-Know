public class FloodFill {

    public static void floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        int oldColor = image[sr][sc];

        if (oldColor != newColor) {
            dfs(image, sr, sc, oldColor, newColor, rows, cols);
        }
    }

    public static void dfs(int[][] image, int row, int col, int oldColor, int newColor, int rows, int cols) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] != oldColor) {
            return;
        }

        image[row][col] = newColor;

        dfs(image, row - 1, col, oldColor, newColor, rows, cols);
        dfs(image, row + 1, col, oldColor, newColor, rows, cols);
        dfs(image, row, col - 1, oldColor, newColor, rows, cols);
        dfs(image, row, col + 1, oldColor, newColor, rows, cols);
    }

    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int sr = 1, sc = 1, newColor = 2;

        floodFill(image, sr, sc, newColor);

        System.out.println("Flood-Filled Image:");
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }

            /*floodFill method:

The floodFill method takes the following parameters:
image: a 2D array representing the image.
sr: the starting row index.
sc: the starting column index.
newColor: the new color to fill the region with.
It first retrieves the dimensions of the image (number of rows and columns) and the color of the pixel at the starting position (sr, sc), which is referred to as oldColor.
If oldColor is not equal to newColor, indicating that the new color is different from the old color, the program proceeds to perform the flood fill by calling the dfs (depth-first search) method.
dfs method:

The dfs method is a recursive helper function used for the actual flood fill operation.
It takes the following parameters:
image: the 2D image array.
row: the current row index.
col: the current column index.
oldColor: the original color of the pixel to be filled.
newColor: the new color to fill the region with.
rows and cols: the dimensions of the image.
The method performs the following steps:
Checks if the current (row, col) coordinates are out of bounds or if the pixel color is not equal to the oldColor. If any of these conditions is met, it returns, terminating the recursive call.
Sets the color of the current pixel to the newColor.
Recursively calls dfs on the adjacent pixels (up, down, left, and right) to propagate the flood fill operation.
main method:

In the main method, an example image represented as a 2D array is defined. The image consists of 1s and 0s.
The program specifies the starting position (sr, sc) as (1, 1) and the new color as 2.
It then calls the floodFill method to perform the flood fill operation on the image.
Finally, the program prints the flood-filled image to the console.
Output:

The program outputs the flood-filled image after replacing the old color (in this case, 1) with the new color (in this case, 2).*/
            System.out.println();
        }
    }
}
