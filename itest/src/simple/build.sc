import java.lang.annotation.Native
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

val scalaVersions = Seq("3.3.3", "2.13.12", "2.12.18", "2.11.12")

object app extends Cross[AppModule](scalaVersions)
trait AppModule extends Core.Module[String] with CrossPlatform {
    trait CommonScalaModule      extends TpolecatModule with ScalafixModule with ScalafmtModule
    trait CommonCrossScalaModule extends CrossScalaModule with CommonScalaModule with CrossValue

    trait CommonCrossPlatformScalaModule extends CommonCrossScalaModule

    trait CommonJvmModule    extends JvmCrossPlatformScalaModule
    trait CommonJsModule     extends JsCrossPlatformScalaModule
    trait CommonNativeModule extends NativeCrossPlatformScalaModule

    trait Shared extends CommonCrossPlatformScalaModule {}

    object jvm    extends Shared with CommonJvmModule
    object js     extends Shared with CommonJsModule
    object native extends Shared with CommonNativeModule

}

def verify() = T.command {
    app("3.3.3").jvm.compile()
    ()
}
