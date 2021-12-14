package JBrischke.persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PriceDaoTest {
    @Test
    public void getPlanetSuccess() throws Exception {
        PriceDao dao = new PriceDao();
        String name = "minecraft";
        double expectedPriceValue = 17.49;
        assertEquals(expectedPriceValue, dao.getPrice(name).getCurrentLowestPrice());
    }
}
