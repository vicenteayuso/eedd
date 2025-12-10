public class Furgonetas{
    public Boolean realizar(Envio envio, String direccion){
        System.out.println("Realianndo enivio a " + direccion + " con furgoneta.");
         return Math.random() > 0.5;
    }
}