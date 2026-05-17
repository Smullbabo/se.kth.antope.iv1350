package integration.discount;

public class WinterDiscountStrategy implements DiscountStrategy{

    @Override
    public double calculateDiscountValue(double totalCost) {
        return totalCost / 10;
    }
    
}
