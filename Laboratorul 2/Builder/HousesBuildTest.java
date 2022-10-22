package Builder;


public class HousesBuildTest {
    public static void main(String args[]){
        Builder.House maison1 = new House.HouseBuilder(12,3,22).setMedieval(true).hasTowers(4).hasGuns(12).build();
        System.out.println(maison1.getNr_of_doors());
        System.out.println(maison1.getNr_of_walls());
        System.out.println(maison1.getNr_of_windows());
        System.out.println(maison1.isMedieval());
        System.out.println(maison1.getNr_of_towers());
    }
}
