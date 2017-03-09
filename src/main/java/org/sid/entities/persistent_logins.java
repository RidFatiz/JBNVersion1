package org.sid.entities;

import java.security.Timestamp;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class persistent_logins {
	private String username;
	@Id
	private String series;
	private String token;
	private Timestamp   last_used;

	public persistent_logins() {
		super();
	}

	public persistent_logins(String username, String token, Timestamp last_used) {
		super();
		this.username = username;
		this.token = token;
		this.last_used = last_used;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Timestamp getLast_used() {
		return last_used;
	}

	public void setLast_used(Timestamp last_used) {
		this.last_used = last_used;
	}
	
	
	
	
	

}
