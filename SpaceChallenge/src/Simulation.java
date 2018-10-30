import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Simulation {

    private ArrayList<Item> itemList;
    private ArrayList<Rocket> arrayOfU1 = new ArrayList<>();
    private ArrayList<Rocket> arrayOfU2 = new ArrayList<>();
    private Rocket u1Rocket, u2Rocket;
    private int numberOfRockets = 0;

    // TODO: create a loadItems method which loads all items from a text file and returns an ArrayList of Items. Each
    // line in the text file consists of the item name followed by '=' then the item's weight in kg. The method should
    // read the text file line by line and create an Item object for each and then add it to an ArrayList of items. The
    // method should then return that ArrayList.

    public ArrayList<Item> loadItems(BufferedReader bufferedReader) {

        try {
            itemList = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] listItem = line.split("=");
                String itemName = listItem[0].trim();
                int itemWeight = Integer.parseInt(listItem[1].trim());

                Item item = new Item(itemName, itemWeight);
                itemList.add(item);
                //System.out.println("The item is " + itemName + " with a weight of " + itemWeight + " kg");
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
        return itemList;
    }

    // create a loadU1 method which takes the ArrayList of items returned from loadItems and starts creating U1
    // rockets. It first tries to fill up 1 rocket with as many items as possible before created a new rocket object and
    // filling that one until all items are loaded.

    public void loadU1(ArrayList<Item> itemList) {
        u1Rocket = new U1();
        for (Item item : itemList) {
            while (!u1Rocket.canCarry(item)) {
                arrayOfU1.add(u1Rocket);
                u1Rocket = new U1();
                numberOfRockets++;
                System.out.println("new U1 Rocket is created: " + numberOfRockets);
            }
            u1Rocket.carry(item);
        }
        numberOfRockets = 0;
    }


    // create a loadU2 method which takes the ArrayList of Items and starts creating U2 rockets and filling them
    // with those items the same way as with U1 until all items are loaded.

    public void loadU2(ArrayList<Item> itemList) {
        u2Rocket = new U2();
        for (Item item : itemList) {
            while (!u2Rocket.canCarry(item)) {
                arrayOfU2.add(u2Rocket);
                u2Rocket = new U2();
                numberOfRockets++;
                System.out.println("new U2 Rocket is created: " + numberOfRockets);
            }
            u2Rocket.carry(item);
        }
        numberOfRockets = 0;
    }

    // create a runSimulation method which takes an ArrayList of Rockets and calls launch() and land() for each of
    // the rockets in the ArrayList. Every time a rocket explodes or crashes (i.e. if launch() or land() return false)
    // it will have to send that rocket again. The total budget required to send each rocket safely to Mars should also
    // be kept track of here. The method then returns the total budget required to send all rockets (including the ones
    // that crashed).

    public int runSimulation(ArrayList<Rocket> arrayOfRocket) {
        numberOfRockets = arrayOfRocket.size();
        int totalBudget = 0;

        for (Rocket rocket : arrayOfRocket) {
            if (rocket.land() || rocket.launch()) {
                numberOfRockets++;
                totalBudget += rocket.getCost();
                System.out.println("Rocket exploded.");
            }
            totalBudget += rocket.getCost();
        }
        System.out.println("Number of Rockets : " + numberOfRockets +
                "\nTotal budget to required to send : " + totalBudget + "$ Million");

        return totalBudget;
    }

    // Those methods return the ArrayList of those U1 or U2 rockets that are
    // fully loaded.

    public ArrayList<Rocket> getArrayOfU1() {
        return arrayOfU1;
    }

    public ArrayList<Rocket> getArrayOfU2() {
        return arrayOfU2;
    }
}
