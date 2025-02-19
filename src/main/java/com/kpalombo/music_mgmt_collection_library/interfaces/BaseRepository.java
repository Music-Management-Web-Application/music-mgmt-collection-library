package com.kpalombo.music_mgmt_collection_library.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<T extends CollectionRecord, E extends UUID> extends JpaRepository<T, E> {
}
