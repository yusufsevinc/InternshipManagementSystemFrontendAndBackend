<template>

  <div class="back" style="background-color: #2f855a;position:  absolute; top: 0; right: 0; bottom: 0; left: 0; ">

      <div class="card container" style="margin-top: 150px;width: 450px;">
        <div class="card-body " >
          <img src="../../assets/200x200.png" class="mt-xl-5 mb-xl-5">
          <p class="font-weight-bold">Internship Management System</p>
          <form class=" container" style="align-content: center;alignment-baseline: center;">
            <div class="form-group">
              <input type="email" v-model="emailForm" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
            </div>
            <div class="form-group mt-xl-5">
              <input type="password" v-model="passwordForm" class="form-control" id="exampleInputPassword1" placeholder="Password">
            </div>
            <a @click="login" class="btn btn-outline-primary  btn-lg" style="margin-bottom: 70px; margin-top: 40px; border-radius: 40px;: lightblue">Login</a>
          </form>
        </div>
        <p style="color:#000;">Follow us on our social media accounts.</p>

        <div class="mb-xl-4 row" style="align-items: center;">
            <a href="https://www.instagram.com/etukurumsal/" target="_blank" class="btn btn-link"><i class="fa-brands fa-instagram" style="font-size:30px;"></i></a>
            <a href="https://www.facebook.com/erzurumteknik" target="_blank" class="btn btn-link"><i class="fa-brands fa-facebook"  style="font-size:30px;"></i></a>
            <a href="https://mobile.twitter.com/etukurumsal" target="_blank" class="btn btn-link"><i class="fa-brands fa-twitter" style="font-size:30px;"></i></a>
            <a href="https://www.youtube.com/channel/UCiEE3z1rsohJF6QQcnobEAg" target="_blank" class="btn btn-link"><i class="fa-brands fa-youtube"  style="font-size:30px;"></i></a>

        </div>
      </div>
    <p style="color: #0c0c0c;" class="font-weight-bold">Erzurum Technical University Computer Engineering Graduation Project</p>
    </div>


</template>

<script>
import axios from "axios";
import {BASE_URL} from "@/services/config";
import SuccusResult from "@/assets/succus.result";

export default {
  name: 'LoginComponent',
  components: {},
  data() {
    return {
      image: "https://erzurum.edu.tr/Content/resim_galeri_kategori/image/55ef7a0b-84a4-4dd4-9cad-16204f994d84.jpg",
      emailForm:null,
      passwordForm : null
    }
  },
  methods: {
    login() {
      var loginData = {
        email : this.emailForm,
        password : this.passwordForm
      };
      axios({
        url:BASE_URL+'auth/login',
        method:'POST',
        data : loginData,
      }).then( response =>{
        console.log("başarılı");
        SuccusResult.methods.alertSuccess("Welcome " + response.data.fullName);
        localStorage.setItem("token",response.data.token);
        localStorage.setItem("email",response.data.email);
        localStorage.setItem("userId",response.data.id);
        localStorage.setItem("fullName",response.data.fullName);
        localStorage.setItem("role",response.data.role);
        localStorage.setItem("uploadFile1",'true')
        localStorage.setItem("uploadFile2",'true')

        if (localStorage.getItem('role') == 'STUDENT'){
          this.$router.push('/')

        }else if (localStorage.getItem('role') == 'SECRETARY'){
          this.$router.push('/confirm-internships')

        }else {
          this.$router.push('/applied-internships')

        }
      }).catch(e =>{
        console.log("hata");
        SuccusResult.methods.alertError("Email or password is incorrect");
      });
    }
  }
}
</script>
<style>
.back {
  background: url('https://erzurum.edu.tr/Content/resim_galeri_kategori/image/55ef7a0b-84a4-4dd4-9cad-16204f994d84.jpg');
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}

</style>
