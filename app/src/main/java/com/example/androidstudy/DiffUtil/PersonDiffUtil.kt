package com.example.androidstudy.DiffUtil

import androidx.recyclerview.widget.DiffUtil

class PersonDiffUtil(
    val oldList : ArrayList<PersonModel>,
    val newList : ArrayList<PersonModel>
) : DiffUtil.Callback() {


    // 이전 목록의 개수를 반환
    override fun getOldListSize(): Int = oldList.size

    // 새로운 목록의 개수를 반환
    override fun getNewListSize(): Int = newList.size

    // 두 개 목록의 객체가 같은지 비교
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

        return oldList[oldItemPosition] == newList[newItemPosition]

    }

    // 두 개 목록의 아이템이 같은지 비교
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        return oldItem.name == newItem.name
    }


    // areItemsTheSame 의 리턴값이 true 이고
    // areContentsTheSame 의 리턴값이 false 이면 이 메소드가 호출되서
    // 변경 내용에 대한 페이로드를 가져온다
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

}