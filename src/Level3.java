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

public class Level3 extends Level2Game {
	ArrayList<JButton> buttons;
	JButton startButton;
	Level3() {
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.setColor(Color.white);
				g.fillRect(0, 0, 700, 700);
			}
		};
		frame.remove(this.panel);
		JPanel contPanel = new JPanel();
		startButton = new JButton("<html>Click to<br />start timer</html>");
		startButton.setSize(30, 15);
		startButton.addActionListener(this);
		frame.getContentPane().setPreferredSize(new Dimension(700, 700));
		;

		buttons = new ArrayList<JButton>();
		panel.setLayout(new GridLayout(7,7));
		for (int i = 0; i < 49; i++) {
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
			buttons.get(1).setBackground(Color.black);
			buttons.get(4).setBackground(Color.black);
			buttons.get(9).setBackground(Color.black);
			buttons.get(12).setBackground(Color.black);
			buttons.get(15).setBackground(Color.black);
			buttons.get(20).setBackground(Color.black);
			buttons.get(22).setBackground(Color.black);
			buttons.get(35).setBackground(Color.black);
			buttons.get(37).setBackground(Color.black);
			buttons.get(40).setBackground(Color.black);
			buttons.get(41).setBackground(Color.black);
			buttons.get(43).setBackground(Color.black);
			buttons.get(47).setBackground(Color.black);
			Timer timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {
				int i = 8;
				public void run() {
					((JButton) e.getSource()).setText(String.valueOf(i));
					i--;
					if (i < 0) {
						timer.cancel();
						((JButton) e.getSource()).setText("");
						for(int o = 0; o < 49; o++) {
							buttons.get(o).setBackground(null);
						}
					}
				}
			}, 0, 1000);
			
		}
		else if(e.getSource()==buttons.get(0)||e.getSource()==buttons.get(1)||e.getSource()==buttons.get(4)||e.getSource()==buttons.get(9)||e.getSource()==buttons.get(12)||
				e.getSource()==buttons.get(15)||e.getSource()==buttons.get(20)||e.getSource()==buttons.get(22)||e.getSource()==buttons.get(35)||e.getSource()==buttons.get(37)||
				e.getSource()==buttons.get(40)||e.getSource()==buttons.get(41)||e.getSource()==buttons.get(43)||e.getSource()==buttons.get(47)) {
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
		if(buttons.get(0).getBackground().equals(Color.black) && buttons.get(1).getBackground().equals(Color.black) &&
			buttons.get(4).getBackground().equals(Color.black) && buttons.get(9).getBackground().equals(Color.black) &&
			buttons.get(12).getBackground().equals(Color.black) && buttons.get(15).getBackground().equals(Color.black) &&
			buttons.get(20).getBackground().equals(Color.black) && buttons.get(22).getBackground().equals(Color.black) &&
			buttons.get(35).getBackground().equals(Color.black) && buttons.get(37).getBackground().equals(Color.black) &&
			buttons.get(40).getBackground().equals(Color.black) && buttons.get(41).getBackground().equals(Color.black) &&
			buttons.get(43).getBackground().equals(Color.black) && buttons.get(47).getBackground().equals(Color.black)) {	
				JOptionPane.showMessageDialog(null, "Wow! You have completed Level 3!");
				frame.setVisible(false);
				comp3=true;
				this.score++;
				Level2Game scoreChange = new Level2Game(this.score);
				scoreChange.frame.repaint();
			}
	}
}
