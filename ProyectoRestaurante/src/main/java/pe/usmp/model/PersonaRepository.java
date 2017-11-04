package pe.usmp.model;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

public interface PersonaRepository extends Repository<Persona, Long>{

	void save(Persona persona) throws DataAccessException;
	
	@Cacheable("personas")
	List<Persona> findAll();
	
	/*Persona findOne(Long id);*/
}

