package com.example.mtgkmm.feature.search.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCardData(
    @SerialName("all_parts")
    val allParts: List<NetworkAllPart>?,
    @SerialName("arena_id")
    val arenaId: Int?,
    val artist: String?,
    @SerialName("artist_ids")
    val artistIds: List<String>?,
    val booster: Boolean?,
    @SerialName("border_color")
    val borderColor: String?,
    @SerialName("card_back_id")
    val cardBackId: String?,
    @SerialName("card_faces")
    val cardFaces: List<NetworkCardFace>?,
    @SerialName("cardmarket_id")
    val cardMarketId: Int?,
    val cmc: Int?,
    @SerialName("collector_number")
    val collectorNumber: String?,
    @SerialName("color_identity")
    val colorIdentity: List<String>?,
    val colors: List<String>?,
    val digital: Boolean?,
    @SerialName("edhrec_rank")
    val edhrecRank: Int?,
    val finishes: List<String>?,
    @SerialName("flavor_text")
    val flavorText: String?,
    val foil: Boolean?,
    val frame: String?,
    @SerialName("frame_effects")
    val frameEffects: List<String>?,
    val fullArt: Boolean?,
    val games: List<String>?,
    @SerialName("highres_image")
    val highresImage: Boolean?,
    val id: String?,
    @SerialName("illustration_id")
    val illustrationId: String?,
    @SerialName("image_status")
    val imageStatus: String?,
    @SerialName("image_uris")
    val imageUris: NetworkImageUris?,
    val keywords: List<String>?,
    val lang: String?,
    val layout: String?,
    val legalities: NetworkLegalities?,
    val loyalty: String?,
    @SerialName("mana_cost")
    val manaCost: String?,
    @SerialName("mtgo_foil_id")
    val mtgoFoilId: Int?,
    @SerialName("mtgo_id")
    val mtgoId: Int?,
    @SerialName("multiverse_ids")
    val multiverseIds: List<Int>?,
    val name: String?,
    val nonfoil: Boolean?,
    @SerialName("object")
    val objectType: String?,
    @SerialName("oracle_id")
    val oracleId: String?,
    @SerialName("oracle_text")
    val oracleText: String?,
    val oversized: Boolean?,
    @SerialName("penny_rank")
    val pennyRank: Int?,
    val power: String?,
    val preview: NetworkPreview?,
    val prices: NetworkPrices?,
    @SerialName("prints_search_uri")
    val printsSearchUri: String?,
    @SerialName("produced_mana")
    val producedMana: List<String>?,
    val promo: Boolean?,
    @SerialName("promo_types")
    val promoTypes: List<String>?,
    @SerialName("purchase_uris")
    val purchaseUris: NetworkPurchaseUris?,
    val rarity: String?,
    @SerialName("related_uris")
    val relatedUris: NetworkRelatedUris?,
    @SerialName("released_at")
    val releasedAt: String?,
    val reprint: Boolean?,
    val reserved: Boolean?,
    @SerialName("rulings_uri")
    val rulingsUri: String?,
    @SerialName("scryfall_set_uri")
    val scryfallSetUri: String?,
    @SerialName("scryfall_uri")
    val scryfallUri: String?,
    @SerialName("security_stamp")
    val securityStamp: String?,
    val set: String?,
    @SerialName("set_id")
    val setId: String?,
    @SerialName("set_name")
    val setName: String?,
    @SerialName("set_search_uri")
    val setSearchUri: String?,
    @SerialName("set_type")
    val setType: String?,
    @SerialName("set_uri")
    val setUri: String?,
    @SerialName("story_spotlight")
    val storySpotlight: Boolean?,
    @SerialName("tcgplayer_id")
    val tcgplayerId: Int?,
    @SerialName("textless")
    val textless: Boolean?,
    val toughness: String?,
    @SerialName("type_line")
    val typeLine: String?,
    val uri: String?,
    val variation: Boolean?,
    val watermark: String?
)