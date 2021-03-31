package Ruleta;

import java.awt.*;

public class Casilla extends Rectangle {

	public static final int FIRSTTWELVE = 50;
	public static final int SECONDTWELVE = 51;
	public static final int THIRDTWELVE = 52;
	public static final int REDS = 53;
	public static final int BLACKS = 54;
	public static final int ONETOEIGHTEEN = 55;
	public static final int NINETEENTOTHIRTYSIX = 56;
	public static final int PAR = 57;
	public static final int IMPAR = 58;
	public static final int ALLCOLL = 59;
	public static final int ALLROW = 60;

	private boolean red;
	private int value;

	public Casilla(int x, int y, int width, int height, int value) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.value = value;
	}

	public Casilla(int x, int y, int width, int height, int value, boolean red) {

		this(x, y, width, height, value);
		this.red = red;
	}

	public boolean isRed() {

		return this.red;
	}

	public int getValue() {

		return this.value;
	}

}
