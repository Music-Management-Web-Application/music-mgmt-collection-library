package com.kpalombo.music_mgmt_collection_library.interfaces;

import lombok.Data;

@Data
public class Request<CollectionRecord> {
    private CollectionRecord record;
    private String id;
}
