package com.app.mythreetier.domain.post;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TestDTO {
    private String name;
    private String[] tests;
}
