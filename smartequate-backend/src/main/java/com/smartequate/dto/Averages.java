package com.smartequate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "averages")
public class Averages {
/*
 * 	 * 	this.size = size;
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
		this.multitouch = multitouch;*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private int id;
	
	@Column
	private float average_height;
	
	@Column
	private float average_weight;
	
	@Column
	private float average_display_size;
	
	@Column
	private float average_camera_a;
	
	@Column
	private float average_camera_b;
	
	@Column
	private float average_rom;
	
	@Column
	private float average_ram;
	
	@Column
	private float average_resolution_width;
	
	@Column
	private float average_resolution_height;
	
	@Column
	private float average_battery;
	
	@Column
	private boolean last;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public float getAverage_weight() {
		return average_weight;
	}

	public void setAverage_weight(float average_weight) {
		this.average_weight = average_weight;
	}

	public float getAverage_height() {
		return average_height;
	}

	public void setAverage_height(float average_height) {
		this.average_height = average_height;
	}

	public float getAverage_display_size() {
		return average_display_size;
	}

	public void setAverage_display_size(float average_display_size) {
		this.average_display_size = average_display_size;
	}

	public float getAverage_camera_a() {
		return average_camera_a;
	}

	public void setAverage_camera_a(float average_camera_a) {
		this.average_camera_a = average_camera_a;
	}

	public float getAverage_camera_b() {
		return average_camera_b;
	}

	public void setAverage_camera_b(float average_camera_b) {
		this.average_camera_b = average_camera_b;
	}

	public float getAverage_rom() {
		return average_rom;
	}

	public void setAverage_rom(float average_rom) {
		this.average_rom = average_rom;
	}

	public float getAverage_ram() {
		return average_ram;
	}

	public void setAverage_ram(float average_ram) {
		this.average_ram = average_ram;
	}

	public float getAverage_resolution_width() {
		return average_resolution_width;
	}

	public void setAverage_resolution_width(float average_resolution_width) {
		this.average_resolution_width = average_resolution_width;
	}

	public float getAverage_resolution_height() {
		return average_resolution_height;
	}

	public void setAverage_resolution_height(float average_resolution_height) {
		this.average_resolution_height = average_resolution_height;
	}

	public float getAverage_battery() {
		return average_battery;
	}

	public void setAverage_battery(float average_battery) {
		this.average_battery = average_battery;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}
	
	
	
	
	
}
