public class CadenaHelados {

    public static void main(String[] args) {
        // helado sencillo
        Helado sencillo = new HeladoSuave();

        System.out.println("Ticket de compra: "+ sencillo.getTipoHelado());
        System.out.println("$" + sencillo.getPrecio());

        // helado con Topping y cobertura
        Helado topCober = new HeladoSuave();
        topCober = new DecoradorTopping(topCober);
        topCober = new DecoradorCobertura(topCober);

        System.out.println("Ticket de compra: "+ topCober.getTipoHelado());
        System.out.println("$" + topCober.getPrecio());

        // Helado con todos los ingredientes
        Helado atascado = new HeladoSuave();
        atascado = new DecoradorTopping(atascado);
        atascado = new DecoradorMermelada(atascado);
        atascado = new DecoradorGranola(atascado);
        atascado = new DecoradorGalleta(atascado);
        atascado = new DecoradorCobertura(atascado);

        System.out.println("Ticket de compra: "+ atascado.getTipoHelado());
        System.out.println("$" + atascado.getPrecio());

    }


}
