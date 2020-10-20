package org.acme.commandmode

import io.quarkus.arc.config.ConfigProperties
import org.eclipse.microprofile.config.inject.ConfigProperty
import javax.inject.Inject
import javax.json.JsonArray

@ConfigProperties(prefix = "wc")
class HelloConfiguration {
//    var root: String = ""   // where to save repos

    @Inject
    @ConfigProperty(name = "name")
    var name: String? = null

    @Inject
    @ConfigProperty(name = "repos")
    var repos: JsonArray? = null

//    var passwd: String = ""   // SSH key password
//    lateinit var repos: List<String>  // List of repository
}
