package pl.bmaraszek;

public class Fractal {
	
	private static boolean isPowerOf2(int x){
		return (x > 0) && ((x & (x - 1)) == 0);
	}
	
	public static String[][] getBoard(int size){

		if(!isPowerOf2(size)){
			throw new IllegalArgumentException("Only powers of 2 are valid board sizes.");
		}
		
		String[][] arr = new String[size][size];
		for (int x = 1; x <= size; ++x) {
			for (int y = 1; y <= size; ++y) {
				arr[y-1][x-1] = getId(x, y, size);
			}
		}
		
		return arr;
	}

	public static String getId(int x, int y, int size) {
		return getId(x, y, size, "");
	}

	private static String getId(int x, int y, int size, String carryOn) {
		String quarter = getQuarter(x, y, size);
		if (size == 2) {
			return carryOn + quarter;
		} else {
			switch (quarter) {
			case "1":
				return carryOn + getId(x - (size / 2), y, size / 2, quarter);
			case "2":
				return carryOn + getId(x, y, size / 2, quarter);
			case "3":
				return carryOn + getId(x, y - (size / 2), size / 2, quarter);
			case "4":
				return carryOn + getId(x - (size / 2), y - (size / 2), size / 2, quarter);
			default:
				throw new Error();
			}
		}
	}

	private static String getQuarter(int x, int y, int size) {
		if (x <= size / 2 && y <= size / 2)
			return "2";
		if (x <= size / 2 && y > size / 2)
			return "3";
		if (x > size / 2 && y <= size / 2)
			return "1";
		if (x > size / 2 && y > size / 2)
			return "4";
		throw new Error("x = " + x + "; y = " + y + "; size = " + size);
	}

}
