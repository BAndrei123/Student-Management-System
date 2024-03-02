
import React, { useState, useEffect } from 'react';
import { Sidebar } from '../Components/Sidebar/Sidebar'
import { SidebarAdmin } from '../Components/SidebarAdmin/SidebarAdmin';
import { useLocation } from 'react-router-dom';
import logo from '../Components/Assets/Logo_Universitatea_Tehnică_din_Cluj-Napoca.svg.png'
import './Home.css'

export const Home = () => {
    
    const location = useLocation();
    const { search } = location;
    const params = new URLSearchParams(search);

    const role = params.get('role');
    const id = params.get('id');

    console.log('Role:', role);
    console.log('ID:', id);
  
    const [studentData, setStudentData] = useState(null);
  
    const fetchStudentData = async () => {
        try {
          const response = await fetch('http://localhost:8080/api/v1/students/get/credentials/'+id);
          const data = await response.json();
          setStudentData(data);
        } catch (error) {
          console.error('Error fetching student data:', error);
        }
    };

    useEffect(() => {
        fetchStudentData();
        
    }, []);

  return (
    <div className="page-container">
    <div className="sidebar-container">
    {role=== '1' ? <SidebarAdmin/>:<Sidebar/>}
    </div>
    <div className="content-container">
        <div className="top-part">
        {studentData && 
            <div className='welcome'>Welcome, {studentData.name}</div>}
        </div>
        
            {studentData && (
                <div className="personal-info">
                <div className="field">Email</div>
                <div className="info">{studentData.credentials.email ? studentData.credentials.email : ""}</div>
                <div className="field">Username</div>
                <div className="info">{studentData.credentials.username}</div>
                <div className="field">Numar de telefon</div>
                <div className="info">{studentData.phoneNumber}</div>
                
                {role!=='1' &&(
                <div>
                <div className="field">Group</div>
                <div className="info">{studentData.group.groupNumber}</div>
                <div className="field">Situatie</div>
                <div className="info">{studentData.integralist===true?"Integralist":"Restantier"}</div>
                <div className="field">Bursa</div>
                <div className="info">{studentData.scholarship.scholarshipType}</div>
                <div className="field">Cazare</div>
                <div className="info">{studentData.dorms.address}</div>
                <div className="field">Numar camera</div>
                <div className="info">{studentData.dorms.roomsInDorms.roomNumber}</div>
                </div>)}
                </div>
            )                
            }   
        
        
        <div className="logo-container">
          <img src={logo} alt="Logo" />
        </div>
    </div>
  </div>
  )
}
