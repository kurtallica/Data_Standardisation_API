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
        {{
          mounted()
        }}
      </tbody>
    </v-table>
  </v-card>
</template>
<script>
export default {
  data() {
    return {
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
      // auditItems: [
      //   {
      //     id: "1",
      //     dateTime: "05/05/2022 15:14",
      //     input: "hello chicken nuggeT",
      //     standardisation: "single standardise",
      //     output: "HELLO CHICKEN NUGGET",
      //   },
      //   {
      //     id: "2",
      //     dateTime: "05/05/2022 15:18",
      //     input: "very goood very niicee",
      //     standardisation: "single standardise",
      //     output: "VERY GOOOD VERY NIICEE",
      //   },
      //   {
      //     id: "3",
      //     dateTime: "05/05/2022 15:30",
      //     input: "how much?!",
      //     standardisation: "single standardise",
      //     output: "HOW MUCH?!",
      //   },
      // ],
    };
  },
  methods: {
    mounted: function () {
      const response = fetch("http://localhost:8081/get-all-records");
      console.log(response.json);
      return response.json;

      //   let xhr = new XMLHttpRequest();
      //   let url = new URL("http://localhost:8081/get-all-records");

      //   xhr.open("GET", url);

      //   xhr.send();

      //   xhr.onload = function () {
      //     let auditElement = document.getElementById("tableBody");
      //     let apiResponse = JSON.parse(xhr.response); //API response to be parsed

      //     // for (let i = 0; i < apiResponse.output.length; i++) {
      //     //   auditElement.innerHTML +=
      //     //     "<tr>" +
      //     //     "<td>" +
      //     //     apiResponse.output[i].record_id +
      //     //     "</td>" +
      //     //     "<td>" +
      //     //     apiResponse.output[i].date_time +
      //     //     "</td>" +
      //     //     "<td>" +
      //     //     apiResponse.output[i].term +
      //     //     "</td>" +
      //     //     "<td>" +
      //     //     apiResponse.output[i].standardisation_method +
      //     //     "</td>" +
      //     //     "<td>" +
      //     //     apiResponse.output[i].output_term +
      //     //     "</td>" +
      //     //     "</tr>";
      //     // }
      //   };
    },
  },
};
</script>
<style lang=""></style>
