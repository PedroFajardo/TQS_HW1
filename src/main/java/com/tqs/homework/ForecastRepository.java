package com.tqs.homework;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    Forecast findByLatitudeAndLongitude(double latitude,double longitude);
    boolean existsByLatitudeAndLongitude(double latitude, double longitude);

}