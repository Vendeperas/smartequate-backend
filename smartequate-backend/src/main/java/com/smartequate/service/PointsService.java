package com.smartequate.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartequate.controller.ComputeController;
import com.smartequate.dto.Attributes;
import com.smartequate.dto.Averages;
import com.smartequate.dto.Points;
import com.smartequate.repository.PointsRepository;
import com.smartequate.util.Constants;

@Service
public class PointsService {

	@Autowired
	private PointsRepository pointsRepo;
	
	@Autowired
	AttributesService attService;
	
	@Autowired
	AveragesService avgService;
	
	public static final Logger logger = LoggerFactory.getLogger(ComputeController.class);
	
	public void savePoints(Points points) {
		pointsRepo.save(points);
	}
	
	
	public Points computePoints(Attributes att) {
		
		
		Averages averages = avgService.getLastAverages();
		
		Points phonePoints = new Points();
		float points = 0;
		
		// ------------------ COMPUTE HEIGHT VALUE -----------------------------
		
		logger.info("Calculant puntuació de 'height'...");
		if (att.getSize().getHeight() > averages.getAverage_height()) {
			logger.info("'height' més gran que la mitjana! (dolent)");
			Attributes highestAtt = attService.getHighestHeight();
			float diff1 = highestAtt.getSize().getHeight() - averages.getAverage_height();
			float diff2 = att.getSize().getHeight() - averages.getAverage_height();
			float diffPerc = diff2 / diff1 * 100;
			float addPoints = (Constants.POINTS_HEIGHT -(Constants.POINTS_HEIGHT / 100 * diffPerc));
			points = points + addPoints;
			phonePoints.setHeightPoints(addPoints);
			logger.info("Puntuació final afegida = " + addPoints);
		} else if (att.getSize().getHeight() < averages.getAverage_height()) {
			logger.info("'height' més petita que la mitjana! (bo)");
			Attributes lowestAtt = attService.getLowestHeight();
			float diff1 = averages.getAverage_height() - lowestAtt.getSize().getHeight();
			float diff2 = averages.getAverage_height() - att.getSize().getHeight();
			float diffPerc = diff2 / diff1 * 100;
			float addPoints = (Constants.POINTS_HEIGHT +(Constants.POINTS_HEIGHT / 100 * diffPerc));
			points = points + addPoints;
			phonePoints.setHeightPoints(addPoints);
			logger.info("Puntuació final afegida = " + addPoints);
		} else {
			logger.info("'height' igual que la mitjana!");
			points = points + Constants.POINTS_HEIGHT;
			phonePoints.setHeightPoints(Constants.POINTS_HEIGHT);
			logger.info("Puntuació final afegida = " + Constants.POINTS_HEIGHT);
		}
		
		// ------------------ COMPUTE WEIGHT VALUE -----------------------------
		
		logger.info("Calculant puntuació de 'weight'...");
		if (att.getWeight() > averages.getAverage_weight()) {
			logger.info("'weight' més gran que la mitjana! (dolent)");
			Attributes highestAtt= attService.getHighestWeight();
			float diff1 = highestAtt.getWeight() - averages.getAverage_weight();
			float diff2 = att.getWeight() - averages.getAverage_weight();
			float diffPerc = diff2 / diff1 * 100;
			float addPoints = (Constants.POINTS_WEIGHT - (Constants.POINTS_WEIGHT / 100 * diffPerc));
			points = points + addPoints;
			phonePoints.setWeightPoints(addPoints);
			logger.info("Puntuació final afegida = " + addPoints);
		} else if (att.getWeight() < averages.getAverage_weight()) {
			logger.info("'weight' més petita que la mitjana! (bo)");
			Attributes lowestAtt = attService.getLowestWeight();
			float diff1 = averages.getAverage_weight() - lowestAtt.getWeight();
			float diff2 = averages.getAverage_weight() - att.getWeight();
			float diffPerc = diff2 / diff1 * 100;
			float addPoints = (Constants.POINTS_WEIGHT +(Constants.POINTS_WEIGHT / 100 * diffPerc));
			points = points + addPoints;
			phonePoints.setWeightPoints(addPoints);
			logger.info("Puntuació final afegida = " + addPoints);
		} else {
			logger.info("'weight' igual que la mitjana!");
			points = points + Constants.POINTS_WEIGHT;
			phonePoints.setWeightPoints(Constants.POINTS_WEIGHT);
			logger.info("Puntuació final afegida = " + Constants.POINTS_WEIGHT);
		}
		
		// ------------------ COMPUTE SIM_TRAY VALUE -----------------------------
		
		logger.info("Calculant puntuació de 'sim_tray'...");
		logger.info("Valor de 'sim_tray' es " + att.getSim_tray());
		points = points + Constants.POINTS_SIM_TRAY * att.getSim_tray();
		phonePoints.setSimTrayPoints(Constants.POINTS_SIM_TRAY * att.getSim_tray());
		logger.info("Puntuació final afegida = " + Constants.POINTS_SIM_TRAY * att.getSim_tray());
		
		
		// ------------------ COMPUTE CPU VALUE -----------------------------
		
		logger.info("Calculant puntuació de 'cpu'...");
		logger.info("Valor de 'cpu' es " + att.getCpu());
		float pointsCpu = 0;
		switch(att.getCpu()) {
		
		  case "snapdragon_865":
		    pointsCpu = Constants.POINTS_CPU_SNAPDRAGON_865;
			  break;
			  
		  case "snapdragon_855":
			  pointsCpu = Constants.POINTS_CPU_SNAPDRAGON_855;
			  break;
			
		  case "snapdragon_845":
			  pointsCpu = Constants.POINTS_CPU_SNAPDRAGON_845;
			  break;
			  
		  case "snapdragon_835":
			  pointsCpu = Constants.POINTS_CPU_SNAPDRAGON_835;
			  break;
			  
		  case "a13":
			  pointsCpu = Constants.POINTS_CPU_A13;
			  break;
			  
		  case "a12":
			  pointsCpu = Constants.POINTS_CPU_A12;
			  break;
			  
		  case "a11":
			  pointsCpu = Constants.POINTS_CPU_A11;
			  break;
			  
		  case "a10":
			  pointsCpu = Constants.POINTS_CPU_A10;
			  break;
			  
		  case "exynos9820":
			  pointsCpu = Constants.POINTS_CPU_EXYNOS9820;
			  break;
			  
		  case "exynos9810":
			  pointsCpu = Constants.POINTS_CPU_EXYNOS9810;
			  break;
			  
		  default:
		    pointsCpu = 0;
		}
		
		points = points + pointsCpu;
		phonePoints.setCpuPoints(pointsCpu);
		logger.info("Puntuació final afegida = " + pointsCpu);
		
		
		// ------------------ COMPUTE DISPLAY_SIZE VALUE -----------------------------
		
		logger.info("Calculant puntuació de 'display_size'...");
		if (att.getDisplay_size() > averages.getAverage_weight()) {
			logger.info("'display_size' més gran que la mitjana! (bo)");
			Attributes highestAtt= attService.getHighestDisplaySize();
			float diff1 = highestAtt.getDisplay_size() - averages.getAverage_display_size();
			float diff2 = att.getDisplay_size() - averages.getAverage_display_size();
			float diffPerc = diff2 / diff1 * 100;
			float addPoints = (Constants.POINTS_DISPLAY_SIZE + (Constants.POINTS_DISPLAY_SIZE / 100 * diffPerc));
			points = points + addPoints;
			phonePoints.setDisplaySizePoints(addPoints);
			logger.info("Puntuació final afegida = " + addPoints);
		} else if (att.getWeight() < averages.getAverage_weight()) {
			logger.info("'display_size' més petita que la mitjana! (dolent)");
			Attributes lowestAtt = attService.getLowestDisplaySize();
			float diff1 = averages.getAverage_display_size() - lowestAtt.getDisplay_size();
			float diff2 = averages.getAverage_display_size() - att.getDisplay_size();
			float diffPerc = diff2 / diff1 * 100;
			float addPoints = (Constants.POINTS_DISPLAY_SIZE -(Constants.POINTS_DISPLAY_SIZE / 100 * diffPerc));
			points = points + addPoints;
			phonePoints.setDisplaySizePoints(addPoints);
			logger.info("Puntuació final afegida = " + addPoints);
		} else {
			logger.info("'display_size' igual que la mitjana!");
			points = points + Constants.POINTS_DISPLAY_SIZE;
			phonePoints.setDisplaySizePoints(Constants.POINTS_DISPLAY_SIZE);
			logger.info("Puntuació final afegida = " + Constants.POINTS_WEIGHT);
		}
		
		// ------------------ COMPUTE CARD_SLOT VALUE -----------------------------
		
		logger.info("Calculant puntuació de 'card_slot'...");
		logger.info("Valor de 'card_slot' és: " + att.isCard_slot());
		
		if (att.isCard_slot()) {
			points = points + Constants.POINTS_CARD_SLOT;
			phonePoints.setCardSlotPoints(Constants.POINTS_CARD_SLOT);
			logger.info("Puntuació final afegida = " + Constants.POINTS_CARD_SLOT);
		} else {
			phonePoints.setCardSlotPoints(0);
			logger.info("Puntuació final afegida = 0");
		}
		
		// ------------------ COMPUTE CAMERA_A VALUE -----------------------------
		
		logger.info("Calculant puntuació de 'camera_a'...");
		if (att.getCamera_a() > averages.getAverage_camera_a()) {
			logger.info("'camera_a' més gran que la mitjana! (bo)");
			Attributes highestAtt= attService.getHighestCameraA();
			float diff1 = highestAtt.getCamera_a() - averages.getAverage_camera_a();
			float diff2 = att.getCamera_a() - averages.getAverage_camera_a();
			float diffPerc = diff2 / diff1 * 100;
			float addPoints = (Constants.POINTS_CAMERA_A + (Constants.POINTS_CAMERA_A / 100 * diffPerc));
			points = points + addPoints;
			phonePoints.setCameraAPoints(addPoints);
			logger.info("Puntuació final afegida = " + addPoints);
		} else if (att.getCamera_a() < averages.getAverage_camera_a()) {
			logger.info("'camera_a' més petita que la mitjana! (dolent)");
			Attributes lowestAtt = attService.getLowestCameraA();
			float diff1 = averages.getAverage_camera_a() - lowestAtt.getCamera_a();
			float diff2 = averages.getAverage_camera_a() - att.getCamera_a();
			float diffPerc = diff2 / diff1 * 100;
			float addPoints = (Constants.POINTS_CAMERA_A -(Constants.POINTS_CAMERA_A / 100 * diffPerc));
			points = points + addPoints;
			phonePoints.setCameraAPoints(addPoints);
			logger.info("Puntuació final afegida = " + addPoints);
		} else {
			logger.info("'camera_a' igual que la mitjana!");
			points = points + Constants.POINTS_CAMERA_A;
			phonePoints.setCameraAPoints(Constants.POINTS_CAMERA_A);
			logger.info("Puntuació final afegida = " + Constants.POINTS_CAMERA_A);
		}
		
	// ------------------ COMPUTE CAMERA_B VALUE -----------------------------
		
		logger.info("Calculant puntuació de 'camera_b'...");
		if (att.getCamera_b() > averages.getAverage_camera_b()) {
			logger.info("'camera_b' més gran que la mitjana! (bo)");
			Attributes highestAtt= attService.getHighestCameraB();
			float diff1 = highestAtt.getCamera_b() - averages.getAverage_camera_b();
			float diff2 = att.getCamera_b() - averages.getAverage_camera_b();
			float diffPerc = diff2 / diff1 * 100;
			float addPoints = (Constants.POINTS_CAMERA_B + (Constants.POINTS_CAMERA_B / 100 * diffPerc));
			points = points + addPoints;
			phonePoints.setCameraBPoints(addPoints);
			logger.info("Puntuació final afegida = " + addPoints);
		} else if (att.getCamera_b() < averages.getAverage_camera_b()) {
			logger.info("'camera_b' més petita que la mitjana! (dolent)");
			Attributes lowestAtt = attService.getLowestCameraB();
			float diff1 = averages.getAverage_camera_b() - lowestAtt.getCamera_b();
			float diff2 = averages.getAverage_camera_b() - att.getCamera_b();
			float diffPerc = diff2 / diff1 * 100;
			float addPoints = (Constants.POINTS_CAMERA_B -(Constants.POINTS_CAMERA_B / 100 * diffPerc));
			points = points + addPoints;
			phonePoints.setCameraBPoints(addPoints);
			logger.info("Puntuació final afegida = " + addPoints);
		} else {
			logger.info("'camera_b' igual que la mitjana!");
			points = points + Constants.POINTS_CAMERA_B;
			phonePoints.setCameraBPoints(Constants.POINTS_CAMERA_B);
			logger.info("Puntuació final afegida = " + Constants.POINTS_CAMERA_B);
		}
		
	// ------------------ COMPUTE JACK VALUE -----------------------------
		
		logger.info("Calculant puntuació de 'jack'...");
		logger.info("Valor de 'jack' és: " + att.isJack());
		
		if (att.isJack()) {
			points = points + Constants.POINTS_CARD_SLOT;
			phonePoints.setJackPoints(Constants.POINTS_CARD_SLOT);
			logger.info("Puntuació final afegida = " + Constants.POINTS_CARD_SLOT);
		} else {
			phonePoints.setJackPoints(0);
			logger.info("Puntuació final afegida = 0");
		}
		
		// ------------------ COMPUTE DISPLAY_TYPE VALUE -----------------------------
		
		logger.info("Calculant puntuació de 'display_type'...");
		logger.info("Valor de 'display_type' es " + att.getCpu());
		float pointsDisplay = 0;
		switch(att.getDisplay_type()) {
		
		  case "led":
			  pointsDisplay = Constants.POINTS_DISPLAY_LED;
			  break;
			  
		  case "oled":
			  pointsDisplay = Constants.POINTS_DISPLAY_OLED;
			  break;
			
		  case "amoled":
			  pointsDisplay = Constants.POINTS_DISPLAY_AMOLED;
			  break;
			  
		  default:
			  pointsDisplay = 0;
		}
		
		points = points + pointsDisplay;
		phonePoints.setDisplayTypePoints(pointsDisplay);
		logger.info("Puntuació final afegida = " + pointsDisplay);
		
		
	// ------------------ COMPUTE ROM VALUE -----------------------------
		
		logger.info("Calculant puntuació de 'rom'...");
		if (att.getRom() > averages.getAverage_rom()) {
			logger.info("'rom' més gran que la mitjana! (bo)");
			Attributes highestAtt= attService.getHighestRom();
			float diff1 = highestAtt.getRom() - averages.getAverage_rom();
			float diff2 = att.getRom() - averages.getAverage_rom();
			float diffPerc = diff2 / diff1 * 100;
			float addPoints = (Constants.POINTS_ROM + (Constants.POINTS_ROM / 100 * diffPerc));
			points = points + addPoints;
			phonePoints.setRomPoints(addPoints);
			logger.info("Puntuació final afegida = " + addPoints);
		} else if (att.getRom() < averages.getAverage_rom()) {
			logger.info("'rom' més petita que la mitjana! (dolent)");
			Attributes lowestAtt = attService.getLowestRom();
			float diff1 = averages.getAverage_rom() - lowestAtt.getRom();
			float diff2 = averages.getAverage_rom() - att.getRom();
			float diffPerc = diff2 / diff1 * 100;
			float addPoints = (Constants.POINTS_ROM -(Constants.POINTS_ROM / 100 * diffPerc));
			points = points + addPoints;
			phonePoints.setRomPoints(addPoints);
			logger.info("Puntuació final afegida = " + addPoints);
		} else {
			logger.info("'rom' igual que la mitjana!");
			points = points + Constants.POINTS_ROM;
			phonePoints.setRomPoints(Constants.POINTS_ROM);
			logger.info("Puntuació final afegida = " + Constants.POINTS_ROM);
		}
				
	// ------------------ COMPUTE RAM VALUE -----------------------------
		
		logger.info("Calculant puntuació de 'ram'...");
		if (att.getRam() > averages.getAverage_ram()) {
			logger.info("'ram' més gran que la mitjana! (bo)");
			Attributes highestAtt= attService.getHighestRam();
			float diff1 = highestAtt.getRam() - averages.getAverage_ram();
			float diff2 = att.getRam() - averages.getAverage_ram();
			float diffPerc = diff2 / diff1 * 100;
			float addPoints = (Constants.POINTS_RAM + (Constants.POINTS_RAM / 100 * diffPerc));
			points = points + addPoints;
			phonePoints.setRamPoints(addPoints);
			logger.info("Puntuació final afegida = " + addPoints);
		} else if (att.getRam() < averages.getAverage_ram()) {
			logger.info("'ram' més petita que la mitjana! (dolent)");
			Attributes lowestAtt = attService.getLowestRam();
			float diff1 = averages.getAverage_ram() - lowestAtt.getRam();
			float diff2 = averages.getAverage_ram() - att.getRam();
			float diffPerc = diff2 / diff1 * 100;
			float addPoints = (Constants.POINTS_RAM -(Constants.POINTS_RAM / 100 * diffPerc));
			points = points + addPoints;
			phonePoints.setRamPoints(addPoints);
			logger.info("Puntuació final afegida = " + addPoints);
		} else {
			logger.info("'ram' igual que la mitjana!");
			points = points + Constants.POINTS_RAM;
			phonePoints.setRamPoints(Constants.POINTS_RAM);
			logger.info("Puntuació final afegida = " + Constants.POINTS_RAM);
		}
		
	// ------------------ COMPUTE RESOLUTION VALUE -----------------------------
		
		logger.info("Calculant puntuació de 'resolution'...");
		logger.info("Valor de 'resolution' es " + att.getResolution().toString());
		float pointsResolution = 0;
		switch(att.getResolution().getId()) {
		
		  case 1:
			  pointsResolution = Constants.POINTS_RESOLUTION_1;
			  break;
			  
		  case 2:
			  pointsResolution = Constants.POINTS_RESOLUTION_2;
			  break;
			
		  case 3:
			  pointsResolution = Constants.POINTS_RESOLUTION_3;
			  break;
			  
		  case 4:
			  pointsResolution = Constants.POINTS_RESOLUTION_4;
			  break;
			  
		  case 5:
			  pointsResolution = Constants.POINTS_RESOLUTION_5;
			  break;
			  
		  default:
			  pointsResolution = 0;
		}
		
		points = points + pointsResolution;
		phonePoints.setResolutionPoints(pointsResolution);
		logger.info("Puntuació final afegida = " + pointsResolution);
		
	// ------------------ COMPUTE BATTERY VALUE -----------------------------
		
		logger.info("Calculant puntuació de 'battery'...");
		if (att.getBattery() > averages.getAverage_battery()) {
			logger.info("'battery' més gran que la mitjana! (bo)");
			Attributes highestAtt= attService.getHighestBattery();
			float diff1 = highestAtt.getBattery() - averages.getAverage_battery();
			float diff2 = att.getBattery() - averages.getAverage_battery();
			float diffPerc = diff2 / diff1 * 100;
			float addPoints = (Constants.POINTS_BATTERY + (Constants.POINTS_BATTERY / 100 * diffPerc));
			points = points + addPoints;
			phonePoints.setBatteryPoints(addPoints);
			logger.info("Puntuació final afegida = " + addPoints);
		} else if (att.getBattery() < averages.getAverage_battery()) {
			logger.info("'battery' més petita que la mitjana! (dolent)");
			Attributes lowestAtt = attService.getLowestBattery();
			float diff1 = averages.getAverage_battery() - lowestAtt.getBattery();
			float diff2 = averages.getAverage_battery() - att.getBattery();
			float diffPerc = diff2 / diff1 * 100;
			float addPoints = (Constants.POINTS_BATTERY -(Constants.POINTS_BATTERY / 100 * diffPerc));
			points = points + addPoints;
			phonePoints.setBatteryPoints(addPoints);
			logger.info("Puntuació final afegida = " + addPoints);
		} else {
			logger.info("'battery' igual que la mitjana!");
			points = points + Constants.POINTS_BATTERY;
			phonePoints.setBatteryPoints(Constants.POINTS_BATTERY);
			logger.info("Puntuació final afegida = " + Constants.POINTS_BATTERY);
		}
				
	// ------------------ COMPUTE SENSORS VALUE -----------------------------
		
		logger.info("Calculant puntuació de 'sensors'...");
		
		if (att.getSensors().isAccelerometer()) {
			points = points + Constants.POINTS_ACCELEROMETER;
			phonePoints.setSensorsAccelerometerPoints(Constants.POINTS_ACCELEROMETER);
		} else {
			phonePoints.setSensorsAccelerometerPoints(0);
		}
		
		if (att.getSensors().isGyroscope()) {
			points = points + Constants.POINTS_GYROSCOPE;
			phonePoints.setSensorsGyroscopePoints(Constants.POINTS_GYROSCOPE);
		} else {
			phonePoints.setSensorsGyroscopePoints(0);
		}
		
		if (att.getSensors().isMagnetometer()) {
			points = points + Constants.POINTS_MAGNETOMETER;
			phonePoints.setSensorsMagnetometerPoints(Constants.POINTS_MAGNETOMETER);
		} else {
			phonePoints.setSensorsMagnetometerPoints(0);
		}
		
		if (att.getSensors().isGps()) {
			points = points + Constants.POINTS_GPS;
			phonePoints.setSensorsGpsPoints(Constants.POINTS_GPS);
		} else {
			phonePoints.setSensorsGpsPoints(0);
		}
		
		if (att.getSensors().isProximity()) {
			points = points + Constants.POINTS_PROXIMITY;
			phonePoints.setSensorsProximityPoints(Constants.POINTS_PROXIMITY);
		} else {
			phonePoints.setSensorsProximityPoints(0);
		}
		
		if (att.getSensors().isLight()) {
			points = points + Constants.POINTS_LIGHT;
			phonePoints.setSensorsLightPoints(Constants.POINTS_LIGHT);
		} else {
			phonePoints.setSensorsLightPoints(0);
		}
		
		if (att.getSensors().isFingerprint()) {
			points = points + Constants.POINTS_FINGERPRINT;
			phonePoints.setSensorsFingerprintPoints(Constants.POINTS_FINGERPRINT);
		} else {
			phonePoints.setSensorsFingerprintPoints(0);
		}
		
		if (att.getSensors().isBarometer()) {
			points = points + Constants.POINTS_BAROMETER;
			phonePoints.setSensorsBarometerPoints(Constants.POINTS_BAROMETER);
		} else {
			phonePoints.setSensorsBarometerPoints(0);
		}
		
		if (att.getSensors().isThermometer()) {
			points = points + Constants.POINTS_THERMOMETER;
			phonePoints.setSensorsThermometerPoints(Constants.POINTS_THERMOMETER);
		} else {
			phonePoints.setSensorsThermometerPoints(0);
		}
		
	// ------------------ COMPUTE PORT VALUE -----------------------------
		
		logger.info("Calculant puntuació de 'port'...");
		logger.info("Valor de port es: " + att.getPort());
		
		float pointsPort = 0;
		switch(att.getPort()) {
		
		  case "micro_usb":
			  pointsPort = Constants.POINTS_PORT_MICRO_USB;
			  break;
		  case "type_c":
			  pointsPort = Constants.POINTS_PORT_TYPE_C;
			  break;  
		  default:
			  pointsPort = 0;
			  break;
		}
		
		points = points + pointsPort;
		phonePoints.setPortPoints(pointsPort);
		logger.info("Puntuació final afegida = " + pointsPort);
		
	// ------------------ COMPUTE MULTITOUCH VALUE -----------------------------
		
		logger.info("Calculant puntuació de 'multitouch'...");
		logger.info("Valor de 'multitouch' es: " + att.isMultitouch());
		
		if (att.isMultitouch()) {
			points = points + Constants.POINTS_MULTITOUCH;
			phonePoints.setMultitouchPoints(Constants.POINTS_MULTITOUCH);
			logger.info("Puntuació final afegida = " + Constants.POINTS_MULTITOUCH);
		} else {
			phonePoints.setMultitouchPoints(0);
			logger.info("Puntuació final afegida = " + 0);
		}
		
		phonePoints.setTotalPoints(points);
		
		return phonePoints;
	}
}

