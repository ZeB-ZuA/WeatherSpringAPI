/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.security.controller;

import com.example.demo.dto.Mensaje;
import com.example.demo.security.entity.Consulta;
import com.example.demo.security.entity.Usuario;
import com.example.demo.security.entity.UsuarioPrincipal;
import com.example.demo.security.service.ConsultaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suasebas
 */
@RestController
@RequestMapping("/weather")
@CrossOrigin(origins = "*")
public class ConsultaController {

    @Autowired
    ConsultaService consultaService;

    @GetMapping("")
    public ResponseEntity<List<Consulta>> findAll() {
        List<Consulta> list = consultaService.list();
        return new ResponseEntity<List<Consulta>>(list, HttpStatus.OK);
    }

    @GetMapping("/current/{city}")
    public ResponseEntity<Mensaje> getConsultaCurrent(@PathVariable("city") String city) {
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario usuario = usuarioPrincipal.getUsuario();

        Consulta consulta = consultaService.getWeatherDataCurrent(city);
        consulta.setUsuario(usuario);
        consultaService.save(consulta);

        return new ResponseEntity<Mensaje>(new Mensaje("Consulta generada y guardada con exito"), HttpStatus.CREATED);
    }

    @GetMapping("/forecast/{city}")
    public ResponseEntity<Mensaje> getConsultaForecast(@PathVariable("city") String city) {
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario usuario = usuarioPrincipal.getUsuario();

        Consulta consulta = consultaService.getWeatherDataForecast(city);
        consulta.setUsuario(usuario);
        consultaService.save(consulta);

        return new ResponseEntity<Mensaje>(new Mensaje("Consulta generada y guardada con exito"), HttpStatus.CREATED);
    }

    @GetMapping("/air_pollution/{city}")
    public ResponseEntity<Mensaje> getConsultaAirPollution(@PathVariable("city") String city) {
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario usuario = usuarioPrincipal.getUsuario();

        Consulta consulta = consultaService.getAirPollutionData(city);
        consulta.setUsuario(usuario);
        consultaService.save(consulta);

        return new ResponseEntity<Mensaje>(new Mensaje("Consulta generada y guardada con éxito"), HttpStatus.CREATED);
    }
}
