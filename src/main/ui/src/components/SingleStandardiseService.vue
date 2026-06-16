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
            v-model="toggleStandardiser"
            color="teal"
            value="toUpperCase"
            label="Upper-Case"
            hide-details=""
          ></v-switch>
          <v-switch
            v-model="toggleStandardiser"
            color="teal"
            value="removeNumbers"
            label="Remove Numbers"
            hide-details=""
          ></v-switch>
          <v-switch
            v-model="toggleStandardiser"
            color="teal"
            value="removePunctuation"
            label="Remove Punctuation"
            hide-details=""
          ></v-switch>
          <v-switch
            v-model="toggleStandardiser"
            color="teal"
            value="replaceAccentedCharacters"
            label="Replace Accented Characters"
            hide-details=""
          ></v-switch>
        </v-card>
        <div class="mb-2">
          <v-btn variant="outlined" color="teal" @click="singleStandardise()"
            >Apply</v-btn
          >
          <v-btn variant="outlined" color="teal" @click="resetComponent()"
            >Reset</v-btn
          >
        </div>
        <v-spacer></v-spacer>
        <v-divider></v-divider>
        <v-card class="mt-4 ps-3" height="39%">
          <v-card-subtitle>Standardisations Applied</v-card-subtitle>
          <v-list disabled>
            <v-list-item>
              <v-list-item-title>{{ standardiserApplied }}</v-list-item-title>
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
    toggleStandardiser: "",
    standardiserApplied: "",
  }),
  methods: {
    singleStandardise() {
      fetch(
        `http://localhost:8081/single-standardise?term=${this.input}&standardiserInput=${this.toggleStandardiser}`
      )
        .then((response) => response.json())
        .then((response) => {
          this.readonly = false;
          this.output = response.output;
          this.readonly = true;
          this.standardiserApplied = this.toggleStandardiser;
        })
        .catch((err) => {
          console.log(err.message || err);
        });
    },
    resetComponent() {
      this.input = "";
      this.output = "";
      this.standardisersApplied = "";
      this.toggleStandardiser = "";
    },
  },
};
</script>
<style></style>
