public class DecoradorTopping implements Helado {

    private Helado helado;

    public DecoradorTopping(Helado helado) {
        this.helado = helado;
    }

    @Override
    public String getTipoHelado() {
        return helado.getTipoHelado() + ", con Topping";
    }

    @Override
    public int getPrecio() {
        return helado.getPrecio() + 20;
    }
}
