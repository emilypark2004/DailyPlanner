package application;

import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomePage extends JFrame implements ActionListener
{
	Container container = getContentPane();
	JButton pomodoroButton = new JButton();
	JButton whiteNoiseButton = new JButton();
	JButton notepadButton = new JButton();
	
	public HomePage()
	{
        this.setTitle("Home Page");
        this.setBounds(300, 60, 700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setResizable(false);
        this.setLayout(null);
        
        Initialize();
        addActionEvent();
	}	
	
	private void Initialize()
	{
		pomodoroButton.setBounds(200, 100, 300, 50);
		whiteNoiseButton.setBounds(200, 200, 300, 50);
		notepadButton.setBounds(200, 300, 300, 50);
		pomodoroButton.setText("Pomodoro Timer");
		whiteNoiseButton.setText("White Noise Player");
		notepadButton.setText("NotePad");
		container.add(pomodoroButton);
		container.add(whiteNoiseButton);
		container.add(notepadButton);
	}

	private void addActionEvent() 
	{
		pomodoroButton.addActionListener(this);
		whiteNoiseButton.addActionListener(this);
		notepadButton.addActionListener(this);
	}


	@Override
    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == pomodoroButton)
		{
			this.setVisible(false);
			PomodoroTimer tm = new PomodoroTimer();
			tm.setVisible(true);
			
		}
		if(e.getSource() == whiteNoiseButton)
		{
			this.setVisible(false);
			WhiteNoise wn = new WhiteNoise();
			wn.setVisible(true);		
		}
		if(e.getSource() == notepadButton)
		{
			this.setVisible(false);
			NotePad np = new NotePad();
			np.setVisible(true);		
		}
	}
}