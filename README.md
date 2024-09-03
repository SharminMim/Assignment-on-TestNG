## Project Title- Web Automation on OrangeHRM using ``` TestNG ```
In this repository I have automated the OrangeHRM with different scenario and also generated the Allure Report.

### Tools Used
- Selenium
- TestNG Framework
- Java
- Gradle
- Allure Report
    - Project run ```gradle clean test```

      For generating Allure Report-
    - ```allure generate allure-results --clean -o allure-report```
    - ```allure serve allure-results```
### Work Scenerio
1. Login as a admin to https://opensource-demo.orangehrmlive.com/
2. Go to PIM menu and create a new employee. Save the employee firstname, lastname, employeeid, username and password into JSONArray file. Generate random password which meets following criteria:
For a strong password, please use a hard to guess combination of text with upper and lower case characters, symbols and numbers. Assert if employee is created successfully.

3. Now go to the dashboard again and search by the employee id to check if the employee is found
4. Now go to the Directory menu and search by employee name and check if the employee is found and logout the session
5. Now login with the newly created employee creds
6. Assert your full name is showing besides the profile icon.
7. Go to my info
8. Scroll down and select Gender and Blood Type as O+ and save it. Then logout the user.

### Test Case
https://docs.google.com/spreadsheets/d/1SoCNBBDXivMWM0ohF8oREC5JiAf8jdUqV4YYeZ9eByE/edit?usp=sharing

### Allure Report
#### Overview 
![allure](https://github.com/user-attachments/assets/76710e5f-18ba-46ac-854f-a58780ba518a)

#### Behaviour 
![allureBehaviour](https://github.com/user-attachments/assets/1a9feabc-d2a8-43f1-b5bf-6b6796ce228e)

### Project Demonstration Video


https://github.com/user-attachments/assets/04759b0d-b1bb-4709-ab6a-dc8aa9de3b5a


