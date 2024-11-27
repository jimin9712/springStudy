package com.app.dependency.qualifier;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("desktop")
//@Primary
@ToString
public class Desktop implements Computer{
    private int screenSize = 2000;

    @Override
    public int getScreenSize() {
        return screenSize;
    }
}
