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
public class Issue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7189951603078458891L;

	private int id;
	private int trackerId;
	private int projectId;
	private String subject;
	private String description;
	private String dueDate;
	private int categoryId;
	private int statusId;
	private int assignedToId;
	private int priorityId;
	private int fixedVersionId;
	private int authorId;
	private int lockVersion;
	private String createdOn;
	private String updatedOn;
	private String startDate;
	private int doneRatio;
	private float estimatedHours;
	private int parentId;
	private int rootId;
	private int lft;
	private int rgt;
	private String isPrivate;
	private String closedOn;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTrackerId() {
		return trackerId;
	}
	public void setTrackerId(int trackerId) {
		this.trackerId = trackerId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getAssignedToId() {
		return assignedToId;
	}
	public void setAssignedToId(int assignedToId) {
		this.assignedToId = assignedToId;
	}
	public int getPriorityId() {
		return priorityId;
	}
	public void setPriorityId(int priorityId) {
		this.priorityId = priorityId;
	}
	public int getFixedVersionId() {
		return fixedVersionId;
	}
	public void setFixedVersionId(int fixedVersionId) {
		this.fixedVersionId = fixedVersionId;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getLockVersion() {
		return lockVersion;
	}
	public void setLockVersion(int lockVersion) {
		this.lockVersion = lockVersion;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public int getDoneRatio() {
		return doneRatio;
	}
	public void setDoneRatio(int doneRatio) {
		this.doneRatio = doneRatio;
	}
	public float getEstimatedHours() {
		return estimatedHours;
	}
	public void setEstimatedHours(float estimatedHours) {
		this.estimatedHours = estimatedHours;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getRootId() {
		return rootId;
	}
	public void setRootId(int rootId) {
		this.rootId = rootId;
	}
	public int getLft() {
		return lft;
	}
	public void setLft(int lft) {
		this.lft = lft;
	}
	public int getRgt() {
		return rgt;
	}
	public void setRgt(int rgt) {
		this.rgt = rgt;
	}
	public String getIsPrivate() {
		return isPrivate;
	}
	public void setIsPrivate(String isPrivate) {
		this.isPrivate = isPrivate;
	}
	public String getClosedOn() {
		return closedOn;
	}
	public void setClosedOn(String closedOn) {
		this.closedOn = closedOn;
	}
	@Override
	public String toString() {
		return "Issue [id=" + id + ", trackerId=" + trackerId + ", projectId=" + projectId + ", subject=" + subject
				+ ", description=" + description + ", dueDate=" + dueDate + ", categoryId=" + categoryId + ", statusId="
				+ statusId + ", assignedToId=" + assignedToId + ", priorityId=" + priorityId + ", fixedVersionId="
				+ fixedVersionId + ", authorId=" + authorId + ", lockVersion=" + lockVersion + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn + ", startDate=" + startDate + ", doneRatio=" + doneRatio
				+ ", estimatedHours=" + estimatedHours + ", parentId=" + parentId + ", rootId=" + rootId + ", lft="
				+ lft + ", rgt=" + rgt + ", isPrivate=" + isPrivate + ", closedOn=" + closedOn + "]";
	}
		
}
