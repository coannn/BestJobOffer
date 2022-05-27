# Test Plan
This is the test plan template for the JobOffer application. <br>
<br>
Version 1.0 <br>
<br>
**Author**: Team 134

## 1 Testing Strategy

### 1.1 Overall strategy

The levels of testing listed below will be performed in order during the testing of the application:

Unit Testing: As the first phase of the testing unit testing will be performed. In this step, the small pieces of testable code, individual functions will be executed. Each unit function in the application will have a purpose to pass. The unit testing will be performed by developers. <br> <br>
Integration Testing: The different modules of the application that are integrated will be tested as a group. The goal of integration testing is finding defects between modules during the interaction. The integration testing will be performed by testers. <br> <br>
System Testing: The fully integrated application will be tested as a whole system. The system testing will be performed after integration testing. This phase of testing will be performed by testers. <br> <br>
Acceptance Testing: The last phase of testing will be the acceptance testing. In this step, the product will be operated by users to validate the software and will be decided if the product is ready for the release. Any bug found in this phase will be documented and once all bugs are fixed, the product will be ready for the release. The last step of testing will be performed by end users. <br> <br>

### 1.2 Test Selection
We will use both black-box and white-box techniques to select test cases.

In black-box testing, we assume that software is a closed box. We don’t look at the details of the code. The focus in black-box testing is just input and output of the software application based on the requirements. White-box testing is the opposite of the black-box testing. The purpose of white-box testing is to evaluate the structure of code in the application.

### 1.3 Adequacy Criterion

We are going to assess the quality of the unit, integration testing with JUnit and the code coverage of the IDE tool will be used to ensure the quality. The system level testing will be assessed by the analysis of integration testing steps to make sure all conditions are met. The acceptance testing quality will be performed.

### 1.4 Bug Tracking
The bugs will be documented by using the Issues page of the team repository on GitHub.

### 1.5 Technology
During the test phases, our intention to use JUnit for unit testing, Appium tool to automate the testing cycle.

## 2 Test Cases 
| Test No    | Description             | Preconditions   | Expected result    | Actual result     | Pass/Fail      | Comments   |
| -----      | ----------------------- | --------------  | ------------------ | ---------------   | -------------- | ---------- | 
| test01     |Validate the cancelWithoutSave function in the JobItem class:|JUnit | The entered job info should be cancelled without saving by the JobItem object |       | Pass      |       |
| test02     |Validate the enterAndSaveCurrentJob function in the User class:|JUnit | User should be able to enter the current job information and save it |       | Pass  |       |
| test03     |Validate the editCurrentJob function in the User class:|JUnit | User should be able to edit the current job information |       | Pass    |       |
| test04     |Validate the enterAndSaveJobOffer function in the User class:|JUnit | User should be able to enter and save a single job offer |       | Pass    |       |
| test05     |Validate the enterAndSaveMultipleJobOffer function in the User class:|JUnit | User should be able to enter and save a multiple job offers |        | Pass |       |
| test06     |Validate the enterOffer button in the OfferJob class:|JUnit | User should be use the enter offer button   |       | Pass  |       |      |
| test07     |Validate the adjustCompareSettings function in the User class:|JUnit | User should be able to adjust settings in comparing jobs|       | Pass      |       |
| test08     |Validate the compareJobOffers function in the User class:|JUnit | User should be able to compare job offers |       |       |       |
| test09     |Validate the returnMainMenu function in the JobItem class:|JUnit | User should be able to return to the start page via Job Item class|       |Pass       |       |
| test10     |Validate the compareJobOffer function in the OfferJob class:|JUnit | The different job offers will be compared functionally |       | Pass     |       |
| test11     |Validate the compareJobOffer function in the user class:|JUnit | The different job offers will be compared functionally |       | Pass     |       |
| test12     |Validate the returnMainMenu function in the OfferComparison class:|JUnit | User should be able to return to the start page |       | Pass     |       |

| test13     |Validate the computeJobScoreRank function in the OfferComparison class:|Manual| The correct ranking will be outputted |       |Pass    |       |
| test14     |Validate the selectTwoJobs function in the Table class:|Manual| Two different jobs should be selected for comparison |       |Pass    |       |
| test15     |Validate the showComparisonTable function in the Table class:|Manual | The comparison table should be displayed |       | Pass    |       |
| test16     |Validate the selectAnotherTwoJobs function in the OfferComparison class:|Manual | The ranking table should be displayed |       | Pass    |       |

| test17     |Validate user can display functions on the Start Page|Fully functional app is running| User should be able to see all buttons on the start page |       |Pass       |       |
| test18     |Validate user should be able to function Enter Current Job|Fully functional app is running| User should be able to click Enter Current Job button and enter the current job details |       |Pass       |       |
| test19     |Validate user should be able to function Enter Job Offer|Fully functional app is running| User should be able to click Enter Job Offer button and enter the job offer details|       |       |       |
| test20     |Validate user should be able to function Adjust Comparison Setting|Fully functional app is running| User should be able to click Adjust Comparison Setting button and update the settings |       |Pass |
| test21     |Validate user should be able to function Compare Offer Page|Fully functional app is running| User should be able to click Compare Offer button and see the ranked job offers |       | Pass      |
| test22     |Validate user should be able to function Compare Two Selected Jobs|Fully functional app is running| User should be able to click Compare Two Selected button and see the two compared job offers in a table |       |Pass       | ||       |












