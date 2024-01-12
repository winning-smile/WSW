package com.example.wsw

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

data class SwitchK(val bottom_out_force: String?=null, val spring: String?=null, val tac_travel: String?=null, val price: String?=null,
                   val total_travel: String?=null, val op_force: String?=null, val name: String?=null, val bio: String?=null,
                   val tac_foce: String?=null, val type: String?=null, val pre_travel: String?=null)

sealed class DataState {
    class Success(val data: MutableList<SwitchK>) : DataState()
    class Failure(val message: String) : DataState()
    object Loading : DataState()
    object Empty : DataState()
}

class SwitchCardViewModel : ViewModel() {

    val response: MutableState<DataState> = mutableStateOf(DataState.Empty)

    init {
        fetchDataFromFirebase()
    }

    private fun fetchDataFromFirebase() {
        val tempList = mutableListOf<SwitchK>()
        response.value = DataState.Loading

        FirebaseDatabase.getInstance().getReference("data/switches/akko")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (DataSnap in snapshot.children) {
                        val switchItem = DataSnap.getValue(SwitchK::class.java)
                        if (switchItem != null)
                            tempList.add(switchItem)
                    }
                    response.value = DataState.Success(tempList)
                }

                override fun onCancelled(error: DatabaseError) {
                    response.value = DataState.Failure(error.message)
                }
            }
        )
    }
}