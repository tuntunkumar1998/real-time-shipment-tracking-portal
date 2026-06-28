import React from 'react'

import axios from "axios";

const API="http://localhost:9292/api/auth";

class AuthService{
   login(user){

return axios.post(API+"/login",user);

   }
  
}

export default AuthService