/**
 * 
 */
package com.bd.redminetools.migration.domain;

import java.io.Serializable;

/**
 * @author yaong
 *
 */
public class MigrationSettings implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8101742909289005043L;

	private String serverAddr;
	private int serverPort;
	private String migType;
	public String getServerAddr() {
		return serverAddr;
	}
	public void setServerAddr(String serverAddr) {
		this.serverAddr = serverAddr;
	}
	public int getServerPort() {
		return serverPort;
	}
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}
	public String getMigType() {
		return migType;
	}
	public void setMigType(String migType) {
		this.migType = migType;
	}
	@Override
	public String toString() {
		return "MigrationSettings [serverAddr=" + serverAddr + ", serverPort=" + serverPort + ", migType=" + migType
				+ "]";
	}	
	
}
