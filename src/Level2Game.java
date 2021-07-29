import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Level2Game implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton button1;
	JButton button2;
	JButton button3;
	int buttonCount = 1;
    JLabel exp = new JLabel("Memorize where the selected buttons are and click on them");
    JLabel level = new JLabel("Select A Level:");
    public static int score;
    public JLabel scoreCount = new JLabel("Score: ");
    static boolean comp1 = false;
    static boolean comp2 = false;
    static boolean comp3 = false;
   
	Level2Game() {
		this(0);
	}
	
	Level2Game(int count) {
		exp.setFont(new Font("Verdana", 1, 15));
		Dimension size = level.getPreferredSize();
		level.setBounds(300, 500, size.width, size.height);
		frame = new JFrame();
		panel = new JPanel();
		frame.setSize(600, 100);
		panel.add(exp);
		panel.add(level);
		if(comp1==false) {
			button1 = initButton();
			button1.setText("Level 1");
		}
		else {
			
		}
		if(comp2==false) {
			button2 = initButton();
			button2.setText("Level 2");
		}
		else{
			
		}
		if(comp3==false) {
			button3 = initButton();
			button3.setText("Level 3");
		}
		else{
			
		}
		panel.add(scoreCount);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scoreCount.setText("Score: " + String.valueOf(score));
		checkScore();
	}
	
	void checkScore() {
		if (score==3) {
			JOptionPane.showMessageDialog(null, "Congratulations! You have completed the game!\nYour score: " + score);
			System.exit(0);
		}
	}
	
	JButton initButton() {
		JButton button = new JButton();
		button.setLayout(null);
		button.setPreferredSize(new Dimension(80,25));
		button.addActionListener(this);
		panel.add(button);
		
		return button;
			
	}
	
	public static void main(String[] args) {
		Level2Game game = new Level2Game();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//frame.setVisible(false);
		// TODO Auto-generated method stub
		if(((JButton)e.getSource()).getText().equals("Level 1")) {
			Level1 level1 = new Level1();
		}
		else if(((JButton)e.getSource()).getText().equals("Level 2")) {
			Level2 level2 = new Level2();
		}
		else if(((JButton)e.getSource()).getText().equals("Level 3")) {
			Level3 level3 = new Level3();
		}
	}
	
}
