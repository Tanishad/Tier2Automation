#Assumption1-Test Data Preparation activity carried out.
#Assumption2- Test Environment Preparation activity carried out.
#Assumtion3-System Date = Today's date or Any Date in Past

@Manual
Feature: This Feature file tests functionalities related to documents Generation, uploading and Deletion.

#UserStory17
  Scenario: Navigation to Document screen
    Given User reaches on risk details screen pending document creation
    When user accesses create document functionality
    Then 'Document' screen is displayed

#UserStory18
  Scenario: Validate generation of documents
    Given User navigates to Document screen
    When User accesses document generation functionality for below mentioned documentType
      | DocumentType     |
      | ClientDisclaimer |
      | QuoteIndication  |
      | MRC              |
    Then documents are generated

#UserStory19
  Scenario:1 Validate attaching documents- single and multiple, formats
    Given User in on the Document screen
    When User attaches mentioned Count of supported document formats
      | Count |
      | 1     |
      | 4     |
    Then documents gets attached to the risk

  Scenario:2 Validate removing attached documents
    Given User in on the Document screen with documents attached.
    When User deletes a selected document
    Then document is deleted

#UserStory20
  Scenario Outline: 1 Validating trade functionality of Risk.
    Given A risk exist with all mandatory fields populated
    When User access trade functionality via mentioned <Route>
    Then Risk is saved as Trading
    Examples:
      | Route             |
      | Risk Details Page |
      | Documents         |

  Scenario: 2 Validating trade functionality of Risk. Negative Scenario
    Given A risk exist with any mandatory field NOT populated
    When User attempts to access trade functionality
    Then The trade functionality access is restricted