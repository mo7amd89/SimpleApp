import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project


interface IExternalProjectDependencies {
    fun addFeatureAuth(projectHandler: (String) -> Any): Any
    fun addRepositoryAuth(projectHandler: (String) -> Any): Any
}
object LocalExternalProjectDependencies : IExternalProjectDependencies {

    override fun addFeatureAuth(projectHandler: (String) -> Any): Any {
        return projectHandler(":feature-auth")
    }

    override fun addRepositoryAuth(projectHandler: (String) -> Any): Any {
        return projectHandler(":repository-auth")
    }

}

object RemoteExternalProjectDependencies : IExternalProjectDependencies {
    private const val authRepoVersion = "1.0.0"


    override fun addFeatureAuth(projectHandler: (String) -> Any): Any {
        return "com.justadeveloper96:feature-auth:$authRepoVersion"
    }

    override fun addRepositoryAuth(projectHandler: (String) -> Any): Any {
        return "com.justadeveloper96:repository-auth:$authRepoVersion"
    }

}


val externalProjectDependencies =
    if (ProjectProperties.remoteBuild) RemoteExternalProjectDependencies else LocalExternalProjectDependencies
