// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0-rc01" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
}

//version
extra["navVersion"] = "2.4.0"
extra["coreKtxVersion"] = "1.9.0"
extra["appCompatVersion"] = "1.6.1"
extra["materialVersion"] = "1.9.0"
extra["constraintLayoutVersion"] = "2.1.4"
extra["junitVersion"] = "4.13.2"
extra["androidJUnitVersion"] = "1.1.5"
extra["espressoCoreVersion"] = "3.5.1"
extra["timberVersion"] = "4.7.1"
extra["coilVersion"] = "1.4.0"
extra["glideVersion"] = "4.12.0"