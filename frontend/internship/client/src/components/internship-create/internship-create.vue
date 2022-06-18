<template>
  <Sidebar></Sidebar>
  <div class="col-xl-10 mt-xl-5 container">

    <form>
      <div class="card">
        <div class="card-body p-xl-5">
          <p class="h5 card-title mb-5 font-weight-bold">Internship Info</p>
          <div class="row">
            <div class="col-md-6 mb-3">
              <label for="internshipDay">Internship Day </label>
              <input type="number" v-model="internshipDayForm" class="form-control" min="20" max="60" id="internshipDay" placeholder="Minimum 20 day Maximum 60 day" required>
            </div>
            <div class="col-md-6 mb-3">
              <label for="is3rdGrade">Are you taking classes from 3rd grade?</label>
              <div><select v-model="isThirdLessonForm" class="custom-select" id="is3rdGrade" required>
                <option selected disabled value="">Choose...</option>
                <option value="true">Yes</option>
                <option value="false">No</option>
              </select></div>
            </div>
          </div>

          <div class="row mt-xl-5">
            <div class="col-md-6 mb-3">
              <label for="startDate">Internship Start Date </label>
              <div>
              <input type="date" v-model="startDateForm" @change="startDateChange($event)" id="startDate" name="StartDate" required>
            </div></div>

            <div class="col-md-6 mb-3">
                <label for="finishDate">Internship Finish Date </label>
              <div>
                <input type="date" v-model="finishDateForm" @change="finishDateChange($event)" id="finishDate" name="FinishDate" required>
            </div>
            </div>
          </div>
        </div>
      </div>

      <div class="card mt-xl-5">
        <div class="card-body p-xl-5">
          <p class="h5 card-title mb-5 font-weight-bold">Company Info</p>
          <div class="row">
            <div class="col-md-6 mb-3">
              <label for="companyName">Company Name</label>
              <input type="text" v-model="companyNameForm" class="form-control" id="companyName" placeholder="Sevinc" required>
            </div>
            <div class="col-md-3 mb-3">
            <label for="companyEmail">Company Email</label>
            <input type="email" v-model="companyEmailForm" class="form-control" id="companyEmail" placeholder="Example : sevinc@gmail.com" required>
          </div>
            <div class="col-md-3 mb-3">
              <label for="companyPhone">Company Phone</label>
              <input type="number" v-model="companyPhoneForm" class="form-control" id="companyPhone" placeholder="Example : 5369807142" required>
            </div>
          </div>
          <div class="row mt-xl-5">
            <div class="col-md-6 mb-3">
              <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Company Street Name </label>
              <input v-model="streetNameForm"  type="text" class="form-control" placeholder="Company Street Name" required>
            </div>
            <div class="col-md-6 mb-3">
              <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Company Apartment No </label>
              <input v-model="apartmentNoForm"  class="form-control" placeholder="Company Apartment No" required>
            </div>
          </div>
          <div class="row mt-xl-5">
            <div class="col-md-auto mb-3">
              <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Company City Name </label>
              <select required  v-model="companyCityId" @change="changeCity($event)"  class="custom-select my-1 mr-sm-2" id="cityName" >
                <option v-for="cityName in cities" :value="cityName.cityKey">{{ cityName.cityName}}</option>

              </select>
            </div>
            <div class="col-md-auto mb-3">
              <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Company District Name </label>
              <select required v-model="companyDistrictId" class="custom-select my-1 mr-sm-2"  @change="changeDistrict($event)" id="districtName" >
                <option v-for="districtName in districts" :value="districtName.districtKey">{{ districtName.districtName}}</option>
              </select>
            </div>
            <div class="col-md-auto mb-3">
              <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Company Neighborhood Name </label>
              <select required v-model="companyNeighborhoodId" class="custom-select my-1 mr-sm-2" id="neighborhoodName">
                <option v-for="neighborhoodName in neighborhoods" :value="neighborhoodName.neighborhoodKey">{{ neighborhoodName.neighborhoodName}}</option>
              </select>
            </div>
          </div>
        </div>
      </div>
      <div class="card mt-xl-5">
        <div class="card-body p-xl-5">
          <p class="h5 card-title mb-5 font-weight-bold">Company Executive Info</p>
          <div class="row">
            <div class="col-md-6 mb-3">
              <label for="companyExecutiveName">Name</label>
              <input type="text" v-model="companyExecutiveNameForm" class="form-control" placeholder="Yusuf" id="companyExecutiveName" required>
            </div>
            <div class="col-md-6 mb-3">
              <label for="companyExecutiveSurname">Surname</label>
              <input type="text" v-model="companyExecutiveSurnameForm" class="form-control" id="companyExecutiveSurname" placeholder="Sevinc" required>
            </div>
          </div>
          <div class="row mt-xl-5">
            <div class="col-md-6 mb-3">
              <label class="my-1 mr-2" for="companyExecutiveEmail">Email </label>
              <input type="email" v-model="companyExecutiveEmailForm" id="companyExecutiveEmail"  class="form-control" placeholder="Example : sevinc@gmail.com" required>
            </div>
            <div class="col-md-6 mb-3">
              <label class="my-1 mr-2" for="companyExecutivePhone">Phone </label>
              <input type="number" v-model="companyExecutivePhoneForm" id="companyExecutivePhone"  class="form-control" placeholder="Example : 5369807142" required>
            </div>
          </div>
          <div class="row mt-xl-5">
            <div class="col-md-12 mb-3">
              <label class="my-1 mr-2" for="companyExecutivePosition">Position </label>
              <input type="text" v-model="companyExecutiveTitleForm" id="companyExecutivePosition"  class="form-control" placeholder="Software Team Lead" required>
            </div>
          </div>
        </div>
      </div>
      <a @click="createInternship" class="btn btn-outline-info mt-xl-5">Create</a>
    </form>
  </div>
</template>

<script>

import {cityAll} from "@/services/city.service";
import {getAllCityDistrict} from "@/services/district.service";
import {getNeighborhoodDistrictAll} from "@/services/neighborhood.service";
import axios from "axios";
import {BASE_URL} from "@/services/config";
import SuccusResult from "@/assets/succus.result";
import Sidebar from '@/components/sidebar/Sidebar'

export default {
  name: 'InternshipCreate',
  components: {Sidebar},
  data() {
    return {
      accepted_dayForm:null,
      apartmentNoForm:null,
      cityKeyForm:null,
      districtKeyForm: null,
      neighborhoodKeyForm: null,
      streetNameForm: null,
      companyExecutiveEmailForm:null,
      companyExecutiveNameForm: null,
      companyExecutivePhoneForm: null,
      companyExecutiveSurnameForm: null,
      companyExecutiveTitleForm: null,
      companyEmailForm: null,
      companyNameForm:null,
      companyPhoneForm: null,
      startDateForm:null,
      finishDateForm:null,
      internshipDayForm: null,
      isThirdLessonForm: null,
      companyCityId:null,
      companyDistrictId:null,
      companyNeighborhoodId:null,
      cities:[],
      districts:[],
      neighborhoods:[],

      }
  },
  created() {
    this.getCities();
  },
  methods: {
    startDateChange(event) {
      this.startDate = event.target.value;
    },
    finishDateChange(event) {
      this.finishDate = event.target.value;
    },
    yazdir(){
      console.log("start Date: " + this.startDate);
      console.log("finishDate: "+this.finishDate);
      console.log(this.isThirdLessonForm);
      console.log(this.companyCityId);
      console.log(this.companyDistrictId);
      console.log(this.companyNeighborhoodId);

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

    },
    createInternship(){
      var  internshipData = {
        accepted_day: this.accepted_dayForm,
        addressSaveFullIdDTO: {
          addressEnabled: true,
          apartmentNo: this.apartmentNoForm,
          cityKey: this.companyCityId,
          districtKey: this.companyDistrictId,
          enabled: true,
          neighborhoodKey: this.companyNeighborhoodId,
          streetName: this.streetNameForm
        },
        companyExecutiveSaveIdDTO: {
          companyExecutiveEmail: this.companyExecutiveEmailForm,
          companyExecutiveName: this.companyExecutiveNameForm,
          companyExecutivePhone: this.companyExecutivePhoneForm,
          companyExecutiveSurname: this.companyExecutiveSurnameForm,
          companyExecutiveTitle: this.companyExecutiveTitleForm,
          enabled: true
        },
        companySaveIdDTO: {
          companyEmail: this.companyEmailForm,
          companyName: this.companyNameForm,
          companyPhone: this.companyPhoneForm,
          enabled: true
        },
        finishDate: this.finishDateForm,
        internshipDay: this.internshipDayForm,
        internshipDocumentId: 1,
        internshipEnabled: true,
        isThirdLesson: this.isThirdLessonForm,
        startDate: this.startDateForm,
        studentId: localStorage.getItem("userId")


      };
      axios({
        url:BASE_URL+'internship/save',
        method:'POST',
        headers: {
          'Authorization': localStorage.getItem("token"),
        },
        data:internshipData
      }).then(response =>{
        SuccusResult.methods.alertSuccess("Internship Saved!");

        if (response != null){
          this.$router.push('/')
        }
      }).catch(e =>{
        SuccusResult.methods.alertError("Un Saved!");
      })
    }
  }
}
</script>

<style>

.fileClass{
  font-weight: lighter;
  font-size: 23px;
}

input[type="file"] {
  cursor: pointer !Important;
  font: 300 14px sans-serif;
  color: red;
  font-weight: bold;
}
input[type="file"]::-webkit-file-upload-button
{
  font: 300 14px  sans-serif;

  background-color: #469dde;
  border-radius: 15px;
  border: 0;
  padding: 12px 25px;
  cursor: pointer;
  color: #1a1919;
  font-weight: bold;
  text-transform: uppercase;
}

input[type="file"]::-ms-browse {
  font: 300 14px 'Roboto', sans-serif;
  border: 0;
  padding: 12px 25px;
  cursor: pointer;
  color: #fff;
  text-transform: uppercase;
}

</style>

