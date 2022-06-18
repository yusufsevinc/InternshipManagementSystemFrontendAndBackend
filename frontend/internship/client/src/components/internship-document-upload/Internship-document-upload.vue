<template>
  <Sidebar></Sidebar>
  <div style="padding:52px 52px 0px 52px;">
    <div class="container">
  <form>
    <div class="row col-xl-12 mt-md-5 text-center">
      <div class="alert alert-info" role="alert" style="font-size: 30px ; width: 1000px">
        TRANSCRIPT and INTERNSHIP FORM UPLAOD
      </div>
    </div>
    <div class="row mt-md-5" v-if="uploadFile1 == 'true'">
      <div class="form-group col-md-5">
        <p class="fileClass">Upload the Internship Application file :</p>

      </div>
      <div class="form-group col-md-5">
        <input  type="file"   v-on:change="onChangeFileUpload1()" ref="fileInput1" />
      </div>
      <div class="form-group col-md-1">
        <a  @click="submitForm1" class="btn btn-outline-info">Upload</a>
      </div>
    </div>

    <div class="row mt-xl-5" v-if="uploadFile2 == 'true'">
      <div class="form-group col-md-5">
        <p class="fileClass">Upload the Transcript file :</p>

      </div>
      <div class="form-group col-md-5" >
        <input  type="file"    v-on:change="onChangeFileUpload2()" ref="fileInput2">
      </div>
      <div class="form-group col-md-1">
        <a  @click="submitForm2" class="btn btn-outline-info">Upload</a>
      </div>
    </div>

  </form>
    </div>
  </div>
</template>
<script>
import axios from 'axios';
import {BASE_URL} from "@/services/config";
import SuccusResult from "@/assets/succus.result";
import Sidebar from '@/components/sidebar/Sidebar'

export default{
  name:'InternshipDocumentUpload',
  components:{Sidebar},
  data(){
    return{
      uploadFile1 : localStorage.getItem("uploadFile1"),
      uploadFile2 : localStorage.getItem("uploadFile2"),
      fileName1 :null,
      file1 : null,
      fileName2 :null,
      file2 : null,
      fileType1:null,
      fileType2:null,
      formData1:new FormData(),
      formData2:new FormData(),

      approved:{
        commission : true,
        assistantDean : true,
        headOfDepartment : true
      },
      enabled : true,



    }
  },
  methods: {
    submitForm1(){
      axios({
        url:BASE_URL+'internship-document/save2',
        method:'POST',
        headers: {
          'Authorization': localStorage.getItem("token")
        },

        data:this.formData1
      }).then(response =>{
        SuccusResult.methods.alertSuccess("Saved");
        this.formData1 = new FormData();
        this.fileType1 = null;
        this.fileInput1 = null;
        localStorage.setItem("uploadFile1",'false');
        location.reload();
      }).catch(e =>{
        SuccusResult.methods.alertError("Un Saved!");
      })
    },
    submitForm2(){
      axios({
        url:BASE_URL+'internship-document/save2',
        method:'POST',
        headers: {
          'Authorization': localStorage.getItem("token")
        },
        data:this.formData2
      }).then(response =>{
        SuccusResult.methods.alertSuccess("Saved");
        localStorage.setItem("uploadFile2",'false')
        this.formData2 = new FormData();
        this.fileInput2 = null;
        this.file2 = null;
        location.reload();
      }).catch(e =>{
        SuccusResult.methods.alertError("Un Saved!");
      })
    },
    onChangeFileUpload1(){
      let internship = {
        approvedId : this.approved,
        enabled : this.enabled

      };
      let file = this.$refs.fileInput1.files[0];
      this.formData1.append('file', file);
      this.formData1.append("title","INTERNSHIP_APPLICATION_FORM")
      this.formData1.append("studentId",localStorage.getItem("userId"))
    },
    onChangeFileUpload2(){
      let internship = {
        approvedId : this.approved,
        enabled : this.enabled

      };
      var file = this.$refs.fileInput2.files[0];
      this.formData2.append('file', file);
      this.formData2.append("title","TRANSCRIPT")
      this.formData2.append("studentId",localStorage.getItem("userId"))

    }
}
}
</script>

<style>

</style>
