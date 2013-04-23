package br.pb.diego.sousa.rest.facade;

import java.util.List;

import br.pb.diego.sousa.rest.dao.PersonDAO;
import br.pb.diego.sousa.rest.entity.Person;
import br.pb.diego.sousa.rest.exception.DataExistingException;
import br.pb.diego.sousa.rest.exception.DataNonexistentException;

/**
 * Facade
 * 
 * @author Diego Sousa, diego[at]diegosousa[dot]com
 * @version 0.0.1
 * @since 02/11/2012
 */

public class Facade {

	private static Facade facade;
	private PersonDAO personDao;

	private Facade() {
		this.personDao = new PersonDAO();
	}

	/**
	 * Singleton
	 */

	public static Facade getInstance() {
		if (facade == null) {
			facade = new Facade();
		}
		return facade;
	}

	/**
	 * Method responsible by add a Person.
	 * 
	 * @param Object
	 *            Person
	 * @return Object Person
	 * @exception DataExistingException
	 *             , if mail exists.
	 * @exception NullPointerException
	 *             , if person equals null
	 */

	public Person addPerson(Person person) {
		Person personAux = null;
		try {
			personAux = personDao.addPerson(person);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return personAux;
	}

	/**
	 * Method responsible by Remove a Person.
	 * 
	 * @param Object
	 *            Person
	 * @return Object Person
	 * @exception DataNonexistentException
	 *             , if person not exists.
	 * @exception NullPointerException
	 *             , if person equals null
	 */

	public Person removePerson(Person person) {

		Person personAux = null;
		try {
			personAux = personDao.removePerson(person);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return personAux;
	}

	/**
	 * Method responsible by Edit a Person.
	 * 
	 * @param Object
	 *            Person
	 * @return Object Person
	 * @exception DataNonexistentException
	 *             , if person not exists.
	 * @exception NullPointerException
	 *             , if person equals null
	 */

	public Person editPerson(Person person) {

		Person personAux = null;
		try {
			personAux = personDao.editPerson(person);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return personAux;
	}

	/**
	 * Method responsible by find a Person.
	 * 
	 * @param String
	 *            mail
	 * @return Object Person
	 * @exception DataNonexistentException
	 *             , if person not exists.
	 */

	public Person findPerson(String mail) {

		Person personAux = null;
		try {
			personAux = personDao.findPerson(mail);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return personAux;
	}

	/**
	 * Method responsible for returning the list of Person.
	 * 
	 * @return List<Person>
	 * 
	 */

	public List<Person> listAllPerson() {

		List<Person> personAux = null;
		try {
			personAux = personDao.listAllPerson();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return personAux;
	}

	/**
	 * Method responsible for clear the list.
	 */

	public void clearList() {
		personDao.clearList();
	}

}