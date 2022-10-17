package AbstractFactory;
import java.awt.desktop.AppForegroundListener;
import java.io.*;

public class GenerateFurniture {
    public static void main(String args[])throws IOException{
        System.out.print("Enter the name of Style ('Victorian' , 'Modern'): ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        furniture factory = new ModernStyle();
        String StyleName=br.readLine();
        if (StyleName == "Victorian") {
            factory = new VictorianStyle();
        }else if (StyleName == "Modern"){
            factory = new ModernStyle();
        }else {
            System.out.println("Style gresit");
        }

        Application app = new Application(factory);
        app.createFurniture();



    }
}
