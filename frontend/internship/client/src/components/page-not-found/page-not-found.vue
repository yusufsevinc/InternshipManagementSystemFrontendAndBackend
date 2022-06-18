
<template xmlns="http://www.w3.org/1999/html">

  <head>


    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Arvo'>

  </head>



  <div class="container">

  <section class="page_404">
      <div class="row">
        <div class="col-sm-9" style="margin-top: 150px">
          <div class="col-sm-10 col-sm-offset-1  text-center">
            <div class="four_zero_four_bg">
              <h1 class="text-center ">404</h1>


            </div>

            <div class="contant_box_404">
              <h3 class="h2">
                Look like you're lost
              </h3>

              <p>the page you are looking for not avaible!</p>

              <a href="http://localhost:8080/login" class="link_404">Go to Login</a>
            </div>
          </div>
        </div>
      </div>
  </section>
  </div>
</template>

<script>

export default {
  name:"PageNotFound"
}

</script>
<style>

#container

{

  width: 100px;

  height: 100px;

  background-color: #567;

  position: absolute;

  left: 50%;

  top: 50%;

  margin-left: -50px;

  margin-top: -50px;

}

.page_404{ padding:40px 0; background:#fff; font-family: 'Arvo', serif;
}

.page_404  img{ width:100%;}

.four_zero_four_bg{

  background-image: url(https://cdn.dribbble.com/users/285475/screenshots/2083086/dribbble_1.gif);
  height: 400px;
  background-position: center;
}


.four_zero_four_bg h1{
  font-size:80px;
}

.four_zero_four_bg h3{
  font-size:80px;
}

.link_404{
  color: #fff!important;
  padding: 10px 20px;
  background: #39ac31;
  margin: 20px 0;
  display: inline-block;}
.contant_box_404{ margin-top:-50px;}

</style>
