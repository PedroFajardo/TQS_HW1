package com.tqs.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@Controller
@RequestMapping(path="/api")
public class ForecastController {
    private static final Logger log = LoggerFactory.getLogger(ForecastController.class);

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private ForecastRepository forecastRepository;
    @Autowired
    private DailyRepository dailyRepository;
    @Autowired
    private DataRepository dataRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Forecast> getAllForecasts() {
        // This returns a JSON or XML with the users
        return forecastRepository.findAll();
    }


    @GetMapping(path="/forecast")
    public @ResponseBody Forecast getForecast(@RequestParam double latitude, @RequestParam double longitude) {
        if (forecastRepository.existsByLatitudeAndLongitude(latitude, longitude)) {
            Forecast forecast = forecastRepository.findByLatitudeAndLongitude(latitude,longitude);
            log.info(forecast.toString());
            return forecast;
        } else {
            Forecast forecast = restTemplate.getForObject(
                    "https://api.darksky.net/forecast/21555dff0ae2af8abca7aa189973ef7a/" + latitude + "," + longitude, Forecast.class);

            for (Data d : forecast.getDaily().getData())
                dataRepository.save(d);
            dailyRepository.save(forecast.getDaily());
            forecastRepository.save(forecast);
            log.info(forecast.toString());
            return forecast;
        }
    }
}
