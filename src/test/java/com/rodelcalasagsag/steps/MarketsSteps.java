package com.rodelcalasagsag.steps;

import com.rodelcalasagsag.pages.MarketsPage;
import com.rodelcalasagsag.utils.ListTrimmer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MarketsSteps {

  private World world;

  public MarketsSteps(World world) {
    this.world = world;
  }

  @Given("I am in the Markets page")
  public void iAmInTheMarketsPage() {
    world.marketsPage = MarketsPage.get(world.driver);
  }

  @When("I select the following assets and quotes:")
  public void iSelectTheFollowingAssetsAndQuotes(DataTable rawTable) {
    DataTable data = rawTable.rows(1);
    List<String> assetCodes = ListTrimmer.trim(data.column(0));
    List<String> quoteCodes = ListTrimmer.trim(data.column(1));

    world.marketsPage = world.marketsPage.selectAssets(assetCodes).selectQuotes(quoteCodes);
  }

  @Then("I should see the table being filtered by asset:")
  public void iShouldSeeTheTableBeingFilteredByAsset(DataTable rawTable) {
    DataTable data = rawTable.rows(1);
    List<String> assetCodes = ListTrimmer.trim(data.column(0));
    List<String> assetNames = ListTrimmer.trim(data.column(1));
    List<String> quoteCodes = ListTrimmer.trim(data.column(2));

    for (int i = 0; i < world.marketsPage.getNumberOfRows(); i++) {
      assertThat(
          world.marketsPage.rowHasCorrectAssetAndPair(i, assetNames, assetCodes, quoteCodes),
          is(true));
    }
  }
}
