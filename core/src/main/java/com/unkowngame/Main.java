package com.unkowngame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Main extends ApplicationAdapter {

    ShapeRenderer shapeRenderer; //класс(переменная) для создания банальных фигур

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer(); //создание рендера базовых фигур
    }

    @Override
    public void render() { // ласс рендера
        // Начинаем отрисовку
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);  // Используем заполненный тип для заливки квадрата

        // Рисуем квадрат (x, y - координаты, ширина, высота)
        shapeRenderer.rect(100, 100, 50, 50);

        // Заканчиваем отрисовку
        shapeRenderer.end();
    }

    @Override //велики код
    public void dispose() { // класс для оптимизации(нужно точнее - спрашивать у чат гпт)
        shapeRenderer.dispose();
    }
}
