package com.trafficlight;

import java.awt.*;

public class Lamp implements Light {
    private boolean status;
    private Color colorLight;

    //  Вариант пустого конструктора (значения по умолчанию)
    public Lamp() {
        this(false, Color.WHITE);
    }

    //  Вариант когда задаем по умолчанию цвет
    public Lamp(boolean status) {
        this(status, Color.WHITE);
    }

    //  Вариант когда по умолчанию задаем статус
    public Lamp(Color colorLight) {
        this(false, colorLight);
    }

    //  Главный конструктор
    public Lamp(boolean status, Color colorLight) {
        this.status = status;
        if (colorLight != null) {
            this.colorLight = colorLight;
        } else {
            System.err.println("Не задан цвет");
        }
    }

    @Override
    public void onOff() {
        status = !status;
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public Color getColor() {
        return colorLight;
    }

    @Override
    public void setColor(Color colorLight) {
        if (colorLight != null) {
            this.colorLight = colorLight;
        }
    }
}
