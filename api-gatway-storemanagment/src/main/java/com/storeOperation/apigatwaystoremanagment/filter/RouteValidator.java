package com.storeOperation.apigatwaystoremanagment.filter;

import org.springframework.stereotype.Component;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.*;
import java.util.function.Predicate;

@Component
public class RouteValidator {
	
	public static final List<String> openApiEndpoints = List.of(
            "api/auth/register",
            "api/auth/login",
            "/eureka",
            "api/auth/getAllStores"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}
