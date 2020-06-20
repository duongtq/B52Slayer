package test;

public class Enemy {
    public boolean toRemove;

    int posX, posY, speed = 1;

    public Enemy(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public Enemy() {

    }

    public void update() {
        posY-=speed;
    }
}
