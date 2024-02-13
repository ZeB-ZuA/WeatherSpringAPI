/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.security.Bucket;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import java.time.Duration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author suasebas
 */
@Component
public class LimitInterceptor implements HandlerInterceptor {

    private final ConcurrentHashMap<String, Bucket> buckets = new ConcurrentHashMap<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String apiKey = request.getHeader("Authorization");
        if (apiKey == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No hay tokens del bucket para el usuario");
            return false;
        }

        Bucket requestBucket = buckets.computeIfAbsent(apiKey, k -> createNewBucket());
        if (requestBucket.tryConsume(1)) {
            return true;
        } else {

            response.sendError(429, "Se ha superado el limite de la api");
            return false;
        }
    }

    private Bucket createNewBucket() {
        return Bucket4j.builder()
                .addLimit(Bandwidth.simple(10, Duration.ofHours(1)))
                .build();
    }

}
