package pl.bmaraszek;

import org.junit.Test;

public class FractalTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void test63() {
		Fractal.getBoard(7);
	}

	@Test
	public void test8() {

		int SIZE = 8;

		String[][] arr = new String[SIZE][SIZE];
		for (int x = 1; x <= SIZE; ++x) {
			for (int y = 1; y <= SIZE; ++y) {
				arr[y-1][x-1] = Fractal.getId(x, y, SIZE);
			}
		}

		for (int x = 1; x <= SIZE; ++x) {
			for (int y = 1; y <= SIZE; ++y) {
				System.out.print("  " + arr[x-1][y-1]);
			}
			System.out.println();
		}
	}

}
