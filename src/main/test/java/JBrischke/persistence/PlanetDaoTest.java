package JBrischke.persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PlanetDaoTest {
    @Test
    public void getPlanetSuccess() throws Exception {
        PriceDao dao = new PriceDao();
        double expectedPriceValue = 17.49;
        assertEquals(expectedPriceValue, dao.getPrice().getCurrentLowestPrice());
    }
}
