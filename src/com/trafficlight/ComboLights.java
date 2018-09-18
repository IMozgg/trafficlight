package com.trafficlight;

import java.util.Map;

public interface ComboLights {
    /**
     * Вывод количества источников света
     * @return кол-во источников света
     */
    int getCountLight();

    /**
     * Установка света на определенную позицию
     * @param numPosition - номер позиции от 1 до CountLight
     * @param light - источник света
     */
    void setLight(int numPosition, Light light);

    /**
     * Получить список всех источников света
     * @return возвращает коллекцию Map<номер позиции, источник света>
     */
    Map<Integer, Light> getLights();
}

