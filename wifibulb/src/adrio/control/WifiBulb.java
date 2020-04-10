package adrio.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class WifiBulb {
	private String ip;
	private int port;
	
	public WifiBulb(String ip, int port) {
		this.ip=ip;
		this.port=port;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	private boolean exec(String command) {
		try (Socket s=new Socket(this.ip, this.port)) {
			OutputStreamWriter w=new OutputStreamWriter(s.getOutputStream(), StandardCharsets.UTF_8);
			w.write(command);
			w.flush();
			BufferedReader r=new BufferedReader(new InputStreamReader(s.getInputStream()));
			String result=r.readLine();
			w.close();
			r.close();
			return result.contains("\"ok\"");
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean powerOff() {
		CommandBuilder builder=new CommandBuilder(1, "set_power");
		builder.addParam("off");
		builder.addParam("sudden");
		builder.addParam(300);
		return exec(builder.toString());
	}
	
	public boolean powerOn() {
		CommandBuilder builder=new CommandBuilder(1, "set_power");
		builder.addParam("on");
		builder.addParam("sudden");
		builder.addParam(300);
		return exec(builder.toString());
	}
}