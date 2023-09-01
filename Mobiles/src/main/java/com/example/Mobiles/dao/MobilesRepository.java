package com.example.Mobiles.dao;

import com.example.Mobiles.entity.Mobiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface MobilesRepository extends JpaRepository<Mobiles, Integer> {

    Optional<Mobiles> findByName(String name);





}
