<template>
  <body>

  </body>
</template>

<script>
import Swal from 'sweetalert2';

export default {
  name:'SuccessResult',
  components:{},
  methods:{
    alertSuccess(message){
      Swal.fire({
        icon: 'success',
        title: message,
        showConfirmButton: false,
        timer: 1500
      })
    },
    alertError(message){
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: message,
      })
    }
  }

}

</script>


<style>
body {
  font-family: "Open Sans",
  -apple-system, BlinkMacSystemFont,
  "Segoe UI", Roboto, Oxygen-Sans,
  Ubuntu, Cantarell, "Helvetica Neue",
  Helvetica, Arial, sans-serif;
}
</style>
