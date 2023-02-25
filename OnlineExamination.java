import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font.*;
import java.lang.Exception;
import java.util.Timer;
import java.util.TimerTask;

class Login extends JFrame implements ActionListener{
  Container c;
  JLabel l1,l2;
  JTextField t1,t2;
  JButton b1;
Login()
  {
	  Font f=new Font("Arial",Font.BOLD,24);
	  setTitle("Login Form");
	  setDefaultCloseOperation(EXIT_ON_CLOSE); 
      c=getContentPane();
      c.setLayout(null);
	  
	  l1=new JLabel("Username:");
	  l2=new JLabel("Password:");
	  l1.setBounds(250,166,193,52);
	  l1.setFont(f);
	  l2.setBounds(250,286,193,52);
	  l2.setFont(f);
	  c.add(l1);
	  c.add(l2);
	  
	  t1=new JTextField();
	  t1.setBounds(481,170,200,40);
	  t1.setForeground(Color.BLACK);
      t1.setFont(f);
	  c.add(t1);
	  
	  t2=new JPasswordField();
	  t2.setBounds(481,286,200,40);
	  t2.setForeground(Color.BLACK);
	  t2.setFont(f);
	  c.add(t2);
	  
	  b1=new JButton("SUBMIT");
	  b1.setBounds(481,380,140,40);
	  b1.setForeground(Color.PINK);
	  b1.setFont(f);
	  b1.addActionListener(this);
	  c.add(b1);
       
	  setVisible(true);
  }	  
  public void actionPerformed(ActionEvent ae){
    String uservalue=t1.getText();
    String passvalue=t2.getText();
    if(!passvalue.equals("")){
        new OnlineExambegin(uservalue);
    }
            else{
                t2.setText("Enter password");
                actionPerformed(ae);
            }
    
  }
}
class OnlineExambegin extends JFrame implements ActionListener{
  JLabel l;
  JLabel l1;
  JRadioButton jb[] = new JRadioButton[7];
  JButton b1,b2;
  ButtonGroup bg;
  int count=0,current=0,x=1,y=1,now=0;
  int m[]=new int[10];
  Timer timer=new Timer();
  OnlineExambegin(String s){
    super(s);
    l=new JLabel();
    l1=new JLabel();
    add(l);
    add(l1);
    bg=new ButtonGroup();
    for(int i=0;i<5;i++)
    {
        jb[i]=new JRadioButton();
        add(jb[i]);
        bg.add(jb[i]); 
    }
    b1=new JButton("Save and Next");
    b2=new JButton("Save and later");
    b1.addActionListener(this);
    b2.addActionListener(this);
    add(b1);
    add(b2);
    set();
    l.setBounds(30,40,450,20);
    l1.setBounds(20,20,450,20);
    jb[0].setBounds(50,80,100,20);  
    jb[1].setBounds(50,110,100,20);  
    jb[2].setBounds(50,140,100,20);  
    jb[3].setBounds(50,170,100,20);  
    b1.setBounds(95,240,140,30);  
    b2.setBounds(270,240,150,30); 
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    setLayout(null);
    setLocation(250,100);
    setVisible(true);  

    setSize(600,350);
    timer.scheduleAtFixedRate(new TimerTask() {
        int i=600;
        public void run(){
            l1.setText("Time left"+i);
            i--;
            if(i<0){
                timer.cancel();
                l1.setText("Time out");
            }
        }
    },0,1000);
}
public OnlineExambegin() {
}
public void actionPerformed(ActionEvent e){
    if(e.getSource()==b1){
            if(check())
            count=count+1;
            current++;
            set();
            if(current==9){
                b1.setEnabled(false);
                b2.setText("Result");
            }
    }
    if(e.getActionCommand().equals("Save and later")){
        JButton bk=new JButton("Review"+x);
        bk.setBounds(480,20+30*x,100,30);
        add(bk);
        bk.addActionListener(this);
        m[x]=current;
        x++;
        current++;
        set();
        if(current==9)
        b2.setText("Result");
        setVisible(false);
        setVisible(true);
    }
    for(int i=0,y=1;i<x;i++,y++){
        if(e.getActionCommand().equals("Review"+y)){
            if(check())
            count=count+1;
            now=current;
            current=m[y];
            set();
            ((JButton)e.getSource()).setEnabled(false);
            current=now;
        }
    }
    if(e.getActionCommand().equals("Result")){
        if(check())
        count=count+1;
        current++;
        JOptionPane.showMessageDialog(this,"Score"+count);
        System.exit(0);
    }
}
 void set()
  {
    jb[4].setSelected(true);
    if(current==0)
    {
        l.setText("Que1.Who is known as father of java programming language?");
        jb[0].setText("Charles Babbage");
        jb[1].setText("James Gosling");
        jb[2].setText("Bjarne");
        jb[3].setText("Bill Gates");
    }
    if(current==1)
    {
        l.setText("Que2.What is the extension of java source file??");
        jb[0].setText(".java");
        jb[1].setText(".class");
        jb[2].setText("javac");
        jb[3].setText(".javac");
    }
    if(current==2)
    {
        l.setText("Que3.Total number of primitive data types in java are?");
        jb[0].setText("2");
        jb[1].setText("4");
        jb[2].setText("8");
        jb[3].setText("9");
    }
    if(current==3)
    {
        l.setText("Que4.Which of the following is an OOPs concept available in java?");
        jb[0].setText("Pointer");
        jb[1].setText("Multiple Inheritance");
        jb[2].setText("Polymorpism");
        jb[3].setText("None of the above");
    }
    if(current==4)
    {
        l.setText("Que5.Identify the corrected definition of a package.");
        jb[0].setText("A Package is a collection of files of type Java Class, Interfaces, or Abstract Class");
        jb[1].setText("A Package is simply a Directory or Folder with Java Classes");
        jb[2].setText("A Package usually contains Java Classes written for a specific purpose or problem");
        jb[3].setText("All the above");
    }
    if(current==5)
    {
        l.setText("Que6.Which of this keyword is used to define inrefaces in java?");
        jb[0].setText("inte");
        jb[1].setText("interface");
        jb[2].setText("intef");
        jb[3].setText("Interface");
    }
    if(current==6)
    {
        l.setText("Que.7 which of the following is a super class for all exception class in java?");
        jb[0].setText("Object");
        jb[1].setText("Throwable");
        jb[2].setText("ArithmeticException");
        jb[3].setText("Throw");
    }
    if(current==7)
    {
        l.setText("Que.8 Which statement is true about java programming?");
        jb[0].setText("Pure object oriented programming language");
        jb[1].setText("Procedure oriented programming language");
        jb[2].setText("Platform dependent programming language");
        jb[3].setText("Object oriented programming language");
    }
    if(current==8)
    {
        l.setText("Que.9 What is the extension of java class file?");
        jb[0].setText(".class");
        jb[1].setText(".java");
        jb[2].setText(".txt");
        jb[3].setText(".js");
        }
        if(current==9)
        {
            l.setText("Que.10 Which of the following are bitwise operator in java?");
            jb[0].setText("&&");
            jb[1].setText("~");
            jb[2].setText("!");
            jb[3].setText("<");
        }
        l.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++)       
        setBounds(50,80+i,200,20); 
  }
  boolean check(){
    if(current==0)
    return (jb[1].isSelected());
    if(current==1)
    return(jb[0].isSelected());
    if(current==2)
    return(jb[2].isSelected());
    if(current==3)
    return(jb[2].isSelected());
    if(current==4)
    return(jb[3].isSelected());
    if(current==5)
    return(jb[1].isSelected());
    if(current==6)
    return(jb[0].isSelected());
    if(current==7)
    return(jb[0].isSelected());
    if(current==8)
    return(jb[0].isSelected());
    if(current==9)
    return(jb[1].isSelected());
    return false;
  }
}
class OnlineExamination{
  public static void main(String args[]){
    try{
	  Login frame=new Login();
	  frame.getContentPane().setBackground(Color.PINK);
	  frame.pack();//maximized
	  frame.setVisible(true);
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,e.getMessage());
    }
 }
}