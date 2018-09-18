package com.trafficlight;

import java.awt.*;

/**
 * Интерфейс для работы со светом
 */
public interface Light {
    /**
     * Метод включающий и выключающий свет
     */
    void onOff();


    /**
     * Метод позволяющий получить текущее состояние света
     */
    boolean getStatus();

    /**
     * Метод для получения цвета свечения
     * @return возвращает цвет Color свечения
     */

    Color getColor();

    /**
     * Метод установки цвета света
     */
    void setColor(Color colorLight);
}
