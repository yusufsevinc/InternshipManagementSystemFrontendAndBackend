<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/200x200.png" />
    <HowToUse />
  </div>
</template>

<script>
// @ is an alias to /src
import HowToUse from "@/components/HowToUse.vue";

export default {
  name: "Home",
  components: {
    HowToUse,
  },
};
</script>
