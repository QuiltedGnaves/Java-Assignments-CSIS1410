/*
 * Dax Allen
 * Assignment: Item List
 * CSIS 1410
 * Section 402
 * 
 */
package a01ItemList;

import java.math.BigDecimal;
import java.text.NumberFormat;
/**
 * An Object that holds data about a specific product including brand, name, price, and unique id number. 
 * Automatically generates the ID numbers.
 * 
 * @param brand String - Name of brand of product
 * @param name String - Name of product
 * @param price BigDecimal - Price of product
 *
 */
public class Product {
	
	private String brand;
	private String name;
	private BigDecimal price;
	private int productId;
	private static int idTemplate = 1000;
	
	/**
	 * Product constructor. Used to create the Product object.
	 * 
	 * @param brand - name of product brand as a string
	 * @param name - name of the product as a string
	 * @param price - price of the product as a BigDecimal
	 */
	public Product(String brand, String name, BigDecimal price) {
		this.brand = brand;
		this.name = name;
		this.price = price;
		this.productId = idTemplate;
		
		idTemplate++;
	}
	
	/**
	 * Constructor with no parameters
	 */
	public Product() {
		
	}
	
	/**
	 * Getter for product's brand
	 * 
	 * @return String of product's brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Getter for product's name
	 * 
	 * @return String of product's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for product's price
	 * 
	 * @return String of formatted BigDecimal of the product's price
	 */
	public String getPrice() {
		return NumberFormat.getCurrencyInstance().format(price);
	}

	/**
	 * Getter for the product's ID
	 * 
	 * @return Int of product's ID
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * toString override for the Product class
	 * 
	 * @return Returns a formatted string with the product's information
	 */
	@Override
	public String toString() {
		return "Brand: " + brand + " -- Item Name: " + name + " -- Price: " + NumberFormat.getCurrencyInstance().format(price) + " -- Product Id: " + productId;
	}
	

}