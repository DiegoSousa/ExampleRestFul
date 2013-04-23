package br.pb.diego.sousa.rest.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity Person
 * 
 * @author Diego Sousa, diego[at]diegosousa[dot]com
 * @version 0.0.1
 * @since 02/11/2012
 */

/**
 * @XmlRootElement is used to transform a POJO in JSON.
 */

@XmlRootElement
public class Person {

	private String name;
	private String mail;

	public Person(String name, String mail) {
		this.name = name;
		this.mail = mail;
	}

	public Person() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\n Mail: " + mail;
	}
}
