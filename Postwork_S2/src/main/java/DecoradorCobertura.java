public class DecoradorCobertura implements Helado {

    private Helado helado;

    public DecoradorCobertura(Helado helado) {
        this.helado = helado;
    }

    @Override
    public String getTipoHelado() {
        return helado.getTipoHelado() + ", con cobertura";
    }

    @Override
    public int getPrecio() {
        return helado.getPrecio() + 20;
    }
}