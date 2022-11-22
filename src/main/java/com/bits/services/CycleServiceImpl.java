package com.bits.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bits.dao.CycleDAO;
import com.bits.models.Cycle;

@Service
public class CycleServiceImpl implements CycleService{
	
	@Autowired
	CycleDAO cycleDAO;
	
	@Override
	@Transactional
	public void addCycle(Cycle cycle) {
		cycleDAO.create(cycle);
	}
	
	@Override
	public Cycle getCycle(long cycleId) {
		return cycleDAO.findOne(cycleId);
	}

	@Override
	@Transactional
	public void removeCycle(long cycleId) {
		cycleDAO.deleteById(cycleId);
	}
}
