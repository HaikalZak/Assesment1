package org.d3if3046.mopro1.budar.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "budar")
class Budar (
    @PrimaryKey
    val judul: String,
    val catatan: String,
    val lokasi: String,
    val lokasi2: String,
    val gambar: String?
)