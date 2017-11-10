package pe.usmp.model;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

public interface ContactoRepository extends Repository<Contacto, Long>{

	void save(Contacto contacto) throws DataAccessException;
	
	List<Contacto> findAll();
	Contacto findOne(Long codigo);
	void delete(Long codigo);
}
