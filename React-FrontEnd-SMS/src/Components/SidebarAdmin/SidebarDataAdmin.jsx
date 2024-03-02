import React from 'react'
import HomeIcon from '@mui/icons-material/Home';
import GroupIcon from '@mui/icons-material/Group';
import PersonAddIcon from '@mui/icons-material/PersonAdd';
import GroupAddIcon from '@mui/icons-material/GroupAdd';
export const SidebarDataAdmin = [
    {
        title: "Home",
        icon: <HomeIcon />,
        link: "/home"
    },
    
    {
        title: "Groups",
        icon: <GroupIcon />,
        link: "/group"
    },
    {
        title: "Students",
        icon: <PersonAddIcon />,
        link: "/addStudent"
    },
    {
        title: "Add Group",
        icon: <GroupAddIcon />,
        link: "/addGroup"
    }
    
]
