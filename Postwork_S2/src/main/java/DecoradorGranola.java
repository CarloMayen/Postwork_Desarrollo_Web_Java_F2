public class DecoradorGranola implements Helado {

    private Helado helado;

    public DecoradorGranola(Helado helado) {
        this.helado = helado;
    }

    @Override
    public String getTipoHelado() {
        return helado.getTipoHelado() + ", con Granola";
    }

    @Override
    public int getPrecio() {
        return helado.getPrecio() + 10;
    }
}
