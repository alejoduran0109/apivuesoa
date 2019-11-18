package co.edu.uniajc.wse_bodega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.uniajc.wse_bodega.model.Bodega;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Integer>{
	// Estados findByIdEstado(@Param("id_estado") int id);
}
