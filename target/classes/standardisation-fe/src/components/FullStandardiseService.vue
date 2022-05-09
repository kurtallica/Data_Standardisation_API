<template>
  <v-container fluid>
    <v-row class="py-15" no-gutters>
      <v-spacer></v-spacer>
      <v-col cols="auto" md="7">
        <v-textarea
          v-model="input"
          class="pb-6"
          counter
          rows="7"
          label="Term"
          :rules="rules"
          :placeholder="inputPlaceholder"
          hide-details=""
        ></v-textarea>

        <v-divider></v-divider>
        <div>
          <v-textarea
            v-model="output"
            class="pt-6"
            rows="7"
            label="Output"
            :readonly="readonly"
            :placeholder="outputPlaceholder"
            hide-details=""
          ></v-textarea>
        </div>
      </v-col>

      <v-divider class="mx-4" vertical></v-divider>
      <v-col cols="12" md="4">
        <v-card class="ps-3">
          <v-card-subtitle>Standardisers to apply</v-card-subtitle>

          <v-switch
            color="primary"
            :model-value="true"
            disabled
            label="Upper-Case"
            hide-details=""
          ></v-switch>
          <v-switch
            color="primary"
            :model-value="true"
            disabled
            label="Remove Numbers"
            hide-details=""
          ></v-switch>
          <v-switch
            color="primary"
            :model-value="true"
            disabled
            label="Remove Punctuation"
            hide-details=""
          ></v-switch>
          <v-switch
            color="primary"
            :model-value="true"
            disabled
            label="Replace Accented Characters"
            hide-details=""
          ></v-switch>
        </v-card>
        <div class="mb-2">
          <v-btn variant="outlined" @click="fullStandardise()">Apply</v-btn>
          <v-btn variant="outlined">Reset</v-btn>
        </div>
        <v-spacer></v-spacer>
        <v-divider></v-divider>
        <v-card class="mt-4 ps-3">
          <v-card-subtitle>Standardisations Applied</v-card-subtitle>
          <v-list disabled>
            <v-list-item v-for="(item, i) in items" :key="i">
              <v-list-item-title v-text="item.text"></v-list-item-title>
            </v-list-item>
          </v-list>
        </v-card>
      </v-col>
      <v-spacer></v-spacer>
    </v-row>
  </v-container>
</template>
<script>
export default {
  data: () => ({
    rules: [(v) => v.length <= 200 || "Max 200 characters"],
    inputPlaceholder: "Please enter term to be standardised",
    input: "",
    outputPlaceholder: "Please click apply to view output",
    output: "",
    readonly: true,
    posts: [],
    items: [
      { text: "Remove Numbers" },
      { text: "Remove Punctuation" },
      { text: "Upper-Case" },
      { text: "Replace Accented Characters" },
    ],
  }),
  methods: {
    fullStandardise() {
      fetch(`http://localhost:8081/full-standardise?term=${this.input}`)
        .then((response) => response.json())
        .then((response) => {
          this.posts = response.output;
          console.log(response.output);
        })
        .catch((err) => {
          console.log(err.message || err);
        });
    },
  },
};
</script>
<style></style>
