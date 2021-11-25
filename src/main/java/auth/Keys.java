package auth;

import java.util.List;

import auth.KeysItem;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Keys{

	@JsonProperty("keys")
	private List<KeysItem> keys;

	public List<KeysItem> getKeys(){
		return keys;
	}
}