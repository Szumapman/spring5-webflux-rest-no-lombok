package guru.springframework.spring5webfluxrestnolombok.repositories;

import guru.springframework.spring5webfluxrestnolombok.domain.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
}
