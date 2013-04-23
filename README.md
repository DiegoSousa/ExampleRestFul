<h1> Example RestFul.

<h3>1 - For run the project by line command:

	mvn package -Dmaven.test.skip=true tomcat:run

<h3>2 - For run the project by eclipse:

<b>Requirements:</b>

Maven: Version 2+<br />
Web Server: Apache Tomcat 7+<br />
JDK: Version 6+<br />
IDE: Eclipse Java EE indigo+<br />

<b>2.1 - To install Maven:</b>

	In Eclipse go in -> Help -> Eclipse MarketPlace -> install the "Maven Integration for eclipse WTP".

<h2>To correctly import the application just follow the following steps.

<b>2.2 - Using a Terminal or a Customer Git, do the clone within your workspace.</b>

	$ cd ~/workspace/

<b>2.3 - Ctrl+C and Ctrl+Shift+V in terminal:</b>

	$ git clone https://github.com/DiegoSousa/ExampleRestFul.git

<b>2.4 - In eclipse go in:</b> 

	file -> import -> type in the search above "Existing maven projects" -> next -> Browser -> 
	select the project ExampleRestFul -> Finish.

<b> Wait until the maven download all libraries.</b>

The End!

<b>Doubts?</b>

<b>Contact</b> diego[at]diegosousa[dot]com <b>or</b> diego.sousa[at]dce.ufpb.br


<h2>Service testing with the tool linux curl (ps: Do this with Running Server):

<h3> See all services

	curl -i -X OPTIONS http://localhost:8080/ExampleRestFul/api/person/

<h3>Add Person

<b>Request:</b>

	curl -i -X POST -H "Content-type: application/json" -d '{"name":"Diego","mail":"diego@diegosousa.com"}' http://localhost:8080/ExampleRestFul/api/person/

<b>Response:</b>

	HTTP/1.1 201 Created
	Server: Apache-Coyote/1.1
	Location: http://localhost:8080/ExampleRestFul/person/diego@diegosousa.com
	Content-Location: http://localhost:8080/ExampleRestFul/person/diego@diegosousa.com
	Content-Type: application/json
	Transfer-Encoding: chunked
	Date: Mon, 22 Apr 2013 03:40:25 GMT

<h3>List All Person

<b>Request:</b>

	curl -i -X GET http://localhost:8080/ExampleRestFul/api/person/

<b>Response:</b>

	HTTP/1.1 200 OK
	Server: Apache-Coyote/1.1
	Content-Type: application/json
	Transfer-Encoding: chunked
	Date: Mon, 22 Apr 2013 03:35:58 GMT

<h3>Get Person

<b>Request:</b>

	curl -i -X GET http://localhost:8080/ExampleRestFul/api/person/diego@diegosousa.com

<b>Response:</b>

	HTTP/1.1 200 OK
	Server: Apache-Coyote/1.1
	Content-Type: application/json
	Transfer-Encoding: chunked
	Date: Mon, 22 Apr 2013 03:43:10 GMT

<h3>Edit Person

<b>Request:</b>

	curl -i -X PUT -H "Content-type: application/json" -d '{"name":"Diego2","mail":"diego@diegosousa.com"}' http://localhost:8080/ExampleRestFul/api/person/

<b>Response:</b>

	HTTP/1.1 204 No Content
	Server: Apache-Coyote/1.1
	Date: Mon, 22 Apr 2013 03:47:46 GMT

<h3>Delete Person

<b>Request:</b>

	curl -i -X DELETE http://localhost:8080/ExampleRestFul/api/person/diego@diegosousa.com

<b>Response:</b>

	HTTP/1.1 204 No Content
	Server: Apache-Coyote/1.1
	Date: Mon, 22 Apr 2013 03:48:49 GMT