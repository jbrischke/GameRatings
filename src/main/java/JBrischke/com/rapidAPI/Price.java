package JBrischke.com.rapidAPI;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Price.
 */
public class Price{

	@JsonProperty("releaseDate")
	private String releaseDate;

	@JsonProperty("stores")
	private List<StoresItem> stores;

	@JsonProperty("name")
	private String name;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("developer")
	private String developer;

	@JsonProperty("id")
	private String id;

	@JsonProperty("currentLowestPrice")
	private double currentLowestPrice;

	@JsonProperty("type")
	private String type;

	/**
	 * Set release date.
	 *
	 * @param releaseDate the release date
	 */
	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}

	/**
	 * Get release date string.
	 *
	 * @return the string
	 */
	public String getReleaseDate(){
		return releaseDate;
	}

	/**
	 * Set stores.
	 *
	 * @param stores the stores
	 */
	public void setStores(List<StoresItem> stores){
		this.stores = stores;
	}

	/**
	 * Get stores list.
	 *
	 * @return the list
	 */
	public List<StoresItem> getStores(){
		return stores;
	}

	/**
	 * Set name.
	 *
	 * @param name the name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * Get name string.
	 *
	 * @return the string
	 */
	public String getName(){
		return name;
	}

	/**
	 * Set currency.
	 *
	 * @param currency the currency
	 */
	public void setCurrency(String currency){
		this.currency = currency;
	}

	/**
	 * Get currency string.
	 *
	 * @return the string
	 */
	public String getCurrency(){
		return currency;
	}

	/**
	 * Set developer.
	 *
	 * @param developer the developer
	 */
	public void setDeveloper(String developer){
		this.developer = developer;
	}

	/**
	 * Get developer string.
	 *
	 * @return the string
	 */
	public String getDeveloper(){
		return developer;
	}

	/**
	 * Set id.
	 *
	 * @param id the id
	 */
	public void setId(String id){
		this.id = id;
	}

	/**
	 * Get id string.
	 *
	 * @return the string
	 */
	public String getId(){
		return id;
	}

	/**
	 * Set current lowest price.
	 *
	 * @param currentLowestPrice the current lowest price
	 */
	public void setCurrentLowestPrice(double currentLowestPrice){
		this.currentLowestPrice = currentLowestPrice;
	}

	/**
	 * Get current lowest price double.
	 *
	 * @return the double
	 */
	public double getCurrentLowestPrice(){
		return currentLowestPrice;
	}

	/**
	 * Set type.
	 *
	 * @param type the type
	 */
	public void setType(String type){
		this.type = type;
	}

	/**
	 * Get type string.
	 *
	 * @return the string
	 */
	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"Price{" + 
			"releaseDate = '" + releaseDate + '\'' + 
			",stores = '" + stores + '\'' + 
			",name = '" + name + '\'' + 
			",currency = '" + currency + '\'' + 
			",developer = '" + developer + '\'' + 
			",id = '" + id + '\'' + 
			",currentLowestPrice = '" + currentLowestPrice + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}