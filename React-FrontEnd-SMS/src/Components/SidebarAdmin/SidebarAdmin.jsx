import React from 'react'
import '../../App.css';
import { SidebarDataAdmin } from './SidebarDataAdmin';
import LogoutIcon from '@mui/icons-material/Logout';
import { useNavigate, useLocation } from 'react-router-dom';


export const SidebarAdmin = () => {
  const location = useLocation();
    const { search } = location;
    const params = new URLSearchParams(search);

    const role = params.get('role');
  const navigate = useNavigate();
  return (
    <div className='SidebarAdmin' >
        <ul className='SidebarListAdmin'>{
            
            SidebarDataAdmin.map((val,key)=>{
                return <li key={key} className='rowAdmin' id={window.location.pathname === val.link ? "activeAdmin" : ""}onClick={()=>{window.location.pathname = val.link}}>
                  
                <div id='iconAdmin'>{val.icon}</div> 
                <div id='titleAdmin'> {val.title}</div>
                    
                    
                </li>
            }) 
        }
        </ul>
        <div className="LogoutAdmin" onClick={()=>{navigate('/')}}>
          <LogoutIcon/>
          Log out
        </div>
    </div>
  )
}
