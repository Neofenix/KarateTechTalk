Feature: work with DB

  Background: connect to db
    * def dbHandler = Java.type('helpers.DbHandler')

  Scenario: Seed databe with a new Job
    * eval dbHandler.addNewEmployeeWithSalary(443322,2000000)


  Scenario: Get level for job
    * def employee =  dbHandler.getEmployeeForIdCard(443322)
    * print employee.idCard
    * print employee.salary
    And match employee.idCard == '443322'
    And match employee.salary == '2000000'

