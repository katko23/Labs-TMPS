package AbstractFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface furniture{
    Chair createChair();
    CoffeeTable createCoffeeTable();
    Sofa createSofa();
}

abstract class Chair{
    protected int numberOfLegs;
    protected int numberOfSits;
    abstract void getnumberOfLegs(int l);
    abstract void getnumberOfSits(int s);
}

abstract class CoffeeTable{
    protected int numberOfLegs;
    protected double length;
    protected double width;
    abstract void getnumberOfLegs(int l);
    abstract void getLength(double l);
    abstract void getWidth(double w);
}

abstract class Sofa{
    protected int numberOfSits;
    protected String materialChoosen;
    abstract void getnumberOfSits(int s);
    abstract void getMaterial(String m);
}

class VictorianChairs extends Chair{
    void getnumberOfLegs(int l){
        numberOfLegs = l;
    }
    void getnumberOfSits(int s){
        numberOfSits = s;
    }
}

class VictorianCoffeeTable extends CoffeeTable{
    void getnumberOfLegs(int l){
        numberOfLegs = l;
    }

    @Override
    void getLength(double l) {
        length = l;
    }

    @Override
    void getWidth(double w) {
        width = w;
    }
}

class VictorianSofa extends Sofa{
    @Override
    void getMaterial(String m) {
        materialChoosen = m;
    }

    @Override
    void getnumberOfSits(int s) {
        numberOfSits = s;
    }
}

class ModernChairs extends Chair{
    void getnumberOfLegs(int l){
        numberOfLegs = l;
    }
    void getnumberOfSits(int s){
        numberOfSits = s;
    }
}

class ModernCoffeeTable extends CoffeeTable{
    void getnumberOfLegs(int l){
        numberOfLegs = l;
    }

    @Override
    void getLength(double l) {
        length = l;
    }

    @Override
    void getWidth(double w) {
        width = w;
    }
}

class ModernSofa extends Sofa{
    @Override
    void getMaterial(String m) {
        materialChoosen = m;
    }

    @Override
    void getnumberOfSits(int s) {
        numberOfSits = s;
    }
}

class VictorianStyle implements furniture{
    @Override
    public Chair createChair() {
        VictorianChairs tempChair = new VictorianChairs();
        return tempChair;
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        VictorianCoffeeTable tempCoffee = new VictorianCoffeeTable();
        return tempCoffee;
    }

    @Override
    public Sofa createSofa() {
        VictorianSofa tempSofa = new VictorianSofa();
        return tempSofa;
    }
}

class ModernStyle implements furniture{
    @Override
    public Chair createChair() {
        ModernChairs tempChair = new ModernChairs();
        return tempChair;
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        ModernCoffeeTable tempCoffee = new ModernCoffeeTable();
        return tempCoffee;
    }

    @Override
    public Sofa createSofa() {
        ModernSofa tempSofa = new ModernSofa();
        return tempSofa;
    }
}

class Application {
    private furniture clientOrder;
    private Chair chair;
    private CoffeeTable coffeeTable;
    private Sofa sofa;

    public Application(furniture clientStyle) {
        clientOrder = clientStyle;
    }
    public void createFurniture() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the number of chair legs: ");
        int nr_legs=Integer.parseInt(br.readLine());
        System.out.print("Enter the number of chair sits: ");
        int nr_sits=Integer.parseInt(br.readLine());
        chair = clientOrder.createChair();
        chair.getnumberOfLegs(nr_legs);
        chair.getnumberOfSits(nr_sits);

        System.out.print("Enter the number of coffeeTable legs: ");
        nr_legs=Integer.parseInt(br.readLine());
        System.out.print("Enter the length of coffeetable: ");
        double length=Double.parseDouble(br.readLine());
        System.out.print("Enter the width of coffeetable: ");
        double width=Double.parseDouble(br.readLine());
        coffeeTable = clientOrder.createCoffeeTable();
        coffeeTable.getnumberOfLegs(nr_legs);
        coffeeTable.getLength(length);
        coffeeTable.getWidth(width);

        System.out.print("Enter the number of sofa sits: ");
        nr_sits=Integer.parseInt(br.readLine());
        System.out.print("Enter the material of sofa:");
        String material=br.readLine();
        sofa = clientOrder.createSofa();
        sofa.getnumberOfSits(nr_sits);
        sofa.getMaterial(material);


    }
}