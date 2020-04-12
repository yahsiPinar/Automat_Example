# Bir Otomat Örneği

**NOT:Proje tanımı src.pdf dosyasında verilmişir.**

Problem bir otomatı tanımladığı için State Design Pattern tercih edilmiştir. Bu projede 4 state vardır: Initial state, Buying state, Exit state, Quit state. 

  **1. Initial State:** Bu state otomatın başlangıç/bekleme durumunu temsil eder. Herhangi bir kullanıcı bakiyesi ile işleme başlamak üzere olabilir veya herhangi bir kullanıcı yok ise makinenin bekleme durumunu temsil eder. Bu sebeple 2 farklı constructor kullanılmıştır. Makinenin bekleme durumunu sağlayan ve kullanıcının pasif olduğu durum için bakiyenin takibini sağlayan ikinci bir constructor daha eklenmiştir. 
  
  **2. Buying State:** Bu aşamada kullanıcı ürün seçimini yapmış, makineye gerekli miktarı atmıştır. Ürün bilgisi, ürünün maliyeti ve kullanıcının bakiyesi ile işlem yapılır. Kullanıcı ürünü satın aldıktan sonra eğer hiç bakiyesi kalmamışsa işlem sonlandırılır ve makine bekleme durumuna geçerek Initial State'e geri döner. Satın alma işlemi tamamlandıktan sonra kullanıcının hala bakiyesi var ise makine kalan bakiye ile bir başka state olan Exit State'e geçiş yapar.
  
  **3. Exit State:** Kullanıcıya kalan bakiyesi ile işlem yapıp yapmak istemediği sorulur. Kullanıcı işlemine devam etmek isterse bakiyesi ile birlikte yeniden Initial State'e aktarılır. Eğer kullanıcı işleme devam etmek istemez ise para üstü iade edilir ve makine bekleme konumuna geçer.
  
  **4. Quit State:** Bu aşamada kullanıcının işleme başladıktan sonra vazgeçmek isterse, bu isteği doğrulamak için son defa çıkış yapmaktan emin olup olmadığı sorulur. Eğer emin ise ücret iadesi yapılır ve makine bekleme konumuna geçer. Eğer çıkış yapmaktan vazgeçerse, var ise kullanıcı mevcut bakiyesi korunarak Initial state'e aktarılır. 
  
**Kullanılan classlar ve açıklamaları**

**Product:** Product sınıfı ilerleyen zamanlarda makinedeki ürün çeşitliliği artırılmak istenirse diye abstract bir sınıf olarak tanımlanmıştır. Bu sınıfta ürünün isim ve fiyat bilgileri bulunmaktadır. Getter metodları tanımlanmış fakat küçük bir proje olduğu için kullanmaya gerek duyulmamıştır.

**Coke-Fanta-Soda:** Coke-Fanta-Soda sınıfları sırası ile problemde belirtilen Kola-Fanta-Gazoz birimlerini temsil etmektedir. İsim ve fiyat bilgilerini kendilerine özgü şekilde tanımlar. Product sınıfını inherit ederler.

**Machine:** Bu sınıf makinenin kendisini temsil etmektedir. Aynı zamanda State Design pattern'daki Context sınıfını temsil etmektedir. Makinenin yönlendirilmesine yardımcı bir state değişkenini tutar ve çeşitli metodlar barındırır. Bunlardan biri setState() metodudur. Bu metod makinenin state'ini değiştirmesini sağlar ve her durum değişimi yaşandığında HandleState() isminde bir fonksiyonu uyarır(bu metottan ilgili sınıfta bahsedilecektir). Bir diğer metod ise RequestProduct()'tır. Kullanıcı UI'dan bir satın alma talebinde bulunduğunda arka planda talebi oluşturan ve akışı başlatan ksımdır. Burada kullanıcının bakiyesi kontrol edilir. Eğer yeterli ise satın alma durumuna geçiş sağlanır(Buying State). Yeterli değil ise kullanıcıya bir uyarı yapılır. 

**Coins:** Burada makinenin kabul edebildiği/geçerli olan para birimleri ve her bir paradan kaç adet olduğu tanımlıdır. Başlangıç durumu olarak tüm paralardan yüzer adet olduğu kabul edilmiştir. Bu bilgiler HashMap tipi ile tutulur. İçerdiği metodlardan ilki increaseCoinValue()'dur. Bir kullanıcı satın alma işlemi yaptığında sisteme bir para girişi sağlamıştır. Bu durumda ilgili paraların stoğu arttırılır. Bir diğer metod decreaseCoinValue()'dur. Kullanıcıya yaptığı satın alma işlemi sonrasında para iadesi yapılmaktadır. Dolayısıyla ödenen iade oranında makinedeki ilgili paraların stoğuda azaltılmalıdır. Burada bu işlem sağlanır. Son metod findChange()'dir. Satın alma işlemi yapılırken kullanıcının ödediği ücretin tam(yani ürün fiyatı ile bire bir) olmadığı durumlarda yapılacak para iadesinin belirlenmesi burada sağlanır. Ücret iadesi yapılırken minimum sayıda paranın kullanılacağı kombinasyon bulunur ve iade bu kombinasyona göre yapılır. 

**MachineState:** Bu sınıf bir interfacedir. Makinenin durum değişimleri içerisinde barındırdığı HandleState() metodu ile kontrol edilmektedir. Bu metod bu interface'i uygulayan tüm sınıflar tarafından kendilerine özgü şekilde override edilir. State değişimlerini sağlayan kemik birim burasıdır. 

**DİKKAT EDİLMESİ GEREKEN HUSUSLAR**

**1.** Makineye para girişi "EKLE" butonu yardımı ile günlük hayatımızdaki otomatlar gibi tek tek sağlanmalıdır. 

**2.** Makineden her defasında tek bir ürün alınabilir. 

**3.** Ürünlerin stokları infinite kabul edilmiştir. 

**4.** Eğer Java versiyonunuz 10'dan düşük ise File->Project Structure->Modules->Language Level yolunu takip ederek Language Leveli kendi java versiyonunuza göre ayarlayınız. 

**5.** .jar dosyası target klasörünün içerisindedir.

