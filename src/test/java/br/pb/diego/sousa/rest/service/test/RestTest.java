/**
 * 
 */
package br.pb.diego.sousa.rest.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.pb.diego.sousa.rest.entity.Person;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * This class is responsible for test the methods of interface Rest of person.
 * 
 * @author Diego Sousa, diego[at]diegosousa[dot]com
 * @version 0.0.1
 * @since 02/11/2012
 */

public class RestTest {

	/**
	 * @throws java.lang.Exception
	 */
	private static WebResource service;
	private final static String urlRoot = "http://localhost:8080/ExampleRestFull/";
	private final static String resourcePath = "api";
	private final static String typeMsg = MediaType.APPLICATION_JSON;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = Client.create(new DefaultClientConfig()).resource(
				UriBuilder.fromUri(urlRoot).build());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * 
	 * Clean persistence.
	 * 
	 * @throws java.lang.Exception
	 *             Ps: Code 204 is a success message unanswered.
	 */
	@Before
	public void setUp() throws Exception {
		ClientResponse crClearList = getResourceClearList();
		assertEquals(204, crClearList.getStatus());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link br.pb.diego.sousa.rest.service.Rest#addPerson(br.pb.diego.sousa.rest.entity.Person)}
	 * .
	 */

	@Test
	public void testAddPerson() {
		JSONObject jsonObjectAddPersonOut = null;
		JSONObject jsonObjectAddPerson = new JSONObject();
		try {
			jsonObjectAddPerson.put("name", "diego");
			jsonObjectAddPerson.put("mail", "diego@diegosousa.com");

			// AddObject
			ClientResponse crAddPerson = getResourceAddPerson(jsonObjectAddPerson);
			assertEquals(200, crAddPerson.getStatus());

			jsonObjectAddPersonOut = new JSONObject(
					crAddPerson.getEntity(String.class));

			assertEquals("diego@diegosousa.com",
					jsonObjectAddPersonOut.getString("mail"));

		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test method for
	 * {@link br.pb.diego.sousa.rest.service.Rest#removePerson(br.pb.diego.sousa.rest.entity.Person)}
	 * .
	 */
	@Test
	public void testRemovePerson() {

		JSONObject jsonObjectAddPersonOut = null;
		JSONObject jsonObjectRemovePersonOut = null;
		JSONObject jsonObjectPerson = new JSONObject();
		
		try {
			jsonObjectPerson.put("name", "diego");
			jsonObjectPerson.put("mail", "diego@diegosousa.com");

			// AddObject
			ClientResponse crAddPerson = getResourceAddPerson(jsonObjectPerson);
			assertEquals(200, crAddPerson.getStatus());

			jsonObjectAddPersonOut = new JSONObject(
					crAddPerson.getEntity(String.class));

			assertEquals("diego@diegosousa.com",
					jsonObjectAddPersonOut.getString("mail"));

			// RemoveObject
			ClientResponse crRemovePerson = getResourceRemovePerson(jsonObjectPerson);
			assertEquals(200, crRemovePerson.getStatus());

			jsonObjectRemovePersonOut = new JSONObject(
					crRemovePerson.getEntity(String.class));

			assertEquals("diego@diegosousa.com",
					jsonObjectRemovePersonOut.getString("mail"));

		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test method for
	 * {@link br.pb.diego.sousa.rest.service.Rest#editPerson(br.pb.diego.sousa.rest.entity.Person)}
	 * .
	 */
	@Test
	public void testEditPerson() {
		// Create Json
		JSONObject jsonObjectAddPerson = new JSONObject();
		try {
			jsonObjectAddPerson.put("name", "diego");
			jsonObjectAddPerson.put("mail", "diego@diegosousa.com");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		// AddObject
		ClientResponse crAddPerson = getResourceAddPerson(jsonObjectAddPerson);
		assertEquals(200, crAddPerson.getStatus());
		assertEquals("diego@diegosousa.com", crAddPerson
				.getEntity(Person.class).getMail());

		// Getting the List All Person and checks if "diego" was add.
		ClientResponse crListAllPerson = getResourceListAllPerson();
		List<Person> listAllPerson = crListAllPerson
				.getEntity(new GenericType<List<Person>>() {
				});
		assertEquals(200, crListAllPerson.getStatus());
		assertEquals(1, listAllPerson.size());
		assertTrue(listAllPerson.get(0).getName().equals("diego"));

		// Edit the Object
		JSONObject jsonObjectEditPerson = new JSONObject();
		try {
			jsonObjectEditPerson.put("name", "Fulano");
			jsonObjectEditPerson.put("mail", "diego@diegosousa.com");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		ClientResponse CREditPerson = getResourceEditPerson(jsonObjectEditPerson);
		assertEquals(200, CREditPerson.getStatus());

		// Getting the List All Person and checks if "diego" was edited.
		ClientResponse crListAllPersonTwo = getResourceListAllPerson();
		List<Person> listAllPersonTwo = crListAllPersonTwo
				.getEntity(new GenericType<List<Person>>() {
				});
		assertEquals(200, crListAllPersonTwo.getStatus());
		assertEquals(1, listAllPersonTwo.size());
		assertTrue(listAllPersonTwo.get(0).getName().equals("Fulano"));

	}

	/**
	 * Test method for
	 * {@link br.pb.diego.sousa.rest.service.Rest#findPerson(java.lang.String)}.
	 */
	@Test
	public void testFindPerson() {
		// Create Json
		JSONObject jsonObjectAddPerson = new JSONObject();
		try {
			jsonObjectAddPerson.put("mail", "diego@diegosousa.com");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		// AddObject
		ClientResponse crAddPerson = getResourceAddPerson(jsonObjectAddPerson);
		assertEquals(200, crAddPerson.getStatus());
		assertEquals("diego@diegosousa.com", crAddPerson
				.getEntity(Person.class).getMail());

		// Getting the List All Person and checks if "diego" was add.
		ClientResponse ClientPerson = getResourceFindPerson(jsonObjectAddPerson);
		Person person = ClientPerson.getEntity(Person.class);
		assertEquals(200, ClientPerson.getStatus());
		assertEquals("diego@diegosousa.com", person.getMail());

	}

	/**
	 * Test method for
	 * {@link br.pb.diego.sousa.rest.service.Rest#listAllPerson()}.
	 */
	@Test
	public void testListAllPerson() {
		// Create Json
		JSONObject jsonObjectDiego = new JSONObject();
		try {
			jsonObjectDiego.put("name", "diego");
			jsonObjectDiego.put("mail", "diego@diegosousa.com");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		// Create Json
		JSONObject jsonObjectMaria = new JSONObject();
		try {
			jsonObjectMaria.put("name", "maria");
			jsonObjectMaria.put("mail", "maria@maria.com");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		// AddObjectDiego
		ClientResponse crAddDiego = getResourceAddPerson(jsonObjectDiego);
		assertEquals(200, crAddDiego.getStatus());
		assertEquals("diego@diegosousa.com", crAddDiego.getEntity(Person.class)
				.getMail());

		// AddObjectMaria
		ClientResponse crAddMaria = getResourceAddPerson(jsonObjectMaria);
		assertEquals(200, crAddMaria.getStatus());
		assertEquals("maria@maria.com", crAddMaria.getEntity(Person.class)
				.getMail());

		// Getting the List All Person and checks if "diego" was add.
		ClientResponse crListAllPerson = getResourceListAllPerson();
		List<Person> listAllPerson = crListAllPerson
				.getEntity(new GenericType<List<Person>>() {
				});
		assertEquals(200, crListAllPerson.getStatus());
		assertEquals(2, listAllPerson.size());

	}

	public ClientResponse getResourceAddPerson(Object jsonObject) {
		return service.path(resourcePath).path("person").path("addperson")
				.accept(typeMsg).post(ClientResponse.class, jsonObject);
	}

	public ClientResponse getResourceRemovePerson(Object jsonObject) {

		return service.path(resourcePath).path("person").path("removeperson")
				.accept(typeMsg).delete(ClientResponse.class, jsonObject);
	}

	public ClientResponse getResourceEditPerson(Object jsonObject) {
		return service.path(resourcePath).path("person").path("editperson")
				.accept(typeMsg).put(ClientResponse.class, jsonObject);
	}

	public ClientResponse getResourceListAllPerson() {
		return service.path(resourcePath).path("person").path("listallperson")
				.accept(typeMsg).get(ClientResponse.class);

	}

	public ClientResponse getResourceFindPerson(Object jsonObject) {
		return service.path(resourcePath).path("person").path("findperson")
				.accept(typeMsg).post(ClientResponse.class, jsonObject);

	}

	public ClientResponse getResourceClearList() {
		return service.path(resourcePath).path("person").path("clearlist")
				.delete(ClientResponse.class);

	}

}
