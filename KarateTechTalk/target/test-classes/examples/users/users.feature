Feature: sample karate test script

  Background:
    * url 'https://jsonplaceholder.typicode.com'

  Scenario: get all users and then get the first user by id
    Given path 'users'
    When method get
    Then status 200

    * def first = response[0]

    Given path 'users', first.id
    When method get
    Then status 200

  Scenario: create a user and then get user email
    * def userRequest = read('classpath:json/UserRequest.json')
    * def dataGenerator = Java.type('helpers.DataGenerator')
    * set userRequest.email = dataGenerator.getRandomEmail()

#    * def user =
#      """
#      {
#        "name": "Test User",
#        "username": "testuser",
#        "email": "test@user.com",
#        "address": {
#          "street": "Has No Name",
#          "suite": "Apt. 123",
#          "city": "Electri",
#          "zipcode": "54321-6789"
#        }
#      }
#      """

    Given path 'users'
    And request userRequest
    When method post
    Then status 201

    * def email = response.email
    * print 'created email is: ', email
  