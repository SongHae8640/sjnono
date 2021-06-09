package com.sjnono.demo.domain.ex.repository;


import com.sjnono.demo.domain.ex.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExRepository extends JpaRepository<Example, Long>, ExRepositoryCustom {
}
