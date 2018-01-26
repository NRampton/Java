package com.project.rings.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.rings.models.Ring;
import com.project.rings.models.User;
import com.project.rings.repositories.RingRepo;
import com.project.rings.repositories.UserRepo;

@Service
public class RingService {

	private RingRepo _rr;
	private UserRepo _ur;
		
	public RingService(RingRepo _rr, UserRepo _ur){
		this._rr = _rr;
		this._ur = _ur;
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
		bearer.setLastPickUp(new Date());
		_rr.save(ring);
	}
	
	public void loseRing(Long id) {
		Ring ring = _rr.findOne(id);
		ring.setBearer(null);
		_rr.save(ring);
	}
}
