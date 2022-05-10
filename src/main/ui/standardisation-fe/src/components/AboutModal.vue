<template>
  <v-container>
    <p color="grey">
      <b>{{ this.about.title }}</b>
    </p>
    <p>{{ this.about.desc }}</p>
    <br />
    <p><b>Version:</b> {{ this.about.version }}</p>
    <p><b>Contact:</b> {{ this.contact.name }}</p>
    <p><b>Email:</b> {{ this.contact.email }}</p>
    <p>
      <b>LinkedIn: </b>
      <a href="https://www.linkedin.com/in/kurtfleming">{{
        this.contact.website
      }}</a>
    </p>
  </v-container>
</template>
<script>
export default {
  data() {
    return {
      contact: {
        name: "Kurtis Fleming",
        website: "https://www.linkedin.com/in/kurtfleming",
        email: "kurtallica@hotmail.com",
      },
      about: {
        title: "Data Standardisation API",
        desc: "Data Standardisation API proof-of-concept",
        version: "V1.0.0",
      },
    };
  },
};
</script>
<style>
p,
a {
  color: #6b6b6b;
}
</style>
