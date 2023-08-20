<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/business-trip-reimbursement/static/styles.css">
    <title>Reimbursement Result</title>
</head>
<body>
    <header>
        <h1>Reimbursement Result</h1>
    </header>

    <main>
        <p>Your claim for the trip on ${claim.tripDate} has been processed.</p>
        <p>Total reimbursement amount: ${reimbursementAmount}</p>
    </main>

    <footer>
        <p>&copy; 2023 Business Trip Reimbursement App</p>
    </footer>
</body>
</html>
