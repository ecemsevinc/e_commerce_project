package ecommerce;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * SepetIslemleri Arayüzü (Interface): Soyutlama (Abstraction) ilkesini temsil eder.
 * Sepetin yapması gereken temel işlevleri (metotları) zorunlu olarak tanımlar.
 */
interface SepetIslemleri {
    void ekle(Urun urun);
    void cikar(String urunAdi);
    void listele();
    double toplamTutariHesapla();
}

/**
 * Sepet Sınıfı: SepetIslemleri arayüzünü uygulayarak (Kalıtım) temel mantığı sağlar.
 */
public class Sepet implements SepetIslemleri {

    // Kapsülleme: Sepet içeriği (urunler listesi) dışarıdan erişime kapalıdır.
    private List<Urun> urunler = new ArrayList<>();

    // Varsayılan kurucu metot: Yeni bir boş sepet listesi oluşturur.
    public Sepet() {
        // this.urunler = new ArrayList<>(); zaten yukarıda yapıldığı için bu blok boş kalabilir.
    }

    /**
     * Ürün ekleme metodu. SepetIslemleri arayüzünden gelen zorunlu metottur.
     */
    @Override
    public void ekle(Urun urun) {
        urunler.add(urun);
        System.out.println("✅ Sepete eklendi: " + urun.getAd());
    }

    /**
     * Ürün çıkarma metodu. SepetIslemleri arayüzünden gelen zorunlu metottur.
     */
    @Override
    public void cikar(String urunAdi) {
        // Sepetteki ürünler arasında dönerek eşleşen ilk ürünü bulur ve çıkarır.
        Iterator<Urun> iterator = urunler.iterator();
        while (iterator.hasNext()) {
            Urun urun = iterator.next();
            if (urun.getAd().equalsIgnoreCase(urunAdi)) {
                iterator.remove();
                System.out.println("❌ Sepetten çıkarıldı: " + urun.getAd());
                return; // Ürün çıkarıldıktan sonra metod sonlandırılır.
            }
        }
        System.out.println("⚠️ '" + urunAdi + "' sepette bulunamadı.");
    }

    /**
     * Sepet içeriğini listeleme metodu. SepetIslemleri arayüzünden gelen zorunlu metottur.
     */
    @Override
    public void listele() {
        if (urunler.isEmpty()) {
            System.out.println("Sepetiniz boş.");
            return;
        }
        System.out.println("\n--- SEPET İÇERİĞİ ---");
        for (int i = 0; i < urunler.size(); i++) {
            // Polimorfizm: Urun veya IndirimliUrun nesnesinin kendi toString() metodu çağrılır.
            System.out.println((i + 1) + ". " + urunler.get(i));
        }
        System.out.println("----------------------");
    }

    /**
     * Sepetteki tüm ürünlerin toplam tutarını hesaplar. SepetIslemleri arayüzünden gelen zorunlu metottur.
     */
    @Override
    public double toplamTutariHesapla() {
        double toplam = 0;
        for (Urun urun : urunler) {
            // Polimorfizm: getFiyat metodu çağrılırken, Java nesnenin türüne bakar.
            // Eğer nesne IndirimliUrun ise indirimli fiyatı, Urun ise normal fiyatı döndürür.
            toplam += urun.getFiyat();
        }
        return toplam;
    }
}