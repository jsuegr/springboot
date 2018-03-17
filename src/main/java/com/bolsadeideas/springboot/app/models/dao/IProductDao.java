package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Producto;

public interface IProductDao extends CrudRepository<Producto, Long> {

	
	public List<Producto> findByNombreLikeIgnoreCase(String term);
}
