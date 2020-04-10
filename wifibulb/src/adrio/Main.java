package adrio;

import adrio.control.WifiBulb;

public class Main {
	public static void main(String[] args) {
		try {
			WifiBulb light = new WifiBulb("192.168.1.130", 55443);
			light.powerOn();
			Thread.sleep(300);
			light.powerOff();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}