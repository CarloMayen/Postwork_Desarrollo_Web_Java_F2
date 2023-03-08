public class DecoradorMermelada implements Helado {

    private Helado helado;

    public DecoradorMermelada(Helado helado) {
        this.helado = helado;
    }

    @Override
    public String getTipoHelado() {
        return helado.getTipoHelado() + ", con Mermelada";
    }

    @Override
    public int getPrecio() {
        return helado.getPrecio() + 10;
    }
}
