

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JFrame;

import pl.bmaraszek.FractalBoard;

public class Fractal extends Canvas {

	private static final long serialVersionUID = 1L;
	private static final int SIZE = 512;
	private static final String[][] BOARD = FractalBoard.getBoard(SIZE);
	private static String REGEX;

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				if (BOARD[x][y].matches(REGEX)) {
					g.setColor(new Color(200, 20, 20));
					g.drawLine(x, y, x, y);
				}
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter regex:");
		REGEX = s.hasNext()? s.next() : ".*1.*";
		s.close();
		
		JFrame frame = new JFrame();

		frame.setSize(SIZE, SIZE + 25);
		frame.add(new Fractal());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
