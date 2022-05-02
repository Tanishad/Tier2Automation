#Assumption1-Test Data Preparation activity carried out.
#Assumption2- Test Environment Preparation activity carried out.
#Assumtion3-System Date = Today's date or Any Date in Past

#User Story 1
@Manual
Feature: This Feature file tests functionalities available within Inbox

  Scenario: Display of risk in Inbox based on Expiry date
    Given Below data is present in the database with condition
      | Criteria                                                      |
      | Expiry date = SystemDate                                      |
      | Expiry date < SystemDate+60                                   |
#Assumption-Risk not been worked upon by user
      | Expiry date > SystemDate+60                                   |
      | Expiry date > SystemDate+60 && Risk being worked upon by user |
    When User logs in and view Inbox
    Then Below Risks behaviour is observed
      | Criteria                                                      | VisiblityInInxox |
      | Expiry date = SystemDate                                      | Yes              |
      | Expiry date < SystemDate+60                                   | Yes              |
      | Expiry date > SystemDate+60                                   | NO               |
      | Expiry date > SystemDate+60 && Risk being worked upon by user | Yes              |

#User Story 2
  Scenario: To distinguish between old risk due for renewal and in-flight risks.
    Given Below data is present in the database with condition
      | Criteria                                                          |
      | Expiry date < SystemDate+60 && Risk being worked upon by user     |
      | Risk being worked upon by user , any date                         |
      | Expiry date < SystemDate+60 && Risk being NOT worked upon by user |
    When User logs in and view Inbox
    Then Below Risks behaviour is observed
      | Criteria                                                          | Distinguish factor |
      | Expiry date < SystemDate+60 && Risk being worked upon by user     | Black              |
      | Risk being worked upon by user , any date                         | Black              |
      | Expiry date < SystemDate+60 && Risk being NOT worked upon by user | Red                |

#User Story 3
  Scenario:To check columns in the Inbox
    Given User loads inbox
    Then Below grid columns are observed
      | columns name                                                |
      | Unique Market Reference (UMR)                               |
      | Original Insured                                            |
#BUG - Based on Screenshots provided and for Class
      | Client/Producer                                             |
      | Class of Business                                           |
      | Inception Date                                              |
      | Expiry Date                                                 |
      | Business Type (New;Renewal;Expanding)                       |
      | Status (Preparation;Documents;Trading;Finalising;Completed) |
      | Layer Nickname                                              |
      | Owner (broker user)                                         |

#UserStory4
  Scenario Outline: Check ability to sort columns in Inbox
    Given User loads inbox
    When User performs below sorting order on the <ColName>
      | SortingOrder |
      | ASC          |
      | DESC         |
      | Default      |
#Look for Null values . IS SUB SORTING OPTION AVAILABLE?
    Then Intuitive behaviour follows
    Examples:
      | ColName    | ForReferenceOnly |
      | UMR        | Alphanumerics    |
      | ExpiryDate | Date             |
      | Class      | String           |

#UserStory5
  Scenario Outline: Filter risk by Owner
    Given User loads Inbox
    When User applies below ownership <Ownerfilters>
    Then Intuitive behaviour follows
    Examples:
      | Ownerfilters        |
      | All Risks           |
      | My Risks            |
      | My Department Risks |

#Userstory6
  Scenario: Ability to search by UMR, Original Insured or Owner
#Could there be any more columns on which search can be applied?
    Given User navigates to search risk functionality
    When User applies below Search criteria
      | SearchCriteriaLabel | Value                  |
      | UMR                 | BMPP300020n            |
      | OrignalInsured      | 360 UK                 |
      | Owner               | BennettDTradEd Test Ac |
    Then Record returned as searched

#UserStory7
  Scenario Outline: Filter risk by Status
    Given User loads Inbox
    When User applies below <Statusfilter>
    Then Intuitive behaviour follows
    Examples:
      | Statusfilter   |
      | Preparation    |
      | Trading        |
      | Completed      |
      | NTU            |
      | Renewed        |
      | Renewal Due    |
      | Client Request |
      | Not Renewing   |

#UserStory8
  Scenario Outline: Ability to view/edit risk details
#Assumption : Inline 3 Dot menu will bring Option will bring View/Edit functionality
    Given User select random risk record
    When User performs <interaction>
    Then <Behaviour> is observed
    Examples:
      | interaction | Behaviour                   |
      | View        | Record is in Read only mode |
      | Edit        | Record is in Editable mode  |

#UserStory9
  Scenario: System to prevent Editing of 'Completed' Risk Status
#Assumption : Inline 3 Dot menu will bring Option will bring View/Edit functionality
    Given User loads Inbox
    When User applies Statusfilter as 'Completed'
    Then User selects random risk record
    And following behaviour is observed
      | interaction | funtionalityAvailable |
      | View        | Yes                   |
      | Edit        | No                    |

#UserStroy 10 (system to prevent me from editing a risk outside my department)- needs Clarification. How to filter Non department risk?
# My Understanding is that the requirement may be implicitly delivered as the Inbox may not be default displaying risks outside logged in user's department.
