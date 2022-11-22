package com.bits.dao;

import org.springframework.stereotype.Repository;

import com.bits.models.Cycle;

@Repository
public class CycleDAO extends AbstractJPADAO<Cycle> {// implements IFooDAO{

   public CycleDAO(){
      setClazz(Cycle.class );
   }
}
