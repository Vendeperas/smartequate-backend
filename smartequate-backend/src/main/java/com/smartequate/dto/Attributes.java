package com.smartequate.dto;

import javax.persistence.*;


@Entity
@Table(name = "attributes")
public class Attributes {

	public enum Cpu{
		snapdragon_865,
		snapdragon_855,
		snapdragon_845,
		snapdragon_835,
		a13,
		a12,
		a11,
		a10,
		exynos9820,
		exynos9810
	}
	
	public enum Display_type {
		led,
		oled,
		amoled
	}
	
	public enum Port{
		micro_usb,
		type_c
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "size_id")
	private Size size;
	
	@Column
	private float weight;
	
	@Column
	private int sim_tray;
	
	@Column
	private String cpu;
	
	@Column(name="display_size")
	private float displaySize;
	
	@Column
	private boolean card_slot;
	
	@Column(name="camera_a")
	private int cameraA;
	
	@Column(name="camera_b")
	private int cameraB;
	
	@Column
	private boolean jack;
	
	@Column
	private String display_type;
	
	@Column
	private int rom;
	
	@Column
	private int ram;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "resolution_id")
	private Resolution resolution;
	
	@Column
	private int battery;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sensors_id")
	private Sensors sensors;
	
	@Column
	private String port;
	
	@Column
	private boolean multitouch;
	
	
	
	/*public Attributes(Size size, float weight, int sim_tray, Cpu cpu, float display_size, boolean card_slot,
			int camera_a, int camera_b, boolean jack, Display_type display_type, int rom, int ram,
			Resolution resolution, int battery, Sensors sensors, Port port, boolean multitouch) {
		super();
		this.size = size;
		this.weight = weight;
		this.sim_tray = sim_tray;
		this.cpu = cpu;
		this.display_size = display_size;
		this.card_slot = card_slot;
		this.camera_a = camera_a;
		this.camera_b = camera_b;
		this.jack = jack;
		this.display_type = display_type;
		this.rom = rom;
		this.ram = ram;
		this.resolution = resolution;
		this.battery = battery;
		this.sensors = sensors;
		this.port = port;
		this.multitouch = multitouch;
	}
*/
	
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Size getSize() {
		return size;
	}


	public void setSize(Size size) {
		this.size = size;
	}



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



	public String getCpu() {
		return cpu;
	}



	public void setCpu(String cpu) {
		this.cpu = cpu;
	}



	public float getDisplay_size() {
		return displaySize;
	}



	public void setDisplay_size(float display_size) {
		this.displaySize = display_size;
	}



	public boolean isCard_slot() {
		return card_slot;
	}



	public void setCard_slot(boolean card_slot) {
		this.card_slot = card_slot;
	}



	public int getCamera_a() {
		return cameraA;
	}



	public void setCamera_a(int camera_a) {
		this.cameraA = camera_a;
	}



	public int getCamera_b() {
		return cameraB;
	}



	public void setCamera_b(int camera_b) {
		this.cameraB = camera_b;
	}



	public boolean isJack() {
		return jack;
	}



	public void setJack(boolean jack) {
		this.jack = jack;
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



	public Resolution getResolution() {
		return resolution;
	}



	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}



	public int getBattery() {
		return battery;
	}



	public void setBattery(int battery) {
		this.battery = battery;
	}



	public Sensors getSensors() {
		return sensors;
	}



	public void setSensors(Sensors sensors) {
		this.sensors = sensors;
	}



	public String getPort() {
		return port;
	}



	public void setPort(String port) {
		this.port = port;
	}



	public boolean isMultitouch() {
		return multitouch;
	}



	public void setMultitouch(boolean multitouch) {
		this.multitouch = multitouch;
	}
	
	
}
