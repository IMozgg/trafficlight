package com.trafficlight;

public interface ControllerLight {
    /**
     *  Получить сведения об оболочке
     * @return
     */
    ComboLights getShell();

    /**
     * Установить оболочку
     * @param shell какой либо контроллер
     */
    void setShell(ComboLights shell);

    /**
     * Следующее устройство
     * @return показывает следующий активный элемент
     */
    Light next();

    /**
     * Задержка
     * @param millis - задержка перед выполнением операции
     */
    void delay(long millis);

    /**
     * Запуск минимпрограммы на активном элементе
     */
    void start();
}
