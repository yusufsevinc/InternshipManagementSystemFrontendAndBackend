<script>
import SidebarRouter from './SidebarRouter'
import { collapsed, toggleSidebar, sidebarWidth } from './state'

export default {
  props:{},
  components:{
    SidebarRouter
  },
  data(){
    return {
      uploadFile1 : localStorage.getItem("uploadFile1"),
      uploadFile2 : localStorage.getItem("uploadFile2"),
      userRole : localStorage.getItem("role")
    }
  },
  setup() {
    return { collapsed, toggleSidebar, sidebarWidth }
  },
  methods:{
    reset(){
      localStorage.removeItem("token");
      console.log("silin token : " + localStorage.getItem("token"))
    },
    exit() {
      localStorage.removeItem("token");
      localStorage.removeItem("email");
      localStorage.removeItem("userId");
      localStorage.removeItem("fullName");
      localStorage.removeItem("role");
    }
  }
}
</script>
<template>
  <div class="sidebar" :style="{ width: sidebarWidth }">
    <h1>
      <span v-if="collapsed">
       <i class="fas fa-users"></i>
      </span>
      <span v-else>Internship Management</span>
    </h1>
    <SidebarRouter v-if="userRole== 'STUDENT'" to="/" icon="fas fa-home">Home</SidebarRouter>
    <SidebarRouter v-if="userRole!= 'STUDENT'" to="/companies" icon="fas fa-building">Companies</SidebarRouter>
    <SidebarRouter v-if="userRole!= 'STUDENT'" icon="fas fa-users" to="/company-executives">Company Executives</SidebarRouter>
    <sidebar-router v-if="userRole== 'STUDENT' && userRole != 'SECRETARY'" icon="fa fa-file" to="/internship-document-upload">Internship File Upload</sidebar-router>
    <SidebarRouter v-if="userRole== 'STUDENT' && userRole != 'SECRETARY' && uploadFile1 == 'false' && uploadFile2 == 'false'" to="/internship-create" icon="fa-solid fa-file-arrow-up">Internship Create</SidebarRouter>
    <SidebarRouter v-if="userRole!= 'STUDENT' && userRole != 'SECRETARY'" icon="fa-solid fa-file-lines" to="/applied-internships" >Applied Internships</SidebarRouter>
    <SidebarRouter v-if="userRole== 'SECRETARY'" icon="fa-solid fa-folder-open" to="/confirm-internships">Confirm Internships</SidebarRouter>
    <br>
    <br>
    <SidebarRouter icon="fas fa-door-open" to="/" @click="exit()">Guvenli Cikis</SidebarRouter>
    <span
        class="collapse-icon"
        :class="{ 'rotate-180': collapsed }"
        @click="toggleSidebar"
    >
      <i class="fas fa-angle-double-left" />
    </span>
  </div>
</template>

<style>
:root {
  --sidebar-bg-color: #33A8FF;
  --sidebar-item-hover: #B5DDFA;
  --sidebar-item-active: #216595;
}
</style>

<style scoped>
.sidebar {
  color: white;
  background-color: var(--sidebar-bg-color);
  float: left;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  bottom: 0;
  padding: 0.5em;
  transition: 0.3s ease;
  display: flex;
  flex-direction: column;
}
.sidebar h1 {
  height: 2.5em;
}
.collapse-icon {
  position: absolute;
  bottom: 0;
  padding: 0.75em;
  color: rgba(255, 255, 255, 0.7);
  transition: 0.2s linear;
}
.rotate-180 {
  transform: rotate(180deg);
  transition: 0.2s linear;
}
</style>
