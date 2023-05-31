/**
 * 
 */
package com.bd.redminetools.migration.domain;

import java.io.Serializable;

/**
 * @author yaong
 *
 */
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8134074593431534761L;

	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}
	
	
}
