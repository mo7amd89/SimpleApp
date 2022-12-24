package com.justadeveloper96.feature_auth

import com.justadeveloper96.repository_auth.IUser

data class NewUser(override val id: String,val email:String): IUser