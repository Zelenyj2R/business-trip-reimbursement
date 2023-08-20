package models;

public class Rates {
    private double dailyAllowance;
    private double mileageRate;


    public Rates(InitialRates initialRates) {
        this.dailyAllowance = initialRates.getDailyAllowance();
        this.mileageRate = initialRates.getMileageRate();
    }


    public double calculateReimbursementForDays(int numberOfDays) {
        return dailyAllowance * numberOfDays;
    }


    public double calculateReimbursementForDistance(double distance) {
        return mileageRate * distance;
    }


    public void updateRates(double dailyAllowanceRate, double mileageRate) {
        this.dailyAllowance = dailyAllowanceRate;
        this.mileageRate = mileageRate;
    }


    public double getDailyAllowance() {
        return dailyAllowance;
    }


    public void setDailyAllowance(double dailyAllowance) {
        this.dailyAllowance = dailyAllowance;
    }


    public double getMileageRate() {
        return mileageRate;
    }


    public void setMileageRate(double mileageRate) {
        this.mileageRate = mileageRate;
    }
}
