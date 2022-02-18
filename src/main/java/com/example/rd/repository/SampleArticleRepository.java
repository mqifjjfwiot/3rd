package com.example.rd.repository;

import com.example.rd.entity.SampleArticle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleArticleRepository extends CrudRepository<SampleArticle,Long> {

}