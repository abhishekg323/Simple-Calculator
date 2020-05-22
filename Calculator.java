import java.awt.*;
import java.awt.event.*;
public class Calculator extends Frame{
    double n1=0;
    char op;
    Font font=new Font("Consolas",Font.BOLD,50);
    Font font2=new Font("Consolas",Font.BOLD,30);
    Label l=new Label("");
    Label l2=new Label("");
    Panel b[]=new Panel[20];
    class Action extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            Label o=(Label)e.getSource();
            if(o.getText().equals("X")){
                String str=l.getText();
                if(str.length()!=0){
                    l.setText(str.substring(0, str.length()-1));
                }
            }
            else if(o.getText().equals("C")){
                l.setText("");
            }
            else if(o.getText().equals("7")){
                l.setText(l.getText()+"7");
            }
            else if(o.getText().equals("8")){
                l.setText(l.getText()+"8");
            }
            else if(o.getText().equals("9")){
                l.setText(l.getText()+"9");
            }
            else if(o.getText().equals("4")){
                l.setText(l.getText()+"4");
            }
            else if(o.getText().equals("5")){
                l.setText(l.getText()+"5");
            }
            else if(o.getText().equals("6")){
                l.setText(l.getText()+"6");
            }
            else if(o.getText().equals("1")){
                l.setText(l.getText()+"1");
            }
            else if(o.getText().equals("2")){
                l.setText(l.getText()+"2");
            }
            else if(o.getText().equals("3")){
                l.setText(l.getText()+"3");
            }
            else if(o.getText().equals("0")){
                l.setText(l.getText()+"0");
            }
            else if(o.getText().equals("00")){
                l.setText(l.getText()+"00");
            }
            else if(o.getText().equals(".")){
                l.setText(l.getText()+".");
            }
            else if(o.getText().equals("+")||o.getText().equals("-")||o.getText().equals("/")||o.getText().equals("*")){
                if(n1==0){
                    n1=Double.parseDouble(l.getText());
                    op=o.getText().charAt(0);
                    l.setText("");
                    l2.setText(String.valueOf(n1)+String.valueOf(op));
                }
                else{
                    char ch=o.getText().charAt(0);
                    switch (op) {
                        case '+': n1+=Double.parseDouble(l.getText());
                            op=ch;
                            break;
                        case '-': n1-=Double.parseDouble(l.getText());
                            op=ch;
                            break;
                        case '/': n1/=Double.parseDouble(l.getText());
                            op=ch;
                            break;
                        case '*': n1*=Double.parseDouble(l.getText());
                            op=ch;
                            break;
                    }
                    l2.setText(String.valueOf(n1)+String.valueOf(op));
                    l.setText("");
                }
            }
            else if(o.getText().equals("=")){
                if(n1!=0){
                    switch (op) {
                        case '+': n1+=Double.parseDouble(l.getText());
                            break;
                        case '-': n1-=Double.parseDouble(l.getText());
                            break;
                        case '/': n1/=Double.parseDouble(l.getText());
                            break;
                        case '*': n1*=Double.parseDouble(l.getText());
                            break;
                    }
                    l2.setText("");
                    l.setText(String.valueOf(n1));
                    n1=0;
                }
            }
        }
    }
    Action action=new Action();
    class Btn extends Panel{
        Btn(){
           String s[]={"X","C"," ","/","7","8","9","*","4","5","6","-","1","2","3","+","0","00",".","="};
           for (int i = 0; i < b.length; i++) {
                b[i]=new Panel();
                Label tmp=new Label(s[i]);   
                tmp.addMouseListener(action);                
                tmp.setFont(font2);
                b[i].add(tmp);
                b[i].setBackground(Color.CYAN);                
                add(b[i]);
           } 
           setLayout(new GridLayout(5,4));
           setVisible(true);
        }
    }
    class Visual extends Panel{
        Visual(){
            setLayout(new GridLayout(2,1));
            add(l2);
            add(l);
        }
    }
    class Close extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            dispose();
        }
    }
    Visual v=new Visual();
    Btn bb=new Btn();
    Calculator(){
        super("Abhishek's Calculator");
        l.setFont(font);
        l2.setFont(font2);
        addWindowListener(new Close());
        setLocationRelativeTo(null);
        setSize(350,500);
        setResizable(false);
        setVisible(true);
        add(v,BorderLayout.NORTH);
        add(bb,BorderLayout.CENTER);
        
    }
    public static void main(String[] args) {
        new Calculator();
    }
}