package com.desaextremo.retotres.repository;

import com.desaextremo.retotres.entity.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GadgetRepository extends MongoRepository<Gadget,Integer> {
}
