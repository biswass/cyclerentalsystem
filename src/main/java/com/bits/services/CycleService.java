package com.bits.services;

import com.bits.models.Cycle;

public interface CycleService {
	
	void addCycle(Cycle cycle);
	
	Cycle getCycle(long cycleId);
	
	void removeCycle(long cycleId);
}
