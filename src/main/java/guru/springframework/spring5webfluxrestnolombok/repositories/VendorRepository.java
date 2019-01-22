package guru.springframework.spring5webfluxrestnolombok.repositories;

import guru.springframework.spring5webfluxrestnolombok.domain.Vendor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VendorRepository extends ReactiveMongoRepository<Vendor, String> {
}
