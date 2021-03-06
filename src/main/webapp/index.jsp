<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<body>
	<h2>
		<u>Congratulations! You start the application!!</u>
	</h2>

	Doubts?
	<br>
	<br> diego@diegosousa.com

	<h2>
		<u>For Service testing with the tool linux "curl":</u>
	</h2>


	<ul>
		<li><h3>See all services (OPTIONS)</h3></li>
	</ul>


	<b>Request:</b>
	<br /> curl -i -X OPTIONS
	http://localhost:8080/ExampleRestFul/api/person/

	<ul>
		<li><h3>Add Person (POST)</h3></li>
	</ul>

	<b>Request:</b>
	<br /> curl -i -X POST -H "Content-type: application/json" -d
	'{"name":"Diego","mail":"diego@diegosousa.com"}'
	http://localhost:8080/ExampleRestFul/api/person/
	<br />
	<br />
	<b>Response:</b>
	<br /> HTTP/1.1 201 Created
	<br /> Server: Apache-Coyote/1.1
	<br /> Location:
	http://localhost:8080/ExampleRestFul/person/diego@diegosousa.com
	<br /> Content-Location:
	http://localhost:8080/ExampleRestFul/person/diego@diegosousa.com
	<br /> Content-Type: application/json
	<br /> Transfer-Encoding: chunked
	<br /> Date: Mon, 22 Apr 2013 03:40:25 GMT
	<br />

	<br />{"mail":"diego@diegosousa.com","name":"Diego"}

	<ul>
		<li><h3>List All Person (GET)</h3></li>
	</ul>

	<b>Request:</b>
	<br /> curl -i -X GET http://localhost:8080/ExampleRestFul/api/person/
	<br />
	<br />
	<b>Response:</b>
	<br /> HTTP/1.1 200 OK
	<br /> Server: Apache-Coyote/1.1
	<br /> Content-Type: application/json
	<br /> Transfer-Encoding: chunked
	<br /> Date: Mon, 22 Apr 2013 03:35:58 GMT
	<br />

	<br />{"Person":[{"name":"Diego","mail":"diego@diegosousa.com"},{"name":"Sousa","mail":"sousa@diegosousa.com"}]}
	<br />

	<ul>
		<li><h3>Replace list of person (PUT)</h3></li>
	</ul>

	<b>Request:</b>
	<br /> curl -i -X PUT -H "Content-type: application/json" -d
	'[{"name":"DiegoEditedOne","mail":"mailOne@diegosoussa.com"},
	{"name":"DiegoEditedTwo", "mail":"mailTwo@diegosousa.com"}]'
	http://localhost:8080/ExampleRestFul/api/person/
	<br />
	<br />
	<b>Response:</b>
	<br /> HTTP/1.1 204 No Content
	<br /> Server: Apache-Coyote/1.1
	<br /> Date: Mon, 22 Apr 2013 03:47:46 GMT
	<br />

	<ul>
		<li><h3>Delete all person (DELETE)</h3></li>
	</ul>

	<b>Request:</b>
	<br /> curl -i -X DELETE
	http://localhost:8080/ExampleRestFul/api/person/
	<br />
	<br />
	<b>Response:</b>
	<br /> HTTP/1.1 204 No Content
	<br /> Server: Apache-Coyote/1.1
	<br /> Date: Mon, 22 Apr 2013 03:48:49 GMT
	<br />

	<ul>
		<li><h3>Get Person (GET)</h3></li>
	</ul>

	<b>Request:</b>
	<br /> curl -i -X GET
	http://localhost:8080/ExampleRestFul/api/person/diego@diegosousa.com
	<br />
	<br />
	<b>Response:</b>
	<br /> HTTP/1.1 200 OK
	<br /> Server: Apache-Coyote/1.1
	<br /> Content-Type: application/json
	<br /> Transfer-Encoding: chunked
	<br /> Date: Mon, 22 Apr 2013 03:43:10 GMT
	<br />

	<br />{"mail":"diego@diegosousa.com","name":"Diego"}

	<ul>
		<li><h3>Edit Person(PUT)</h3></li>
	</ul>

	<b>Request:</b>
	<br /> curl -i -X PUT -H "Content-type: application/json" -d
	'{"name":"DiegoEdited","mail":"mailEdited@diegosousa.com"}'
	http://localhost:8080/ExampleRestFul/api/person/diego@diegosousa.com
	<br />
	<br />
	<b>Response:</b>
	<br /> HTTP/1.1 204 No Content
	<br /> Server: Apache-Coyote/1.1
	<br /> Date: Mon, 22 Apr 2013 03:47:46 GMT
	<br />

	<ul>
		<li><h3>Delete Person (DELETE)</h3></li>
	</ul>

	<b>Request:</b>
	<br /> curl -i -X DELETE
	http://localhost:8080/ExampleRestFul/api/person/diego@diegosousa.com
	<br />
	<br />
	<b>Response:</b>
	<br /> HTTP/1.1 204 No Content
	<br /> Server: Apache-Coyote/1.1
	<br /> Date: Mon, 22 Apr 2013 03:48:49 GMT
	<br />

</body>
</html>
