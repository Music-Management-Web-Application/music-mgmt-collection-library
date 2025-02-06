package com.kpalombo.music_mgmt_collection_library.interfaces;

import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Data
public abstract class CollectionController<T extends CollectionRecord, E extends UUID> {
    @Autowired
    public JpaRepository<T, UUID> repository;

    protected CollectionController(JpaRepository<T, UUID> repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public Response<T> create(@RequestBody @Valid Request<T> request) {
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

    @GetMapping("/get")
    public Response<T> get(@RequestParam String id) {
        Response<T> response = new Response<>();
        T record = repository.findById(UUID.fromString(id)).orElse(null);
        response.setResponse(new ResponseEntity<>(record, HttpStatus.OK));
        return response;
    }

    @PutMapping("/update")
    public Response<T> update(@RequestParam String id, @RequestBody @Valid Request<T> request) {
        Response<T> response = new Response<>();
        T record = request.getRecord();
        record.setId(UUID.fromString(id));
        T updatedRecord = repository.save(record);
        response.setResponse(new ResponseEntity<>(updatedRecord, HttpStatus.OK));
        return response;
    }

    @DeleteMapping("/delete")
    public Response<T> delete(@RequestParam String id) {
        Response<T> response = new Response<>();
        T record = repository.findById(UUID.fromString(id)).orElse(null);
        if (record == null) {
            response.setResponse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } else {
            repository.delete(record);
            response.setResponse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        }
        return response;
    }
}
