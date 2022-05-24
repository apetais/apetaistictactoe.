package view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import control.GameController;
import model.Player;
public class TopPanel extends GamePanel{
	JButton quitBtn;
	JButton startGameBtn;
	JButton doneBtn;
	JButton addBtn;
	Player player;
	
	
public TopPanel (GameController gc) {
	super(gc);
	this.setLayout(new FlowLayout(FlowLayout.CENTER));
	this.setPreferredSize(new Dimension(MainWindow.WIDTH,MainWindow.TOP_HEIGHT));
	this.setBorder(new LineBorder(Color.GRAY,1,true));
	quitBtn = new JButton("Quit App"); 
	quitBtn.setPreferredSize(new Dimension(100,40));
	quitBtn.addActionListener((e)->{
		System.out.println("Good Bye...");
		System.exit(ABORT);
	});
	
	startGameBtn = new JButton("Start Game");
	startGameBtn.setPreferredSize(new Dimension(100,40));
	startGameBtn.setEnabled(false);
	startGameBtn.addActionListener((e)->{this.gc.startGame();});
	
	doneBtn = new JButton("Done");
	doneBtn.setPreferredSize(new Dimension(100,40));
	doneBtn.setEnabled(false);
	
	addBtn = new JButton("Add Player");
	addBtn.setPreferredSize(new Dimension(100,40));
	addBtn.setEnabled(true);
	addBtn.addActionListener((e)->{this.askToAddPlayer();});
	
	add(startGameBtn);
	add(doneBtn);
	add(quitBtn);
	add(addBtn);
	
}
public void askToAddPlayer() {	
	Component frame = null;
	String s = (String)JOptionPane.showInputDialog(frame,"Add player's name:\n" );
	addPlayer(s);
}


public void addPlayer(String s) {
	int numOfPls;
	numOfPls = gc.getModel().getPlayerCatalogue().getNumOfPls();
	if(gc.getModel().getPlayerCatalogue().findPlayer(s) !=null) {
		JOptionPane.showMessageDialog(gc.getView(),"This player has already been added", "Ooopsss....", JOptionPane.ERROR_MESSAGE);
	}
	else {
		gc.getModel().getPlayerCatalogue().getListOfPlayers()[numOfPls] = new Player(s,null);
		numOfPls++;
	}
}
public JButton getAddBtn() {
	return addBtn;
}
public void setAddBtn(JButton addBtn) {
	this.addBtn = addBtn;
}
public JButton getQuitBtn() {
	return quitBtn;
}
public JButton getStartGameBtn() {
	return startGameBtn;
}
public JButton getDoneBtn() {
	return doneBtn;
}


}