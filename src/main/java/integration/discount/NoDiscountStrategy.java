package integration.discount;


/**
 * A Discount Starategy which gives no discount.
 */
public class NoDiscountStrategy implements DiscountStrategy{

    @Override
    /**
     * Returns 0 as there is no discount to be calculated.
     * 
     * @param totalCost The total cost before any discounts are applied.
     * @return 0 as this strategy represents no discount on the total cost.
     */
    public double calculateDiscountValue(double totalCost) {
        return 0;
    }
    
}
