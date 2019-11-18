package co.edu.uniajc.wse_fabrica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import co.edu.uniajc.wse_fabrica.model.Fabrica;
import co.edu.uniajc.wse_fabrica.repository.FabricaRepository;

@Service
public class FabricaService {

	@Autowired
	FabricaRepository fabricaRepository;
	
	public Fabrica saveEstado(Fabrica fabrica) {
		return fabricaRepository.save(fabrica);
	}
	
	public Fabrica updateEstado(Fabrica fabrica) {
		return fabricaRepository.save(fabrica);
	}
	
	public void deleteEstado(int id) {
		fabricaRepository.deleteById(id);
	}
	
	public List<Fabrica> listar(){
		return fabricaRepository.findAll();
	}
	/*
	public Estados getByIdEstado(int id) {
		return estadosRepository.findByIdEstado(id);
	}
*/	
}
