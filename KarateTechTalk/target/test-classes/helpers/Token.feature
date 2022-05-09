Feature: Dummy

  Scenario: Dummy
    * def dataGenerator = Java.type('helpers.DataGenerator')
    * def Token = dataGenerator.getToken()
    * print Token