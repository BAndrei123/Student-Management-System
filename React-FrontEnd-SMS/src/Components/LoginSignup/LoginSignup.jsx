import React, { useState } from 'react'
import axios from 'axios';
import './LoginSignup.css'
import user_icon from '../Assets/person.png'
import email_icon from '../Assets/email.png'
import password_icon from '../Assets/password.png'
import role_icon from '../Assets/role.png'
import { useNavigate } from 'react-router-dom';
export const LoginSignup = () => {

    const[action,setAction] = useState("Login");
    
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [role, setRole] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();
    async function save(event)
    {
        event.preventDefault();
    try
        {
         await axios.post("http://localhost:8080/api/v1/credentials/save",
        {
        
        username: name,
        role : role,
        email : email,
        password : password
        
        }).then((res)=>
        {
            //console.log(res.data);
            if (res.data.message==="insert all fields")
            {
                alert("All fields need to be inserted");
            }
            if(res.data.message==="Insert valid email")
            {
                alert("Insert valid email (example@example.com)");
            }
            if(res.data.message==="Email already exists")
            {
                alert("Email already exists");
            }
            if(res.data.message==="succed")
            {
                alert("Success");
            }
        });        
          setPassword("");
        
        }
    catch(err)
        {
          alert("User Registation Failed");
        }
   }

   async function login(event) {
    event.preventDefault();
    try {
      await axios.post("http://localhost:8080/api/v1/credentials/login", {
        email: email,
        password: password,
        }).then((res) => 
        {
         console.log(res.data);
         
         if (res.data.message === "Email does not exist") 
         {
           alert("Email not exits");
         } 
         else if(res.data.message === "logged in successfully")
         { 
            console.log(res.data);
        // Navigate to the homepage
           navigate('/home?id='+res.data.id+'&role='+res.data.role);
         } 
          else 
         { 
            alert("Incorrect Email and Password not match");
         }
      }, fail => {
       console.error(fail); // Error!
        });
    }

     catch (err) {
      alert(err);
    }
  
}
  return (
    <div className="container">
        <div className="container-in">
            <div className="header">
                <div className="text">{action}</div>
                <div className="underline"></div>
            </div>
            <div className="inputs">
                {
                    action==="Login"? <div></div>:
                    <div className="input">
                    <img src={user_icon} alt="" />
                    <input type="text" placeholder='Name'
                    value={name}
                    onChange={(event)=>{
                        setName(event.target.value);
                    }}
                    />
                    </div>
                }
                
                {
                    action==="Login"? <div></div>: 
                    <div className="input">
                    <img src={role_icon} alt="" />
                    <input type="number" placeholder='Role' 
                    
                    value={role}
                    onChange={(event)=>{
                        setRole(event.target.value);
                    }}
                    />
                    </div>
                }
                

                <div className="input">
                <img src={email_icon} alt="" />
                <input type="email" placeholder='Email'

                value={email}
                onChange={(event)=>{
                    setEmail(event.target.value);
                }}
                
                />
                </div>

                <div className="input">
                <img src={password_icon} alt="" />
                <input type="password" placeholder='Password'
                
                value={password}
                    onChange={(event)=>{
                        setPassword(event.target.value);
                    }}
                
                />
                </div>

            </div>
            <div className="forgot-password">Lost password? <span>Click here!</span></div>
            <div className="submit-container">
                <div className={action==="Login"?"submit gray":"submit"} onClick={ action==="Sign Up" ? save : ()=>{setAction("Sign Up")}}>
                Sign Up
                </div>
                <div className={action==="Sign Up"?"submit gray":"submit"} onClick={action==="Login"?login:()=>{setAction("Login")}}>
                    Login
                </div>
            </div>
        </div>
    </div>
  )
}
