package com.kpalombo.music_mgmt_collection_library.annnotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@RestController
@RequestMapping
public @interface CollectionRecordRepository {
    @AliasFor(annotation = RequestMapping.class, value = "path")
    String[] path() default {};
}
