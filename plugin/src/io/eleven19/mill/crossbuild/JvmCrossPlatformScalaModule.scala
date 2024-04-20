package io.eleven19.mill.crossbuild

trait JvmCrossPlatformScalaModule extends CrossPlatformScalaModule {
    def platform: Platform = Platform.JVM
}

