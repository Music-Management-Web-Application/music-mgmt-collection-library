package com.kpalombo.music_mgmt_collection_library.interfaces;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class CollectionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}