package com.project.rings.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.rings.models.Ring;
import com.project.rings.repositories.RingRepo;

@Service
public class RingService {

	private RingRepo _rr;
		
	public RingService(RingRepo _rr){
		this._rr = _rr;
	}
	
	public List<Ring> getAvailableRings() {
		return (List<Ring>) _rr.findAvailableRings();
	}
	
}
