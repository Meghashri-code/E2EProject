
Feature: Login to application



  Scenario: Positive test validating login
    Given Initialize the browser with chrome
    And Navigate to "http://www.qaclickacademy.com/" site
    And click on login link in home page to land on secure sign in page
    When user enters <uname>and <pswd> logs in
    Then verify that user is successfully not logged in
   
    
    
    Examples:    
    |uname														 |pswd			  |
    |"meghashri.purushothama@gmail.com"|"Pragyan_24"|
    |"leedsshri@gmail.com"						 |"htsysn"    |
  


