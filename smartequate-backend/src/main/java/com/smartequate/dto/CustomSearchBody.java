package com.smartequate.dto;


public class CustomSearchBody {
	
	private float weight;
	
	private int sim_tray;
	
	private float minDisplaySize;
	
	private float maxDisplaySize;
	
	private boolean card_slot;

	private int cameraA;
	
	private int cameraB;
	
	private boolean jack;
	
	private String display_type;
	
	private int rom;
	
	private int ram;
	
	private String port;
	
	private boolean multitouch;

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getSim_tray() {
		return sim_tray;
	}

	public void setSim_tray(int sim_tray) {
		this.sim_tray = sim_tray;
	}

	public float getMinDisplaySize() {
		return minDisplaySize;
	}

	public void setMinDisplaySize(float minDisplaySize) {
		this.minDisplaySize = minDisplaySize;
	}

	public float getMaxDisplaySize() {
		return maxDisplaySize;
	}

	public void setMaxDisplaySize(float maxDisplaySize) {
		this.maxDisplaySize = maxDisplaySize;
	}


	public int getCameraA() {
		return cameraA;
	}

	public void setCameraA(int cameraA) {
		this.cameraA = cameraA;
	}

	public int getCameraB() {
		return cameraB;
	}

	public void setCameraB(int cameraB) {
		this.cameraB = cameraB;
	}

	public String getDisplay_type() {
		return display_type;
	}

	public void setDisplay_type(String display_type) {
		this.display_type = display_type;
	}

	public int getRom() {
		return rom;
	}

	public void setRom(int rom) {
		this.rom = rom;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public boolean isCard_slot() {
		return card_slot;
	}

	public void setCard_slot(boolean card_slot) {
		this.card_slot = card_slot;
	}

	public boolean isJack() {
		return jack;
	}

	public void setJack(boolean jack) {
		this.jack = jack;
	}

	public boolean isMultitouch() {
		return multitouch;
	}

	public void setMultitouch(boolean multitouch) {
		this.multitouch = multitouch;
	}

	
	
	
}
