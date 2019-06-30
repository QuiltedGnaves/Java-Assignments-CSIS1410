package labBalloon;

import java.util.Random;

public enum Sizes {
	
	XS, S, M, L, XL;
	
	/**
	 * Gets a random size from the sizes enum
	 * @return size 
	 */
	public static Sizes getRandomSize() {
		Random rand = new Random();
		return Sizes.values()[rand.nextInt(Sizes.values().length)];
	}

}
