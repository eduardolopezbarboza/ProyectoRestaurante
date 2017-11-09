package pe.usmp.model;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;



public interface ProductoRepository extends Repository<Producto, Long> {

	void save(Producto producto) throws DataAccessException;

	List<Producto> findAll();

	Producto findOne(Long codigo);
	
	void delete(Long codigo);
	
	
}
