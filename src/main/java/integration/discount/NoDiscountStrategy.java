package integration.discount;

public class NoDiscountStrategy implements DiscountStrategy{

    @Override
    public double calculateDiscountValue(double totalCost) {
        return 0;
    }
    
}
