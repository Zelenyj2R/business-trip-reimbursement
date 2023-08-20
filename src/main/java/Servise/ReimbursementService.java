package Servise;

import models.Claim;
import models.Rates;
import models.Receipt;
import models.InitialRates;


import java.util.List;

public class ReimbursementService {
    private Rates rates;
    public ReimbursementService(InitialRates initialRates) {
        this.rates = new Rates(initialRates);
    }

    public double calculateReimbursement(Claim claim) {
        double totalReimbursement = 0;

        List<Receipt> receipts = claim.getReceipts();
        for (Receipt receipt : receipts) {
            totalReimbursement += receipt.getAmount();
        }

        totalReimbursement += rates.calculateReimbursementForDays(claim.getNumberOfDays());
        totalReimbursement += rates.calculateReimbursementForDistance(claim.getDistance());

        return totalReimbursement;
    }

    public Rates getRates() {
        return rates;
    }
}
