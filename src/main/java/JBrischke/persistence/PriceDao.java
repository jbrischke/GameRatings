package JBrischke.persistence;

import JBrischke.com.rapidAPI.Price;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Price dao.
 */
public class PriceDao implements util.PropertiesLoader {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Properties.
     */
    Properties properties;
    /**
     * The Url path.
     */
    String URL_PATH;
    /**
     * The Key header.
     */
    String KEY_HEADER;
    /**
     * The Key value.
     */
    String KEY_VALUE;

    /**
     * Gets price.
     *
     * @param name the name
     * @return the price
     */
    public Price getPrice(String name) {
        //Creates a client request that returns a price entity that is displayed on the view report page
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target("");
        loadProperties();
        String response = target.path(URL_PATH).path(name).request().accept(MediaType.APPLICATION_JSON)
                .header(KEY_HEADER, KEY_VALUE).get(String.class);
        logger.debug(response);
        ObjectMapper mapper = new ObjectMapper();
        Price price = null;
        try {
            price = mapper.readValue(response, Price.class);
        } catch (JsonProcessingException e) {
            logger.debug(e);
        }
        return price;
    }


    private void loadProperties() {
        try {
            properties = loadProperties("/api.properties");
            URL_PATH = properties.getProperty("loginURL");
            KEY_HEADER = properties.getProperty("apiKeyHeader");
            KEY_VALUE = properties.getProperty("apiKeyValue");
        } catch (IOException ioException) {
            logger.error("Cannot load properties..." + ioException.getMessage(), ioException);
        } catch (Exception e) {
            logger.error("Error loading properties" + e.getMessage(), e);
        }
    }
}
