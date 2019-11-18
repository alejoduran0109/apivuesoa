package co.edu.uniajc.wse_tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.uniajc.wse_tienda.model.Tienda;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Integer>{
	// Estados findByIdEstado(@Param("id_estado") int id);
}
