package ecommerce;

/**
 * IndirimliUrun Sınıfı: Urun sınıfından Kalıtım (Inheritance) yoluyla türetilmiştir.
 * Kalıtım ve Polimorfizm ilkelerini gösterir.
 */
public class IndirimliUrun extends Urun {

    // Bu alana özel bir özellik eklenir.
    private double indirimOrani; // Örn: 0.10 (%10 indirim)

    /**
     * Kurucu metot: Üst sınıfın (Urun) kurucusunu çağırır ve ek olarak indirim oranını alır.
     */
    public IndirimliUrun(String ad, double fiyat, double indirimOrani) {
        super(ad, fiyat); // Kalıtım: Üst sınıfa ait kurucuyu çağırır.
        this.indirimOrani = indirimOrani;
    }

    /**
     * getFiyat metodu: Üst sınıftaki metot yeniden yazılır (Polimorfizm/Çok Biçimlilik).
     * Artık ürünün indirimli fiyatını hesaplar.
     */
    @Override
    public double getFiyat() {
        // super.getFiyat() ile Urun sınıfındaki temel fiyata erişilir ve indirim uygulanır.
        return super.getFiyat() * (1 - indirimOrani);
    }

    /**
     * toString metodu: Polimorfizm sayesinde ürünün indirimli olduğunu belirtmek için özelleştirilir.
     */
    @Override
    public String toString() {
        // Üst sınıfın (Urun) formatına ek olarak "(İndirimli)" bilgisini ekler.
        return super.toString() + " (İndirimli)";
    }
}