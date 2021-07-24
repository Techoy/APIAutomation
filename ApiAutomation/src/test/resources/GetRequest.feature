
Feature: Employee REST Api requests


    Scenario: GET REQUEST
        When I send a GET request for "https://reqres.in/api/users?page=2"
        Then Status code is 200
        And match response "data[0].id==7"
      And match response "data[0].email==michael.lawson@reqres.in"


    Scenario: POST REQUEST
      When I send the POST request for "http://restapi.demoqa.com/customer/register"
      Then Status code is 201
     And match response "SuccessCode==OPERATION_SUCCESS"