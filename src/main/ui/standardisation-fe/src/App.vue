<template>
  <v-app>
    <v-main>
      <v-app-bar color="#b8d1cb" dark>
        <v-toolbar-title>Data Standardisation API</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-btn to="/">Home</v-btn>
        <v-btn to="audit">Audit</v-btn>
        <v-btn @click="toggleDialog()">About</v-btn>
      </v-app-bar>
      <v-dialog v-model="showDialog" width="500">
        <v-card v-if="showDialog">
          <v-toolbar color="#b8d1cb" dark>
            <v-toolbar-title>About</v-toolbar-title>
          </v-toolbar>
          <about-modal />
          <v-card-actions class="justify-end">
            <v-btn text @click="hideDialog()">Close</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
      <router-view />
    </v-main>
  </v-app>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import AboutModal from "./components/AboutModal.vue";

export default defineComponent({
  name: "App",
  components: {
    AboutModal,
  },
  data() {
    return {
      showDialog: false,
    };
  },
  methods: {
    toggleDialog: function () {
      this.showDialog = !this.showDialog;
    },
    hideDialog: function () {
      this.showDialog = false;
    },
  },
});
</script>
<style></style>
