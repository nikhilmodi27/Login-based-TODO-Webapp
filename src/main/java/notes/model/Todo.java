package notes.model;

import java.util.Date;

public class Todo {
	private int id;
	private String username;
	private String title;
	private String description;
	private String status;
	private Date dt;

	
	public Todo() {
	}

	public Todo(String username, String title, String description, String status, Date dt) {
		super();
		this.username = username;
		this.title = title;
		this.description = description;
		this.status = status;
		this.dt = dt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

}
