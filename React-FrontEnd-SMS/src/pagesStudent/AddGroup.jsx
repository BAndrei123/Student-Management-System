import React, { useState, useEffect } from 'react'
import { SidebarAdmin } from '../Components/SidebarAdmin/SidebarAdmin'
import './AddGroup.css'
import axios from 'axios'
import ArrowDropDownIcon from '@mui/icons-material/ArrowDropDown';
import ArrowDropUpIcon from '@mui/icons-material/ArrowDropUp';
export const AddGroup = () => {
  const [choose, setchoose] = useState("AddGroup");
  const [GroupNumber, setGroupNumber] = useState("");
  const [groupsList, setGroupsList] = useState([]);

  const [isActiveDeleteG, setIsActiveDeleteG] = useState(false);
  const [selectDeleteG, setDeleteG] = useState("Select ID to Edit");

  async function saveGroup(event) {
    event.preventDefault();

    try {

      await axios.post("http://localhost:8080/api/v1/groups/add",
        {

          groupNumber: GroupNumber

        }).then((res) => {
          if (res.data !== null) {
            alert("Group added");
          }

        });


    }
    catch (err) {
      console.log(err);
      alert("Group Registation Failed");
    }
  }

  const fetchAllGroups = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/v1/groups/get/all');
      const data = await response.json();
      setGroupsList(data);
    } catch (error) {
      console.error('Error fetching students list:', error);
    }
  };
  useEffect(() => {
    fetchAllGroups();


  }, []);

  const getAllGroupsIDS = (groupsListList) => {
    return groupsList.map((group) => group.groupNumber);
  }

  const groupNumbers = getAllGroupsIDS(groupsList);
  const getID = (groupsList, groupNumber) => {
    const foundGroup = groupsList.find((group) => group.groupNumber === groupNumber);

    if (foundGroup) {
        return foundGroup.groupId;
    } else {
        return 0; // Return 0 if no matching email is found
    }
};
  async function DeleteGroup(event) {
    event.preventDefault();

    try {

        await axios.delete("http://localhost:8080/api/v1/groups/delete/" + getID(groupsList,selectDeleteG),
            {



            }).then((res) => {
                if (res.data !== null) {
                    fetchAllGroups();
                    const index = groupNumbers.indexOf(selectDeleteG);
                    groupNumbers.splice(index, 1);
                    setDeleteG("Select ID to Delete");
                    alert("Group deleted");

                }

            });
    }
    catch (err) {
        alert(err);
    }
}

  return (

    <div className="page-container">
      <div className="sidebar-container">
        <SidebarAdmin />
      </div>
      <div className="content-container">
        <div className="buttons">
          <div className="submit-container-groups">
            <div className={choose === "AddGroup" ? "submit-groups" : "submit-groups gray-groups"} onClick={() => { setchoose("AddGroup") }}>
              Add Group
            </div>

            <div className={choose === "DeleteGroup" ? "submit-groups" : "submit-groups gray-groups"} onClick={() => { setchoose("DeleteGroup") }}>
              Delete Group
            </div>
          </div>
        </div>
        <div className="inputs-groups">
          {choose === "AddGroup" && (
            <div className="input-groups">

              <input type="number" placeholder='Group Number'

                value={GroupNumber}
                onChange={(event) => {
                  setGroupNumber(event.target.value);
                }}
              />
            </div>)}
          {choose==="DeleteGroup"&& (
            <>
              <div className="dropdown-students">
                <div className="dropdown-btn" onClick={() => { setIsActiveDeleteG(!isActiveDeleteG) }}> {selectDeleteG}
                  {!isActiveDeleteG &&
                    <ArrowDropDownIcon />
                  }
                  {isActiveDeleteG &&
                    <ArrowDropUpIcon />

                  }
                </div>

                {isActiveDeleteG &&
                  <div className="dropdown-content">
                    {
                      groupNumbers.map(option => {
                        return <div key={option} onClick={() => { setDeleteG(option); setIsActiveDeleteG(false); }} className='dropdown-item'>{option}</div>
                      })
                    }

                  </div>
                }
              </div>
            </>
          )}

          
          <div className="make-change" onClick={choose==="AddGroup"?saveGroup:DeleteGroup}>
            Make change
          </div>
        </div>
      </div>
    </div>
  )
}
