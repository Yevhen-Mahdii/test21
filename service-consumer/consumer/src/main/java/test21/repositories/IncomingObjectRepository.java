package test21.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import test21.data.model.IncomingObject;

public interface IncomingObjectRepository extends MongoRepository<IncomingObject, String> {
}
