package config;

public class RoleConfig {
	
	private String className;
	
	private int initialResource;
	
	private int initialTechPoint;
	
	private int tchDevelopSpeed;
	
	private int rsrRestoreSpeed;
	
	public RoleConfig( String className, int initialResource,int initialTechPoint,int tchDevelopSpeed,int rsrRestoreSpeed) {
		this.className=className;
		this.initialResource=initialResource;
		this.initialTechPoint=initialTechPoint;
		this.tchDevelopSpeed=tchDevelopSpeed;
		this.rsrRestoreSpeed=rsrRestoreSpeed;
	}

	public String getClassName() {
		return className;
	}

	public int getInitialResource() {
		return initialResource;
	}

	public int getInitialTechPoint() {
		return initialTechPoint;
	}

	public int getTchDevelopSpeed() {
		return tchDevelopSpeed;
	}

	public int getRsrRestoreSpeed() {
		return rsrRestoreSpeed;
	}
	
	
	
}
