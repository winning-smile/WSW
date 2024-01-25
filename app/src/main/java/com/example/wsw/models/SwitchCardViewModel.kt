package com.example.wsw.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

data class SwitchK(val id: Long = counter++, val main_img: String?=null, val info_img: String?=null, val promo_ing: String?=null,
                   val bottom_out_force: String?=null, val spring: String?=null, val tac_travel: String?=null,
                   val price: String?=null, val total_travel: String?=null, val op_force: String?=null,
                   val name: String?=null, val bio: String?=null, val tac_foce: String?=null,
                   val type: String?=null, val pre_travel: String?=null) {
    companion object {
        private var counter = 0L
    }
}


sealed class DataState {
    class Success(val data: MutableList<SwitchK>) : DataState()
    class Failure(val message: String) : DataState()
    object Loading : DataState()
    object Empty : DataState()
}

class SwitchCardViewModel : ViewModel() {

    val response: MutableState<DataState> = mutableStateOf(DataState.Empty)
    var selectCount by mutableIntStateOf(0)
        private set

    var ffvisible by mutableStateOf(false)
        private set

    var scrollStateValue by mutableIntStateOf(0)
        private set

    var sC = mutableStateListOf<Long>(0, 0)
        private set

    fun cv(){
        ffvisible = !ffvisible
    }
    fun moveToCard(){
        try{
            sC.first()
        } finally {
            scrollStateValue = sC.first().toInt()
            sC.reverse()
        }
    }

    fun radioButtonLogic(curState: Boolean, id: Long): Boolean {
        if (!curState){
            if (selectCount < 2){
                sC.add(id)
                selectCount += 1
                return true
            }
            return false
        }
        else{
            if (selectCount != 0){
                sC.removeLast()
                selectCount -= 1
                return false
            }
            return true
        }
    }

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