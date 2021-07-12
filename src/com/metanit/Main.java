package com.metanit;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Draw derevo = new Draw();
        derevo.setVisible(true);
    }
}

class Draw extends JFrame{
    public Draw() {
        super("Дерево Пифагора");
        this.setBounds(500, 500, 1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.red);
        drawTree(10, 500, 600, 150, 0, g);
    }

    public void drawTree(int n, int x0, int y0, int a, double alpha, Graphics g)
    {
        double x1, y1, a1;
        x1 = x0 + a*(Math.sin(alpha)); //45
        y1 = y0 - a*(Math.cos(alpha));
        g.drawLine(x0, y0, (int)x1, (int)y1);
        a1 = (a*Math.sqrt(2))/2; // изменить палку
        if(n-- > 0){
            drawTree(n, (int)x1, (int)(y1), (int)a1, alpha + (Math.PI)/4, g); //l
            drawTree(n, (int)x1, (int)(y1), (int)a1, alpha - (Math.PI)/4, g); //p
        }
    }
}
