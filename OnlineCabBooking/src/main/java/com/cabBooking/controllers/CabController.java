package com.cabBooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cabBooking.exceptions.CabException;
import com.cabBooking.models.Cab;
import com.cabBooking.services.CabService;

@ControllerAdvice
public class CabController {
	@Autowired
	public CabService cabDao;
	
	@PostMapping("/registercabs")
	public ResponseEntity<Cab> registerCabHandler( @RequestBody Cab cab) throws CabException{
		 Cab registeredCab=cabDao.registerCab(cab);
		 return new ResponseEntity<Cab>(registeredCab,HttpStatus.OK);
		
		
	}

	
	@PutMapping("/updatecabs")
	public ResponseEntity<Cab> updateCabHandler( @RequestBody Cab cab) throws CabException{
		 Cab updatedCab=cabDao.updateCab(cab);
		 return new ResponseEntity<Cab>(updatedCab,HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/deletecabs/{cabId}")
	public ResponseEntity<Cab> deleteCabHandler(@PathVariable int cabId) throws CabException{
		 Cab deletedCab=cabDao.deleteCab(cabId);
		 return new ResponseEntity<Cab>(deletedCab,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/cabs/{carType}")
	public ResponseEntity<List<Cab>> CabTypeHandler( @RequestBody String carType) throws CabException{
		 List<Cab> viewCabs=cabDao.viewCabsOfType(carType);
		 return new ResponseEntity<List<Cab>>(viewCabs,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/cabs/{carType}")
	public ResponseEntity<Integer> NumberOfCabTypeHandler( @RequestBody String carType) throws CabException{
		 int carTypeNumber=cabDao.countCabsOfType(carType);
		 return new ResponseEntity<Integer>(carTypeNumber,HttpStatus.OK);
		
		
	}



}
