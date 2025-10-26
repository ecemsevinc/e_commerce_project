package ecommerce;

/**
 * Urun Sınıfı: Sepete eklenecek her bir ürünü temsil eder.
 * Temel olarak Kapsülleme (Encapsulation) ilkesini gösterir.
 */
public class Urun {

    // Kapsülleme (Encapsulation): Alanlar private olarak tanımlanmıştır.
    // Bu sayede verilere dışarıdan direkt müdahale edilemez.
    private String ad;
    private double fiyat;

    /**
     * Kurucu metot (Constructor): Urun nesnesi oluşturulurken adı ve fiyatı ayarlar.
     */
    public Urun(String ad, double fiyat) {
        this.ad = ad;
        this.fiyat = fiyat;
    }

    /**
     * Getter metotları: Kapsüllenmiş (private) 'ad' değişkenine okuma erişimi sağlar.
     */
    public String getAd() {
        return ad;
    }

    /**
     * Getter metotları: Kapsüllenmiş (private) 'fiyat' değişkenine okuma erişimi sağlar.
     * Bu metot, IndirimliUrun sınıfında yeniden tanımlanacaktır (Polimorfizm için kritik).
     */
    public double getFiyat() {
        return fiyat;
    }

    /**

     * Bu, Çok Biçimlilik (Polimorfizm) örneğidir; nesnenin ekranda nasıl gösterileceğini belirler.
     */
    @Override
    public String toString() {
        return ad + " - " + String.format("%.2f", fiyat) + " TL";
    }
}