<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/business-trip-reimbursement/static/styles.css">
    <title>Create Claim</title>
</head>
<body>
    <header>
        <h1>Create a New Reimbursement Claim</h1>
    </header>

    <main>
        <form action="/user/submit-claim" method="post">
            <div class="form-group">
                <label for="tripDate">Trip Date:</label>
                <input type="date" id="tripDate" name="tripDate" class="input" required>
            </div>

            <div class="form-group">
                <label for="receiptType">Receipt Type:</label>
                <select id="receiptType" name="receiptType" class="input">
                    <option value="taxi">Taxi</option>
                    <option value="hotel">Hotel</option>
                    <option value="planeTicket">Plane Ticket</option>
                    <!-- Другие варианты -->
                </select>
            </div>

            <div class="form-group">
                <label for="amount">Receipt Amount:</label>
                <input type="number" id="amount" name="amount" class="input" required>
            </div>

            <div class="form-group">
                <label for="numberOfDays">Number of Days:</label>
                <input type="number" id="numberOfDays" name="numberOfDays" class="input" required>
            </div>

            <div class="form-group">
                <label for="distance">Distance (km):</label>
                <input type="number" id="distance" name="distance" class="input" required>
            </div>

            <button type="submit" class="button">Submit Claim</button>
        </form>
    </main>

    <footer>
        <p>&copy; 2023 Business Trip Reimbursement App</p>
    </footer>
</body>
</html>
