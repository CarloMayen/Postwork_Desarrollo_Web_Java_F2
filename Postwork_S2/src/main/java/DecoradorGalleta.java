public class DecoradorGalleta implements Helado {

    private Helado helado;

    public DecoradorGalleta(Helado helado) {
        this.helado = helado;
    }

    @Override
    public String getTipoHelado() {
        return helado.getTipoHelado() + ", con Galleta";
    }

    @Override
    public int getPrecio() {
        return helado.getPrecio() + 15;
    }
}