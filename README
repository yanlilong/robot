This doucment is about how to use Toy-Robot Rest Service API.

This Rest service API implements a simulation of a toy robot moving on a square tablet. It uses a deterministic finite automaton to gain the performance.

Part 1: System requirement

maven 3, Java 1.8, Firefox or Chrome

Part 2: Build System

Build the project: mvn clean install

Run the project:   mvn spring-boot:run

Part 3: Consume Toy Robot Service

3.1 System Parameters

3.1.1 URL
http://localhost:8080/api/v1/toy-robot?PLACE=1,2,EAST&ACTIONS=MOVE,MOVE,LEFT,MOVE,REPORT

3.1.2 Rest Parameters
# PLACE: a sequence of X,Y,Direction, for example: PLACE=0,0,NORTH
# ACTIONS: sequence of actions split by comma, for example: ACTIONS=MOVE,MOVE,LEFT,MOVE,REPORT
NOTE:
1. acceptable values of Direction: EAST, NORTH, SOUTH, WEST
2. acceptable values of Action: MOVE, RIGHT, LEFT, REPORT
3. "REPORT" is required in the ACTIONS.

Part 4: Case studies and Error message

4.1 url robotError: 404 Error, including missing parameters
http://localhost:8080/api/v1/toy
output:404 Error,Request resource not Found

4.2 valid input:
http://localhost:8080/api/v1/toy-robot?PLACE=1,2,NORTH&ACTIONS=MOVE,REPORT
output:{"x":1,"y":3,"direction":"NORTH"}

4.3 invalid input: Missing Robot ERROR
http://localhost:8080/api/v1/toy-robot?PLACE=1,6,EAST&ACTIONS=MOVE,MOVE,LEFT,MOVE,REPORT
output:invalid place: 1,6,EAST

4.4 invalid input: Missing REPORT ERROR
http://localhost:8080/api/v1/toy-robot?PLACE=0,0,NORTH&ACTIONS=MOVE
Error output:Please add REPORT in your Parameter ACTIONS:MOVE,in order to get output

4.5 invalid actions skipped
For example: http://localhost:8080/api/v1/toy-robot?PLACE=4,4,NORTH&ACTIONS=MOVE,REPORT
The action MOVE will be ignored, and the output is 4,4,NORTH
