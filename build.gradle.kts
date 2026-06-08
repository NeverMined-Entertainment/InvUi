plugins {
    id("java")
    alias(libs.plugins.shadow)
    alias(libs.plugins.pluginYml)
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(16))
}

dependencies {
    compileOnly(libs.paperApi)
    implementation(libs.invUi)
    implementation(libs.invUiKotlin)
}

tasks {
    shadowJar {
        archiveBaseName.set(findProperty("name").toString())
        archiveClassifier.set("")
    }

    compileJava {
        options.encoding = Charsets.UTF_8.name()
    }
}

bukkit {
    name = findProperty("name").toString()
    version = getVersion().toString()
    website = findProperty("website").toString()
    author = findProperty("author").toString()
    main = "org.bigcraft.invui.InvUi"
    apiVersion = "1.16"
}