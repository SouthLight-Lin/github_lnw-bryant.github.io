package experiment.five;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        double price = 1.0;
        price = new BigDecimal(price).divide(new BigDecimal(1)).doubleValue();
        System.out.println(price);
    }
}
