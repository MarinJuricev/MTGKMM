package com.example.mtgkmm.android.feature.card.model


sealed class UiLegality(open val legalityType: UiLegalityType) {
    data class Standard(override val legalityType: UiLegalityType) : UiLegality(legalityType)
    data class Future(override val legalityType: UiLegalityType) : UiLegality(legalityType)
    data class Historic(override val legalityType: UiLegalityType) : UiLegality(legalityType)
    data class Gladiator(override val legalityType: UiLegalityType) : UiLegality(legalityType)
    data class Pioneer(override val legalityType: UiLegalityType) : UiLegality(legalityType)
    data class Explorer(override val legalityType: UiLegalityType) : UiLegality(legalityType)
    data class Modern(override val legalityType: UiLegalityType) : UiLegality(legalityType)
    data class Legacy(override val legalityType: UiLegalityType) : UiLegality(legalityType)
    data class Pauper(override val legalityType: UiLegalityType) : UiLegality(legalityType)
    data class Vintage(override val legalityType: UiLegalityType) : UiLegality(legalityType)
    data class Penny(override val legalityType: UiLegalityType) : UiLegality(legalityType)
    data class Commander(override val legalityType: UiLegalityType) : UiLegality(legalityType)
    data class Brawl(override val legalityType: UiLegalityType) : UiLegality(legalityType)
    data class HistoricBrawl(override val legalityType: UiLegalityType) : UiLegality(legalityType)
    data class Alchemy(override val legalityType: UiLegalityType) : UiLegality(legalityType)
    data class PauperCommander(override val legalityType: UiLegalityType) : UiLegality(legalityType)
    data class Duel(override val legalityType: UiLegalityType) : UiLegality(legalityType)
    data class OldSchool(override val legalityType: UiLegalityType) : UiLegality(legalityType)
    data class PreModern(override val legalityType: UiLegalityType) : UiLegality(legalityType)
}

