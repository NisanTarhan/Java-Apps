import java.util.Random;

public abstract class Rocket implements ISpaceShip {

    private int cost;
    private int currentWeight;
    private int maxWeight;
    private int cargoLimit;

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return currentWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public Rocket(int cost, int weight, int maxWeight) {
        this.cost = cost;
        this.currentWeight = weight;
        this.maxWeight = maxWeight;
        this.cargoLimit = maxWeight - weight;
    }

    public int getCargoLimit() {
        return cargoLimit;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    // U1 and U2 class will override this method.
    @Override
    public boolean launch() {
        return true;
    }

    // U1 and U2 class will override this method.
    @Override
    public boolean land() {   // U1 and U2 class will override this method.
        return true;
    }

    // a method that takes an Item as an argument and returns true
    // if the rocket can carry such item or false if it will exceed the weight limit.
    @Override
    public boolean canCarry(Item item) {
        return (currentWeight + item.getWeight() <= maxWeight);
    }

    // a method that also takes an Item object and updates the current weight of the rocket.
    @Override
    public int carry(Item item) {
        currentWeight = currentWeight + item.getWeight();
        cargoLimit = cargoLimit - item.getWeight();
        System.out.println("Current rocket weight is : " + currentWeight);
        System.out.println("CargoLimit : " + cargoLimit);
        return currentWeight;
    }

    // Create a random number to calculate chance of explosion for U1 and U2.
    public double getRandomNumber() {
        Random random = new Random();
        return random.nextDouble();
    }

    public void printProperties() {
        System.out.println("Cost : " + getCost() + "$ Million");
        System.out.println("Weight : " + getWeight() + " Tonnes");
        System.out.println("Max weight : " + getMaxWeight() + " Tonnes");
        System.out.println("Cargo Limit : " + getCargoLimit() + " Tonnes");
    }
}
