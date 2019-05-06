package com.tqs.homework;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DailyRepository extends JpaRepository<Daily, Long> {

}