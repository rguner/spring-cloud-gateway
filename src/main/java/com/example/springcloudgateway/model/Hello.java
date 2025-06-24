package com.example.springcloudgateway.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Hello {
    private final String title;
    private final String message;
}
