/*package org.sid.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChatingMessage {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String message;
	
	private Long idSender;
	private Long idReceiver;
    private Date time;
	private String nameSender ;
	private String nameReceiver ;
	
	
	public ChatingMessage() {

	}
	
	
	public String getNameSender() {
		return nameSender;
	}


	public void setNameSender(String nameSender) {
		this.nameSender = nameSender;
	}


	public String getNameReceiver() {
		return nameReceiver;
	}


	public void setNameReceiver(String nameReceiver) {
		this.nameReceiver = nameReceiver;
	}


	public ChatingMessage(Long id, String message) {
		this.id = id;
		this.message = message;
	}

	public void setIdSender(Long idSender) {
		this.idSender = idSender;
	}

	public void setIdReceiver(Long idReceiver) {
		this.idReceiver = idReceiver;
	}

	public Long getIdSender() {
		return idSender;
	}

	public Long getIdReceiver() {
		return idReceiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}
	
}

*/