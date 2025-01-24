package com.kpalombo.music_mgmt_collection_library.interfaces;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public interface CollectionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long getId();
    void setId(Long id);
}