package com.smartequate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "points")
public class Points {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private int id;
	@Column
	private float heightPoints;
	@Column
	private float weightPoints;
	@Column
	private float simTrayPoints;
	@Column
	private float cpuPoints;
	@Column
	private float displaySizePoints;
	@Column
	private float cardSlotPoints;
	@Column
	private float cameraAPoints;
	@Column
	private float cameraBPoints;
	@Column
	private float jackPoints;
	@Column
	private float displayTypePoints;
	@Column
	private float romPoints;
	@Column
	private float ramPoints;
	@Column
	private float resolutionPoints;
	@Column
	private float batteryPoints;
	@Column
	private float sensorsGyroscopePoints;
	@Column
	private float sensorsMagnetometerPoints;
	@Column
	private float sensorsGpsPoints;
	@Column
	private float sensorsProximityPoints;
	@Column
	private float sensorsLightPoints;
	@Column
	private float sensorsFingerprintPoints;
	@Column
	private float sensorsBarometerPoints;
	@Column
	private float sensorsThermometerPoints;
	@Column
	private float sensorsAccelerometerPoints;
	@Column
	private float portPoints;
	@Column
	private float multitouchPoints;
	@Column
	private float totalPoints;
	
	public float getHeightPoints() {
		return heightPoints;
	}
	public void setHeightPoints(float heightPoints) {
		this.heightPoints = heightPoints;
	}
	public float getWeightPoints() {
		return weightPoints;
	}
	public void setWeightPoints(float weightPoints) {
		this.weightPoints = weightPoints;
	}
	public float getSimTrayPoints() {
		return simTrayPoints;
	}
	public void setSimTrayPoints(float simTrayPoints) {
		this.simTrayPoints = simTrayPoints;
	}
	public float getCpuPoints() {
		return cpuPoints;
	}
	public void setCpuPoints(float cpuPoints) {
		this.cpuPoints = cpuPoints;
	}
	public float getDisplaySizePoints() {
		return displaySizePoints;
	}
	public void setDisplaySizePoints(float displaySizePoints) {
		this.displaySizePoints = displaySizePoints;
	}
	public float getCardSlotPoints() {
		return cardSlotPoints;
	}
	public void setCardSlotPoints(float cardSlotPoints) {
		this.cardSlotPoints = cardSlotPoints;
	}
	public float getCameraAPoints() {
		return cameraAPoints;
	}
	public void setCameraAPoints(float cameraAPoints) {
		this.cameraAPoints = cameraAPoints;
	}
	public float getCameraBPoints() {
		return cameraBPoints;
	}
	public void setCameraBPoints(float cameraBPoints) {
		this.cameraBPoints = cameraBPoints;
	}
	public float getJackPoints() {
		return jackPoints;
	}
	public void setJackPoints(float jackPoints) {
		this.jackPoints = jackPoints;
	}
	public float getDisplayTypePoints() {
		return displayTypePoints;
	}
	public void setDisplayTypePoints(float displayTypePoints) {
		this.displayTypePoints = displayTypePoints;
	}
	public float getRomPoints() {
		return romPoints;
	}
	public void setRomPoints(float romPoints) {
		this.romPoints = romPoints;
	}
	public float getRamPoints() {
		return ramPoints;
	}
	public void setRamPoints(float ramPoints) {
		this.ramPoints = ramPoints;
	}
	public float getResolutionPoints() {
		return resolutionPoints;
	}
	public void setResolutionPoints(float resolutionPoints) {
		this.resolutionPoints = resolutionPoints;
	}
	public float getBatteryPoints() {
		return batteryPoints;
	}
	public void setBatteryPoints(float batteryPoints) {
		this.batteryPoints = batteryPoints;
	}
	public float getSensorsGyroscopePoints() {
		return sensorsGyroscopePoints;
	}
	public void setSensorsGyroscopePoints(float sensorsGyroscopePoints) {
		this.sensorsGyroscopePoints = sensorsGyroscopePoints;
	}
	public float getSensorsMagnetometerPoints() {
		return sensorsMagnetometerPoints;
	}
	public void setSensorsMagnetometerPoints(float sensorsMagnetometerPoints) {
		this.sensorsMagnetometerPoints = sensorsMagnetometerPoints;
	}
	public float getSensorsGpsPoints() {
		return sensorsGpsPoints;
	}
	public void setSensorsGpsPoints(float sensorsGpsPoints) {
		this.sensorsGpsPoints = sensorsGpsPoints;
	}
	public float getSensorsProximityPoints() {
		return sensorsProximityPoints;
	}
	public void setSensorsProximityPoints(float sensorsProximityPoints) {
		this.sensorsProximityPoints = sensorsProximityPoints;
	}
	public float getSensorsLightPoints() {
		return sensorsLightPoints;
	}
	public void setSensorsLightPoints(float sensorsLightPoints) {
		this.sensorsLightPoints = sensorsLightPoints;
	}
	public float getSensorsFingerprintPoints() {
		return sensorsFingerprintPoints;
	}
	public void setSensorsFingerprintPoints(float sensorsFingerprintPoints) {
		this.sensorsFingerprintPoints = sensorsFingerprintPoints;
	}
	public float getSensorsBarometerPoints() {
		return sensorsBarometerPoints;
	}
	public void setSensorsBarometerPoints(float sensorsBarometerPoints) {
		this.sensorsBarometerPoints = sensorsBarometerPoints;
	}
	public float getSensorsThermometerPoints() {
		return sensorsThermometerPoints;
	}
	public void setSensorsThermometerPoints(float sensorsThermometerPoints) {
		this.sensorsThermometerPoints = sensorsThermometerPoints;
	}
	public float getSensorsAccelerometerPoints() {
		return sensorsAccelerometerPoints;
	}
	public void setSensorsAccelerometerPoints(float sensorsAccelerometerPoints) {
		this.sensorsAccelerometerPoints = sensorsAccelerometerPoints;
	}
	public float getPortPoints() {
		return portPoints;
	}
	public void setPortPoints(float portPoints) {
		this.portPoints = portPoints;
	}
	public float getMultitouchPoints() {
		return multitouchPoints;
	}
	public void setMultitouchPoints(float multitouchPoints) {
		this.multitouchPoints = multitouchPoints;
	}
	public float getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(float totalPoints) {
		this.totalPoints = totalPoints;
	}
	
	
	
	
	
}

