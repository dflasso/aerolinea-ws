package ec.edu.espe.monster.aerolineacondor.model.constants;

public enum TypeGeograficLocation {
	COUNTRY("TG001"),
	REGION("TG002"),
	PROVINCE("TG003"),
	CITY("TG004");
	
	private String code;

	private TypeGeograficLocation(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
}
