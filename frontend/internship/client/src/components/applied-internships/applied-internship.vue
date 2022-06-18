<template>
  <Sidebar></Sidebar>
  <div style="padding:52px 52px 0px 52px;">
    <div class="col-xl-12 col-md-6">
      <table id="internships" class="table" style="width:100%">
        <thead>
        <tr>
          <th>Student Full Name</th>
          <th>Internship Day</th>
          <th>Start Date</th>
          <th>Finish Date</th>
          <th>Is Third Lesson</th>
          <th>Company Name</th>
          <th>Company Executive Full Name</th>
          <th>Transcript</th>
          <th>Internship Application File</th>
          <th>Internship Book</th>
          <th>Commission</th>
          <th>Head of Department</th>
          <th>Dean</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for='(item, index) in internships' :key='index'>
          <th>{{item.studentResponseDTO.fullName}}</th>
          <th>{{item.internshipDay}}</th>
          <th>{{item.startDate}}</th>
          <th>{{item.finishDate}}</th>
          <th>{{item.isThirdLesson}}</th>
          <th>{{item.companyResponseDTO.companyName}}</th>
          <th>{{item.companyExecutiveResponseDTO.companyExecutiveName }}  {{item.companyExecutiveResponseDTO.companyExecutiveSurname }}</th>

          <th v-if="(item.transcriptFile) !== null" ><button type="button" class="btnCss" @click="downloadFile(item.transcriptFile.internshipDocumentId)">Open File</button></th>
          <th v-else>Not Loaded</th>
          <th v-if="(item.applicationFile) !== null" ><button type="button" class="btnCss" @click="downloadFile(item.applicationFile.internshipDocumentId)">Open File</button></th>
          <th v-else>Not Loaded</th>
          <th v-if="(item.bookFile) !== null" ><button type="button" class="btnCss" @click="downloadFile(item.bookFile.internshipDocumentId)">Open File</button></th>
          <th v-else>Not Loaded</th>


          <th v-if="(item.approvedResponseDTO.commission) === false" ><button :disabled="role !== 'COMMISSION'" type="button" style="background-color:#3aa8ff" class="btnCss" @click="updateApproved(item.approvedResponseDTO.approvedId,'commission')">Confirm</button></th>
          <th v-else>Approved</th>
          <th v-if="(item.approvedResponseDTO.headOfDepartment) === false" ><button :disabled="role !== 'HEAD_OF_DEPARTMENT'" style="background-color:#438aff" type="button" class="btnCss" @click="updateApproved(item.approvedResponseDTO.approvedId,'headOfDepartment')">Confirm</button></th>
          <th v-else>Approved</th>
          <th v-if="(item.approvedResponseDTO.assistantDean) === false" disabled ><button :disabled="role !== 'DEAN'" type="button" style="background-color: #3561ff" class="btnCss" @click="updateApproved(item.approvedResponseDTO.approvedId,'assistantDean')">Confirm</button></th>
          <th v-else>Approved</th>

        </tr>
        </tbody>
        <tfoot>
        <tr>
          <th>Student Full Name</th>
          <th>Internship Day</th>
          <th>Start Date</th>
          <th>Finish Date</th>
          <th>Is Third Lesson</th>
          <th>Company Name</th>
          <th>Company Executive Name</th>
          <th>Transcript</th>
          <th>Internship Application File</th>
          <th>Internship Book</th>
          <th>Commission</th>
          <th>Head of Department</th>
          <th>Dean</th>
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
  name: 'AppliedInternships',
  components: {Sidebar},
  data(){
    return{
      internships : [],
      role:localStorage.getItem('role')
    }
  },
  created() {
    this.getInternships()
  },
  methods:{
    downloadFile(fileId){
      console.log(localStorage.getItem('role'))
    axios({
      method:'GET',
      url:BASE_URL+'internship-document/download/'+fileId,
      responseType:"arraybuffer",
      headers: {
        'Authorization': localStorage.getItem("token")
      }
    }).then(response =>{
            var file = new Blob([response.data], {type: 'application/pdf'});
            var fileURL = URL.createObjectURL(file);
            window.open(fileURL);
      }).catch(e=>{
      SuccusResult.methods.alertError("Oops something went wrong please try again later");
    })
    },
    getInternships(){
      axios({
        method:'GET',
        url:BASE_URL+'internship/all',
        headers: {
          'Authorization': localStorage.getItem("token")
        }
      }).then(response =>{
        this.internships = response.data;

      }).then(
          this.dataTable
      )
          .catch(e =>{
            SuccusResult.methods.alertError("Oops something went wrong please try again later");
      })
    },
    updateApproved(id,type){
      console.log("update çalıştı")
      axios({
        method:'PUT',
        url:BASE_URL+'approved/update/'+type+'/'+id,
        headers: {
          'Authorization': localStorage.getItem("token")
        }
      }).then(response =>{
            location.reload()
          }
      ).catch(e =>{
        SuccusResult.methods.alertError("Oops something went wrong please try again later");

      })
    },
    dataTable() {
      $(document).ready(function () {
        $('#internships').dataTable({
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

function format(inputDate) {
  let date, month, year;

  date = inputDate.getDate();
  month = inputDate.getMonth() + 1;
  year = inputDate.getFullYear();

  date = date
      .toString()
      .padStart(2, '0');

  month = month
      .toString()
      .padStart(2, '0');

  return `${date}/${month}/${year}`;

}
</script>

<style>
.dataTables_filter {
  float: none;
  text-align: inherit;
}

.btnCss{
  padding: 3px 9px;
  background-color: #1f9cff; /* Green */
  border-radius: 10px;
  border-color:#36caff ;
  color: white;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  cursor: grab;

}

</style>
