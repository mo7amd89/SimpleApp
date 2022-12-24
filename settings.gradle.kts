pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "SimpleApp"
include(":app")
// Local Project link

fun findAndLinkExternalModules(list: List<String>) {
    val matchingModules = File("$rootDir/../").listFiles(java.io.FileFilter {
        it.isDirectory && it.name.startsWith("Feature")
    }).flatMap {
        it.listFiles(java.io.FileFilter {
            it.isDirectory && list.contains(it.name)
        }).toList()
    }
    println("findAndLinkExternalModules: ${matchingModules.size}/${externalModules.size}")
    matchingModules.forEach {
        println(it)
        val moduleName = it.name
        include(":$moduleName")
        project(":$moduleName").projectDir = it
    }
}
val externalModules = listOf("feature-auth", "repository-auth")

findAndLinkExternalModules(externalModules)