import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Transfer extends JFrame implements ActionListener {
    JLabel label;
    JLabel num;
    JLabel l;
    JTextField input = new JTextField("9487");//輸入文字
    int num1 = 9487;
    //監聽
    public static int classify(String name)throws Exception{//分類
        int result = 0;
        if((name.charAt(0)>='A' )&& (name.charAt(0)<='Z')){
            result = (name.charAt(0)-'A');
        }else if((name.charAt(0)>='a') &&( name.charAt(0)<='z')){
            result = (name.charAt(0)-'a');
        }else{
            throw new Exception();
        }
        return result;
    }
    public static String toString(int val, int b){
        String y = "";
        if(val == 0)
            y = "0";         
        while (val != 0){                                   
            if(val % b == 10){
                y = "A" + y ;
            }
            if(val % b == 11){
                y = "B" + y;
            }
            else if(val % b == 12){
                y ="C" + y ;
            }
            else if(val % b == 13){
                y ="D" + y;
            }
            else if(val % b == 14){
                y = "E"+ y;
            }
            else if(val % b == 15){
                y = "F" + y;
            } else {
                y = val % b + y;
               
            }
			 val = val / b;
        }       
        return y;
    }
    public void actionPerformed(ActionEvent e){       
        String command = e.getActionCommand();
        if(command.equals("2進位")){
            String x = (toString(num1, 2));
            l.setText(x);   
        }else if(command.equals("4進位")){
            String x = (toString(num1, 4));
            l.setText(x);   
        }else if(command.equals("8進位")){
            String x = (toString(num1, 8));
            l.setText(x);   
        }else if(command.equals("16進位")){
            String x = (toString(num1, 16));
            l.setText(x);   
        }else{
            try{ 
                if(num1 > 0){            
                l.setText("?");
                num1 = Integer.parseInt(command);                
                num.setText(Integer.toString(num1));
                }else{
                    JOptionPane.showMessageDialog(null, "負數");
                }
            }catch(Exception err){            
                JOptionPane.showMessageDialog(null, "請輸入>=0的整數");
            }finally{
                input.setText("");
            }
        }
    }        
    public Transfer(){
        this.setTitle("BaseTransfer");
        this.setSize(600,300);
        this.setLayout(new GridLayout(2,5));
        num = new JLabel("9487", JLabel.CENTER);
        label = new JLabel("=>", JLabel.CENTER);
        l = new JLabel("?", JLabel.CENTER);
        //2進位
        JButton plus2 = new JButton("2進位");
        plus2.addActionListener(this);
        //4進位
        JButton plus4 = new JButton("4進位");
        plus4.addActionListener(this);
        //8進位
        JButton plus8 = new JButton("8進位");
        plus8.addActionListener(this);
        //16進位
        JButton plus16 = new JButton("16進位");
        plus16.addActionListener(this);
        //輸入文字
        input.addActionListener(this);
        this.add(new JLabel(""));
        this.add(num);
        this.add(label);
        this.add(l);
        this.add(new JLabel(""));
        this.add(plus2);
        this.add(plus4);
        this.add(plus8);
        this.add(plus16);
        this.add(input);
        this.setVisible(true); // 顯示標籤
        this.setLocationRelativeTo(null); // 視窗置中
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
    }    
    public static void main(String[] argc){
        new Transfer();
    }    
}