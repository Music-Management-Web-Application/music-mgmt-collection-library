package com.kpalombo.music_mgmt_collection_library.annnotation;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Entity
@Table
public @interface Collection {
    @AliasFor(annotation = Entity.class, attribute = "name")
    String name() default "";
}
