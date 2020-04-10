package adrio.control;

import java.util.ArrayList;

public class CommandBuilder {
	private int id;
	private String method;
	private ArrayList<ParameterObject> params;
	
	public CommandBuilder(int id) {
		this.id=id;
		this.params=new ArrayList<>();
	}
	
	public CommandBuilder() {
		this.params=new ArrayList<>();
	}
	
	public CommandBuilder(String method) {
		this.method=method;
		this.params=new ArrayList<>();
	}
	
	public CommandBuilder(int id, String method) {
		this.id=id;
		this.method=method;
		this.params=new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public ArrayList<ParameterObject> getParams() {
		return params;
	}

	public void setParams(ArrayList<ParameterObject> params) {
		this.params = params;
	}	
	
	public void addParam(String param) {
		this.params.add(new ParameterObject(param));
	}
	
	public void addParam(int param) {
		this.params.add(new ParameterObject(param));
	}
	
	public String toString() {
		String parametersString="[";
		for (int i=0;i<params.size();i++) {
			ParameterObject obj=params.get(i);
			if (i==(params.size()-1)&&i==0) {
				parametersString+=obj.toString()+"]";
				continue;
			}
			if (i==(params.size()-1)) {
				parametersString+=", "+obj.toString()+"]";
				continue;
			}
			if (i==0) {
				parametersString+=obj.toString();
				continue;
			}
			if (i!=0&&i!=(params.size()-1)) {
				parametersString+=", "+obj.toString();
				continue;
			}
		}
		return "{\"id\":"+this.id+", \"method\":\""+this.method+"\", \"params\":"+parametersString+"}\r\n";
	}
}