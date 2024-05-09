package org.d3if3046.mopro1.budar.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3046.mopro1.budar.database.BudarDao
import org.d3if3046.mopro1.budar.model.Budar

class DetailViewModel(private val dao: BudarDao) : ViewModel() {
    fun insert(judul: String, catatan: String, lokasi: String, lokasi2: String, gambar: String?) {
        val budar = Budar(
            judul = judul,
            catatan = catatan,
            lokasi = lokasi, // Menyimpan nilai lokasi
            lokasi2 = lokasi2,
            gambar = gambar
        )
        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(budar)
        }
    }

    suspend fun getBudar(judul: String): Budar? {
        return dao.getBudarById(judul)
    }

    fun update(judul: String, catatan: String, lokasi: String, lokasi2: String, gambar: String?) {
        val budar = Budar(
            judul = judul,
            catatan = catatan,
            lokasi = lokasi, // Menyimpan nilai lokasi
            lokasi2 = lokasi2,
            gambar = gambar
        )
        viewModelScope.launch(Dispatchers.IO) {
            dao.update(budar)
        }
    }

    fun delete(judul: String) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(judul)
        }
    }
}
