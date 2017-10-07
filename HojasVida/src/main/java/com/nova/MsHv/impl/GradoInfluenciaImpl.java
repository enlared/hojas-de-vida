package com.nova.MsHv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.MsHv.dao.InfluenciaCompraDao;
import com.nova.MsHv.entidad.InfluenciaCompra;


@Service
public class GradoInfluenciaImpl  {

	@Autowired private InfluenciaCompraDao dao ;
	
	public List<InfluenciaCompra> consultarAll(){
		return dao.findAll();
	}
}
