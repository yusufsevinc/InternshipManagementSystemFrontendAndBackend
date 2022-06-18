<template>
  <Sidebar/>
  <div style="padding:52px 52px 0px 52px;">
    <div class="col-xl-12 col-md-6">

    <form class="text-center">

      <div class="row col-xl-5 mt-md-5">
        <div class="alert alert-info" role="alert" style="font-size: 30px ; width: 1000px">
          Company Create
        </div>
      </div>

        <div class="row col-xl-4 mt-md-5">
          <input v-model="companyName" required type="text" class="form-control" placeholder="Company Name">
        </div>
        <div class="row col-xl-4 mt-md-5">
          <input v-model="companyEmail" required type="text" class="form-control" placeholder="Company Email">
        </div>
        <div class="row col-xl-4 mt-md-5">
          <input v-model="companyPhone" required type="text" class="form-control" placeholder="Company Phone">
        </div>

        <div class="row col-xl-4 mt-md-5">
          <input v-model="companyStreetName" required type="text" class="form-control" placeholder="Company Street Name">
        </div>
        <div class="row col-xl-4 mt-md-5">
          <input v-model="companyApartmentNo" required class="form-control" placeholder="Company Apartment No">
        </div>
        <div class="row col-xl-auto mt-md-5">
          <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Company City Name </label>
          <select required  v-model="companyCityId" @change="changeCity($event)"  class="custom-select my-1 mr-sm-2" id="cityName">
            <option v-for="cityName in cities" :value="cityName.cityKey">{{ cityName.cityName}}</option>

          </select>
        </div>
        <div class="row col-xl-auto mt-md-5">
          <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Company District Name </label>
          <select required v-model="companyDistrictId" class="custom-select my-1 mr-sm-2"  @change="changeDistrict($event)" id="districtName">
            <option v-for="districtName in districts" :value="districtName.districtKey">{{ districtName.districtName}}</option>
          </select>
        </div>
        <div class="row col-xl-auto mt-md-5">
          <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Company Neighborhood Name </label>
          <select required v-model="companyNeighborhoodId" class="custom-select my-1 mr-sm-2" id="neighborhoodName">
            <option v-for="neighborhoodName in neighborhoods" :value="neighborhoodName.neighborhoodKey">{{ neighborhoodName.neighborhoodName}}</option>
          </select>
        </div>
      <div class="row col-xl-auto ">
        <div style="padding-right:52px; margin-top: 52px">
          <a @click="createAddress" class="btn btn-outline-info">Create</a>
        </div>
      </div>
    </form>
    </div>
  </div>
</template>

<script>
import {cityAll} from "@/services/city.service";
import {getAllCityDistrict} from "@/services/district.service";
import {getNeighborhoodDistrictAll} from "@/services/neighborhood.service";
import {saveAddress} from "@/services/address.service";
import {saveCompany} from "@/services/company.service";
import Sidebar from '@/components/sidebar/Sidebar'

export default{
  name:'CompanyCreate',

  components:{Sidebar},
  data(){
    return{
      companyName:null,
      companyEmail:null,
      companyPhone:null,
      companyStreetName:null,
      companyCityId:null,
      companyDistrictId:null,
      companyApartmentNo:null,
      companyNeighborhoodId:null,
      cityId:null,
      addressId : null,
      districtId:null,
      cities:[],
      districts:[],
      neighborhoods:[]
    }
  },
  created() {
    this.getCities();
  },
  methods:{
    variable(){

      console.log(this.companyName);
      console.log(this.companyEmail);
      console.log(this.companyPhone);
      console.log(this.companyCityId);
      console.log(this.companyDistrictId);
      console.log(this.companyNeighborhoodId);
      console.log(this.companyApartmentNo);
      console.log(this.companyStreetName);


    },
    createCompany(){
      var createCompnayData ={
        companyName : this.companyName,
        companyPhone : this.companyPhone,
        companyEmail : this.companyEmail,
        enabled : true,
        addressId : this.addressId
      };

    saveCompany(createCompnayData).then();

    },
    createAddress(){
      var addressData = {
        apartmentNo : this.companyApartmentNo,
        addressEnabled:true,
        streetName : this.companyStreetName,
        cityKey : this.companyCityId,
        districtKey : this.companyDistrictId,
        neighborhoodKey : this.companyNeighborhoodId
      };

      saveAddress(addressData).then(response =>{
        this.addressId = response.addressId;
        this.createCompany();
        this.companyNeighborhoodId = null;
        if (response != null){
          this.$router.push('/companies')
        }
      });
    },
    getCities(){
      cityAll().then(response =>{
        this.cities = response.data;
      });
    },
    getDistrict(){
      getAllCityDistrict(this.companyCityId).then(response =>{
        this.districts = response.data;
      });
    },
    getNeighborhood(){
      getNeighborhoodDistrictAll(this.companyDistrictId).then(response =>{
        this.neighborhoods = response.data;
      });
    },
    changeCity(event) {
      this.companyCityId = event.target.value;
      this.getDistrict();
      console.log(this.companyCityId)
    },
    changeDistrict(event){
      this.companyDistrictId = event.target.value;
      this.getNeighborhood();
      console.log(this.companyDistrictId)

    }
  }
}
</script>

<style>
</style>
