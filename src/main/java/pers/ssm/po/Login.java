package pers.ssm.po;

public class Login {
    private Integer id;
    private String  name;
    private String  password;
    private Integer type;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(Integer id, String name, String password, Integer type) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", name=" + name + ", password=" + password + ", type=" + type + "]";
	}
    
}
