package me.springframework.spring5webapp.repositories;

import me.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepo extends CrudRepository<Publisher, Long> {
}
