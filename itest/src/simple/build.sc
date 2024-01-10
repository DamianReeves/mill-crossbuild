import $exec.plugins
import mill._
import mill.api.Result
import mill.define.SelectMode
import mill.eval._
import mill.main.MainModule
import mill.scalalib._
import mill.scalajslib._
import mill.scalanativelib._
import io.github.eleven19.mill.crossbuild._

val scalaVersions = Seq("3.3.1", "2.13.12", "2.12.18", "2.11.12")

object app extends Cross[AppModule](scalaVersions)
trait AppModule extends Core.Module[String] with CrossPlatform {
    trait Shared extends CrossPlatformScalaModule

    object jvm extends Shared
}

def verify() = T.command {
    app("3.3.1").jvm.compile()
    ()
}
