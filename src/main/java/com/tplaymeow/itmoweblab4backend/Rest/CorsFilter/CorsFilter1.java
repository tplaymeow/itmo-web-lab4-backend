//package com.tplaymeow.itmoweblab4backend.Rest.CorsFilter;
//
//import lombok.extern.java.Log;
//
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerResponseContext;
//import javax.ws.rs.container.ContainerResponseFilter;
//import javax.ws.rs.container.PreMatching;
//import javax.ws.rs.ext.Provider;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Objects;
//
//@PreMatching
//@Log
//public class CorsFilter implements ContainerResponseFilter {
//    private static List<String> allowedOrigins =
//            Arrays.asList("http://localhost:3000", "https://se.ifmo.ru");
//
//    @Override
//    public void filter(
//            ContainerRequestContext requestContext,
//            ContainerResponseContext responseContext
//    ) throws IOException {
//        String origin = requestContext.getHeaderString("Origin");
//
//        log.info(origin);
//
//        if (Objects.nonNull(origin) && allowedOrigins.contains(origin))
//            responseContext.getHeaders().add("Access-Control-Allow-Origin", origin);
//
//        responseContext.getHeaders().add(
//                "Access-Control-Allow-Credentials", "true");
//        responseContext.getHeaders().add(
//                "Access-Control-Allow-Headers",
//                "Origin, Content-Type, Accept, Authorization");
//        responseContext.getHeaders().add(
//                "Access-Control-Allow-Methods",
//                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
//    }
//}
