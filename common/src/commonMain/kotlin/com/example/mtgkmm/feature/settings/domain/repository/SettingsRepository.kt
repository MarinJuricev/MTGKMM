import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.feature.settings.domain.model.SettingsItem
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun observeSettingsData(): Flow<List<SettingsItem>>

    suspend fun updateSettingsItem(
        settingsItem: SettingsItem
    ): Either<Failure, Unit>
}