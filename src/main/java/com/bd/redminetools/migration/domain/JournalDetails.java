/**
 * 
 */
package com.bd.redminetools.migration.domain;

import java.io.Serializable;

/**
* 설명 :
* 작성자 : 전길수
* 작성일 : 2023.05.02.
* 변경일 : 2023.05.02.
*/
public class JournalDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -391468053787997996L;

	private int id;
	private int journalId;
	private String property;
	private String propKey;
	private String oldValue;
	private String value;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJournalId() {
		return journalId;
	}
	public void setJournalId(int journalId) {
		this.journalId = journalId;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getPropKey() {
		return propKey;
	}
	public void setPropKey(String propKey) {
		this.propKey = propKey;
	}
	public String getOldValue() {
		return oldValue;
	}
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "JournalDetails [id=" + id + ", journalId=" + journalId + ", property=" + property + ", propKey="
				+ propKey + ", oldValue=" + oldValue + ", value=" + value + "]";
	}

}
