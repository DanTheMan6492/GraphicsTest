package General;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Geometry.Matrix44;
import Geometry.Vector3D;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener{


    public static void main(String[] args) {
        //new Frame();
    	Vector3D v = new Vector3D(0, 1, 2);
    	System.out.println(v);
    	Matrix44 a = new Matrix44();
    	Matrix44 b = new Matrix44();
    	Matrix44 c = a.multiply(b);
    	Matrix44 d = new Matrix44(0.707107f, 0f, -0.707107f, 0f, -0.331295f, 0.883452f, -0.331295f, 0f, 0.624695f, 0.468521f, 0.624695f, 0f, 4.000574f, 3.00043f, 4.000574f, 1f); 
        System.out.println(d);
        System.out.println(d.inverse());
    }

    public void paint(Graphics g){
        super.paintComponent(g);
		
		
    }

    public Frame() {
		JFrame f = new JFrame("GraphicsTest");
		f.setSize(new Dimension(800, 830));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

    @Override
	public void mouseClicked(MouseEvent arg0) {
	
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) { 
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}