plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    kotlin("jvm")
}

group = "kr.hs.dgsw"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven {
        name = "codemc-snapshots"
        url = uri("https://repo.codemc.io/repository/maven-snapshots/")
    }
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.19.4-R0.1-SNAPSHOT")
    implementation("net.wesjd:anvilgui:1.9.2-SNAPSHOT") // Anvil GUI
}

tasks.shadowJar {
    minimize {
        exclude(dependency("net.wesjd:anvilgui:.*"))
    }
}

tasks.register("copyPlugin", Copy::class) {
    dependsOn("shadowJar")
    from("build/libs/DAuth-1.0-SNAPSHOT-all.jar")
    into("/Users/rlawhddbs/Desktop/minecraft-server/plugins")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}