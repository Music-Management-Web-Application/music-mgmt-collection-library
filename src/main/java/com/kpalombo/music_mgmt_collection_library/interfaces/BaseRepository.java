package com.kpalombo.music_mgmt_collection_library.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T extends CollectionRecord> extends JpaRepository<T, Long> {


//    @GetMapping("/{id}")
//    public ResponseEntity<T> getById(@PathVariable Long id) {
//        return ResponseEntity.of(getRepository().findById(id));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<T> update(@PathVariable Long id, @RequestBody T entity) {
//        return ResponseEntity.of(getRepository().findById(id).map(existing -> {
//            // Update existing entity with values from entity
//            // ...
//            return getRepository().save(existing);
//        }));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        getRepository().deleteById(id);
//        return ResponseEntity.noContent().build();
//    }



//     default GetResponse<T> get(GetRequest<T> request) {
//         GetResponse<T> response = new GetResponse<>();
//         T record = findById(request.getId()).orElse(null);
//         response.setResponse(new ResponseEntity<>(record, HttpStatus.OK));
//         return response;
//     }
//     default UpdateResponse<T> update(UpdateRequest<T> request) {
//         UpdateResponse<T> response = new UpdateResponse<>();
//         T record = request.getRecord();
//         T updatedRecord = save(record);
//         response.setResponse(new ResponseEntity<>(updatedRecord, HttpStatus.OK));
//         return response;
//     }
//
//    default DeleteResponse<T> delete(DeleteRequest<T> request) {
//        DeleteResponse<T> response = new DeleteResponse<>();
//        T record = request.getRecord();
//        delete(record);
//        response.setResponse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
//        return response;
//    }
}
