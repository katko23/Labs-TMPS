package FactoryMethod;

import java.io.*;
import FactoryMethod.*;
class GenerateShipping{
    public static void main(String args[])throws IOException{
        GetShippingFactory planFactory = new GetShippingFactory();

        System.out.print("Enter the name of Shipping ('AVIA' , 'SHIP' , 'TRUCK'): ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String ShippingName=br.readLine();
        System.out.print("Enter the distance in km for that you need to check costs: ");
        int distance=Integer.parseInt(br.readLine());

        Shipping p = planFactory.getShipping(ShippingName);
        //call getRate() method and calculateBill()method of DomesticPaln.

        System.out.print("Price for "+ShippingName+" of  "+distance+" km is: ");
        p.calculateBill(distance);
    }
}
