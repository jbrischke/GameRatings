package JBrischke.com.rapidAPI;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

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

	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public void setStores(List<StoresItem> stores){
		this.stores = stores;
	}

	public List<StoresItem> getStores(){
		return stores;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}

	public void setDeveloper(String developer){
		this.developer = developer;
	}

	public String getDeveloper(){
		return developer;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCurrentLowestPrice(double currentLowestPrice){
		this.currentLowestPrice = currentLowestPrice;
	}

	public double getCurrentLowestPrice(){
		return currentLowestPrice;
	}

	public void setType(String type){
		this.type = type;
	}

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