package dev.tildejustin.mcsr_meta.json

import kotlinx.serialization.*

@Serializable
data class Meta(val schemaVersion: Int, val mods: List<Mod>) {
    @Serializable
    data class Mod @OptIn(ExperimentalSerializationApi::class) constructor(
        val modid: String,
        val name: String,
        val description: String,
        val sources: String,
        val versions: List<ModVersion>,
        @EncodeDefault(EncodeDefault.Mode.NEVER) val traits: List<String> = listOf(),
        @EncodeDefault(EncodeDefault.Mode.NEVER) val incompatibilities: List<String> = listOf(),
        @EncodeDefault(EncodeDefault.Mode.NEVER) val recommended: Boolean = true,
        @EncodeDefault(EncodeDefault.Mode.NEVER) val obsolete: Boolean = false
    )

    @Serializable
    data class ModVersion @OptIn(ExperimentalSerializationApi::class) constructor(
        val target_version: Collection<String>,
        val version: String,
        val url: String,
        val hash: String,
        @EncodeDefault(EncodeDefault.Mode.NEVER) val recommended: Boolean = true,
        @EncodeDefault(EncodeDefault.Mode.NEVER) val obsolete: Boolean = false
    )
}
