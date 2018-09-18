package com.trafficlight;

public interface ProcessProgram {
    /**
     * Запустить работу программы
     */
    void run();

    /**
     * Ввести данные
     * @return результат ввода пользователя
     */
    long inputData();

    /**
     * Установить связь с устройством
     * @param controller связь проводится с контроллером связи устройства
     */
    void setController(ControllerLight controller);

    /**
     * Инициализация процесса перед запуском
     */
    void init();
}
