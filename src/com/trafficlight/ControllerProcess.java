package com.trafficlight;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//  Контроллер, который управляет всем процессом работы светофора

/**
 * ВАЖНО! Этот контроллер выполняет конкретную задачу
 * поэтому все параметры жестко связанны между собой
 * <p>
 * Модель светофора имеет слабые связи, что дает гибкость развития ПО:
 * - возможность добавить, изменить, доработать любой компонент программы не затрагивая основной код
 * работа со светом, цветами, комбинациями источников света, управление светом и т.д.
 * - Возможность написать мини программы для управления источниками света через логические контроллеры
 */
public class ControllerProcess implements ProcessProgram {
    private ControllerLight cl;
    private long tableTime[];

    public ControllerProcess() {
        this(null);
    }

    //  Главный конструктор
    public ControllerProcess(ControllerLight cl) {
        this.cl = cl;
        this.init();
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 4) {
            this.cl.start();
            i++;
        }
    }

    @Override
    public long inputData() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String answer;
            answer = sc.nextLine();

            //  Проверяем что пользователь ввел что-нибудь
            if (answer.length() > 0) {
                return Long.parseLong(answer);
            } else {
                System.err.println("Вы ничего не ввели.\nПопробуйте еще раз");
            }
        }
    }

    @Override
    public void setController(ControllerLight controller) {
        this.cl = controller;
    }

    @Override
    public void init() {
        //  Создаем массив с 3 данными по времени
        this.tableTime = new long[3];

        //  Заносим их в таблицу
        System.out.print("Введите время задержки красного цвета: ");
        this.tableTime[0] = this.inputData();
        System.out.print("Введите время задержки оранжевого цвета: ");
        this.tableTime[1] = this.inputData();
        System.out.print("Введите время задержки зеленого цвета: ");
        this.tableTime[2] = this.inputData();

        //  Создаем объект светофор
        Map<Integer, Light> listLight = new HashMap<>(3);
        listLight.put(1, new Lamp(Color.RED));
        listLight.put(2, new Lamp(Color.ORANGE));
        listLight.put(3, new Lamp(Color.GREEN));
        ComboLights comboLights = new LightShell(listLight);
        this.cl = new LogicalController(comboLights);
        ((LogicalController) this.cl).setTableTime(this.tableTime);

        System.out.println("Готово...");
    }
}
