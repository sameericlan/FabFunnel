package nameEmail;

public class DynamicVariableStore {
	private static DynamicVariableStore instance;
	private String name;
	private String email;

	private DynamicVariableStore() {}

	public static synchronized DynamicVariableStore getInstance() {
		if (instance == null) {
			instance = new DynamicVariableStore();
		}
		return instance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
