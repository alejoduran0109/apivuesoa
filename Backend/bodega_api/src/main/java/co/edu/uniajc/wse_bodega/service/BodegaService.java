package co.edu.uniajc.wse_bodega.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import co.edu.uniajc.wse_bodega.model.Bodega;
import co.edu.uniajc.wse_bodega.repository.BodegaRepository;

@Service
public class BodegaService {

	@Autowired
	BodegaRepository bodegaRepository;
	
	public Bodega saveEstado(Bodega bodega) {
		return bodegaRepository.save(bodega);
	}
	
	public Bodega updateEstado(Bodega bodega) {
		return bodegaRepository.save(bodega);
	}
	
	public void deleteEstado(int id) {
		bodegaRepository.deleteById(id);
	}
	
	public List<Bodega> listar(){
		return bodegaRepository.findAll();
	}
	/*
	public Estados getByIdEstado(int id) {
		return estadosRepository.findByIdEstado(id);
	}
*/	
}
