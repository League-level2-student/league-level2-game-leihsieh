import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Level1 extends Level2Game {
	ArrayList<JButton> buttons;
	JButton startButton;
	
	Level1() {
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.setColor(Color.white);
				g.fillRect(0, 0, 600, 600);
			}
		};
		frame.remove(this.panel);
		JPanel contPanel = new JPanel();
		startButton = new JButton("<html>Click to<br />start timer</html>");
		startButton.setSize(30, 15);
		startButton.addActionListener(this);
		frame.getContentPane().setPreferredSize(new Dimension(600, 600));
		;

		buttons = new ArrayList<JButton>();
		panel.setLayout(new GridLayout(5, 5));
		for (int i = 0; i < 25; i++) {
			JButton memo = new JButton();
			memo.addActionListener(this);
			buttons.add(memo);
			memo.setPreferredSize(new Dimension(80, 80));
			panel.add(memo);
		}
		frame.add(contPanel);
		contPanel.add(panel);
		contPanel.add(startButton);
		frame.pack();
		frame.revalidate();
		frame.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if (((JButton) e.getSource()).getText().equals("<html>Click to<br />start timer</html>")) {
			buttons.get(0).setBackground(Color.black);
			buttons.get(2).setBackground(Color.black);
			buttons.get(6).setBackground(Color.black);
			buttons.get(9).setBackground(Color.black);
			buttons.get(13).setBackground(Color.black);
			buttons.get(16).setBackground(Color.black);
			buttons.get(20).setBackground(Color.black);
			buttons.get(22).setBackground(Color.black);
			Timer timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {
				int i = 8;
				public void run() {
					((JButton) e.getSource()).setText(String.valueOf(i));
					i--;
					if (i < 0) {
						timer.cancel();
						((JButton) e.getSource()).setText("");
						for(int o = 0; o < 25; o++) {
							buttons.get(o).setBackground(null);
						}
					}
				}
			}, 0, 1000);
			
		}
		else if(e.getSource()==buttons.get(0)||e.getSource()==buttons.get(2)||e.getSource()==buttons.get(6)||e.getSource()==buttons.get(9)||e.getSource()==buttons.get(13)||
				e.getSource()==buttons.get(16)||e.getSource()==buttons.get(20)||e.getSource()==buttons.get(22)) {
				((JButton) e.getSource()).setBackground(Color.black);
				checkMem();
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Wrong!");
			frame.setVisible(false);
			Level2Game l2g = new Level2Game();
		}
	}
	public void checkMem() {
		if(buttons.get(0).getBackground().equals(Color.black) && buttons.get(2).getBackground().equals(Color.black) &&
			buttons.get(6).getBackground().equals(Color.black) && buttons.get(9).getBackground().equals(Color.black) &&
			buttons.get(13).getBackground().equals(Color.black) && buttons.get(16).getBackground().equals(Color.black) &&
			buttons.get(20).getBackground().equals(Color.black) && buttons.get(22).getBackground().equals(Color.black)) {	
				JOptionPane.showMessageDialog(null, "Well Done! You have completed Level 1!");
				frame.setVisible(false);
				comp1=true;
				this.score++;
				Level2Game scoreChange = new Level2Game(this.score);
				scoreChange.frame.repaint();
				
			}
	}
}
