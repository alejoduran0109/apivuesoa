package co.edu.uniajc.wse_fabrica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.uniajc.wse_fabrica.model.Fabrica;

@Repository
public interface FabricaRepository extends JpaRepository<Fabrica, Integer>{
	// Estados findByIdEstado(@Param("id_estado") int id);
}
