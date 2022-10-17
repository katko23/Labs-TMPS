package FactoryMethod;
import FactoryMethod.*;

public class GetShippingFactory{

    //use getPlan method to get object of type Plan
    public Shipping getShipping(String shippingType){
        if(shippingType == null){
            return null;
        }
        if(shippingType.equalsIgnoreCase("AVIA")) {
            return new Avia();
        }
        else if(shippingType.equalsIgnoreCase("SHIP")){
            return new Ship();
        }
        else if(shippingType.equalsIgnoreCase("TRUCK")) {
            return new Truck();
        }
        return null;
    }
}