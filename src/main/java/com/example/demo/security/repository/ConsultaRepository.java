/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.security.repository;

import com.example.demo.security.entity.Consulta;
import com.example.demo.security.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author suasebas
 */
public interface ConsultaRepository extends JpaRepository<Consulta, Integer>{
    
    List<Consulta> findByUsuario(Usuario usuario);
    
    
}
