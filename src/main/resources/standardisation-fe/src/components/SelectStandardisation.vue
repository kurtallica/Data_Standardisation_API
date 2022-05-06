<template>
  <v-app>
    <v-card class="mx-auto my-auto" max-width="374" elevation="2" tile>
      <v-row dense>
        <v-col cols="12">
          <v-card color="#b8d1cb" dark>
            <v-card-title class="text-h5"> Full Standardisation </v-card-title>

            <v-card-subtitle
              >Apply all available standardisations to a user-defined
              String</v-card-subtitle
            >

            <v-card-actions>
              <v-btn block to="/full-standardise"> Select </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>

      <v-row dense>
        <v-col cols="12">
          <v-card color="#b8d1cb" dark>
            <v-card-title class="text-h5">
              Multiple Standardisation
            </v-card-title>

            <v-card-subtitle
              >Apply a selection of available standardisations to a user-defined
              String</v-card-subtitle
            >

            <v-card-actions>
              <v-btn block color="accent" to="/multiple-standardise">
                Select
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>

      <v-row dense>
        <v-col cols="12">
          <v-card color="#b8d1cb" dark>
            <v-card-title class="text-h5">
              Single Standardisation
            </v-card-title>

            <v-card-subtitle
              >Apply a single available standardisation to a user-defined
              String</v-card-subtitle
            >

            <v-card-actions>
              <v-btn block to="/single-standardise"> Select </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-card>
  </v-app>
</template>
