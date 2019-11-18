package co.edu.uniajc.wse_tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import co.edu.uniajc.wse_tienda.model.Tienda;
import co.edu.uniajc.wse_tienda.repository.TiendaRepository;

@Service
public class TiendaService {

	@Autowired
	TiendaRepository fabricaRepository;
	
	public Tienda saveEstado(Tienda fabrica) {
		return fabricaRepository.save(fabrica);
	}
	
	public Tienda updateEstado(Tienda fabrica) {
		return fabricaRepository.save(fabrica);
	}
	
	public void deleteEstado(int id) {
		fabricaRepository.deleteById(id);
	}
	
	public List<Tienda> listar(){
		return fabricaRepository.findAll();
	}
	/*
	public Estados getByIdEstado(int id) {
		return estadosRepository.findByIdEstado(id);
	}
*/	
}
