package FactoryMethod;
    abstract class Shipping{
        protected double price_km;
        abstract void getPrice_Km();

        public void calculateBill(int dist){
            getPrice_Km();
            System.out.println(dist*price_km);
        }
    }
    // make a abstract class of shipping

    class Avia extends Shipping{
        //@override
        public void getPrice_Km(){
            price_km = 5.5;
        }
    }
    // first class of shipping with a plane

    class Ship extends Shipping{
        //@override
        public void getPrice_Km(){
            price_km = 7.5;
        }
    }
    // Deliver by sea in a container ##DOCKER##

    class Truck extends Shipping{

        public void getPrice_Km(){
            price_km = 2.3;
        }
    }//Deliver by the Truck , but at a lower price




