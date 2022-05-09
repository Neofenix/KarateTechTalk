Feature: sample karate test script

  Background:
    * url 'https://jsonplaceholder.typicode.com'

  Scenario: get all posts and then get the first post by id
    Given path 'posts'
    When method get
    Then status 200

    * def first = response[0]

    Given path 'posts', first.id
    When method get
    Then status 200

  Scenario: create a post and then get it by id
    * def postRequest = read('classpath:json/PostRequest.json')
    * def dataGenerator = Java.type('helpers.DataGenerator')
    * set postRequest.userId = dataGenerator.getRandomId()
    * print postRequest.userId

#    * def posts =
#      """
#      {
#        title: 'foo',
#        body: 'bar',
#        userId: 1
#      }
#      """

    Given path 'posts'
    And request postRequest
    When method post
    Then status 201

    * def postId = response.id
    * print 'post id is: ', postId
  