<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/business-trip-reimbursement/static/styles.css">
    <title>Edit Rates</title>
</head>
<body>
    <header>
        <h1>Edit Reimbursement Rates</h1>
    </header>

    <main>
        <form action="/admin/update-rates" method="post">
            <div class="form-group">
                <label for="dailyAllowanceRate">Daily Allowance Rate:</label>
                <input type="number" step="0.01" id="dailyAllowanceRate" name="dailyAllowanceRate" class="input" value="${rates.dailyAllowanceRate}" required>
            </div>

            <div class="form-group">
                <label for="mileageRate">Mileage Rate:</label>
                <input type="number" step="0.01" id="mileageRate" name="mileageRate" class="input" value="${rates.mileageRate}" required>
            </div>

            <button type="submit" class="button">Update Rates</button>
        </form>

        <div class="result">
            <p>Updated Rates:</p>
            <p>Daily Allowance Rate: ${updatedRates.dailyAllowanceRate}</p>
            <p>Mileage Rate: ${updatedRates.mileageRate}</p>
        </div>
    </main>

    <footer>
        <p>&copy; 2023 Business Trip Reimbursement App</p>
    </footer>
</body>
</html>
