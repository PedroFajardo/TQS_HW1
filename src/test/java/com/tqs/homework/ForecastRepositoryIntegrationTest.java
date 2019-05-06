package com.tqs.homework;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ForecastRepositoryIntegrationTest{

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ForecastRepository forecastRepo;

    @Test
    public void whenFindByLatitudeAndLongitude_thenReturnForecast(){

        //London Coordinates
        double latitude = 51.507351;
        double longitude = -0.127758;


        Forecast london = new Forecast(latitude, longitude);
        entityManager.persist(london);
        entityManager.flush();

        Forecast found = forecastRepo.findByLatitudeAndLongitude(london.getLatitude(), london.getLongitude());

        assertThat(london.equals(found));
        
    }

}
