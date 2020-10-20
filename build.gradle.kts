import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.72"
    id("io.quarkus")
}

repositories {
    mavenLocal()
    mavenCentral()
}

group = "com.example"
version = "1.0-SNAPSHOT"

val quarkusPluginId = "io.quarkus"
val quarkusPlatformGroupId = "io.quarkus"
val quarkusPlatformArtifactId = "quarkus-universe-bom"
val quarkusPlatformVersion = "1.8.3.Final"

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-jsonb")
    implementation("io.quarkus:quarkus-jsonp")
    implementation("io.smallrye.config:smallrye-config-source-hocon:1.8.6")
    implementation("io.smallrye.config:smallrye-config-converter-json:1.8.6")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.quarkus:quarkus-arc")
    testImplementation("io.quarkus:quarkus-junit5")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
    kotlinOptions.javaParameters = true
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
