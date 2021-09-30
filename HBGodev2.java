package hbgodev2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class HBGodev2 extends JFrame implements ActionListener{

    JPanel panel;
    JLabel jlb,jlb2;
    JTextField jtf,jtf2;
    JButton jbt;
    JTable jtbl;
    JScrollPane js;
    
    
    HBGodev2(){
        
        super("");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        this.setLayout(null);
        
        panel=new JPanel();
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setSize(800,250);   
        this.add(panel);
        
        jlb=new JLabel("1.sekansi giriniz: ");
        jlb.setBounds(175,40,170,30);
        
        jtf=new JTextField(""); 
        jtf.setBounds(350,40,250,30);
        
        jlb2=new JLabel("2.sekansi giriniz: ");
        jlb2.setBounds(175,90,170,30);
        
        jtf2=new JTextField("");
        jtf2.setBounds(350,90,250,30);
        
        jbt=new JButton("Matris Olustur");
        jbt.setBounds(275,140, 250, 30);
        
        panel.add(jlb);
        panel.add(jtf);
        panel.add(jlb2);
        panel.add(jtf2);
        panel.add(jbt);
        
        jbt.addActionListener(this);
        
        this.setSize(800, 700);
        this.setVisible(true);   
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource().equals(jbt)){
            
            String sekans1 = jtf.getText();
            String sekans2 = jtf2.getText();
           
            DefaultTableModel model = new DefaultTableModel(sekans1.length()+1,sekans2.length()+1);
            jtbl = new JTable(model);
            jtbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            js=new JScrollPane(jtbl);
            js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
            js.setBounds(20, 210, 745, 350);
            js.setVisible(true);


            for(int i=0;i<sekans1.length();i++){
                model.setValueAt(sekans1.charAt(i),i+1,0);
            }

            for(int i=0;i<sekans2.length();i++){
                model.setValueAt(sekans2.charAt(i),0,i+1);
            }

            for(int i=0;i<sekans1.length();i++){
                for(int j=0;j<sekans2.length();j++){
                    if(sekans1.charAt(i)== sekans2.charAt(j)){
                        model.setValueAt("0",i+1,j+1);
                    }
                }
            }
            
            for(int i=1;i<sekans1.length();i++){
                for(int j=1;j<sekans2.length();j++){
                    if(sekans1.charAt(i)== sekans2.charAt(j) & sekans1.charAt(i-1)== sekans2.charAt(j-1) ){
                        int x = Integer.parseInt( model.getValueAt(i, j).toString() );
                        model.setValueAt(x+1,i+1,j+1);
                    }       
                }       
            }
            
            jtbl.setRowHeight(30);
            for(int i=0;i<=sekans2.length();i++){
                jtbl.getColumnModel().getColumn(i).setPreferredWidth(30);
            }

            jtbl.setDefaultRenderer(Object.class, new tabloBoya());
            
            this.add(js);
        }
    }
    
    
    public class tabloBoya extends DefaultTableCellRenderer {
       
        @Override
        public Color getBackground() {
            
            String value = getText();
            
            Color[] colors = new Color[7]; 
            colors[0] = new Color(250, 219, 216);
            colors[1] = new Color(245, 183, 177);
            colors[2] = new Color(217, 136, 128);
            colors[3] = new Color(174, 214, 241);
            colors[4] = new Color(93, 173, 226);
            colors[5] = new Color(133, 146, 158);
            colors[6] = new Color(93, 109, 126);
            
            switch (value) {
                case "0":
                    return colors[0]; 
                case "1":    
                    return colors[1];    
                case "2":
                    return colors[2]; 
                case "3":
                    return colors[3]; 
                case "4":
                    return colors[4]; 
                case "5":
                    return colors[5];
                case "6":
                case "7":
                case "8":
                case "9":
                    return colors[6]; 
                default:
                    break;
            }
        return super.getBackground();
        }
    }
 
    
    public static void main(String[] args) {
       HBGodev2 odev = new HBGodev2();
    }

}
