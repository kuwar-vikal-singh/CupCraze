package com.axel.cupcraze.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.axel.cupcraze.Model.CategoryModel
import com.axel.cupcraze.Model.ItemsModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.sql.Ref

class MainViewModel :ViewModel() {
    private val firebaseDatabase = FirebaseDatabase.getInstance()

    private val _category = MutableLiveData<MutableList<CategoryModel>>()
    private  val _popular =MutableLiveData<MutableList<ItemsModel>>()
    private  val _offer =MutableLiveData<MutableList<ItemsModel>>()

    val category:LiveData<MutableList<CategoryModel>> =_category
    val popular:LiveData<MutableList<ItemsModel>> =_popular
    val offer:LiveData<MutableList<ItemsModel>> =_offer

    fun loadCategory(){

        val Ref = firebaseDatabase.getReference("Category")
        Ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
               val lists = mutableListOf<CategoryModel>()

                for (childSnapshot in snapshot.children){
                    val list  = childSnapshot.getValue(CategoryModel::class.java)

                    if (list!=null) {
                        lists.add(list)
                    }
                }
                _category.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    fun loadPopular(){
        val Ref = firebaseDatabase.getReference("Items")
        Ref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
              val lists = mutableListOf<ItemsModel>()

                for (childSnapsot in snapshot.children){
                    val list = childSnapsot.getValue(ItemsModel::class.java)
                    if (list!=null){
                        lists.add(list)
                    }
                }
                _popular.value = lists

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    fun loadOffer(){
        val Ref = firebaseDatabase.getReference("Offers")
        Ref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
              val lists = mutableListOf<ItemsModel>()

                for (childSnapsot in snapshot.children){
                    val list = childSnapsot.getValue(ItemsModel::class.java)
                    if (list!=null){
                        lists.add(list)
                    }
                }
                _offer.value = lists

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }


}