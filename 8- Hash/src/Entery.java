
public class Entery {
	private int status;
	private int value;

	public Entery() {

	}

	public Entery(int status) {
		this.status = status;
	}

	public Entery(int value, int status) {
		this.status = status;
		this.value = value;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
