package me.springframework.spring5webapp.repositories;

import me.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Long>
{

}
