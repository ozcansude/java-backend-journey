public class Kutu<T>{
    private T veri;

    public Kutu(T veri){
        this.veri = veri;
    }

    public T getVeri() {
        return veri;
    }

    public void setVeri(T yeniVeri) {
        this.veri = yeniVeri;
    }
}