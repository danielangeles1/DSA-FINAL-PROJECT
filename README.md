Daniel: 
  Sales, PremiumBuyerInterface


  
Aneesh: 
  Buyer, PremiumBuyer




Alg 1

/**
Algorithmic Efficiency: O(n log n)
     * Big-Omega: O(n)
/**

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




Alg 2

Algorithmic Efficiency: O(n)
     * Big-Omega: O(1)



    public static boolean ifPersonAlreadyBought(HashMap<Buyer, LocalTime> currPeople, String username)
     {
            for(Buyer i : currPeople.keySet())
            {
                if(i.getUserName().equals(username))
                    return true;
            }

            return false;
     }





