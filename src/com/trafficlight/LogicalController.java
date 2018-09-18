package com.trafficlight;

import java.awt.*;

/**
 * Этот контроллер может включать и выключать устройства на определенное время
 */
public class LogicalController implements ControllerLight {
    private ComboLights shell;

    //  Номера устройств считаются с 0 до кол-во устройств
    private int targetLamp;

    //  Таблица соответствий временных задержек
    private long tableTime[];

    //  Главный конструктор
    public LogicalController(ComboLights shell) {
        if (shell != null) {
            this.shell = shell;
            this.tableTime = new long[shell.getCountLight()];
        } else {
            System.err.println("Нет устройства для управления");
        }
    }

    @Override
    public ComboLights getShell() {
        return this.shell;
    }

    @Override
    public void setShell(ComboLights shell) {
        this.shell = shell;
    }

    @Override
    public Light next() {
        Light targetLight;

        if (this.targetLamp >= shell.getCountLight()) {
            targetLamp = 1;
        } else {
            targetLamp++;
        }
        targetLight = shell.getLights().get(this.targetLamp);

        return targetLight;
    }

    @Override
    public void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //  Основная программа, что делать с устройствами контроллеру
    //  мы задаем включать каждый раз следующее устройство на время заданное таблицей а после выключать
    @Override
    public void start() {
        long curMillis = System.currentTimeMillis();
        Light currentLight = this.next();
        currentLight.onOff();
        System.out.println("-----------");
        drawTrafficLight();
        System.out.println("-----------");
        System.out.println();
        this.delay(tableTime[targetLamp <= 0 ? 0 : targetLamp - 1]);
        currentLight.onOff();
        System.out.println("-----------");
        drawTrafficLight();
        System.out.println("-----------");
        System.out.println("Время горения: " + (System.currentTimeMillis() - curMillis));
        System.out.println();
    }

    public void setTableTime(long[] tableTime) {
        this.tableTime = tableTime;
    }

    public void drawTrafficLight() {
        String color;

        for (int i = 0; i < shell.getCountLight(); i++) {
            if (shell.getLights().get(i + 1).getColor() == Color.RED) {
                color = "КРАСНЫЙ";
            } else if (shell.getLights().get(i + 1).getColor() == Color.ORANGE){
                color = "ОРАНЖЕВЫЙ";
            } else {
                color = "ЗЕЛЕНЫЙ";
            }
            System.out.println(color + ":\t" + shell.getLights().get(i + 1).getStatus());
        }
    }
}
