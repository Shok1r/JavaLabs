/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import java.awt.Color;

/**
 *
 * @author NikitaShokorov
 */
public class Car {
    private int width = 40;
    private int height = 20;
    //Начальное расположение
    private int posX;
    private int posY;
    private Color carColor;
    private int speed;
    private int carNumber;
    
    
    public Car(int posX, int posY, int red, int green, int blue, int speed, int carNumber) {
        this.posX = posX;
        this.posY = posY;
        this.carColor = new Color(red, green, blue);
        this.speed = speed;
        this.carNumber = carNumber;
    }
    
    public void onStart(int startX, int newSpeed) {
        this.posX = startX;
        this.speed = newSpeed;
    }
    
    public void moveCar() {
        this.posX += speed;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Color getCarColor() {
        return carColor;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
}
