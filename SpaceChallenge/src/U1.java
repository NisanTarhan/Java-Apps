public class U1 extends Rocket {
    private double percentOFLaunch;
    private double getPercentOFLand;

    public U1() {
        super(100, 10000, 18000);
        this.percentOFLaunch = 0.05;
        this.getPercentOFLand = 0.01;
    }

    //Chance of launch explosion = 5% * (cargo carried / cargo limit)
    @Override
    public boolean launch() {
        double chanceOfLaunchExplosion = (percentOFLaunch) * ((double) getCurrentWeight() / (double) getCargoLimit());
        return !(chanceOfLaunchExplosion == getRandomNumber()); // if the chance of launch equal to random number, rocket explodes.
    }

    //Chance of landing crash = 1% * (cargo carried / cargo limit)
    @Override
    public boolean land() {
        double chanceOfLandCrashed = (getPercentOFLand) * ((double) getCurrentWeight() / (double) getCargoLimit());
        return !(chanceOfLandCrashed == getRandomNumber());  // if the chance of launch equal to random number, rocket explodes.
    }
}
