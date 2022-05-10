<template>
  <select-standardisation />
</template>

<script lang="ts">
import { defineComponent } from "vue";

// Components
import SelectStandardisation from "../components/SelectStandardisation.vue";

export default defineComponent({
  name: "HomeView",

  components: {
    SelectStandardisation,
  },
});
</script>
