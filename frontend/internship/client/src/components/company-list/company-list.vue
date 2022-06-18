<template>
  <Sidebar></Sidebar>
  <div style="padding:52px 52px 0px 52px;">
    <div class="col-xl-12 col-md-6">
    <table id="companies" class="table" style="width:100%">
      <thead>
      <tr>
        <th>Index</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Is Active</th>
        <th>See Employees</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for='(item, index) in companies' :key='index'>
        <th>{{index}}</th>
        <th>{{item.companyName}}</th>
        <th>{{item.companyEmail}}</th>
        <th>{{item.companyPhone}}</th>
        <th>{{item.address.neighborhood.district.city.cityName}} / {{item.address.neighborhood.district.districtName}}</th>
        <th>{{item.enabled}}</th>
        <th><a v-bind:href="'/company-executives-detail/' + item.companyId" class="btn btn-outline-success">
          See Employees</a>
        </th>
      </tr>
      </tbody>
      <tfoot>
      <tr>
        <th>Index</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Is Active</th>
      </tr>
      </tfoot>
    </table>
        </div>
  </div>
    <div class="d-flex flex-row-reverse">
      <div style="padding-right:52px;"><a v-bind:href="'/company-create'" class="btn btn-outline-info">Create</a>
      </div>
    </div>
</template>

<script>
import {companyAll} from "@/services/company.service";
import $ from 'jquery';
import {getCompanyExecutiveDetailById} from "@/services/company-executive.service";
import Sidebar from '@/components/sidebar/Sidebar'


export default {
  name: 'CompanyList',
  components: {Sidebar},
  data() {
    return {companies: []}
  },
  created() {
    this.getCompanies();
  },
  methods: {
    getCompanies() {
      companyAll().then(response => {
        this.companies = response.data;
      }).then(
          this.dataTable
      )
    },
    dataTable() {
      $(document).ready(function () {
        $('#companies').dataTable({
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
