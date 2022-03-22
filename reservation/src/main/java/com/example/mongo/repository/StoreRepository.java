package com.example.mongo.repository;

import com.example.mongo.model.Store;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository extends MongoRepository<Store, Long> {

    Optional<Store> findById(Long ReservationId);
    List <Store> findAll();
    void deleteById(Long ReservationId);

}
