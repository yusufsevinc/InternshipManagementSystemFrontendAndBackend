import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import "jquery/dist/jquery.min.js";
import '@fortawesome/fontawesome-free/js/all';
import 'bootstrap/dist/css/bootstrap.min.css';
import '@fortawesome/fontawesome-free/css/all.min.css';
import 'mdbvue/lib/css/mdb.min.css'
import "datatables.net-dt/js/dataTables.dataTables";
import "datatables.net-dt/css/jquery.dataTables.min.css";
import '@popperjs/core';



createApp(App).use(store).use(router).mount("#app");
