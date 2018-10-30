public class U2 extends Rocket {
    private double percentOFLaunch;
    private double getPercentOFLand;

    public U2() {
        super(120, 18000, 29000);
        this.percentOFLaunch = 0.04;
        this.getPercentOFLand = 0.08;
    }

    //Chance of launch explosion = 5% * (cargo carried / cargo limit)
    @Override
    public boolean launch() {
        double chanceOfLaunchExplosion = (percentOFLaunch) * ((double) getCurrentWeight() / (double) getCargoLimit());
        return !(chanceOfLaunchExplosion == getRandomNumber());  // if the chance of launch equal to random number, rocket explodes.
    }

    //Chance of landing crash = 1% * (cargo carried / cargo limit)
    @Override
    public boolean land() {

        double chanceOfLandCrashed = (getPercentOFLand) * ((double) getCurrentWeight() / (double) getCargoLimit());
        return !(chanceOfLandCrashed == getRandomNumber());  // if the chance of launch equal to random number, rocket explodes.
    }
}
