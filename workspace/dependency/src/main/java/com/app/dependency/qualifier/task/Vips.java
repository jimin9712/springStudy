package com.app.dependency.qualifier.task;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("vips")
@ToString
public class Vips implements Resturant{
    private int SteakPrice = Resturant.SteakPrice + 10000;
    private boolean Selfbar = false;

    @Override
    public boolean Selfbar() {
        return Selfbar;
    }
}
