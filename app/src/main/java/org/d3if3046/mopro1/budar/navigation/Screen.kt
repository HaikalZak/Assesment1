
package org.d3if3046.mopro1.budar.navigation

import org.d3if3046.mopro1.budar.ui.screenBudar.KEY_JUDUL

sealed class Screen (val route:String) {
    data object Awal: Screen("awalScreen")
    data object Home: Screen("mainScreen")
    data object About: Screen("aboutScreen")
    data object FormBaru: Screen("detailScreen")
    data object FormUbah: Screen("detailScreen/{$KEY_JUDUL}"){
        fun withJudul(judul: String) = "detailScreen/$judul"
    }
}
