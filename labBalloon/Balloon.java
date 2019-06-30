/*
 * Dax Allen
 * CSIS 1410
 * Section 402
 */
package labBalloon;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Creates a balloon object with a size, whether it is filled with helium or air, and an image associated with its size.
 * @author Dax Allen
 *
 */
public class Balloon {
	
	String size;
	String inflatedWith;
	Icon sizeImage;
	
	
	/**
	 * Constructor for the balloon. Takes no parameters.
	 */
	public Balloon(String size, String inflatedWith, ImageIcon sizeImage) {
		this.size = size;
		this.sizeImage = sizeImage;
		this.inflatedWith = inflatedWith;
	}

	/**
	 * Size getter
	 * @return size Object
	 */
	public String getSize() {
		return size;
	}

	/**
	 * inflatedWith getter
	 * @return inflatedWith 
	 */
	public String getInflatedWith() {
		return inflatedWith;
	}
	
	/**
	 * sizeImage getter
	 * @return sizeImage
	 */
	public Icon getSizeImage() {
		return sizeImage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inflatedWith == null) ? 0 : inflatedWith.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((sizeImage == null) ? 0 : sizeImage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Balloon))
			return false;
		Balloon other = (Balloon) obj;
		if (inflatedWith == null) {
			if (other.inflatedWith != null)
				return false;
		} else if (!inflatedWith.equals(other.inflatedWith))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (sizeImage == null) {
			if (other.sizeImage != null)
				return false;
		} else if (!sizeImage.equals(other.sizeImage))
			return false;
		return true;
	}

	

	

	

	
	
	

}
