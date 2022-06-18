import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
import Dashboard from "@/views/Dashboard";
import CompanyList from "@/components/company-list/company-list";
import CompanyExecutiveList from "@/components/company-executive-list/company-executive-list";
import CompanyExecutiveDetail from "@/components/company-executive-list/company-executive-detail";
import CompanyCreate from "@/components/company-create/company-create";
import CompanyExecutiveCreate from "@/components/company-executive-create/company-executive-create";
import InternshipDocumentUpload from "@/components/internship-document-upload/Internship-document-upload";
import InternshipCreate from "@/components/internship-create/internship-create";
import Login from "@/components/login/login";
import AppliedInternships from "@/components/applied-internships/applied-internship";
import ConfirmInternships from "@/components/confirm-internship/confirm-internship";
import PageNotFound from "@/components/page-not-found/page-not-found";


const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/about",
    name: "About",
    component: () =>
      import("../views/About.vue"),
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/dashboard",
    name: "Dashboard",
    component: Dashboard,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/companies",
    name: "Companies",
    component: CompanyList,
    meta: {
      requiresAuth: true
    }

  },
  {
    path: "/company-executives",
    name: "Company Executives",
    component: CompanyExecutiveList,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/company-executives-detail/:id',
    name: 'Company Executive Detail',
    component: CompanyExecutiveDetail,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/company-create',
    name: 'Company Create',
    component: CompanyCreate,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/company-executive-create',
    name : 'Company Executive Create',
    component: CompanyExecutiveCreate,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/internship-document-upload',
    name: 'Internship File Upload',
    component: InternshipDocumentUpload,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/internship-create',
    name: 'Internship Create',
    component: InternshipCreate,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/applied-internships',
    name: 'Applied Internships',
    component: AppliedInternships,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/confirm-internships',
    name: 'Confirm Internships',
    component: ConfirmInternships,
    meta: {
      requiresAuth: true
    }
  },
  {
   path: '/:pathMatch(.*)*',
    name: 'Page Not Found',
    component: PageNotFound
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

router.beforeEach((to, from, next) => {
 document.title = to.name;
  //next();
  const  currentUser = localStorage.getItem("token");
  const  requiresAuth = to.matched.some(record => record.meta.requiresAuth);
  if (requiresAuth && (currentUser == null)){
    console.log("if")
    next("Login");
  }
  else{
    console.log("else")
    next();
  }
});



export default router;



