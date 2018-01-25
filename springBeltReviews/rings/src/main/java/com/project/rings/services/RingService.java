package com.project.rings.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.rings.models.Ring;
import com.project.rings.models.User;
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
	
	public void forgeRing(String name, User smith) {
		Ring newRing = new Ring();
		newRing.setName(name);
		newRing.setSmith(smith);
		_rr.save(newRing);
	}
	
	public void claimRing(Ring ring, User bearer) {
		ring.setBearer(bearer);
		_rr.save(ring);
	}
	
	public void loseRing(Long id) {
		Ring ring = _rr.findOne(id);
		ring.setBearer(null);
		_rr.save(ring);
	}
}
