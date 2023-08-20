Setup Instructions:
Cloning the Project:

Clone this repository to your local machine.
Navigate to the project folder: cd business-trip-reimbursement
Setting Up Environment:

Make sure you have Apache Maven installed.
Running the Application:
Open a command prompt or terminal window.
Navigate to the project's root folder: cd business-trip-reimbursement
Run the command: mvn clean install
After a successful build, run: mvn jetty:run
Accessing the Application:
Open a web browser.
Go to: http://localhost:8080/business-trip-reimbursement/
Usage Instructions:
Authentication:

Please note that the current implementation doesn't include authentication, so all users can access the functions.

User Page:

Click the "Create a New Reimbursement Claim" link on the main page.
Fill out the form with trip details, receipts, number of days, and distance.
Click the "Submit Claim" button.
Admin Page:

Click the "Edit Reimbursement Rates" link on the main page.
Update rates as desired.
Click the "Update Rates" button.
Please make sure that you have Jetty and the necessary dependencies set up in your project configuration. The jetty:run command starts a local server using Jetty, which allows you to access the application through your web browser.