package com.smartequate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartequate.dto.Attributes;
import com.smartequate.dto.Averages;
import com.smartequate.repository.AveragesRepository;

@Service
public class AveragesService {
	
	@Autowired
	private AveragesRepository averageRepo;
	
	@Autowired
	AttributesService attService;
	
	public Averages getLastAverages() {
		
		Averages avr = averageRepo.findByLast(true);
		
		return avr;
	}
	
	public void saveAverages(Averages avg) {
		averageRepo.save(avg);
	}
	
	public void recalculateAverages( ) {
		List<Attributes> atts = attService.getAllAttributes();
		float avgHeight = 0;
		float avgWeight = 0;
		float avgDisplaySize = 0;
		float avgCameraA = 0;
		float avgCameraB = 0;
		float avgRom = 0;
		float avgRam = 0;
		float avgResolutionWidth = 0;
		float avgResolutionHeight = 0;
		float avgBattery = 0;
		
		for (Attributes attVar: atts) {
			avgHeight = avgHeight + attVar.getSize().getHeight();
			avgWeight = avgWeight + attVar.getWeight();
			avgDisplaySize = avgDisplaySize + attVar.getDisplay_size();
			avgCameraA = avgCameraA + attVar.getCamera_a();
			avgCameraB = avgCameraB + attVar.getCamera_b();
			avgRom = avgRom + attVar.getRom();
			avgRam = avgRam + attVar.getRam();
			avgResolutionWidth = avgResolutionWidth + attVar.getResolution().getWidth();
			avgResolutionHeight = avgResolutionHeight + attVar.getResolution().getHeight();
			avgBattery = avgBattery + attVar.getBattery();
		}
		
		avgHeight = avgHeight  / atts.size();
		avgWeight = avgWeight  / atts.size();
		avgDisplaySize = avgDisplaySize / atts.size();
		avgCameraA = avgCameraA / atts.size();
		avgCameraB = avgCameraB / atts.size();
		avgRom = avgRom / atts.size();
		avgRam = avgRam / atts.size();
		avgResolutionWidth = avgResolutionWidth / atts.size();
		avgResolutionHeight = avgResolutionHeight / atts.size();
		avgBattery = avgBattery / atts.size();
		
		Averages avgs = new Averages();
		avgs.setAverage_height(avgHeight);
		avgs.setAverage_weight(avgWeight);
		avgs.setAverage_display_size(avgDisplaySize);
		avgs.setAverage_camera_a(avgCameraA);
		avgs.setAverage_camera_b(avgCameraB);
		avgs.setAverage_rom(avgRom);
		avgs.setAverage_ram(avgRam);
		avgs.setAverage_resolution_width(avgResolutionWidth);
		avgs.setAverage_resolution_height(avgResolutionHeight);
		avgs.setAverage_battery(avgBattery);
		avgs.setLast(true);
		
		Averages lastAvg = getLastAverages();
		if (lastAvg != null) {
			lastAvg.setLast(false);
			saveAverages(lastAvg);
		}

		saveAverages(avgs);
	}
	

}
