import java.awt.Color;  
import java.awt.EventQueue;  
import java.awt.Font;  
import java.awt.SystemColor;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.util.Stack;  
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JPanel;  
import javax.swing.JTextField;  
import javax.swing.SwingConstants;  
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class CA2 extends JFrame {  
  
    private static final long serialVersionUID = 45681563L;  
    private JPanel contentPane;  
    private JTextField textField;  
    /** 
     * Launch the application. 
     */  
    public static void main(String[] args) {  
        EventQueue.invokeLater(new Runnable() {  
            public void run() {  
                try {  
                    CA2 frame = new CA2();
                   
                    frame.setVisible(true);

                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        });  
    }  

    private static double Equals(String operator,double a,double b)  
    {  
        switch(operator)  
        {     
            case "+":return a+b;  
            case "-":return a-b;  
            case "*":return a*b;  
            case "/":return a/b;  
        }  
        return 0;  
    }  
    /** 
     * Create the frame. 
     */  
    public CA2() {  
        setTitle("Calc");  
        setResizable(false);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setBounds(400, 100, 653, 579); //�������һ�� 
        contentPane = new JPanel();  
        contentPane.setBackground(Color.DARK_GRAY);  
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));  
        setContentPane(contentPane);  
        contentPane.setLayout(null);  
        
        //ǰ4*4�а�������
        JPanel panel = new JPanel();  
        panel.setBounds(0, 138, 373, 324);  
        contentPane.add(panel);  
        panel.setLayout(null);  
        //��������� 
        //��1��1��
        //CLEAR
        JButton btnNewJButton_AC = new JButton("AC");  
        btnNewJButton_AC.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_AC.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_AC.setBounds(1, 0, 93, 81);  
        panel.add(btnNewJButton_AC);  
        
        //������� positive/negtive ��1��2��
        JButton btnNewJButton_PN = new JButton("+/-");  
        btnNewJButton_PN.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_PN.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_PN.setBounds(94, 0, 93, 81);  
        panel.add(btnNewJButton_PN);  
        
        //�ٷֱ����� /100 ��1��3��
        JButton btnNewJButton_PE = new JButton("%");  
        btnNewJButton_PE.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_PE.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_PE.setBounds(187, 0, 93, 81);  
        panel.add(btnNewJButton_PE);  
        
        //������������ * ��2��4��
        JButton btnNewJButton_MU = new JButton("*");  
        btnNewJButton_MU.setForeground(Color.WHITE);  
        btnNewJButton_MU.setBackground(Color.ORANGE);  
        btnNewJButton_MU.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_MU.setBounds(280, 81, 93, 81);  
        panel.add(btnNewJButton_MU);
        
        //������������ /  ��1��4��
        JButton btnNewJButton_DI = new JButton("/");  
        btnNewJButton_DI.setForeground(Color.WHITE);  
        btnNewJButton_DI.setBackground(Color.ORANGE);  
        btnNewJButton_DI.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_DI.setBounds(280, 0, 93, 81);  
        panel.add(btnNewJButton_DI);  
        
        //������������ -  ��3��4��
        JButton btnNewJButton_N = new JButton("-");  
        btnNewJButton_N.setForeground(Color.WHITE);  
        btnNewJButton_N.setBackground(Color.ORANGE);  
        btnNewJButton_N.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_N.setBounds(280, 162, 93, 81);  
        panel.add(btnNewJButton_N);  
        
        //������������ +  ��4��4��
        JButton btnNewJButton_P = new JButton("+");  
        btnNewJButton_P.setForeground(Color.WHITE);  
        btnNewJButton_P.setBackground(Color.ORANGE);  
        btnNewJButton_P.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_P.setBounds(280, 243, 93, 81);  
        panel.add(btnNewJButton_P);  
        
        //�ڣ�1��5������5��8����������
        JPanel panel2 = new JPanel();  
        panel2.setBounds(373, 138, 373, 405);  
        contentPane.add(panel2);  
        panel2.setLayout(null);  
        //��5��
        //�����µĹ��ܰ���SIN
        JButton btnNewJButton_SIN =new JButton("sin");
        btnNewJButton_SIN.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_SIN.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_SIN.setBounds(0, 0, 93, 81);  
        panel2.add(btnNewJButton_SIN);  
        
        //�����µĹ��ܰ���COS
        JButton btnNewJButton_COS =new JButton("cos");
        btnNewJButton_COS.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_COS.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_COS.setBounds(0, 81, 93, 81);  
        panel2.add(btnNewJButton_COS); 
        
        //�����µĹ��ܰ���SEC
        JButton btnNewJButton_SEC =new JButton("SEC");
        btnNewJButton_SEC.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_SEC.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_SEC.setBounds(0, 162, 93, 81);  
        panel2.add(btnNewJButton_SEC); 
        
        //�����µĹ��ܰ���CSC
        JButton btnNewJButton_CSC =new JButton("CSC");
        btnNewJButton_CSC.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_CSC.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_CSC.setBounds(0, 243, 93, 81);  
        panel2.add(btnNewJButton_CSC);
        
        //�����µĹ��ܰ���TAN
        JButton btnNewJButton_TAN =new JButton("TAN");
        btnNewJButton_TAN.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_TAN.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_TAN.setBounds(0, 324, 93, 81);  
        panel2.add(btnNewJButton_TAN);
        
        //��6��
        //�����µĹ��ܰ�����ֵ
        JButton btnNewJButton_AVE =new JButton("AVE");
        btnNewJButton_AVE.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_AVE.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_AVE.setBounds(93, 0, 93, 81);  
        panel2.add(btnNewJButton_AVE); 
        
        //�����µĹ��ܰ�������MODE
        JButton btnNewJButton_MO =new JButton("MODE");
        btnNewJButton_MO.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_MO.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_MO.setBounds(93, 81, 93, 81);  
        panel2.add(btnNewJButton_MO); 
        
        //�����µĹ��ܰ���CAPM �ʱ��ʲ�����ģ��
        JButton btnNewJButton_CAPM = new JButton("CAPM");  
        btnNewJButton_CAPM.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_CAPM.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_CAPM.setBounds(93, 162, 93, 81);  
        panel2.add(btnNewJButton_CAPM);  
        
        //�����µĹ��ܰ���PV ��ֵ����  
        JButton btnNewJButton_PV = new JButton("PV");
        btnNewJButton_PV.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_PV.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_PV.setBounds(93, 243, 93, 81);  
        panel2.add(btnNewJButton_PV);  
        
        //�����µĹ��ܰ���PMT �������
        JButton btnNewJButton_PMT = new JButton("PMT");
        btnNewJButton_PMT.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_PMT.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_PMT.setBounds(93, 324, 93, 81);  
        panel2.add(btnNewJButton_PMT); 
        
        //��7��
        //�����µĹ��ܰ���M^N �˷���������ָ��ͨ�ü���
        JButton btnNewJButton_MI = new JButton("M^N");
        btnNewJButton_MI.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_MI.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_MI.setBounds(186, 0, 93, 81);  
        panel2.add(btnNewJButton_MI);  
        
        //�����µĹ��ܰ���LOG
        JButton btnNewJButton_LOG = new JButton("log");  
        btnNewJButton_LOG.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_LOG.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_LOG.setBounds(186, 81, 93, 81);  
        panel2.add(btnNewJButton_LOG);  
        
        //�����µĹ��ܰ���BS ������-˹�ƶ�˹��Ȩ��ֵ����ģ��
        JButton btnNewJButton_BS = new JButton("BS");
        btnNewJButton_BS.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_BS.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_BS.setBounds(186, 162, 93, 81);  
        panel2.add(btnNewJButton_BS);
        
        //�����µĹ��ܰ���FV ��ֵ����  
        JButton btnNewJButton_FV = new JButton("FV");
        btnNewJButton_FV.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_FV.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_FV.setBounds(186, 243, 93, 81);  
        panel2.add(btnNewJButton_FV);
        
         
        //�����µĹ��ܰ���IRR �����ʼ���  
        JButton btnNewJButton_IRR = new JButton("IRR");
        btnNewJButton_IRR.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_IRR.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_IRR.setBounds(186, 324, 93, 81);  
        panel2.add(btnNewJButton_IRR);  
        
        //���ְ���
        JButton btnNewJButton_7 = new JButton("7");
        btnNewJButton_7.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_7.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_7.setBounds(1, 81, 93, 81);  
        panel.add(btnNewJButton_7);  
          
        JButton btnNewJButton_8 = new JButton("8");  
        btnNewJButton_8.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_8.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_8.setBounds(94, 81, 93, 81);  
        panel.add(btnNewJButton_8);  
          
        JButton btnNewJButton_9 = new JButton("9");  
        btnNewJButton_9.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_9.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_9.setBounds(187, 81, 93, 81);  
        panel.add(btnNewJButton_9);  
          
          
        JButton btnNewJButton_4 = new JButton("4");  
        btnNewJButton_4.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_4.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_4.setBounds(1, 162, 93, 81);  
        panel.add(btnNewJButton_4);  
          
        JButton btnNewJButton_5 = new JButton("5");  
        btnNewJButton_5.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_5.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_5.setBounds(94, 162, 93, 81);  
        panel.add(btnNewJButton_5);  
          
        JButton btnNewJButton_6 = new JButton("6");  
        btnNewJButton_6.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_6.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_6.setBounds(187, 162, 93, 81);  
        panel.add(btnNewJButton_6);  
         
        JButton btnNewJButton_1 = new JButton("1");  
        btnNewJButton_1.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_1.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_1.setBounds(1, 243, 93, 81);  
        panel.add(btnNewJButton_1);  
          
        JButton btnNewJButton_2 = new JButton("2");  
        btnNewJButton_2.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_2.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_2.setSize(93, 81);  
        btnNewJButton_2.setLocation(94, 243);  
        panel.add(btnNewJButton_2);  
          
        JButton btnNewJButton_3 = new JButton("3");  
        btnNewJButton_3.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_3.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_3.setSize(93, 81);  
        btnNewJButton_3.setLocation(187, 243);  
        panel.add(btnNewJButton_3);  
         
        //���һ�а�������  ��5��1�� ��5��2�� ��5��3�� ��5��4��
        JPanel panel_1 = new JPanel();  
        panel_1.setBounds(0, 462, 374, 82);  
        contentPane.add(panel_1);  
        panel_1.setLayout(null);  
          
        JButton btnNewJButton_0 = new JButton("0");  
        btnNewJButton_0.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_0.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_0.setBounds(1, 0, 186, 82);  
        panel_1.add(btnNewJButton_0);  
          
        JButton btnNewJButton_dot = new JButton(".");  
        btnNewJButton_dot.setBackground(SystemColor.inactiveCaptionBorder);  
        btnNewJButton_dot.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_dot.setBounds(187, 0, 93, 82);  
        panel_1.add(btnNewJButton_dot);  
          
        JButton btnNewJButton_eq = new JButton("=");  
        btnNewJButton_eq.setForeground(Color.WHITE);  
        btnNewJButton_eq.setBackground(Color.ORANGE);  
        btnNewJButton_eq.setFont(new Font("����", Font.BOLD, 20));  
        btnNewJButton_eq.setBounds(280, 0, 93, 82);  
        panel_1.add(btnNewJButton_eq);
        
        //ʵʱʱ����ʾ����
        JPanel panel_3 = new TimePanel();  
        panel_3.setBounds(373, 100,279, 38);  
        contentPane.add(panel_3);  
     
        //���봰����ʾ����
        textField = new JTextField();  
        textField.setHorizontalAlignment(SwingConstants.RIGHT);  
        textField.setFont(new Font("����", Font.PLAIN, 70));  
        textField.setForeground(Color.WHITE);  
        textField.setText("0");  
        textField.setEditable(false);  
        textField.setBorder(null);  
        textField.setBackground(Color.DARK_GRAY);  
        textField.setBounds(14, 56, 346, 82);  
        contentPane.add(textField);  
        textField.setColumns(10);  
  
    //����������Լ��ַ�ͨ����ջ�ļ���  
        Stack<Double> Number = new Stack<>();   
        Stack<String> Operator = new Stack<>();   
        StringBuffer sb = new StringBuffer();  
        {  
            btnNewJButton_1.addActionListener(new ActionListener()   
            {  
                public void actionPerformed(ActionEvent e)   
                {  
                    int flag = 0;  
                    if(sb.indexOf("-")!=-1)flag=1;  
                    if(sb.length()-flag>=9)return;  
                    btnNewJButton_AC.setText("C");  
                    sb.append("1");  
                    textField.setText(sb.toString());  
                }  
            });  
        }  
          
        {  
            btnNewJButton_2.addActionListener(new ActionListener()   
            {  
                public void actionPerformed(ActionEvent e)   
                {  
                    int flag = 0;  
                    if(sb.indexOf("-")!=-1)flag=1;  
                    if(sb.length()-flag>=9)return;  
                    btnNewJButton_AC.setText("C");  
                    sb.append("2");  
                    textField.setText(sb.toString());  
                }  
            });  
        }  
          
        {  
            btnNewJButton_3.addActionListener(new ActionListener()   
            {  
                public void actionPerformed(ActionEvent e)  
                {  
                    int flag = 0;  
                    if(sb.indexOf("-")!=-1)flag=1;  
                    if(sb.length()-flag>=9)return;  
                    btnNewJButton_AC.setText("C");  
                    sb.append("3");  
                    textField.setText(sb.toString());  
                }  
            });  
        }  
          
        {  
            btnNewJButton_4.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent e) {  
                    int flag = 0;  
                    if(sb.indexOf("-")!=-1)flag=1;  
                    if(sb.length()-flag>=9)return;  
                    btnNewJButton_AC.setText("C");  
                    sb.append("4");  
                    textField.setText(sb.toString());  
                }  
            });  
        }  
          
          
        {  
            btnNewJButton_5.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent e) {  
                    int flag = 0;  
                    if(sb.indexOf("-")!=-1)flag=1;  
                    if(sb.length()-flag>=9)return;  
                    btnNewJButton_AC.setText("C");  
                    sb.append("5");  
                    textField.setText(sb.toString());  
                }  
            });  
        }  
          
        {  
            btnNewJButton_6.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent e) {  
                    int flag = 0;  
                    if(sb.indexOf("-")!=-1)flag=1;  
                    if(sb.length()-flag>=9)return;  
                    btnNewJButton_AC.setText("C");  
                    sb.append("6");  
                    textField.setText(sb.toString());  
                }  
            });  
        }  
          
        {  
            btnNewJButton_7.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent e) {  
                    int flag = 0;  
                    if(sb.indexOf("-")!=-1)flag=1;  
                    if(sb.length()-flag>=9)return;  
                    btnNewJButton_AC.setText("C");  
                    sb.append("7");  
                    textField.setText(sb.toString());  
                }  
            });  
        }  
          
        {  
            btnNewJButton_8.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent e) {  
                    int flag = 0;  
                    if(sb.indexOf("-")!=-1)flag=1;  
                    if(sb.length()-flag>=9)return;  
                    btnNewJButton_AC.setText("C");  
                    sb.append("8");  
                    textField.setText(sb.toString());  
                }  
            });  
        }  
          
        {  
            btnNewJButton_9.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent e) {  
                    int flag = 0;  
                    if(sb.indexOf("-")!=-1)flag=1;  
                    if(sb.length()-flag>=9)return;  
                    btnNewJButton_AC.setText("C");  
                    sb.append("9");  
                    textField.setText(sb.toString());  
                }  
            });  
        }  
          
        {  
            btnNewJButton_AC.addActionListener(new ActionListener()   
            {  
                public void actionPerformed(ActionEvent e)   
                {  
                    btnNewJButton_AC.setText("AC");  
                    sb.delete(0,sb.length());  
                    textField.setText("0");  
                    while(!Operator.isEmpty())Operator.pop();  
                    while(!Number.isEmpty())Number.pop();  
                }  
            });  
        }  
          
        {  
            btnNewJButton_0.addActionListener(new ActionListener()   
            {  
                public void actionPerformed(ActionEvent e)   
                {  
                    if(sb.length()==0 || (sb.length()==1 && sb.indexOf("-")!=-1))return;  
                    int flag = 0;  
                    if(sb.indexOf("-")!=-1)flag=1;  
                    if(sb.length()-flag>=9)return;  
                    btnNewJButton_AC.setText("C");  
                    sb.append("0");  
                    textField.setText(sb.toString());  
                }  
            });  
        }  
          
        {  
            btnNewJButton_dot.addActionListener(new ActionListener()   
            {  
                public void actionPerformed(ActionEvent e)   
                {  
                    if(sb.length()>=9)return;  
                    if(sb.indexOf(".")!=-1)return;  
                    btnNewJButton_AC.setText("C");  
                    if(sb.length()==0 || (sb.length()==1 && sb.indexOf("-")!=-1))  
                        sb.append("0.");  
                    else  
                        sb.append(".");  
                    textField.setText(sb.toString());  
                }  
            });  
        }  
          
        {  
            btnNewJButton_PN.addActionListener(new ActionListener()   
            {  
                public void actionPerformed(ActionEvent e)   
                {  
                    if(sb.indexOf("-")==-1)  
                    {  
                        sb.insert(0,'-');  
                        if(sb.length()==1)  
                        {  
                            textField.setText("-0");  
                            return;  
                        }  
                    }  
                    else  
                    {  
                        sb.delete(0,1);  
                        if(sb.length()==0)  
                        {  
                            textField.setText("0");  
                            return;  
                        }  
                    }  
                    textField.setText(sb.toString());  
                }  
            });  
        }  
          
        {  
            btnNewJButton_P.addActionListener(new ActionListener()   
            {  
                public void actionPerformed(ActionEvent e)   
                {  
                    try  
                    {  
                        double num = Double.parseDouble(sb.toString());  
                          
                        while(Operator.size()>=1)  
                            num = Equals(Operator.pop(),Number.pop(),num);  
                        String str = num+"";  
                        if(str.length()>9)  
                            str = str.substring(0,9);  
                        if(str.endsWith(".0"))  
                            str = str.substring(0,str.length()-2);  
                        textField.setText(str);  
                          
                        Number.push(num);  
                        Operator.push("+");  
                        sb.delete(0,sb.length());  
                    }catch(NumberFormatException e1){}  
                }  
            });  
        }  
          
        {  
            btnNewJButton_N.addActionListener(new ActionListener()   
            {  
                public void actionPerformed(ActionEvent e)   
                {  
                    try  
                    {  
                        double num = Double.parseDouble(sb.toString());  
                          
                        while(Operator.size()>=1)  
                            num = Equals(Operator.pop(),Number.pop(),num);  
                        String str = num+"";  
                        if(str.length()>9)  
                            str = str.substring(0,9);  
                        if(str.endsWith(".0"))  
                            str = str.substring(0,str.length()-2);  
                        textField.setText(str);  
                          
                        Number.push(num);  
                        Operator.push("-");  
                        sb.delete(0,sb.length());  
                    }catch(NumberFormatException e1){}  
                }  
            });  
        }  
          
        {  
            btnNewJButton_MU.addActionListener(new ActionListener()   
            {  
                public void actionPerformed(ActionEvent e)   
                {  
                    try  
                    {  
                        double num = Double.parseDouble(sb.toString());  
  
                        if(Operator.size()>=1 && (Operator.peek().equals("*") || Operator.peek().equals("/")))  
                            num = Equals(Operator.pop(),Number.pop(),num);  
                        String str = num+"";  
                        if(str.length()>9)  
                            str = str.substring(0,9);  
                        if(str.endsWith(".0"))  
                            str = str.substring(0,str.length()-2);  
                        textField.setText(str);  
                          
                        Number.push(num);  
                        Operator.push("*");  
                        sb.delete(0,sb.length());  
                    }catch(NumberFormatException e1){}  
                }  
            });  
        }  
          
        {  
            btnNewJButton_DI.addActionListener(new ActionListener()   
            {  
                public void actionPerformed(ActionEvent e)   
                {  
                    try  
                    {  
                        double num = Double.parseDouble(sb.toString());  
  
                        if(Operator.size()>=1 && (Operator.peek().equals("*") || Operator.peek().equals("/")))  
                            num = Equals(Operator.pop(),Number.pop(),num);  
                        String str = num+"";  
                        if(str.length()>9)  
                            str = str.substring(0,9);  
                        if(str.endsWith(".0"))  
                            str = str.substring(0,str.length()-2);  
                        textField.setText(str);  
                          
                        Number.push(num);  
                        Operator.push("/");  
                        sb.delete(0,sb.length());  
                    }catch(NumberFormatException e1){}  
                }  
            });  
        }  
          
        {  
            btnNewJButton_eq.addActionListener(new ActionListener()   
            {  
                public void actionPerformed(ActionEvent e)   
                {  
                    double num = Double.parseDouble(sb.toString());  
                    while(!Operator.isEmpty())  
                        num = Equals(Operator.pop(),Number.pop(),num);  
                      
                    String str = num+"";  
                    if(str.length()>9)  
                        str = str.substring(0,9);  
                    if(str.endsWith(".0"))  
                        str = str.substring(0,str.length()-2);  
                    textField.setText(str);  
                      
                    sb.delete(0,sb.length());  
                    if(num!=0)  
                        sb.append(str);  
                }  
            });  
        }  
          
        {  
            btnNewJButton_PE.addActionListener(new ActionListener()   
            {  
                public void actionPerformed(ActionEvent e)   
                {  
                    try  
                    {  
                        double num = Double.parseDouble(sb.toString());  
                        if(num==0)  
                        {  
                            sb.delete(0,sb.length());  
                            textField.setText("0");  
                            return;  
                        }  
                        num /= 100;  
                        sb.delete(0,sb.length());  
                        sb.append(num);  
                        textField.setText(sb.toString());  
                    }catch(NumberFormatException e1){}  
                }  
            });  
        }  
        
        {  
            btnNewJButton_SIN.addActionListener(new ActionListener()   
            {  
                public void actionPerformed(ActionEvent e)   
                {  
                    try  
                    {  
                        double num = Double.parseDouble(sb.toString());  
                       /* if(num==0)  
                        {  
                            sb.delete(0,sb.length());  
                            textField.setText("0");  
                            return;  
                        }  */
                        num = Math.sin(Math.PI/180*num);  
                        sb.delete(0,sb.length());
                         
                        String str = num+"";  
                        if(str.length()>9)  
                            str = str.substring(0,9);  
                        if(str.endsWith(".0"))  
                            str = str.substring(0,str.length()-2);
                        sb.append(str);  
                        textField.setText(sb.toString());  
                    }catch(NumberFormatException e1){}  
                    
                }  
            });  
        }  
        
        {  
            btnNewJButton_COS.addActionListener(new ActionListener()   
            {  
                public void actionPerformed(ActionEvent e)   
                {  
                    try  
                    {  
                        double num = Double.parseDouble(sb.toString());  
                       /* if(num==0)  
                        {  
                            sb.delete(0,sb.length());  
                            textField.setText("0");  
                            return;  
                        }  */
                        num = Math.cos(Math.PI/180*num);  
                        sb.delete(0,sb.length());
                         
                        String str = num+"";  
						if(str.length()>9) {
                        	String S1 = str.substring(0,6);
                        	String S2 = str.substring(str.length()-4,str.length());
                        	str = S1+S2;
						}
                        sb.append(str);  
                        textField.setText(sb.toString());  
                    }catch(NumberFormatException e1){}  
                    
                }  
            });  
        }  
        
        {  
            btnNewJButton_TAN.addActionListener(new ActionListener()   
            {  
                public void actionPerformed(ActionEvent e)   
                {  
                    try  
                    {  
                        double num = Double.parseDouble(sb.toString());  
                        if(num==0)  
                        {  
                            sb.delete(0,sb.length());  
                            textField.setText("0");  
                            return;  
                        } 
                        num = Math.tan(Math.PI/180*num);  
                        sb.delete(0,sb.length());
                         
                        String str = num+"";  
                        if(str.length()>9)  
                            str = str.substring(0,9);  
                        if(str.endsWith(".0"))  
                            str = str.substring(0,str.length()-2);
                        sb.append(str);  
                        textField.setText(sb.toString());  
                    }catch(NumberFormatException e1){}  
                    
                }  
            });  
        }  
        
        {  
            btnNewJButton_SEC.addActionListener(new ActionListener()   
            {  
                public void actionPerformed(ActionEvent e)   
                {  
                    try  
                    {  
                        double num = Double.parseDouble(sb.toString());  
                       /* if(num==0)  
                        {  
                            sb.delete(0,sb.length());  
                            textField.setText("0");  
                            return;  
                        }  */
                        num = 1/(Math.cos(Math.PI/180*num));  
                        sb.delete(0,sb.length());
                         
                        String str = num+"";  
                        if(str.length()>9)  
                            str = str.substring(0,9);  
                        if(str.endsWith(".0"))  
                            str = str.substring(0,str.length()-2);
                        sb.append(str);  
                        textField.setText(sb.toString());  
                    }catch(NumberFormatException e1){}  
                    
                }  
            });  
        }  
        
        {  
            btnNewJButton_CSC.addActionListener(new ActionListener()   
            {  
                public void actionPerformed(ActionEvent e)   
                {  
                    try  
                    {  
                        double num = Double.parseDouble(sb.toString());  
                       /* if(num==0)  
                        {  
                            sb.delete(0,sb.length());  
                            textField.setText("0");  
                            return;  
                        }  */
                        num = 1/(Math.sin(Math.PI/180*num));  
                        sb.delete(0,sb.length());
                         
                        String str = num+"";  
                        if(str.length()>9)  
                            str = str.substring(0,9);  
                        if(str.endsWith(".0"))  
                            str = str.substring(0,str.length()-2);
                        sb.append(str);  
                        textField.setText(sb.toString());  
                    }catch(NumberFormatException e1){}  
                    
                }  
            });  
        }  
    }  
 }
