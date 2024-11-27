package com.app.dependency.qualifier.task;

import lombok.ToString;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@ToString
public class Outback implements Resturant{
    private int SteakPrice = Resturant.SteakPrice - 10000;
    private boolean Selfbar = true;


    @Override
    public boolean Selfbar() {
        return Selfbar;
    }
}
