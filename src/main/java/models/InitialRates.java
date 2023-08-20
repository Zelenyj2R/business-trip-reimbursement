package models;

public enum InitialRates {
    INITIAL(15.0, 0.3);

    private double dailyAllowance;
    private double mileageRate;

    InitialRates(double dailyAllowance, double mileageRate) {
        this.dailyAllowance = dailyAllowance;
        this.mileageRate = mileageRate;
    }

    public double getDailyAllowance() {
        return dailyAllowance;
    }

    public double getMileageRate() {
        return mileageRate;
    }
}
