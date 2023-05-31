/**
 * 
 */
package com.bd.redminetools.migration.domain;

import java.io.Serializable;

/**
 * @author yaong
 *
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7837467457971270036L;

	private int id;
	private String login;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", name=" + name + "]";
	}
	
	
}
