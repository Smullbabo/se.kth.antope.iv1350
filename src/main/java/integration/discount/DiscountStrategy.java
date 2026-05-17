package integration.discount;



/**
 *  Defines the strategy to be used to give customers discounts. The interface is to be implemented by a class providing
 *  an algorithm to give a discount.
 */
public interface DiscountStrategy {
    

    /**
     * Calculates the amount of money to be discounted based on the implmentations discount algorithm.
     * 
     * @param totalCost is the total cost before any discounts have been applied.
     * @return is a double representing the amount that shall be subtracted from the total in order to give the proper discount.
     */
    double calculateDiscountValue(double totalCost);
}
