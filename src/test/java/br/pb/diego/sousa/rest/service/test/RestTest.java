package br.pb.diego.sousa.rest.service.test;

import static org.junit.Assert.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * This class is responsible for test the methods of interface Rest of person.
 * 
 * @author Diego Sousa, diego[at]diegosousa[dot]com
 * @version 0.0.1
 * @since 02/11/2012
 * 
 * Resources:
 * 
 * ${UrlFull}
 * 
 * Post One Person 
 * GET ALL 
 * Put ALL 
 * Delete All
 * 
 * ${UrlFull}/{value}
 * 
 * GET One Person 
 * PUT One Person 
 * Delete One Person
 * 
 */

public class RestTest {

	private static WebResource service;
	private static String uriRoot = "http://localhost:8080/ExampleRestFul/";
	private String resourcePath = "api/";
	private String pathPerson = "person/";
	private String UrlFull = uriRoot + resourcePath;
	private String typeMsg = MediaType.APPLICATION_JSON;
	private JSONObject entityJsonIn;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Starting the test facade class...");
		service = Client.create(new DefaultClientConfig()).resource(
				UriBuilder.fromUri(uriRoot).build());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Finished the test facade class!");
	}

	/**
	 * 
	 * Clean list of date.
	 * 
	 * @throws java.lang.Exception
	 *             Ps: Code 204 is a success message without body.
	 */
	@Before
	public void setUp() throws Exception {
		// Excluding all resources and testing the status code of the response.
		assertEquals(204, getResourceDeleteAll().getStatus());
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
	public final void testAddPerson() {

		JSONObject entityJsonOut;

		// ******* Adding Object***********

		ClientResponse crAddPerson = getResourcePost(createJson("diego",
				"diego@diegosousa.com"));

		// Verifying status code
		assertEquals(201, crAddPerson.getStatus());

		// Verifying Media Type
		assertEquals(MediaType.valueOf(typeMsg), crAddPerson.getType());
		try {
			// Verifying Location in header.
			assertEquals(
					UrlFull
							+ pathPerson
							+ createJson("diego", "diego@diegosousa.com")
									.getString("mail"), crAddPerson
							.getLocation().toString());

			entityJsonOut = new JSONObject(crAddPerson.getEntity(String.class));

			// Verifying entity in body.
			assertEquals("diego@diegosousa.com",
					entityJsonOut.getString("mail"));
			assertEquals("diego", entityJsonOut.getString("name"));

			// ******* Getting the List All Person ***********

			// Getting the List All Person and checks if "diego" was edited.
			ClientResponse crListAllPerson = getResourceGetAll();

			// Verifying status code
			assertEquals(200, crListAllPerson.getStatus());

			// Verifying Media Type
			assertEquals(MediaType.valueOf(typeMsg), crListAllPerson.getType());

			JSONArray jsonArray = new JSONObject(
					crListAllPerson.getEntity(String.class))
					.getJSONArray("Person");

			// Verifying entity in body.
			assertEquals(1, jsonArray.length());
			assertEquals("diego", jsonArray.getJSONObject(0).getString("name"));

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link br.pb.diego.sousa.rest.service.Rest#listAllPerson()}.
	 */
	@Test
	public final void testListAllPerson() {
		JSONObject entityJsonOut;

		// ******* Adding Object***********

		ClientResponse crAddPerson = getResourcePost(createJson("diego",
				"diego@diegosousa.com"));

		// Verifying status code
		assertEquals(201, crAddPerson.getStatus());

		// Verifying Media Type
		assertEquals(MediaType.valueOf(typeMsg), crAddPerson.getType());
		try {
			// Verifying Location in header.
			assertEquals(
					UrlFull
							+ pathPerson
							+ createJson("diego", "diego@diegosousa.com")
									.getString("mail"), crAddPerson
							.getLocation().toString());

			entityJsonOut = new JSONObject(crAddPerson.getEntity(String.class));

			// Verifying entity in body.
			assertEquals("diego@diegosousa.com",
					entityJsonOut.getString("mail"));
			assertEquals("diego", entityJsonOut.getString("name"));

			// ******* Getting the List All Person ***********

			// Getting the List All Person and checks if "diego" was edited.
			ClientResponse crListAllPerson = getResourceGetAll();

			// Verifying status code
			assertEquals(200, crListAllPerson.getStatus());

			// Verifying Media Type
			assertEquals(MediaType.valueOf(typeMsg), crListAllPerson.getType());

			JSONArray jsonArray = new JSONObject(
					crListAllPerson.getEntity(String.class))
					.getJSONArray("Person");

			// Verifying entity in body.
			assertEquals(1, jsonArray.length());
			assertEquals("diego", jsonArray.getJSONObject(0).getString("name"));

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link br.pb.diego.sousa.rest.service.Rest#updateListOfPerson(org.codehaus.jettison.json.JSONArray)}
	 * .
	 */
	@Test
	public final void testUpdateListOfPerson() {

		JSONObject entityJsonOut;
		JSONObject entityJsonOutTwo;

		// ******* AddObject***********

		ClientResponse crAddPerson = getResourcePost(createJson("diego",
				"diego@diegosousa.com"));
		ClientResponse crAddPersonTwo = getResourcePost(createJson("maria",
				"maria@diegosousa.com"));

		// Verifying status code
		assertEquals(201, crAddPerson.getStatus());
		assertEquals(201, crAddPersonTwo.getStatus());

		// Verifying Media Type
		assertEquals(MediaType.valueOf(typeMsg), crAddPerson.getType());
		assertEquals(MediaType.valueOf(typeMsg), crAddPersonTwo.getType());

		try {
			// Verifying Location in header.
			assertEquals(
					UrlFull
							+ pathPerson
							+ createJson("diego", "diego@diegosousa.com")
									.getString("mail"), crAddPerson
							.getLocation().toString());

			assertEquals(
					UrlFull
							+ pathPerson
							+ createJson("maria", "maria@diegosousa.com")
									.getString("mail"), crAddPersonTwo
							.getLocation().toString());

			entityJsonOut = new JSONObject(crAddPerson.getEntity(String.class));
			entityJsonOutTwo = new JSONObject(
					crAddPersonTwo.getEntity(String.class));

			// Verifying entity in body.
			assertEquals("diego@diegosousa.com",
					entityJsonOut.getString("mail"));
			assertEquals("diego", entityJsonOut.getString("name"));

			assertEquals("maria@diegosousa.com",
					entityJsonOutTwo.getString("mail"));
			assertEquals("maria", entityJsonOutTwo.getString("name"));

			// ******* Getting the List All Person ***********

			// Getting the List All Person.
			ClientResponse crListAllPerson = getResourceGetAll();

			// Verifying status code
			assertEquals(200, crListAllPerson.getStatus());

			// Verifying Media Type
			assertEquals(MediaType.valueOf(typeMsg), crListAllPerson.getType());

			// Getting the List.
			JSONArray jsonArrayAllPersonOne = new JSONObject(
					crListAllPerson.getEntity(String.class))
					.getJSONArray("Person");

			// Verifying entity in body.
			assertEquals(2, jsonArrayAllPersonOne.length());

		} catch (JSONException e) {
			e.printStackTrace();
		}

		// ******* Replace all list of person ***********

		JSONArray jsonArrayAddPerson = new JSONArray();
		jsonArrayAddPerson.put(createJson("Fulano", "fulano@diegosousa.com"));
		jsonArrayAddPerson
				.put(createJson("Beltrano", "beltrano@diegosousa.com"));
		jsonArrayAddPerson.put(createJson("Bia", "bia@diegosousa.com"));

		// Replace list of person and verifying status code.
		assertEquals(204, getResourcePutList(jsonArrayAddPerson).getStatus());

		// ******* Getting the list all of person ***********

		// Getting the List All Person and checks if the list was edited.
		ClientResponse crListAllPerson = getResourceGetAll();

		// Verifying status code
		assertEquals(200, crListAllPerson.getStatus());

		// Verifying Media Type
		assertEquals(MediaType.valueOf(typeMsg), crListAllPerson.getType());

		try {
			JSONArray jsonArrayAllPersonTwo = new JSONObject(
					crListAllPerson.getEntity(String.class))
					.getJSONArray("Person");

			// Verifying entity in body.
			assertEquals(3, jsonArrayAllPersonTwo.length());

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link br.pb.diego.sousa.rest.service.Rest#removeAllPerson()}.
	 */
	@Test
	public final void testRemoveAllPerson() {

		JSONObject entityJsonOut;
		JSONObject entityJsonOutTwo;

		// ******* AddObject***********

		ClientResponse crAddPerson = getResourcePost(createJson("diego",
				"diego@diegosousa.com"));
		ClientResponse crAddPersonTwo = getResourcePost(createJson("maria",
				"maria@diegosousa.com"));

		// Verifying status code
		assertEquals(201, crAddPerson.getStatus());
		assertEquals(201, crAddPersonTwo.getStatus());

		// Verifying Media Type
		assertEquals(MediaType.valueOf(typeMsg), crAddPerson.getType());
		assertEquals(MediaType.valueOf(typeMsg), crAddPersonTwo.getType());

		try {
			// Verifying Location in header.
			assertEquals(
					UrlFull
							+ pathPerson
							+ createJson("diego", "diego@diegosousa.com")
									.getString("mail"), crAddPerson
							.getLocation().toString());

			assertEquals(
					UrlFull
							+ pathPerson
							+ createJson("maria", "maria@diegosousa.com")
									.getString("mail"), crAddPersonTwo
							.getLocation().toString());

			entityJsonOut = new JSONObject(crAddPerson.getEntity(String.class));
			entityJsonOutTwo = new JSONObject(
					crAddPersonTwo.getEntity(String.class));

			// Verifying entity in body.
			assertEquals("diego@diegosousa.com",
					entityJsonOut.getString("mail"));
			assertEquals("diego", entityJsonOut.getString("name"));

			assertEquals("maria@diegosousa.com",
					entityJsonOutTwo.getString("mail"));
			assertEquals("maria", entityJsonOutTwo.getString("name"));

			// ******* Getting the List All Person ***********

			// Getting the List All Person.
			ClientResponse crListAllPerson = getResourceGetAll();

			// Verifying status code
			assertEquals(200, crListAllPerson.getStatus());

			// Verifying Media Type
			assertEquals(MediaType.valueOf(typeMsg), crListAllPerson.getType());

			JSONArray jsonArrayAllPersonOne = new JSONObject(
					crListAllPerson.getEntity(String.class))
					.getJSONArray("Person");

			// Verifying entity in body.
			assertEquals(2, jsonArrayAllPersonOne.length());

			// ******* Removing All Person ***********

			// Removing Object and testing code status.
			assertEquals(204, getResourceDeleteAll().getStatus());

			// ******* Getting the List All Person ***********

			// Getting the List All Person.
			ClientResponse crListAllPersonTwo = getResourceGetAll();

			// Verifying status code
			assertEquals(200, crListAllPersonTwo.getStatus());

			// Verifying Media Type
			assertEquals(MediaType.valueOf(typeMsg),
					crListAllPersonTwo.getType());

			JSONArray jsonArrayAllPersonTwo = new JSONObject(
					crListAllPersonTwo.getEntity(String.class))
					.getJSONArray("Person");

			// Verifying entity in body.
			assertEquals(0, jsonArrayAllPersonTwo.length());

		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test method for
	 * {@link br.pb.diego.sousa.rest.service.Rest#getPerson(java.lang.String)}.
	 */
	@Test
	public final void testGetPerson() {

		JSONObject entityJsonOut;

		// ******* Adding person ***********

		ClientResponse crAddPerson = getResourcePost(createJson("diego",
				"diego@diegosousa.com"));

		// Verifying status code
		assertEquals(201, crAddPerson.getStatus());

		// Verifying Media Type
		assertEquals(MediaType.valueOf(typeMsg), crAddPerson.getType());
		try {
			// Verifying Location in header.
			assertEquals(
					UrlFull
							+ pathPerson
							+ createJson("diego", "diego@diegosousa.com")
									.getString("mail"), crAddPerson
							.getLocation().toString());

			entityJsonOut = new JSONObject(crAddPerson.getEntity(String.class));

			// Verifying entity in body.
			assertEquals("diego@diegosousa.com",
					entityJsonOut.getString("mail"));
			assertEquals("diego", entityJsonOut.getString("name"));

			// ******* Getting Person ***********

			ClientResponse crGetPerson = getResourceGet("diego@diegosousa.com");

			// Verifying status code
			assertEquals(200, crGetPerson.getStatus());

			// Verifying Media Type
			assertEquals(MediaType.valueOf(typeMsg), crGetPerson.getType());

			// Verifying entity in body.
			assertEquals("diego",
					new JSONObject(crGetPerson.getEntity(String.class))
							.getString("name"));

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link br.pb.diego.sousa.rest.service.Rest#editPerson(java.lang.String, br.pb.diego.sousa.rest.entity.Person)}
	 * .
	 */
	@Test
	public final void testEditPerson() {

		JSONObject entityJsonOut;

		// ******* Adding Person ***********

		ClientResponse crAddPerson = getResourcePost(createJson("diego",
				"diego@diegosousa.com"));

		// Verifying status code
		assertEquals(201, crAddPerson.getStatus());

		// Verifying Media Type
		assertEquals(MediaType.valueOf(typeMsg), crAddPerson.getType());

		try {
			// Verifying Location in header.
			assertEquals(
					UrlFull
							+ pathPerson
							+ createJson("diego", "diego@diegosousa.com")
									.getString("mail"), crAddPerson
							.getLocation().toString());

			entityJsonOut = new JSONObject(crAddPerson.getEntity(String.class));

			// Verifying entity in body.
			assertEquals("diego@diegosousa.com",
					entityJsonOut.getString("mail"));
			assertEquals("diego", entityJsonOut.getString("name"));

			// ******* Updating Person ***********

			// Editing person and verifying status code
			assertEquals(
					204,
					getResourcePut("diego@diegosousa.com",
							createJson("Fulano", "fulano@diegosousa.com"))
							.getStatus());

			// ******* Getting the List All Person ***********

			// Getting the List All Person and checks if "diego" was edited.
			ClientResponse crListAllPerson = getResourceGetAll();

			// Verifying status code
			assertEquals(200, crListAllPerson.getStatus());

			// Verifying Media Type
			assertEquals(MediaType.valueOf(typeMsg), crListAllPerson.getType());

			JSONArray jsonArray = new JSONObject(
					crListAllPerson.getEntity(String.class))
					.getJSONArray("Person");

			// Verifying entity in body.
			assertEquals(1, jsonArray.length());
			assertEquals("Fulano", jsonArray.getJSONObject(0).getString("name"));

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link br.pb.diego.sousa.rest.service.Rest#removePerson(java.lang.String)}
	 * 
	 */

	@Test
	public final void testRemovePerson() {

		JSONObject entityJsonOut;
		JSONObject entityJsonOutTwo;

		// ******* AddObject***********

		ClientResponse crAddPerson = getResourcePost(createJson("diego",
				"diego@diegosousa.com"));
		ClientResponse crAddPersonTwo = getResourcePost(createJson("maria",
				"maria@diegosousa.com"));

		// Verifying status code
		assertEquals(201, crAddPerson.getStatus());
		assertEquals(201, crAddPersonTwo.getStatus());

		// Verifying Media Type
		assertEquals(MediaType.valueOf(typeMsg), crAddPerson.getType());
		assertEquals(MediaType.valueOf(typeMsg), crAddPersonTwo.getType());

		try {
			// Verifying Location in header.
			assertEquals(
					UrlFull
							+ pathPerson
							+ createJson("diego", "diego@diegosousa.com")
									.getString("mail"), crAddPerson
							.getLocation().toString());

			assertEquals(
					UrlFull
							+ pathPerson
							+ createJson("maria", "maria@diegosousa.com")
									.getString("mail"), crAddPersonTwo
							.getLocation().toString());

			entityJsonOut = new JSONObject(crAddPerson.getEntity(String.class));
			entityJsonOutTwo = new JSONObject(
					crAddPersonTwo.getEntity(String.class));

			// Verifying entity in body.
			assertEquals("diego@diegosousa.com",
					entityJsonOut.getString("mail"));
			assertEquals("diego", entityJsonOut.getString("name"));

			assertEquals("maria@diegosousa.com",
					entityJsonOutTwo.getString("mail"));
			assertEquals("maria", entityJsonOutTwo.getString("name"));

			// ******* Getting the List All Person ***********

			// Getting the List All Person.
			ClientResponse crListAllPerson = getResourceGetAll();

			// Verifying status code
			assertEquals(200, crListAllPerson.getStatus());

			// Verifying Media Type
			assertEquals(MediaType.valueOf(typeMsg), crListAllPerson.getType());

			JSONArray jsonArrayAllPersonOne = new JSONObject(
					crListAllPerson.getEntity(String.class))
					.getJSONArray("Person");

			// Verifying entity in body.
			assertEquals(2, jsonArrayAllPersonOne.length());

			// ******* Removing Person ***********

			// Removing Object and testing code status.
			assertEquals(204, getResourceDelete("diego@diegosousa.com")
					.getStatus());

			// ******* Getting the List All Person ***********

			// Getting the List All Person.
			ClientResponse crListAllPersonTwo = getResourceGetAll();

			// Verifying status code
			assertEquals(200, crListAllPersonTwo.getStatus());

			// Verifying Media Type
			assertEquals(MediaType.valueOf(typeMsg),
					crListAllPersonTwo.getType());

			JSONArray jsonArrayAllPersonTwo = new JSONObject(
					crListAllPersonTwo.getEntity(String.class))
					.getJSONArray("Person");

			// Verifying entity in body.
			assertEquals(1, jsonArrayAllPersonTwo.length());

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Request using method HTTP GET for get All Person.
	 * 
	 * @return ClientResponse
	 */

	public ClientResponse getResourceGetAll() {
		return service.path(resourcePath).path("person")
				.get(ClientResponse.class);
	}

	/**
	 * Request using method HTTP POST for add person.
	 * 
	 * @param jsonObject
	 * @return ClientResponse
	 */

	public ClientResponse getResourcePost(JSONObject jsonObject) {
		return service.path(resourcePath).path("person").accept(typeMsg)
				.post(ClientResponse.class, jsonObject);
	}

	/**
	 * Request using method HTTP PUT for edit all person.
	 * 
	 * @param JSONArray
	 * @return ClientResponse
	 */

	public ClientResponse getResourcePutList(JSONArray jsonArray) {
		return service.path(resourcePath).path("person").accept(typeMsg)
				.put(ClientResponse.class, jsonArray);
	}

	/**
	 * Request using method HTTP DELETE for removed all person.
	 * 
	 * @return ClientResponse
	 */

	public ClientResponse getResourceDeleteAll() {
		return service.path(resourcePath).path("person")
				.delete(ClientResponse.class);
	}

	/**
	 * Request using method HTTP GET for get one person.
	 * 
	 * @param mail
	 * @return ClientResponse
	 */

	public ClientResponse getResourceGet(String mail) {
		return service.path(resourcePath).path("person").path(mail)
				.get(ClientResponse.class);
	}

	/**
	 * Request using method HTTP PUT for replace list all person.
	 * 
	 * @param mail
	 * @param jsonObject
	 * @return ClientResponse.
	 */

	public ClientResponse getResourcePut(String mail, JSONObject jsonObject) {
		return service.path(resourcePath).path("person").path(mail)
				.put(ClientResponse.class, jsonObject);
	}

	/**
	 * Request using method HTTP DELETE for removed one person.
	 * 
	 * @param mail
	 * @return ClientResponse.
	 */

	public ClientResponse getResourceDelete(String mail) {
		return service.path(resourcePath).path("person").path(mail)
				.delete(ClientResponse.class);
	}

	/**
	 * Method for create JSON with data of a person.
	 * 
	 * @param name
	 * @param mail
	 * @return JSONObject
	 * 
	 */

	public JSONObject createJson(String name, String mail) {

		if (entityJsonIn == null) {
			entityJsonIn = new JSONObject();
		}

		try {
			entityJsonIn.put("name", name);
			entityJsonIn.put("mail", mail);
		} catch (JSONException je) {
			je.printStackTrace();
		}
		return entityJsonIn;
	}
}