package com.codingdojo.nrampton.relationships.services;

import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.relationships.models.License;
import com.codingdojo.nrampton.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private LicenseRepository _lr;
	
	public LicenseService(LicenseRepository _lr) {
		this._lr = _lr;
	}
	
	public void createLicense(License license) {
		_lr.save(license);
	}
	
	public void theNuclearOption() {
		_lr.deleteAll();
	}
}
