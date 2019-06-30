package a09ListVsSet;

import java.awt.Color;

public class ColoredSquare {
	int side;
	Color color;
	
	public ColoredSquare(int s, Color c) {
		this.side = s;
		this.color = c;
	}
	
	public int area() {
		return this.side * this.side;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + side;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ColoredSquare))
			return false;
		ColoredSquare other = (ColoredSquare) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (side != other.side)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Side: %s #%s", side, Integer.toHexString(color.getRGB()).substring(2).toUpperCase());
	}
	
	

}
