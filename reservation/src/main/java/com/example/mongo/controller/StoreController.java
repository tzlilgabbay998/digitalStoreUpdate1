package com.example.mongo.controller;

import com.example.mongo.exception.ResourceNotFoundException;
import com.example.mongo.model.Store;
import com.example.mongo.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {

    private final StoreRepository storeRepository;

    @GetMapping
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Store getStoreById(@PathVariable Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store", "id", id));
    }

    @PostMapping
    public List<Store> addStores(@RequestBody List<Store> stores) {
        return storeRepository.saveAll(stores);
    }

    @PutMapping
    public Store editStore(@RequestBody Store store){
        if (storeRepository.existsById(store.getId())) {
            return new ResponseEntity(HttpStatus.);
        } else {

        }  return new ResponseEntity(HttpStatus.OK);
            return storeRepository.saveAndFlush(store);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        if (storeRepository.existsById(id)) {
            storeRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
