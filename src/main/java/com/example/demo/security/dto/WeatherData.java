package com.example.demo.security.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
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
public class WeatherData {

    private List<Weather> weather;

 
    

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Weather {

        private int id;
        private String main;
        private String description;
        private String icon;

        @Override
        public String toString() {
            return "Weather{" + "id=" + id + ", main=" + main + ", description=" + description + ", icon=" + icon + '}';
        }

    }

}
