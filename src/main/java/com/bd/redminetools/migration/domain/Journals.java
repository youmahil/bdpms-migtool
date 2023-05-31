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
public class Journals implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5301898628444166391L;

	private int id;
	private int oldJournalId;
	private int journalizedId;
	private int oldJournalizedId;
	private String journalizedType;
	private String notes;
	private String userId;
	private String createdOn;
	private int privateNotes;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOldJournalId() {
		return oldJournalId;
	}
	public void setOldJournalId(int oldJournalId) {
		this.oldJournalId = oldJournalId;
	}
	public int getJournalizedId() {
		return journalizedId;
	}
	public void setJournalizedId(int journalizedId) {
		this.journalizedId = journalizedId;
	}
	public int getOldJournalizedId() {
		return oldJournalizedId;
	}
	public void setOldJournalizedId(int oldJournalizedId) {
		this.oldJournalizedId = oldJournalizedId;
	}
	public String getJournalizedType() {
		return journalizedType;
	}
	public void setJournalizedType(String journalizedType) {
		this.journalizedType = journalizedType;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public int getPrivateNotes() {
		return privateNotes;
	}
	public void setPrivateNotes(int privateNotes) {
		this.privateNotes = privateNotes;
	}
	@Override
	public String toString() {
		return "Journals [id=" + id + ", oldJournalId=" + oldJournalId + ", journalizedId=" + journalizedId
				+ ", oldJournalizedId=" + oldJournalizedId + ", journalizedType=" + journalizedType + ", notes=" + notes
				+ ", userId=" + userId + ", createdOn=" + createdOn + ", privateNotes=" + privateNotes + "]";
	}	
	
}
