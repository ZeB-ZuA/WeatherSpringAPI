
package com.example.demo.security.dto;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Geocoding {
    private String name;
    private double lat;
    private double lon;
}