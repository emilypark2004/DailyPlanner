package application;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WhiteNoise extends JFrame implements ActionListener{

	Container container = getContentPane();
	
	JButton playButton = new JButton("Play White Noise");
	JButton backButton = new JButton("Back to Home Page");
	
	public WhiteNoise()
	{
        this.setTitle("White Noise Player");
        this.setBounds(300, 60, 700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setResizable(false);
        this.setLayout(null);
        
        Initialize();
        addActionEvent();
	}
	
	private void Initialize() {
		// TODO Auto-generated method stub	

		playButton.setBounds(250, 100, 200, 80);
		playButton.setBorderPainted(false);
		playButton.setBackground(new Color(159,89,155));
		playButton.setForeground(Color.WHITE);
		playButton.setFont(new Font("San Francisco", Font.BOLD, 15));
		container.add(playButton);
		
		backButton.setBounds(250, 300, 200, 80);
		backButton.setBorderPainted(false);
		backButton.setBackground(new Color(159,89,155));
		backButton.setForeground(Color.WHITE);
		backButton.setFont(new Font("San Francisco", Font.BOLD, 15));
		container.add(backButton);
	}

	private void addActionEvent()
	{
		// TODO Auto-generated method stub
		playButton.addActionListener(this);
		backButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == playButton)
		{
		try {
			File musicPath = new File("01-White-Noise-10min.wav");
			
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInput);
			clip.start();
	
			JOptionPane.showMessageDialog(null, "Press OK to pause");
			long clipTimePosition = clip.getMicrosecondPosition();
			clip.stop();
			
			JOptionPane.showMessageDialog(null, "Press OK to resume");
			clip.setMicrosecondPosition(clipTimePosition);
			clip.start();
			
			JOptionPane.showMessageDialog(null, "Press OK to pause");
			clip.stop();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	        
		}
		
		
		if(e.getSource() == backButton)
		{
			this.setVisible(false);
			HomePage homePage = new HomePage();
			homePage.setVisible(true);
		}
	}
}
