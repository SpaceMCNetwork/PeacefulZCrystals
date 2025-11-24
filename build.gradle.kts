plugins {
    id("java")
    id("dev.architectury.loom") version("1.7.462")
    id("architectury-plugin") version("3.4-SNAPSHOT")
    kotlin("jvm") version("2.0.0")
}

group = "dev.nxkorasu"
version = "1.2.1"

architectury {
    platformSetupLoomIde()
    fabric()
}

loom {
    silentMojangMappingsLicense()
    mixin {
        defaultRefmapName.set("mixins.${project.name}.refmap.json")
    }
}

repositories {
    mavenCentral()
    maven("https://maven.impactdev.net/repository/development/")
    maven("https://maven.nucleoid.xyz")
}

dependencies {

    minecraft("com.mojang:minecraft:1.21.1")

    // Kotlin actualizado
    implementation("org.jetbrains.kotlin:kotlin-reflect:2.0.0")

    // Loader + API
    modImplementation("net.fabricmc:fabric-loader:0.16.9")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.107.0+1.21.1")

    // Polymer
    modImplementation(include("eu.pb4", "polymer-core", "0.9.17+1.21.1"))
    modImplementation(include("eu.pb4", "polymer-blocks", "0.9.17+1.21.1"))
    modImplementation(include("eu.pb4", "polymer-resource-pack", "0.9.17+1.21.1"))
    modImplementation(include("eu.pb4", "polymer-virtual-entity", "0.9.17+1.21.1"))

    // Cobblemon
    modImplementation("com.cobblemon:fabric:1.7.0+1.21.1")

    // Optional
    compileOnly("net.luckperms:api:${rootProject.property("luckperms_version")}")

    // Mappings
    mappings("net.fabricmc:yarn:1.21.1+build.3:v2")

    // Tests
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
