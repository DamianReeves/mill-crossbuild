package io.github.eleven19.mill.crossbuild

class PlatformSuite extends munit.FunSuite {
    test("Should have correct number of Platform variations") {
        val platforms = Platform.all
        assertEquals(platforms.size, 3)
    }
}
