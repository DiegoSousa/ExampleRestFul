Example RestFul With Jersey and Junit Test.
================
------------------------------------

1 - For run the project by line command:

	$ mvn package -Dmaven.test.skip=true tomcat:run

2 - For run the project by eclipse:
-----------------------------------

Requirements:

Maven: Version 2+  
Web Server: Apache Tomcat 7+  
JDK: Version 6+  
IDE: Eclipse Java EE indigo+<br />

**2.1 - To install Maven:**

	In Eclipse go in -> Help -> Eclipse MarketPlace -> install the "Maven Integration for eclipse WTP".

<h3>To correctly import the application just follow the following steps.</h3>

**2.2 - Using a Terminal or a Customer Git, do the clone within your workspace.**

	$ cd ~/workspace/

**2.3 - Ctrl+C and Ctrl+Shift+V in terminal:**

	$ git clone https://github.com/DiegoSousa/ExampleRestFul.git

**2 - In eclipse go in:** 

	file -> import -> type in the search above "Existing maven projects" -> next -> Browser -> 
	select the project ExampleRestFull -> Finish.

**3 - Wait until the maven download all libraries.**

The End!

**Doubts?**

**Contact** diego[at]diegosousa[dot]com **or** diego.sousa[at]dce.ufpb.br

------------------------------------------------------------------------
3 - Service testing with the tool linux curl (ps: Do this with Running Server):


<h3> See all services</h3>

	curl -i -X OPTIONS http://localhost:8080/ExampleRestFull/api/person/

<h3>Add Person</h3>

**Request:**

	curl -i -X POST -H "Content-type: application/json" -d '{"name":"Diego","mail":"diego@diegosousa.com"}' http://localhost:8080/ExampleRestFull/api/person/

**Response:**

	HTTP/1.1 201 Created
	Server: Apache-Coyote/1.1
	Location: http://localhost:8080/ExampleRestFull/person/diego@diegosousa.com
	Content-Location: http://localhost:8080/ExampleRestFull/person/diego@diegosousa.com
	Content-Type: application/json
	Transfer-Encoding: chunked
	Date: Mon, 22 Apr 2013 03:40:25 GMT

<h3>List All Person</h3>

**Request:**

	curl -i -X GET http://localhost:8080/ExampleRestFull/api/person/

**Response:**

	HTTP/1.1 200 OK
	Server: Apache-Coyote/1.1
	Content-Type: application/json
	Transfer-Encoding: chunked
	Date: Mon, 22 Apr 2013 03:35:58 GMT

<h3>Get Person</h3>

**Request:**

	curl -i -X GET http://localhost:8080/ExampleRestFull/api/person/diego@diegosousa.com

**Response:**

	HTTP/1.1 200 OK
	Server: Apache-Coyote/1.1
	Content-Type: application/json
	Transfer-Encoding: chunked
	Date: Mon, 22 Apr 2013 03:43:10 GMT

<h3>Edit Person</h3>

**Request:**

	curl -i -X PUT -H "Content-type: application/json" -d '{"name":"Diego2","mail":"diego@diegosousa.com"}' http://localhost:8080/ExampleRestFull/api/person/

**Response:**

	HTTP/1.1 204 No Content
	Server: Apache-Coyote/1.1
	Date: Mon, 22 Apr 2013 03:47:46 GMT

<h3>Delete Person</h3>

**Request:**

	curl -i -X DELETE http://localhost:8080/ExampleRestFull/api/person/diego@diegosousa.com

**Response:**

	HTTP/1.1 204 No Content
	Server: Apache-Coyote/1.1
	Date: Mon, 22 Apr 2013 03:48:49 GMT