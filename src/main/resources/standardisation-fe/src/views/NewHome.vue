<template>
  <div class="home-screen-wrapper">
    <div class="half-border"></div>
    <div class="heading">
      <img src="resources/cbc-64px.png" alt="CBC logo" />
      <h1>Data Standardisation API</h1>
    </div>
    <hr />
    <div class="standardise-method">
      <h3>Standardisation Method</h3>
      <form class="standardiser-radio" id="standardiserRadio">
        <fieldset>
          <legend>Select Standardisation Method</legend>
          <input
            type="radio"
            name="endpoints"
            id="full-standardise"
            value="full-standardise"
          />
          Full Standardisation
          <br />
          <input
            type="radio"
            name="endpoints"
            id="multiple-standardise"
            value="multiple-standardise"
          />
          Multiple Standardisation <br />
          <input
            type="radio"
            name="endpoints"
            id="single-standardise"
            value="single-standardise"
          />
          Single Standardisation <br />
        </fieldset>
      </form>
    </div>
    <div class="next-button">
      <button type="button" onclick="standardiseMethod()">Next</button>
    </div>
  </div>
</template>
