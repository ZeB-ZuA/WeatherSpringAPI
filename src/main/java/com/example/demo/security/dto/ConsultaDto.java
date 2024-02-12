/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.security.dto;

import com.example.demo.security.enums.ConsultaTipo;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 *
 * @author suasebas
 */
@Getter
@Setter
@NoArgsConstructor
public class ConsultaDto {

    @NotBlank
    private String cuidad;
    @NotBlank
    private ConsultaTipo consultaTipo;

    public ConsultaDto(    @NotBlank String cuidad,    @NotBlank ConsultaTipo consultaTipo) {
        this.cuidad = cuidad;
        this.consultaTipo = consultaTipo;
    }
    
    
}
