/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.security.service;

import com.example.demo.security.dto.Geocoding;
import com.example.demo.security.dto.WeatherData;
import com.example.demo.security.entity.Consulta;
import com.example.demo.security.enums.ConsultaTipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.security.repository.ConsultaRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author suasebas
 */
@Service
@Transactional

public class ConsultaService {

    private final static String API_KEY = "ad060ebee1c26ccba1739a90f1b2bf46";
    private static ConsultaTipo ConsultaTipo;
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    ConsultaRepository consultaRepository;

    public List<Consulta> list() {
        return consultaRepository.findAll();
    }

    public Optional<Consulta> getOne(int id) {
        return consultaRepository.findById(id);
    }

    public void save(Consulta consulta) {
        consultaRepository.save(consulta);
    }

    public void delete(int id) {
        consultaRepository.deleteById(id);
    }

    @Cacheable(value = "weatherData", key = "#city")
    public Consulta getWeatherDataCurrent(String city) {
        ConsultaTipo = ConsultaTipo.weather;
        String url = getApiUrl(ConsultaTipo, city, 0, 0);
        RestTemplate restTemplate = new RestTemplate();
        WeatherData weatherData = restTemplate.getForObject(url, WeatherData.class);

        Consulta consulta = new Consulta();
        consulta.setCiudad(city);
        consulta.setTipoConsulta(ConsultaTipo.weather);
        consulta.setFechaHora(LocalDateTime.now());
        consulta.setRespuesta(weatherData.getWeather().toString());

        return consulta;
    }

    @Cacheable(value = "weatherData", key = "#city")
    public Consulta getWeatherDataForecast(String city) {

        ConsultaTipo = ConsultaTipo.forecast;
        String url = getApiUrl(ConsultaTipo, city, 0, 0);
        RestTemplate restTemplate = new RestTemplate();
        String weatherDataJson = restTemplate.getForObject(url, String.class);

        Consulta consulta = new Consulta();
        consulta.setCiudad(city);
        consulta.setTipoConsulta(ConsultaTipo);
        consulta.setFechaHora(LocalDateTime.now());
        consulta.setRespuesta(weatherDataJson);

        return consulta;
    }

    @Cacheable(value = "weatherData", key = "#city")
    public Consulta getAirPollutionData(String city) {

        String geocodingUrl = "http://api.openweathermap.org/geo/1.0/direct?q=" + city + "&limit=1&appid=" + API_KEY;
        RestTemplate restTemplate = new RestTemplate();
        Geocoding[] geocoding = restTemplate.getForObject(geocodingUrl, Geocoding[].class);
        double lat = geocoding[0].getLat();
        double lon = geocoding[0].getLon();

        ConsultaTipo = ConsultaTipo.air_pollution;
        String airPollutionUrl = getApiUrl(ConsultaTipo, city, lat, lon);
        String airPollutionData = restTemplate.getForObject(airPollutionUrl, String.class);

        Consulta consulta = new Consulta();
        consulta.setCiudad(city);
        consulta.setTipoConsulta(ConsultaTipo);
        consulta.setFechaHora(LocalDateTime.now());
        consulta.setRespuesta(airPollutionData);

        return consulta;
    }

    public final static String getApiUrl(ConsultaTipo consultaTipo, String city, double lat, double lon) {
        String baseUrl = "http://api.openweathermap.org/data/2.5/";
        String apiKey = "&appid=" + API_KEY;
        switch (consultaTipo) {
            case weather:
                return baseUrl + "weather?q=" + city + apiKey;
            case forecast:
                return baseUrl + "forecast?q=" + city + apiKey;
            case air_pollution:
                return baseUrl + "air_pollution?lat=" + lat + "&lon=" + lon + apiKey;
            default:
                throw new IllegalArgumentException("Tipo de consulta no soportado: " + consultaTipo);
        }
    }

}
