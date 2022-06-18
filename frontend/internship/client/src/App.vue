<script>
import Sidebar from '@/components/sidebar/Sidebar'
import Login from "@/components/login/login";
import { sidebarWidth } from '@/components/sidebar/state'
import SidebarRouter from "@/components/sidebar/SidebarRouter";
import {computed, watch} from "vue";
export default {
  components: {SidebarRouter, Sidebar ,Login},
  setup() {
    return { sidebarWidth }
  },
  data(){
    return{
      userId : localStorage.getItem("email"),
      loginPath : "/login"

    }
  },
  created() {
    console.log(this.userId)
  },
  watch:{
    userId(){
      return this.loginPath = "/"
    }
  }

}
</script>
<template>
    <div :style="{ 'margin-left': sidebarWidth }">
      <router-view/>
    </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
#nav {
  padding: 30px;
}
#nav a {
  font-weight: bold;
  color: #2c3e50;
}
#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
