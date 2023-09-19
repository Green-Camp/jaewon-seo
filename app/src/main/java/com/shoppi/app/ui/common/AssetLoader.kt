package com.shoppi.app.ui.common

import android.content.Context

class AssetLoader(private val context: Context) {
    //exception 발생시에 처리 함수
    fun getJsonString(fileName: String): String? {
        //runcathing 함수를 사용하여 성공하면 Result 객체에서 성공 실패 여부를 알 수 있다.
        return kotlin.runCatching {
            loadAsset(fileName)
            //오류발생시에 Null을 반환하기 위해 getOrNull함수를 사용한다.
        }.getOrNull()
    }

    //loadAsset이 원하는 값 = json 값을 String으로 변환 -> 리턴이 String
    //use 함수 내부 구현에서는 exception이 발생 가능하다. -> 발생 했을 때 처리 필요
    private fun loadAsset(fileName: String): String {
        return context.assets.open(fileName).use { inputStream ->
            val size = inputStream.available()
            val bytes = ByteArray(size)
            inputStream.read(bytes)
            String(bytes)
        }
    }
}