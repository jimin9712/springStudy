package com.app.dependency.injection;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class Food {

    private final Knife knife;
}
