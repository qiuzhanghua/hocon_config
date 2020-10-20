package org.acme.commandmode

import io.quarkus.runtime.Quarkus
import io.quarkus.runtime.QuarkusApplication
import io.quarkus.runtime.annotations.QuarkusMain
import org.eclipse.microprofile.config.Config
import org.eclipse.microprofile.config.inject.ConfigProperty
import javax.inject.Inject
import javax.json.JsonArray
import javax.json.JsonObject

@QuarkusMain
class HelloCommando : QuarkusApplication {

    @Inject
    private val config: Config? = null

    @Inject
    @ConfigProperty(name = "wc.name")
    private var name: String? = null

    @Inject
    @ConfigProperty(name = "wc.data")
    var data: String? = null

    @Inject
    @ConfigProperty(name = "wc.repos")
    var repos: JsonArray? = null

    override fun run(vararg args: String?): Int {
//        val name = if (args.isNotEmpty()) args.joinToString(",") else "Hi, from Daniel..."
        println(name)
        println(repos)
        println(data)

        repos?.forEach { x ->
                println(x.asJsonObject());
        }
        Quarkus.waitForExit()
        return 0
    }

}
