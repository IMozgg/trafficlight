package com.trafficlight;

import java.util.HashMap;
import java.util.Map;

public class LightShell implements ComboLights {
    /*
        cells по сути это шаблон ячеек,
        можно создать отдельный класс шаблонов
        (светофоры бывают разными и можно комбинировать разные варианты расположения света)
        Это упрощенный вариант, когда мы заранее указываем шаблон.
    */
    private Map<Integer, Light> cells;
    private String name;
    private String status;
    private final int DEFAULT_LIGHT_NUM = 3;

    //  Пустой конструктор
    public LightShell() {
        this(null,"стандартный", "исправен" );
    }

    //  Конструктор с одним параметром - cells
    public LightShell(Map<Integer, Light> cells) {
        this(cells, "кастомный", "исправен");
    }

    //  Главный конструктор
    public LightShell(Map<Integer, Light> cells, String name, String status) {
        this.cells = cells == null ? initCells(DEFAULT_LIGHT_NUM) : cells;
        this.name = name;
        this.status = status;
    }

    @Override
    public int getCountLight() {
        return this.cells.keySet().size();
    }

    @Override
    public void setLight(int numPosition, Light light) {
        if (this.cells.keySet().size() >= numPosition) {
            if (this.cells.get(numPosition) == null) {
                this.cells.put(numPosition, light);
            } else {
                System.err.println("Свет уже есть");
            }
        } else {
            System.err.println("Такой позиции не существует");
        }
    }

    @Override
    public Map<Integer, Light> getLights() {
        return this.cells;
    }

    //  Метод для создания шаблона для источников света
    private Map<Integer, Light> initCells(int cellsCount) {
        Map<Integer, Light> tempCells = new HashMap<>(cellsCount);
        for (int i = 0; i < cellsCount; i++) {
            tempCells.put(i + 1, null);
        }

        return tempCells;
    }
}
