package JBrischke.com.rapidAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StoresItem{

	@JsonProperty("seller")
	private String seller;

	@JsonProperty("price")
	private double price;

	@JsonProperty("url")
	private String url;

	public void setSeller(String seller){
		this.seller = seller;
	}

	public String getSeller(){
		return seller;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return price;
	}

	public void setUrl(String url){
		this.url = url;
	}

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