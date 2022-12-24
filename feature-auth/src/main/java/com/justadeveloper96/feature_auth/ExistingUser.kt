package com.justadeveloper96.feature_auth

import com.justadeveloper96.repository_auth.IUser

data class ExistingUser(override val id: String) : IUser