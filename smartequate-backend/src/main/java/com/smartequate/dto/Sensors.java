package com.smartequate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sensors")
public class Sensors {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private int id;
	
	@Column
	private boolean accelerometer;
	
	@Column
	private boolean gyroscope;
	
	@Column
	private boolean magnetometer;
	
	@Column
	private boolean gps;
	
	@Column
	private boolean proximity;
	
	@Column
	private boolean light;
	
	@Column
	private boolean fingerprint;
	
	@Column
	private boolean barometer;
	
	@Column
	private boolean thermometer;
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public boolean isAccelerometer() {
		return accelerometer;
	}
	public void setAccelerometer(boolean accelerometer) {
		this.accelerometer = accelerometer;
	}
	public boolean isGyroscope() {
		return gyroscope;
	}
	public void setGyroscope(boolean gyroscope) {
		this.gyroscope = gyroscope;
	}
	public boolean isMagnetometer() {
		return magnetometer;
	}
	public void setMagnetometer(boolean magnetometer) {
		this.magnetometer = magnetometer;
	}
	public boolean isGps() {
		return gps;
	}
	public void setGps(boolean gps) {
		this.gps = gps;
	}
	public boolean isProximity() {
		return proximity;
	}
	public void setProximity(boolean proximity) {
		this.proximity = proximity;
	}
	public boolean isLight() {
		return light;
	}
	public void setLight(boolean light) {
		this.light = light;
	}
	public boolean isFingerprint() {
		return fingerprint;
	}
	public void setFingerprint(boolean fingerprint) {
		this.fingerprint = fingerprint;
	}
	public boolean isBarometer() {
		return barometer;
	}
	public void setBarometer(boolean barometer) {
		this.barometer = barometer;
	}
	public boolean isThermometer() {
		return thermometer;
	}
	public void setThermometer(boolean thermometer) {
		this.thermometer = thermometer;
	}
	
	
	
}
