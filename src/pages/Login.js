import React from 'react'
import { useNavigate } from "react-router-dom";
import AuthService from "../services/AuthService";
import { useState, useEffect } from 'react';


const Login = () => { 

  const navigate=useNavigate();

    const[user,setUser]=useState({

       username:"",
       password:""
    });

    const login=()=>{

     AuthService.login(user)

     .then(res=>{

          localStorage.setItem("token",res.data.token);

          navigate("/dashboard");
        })

     .catch(err=>{

         alert("Invalid Credentials");
       })
    }



  return (

    <div className="container mt-5">

    <h2>Login</h2>

  <input
   className="form-control mb-2"
   placeholder="Username"
   onChange={(e)=>setUser({...user,username:e.target.value})}
  />

  <input
   type="password"
   className="form-control mb-3"
   placeholder="Password"
   onChange={(e)=>setUser({...user,password:e.target.value})}
  />

  <button
   className="btn btn-success"
   onClick={login} 
   >Login</button>

  </div>
  )
}
export default Login