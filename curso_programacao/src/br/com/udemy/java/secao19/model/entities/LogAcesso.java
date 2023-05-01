package br.com.udemy.java.secao19.model.entities;

import java.time.Instant;
import java.util.Objects;

public final class LogAcesso {
	
	private String userName;
	private Instant accessDate;
	
	public LogAcesso(String userName, Instant accessDate) {
		this.userName = userName;
		this.accessDate = accessDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Instant getAccessDate() {
		return accessDate;
	}

	public void setAccessDate(Instant accessDate) {
		this.accessDate = accessDate;
	}



	@Override
	public int hashCode() {
		return Objects.hash(userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogAcesso other = (LogAcesso) obj;
		return Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "Login -> [userName=" + userName + ", accessDate=" + accessDate + "]";
	}
	
	

}
