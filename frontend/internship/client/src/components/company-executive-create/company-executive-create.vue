<template>
  <Sidebar></Sidebar>
  <div style="padding:52px 52px 0px 52px;">
    <div class="col-xl-12 col-md-6">
      <form>
        <div class="row col-xl-5 mt-md-5">
          <div class="alert alert-info" role="alert" style="font-size: 30px ; width: 1000px">
            Company Executive Create
          </div>
        </div>

        <div class="row col-xl-4 mt-md-5">
          <input v-model="name" type="text" class="form-control" placeholder="Name" required/>
        </div>
        <div class="row col-xl-4 mt-md-5">
          <input v-model="surname" type="text" class="form-control" placeholder="Surname">
        </div>
        <div class="row col-xl-4 mt-md-5">
          <input v-model="email" type="text" class="form-control" placeholder="Email">
        </div>

        <div class="row col-xl-4 mt-md-5">
          <input v-model="phone" type="text" class="form-control" placeholder="Phone">
        </div>
        <div class="row col-xl-4 mt-md-5">
          <input v-model="position" class="form-control" placeholder="Position">
        </div>
        <div class="row col-xl-auto mt-md-5">
          <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Company Name </label>
          <select v-model="companyId" class="custom-select my-1 mr-sm-2" id="cityName">
            <option v-for="companyName in companies" :value="companyName.companyId">{{ companyName.companyName }}
            </option>
          </select>
        </div>
        <div class="row col-xl-auto ">
          <div style="padding-right:52px; margin-top: 52px">
            <a @click="createCompanyExecutive"  class="btn btn-outline-info"
            >Create</a>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import {companyAll} from "@/services/company.service";
import {saveCompanyExecutive} from "@/services/company-executive.service";
import $ from 'jquery';
import Sidebar from '@/components/sidebar/Sidebar'

export default {
  name: 'CompanyExecutiveCreate',
  components: {Sidebar},
  data() {
    return {
      name: null,
      surname: null,
      email: null,
      phone: null,
      position: null,
      enabled: true,
      companyId: null,
      companies: [],
      response : null
    }
  },
  created() {
    this.getCompanies();
  },
  methods: {
    variable() {
      console.log(this.name);
      console.log(this.surname);
      console.log(this.email);
      console.log(this.phone);
      console.log(this.position);
      console.log(this.enabled);
      console.log(this.companyId);
    },
    getCompanies() {
      companyAll().then(response => {
        this.companies = response.data;
      });
    },
    createCompanyExecutive(){
      var createCompanyExecutive = {
        companyExecutiveName:this.name,
        companyExecutiveSurname:this.surname,
        companyExecutiveEmail:this.email,
        companyExecutiveTitle:this.email,
        companyExecutivePhone:this.phone,
        enabled:this.enabled,
        companyId:this.companyId
      };

    saveCompanyExecutive(createCompanyExecutive).then(
        response =>{
         this.response = response;
         if (response != null){
           this.$router.push('/company-executives')
         }
        });
      date();
    }
  }
}
</script>

<style>
</style>
