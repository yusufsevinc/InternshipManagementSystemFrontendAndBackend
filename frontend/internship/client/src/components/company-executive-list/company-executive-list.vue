<template>
  <Sidebar></Sidebar>
  <div style="padding:52px 52px 0px 52px;">
    <div class="col-xl-12 col-md-6">
      <table id="companyExecutive" class="table" style="width:100%">
        <thead>
        <tr>
          <th>Name Surname</th>
          <th>Position</th>
          <th>Email</th>
          <th>Phone</th>
          <th>Is Active</th>
          <th>Company Name</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for='(item, index) in companyExecutives' :key='index'>
          <th>{{item.companyExecutiveName}}  {{item.companyExecutiveSurname}}</th>
          <th>{{item.companyExecutiveTitle}}</th>
          <th>{{item.companyExecutiveEmail}}</th>
          <th>{{item.companyExecutivePhone}}</th>
          <th>{{item.enabled}}</th>
          <th>{{item.company.companyName}}</th>
        </tr>
        </tbody>
        <tfoot>
        <tr>
          <th>Name Surname</th>
          <th>Position</th>
          <th>Email</th>
          <th>Phone</th>
          <th>Is Active</th>
          <th>Company Name</th>
        </tr>
        </tfoot>
      </table>
    </div>
  </div>
  <div class="d-flex flex-row-reverse">
    <div style="padding-right:52px;"><a v-bind:href="'/company-executive-create'" class="btn btn-outline-info">Create</a>
    </div>
  </div>
</template>
<script>
import {companyExecutiveAll} from "@/services/company-executive.service";
import $ from "jquery";
import Sidebar from '@/components/sidebar/Sidebar'

export default {
  name: 'CompanyExecutiveList',
  components: {Sidebar},
  data() {
    return {companyExecutives: {}}
  },
  created() {
    this.getCompanyExecutive();
  },
  methods: {
    getCompanyExecutive() {
      companyExecutiveAll().then(response => {
        this.companyExecutives = response.data;
      }).then(
          this.dataTable
      );
    },
    dataTable(){
      $(document).ready(function () {
        $('#companyExecutive').dataTable({
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
