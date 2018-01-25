package com.project.bnb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.bnb.models.Pool;
import com.project.bnb.models.User;
import com.project.bnb.repositories.PoolRepository;

@Service
public class PoolService {
	private PoolRepository _pr;

	public PoolService(PoolRepository _pr) {
		super();
		this._pr = _pr;
	}
	
	public void createPool(Pool pool, User user) {
		pool.setHost(user);
		_pr.save(pool);
	}
	
	public List<Pool> getAllPools() {
		return (List<Pool>) _pr.findAll();
	}
	
	public List<Pool> searchPools(String term) {
		List<Pool> allPools = getAllPools();
		List<Pool> results = new ArrayList<Pool>();
		for (Pool pool : allPools) {
			if (pool.getAddress().toLowerCase().contains(term)) {
				results.add(pool);
			}
		}
		return results;
	}
	
	public Pool getPoolById(Long id) {
		return (Pool) _pr.findOne(id);
	}
	
	public void deletePool(Long id) {
		_pr.delete(id);
	}
	
	public void updatePool(Pool pool) {
		_pr.save(pool);
	}
	
}
