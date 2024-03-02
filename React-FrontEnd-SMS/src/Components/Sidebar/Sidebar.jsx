import React from 'react'
import '../../App.css';
import { SidebarData } from './SidebarData';
import LogoutIcon from '@mui/icons-material/Logout';
import { useNavigate, useLocation } from 'react-router-dom';


export const Sidebar = () => {
  const location = useLocation();
    const { search } = location;
    const params = new URLSearchParams(search);

    const role = params.get('role');
  const navigate = useNavigate();
  return (
    <div className='Sidebar' >
        <ul className='SidebarList'>{
            
            SidebarData.map((val,key)=>{
                return <li key={key} className='row' id={window.location.pathname === val.link ? "active" : ""}onClick={()=>{window.location.pathname = val.link}}>
            
                  <div id='icon'>{val.icon}</div> 
                  <div id='title'> {val.title}</div>
                    
                    
                </li>
            }) 
        }
        </ul>
        <div className="Logout" onClick={()=>{navigate('/')}}>
          <LogoutIcon/>
          Log out
        </div>
    </div>
  )
}
