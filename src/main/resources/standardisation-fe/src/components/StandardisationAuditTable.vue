<template>
  <v-card>
    <v-card-title> </v-card-title>
    <v-table fixed-header height="300px">
      <thead>
        <tr>
          <th v-for="header in headers" :key="header.id">{{ header.text }}</th>
        </tr>
      </thead>
      <tbody id="tableBody">
        <tr v-for="post in posts" :key="post.record_id">
          <td>
            {{ post.record_id }}
          </td>
          <td>{{ post.date_time }}</td>
          <td>
            {{ post.term }}
          </td>
          <td>
            {{ post.standardisation_method }}
          </td>
          <td>
            {{ post.output_term }}
          </td>
        </tr>
      </tbody>
    </v-table>
  </v-card>
</template>
<script>
export default {
  data() {
    return {
      posts: [],
      errors: [],
      headers: [
        {
          text: "ID",
          align: "start",
          filterable: false,
          value: "id",
        },
        { text: "Date/Time", value: "dateTime" },
        { text: "Input Term", value: "input" },
        { text: "Standardisation Method", value: "standardisation" },
        { text: "Output Term", value: "output" },
      ],
    };
  },
  created() {
    this.getAuditData();
  },
  methods: {
    getAuditData() {
      fetch(`http://localhost:8081/get-all-records`)
        .then((response) => response.json())
        .then((response) => {
          this.posts = response.output;
        })
        .catch((err) => {
          console.log(err.message || err);
        });
    },
  },
};
</script>
<style lang=""></style>
