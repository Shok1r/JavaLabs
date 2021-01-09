package lab8;

import java.util.Properties;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author NikitaShokorov
 */
public class Email {

    private  final  static  String  PROPS_FILE_PATH = "/Users/NikitaShokorov/Desktop/LabsAndOthers/Java/Labs/Lab8/src/lab8/userInfo.properties";
    private static Sender sslSender;

    public static void main(String[] args)
    {
        
        try {
            Scanner in = new Scanner(System.in);
            
            //������ ������ ������������ ��� ����������� (����� ������)
            Properties prop = new Properties();
            File file = new File(PROPS_FILE_PATH);
            prop.load(new FileReader(file));        

            /*
            System.out.print("������� ������ ����������: \n");
            String emailTo = in.nextLine();
            */
            
            System.out.print("������� ���� ������: \n");
            String theme = in.nextLine();
            
            System.out.print("������� ���� ������: \n");
            String body = in.nextLine();
            
            sslSender = new Sender(prop.getProperty("user"), prop.getProperty("pass"));
            sslSender.send(theme, body, prop.getProperty("from"),  prop.getProperty("to"));
            
            System.out.println ("��������� ����������");
            
            } catch (IOException e) {
                System.out.print(e.getMessage());
            }
    }
    
}
