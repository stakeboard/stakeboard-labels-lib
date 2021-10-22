import net.stakeboard.stakeboard.labels.lib.v0.models.{StakepoolLabel, StakepoolLabels}
import net.stakeboard.stakeboard.labels.lib.v0.models.json._
import org.scalatest.{MustMatchers, OptionValues, WordSpec}
import play.api.libs.json.Json

import java.util.Locale


class StakeboardLabelsTest extends WordSpec with MustMatchers with OptionValues {

  private val SimpleLabelsExample =
    """
      |{
      |  "labels" : [ {
      |    "name" : "name1",
      |    "short_name" : "short_name1",
      |    "description" : "description1",
      |    "subcategories" : [ {
      |      "name" : "sub_name",
      |      "short_name" : "sub_short_name",
      |      "description" : "sub_description"
      |    } ]
      |  }, {
      |    "name" : "name2",
      |    "short_name" : "short_name2",
      |    "description" : "description1"
      |  } ]
      |}
      |""".stripMargin


  "Labels serde test" in {

    val labels = StakepoolLabels(
      List(
        StakepoolLabel("name1", "short_name1", "description1", Some(List(StakepoolLabel("sub_name", "sub_short_name", "sub_description")))),
        StakepoolLabel("name2", "short_name2", "description1")
      )
    )

    Json.parse(SimpleLabelsExample) must be(labels)

  }

  "Full labels" in {

    val labels = StakepoolLabels(
      List(
        StakepoolLabel("Hosting", "hosting", "Type of infrastructure the Stake Pool is running on, eg. Cloud, Bare Metal, Mix",
          Some(List(
            StakepoolLabel("Cloud", "cloud", "Stake Pool is entirely running in the Cloud"),
            StakepoolLabel("Bare Metal", "bare_metal", "Stake Pool is entirely running on Bare Metal"),
            StakepoolLabel("Mix", "mix", "Stake Pool is hosted on a combination of Cloud and Bare Metal resources"),
          ))),
        StakepoolLabel("Charity", "charity", "Charity organizations. Subcategories are based on the following breakdown: https://topnonprofits.com/types-of-charities/",
          Some(List(
            StakepoolLabel("Animals", "animals", "Charity organizations focused on Wildlife conservation organizations, Pet and Animal Welfare Organizations, Hunting & Fishing Conservation Groups, Zoos and Aquariums."),
            StakepoolLabel("Environmental", "environment", "Environmental Charities focus on ways to promote preservation, appreciation, and sustainable development for the environment."),
            StakepoolLabel("Non-governmental organizations", "ngo", "Charity organizations focused on International Development NGOs, Disaster Relief & Humanitarian NGOs, Peace & Human Rights NGOs, Conservation NGOs, Child Sponsorship Organizations"),
            StakepoolLabel("Health", "health", "Charity organizations focused on Disease & Disorder, Medical Services & Treatment, Medical Research Charities, Patient and Family Support Charities"),
            StakepoolLabel("Education", "charity_education", "Charity organizations focused on support students from every age group. Some serve as the educational institutions while focus on making education more accessible and effective."),
            StakepoolLabel("Arts & Culture", "arts_culture", "Charity organizations focused on supporting Museums & Art Galleries, Performing Arts, Libraries & Historical Societies, Public Broadcasting and Media")
          ))),
        StakepoolLabel("ITN", "itn", "Stake Pool that was part of the Incentivized Test Net"),
        StakepoolLabel("Contributor (Builder)", "builder", "Stake Pool run by Cardano builders. Eg. Software, Infrastructure"),
        StakepoolLabel("Women in Blockchain", "wib", "Stake Pool run by a woman"),
        StakepoolLabel("Education", "education", "Stake Pool run by someone whose main focus is to create blockchain educational content"),
        StakepoolLabel("Content creator", "content_creator", "Stake Pool run by a content creator. Eg YouTuber, TikToker."),
        StakepoolLabel("(Fair) Initial Stakepool Offering", "iso", "Stake Pool part of an ISO/FISO")
      )
    )

    println(Json.prettyPrint(Json.toJson(labels)))

  }

  "Locales" in {
    //    Locale
    //      .getAvailableLocales
    //      .groupBy(_.getLanguage)
    //      .keySet
    //      .toList
    //      .sorted
    //      .foreach(println)

    println("====")

    val en = Locale
      .getAvailableLocales
      .groupBy(_.getLanguage)
      .get("en")

    en.foreach(_.filterNot(locale => locale.getCountry != null && locale.getCountry.trim.nonEmpty).foreach { locale =>
      println(s"getISO3Language: ${locale.getISO3Language}, getLanguage: ${locale.getLanguage}, getScript: ${locale.getScript}, getCountry: ${locale.getCountry}, getDisplayName: ${locale.getDisplayName}, toString: ${locale.toString}")
    })

  }

}
