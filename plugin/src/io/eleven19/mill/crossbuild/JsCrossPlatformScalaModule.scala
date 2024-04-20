package io.eleven19.mill.crossbuild
import mill.scalajslib._

trait JsCrossPlatformScalaModule extends ScalaJSModule with CrossPlatformScalaModule {
    def platform: Platform = Platform.JS
}
