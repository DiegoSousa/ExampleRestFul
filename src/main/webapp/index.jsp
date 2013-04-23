<html>
<body>
<h2>Congratulations you start the application!!</h2>

Doubts?<br><br>
diego@diegosousa.com

<h2>For Service testing with the tool linux "curl":</h2>

<h3> See all services:</h3>

<b>Request:</b><br />	

	curl -i -X OPTIONS http://localhost:8080/ExampleRestFull/api/person/

<h3>Add Person</h3>

<b>Request:</b>
<br />

	curl -i -X POST -H "Content-type: application/json" -d '{"name":"Diego","mail":"diego@diegosousa.com"}' http://localhost:8080/ExampleRestFull/api/person/
<br />	
<br />
<b>Response:</b>
<br />
	HTTP/1.1 201 Created<br />
	Server: Apache-Coyote/1.1<br />
	Location: http://localhost:8080/ExampleRestFull/person/diego@diegosousa.com<br />
	Content-Location: http://localhost:8080/ExampleRestFull/person/diego@diegosousa.com<br />
	Content-Type: application/json<br />
	Transfer-Encoding: chunked<br />
	Date: Mon, 22 Apr 2013 03:40:25 GMT<br />

<h3>List All Person</h3>

<b>Request:</b>
<br />
	curl -i -X GET http://localhost:8080/ExampleRestFull/api/person/
<br />
<br />
<b>Response:</b>
<br />
	HTTP/1.1 200 OK<br />
	Server: Apache-Coyote/1.1<br />
	Content-Type: application/json<br />
	Transfer-Encoding: chunked<br />
	Date: Mon, 22 Apr 2013 03:35:58 GMT<br />

<h3>Get Person</h3>

<b>Request:</b>
<br />
	curl -i -X GET http://localhost:8080/ExampleRestFull/api/person/diego@diegosousa.com
<br />
<br />
<b>Response:</b>
<br />
	HTTP/1.1 200 OK<br />
	Server: Apache-Coyote/1.1<br />
	Content-Type: application/json<br />
	Transfer-Encoding: chunked<br />
	Date: Mon, 22 Apr 2013 03:43:10 GMT<br />

<h3>Edit Person</h3>

<b>Request:</b>
<br />
	curl -i -X PUT -H "Content-type: application/json" -d '{"name":"Diego2","mail":"diego@diegosousa.com"}' http://localhost:8080/ExampleRestFull/api/person/
<br />
<br />
<b>Response:</b>
<br />
	HTTP/1.1 204 No Content<br />
	Server: Apache-Coyote/1.1<br />
	Date: Mon, 22 Apr 2013 03:47:46 GMT<br />

<h3>Delete Person</h3>

<b>Request:</b>
<br />
	curl -i -X DELETE http://localhost:8080/ExampleRestFull/api/person/diego@diegosousa.com
<br />
<br />
<b>Response:</b>
<br />
	HTTP/1.1 204 No Content<br />
	Server: Apache-Coyote/1.1<br />
	Date: Mon, 22 Apr 2013 03:48:49 GMT<br />

</body>
</html>
