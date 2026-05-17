package integration.discount;
/**A Discount Strategy that gives the total cost a 10% discount as a discrete value used later to update a final
 * price with a discount.
 */
public class WinterDiscountStrategy implements DiscountStrategy{

    
    @Override
    /**
     * Calculates the total discount amount from the total value and returns a value that is 10% of the initial total cost.
     * 
     * @param totalCost is the total cost before any discounts are applied.
     * @return a double representing the value to be subtracted to achive desired discount.
     */
    public double calculateDiscountValue(double totalCost) {
        return totalCost / 10;
    }
    
}
