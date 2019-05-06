package com.TQS.homework;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ForecastRepository extends CrudRepository<Forecast, Integer> {

    Forecast findByLatitudeAndLongitude(double latitude,double longitude);
    boolean existsByLatitudeAndLongitude(double latitude, double longitude);

}