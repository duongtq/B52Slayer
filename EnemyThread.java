package test;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EnemyThread extends Thread {
    public static final int MAX_ENEMIES = 10;

    public int numberOfRockets = 0;

    private HashMap<Integer, Enemy> enemies;
    private Server server;
    private Random randomEngine = new Random();
    // Check if number of enemy is max

    public EnemyThread(Server server, HashMap<Integer, Enemy> enemies) {
        this.server = server;
        this.enemies = enemies;
    }

    public void run() {
        while(true) {
            if (enemies.size() < MAX_ENEMIES) {
                 int randomX = randomEngine.nextInt((740 - 60) + 1) - 60;
                int fixedY = 0;

                numberOfRockets = numberOfRockets + 1;
                Enemy enemy = new Enemy();
                enemies.put(numberOfRockets, enemy);

                // broadcast
                server.broadcast(Message.createNewEnemyMessage(numberOfRockets, randomX, fixedY), null);
            }

            for(Map.Entry enemyEle : enemies.entrySet()) {
                int id = (int) enemyEle.getKey();
                Enemy enemy = (Enemy) enemyEle.getValue();

                if(enemy.posY < 0 || enemy.toRemove)  {
                    enemies.remove(id);
                    // send remove shot message to client
                    String removeEnemyMessage = Message.createRemoveEnemyMessage(id);
                    server.broadcast(removeEnemyMessage, null);
                    continue;
                }
                enemy.update();
                String enemyPosMessage = Message.createEnemyPosMessage(id, enemy.posX, enemy.posY);
                server.broadcast(enemyPosMessage, null);
            }


            try {
                Thread.sleep(5);
            } catch(InterruptedException ex) {
                System.out.println("Error in shot thread!");
                ex.printStackTrace();
            }
        }
    }


}
