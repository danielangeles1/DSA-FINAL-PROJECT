/**
 * class which represents a premium buyer with a predefined discount
 * Extends the Buyer class and implements PremiumBuyerInterface.
 */
public class PremiumBuyer extends Buyer implements PremiumBuyerInterface {

    /** Discount rate for all premium buyers */
    private double discount = 0.8;

    /**
     * Constructor which creates a PremiumBuyer with the given username and official         name.
     * 
     * @param userName   the user inputed username of the premium buyer
     * @param officialName the user inputed official name of the premium buyer
     */
    public PremiumBuyer(String userName, String officialName) {
        super(userName, officialName, 1);
    }

    /**
     * Returns the discount rate for the premium buyer
     * 
     * @return double discount rate
     */
    public double getDiscount() {
        return discount;
    }

}
