import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * the Sales class simulates a ticket sales system (the pre sale and during
 * sale)
 * pre sale is when the buyers join the queue to buy tickets
 * the during sale is when the the buyers can actually buy the tickets
 * Buyers join a queue and purchase tickets based on their account type,
 * aphabetical and order of arrival
 */
public class Sales {

    /**
     * sorts a map of buyers and their corresponding times based on the buyer's
     * account type
     * (using the Buyer's compareTo method) and the time they joined
     * Algorithmic Efficiency: O(n log n)
     * Big-Omega: O(n)
     * @param unsortedMap the unsorted map of buyers and their respective joining
     *                    times
     * @return a LinkedHashMap with buyers sorted by account type and joining time
     */
    public static LinkedHashMap<Buyer, LocalTime> mapSorter(Map<Buyer, LocalTime> unsortedMap) {
        ArrayList<Map.Entry<Buyer, LocalTime>> entryList = new ArrayList<>(unsortedMap.entrySet());

        // Sorts by account type and time
        entryList.sort((entry1, entry2) -> {
            Buyer buyer = entry1.getKey();
            Buyer buyer2 = entry2.getKey();

            if (buyer.compareTo(buyer2) != 0)
                return buyer.compareTo(buyer2);

            return entry1.getValue().compareTo(entry2.getValue());
        });

        // Creates a sorted map
        LinkedHashMap<Buyer, LocalTime> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Buyer, LocalTime> entry : entryList)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }


    /**
     * checks if a person already is in the que to buy ticket based on their username
     * Algorithmic Efficiency: O(n)
     * Big-Omega: O(1)
     * @param currPeople A HashMap containing Buyer objects as keys and their               purchase times as values
     * @param name the username to check
     * @return true if the username exists in the map, false otherwise.
     */
     public static boolean ifPersonAlreadyBought(HashMap<Buyer, LocalTime> currPeople, String username)
     {
            for(Buyer i : currPeople.keySet())
            {
                if(i.getUserName().equals(username))
                    return true;
            }

            return false;
     }

    /**
     * The main method to handle the presale and the during sale simulation
     * users are prompted to join a queue to buy tickets
     * then the sale occurs and users are prompted to buy their ticket
     * ordered by acount type, alphabetical and order of arrival
     * (Premium accounts receive priority)
     */
    public static void main(String[] args) {
        HashMap<Buyer, LocalTime> totalMap = new HashMap<>();
        Queue<Buyer> quee = new LinkedList<>();

        Scanner ob = new Scanner(System.in);

        System.out.println("Do you want to join the queue to buy tickets? (Type y or n)");

        while (ob.hasNextLine()) {
            if (ob.nextLine().equals("y")) {
                System.out.println("Enter your name:");
                String name = ob.nextLine();

                System.out.println("Enter your account name:");
                String acc = ob.nextLine();

                if(!ifPersonAlreadyBought(totalMap, acc)) {
                    System.out.println("Do you have a premium account? (y for yes, n for no)");
                    String var = ob.nextLine();
                    if (var.equals("y"))
                        totalMap.put(new Buyer(acc, name, 1), LocalTime.now());
                    if (var.equals("n"))
                        totalMap.put(new Buyer(acc, name, 0), LocalTime.now());
                }
                else {
                    System.out.println("Already joined queue for tickets\n\n");
                }

                System.out.println("Do you want to join the queue to buy tickets? (Type y or n)");
            }
            else
                break;
        }

        // sort the buyers and process the queue into map
        Map<Buyer, LocalTime> sortedMap = mapSorter(totalMap);

        // Algorithmic Efficiency(Big-O): O(n)
        // Big-Omega: O(1)
        quee.addAll(sortedMap.keySet());

        // Simulate during sale day
        System.out.println("\n\n\n\n\nTicket Sale is Starting\nThe tickets will sell in order of the queue\n");
        ArrayList<Buyer> ticketsBought = new ArrayList<>();
        while (!quee.isEmpty()) {
            Buyer person = quee.remove();
            if (person.getAccountVersion() == 1) {
                PremiumBuyer buyerr = new PremiumBuyer("n", "j");
                System.out.println("Your account: \n" + "Username: " + person.getUserName() + "\n" +
                    "Name: " + person.getName() + "\n" + "Account version: Premium" + "\n" + "Time Signed up: "
                    + sortedMap.get(person) + "\nPurchase your ticket\n");
                System.out.println("Premium Account Ticket Price is " + 25 * buyerr.getDiscount());
                System.out.println("Type y for purchase confirmation; n for decline");
                if (ob.nextLine().equals("y")) {
                    person.setTicketBought(true);
                    ticketsBought.add(person);
                    System.out.println("Thank you for buying, see you in 3 days");
                } else {
                    System.out.println("Sorry to hear that. See you next time");
                }
            } else {
                String ver = person.getAccountVersion() == 1 ? "Premium" : "Standard";
                System.out.println("Your account: \n" + "Username: " + person.getUserName() + "\n" +
                    "Name: " + person.getName() + "\n" + "Account version: " + ver + "\n" +
                    "Time Signed up: " + sortedMap.get(person) + "\nPurchase your ticket\n");
                System.out.println("Ticket Price is 25");
                System.out.println("Type y for purchase confirmation; n for decline");
                if (ob.nextLine().equals("y")) {
                    person.setTicketBought(true);
                    ticketsBought.add(person);
                    System.out.println("Thank you for buying, see you in 3 days\n\n\nNext Buyer Purchase Your Ticket\n");
                } else {
                    System.out.println("Sorry to hear that. See you next time\n\n\nNext Buyer Purchase Your Ticket\n");
                }
            }
        }

        System.out.println("List of buyers: ");
        if(ticketsBought.isEmpty())
            System.out.println("No buyers");
        else 
        {
        for(Buyer i : ticketsBought)
            System.out.println("   " + i.getName());
        }

    }
}
