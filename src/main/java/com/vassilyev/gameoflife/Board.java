package com.vassilyev.gameoflife;

import java.util.Arrays;

public class Board {

    int width;
    int height;

    private int[][] temp;
    private int[][] gameField;


    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.temp = new int[width][height];
        this.gameField = new int[width][height];
    }

    public void step() {
        boolean isAlive;
        boolean keepAlive;
        boolean makeNewLive;
        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                int neighbours = 0;
                isAlive = gameField[i][j] == 1;
                neighbours = (
                        gameField[i - 1][j - 1] + gameField[i - 1][j] + gameField[i - 1][j + 1]
                                + gameField[i][j - 1] + gameField[i][j + 1]
                                + gameField[i + 1][j - 1] + gameField[i + 1][j] + gameField[i + 1][j + 1]
                );
                //System.out.println("точка с коррдинатами i,j = " + i + "," + j + " имеет соседей: " + neighbours);
                keepAlive = isAlive && (neighbours == 2 || neighbours == 3);
                makeNewLive = !isAlive && neighbours == 3;
                temp[i][j] = (keepAlive || makeNewLive) ? 1 : 0;
            }
        }
        for (int i = 1; i < width - 1; i++)
            for (int j = 1; j < height - 1; j++)
                // второй проход: копируем вычисленное состояние в текущее
                gameField[i][j] = temp[i][j];
    }

    @Override
    public String toString() {
        return Arrays.deepToString(gameField).replace("], ", "]\n");
    }

    public void set(int i, int j, boolean value) {
        gameField[i][j] = value ? 1 : 0;
    }

    public int get(int i, int j) {
        return gameField[i][j];
    }

    public void clear() {
        this.gameField = new int[width][height];
        this.temp = new int[width][height];
    }


}
