package pe.usmp.model;

import java.util.List;



import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;



public interface PersonaRepository extends Repository<Persona, Long>{

	void save(Persona persona) throws DataAccessException;
	
	List<Persona> findAll();
	
	@Query("select password from Persona where password = ?1")
	List<Persona> findByPassword(String password);
	
	@Query("select nombre from Persona where password = ?1")
	List<Persona> findNombreByPassword(String password);
	
	Persona findOne(Long id);
	void delete(Long id);
	
}
