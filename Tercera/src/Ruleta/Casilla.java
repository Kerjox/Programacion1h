package Ruleta;

import java.awt.*;

public class Casilla extends Rectangle {

	public static final int ALLCOLL = 10;
	public static final int ALLROW = 11;
	public static final int BLACKS = 5;
	public static final int FIRSTTWELVE = 1;
	public static final int IMPAR = 9;
	public static final int NINETEENTOTHIRTYSIX = 7;
	public static final int NUMBER = 0;
	public static final int ONETOEIGHTEEN = 6;
	public static final int PAR = 8;
	public static final int REDS = 4;
	public static final int SECONDTWELVE = 2;
	public static final int THIRDTWELVE = 3;
	private boolean red;
	private final int type;
	private int value;

	public Casilla(int x, int y, int width, int height, int type) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.type = type;
	}

	public Casilla(int x, int y, int width, int height, int type, int value) {

		this(x, y, width, height, type);
		this.value = value;
	}

	public Casilla(int x, int y, int width, int height, int type, int value, boolean red) {

		this(x, y, width, height, type, value);
		this.red = red;
	}

	public int getType() {

		return this.type;
	}

	public boolean isRed() {

		return this.red;
	}

	public int getValue() {

		return this.value;
	}

}
