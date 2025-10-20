 ## Requirements of this project:- 

1. Visit the site https://dailyfinance.roadtocareer.net/. Register a new user (e.g. gmailuser+randomdigit@gmail.com). Assert the congratulations email is received.

2. Now click on the reset password link. Write 2 negative test case and assert them.

3. Now Input valid gmail account you have registered and click on send reset link button

4. Now retrieve password reset mail from your gmail and set new password

5. Now login with the new password to ensure login successful

6. Add random 2 items (1 for all fields, another for only mandatory fields) and assert 2 items are showing on the item list

7. Now go to user profile and update user gmail with a new gmail

8. Now logout and login with the updated gmail account. Assert that using new email login is successful and using previous email login is failed.

9. Now logout again and login with the admin account. Admin credential must be sent from the terminal securely.

10. Search by the updated gmail and Assert that updated user email is showing on admin dashboard.

11. Now register more 3 users getting data from a CSV file

12. Now login as admin and get all the users from user table and write them in a text file.

## How to Run This Project
Before running the project, make sure you have:

1:- Java JDK 21+ installed

2:Gradle installed (or use Gradle wrapper included in the project)

### Project Setup

1-Clone the repository

2-Open the project in your IDE

3-Install dependencies (The project uses Gradle, dependencies are defined in build.gradle.)

4-Run from Gradle :- ./gradlew clean test -Pemail="your_test_email@gmail.com" -Ppassword="your_password"

## Alure report of this Automation Project

<img width="1872" height="852" alt="image" src="https://github.com/user-attachments/assets/998a56d4-2cb0-4046-93b1-3ecca0bc8c3b" />

<img width="858" height="880" alt="image" src="https://github.com/user-attachments/assets/1432384a-e548-4332-8238-164f75358de7" />

### vedio demonastration link:- 

link:-  https://drive.google.com/drive/folders/1R5E39gwfWrRTHHBwtky19XMuX-9Nk4pm?dmr=1&ec=wgc-drive-globalnav-goto





