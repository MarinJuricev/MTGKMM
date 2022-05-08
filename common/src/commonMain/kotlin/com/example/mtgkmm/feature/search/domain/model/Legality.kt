package com.example.mtgkmm.feature.search.domain.model

sealed class Legality(open val legalityType: LegalityType) {
    data class Standard(override val legalityType: LegalityType) : Legality(legalityType)
    data class Future(override val legalityType: LegalityType) : Legality(legalityType)
    data class Historic(override val legalityType: LegalityType) : Legality(legalityType)
    data class Gladiator(override val legalityType: LegalityType) : Legality(legalityType)
    data class Pioneer(override val legalityType: LegalityType) : Legality(legalityType)
    data class Explorer(override val legalityType: LegalityType) : Legality(legalityType)
    data class Modern(override val legalityType: LegalityType) : Legality(legalityType)
    data class Legacy(override val legalityType: LegalityType) : Legality(legalityType)
    data class Pauper(override val legalityType: LegalityType) : Legality(legalityType)
    data class Vintage(override val legalityType: LegalityType) : Legality(legalityType)
    data class Penny(override val legalityType: LegalityType) : Legality(legalityType)
    data class Commander(override val legalityType: LegalityType) : Legality(legalityType)
    data class Brawl(override val legalityType: LegalityType) : Legality(legalityType)
    data class HistoricBrawl(override val legalityType: LegalityType) : Legality(legalityType)
    data class Alchemy(override val legalityType: LegalityType) : Legality(legalityType)
    data class PauperCommander(override val legalityType: LegalityType) : Legality(legalityType)
    data class Duel(override val legalityType: LegalityType) : Legality(legalityType)
    data class OldSchool(override val legalityType: LegalityType) : Legality(legalityType)
    data class PreModern(override val legalityType: LegalityType) : Legality(legalityType)
}
