package com.kpalombo.music_mgmt_collection_library.interfaces;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
public abstract class CollectionController<T, Long> {
    @Autowired
    public JpaRepository<T, Long> repository;

    protected CollectionController(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public Response<T> create(@RequestBody Request<T> request) {
        Response<T> response = new Response<>();
        T record = request.getRecord();
        T createdRecord = repository.save(record);
        response.setResponse(new ResponseEntity<>(createdRecord, HttpStatus.CREATED));
        return response;
    }

    @GetMapping("/list")
    public ListResponse<T> list() {
        List<T> records = repository.findAll();
        ListResponse<T> response = new ListResponse<>();
        response.setResponse(new ResponseEntity<>(records, HttpStatus.OK));
        return response;
    }

    @GetMapping("/{id}")
    public Response<T> get(@RequestBody Request<T> request) {
        Response<T> response = new Response<>();
        T record = repository.findById((Long) request.getId()).orElse(null);
        response.setResponse(new ResponseEntity<>(record, HttpStatus.OK));
        return response;
    }

    @PutMapping("/{id}")
    public Response<T> update(@RequestBody Request<T> request) {
        Response<T> response = new Response<>();
        T record = repository.findById((Long) request.getId()).orElse(null);
        T updatedRecord = repository.save(record);
        response.setResponse(new ResponseEntity<>(updatedRecord, HttpStatus.OK));
        return response;
    }

    @DeleteMapping("/{id}")
    public Response<T> delete(@RequestBody Request<T> request) {
        Response<T> response = new Response<>();
        String id = request.getId();
        T record = repository.findById((Long) request.getId()).orElse(null);
        repository.delete(record);
        response.setResponse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        return response;
    }
}
