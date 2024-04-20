package io.eleven19.mill.crossbuild
import mill.scalanativelib._

trait NativeCrossPlatformScalaModule extends ScalaNativeModule with CrossPlatformScalaModule {
    def platform: Platform = Platform.Native
}
