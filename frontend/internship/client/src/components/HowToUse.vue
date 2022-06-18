<template>
  <Sidebar></Sidebar>
  <div class="hello">
    <div style="margin-top: 40px">
    <h2 style="font-weight: bold;">Değerli Öğrencimiz <span style=" color: rgba(255,47,25,0.95)">{{fullName}}</span> Staj Yönetim Sistemine Hoş Geldiniz (-_-)</h2>

      <h3 style="font-weight: bold;margin-top: 50px">Staj Sistemi Nedir ?</h3>
      <div style="padding-left: 90px;padding-right: 90px; margin-top: 25px;">
        <p> Staj akademik kariyer devam ederken öğrencilik hayatında öğrenilen bilgilerin, iş dünyasında “pratikte” uygulanmasını sağlayan çalışma şekline verilen isimdir. Staj sayesinde eğitimini tamamlamak üzere olan öğrenciler iş hayatına daha hızlı bir şekilde adapte sağlar.</p>
      <p> Şunu biliyoruz ki yeni mezun biri için iş dünyası büyük bir okyanustur. İlk iş günü sanki onca yıl siz değil de bir başkası okumuş gibi bir hissin oluşması da klasiktir. Öğrencilik hayatında öğretilen her bilgi değerlidir ancak bu değeri iş hayatına katmak da ayrı bir meziyettir.</p>
      <p> Okulda öğrenilenlerin iş hayatına kusursuz adapte olması ile başarı kaçınılmazdır. İlk iş gününde ortamdan, işten ve hatta sektörden bu kadar uzak olmamak için staj iyi bir adımdır. Bazen staj yapmanın göz ardı edildiği durumlar olabilir ancak ilk iş günü size verilen işi daha önce deneyimlemiş olmanın verdiği özgüven de en büyük kazancınız olacaktır. </p>
      </div>

      <h3 style="font-weight: bold;margin-top: 50px">Staj Yönetim Sistemi Sitesi Nasıl Kullanılır ?</h3>

    </div>
    <div style="padding-left: 90px;padding-right: 90px; margin-top: 25px;">
      <ul>
        <li>
          <p>
            <span style="font-weight: bold; font-size: 25px;">*</span>
            Sol menüde bulunan <span style="font-weight: bold;">Internship File Upload</span> tıklayın.</p>
        </li><br>
        <li>
          <p>
            <span style="font-weight: bold; font-size: 25px;">*</span>
            Sayfada istenilen evraklarını sisteme yükleyin.</p>
        </li><br>
        <li>
          <p>
            <span style="font-weight: bold; font-size: 25px;">*</span>
            Evrakları sisteme yükledikten sonra sol menüde <span style="font-weight: bold;">Internship Create</span>
          kısmı aktif olacaktır.</p>
        </li><br>
        <li>
          <p>
            <span style="font-weight: bold; font-size: 25px;">*</span>
             Sol menüde bulunan <span style="font-weight: bold;">Internship Create</span> tıklayın ve formu doldurduktan sonra
            <span style="font-weight: bold;">Create</span> tıklayın ve bu kadar bitti.</p>
        </li><br>
      </ul>
    </div>

  </div>
</template>

<script>
import Sidebar from "@/components/sidebar/Sidebar";
export default {
  name: "HelloWorld",
  components:{Sidebar},
  props: {
    msg: String,
  },
  data(){
    return{
      fullName: localStorage.getItem("fullName")
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
p{
  color: #0c0c0c;
  font-size: 20px;
}
</style>
