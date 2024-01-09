import mill._
import mill.scalalib._
import mill.scalalib.scalafmt._
import mill.scalalib.publish._
import mill.scalalib.api.ZincWorkerUtil._

import $ivy.`de.tototec::de.tobiasroeser.mill.integrationtest::0.6.1`
import $ivy.`com.goyeau::mill-scalafix::0.3.1`
import com.goyeau.mill.scalafix.ScalafixModule
import $ivy.`io.chris-kipp::mill-ci-release::0.1.9`
import io.kipp.mill.ci.release._
import de.tobiasroeser.mill.vcs.version.VcsVersion

val millVersions = Seq("0.11.0")
val scala213     = "2.13.12"
val pluginName   = "mill-crossbuild"

object plugin extends Cross[Plugin](millVersions)
trait Plugin  extends Cross.Module[String] with ScalaModule {}

trait Publish extends CiReleaseModule {
    def pomSettings = PomSettings(
        description = "A mill plugin for cross-building projects",
        organization = "io.github.eleven19",
        url = "https://github.com/eleven19/mill-crossbuild",
        licenses = Seq(License.`Apache-2.0`),
        versionControl = VersionControl.github("eleven19", "mill-crossbuild"),
        developers = Seq(
            Developer(
                "DamianReeves",
                "Damian Reeves",
                "https://github.com/DamianReeves",
            )
        ),
    )
}
