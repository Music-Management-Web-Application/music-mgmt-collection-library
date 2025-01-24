package com.kpalombo.music_mgmt_collection_library.interfaces;

import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
public class Response<CollectionRecord> {
    public ResponseEntity<CollectionRecord> response;
}
