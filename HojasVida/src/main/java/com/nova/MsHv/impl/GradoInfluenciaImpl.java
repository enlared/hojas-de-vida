package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.GradoInfluenciaDao;
import com.nova.MsHv.entidad.GradoInfluencia;


@Service
public class GradoInfluenciaImpl  {

	@Autowired private GradoInfluenciaDao dao ;
	
	public List<GradoInfluencia> consultarAll(){
		return dao.findAll();
	}
}
