package app.dto;

public class EmpDTO 
{
	private int id;
	private String name;
	private int contact;
    private String email;
	
	public EmpDTO(){}
	
	public EmpDTO(int id, String name, int contact, String email) 
	{
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.email = email;
	}

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

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	

}
