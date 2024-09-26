package com.unkowngame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

public class Main extends ApplicationAdapter {

    ShapeRenderer shapeRenderer; //класс(переменная) для создания банальных фигур
    int x, y; // координаты квадрата

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer(); //создание рендера базовых фигур

        //присвоение базовых координат
        x = 100;
        y = 100;
    }

    @Override
    public void render() { // класс рендера
        // очистка экрана
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        controls(); // проверка нажата ли клавиша управления

        // Начинаем отрисовку
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);  // Используем заполненный тип для заливки квадрата

        // Рисуем квадрат (x, y - координаты, ширина, высота)
        shapeRenderer.rect(x, y, 50, 50);

        // Заканчиваем отрисовку
        shapeRenderer.end();
    }

    @Override //велики код
    public void dispose() { // класс для оптимизации(нужно точнее - спрашивать у чат гпт)
        shapeRenderer.dispose();
    }

    public void controls(){ // управление
        float deltaTime = Gdx.graphics.getDeltaTime();

        // Проверяем нажатие W и D для движения по диагонали вверх-вправо
        if (Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.D)) {
            y ++;
            x ++;
        }
        // Проверяем нажатие W и A для движения по диагонали вверх-влево
        else if (Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.A)) {
            y ++;
            x --;
        }
        // Проверяем нажатие S и D для движения по диагонали вниз-вправо
        else if (Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.D)) {
            y --;
            x ++;
        }
        // Проверяем нажатие S и A для движения по диагонали вниз-влево
        else if (Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.A)) {
            y --;
            x --;
        }
        // Движение строго вверх (W)
        else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            y ++;
        }
        // Движение строго вниз (S)
        else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            y --;
        }
        // Движение строго влево (A)
        else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            x --;
        }
        // Движение строго вправо (D)
        else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            x ++;
        }
    }
}
