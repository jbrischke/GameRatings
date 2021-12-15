package JBrischke.com.rapidAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Stores item.
 */
public class StoresItem{

	@JsonProperty("seller")
	private String seller;

	@JsonProperty("price")
	private double price;

	@JsonProperty("url")
	private String url;

	/**
	 * Set seller.
	 *
	 * @param seller the seller
	 */
	public void setSeller(String seller){
		this.seller = seller;
	}

	/**
	 * Get seller string.
	 *
	 * @return the string
	 */
	public String getSeller(){
		return seller;
	}

	/**
	 * Set price.
	 *
	 * @param price the price
	 */
	public void setPrice(double price){
		this.price = price;
	}

	/**
	 * Get price double.
	 *
	 * @return the double
	 */
	public double getPrice(){
		return price;
	}

	/**
	 * Set url.
	 *
	 * @param url the url
	 */
	public void setUrl(String url){
		this.url = url;
	}

	/**
	 * Get url string.
	 *
	 * @return the string
	 */
	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"StoresItem{" + 
			"seller = '" + seller + '\'' + 
			",price = '" + price + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}