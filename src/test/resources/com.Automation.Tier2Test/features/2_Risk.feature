#Assumption1-Test Data Preparation activity carried out.
#Assumption2- Test Environment Preparation activity carried out.
#Assumtion3-System Date = Today's date or Any Date in Past

@Manual
Feature: This Feature file tests functionalities related to Risk and Risk Details

#UserStory 11 & 12
  Scenario: Ability to create 'New' risk from inbox
    Given User loads Inbox
    When User navigates to create new risk functionality
    Then User submits below information
      | Field         | Value                                  |
#Clarification on the Type of risk. Can it be anything other than New?
      | type          | New                                    |
      | Division      | Bermuda                                |
      | Sub-Division  | List contains values based on Division |
      | UMR           | **Based on Division                    |
      | InceptionDate | CurrentDate                            |
      | ExpiryDate    | CurrentDate+1Year                      |
    And Newly created risk's status is 'preparation'

#Userstory13
  Scenario: InternalID generated for new Risk
    Given User loads Inbox
    When User navigates to create new risk functionality
    And User creates new Risk
    Then Internal ID is created in DB
    And InternalID is not visible within AUT

#UserStory14
  Scenario: Submit Risk details
    Given Risk exist without corresponding Risk details
    When  Risk details screen appears
#Refer Mandatory/ Optional/Conditional, searchable, freetext field checks in story.
    Then Validate M/O/C checks on the risk details screen.
#Refer Picklist checks in story.
    And Expiry date is default set as inspectionDate + 1 year
    And Date picker functionality is checked
    And User submits relevant values in each field


#UserStory15
  Scenario: Save Risk details
    Given Unsaved risk details exist
    When User saves the risk details
    Then Risk details are submitted into DB

#UserStory16
  Scenario: 1 Ability to Add Risk members
    Given Unsaved risk details exist
    When User reaches to Add/Remove Team Member screen
    And User searches with keyword 'Test'
    Then Search result is displayed
    And User can Add selected team member

  Scenario: 2 Risk member is added
    Given Unsaved risk details exist
    When User selects a team member to add from filtered records
    Then team member is associated

  Scenario: 3 Remove Risk member/s and verify Risk details
    Given Unsaved risk details with team member/s added exist
    When User removes an already added team member
    Then Risk team member is deleted
    And Risk team member details are updated in DB