package br.pb.diego.sousa.rest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import br.pb.diego.sousa.rest.entity.Person;
import br.pb.diego.sousa.rest.exception.DataExistingException;
import br.pb.diego.sousa.rest.exception.DataNonexistentException;

/**
 * This class is responsible for the persistence of the person entity.
 * 
 * @author Diego Sousa, diego[at]diegosousa[dot]com
 * @version 0.0.1
 * @since 02/11/2012
 */

public class PersonDAO {

	private Logger logger;
	private List<Person> persons;

	public PersonDAO() {
		this.persons = new ArrayList<Person>();
		this.logger = Logger.getLogger(getClass().getPackage().toString());
	}

	/**
	 * Method responsible by add a Person.
	 * 
	 * @param Object
	 *            Person
	 * @return Object Person
	 * @throws DataExistingException
	 *             , if mail exists.
	 * @throws NullPointerException
	 *             , if person equals null
	 */

	public Person addPerson(Person person) throws DataExistingException,
			NullPointerException {

		if (person != null) {
			for (Person personAux : persons) {
				if (personAux.getMail().equals(person.getMail())) {
					throw new DataExistingException(
							"This email is already registered.");
				}
			}
			persons.add(person);
			logger.info("Person: " + person.getName()
					+ " added with successfully");
			return person;
		}
		throw new NullPointerException("Person is null");
	}

	/**
	 * Method responsible by Remove a Person.
	 * 
	 * @param Object
	 *            Person
	 * @return Object Person
	 * @throws DataNonexistentException
	 *             , if person not exists.
	 * @throws NullPointerException
	 *             , if person equals null
	 */

	public Person removePerson(Person person) throws DataNonexistentException,
			NullPointerException {

		if (person != null) {
			for (Person personAux : persons) {
				if (personAux.getMail().equals(person.getMail())) {
					persons.remove(personAux);
					logger.info("Person: " + person.getName()
							+ " removed with successfully");
					return person;
				}
			}
			throw new DataNonexistentException("Person not exists.");
		}
		throw new NullPointerException("Person is null");
	}

	/**
	 * Method responsible by Edit a Person.
	 * 
	 * @param String
	 *            mail - Email is the identifier of the object
	 * 
	 * @param Object
	 *            Person
	 * @return Object Person
	 * @throws DataNonexistentException
	 *             , if person not exists.
	 * @throws NullPointerException
	 *             , if person equals null
	 */

	public Person editPerson(String mail, Person person)
			throws DataNonexistentException, NullPointerException {

		if (person != null) {
			for (Person personAux : persons) {
				if (personAux.getMail().equals(mail)) {
					persons.remove(personAux);
					persons.add(person);
					logger.info("Person: " + person.getName()
							+ " edited with successfully");
					return person;
				}
				throw new DataNonexistentException("Person not exists.");
			}
		}
		throw new NullPointerException("Person is null");
	}

	/**
	 * Method responsible by find a Person.
	 * 
	 * @param String
	 *            mail
	 * @return Object Person
	 * @throws DataNonexistentException
	 *             , if person not exists.
	 */

	public Person findPerson(String mail) throws DataNonexistentException {

		for (Person personAux : persons) {
			if (personAux.getMail().equals(mail)) {
				logger.info("Person: " + personAux.getName() + " found!");
				return personAux;
			}
		}
		throw new DataNonexistentException("person not Found!");
	}

	/**
	 * Method responsible for returning the list of Person.
	 * 
	 * @return List<Person>
	 * 
	 */

	public List<Person> listAllPerson() {
		return persons;
	}

	/**
	 * Method responsible for clear the list.
	 */

	public void clearList() {
		persons.clear();
		logger.info("List All Person clear!");
	}
}
