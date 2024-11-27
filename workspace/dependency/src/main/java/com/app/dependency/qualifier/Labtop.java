package com.app.dependency.qualifier;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("labtop")
@ToString
public class Labtop implements Computer{
    private int screenSize = 1280;

    @Override
    public int getScreenSize() {
        return screenSize;
    }
}
