import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.net.URL;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MoveMap extends JPanel{
	int x,y;
	int x1=100, y1=200;
	boolean flag=false;
	JPanel mainP, propertiesP;

	JLabel l;
	JFrame fr;
	//координаты х двух частей карты
	int layer1=0, layer2=400;
	int var1=-2;
	int var2=+2;


	public static void main(String[] args) {
		MoveMap mh=new MoveMap();
	}

	MoveMap(){

		 fr= new JFrame("Бродилка");
		 fr.setSize(400,500);
		 fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	     fr.setVisible(true);
		 fr.setLocationRelativeTo(null);
		 //fr.setResizable(false);

		  	// Задаём схему для главной панели
	 mainP=new JPanel();
	 BorderLayout bl = new BorderLayout();
	 mainP.setLayout(bl);

	    //создаем объект-панель и кладем ее на фрейм
	    //MoveHero ff= new MoveHero();
	 	propertiesP=new JPanel();
	 	l=new JLabel("Здесь будет информация о ходе игры");
	 	propertiesP.add(l);
	    mainP.add("Center",this);
	    mainP.add("South",propertiesP);

	    fr.add(mainP);

		addKeyListener(new MoveIt());
	}

	public void paintComponent(Graphics g){
		//загружаем изображение карты
		ImageIcon imap = new ImageIcon(getClass().getResource("img1/map.jpg"));
        Image map = imap.getImage();
        //рисуем изображение
        g.drawImage(map,layer1,0,500,500, null);
        g.drawImage(map,layer2,0,500,500, null);

		        //загружаем изображение персонажа
		        ImageIcon icon = new ImageIcon(getClass().getResource("img1/bulldog.png"));
		        Image image = icon.getImage();
		        //рисуем изображение
		        g.drawImage(image,x,y,50,50, null);

		        // Установить фокус, чтобы обработчик клавиатуры мог посылать команды объектам
		    requestFocus();
		    this.updateUI();
		    }


	//добавляем класс-слушатель клавиатуры
    class MoveIt implements KeyListener{

      public void keyPressed(KeyEvent event){
    	  //вызываем метод сдвига карты
    	  //moveMap();

      switch (event.getKeyCode()) {
              case KeyEvent.VK_LEFT:
            	  moveMapLeft();
          break;
          case KeyEvent.VK_RIGHT:
               moveMapRight();
          break;
          case KeyEvent.VK_UP:
            y--;
          break;
          case KeyEvent.VK_DOWN:
            y++;
          break;
      }
      //после обработки нажвтия клавиши перерисовываем изображение
      repaint();
      };

      //эти методы мы не используем, но их все равно надо написать
      public void keyReleased(KeyEvent event){}
      public void keyTyped(KeyEvent event){}
}
    public void moveMapRight(){
    	layer1=-3;
  	  layer2=-3;
  x++;
    }
    public void moveMapLeft(){
    	layer1=+3;
    	  layer2=+3;
    x--;
    }
}

    




