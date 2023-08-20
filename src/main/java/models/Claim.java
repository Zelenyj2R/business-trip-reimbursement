package models;

import java.time.LocalDate;
import java.util.List;

public class Claim {
    private LocalDate tripDate;
    private List<Receipt> receipts;
    private int numberOfDays;
    private double distance;

    public Claim() {
    }

    public Claim(LocalDate tripDate, List<Receipt> receipts, int numberOfDays, double distance) {
        this.tripDate = tripDate;
        this.receipts = receipts;
        this.numberOfDays = numberOfDays;
        this.distance = distance;
    }

    public LocalDate getTripDate() {
        return tripDate;
    }

    public void setTripDate(LocalDate tripDate) {
        this.tripDate = tripDate;
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double calculateTotalReimbursement(Rates rates) {
        double totalReimbursement = 0;

        for (Receipt receipt : receipts) {
            totalReimbursement += receipt.getAmount();
        }

        totalReimbursement += numberOfDays * rates.getDailyAllowance();

        totalReimbursement += distance * rates.getMileageRate();

        return totalReimbursement;
    }
}
