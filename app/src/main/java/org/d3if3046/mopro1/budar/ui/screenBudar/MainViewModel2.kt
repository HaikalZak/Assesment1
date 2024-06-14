package org.d3if3046.mopro1.budar.ui.screenBudar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if3046.mopro1.budar.database.BudarDao
import org.d3if3046.mopro1.budar.model.Budar

class MainViewModel2(dao: BudarDao) : ViewModel() {

    val data: StateFlow<List<Budar>> = dao.getBudar().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}
