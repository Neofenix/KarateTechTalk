@debug
Feature: Hooks

    Background: hooks
        #callonce stores the value for the next scenarios
        # * def result = call read('classpath:helpers/Dummy.feature')

        #after hooks (afterScenario: execute every scenario)
        #* configure afterScenario = function(){ karate.call('classpath:helpers/Dummy.feature') }
        #* configure afterFeature =
        #"""
        #function(){
        #     karate.log('After Feature')
        #    }
        #"""

    Scenario: First scenario
        * print 'This is first scenario'

    Scenario: Second scenario
        * print 'This is second scenario'

