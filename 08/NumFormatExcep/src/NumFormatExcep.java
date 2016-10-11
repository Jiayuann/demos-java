public class NumFormatExcep{
	private String name;
	private String password;
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
	public static void main(String[] args) {
		NumFormatExcep r7 = new NumFormatExcep();
		String name = r7.getName();
		int password = new Integer(r7.getPassword()).intValue();
		System.out.println("用户名为" + name + ";密码为" + password);
	}
}
