package com.example.nbc_givehub
data class UserData(
    var id: String = "",
    var password: String = "",
    var name: String = "",
    var mbti: String = "",
    var launguage: String = "",
    var git: String = "",
    var blog: String = ""
){
    companion object{
        var datalist = arrayListOf(
            UserData("jgs288", "Abcdef!","장규식", "-", "Android / Kotlin","github.com/JnagGyuSik", "aquaria-kr.tistory.com/"),
            UserData("dkswlsgur123", "Abcdef@","안진혁", "ENTP", "Android / Kotlin","github.com/AnJinHyuck", "noisno.tistory.com/"),
            UserData("jyk0435", "Abcdef#","윤영진","INFP", "Android / Kotlin","github.com/jinnnyyy", "yyj1624.tistory.com/"),
            UserData("neoneoneo123", "Abcdef$","정지연", "ENFJ", "Android / Kotlin","github.com/neoneoneo123", "velog.io/@neoneoneo/posts"),
            UserData("jyy3637", "Abcdef%","정예윤", "ENTP", "Android / Kotlin", "github.com/JYeyun", "ginger-code.tistory.com/")
        )
        fun showlist() : ArrayList<UserData>{
            return datalist
        }
        fun createUser(id:String, password:String, name:String ) {
            var user = UserData(id, password, name, "", "", "", "")
            datalist.add(user)
        }
        fun searchUser(id: String) {

        }
        fun deleteUser(){

        }
    }
}
