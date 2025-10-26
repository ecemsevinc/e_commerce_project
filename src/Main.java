package ecommerce; // Bu sınıf ecommerce paketine ait

import java.util.*; // Gerekli Java kütüphanelerini içe aktarıyoruz (List, Scanner vb.)

public class Main {

    // Katalog: ürünlerin tutulduğu liste
    private static final List<Urun> katalog = new ArrayList<>();

    // Sepet sınıfından bir nesne oluşturduk (kullanıcının sepeti)
    private static final Sepet sepet = new Sepet();

    // Kullanıcıdan veri almak için Scanner sınıfı
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Uygulama başlarken ürün kataloğunu oluşturur
        katalogOlustur();

        System.out.println("=== E-Ticaret Konsol Uygulaması ===");

        // Sürekli çalışan menü döngüsü
        while (true) {
            menuYazdir(); // Kullanıcıya menüyü gösterir
            String secim = sc.nextLine().trim(); // Kullanıcının seçimini alır

            // switch-case yapısı: kullanıcının girdiği seçime göre işlem yapılır
            switch (secim) {
                case "1" -> katalogListele();    // 1: Ürünleri listele
                case "2" -> sepeteEkle();        // 2: Sepete ürün ekle
                case "3" -> sepettenCikar();     // 3: Sepetten ürün çıkar
                case "4" -> sepetiListele();     // 4: Sepeti göster
                case "5" -> toplamTutar();       // 5: Toplam tutarı göster
                case "6" -> odeme();             // 6: Ödeme işlemi yap
                case "0" -> {                    // 0: Programdan çık
                    System.out.println("Çıkış yapıldı. Teşekkürler!");
                    return; // while döngüsünü bitirir
                }
                default -> System.out.println("Geçersiz seçim (0-6) girin.");
            }
        }
    }

    // Kullanıcıya menü seçeneklerini gösteren metot
    private static void menuYazdir() {
        System.out.println("""
                
                -----------------------------
                1) Kataloğu Listele
                2) Sepete Ekle
                3) Sepetten Çıkar
                4) Sepeti Listele
                5) Toplam Tutar
                6) Ödeme (Kupon: INDIRIM10)
                0) Çıkış
                -----------------------------
                Seçiminiz: """);
    }

    // Katalog oluşturma metodu — uygulama başlarken örnek ürünler ekleniyor
    private static void katalogOlustur() {
        katalog.add(new Urun("Kulaklık", 399.90));
        katalog.add(new Urun("Mouse", 249.50));
        katalog.add(new Urun("Klavye", 549.00));
        katalog.add(new IndirimliUrun("Laptop Çantası", 899.00, 0.20)); // %20 indirimli ürün
        katalog.add(new Urun("USB Bellek 64GB", 199.00));
    }

    // Katalogdaki ürünleri ekrana yazdırır
    private static void katalogListele() {
        System.out.println("\n--- KATALOG ---");
        for (int i = 0; i < katalog.size(); i++) {
            System.out.printf("%d) %s%n", (i + 1), katalog.get(i));
        }
        System.out.println("----------------");
    }

    // Kullanıcının sepete ürün eklemesini sağlar
    private static void sepeteEkle() {
        System.out.print("Ürün numarası ya da adı girin: ");
        String girdi = sc.nextLine().trim(); // Kullanıcıdan giriş alınır
        Urun secilen = null; // Seçilen ürünü geçici olarak tutacak değişken

        // Kullanıcı sayı girdiyse (örneğin 2), listedeki o sıradaki ürünü seç
        if (girdi.matches("\\d+")) {
            int idx = Integer.parseInt(girdi) - 1;
            if (idx >= 0 && idx < katalog.size()) secilen = katalog.get(idx);
        }
        // Eğer kullanıcı ürün adını girdiyse (örneğin "Mouse"), ada göre arama yap
        else {
            for (Urun u : katalog)
                if (u.getAd().equalsIgnoreCase(girdi)) secilen = u;
        }

        // Ürün bulunamazsa uyarı ver
        if (secilen == null) {
            System.out.println("Ürün bulunamadı.");
            return;
        }

        // Ürün bulunduysa sepete ekle
        sepet.ekle(secilen);
    }

    // Sepetten ürün çıkarma işlemi
    private static void sepettenCikar() {
        System.out.print("Çıkarılacak ürün adı: ");
        sepet.cikar(sc.nextLine().trim());
    }

    // Sepetteki ürünleri listeler
    private static void sepetiListele() {
        sepet.listele();
    }

    // Sepetteki toplam tutarı hesaplar ve ekrana yazdırır
    private static void toplamTutar() {
        System.out.printf("Sepet Toplamı: %.2f TL%n", sepet.toplamTutariHesapla());
    }

    // Ödeme işlemini simüle eder (kupon kodu varsa indirim uygular)
    private static void odeme() {
        double toplam = sepet.toplamTutariHesapla(); // Sepetin toplam tutarı alınır
        System.out.printf("Ara Toplam: %.2f TL%n", toplam);
        System.out.print("Kupon kodu (boş bırakmak için Enter): ");
        String kupon = sc.nextLine().trim();

        // Kupon kodu doğru girilmişse %10 indirim uygulanır
        if ("INDIRIM10".equalsIgnoreCase(kupon)) {
            toplam *= 0.90;
            System.out.println("Kupon uygulandı! %10 indirim.");
        }
        // Yanlış bir kod girildiyse kullanıcı uyarılır
        else if (!kupon.isBlank()) {
            System.out.println("Geçersiz kupon.");
        }

        // Son ödeme tutarını ve işlem sonucunu yazdırır
        System.out.printf("Ödenecek Tutar: %.2f TL%n", toplam);
        System.out.println("Ödeme işlemi tamamlandı (simülasyon).");
    }
}