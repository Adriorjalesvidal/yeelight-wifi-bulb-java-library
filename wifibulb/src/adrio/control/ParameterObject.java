package adrio.control;

public class ParameterObject {
	private boolean string;
	private String paramValue;
	
	public ParameterObject() {}	
	public ParameterObject(String paramValue) {
		setParamValue(paramValue);
	}
	
	public ParameterObject(int paramValue) {
		setParamValue(paramValue);
	}
	
	public String getParamValue() {
		return paramValue;
	}
	
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
		this.string=true;
	}	
	
	public void setParamValue(int paramValue) {
		this.paramValue=paramValue+"";
		this.string=false;
	}
	
	public String toString() {
		if (this.string) {
			return "\""+this.paramValue+"\"";
		} else {
			return this.paramValue;
		}
	}
}