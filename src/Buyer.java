/**
 * Represents a buyer with account details and ticket info
 * Implements the Comparable interface
 */
public class Buyer implements Comparable<Buyer> {

    /** the username of the buyer */
    private String userName;

    /** the official name of the buyer */
    private String officialName;

    /** the acc version of the buyer */
    private int accountVersion;

    /** indicates whether the buyer has bought a ticket (true or false) */
    private boolean ticketBought;

    /**
     * constructs a Buyer with given details
     *
     * @param userName       username of buyer
     * @param officialName   official name of buyer
     * @param accountVersion account version of the buyer
     */
    public Buyer(String userName, String officialName, int accountVersion) {
        this.userName = userName;
        this.officialName = officialName;
        this.accountVersion = accountVersion;
    }

    /**
     * Returns the official name of the buyer
     *
     * @return String official name
     */
    public String getName() {
        return officialName;
    }

    /**
     * Returns the username of the buyer
     *
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Returns the account version of the buyer (0 or 1) (standerd or premium))
     *
     * @return the account version
     */
    public int getAccountVersion() {
        return accountVersion;
    }

    /**
     * Returns whether the buyer has bought a ticket
     *
     * @return boolean, true if the ticket is bought, false if not
     */
    public boolean getTicketBought() {
        return ticketBought;
    }

    /**
     * Sets whether the buyer has bought a ticket.
     *
     * @param ticketBought true if the ticket is bought, false otherwise
     */
    public void setTicketBought(boolean ticketBought) {
        this.ticketBought = ticketBought;
    }

    /**
     * compares this buyer to another buyer for sorting
     * the comparison is based on account version and if equal
     * compares by the last name in the official name
     *
     * @param other the buyer to compare to
     * @return a negative value if this buyer is less
     *         0 if they are equal or a positive value if this buyer is greater
     */
    @Override
    public int compareTo(Buyer other) {
        if (other instanceof Buyer) {
            Buyer e = (Buyer) other;

            if (e.getAccountVersion() == getAccountVersion())
                return 0;
            else if (e.getAccountVersion() > getAccountVersion())
                return 1;
            else
                return -1;
        }

        return -1;
    }
}
