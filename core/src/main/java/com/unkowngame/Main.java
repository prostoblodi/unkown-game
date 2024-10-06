package com.unkowngame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class Main extends ApplicationAdapter {

    ShapeRenderer shapeRenderer; // класс(переменная) для создания банальных фигур
    OrthographicCamera camera; // камера
    Random random = new Random();
    Rectangle spawnRadius = new Rectangle(0,0,200,200);

    int x, y; // координаты квадрата
    float randomX, randomY;

    Player player = new Player(); // добавление игрока

    static ArrayList<Bullet> bullets = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();

    @Override
    public void create() { // класс, который срабатывает при старте игры только один раз
        shapeRenderer = new ShapeRenderer(); //создание рендера базовых фигур

        // Инициализируем камеру
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(x, y, 0);  // Устанавливаем позицию камеры на начальное положение квадрата
        camera.update();

        //присвоение базовых координат
        x = 0;
        y = 0;

        Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Crosshair); // курсор другой
        createEnemies();
    }

    @Override
    public void render() { // класс, который обновляется каждый кадр
        float deltaTime = Gdx.graphics.getDeltaTime();

        Gdx.gl.glClearColor(0, 0, 0, 1); // цвет, которым будет очищатся экран
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // очистка экрана

        player.update(camera, deltaTime); // обновление игрока

        bulletAndEnemyUpdate();

        // Начинаем отрисовку
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);  // Используем заполненный тип для заливки квадрата
        player.draw(camera, shapeRenderer); // отрисовка игрока
        shapeRenderer.end();
        // Заканчиваем отрисовку
    }

    public void bulletAndEnemyUpdate(){
        if (!bullets.isEmpty()) {
            for (Bullet bullet : new ArrayList<>(bullets)) {

                bullet.update(shapeRenderer, player); // обновление пули

                for(Enemy enemy : new ArrayList<>(enemies)) {
                    if(enemy.hitbox.overlaps(bullet.hitbox) && enemy.isActive && bullet.isActive){
                        bullet.isActive = false;
                        enemy.isActive = false;
                        System.out.println("^-> Enemy " + enemy + " killed by bullet " + bullet);
                    } // Проврека на столкновение
                } // перебор всех врагов

                if(!bullet.isActive){
                    bullets.remove(bullet);
                } // удаление пули, если неактивна
            } // перебор всех пуль
        } // если пули есть
        for(Enemy enemy : new ArrayList<>(enemies)) {

            if(!enemy.isActive){
                enemies.remove(enemy);
            } // если враг не активен - удаление

            enemy.draw(shapeRenderer); // отрисовка
        } // перебор врагов
    }

    public static void createBullet(float speedX, float speedY, float startX, float startY){
        bullets.add(new Bullet(speedX, speedY, startX, startY));
    } // создание пули

    public void createEnemies(){
        for(int i = 0; i<10; i++){
            randomX = random.nextInt(-300, 300);
            randomY = random.nextInt(-300, 300);
            // рандом координаты от -300 до 300

            enemies.add(new Enemy(randomX, randomY));
            System.out.printf("-> New enemy! x: %f y: %f \n", randomX, randomY);
            // добавление врага

            for(Enemy enemy : new ArrayList<>(enemies)) {
                if(enemy.hitbox.overlaps(spawnRadius)){
                    System.out.println("!-> Oops! Enemy " + enemy + " is bad! Removing...");
                    enemies.remove(enemy);
                    i--;
                } // если враг заспавнился слишком близко к игроку - удаление, и повторение цикла на один раз больше
            } // перебор всех врагов
        } // повторить 10 раз
        System.out.println("------------------------------");
    } // генерация врагов

    @Override // хз, лучше не трогать
    public void dispose() { // класс для оптимизации(нужно точнее - спрашивать у чат гпт)
        shapeRenderer.dispose();
    }

}
