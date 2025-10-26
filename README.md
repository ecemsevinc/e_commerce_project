# E-TİCARET SEPET UYGULAMASI 

Bu proje, Nesneye Yönelik Programlama (OOP) ilkelerini uygulayarak geliştirilmiş, konsol tabanlı bir alışveriş sepeti simülasyonudur. Uygulama, temel e-ticaret süreçlerini (ürün yönetimi, sepet işlemleri ve hesaplama) simüle ederken, Java dilinde OOP kavramlarının nasıl kullanıldığını göstermeyi amaçlamaktadır.

## Proje Amaçları ve Kullanılan OOP Kavramları

Proje,aşağıdaki dört temel OOP ilkesini kod içinde somutlaştırmaktadır:

| OOP Kavramı | Uygulama Yeri |
| :--- | :--- |
| **Kapsülleme** | `Urun` ve `Sepet` sınıflarındaki `private` değişkenler ve `public` getter metotları. |
| **Soyutlama** | `SepetIslemleri` Interface'inin (Arayüzünün) kullanılması. |
| **Kalıtım** | `IndirimliUrun` sınıfının `Urun` sınıfından türetilmesi (`extends`). |
| **Çok Biçimlilik (Polimorfizm)**| `IndirimliUrun` sınıfında `getFiyat()` ve `toString()` metotlarının yeniden yazılması (`@Override`). |

## Proje Yapısı ve Dosyalar

Proje, `ecommerce` paketi altında yer alan temel sınıflardan oluşur:

* **Main.java:** Uygulamanın ana döngüsü, konsol menüsü ve kullanıcı girişlerinin yönetimi.
* **Urun.java:** Temel ürün nesnesi tanımı. Kapsüllemeyi gösterir.
* **IndirimliUrun.java:** `Urun` sınıfından kalıtım alır ve indirimli fiyat hesaplaması ile Polimorfizmi gösterir.
* **Sepet.java:** Sepet yönetimini ve hesaplama mantığını içerir. `SepetIslemleri` arayüzünü uygular.
* **SepetIslemleri.java:** Sepetin zorunlu işlevlerini tanımlayan arayüz (Soyutlama).

### Ekran Çıktısı
 Uygulama çalıştırıldığında oluşan konsol görüntüsü için ekran görüntüsüne göz atabilirsiniz.

## Kurulum ve Çalıştırma

Bu uygulama standart Java ortamında çalışır ve herhangi bir ek bağımlılık gerektirmez.

### Ön Koşullar

* Java Development Kit (JDK) kurulu olmalıdır (Tercihen Java 17 veya üzeri).

### Çalıştırma Adımları

1.  **Depoyu Klonlayın** veya indirin.
2.  **IDE'de Açın:** Proje dosyalarını (Main.java, Urun.java vb.) IntelliJ IDEA veya Eclipse gibi bir geliştirme ortamında açın.
3.  **Çalıştırın:** `Main.java` dosyasını ana sınıf olarak belirleyip uygulamayı çalıştırın.

