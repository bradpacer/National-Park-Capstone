package com.techelevator.npgeek.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Park;

@Component
public interface ParkDao {
	public List<Park> getAllParks();
	public Park getParkByCode(String code);
}
