<template>
  <Sidebar/>
  <div style="padding:52px 52px 0px 52px;">
    <div class="col-xl-12 col-md-6">
      <table id="companyExecutiveDetail" class="table" style="width:100%">
      <thead class="thead-light">
      <tr>
        <th scope="col">Index</th>
        <th scope="col">Name Surname</th>
        <th scope="col">Position</th>
        <th scope="col">Email</th>
        <th scope="col">Phone</th>
        <th scope="col">Is Active</th>
        <th scope="col">Company Name</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for='(item, index) in companyExecutiveDetail' :key='index'>
        <th scope="row">{{ index }}</th>
        <th>{{item.companyExecutiveName}}  {{item.companyExecutiveSurname}}</th>
        <th>{{item.companyExecutiveTitle}}</th>
        <th>{{item.companyExecutiveEmail}}</th>
        <th>{{item.companyExecutivePhone}}</th>
        <th>{{item.enabled}}</th>
        <th>{{item.company.companyName}}</th>
      </tr>
      </tbody>
    </table>
    </div>
  </div>
</template>

<script>
import {getCompanyExecutiveDetailById} from "@/services/company-executive.service";
import $ from "jquery";
import Sidebar from '@/components/sidebar/Sidebar'

export default {
  name: 'CompanyExecutiveDetail',
  components:{Sidebar},
  data() {
    return {companyExecutiveDetail: {}}
  },
  created() {
    this.getCompanyExecutive();
  },
  methods:{
    getCompanyExecutive() {
      getCompanyExecutiveDetailById(this.$route.params.id).then(response => {
        this.companyExecutiveDetail = response.data;
      }).then(
          this.dataTable
      );
    },
    dataTable(){
      $(document).ready(function () {
        $('#companyExecutiveDetail').dataTable({
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
