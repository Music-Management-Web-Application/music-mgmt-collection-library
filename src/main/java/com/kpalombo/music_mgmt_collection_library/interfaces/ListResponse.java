package com.kpalombo.music_mgmt_collection_library.interfaces;

import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Data
public class ListResponse<CollectionRecord> {
    public ResponseEntity<List<CollectionRecord>> response;
}
