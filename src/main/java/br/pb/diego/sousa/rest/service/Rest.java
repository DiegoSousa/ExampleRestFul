package br.pb.diego.sousa.rest.service;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import br.pb.diego.sousa.rest.entity.Person;
import br.pb.diego.sousa.rest.facade.Facade;

/**
 * Layer Rest
 * 
 * @author Diego Sousa, diego[at]diegosousa[dot]com
 * @version 0.0.1
 * @since 02/11/2012
 */

@Path(value = "/person")
public class Rest {

	private Facade facade = Facade.getInstance();
	private String uri = "http://localhost:8080/ExampleRestFul/person/";

	/**
	 * Method GET - Responsible for returning the list of Person.
	 * 
	 * @return Object Response with the list e the data of network.
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAllPerson() {

		List<Person> list = facade.listAllPerson();

		if (list != null) {
			JSONObject jObject = new JSONObject();
			try {
				JSONArray jArray = new JSONArray();
				for (Person person : list) {
					JSONObject personJSON = new JSONObject();
					personJSON.put("name", person.getName());
					personJSON.put("mail", person.getMail());
					jArray.put(personJSON);
				}
				jObject.put("Person", jArray);
			} catch (JSONException jse) {
				jse.printStackTrace();
			}
			return Response.status(200).type(MediaType.APPLICATION_JSON)
					.entity(jObject).build();
		}
		// Status code 500 - The server encountered an unexpected condition
		// which prevented it from fulfilling the request.
		return Response.status(500).build();

	}

	/**
	 * Method GET - Responsible by find a Person.
	 * 
	 * @param String
	 *            mail of Person
	 * 
	 * @return Object Response with the json of Person e the data of network.
	 */

	@GET
	@Path("{mail}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPerson(@PathParam("mail") String mail) {
		Person person = facade.findPerson(mail);

		if (person != null) {
			return Response.status(200).type(MediaType.APPLICATION_JSON)
					.entity(person).build();
		}
		// Status code 500 - The server encountered an unexpected condition
		// which prevented it from fulfilling the request.
		return Response.status(500).build();

	}

	/**
	 * Method POST - Responsible by add a Person.
	 * 
	 * @param Object
	 *            Person
	 * 
	 * @return Object Response with the data of network.
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPerson(Person person) {

		Person personAux = facade.addPerson(person);

		if (personAux != null) {
			URI uriAux = UriBuilder.fromUri(uri + personAux.getMail()).build();
			return Response.status(201).location(uriAux)
					.contentLocation(uriAux).type(MediaType.APPLICATION_JSON)
					.entity(personAux).build();
		}
		return Response.status(500).build();
	}

	/**
	 * Method PUT - Responsible by Edit a Person.
	 * 
	 * @param Object
	 *            Person
	 * 
	 * @return Object Response with the data of network.
	 */

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editPerson(Person person) {

		Person personAux = facade.editPerson(person);

		if (personAux != null) {
			return Response.status(204).build();
		}
		return Response.status(500).build();
	}

	/**
	 * Method DELETE - Responsible by Remove a Person.
	 * 
	 * @param String
	 *            - Mail of Person.
	 * 
	 * @return Object Response with the data of network.
	 */

	@DELETE
	@Path("{mail}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removePerson(@PathParam("mail") String mail) {
		Person person;
		if ((person = facade.findPerson(mail)) != null) {
			if (facade.removePerson(person) != null) {

				return Response.status(204).build();
			}
			return Response.status(500).build();
		}
		return Response.status(500).build();
	}

	/**
	 * Method responsible for clear all list.
	 * 
	 * @return Object Response with the data of network.
	 */

	@DELETE
	@Path("/clearlist")
	public Response clearList() {
		facade.clearList();
		return Response.status(204).build();
	}
}