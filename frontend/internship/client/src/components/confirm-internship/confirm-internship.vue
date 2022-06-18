<template>
  <Sidebar></Sidebar>
  <div style="padding:52px 52px 0px 52px;">
    <div class="col-xl-12 col-md-6">
      <table id="confirmInternships" class="table" style="width:100%">
        <thead>
        <tr>
          <th>Student Full Name</th>
          <th>Internship Day</th>
          <th>Start Date</th>
          <th>Finish Date</th>
          <th>Father Name</th>
          <th>Mother Name</th>
          <th>Birth Date</th>
          <th>Birth Place</th>
          <th>Health Coverge</th>
          <th>School Number</th>
          <th>Telephone</th>
          <th>Company Name</th>
          <th>Company Telephone</th>
          <th>Company Email</th>
        </tr>
        </thead>
        <tbody>
        <tr  v-for='(item, index) in confirmInternship' :key='index'>
          <th>{{item.studentResponseDTO.fullName}}</th>
          <th>{{item.internshipDay}}</th>
          <th>{{item.startDate}}</th>
          <th>{{item.finishDate}}</th>
          <th>{{item.studentIdentityResponseDTO.fatherName}}</th>
          <th>{{item.studentIdentityResponseDTO.motherName}}</th>
          <th>{{item.studentIdentityResponseDTO.birthDate}}</th>
          <th>{{item.studentIdentityResponseDTO.birthPlace}}</th>
          <th>{{item.studentIdentityResponseDTO.healthCovergeEnum}}</th>
          <th>{{item.studentResponseDTO.schoolNumber}}</th>
          <th>{{item.studentResponseDTO.telephone}}</th>
          <th>{{item.companyResponseDTO.companyName}}</th>
          <th>{{item.companyResponseDTO.companyPhone}}</th>
          <th>{{item.companyResponseDTO.companyEmail}}</th>
        </tr>
        </tbody>
        <tfoot>
        <tr>
          <th>Student Full Name</th>
          <th>Internship Day</th>
          <th>Start Date</th>
          <th>Finish Date</th>
          <th>Father Name</th>
          <th>Mother Name</th>
          <th>Birth Date</th>
          <th>Birth Place</th>
          <th>Health Coverge</th>
          <th>School Number</th>
          <th>Telephone</th>
          <th>Company Name</th>
          <th>Company Telephone</th>
          <th>Company Email</th>
        </tr>
        </tfoot>
      </table>
    </div>
  </div>
</template>

<script>

import Sidebar from "@/components/sidebar/Sidebar";
import axios from "axios";
import SuccusResult from "@/assets/succus.result";
import {BASE_URL} from "@/services/config";
import $ from "jquery";

export default {
  name: 'ConfirmInternships',
  components: {Sidebar},
  data(){
    return{
      confirmInternship : [],
    }
  },
  created() {
    this.getConfirmInternships()
  },
  methods:{
    getConfirmInternships(){
      axios({
        method:'GET',
        url:BASE_URL+'internship/approved/all',
        headers: {
          'Authorization': localStorage.getItem("token")
        }
      }).then(response =>{
        this.confirmInternship = response.data;

      }).then(
          this.dataTable
      )
          .catch(e =>{
            SuccusResult.methods.alertError("Oops something went wrong please try again later");
          })
    },
    dataTable() {
      $(document).ready(function () {
        $('#confirmInternships').dataTable({
          orderCellsTop: true,
          initComplete: function () {
            this.api().columns().every(function () {
              var column = this;
              var select = $('<select  class="browser-default custom-select form-control-sm"><option value="" selected>Search</option></select>')
                  .appendTo($(column.footer()).empty())
                  .on('change', function () {
                    var val = $.fn.dataTable.util.escapeRegex(
                        $(this).val()
                    );
                    column
                        .search(val ? '^' + val + '$' : '', true, false)
                        .draw();
                  });
              column.data().unique().sort().each(function (d, j) {
                select.append('<option value="' + d + '">' + d + '</option>')
              });
            });
          }
        });
      });
    }
  }
}
</script>
<style>
</style>
