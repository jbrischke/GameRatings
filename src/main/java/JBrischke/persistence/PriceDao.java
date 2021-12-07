package JBrischke.persistence;

import JBrischke.com.rapidAPI.Price;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class PriceDao {
    Price getPrice() {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target("");
        //TODO properties file
        String response = target.path("https://game-prices.p.rapidapi.com/game/").path("minecraft").request().accept(MediaType.APPLICATION_JSON)
                .header("x-rapidapi-key", "902c9d04ebmshc17380d9341d091p165c33jsndaf6acaad7d2").get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Price price = null;
        try {
            price = mapper.readValue(response, Price.class);
        } catch (JsonProcessingException e) {
            //TODO set up logging and write this to the log
            e.printStackTrace();
        }
        return price;
    }
}
