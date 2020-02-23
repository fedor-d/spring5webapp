package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author FedorD
 * @date 2020-02-23
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
