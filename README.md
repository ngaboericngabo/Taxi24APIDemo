# Taxi24APIDemo

Bk Demo

--------------Github repo-------------

https://github.com/ngaboericngabo/Taxi24APIDemo.git

-----Tools and Technologies used-------------

Spring-boot 2.0.4.RELEASE

MySQL 5.5.11

Java 8

Eclipse

Tomcat 8

Maven 3

-------------Deployment steps-------------

1.create database ,name: "taxiapi"(username:root,passwor:root,port:3306)
2.import mysql file into mysql database(this can be found ont he shared git hub repo)
3.deploy war file on tomacat server(this can be found on the shared git hub repo)
4.start tomacat server

if database connection denied follow the bellow steps:

1.stop tomacat server
2.change the "application.properties" by mysql  local configurations 
path:\Taxi24APIDemo\src\main\resources
3.do mvn clean install to get war 
4.deploy a new war on tomacat server
5.restart the server

---------------Test------------------------

1.you can use any tool to test web services
ex:Mozilla Rest client plugin,.....

-----------solutions----------------------

DRIVER
-------
scenario:Get lit of all drivers
Method:GET
http://localhost:8080/Taxi24BkAPI/getTaxi24/findUserByUserCategoryCode/DRIVER

scenario:Get a list of all available drivers
Method:GET
http://localhost:8080/Taxi24BkAPI/getTaxi24/findAvailableDriver

scenario:Get a list of all available drivers within 3km for a specific location
METHOD:GET
http://localhost:8080/Taxi24BkAPI/getTaxi24/availableDriverWithin3km/-1.971657/30.102971

scenario:Get a specific driver by ID
METHOD:GET
http://localhost:8080/Taxi24BkAPI/getTaxi24/getDriverById/20


TRIPS
-----
scenario:Create a new ‘Trip’ request by assigning a driver to a rider
METHOD:GET
http://localhost:8080/Taxi24BkAPI/getTaxi24/createNewTrip/20/13


scenario:Complete a trip
METHOD:PUT
http://localhost:8080/Taxi24BkAPI/getTaxi24/competeTrip/2

scenario:Get a list of all active Trips
METHOD:GET
http://localhost:8080/Taxi24BkAPI/getTaxi24/getActiveTrip


RIDERS
------
scenario:Get a list of all riders
METHOD:GET
http://localhost:8080/Taxi24BkAPI/getTaxi24/findUserByUserCategoryCode/RIDER

scenario:Get a specific rider by ID
METHOD:GET
http://localhost:8080/Taxi24BkAPI/getTaxi24/getRidersById/19

scenario:For a specific driver, get a list of the 3 closest drivers(This will based on how may km provided in the request)
METHOD:GET
http://localhost:8080/Taxi24BkAPI/getTaxi24/get3closeClosestDriver/20/6



-----Thank you!------





