import React, { useState, useEffect } from 'react'
import { SidebarAdmin } from '../Components/SidebarAdmin/SidebarAdmin'
import './Students.css'


import ArrowDropDownIcon from '@mui/icons-material/ArrowDropDown';
import ArrowDropUpIcon from '@mui/icons-material/ArrowDropUp';
import axios from 'axios'

export const Students = () => {
    const [name, setName] = useState("");

    const [Age, setAge] = useState("");
    const [Phone, setPhone] = useState("");
    const [choose, setchoose] = useState("AddStudent");

    const [isActiveCredentials, setIsActiveC] = useState(false);
    const [selectCredentials, setCredentials] = useState("Select credentials");
    const [credentialsList, setCredentialsList] = useState([]);

    const [isActiveGroup, setIsActiveGroup] = useState(false);
    const [selectedbyGroup, setselectedByGroup] = useState("Select group");
    const optionsGroup = ["30411", "30412", "30413", "30414", "30421", "30422", "30423", "30424", "30431", "30432", "30433", "30434", "30441", "30442", "30443", "30444"]

    const [isActiveI, setIsActiveI] = useState(false);
    const [selectI, setI] = useState("Select situation");
    const optionsSit = ["Integralist", "Restantier"];

    const [isActiveS, setIsActiveS] = useState(false);
    const [selectS, setS] = useState("Select scholarship");
    const optionsS = ["Bursa de performanta 1", "Bursa de perfomarmanta 2", "Bursa sociala", "Nu are"];

    const [isActiveD, setIsActiveD] = useState(false);
    const [selectD, setD] = useState("Select dorms");
    const optionsD = ["Observator", "Marasti", "None"];

    const [studentsList, setStudentsList] = useState([]);
    const [groupsList,setGroupsList] =useState([]);
    const [student, setStudent] = useState();
    const fetchAllCredentials = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/v1/credentials/get/all');
            const data = await response.json();
            setCredentialsList(data);
        } catch (error) {
            console.error('Error fetching students list:', error);
        }
    };
    const fetchAllStudents = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/v1/students/get/all');
            const data = await response.json();
            setStudentsList(data);
        } catch (error) {
            console.error('Error fetching students list:', error);
        }
    };
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
        fetchAllCredentials();
        fetchAllStudents();
        fetchAllGroups();
    }, []);


    const getAllGroupsIDS = (groupsListList) => {
        return groupsList.map((group) => group.groupNumber);
    }
    const groupNumbers = getAllGroupsIDS(groupsList);
    const getGroupsID = (groupsList, groupNumber) => {
    const foundGroup = groupsList.find((group) => group.groupNumber === groupNumber);

    if (foundGroup) {
        return foundGroup.groupId;
    } else {
        return 0; // Return 0 if no matching email is found
    }
    };
    const getUniqueEmail = (credentialsList) => {
        const uniqueGroupsSet = new Set();
        credentialsList.forEach((credential) => {
            const group = credential.email;
            if (group) {
                uniqueGroupsSet.add(group);
            }
        });

        return Array.from(uniqueGroupsSet);
    };

    const optionsEmail = getUniqueEmail(credentialsList);
    const [isActiveDelete, setIsActiveDelete] = useState(false);
    const [selectDelete, setDelete] = useState("Select ID to Delete");

    const [isActiveEdit, setIsActiveEdit] = useState(false);
    const [selectEdit, setEdit] = useState("Select ID to Edit");


    const getAllStudentsIDS = (studentsList) => {
        return studentsList.map((student) => student.studentId);
    }

    const studentsIDS = getAllStudentsIDS(studentsList);


    const getID = (credentialsList, email) => {
        const foundCredential = credentialsList.find((credential) => credential.email === email);

        if (foundCredential) {
            return foundCredential.credentialsID;
        } else {
            return 0; // Return 0 if no matching email is found
        }
    };

    async function saveStud(event) {
        event.preventDefault();

        try {

            await axios.post("http://localhost:8080/api/v1/students/add",
                {

                    name: name,
                    age: Age,
                    credentials: getID(credentialsList, selectCredentials),
                    phoneNumber: Phone,
                    group: getGroupsID(groupsList,selectedbyGroup),
                    scholarship: optionsS.indexOf(selectS) + 1,
                    integralist: (selectI === "Integralist" ? true : false),
                    dorms: optionsD.indexOf(selectD) + 1

                }).then((res) => {
                    if (res.data !== null) {
                        alert("Student added");
                        setCredentials("Select credentials")
                        setName("");
                        setAge("");
                        setPhone("");
                        setselectedByGroup("Select group");
                        setI("Select situation");
                        setS("Select scholarship");
                        setD("Select dorms");
                    }

                });


        }
        catch (err) {
            console.log(err);
            alert("Student Registation Failed");
        }
    }


    async function deleteStud(event) {
        event.preventDefault();

        try {

            await axios.delete("http://localhost:8080/api/v1/students/delete/" + selectDelete,
                {



                }).then((res) => {
                    if (res.data !== null) {
                        fetchAllStudents();
                        const index = studentsIDS.indexOf(selectDelete);
                        studentsIDS.splice(index, 1);
                        setDelete("Select ID to Delete");
                        alert("Student deleted");

                    }

                });
        }
        catch (err) {
            alert(err);
        }
    }
    async function updateStud(event) {
        event.preventDefault();

        try {

            await axios.put("http://localhost:8080/api/v1/students/update",
                {
                    studentId: selectEdit,
                    name: name,
                    age: Age,
                    credentials: getID(credentialsList, selectCredentials),
                    phoneNumber: Phone,
                    group: getGroupsID(groupsList,selectedbyGroup),
                    scholarship: optionsS.indexOf(selectS) + 1,
                    integralist: (selectI === "Integralist" ? true : false),
                    dorms: optionsD.indexOf(selectD) + 1

                }).then((res) => {
                    if (res.data !== null) {
                        alert("Student updated");
                        setEdit("Select ID to Edit");
                        setCredentials("Select credentials")
                        setName("");
                        setAge("");
                        setPhone("");
                        setselectedByGroup("Select group");
                        setI("Select situation");
                        setS("Select scholarship");
                        setD("Select dorms");
                    }

                });


        }
        catch (err) {
            console.log(err);
            alert("Student Update Failed");
        }
    }
    const fetchStudent = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/v1/students/get/' + selectEdit);
            const data = await response.json();
            setStudent(data);
        } catch (err) {
            alert(err);
        }
    }
    useEffect(() => {
        if (selectEdit !== "Select ID to Edit") {
            fetchStudent();
            
            
        }
    }, [selectEdit])
    useEffect(()=>{
        if(student){
        setCredentials(student.credentials.email);
            setName(student.name);
            setAge(student.age);
            setPhone(student.phoneNumber);
            setselectedByGroup(student.group.groupNumber.toString());
            setI(student.integralist===true?"Integralist":"Restantier");
            setS(student.scholarship.scholarshipType);
            setD(student.dorms.address.toString());}
    },[student])
    console.log(student);
    return (
        <div className="page-container">
            <div className="sidebar-container">
                <SidebarAdmin />
            </div>
            <div className="content-container">
                <div className="buttons">
                    <div className="submit-container-students">
                        <div className={choose === "AddStudent" ? "submit-students" : "submit-students gray-students"} onClick={() => { setchoose("AddStudent") }}>
                            Add Student
                        </div>
                        <div className={choose === "EditStudent" ? "submit-students" : "submit-students gray-students"} onClick={() => { setchoose("EditStudent") }}>
                            Edit Student
                        </div>
                        <div className={choose === "DeleteStudent" ? "submit-students" : "submit-students gray-students"} onClick={() => { setchoose("DeleteStudent") }}>
                            Delete Student
                        </div>
                    </div>
                </div>
                <div className="inputs-students">

                    {(choose === "AddStudent" || choose === "EditStudent") && (
                        <>
                            {choose === "EditStudent" && (
                                <>
                                    <div className="dropdown-students">
                                        <div className="dropdown-btn" onClick={() => { setIsActiveEdit(!isActiveEdit) }}> {selectEdit}
                                            {!isActiveEdit &&
                                                <ArrowDropDownIcon />
                                            }
                                            {isActiveEdit &&
                                                <ArrowDropUpIcon />

                                            }
                                        </div>

                                        {isActiveEdit &&
                                            <div className="dropdown-content">
                                                {
                                                    studentsIDS.map(option => {
                                                        return <div key={option} onClick={() => { setEdit(option); setIsActiveEdit(false); }} className='dropdown-item'>{option}</div>
                                                    })
                                                }

                                            </div>
                                        }
                                    </div>
                                </>
                            )}

                            <div className="input-students">

                                <input type="text" placeholder='Name'
                                    value={name}
                                    onChange={(event) => {
                                        setName(event.target.value);
                                    }}
                                />
                            </div>



                            <div className="input-students">

                                <input type="number" placeholder='Age'

                                    value={Age}
                                    onChange={(event) => {
                                        setAge(event.target.value);
                                    }}
                                />
                            </div>

                            <div className="dropdown-students">
                                <div className="dropdown-btn" onClick={() => { setIsActiveC(!isActiveCredentials) }}> {selectCredentials}
                                    {!isActiveCredentials &&
                                        <ArrowDropDownIcon />
                                    }
                                    {isActiveCredentials &&
                                        <ArrowDropUpIcon />

                                    }
                                </div>

                                {isActiveCredentials &&
                                    <div className="dropdown-content">
                                        {
                                            optionsEmail.map(option => {
                                                return <div key={option} onClick={() => { setCredentials(option); setIsActiveC(false) }} className='dropdown-item'>{option}</div>
                                            })
                                        }

                                    </div>
                                }
                            </div>
                            <div className="input-students">

                                <input type="text" placeholder='Phone'

                                    value={Phone}
                                    onChange={(event) => {
                                        setPhone(event.target.value);
                                    }}
                                />
                            </div>

                            <div className="dropdown-students">
                                <div className="dropdown-btn" onClick={() => { setIsActiveGroup(!isActiveGroup) }}> {selectedbyGroup}
                                    {!isActiveGroup &&
                                        <ArrowDropDownIcon />
                                    }
                                    {isActiveGroup &&
                                        <ArrowDropUpIcon />

                                    }
                                </div>
                                {isActiveGroup &&
                                    <div className="dropdown-content">
                                        {
                                            groupNumbers.map(option => {
                                                return <div key={option} onClick={() => { setselectedByGroup(option); setIsActiveGroup(false) }} className='dropdown-item'>{option}</div>
                                            })
                                        }

                                    </div>
                                }
                            </div>
                            <div className="dropdown-students">
                                <div className="dropdown-btn" onClick={() => { setIsActiveI(!isActiveI) }}> {selectI}
                                    {!isActiveI &&
                                        <ArrowDropDownIcon />
                                    }
                                    {isActiveI &&
                                        <ArrowDropUpIcon />

                                    }
                                </div>
                                {isActiveI &&
                                    <div className="dropdown-content">
                                        {
                                            optionsSit.map(option => {
                                                return <div key={option} onClick={() => { setI(option); setIsActiveI(false) }} className='dropdown-item'>{option}</div>
                                            })
                                        }

                                    </div>
                                }
                            </div>
                            <div className="dropdown-students">
                                <div className="dropdown-btn" onClick={() => { setIsActiveS(!isActiveS) }}> {selectS}
                                    {!isActiveS &&
                                        <ArrowDropDownIcon />
                                    }
                                    {isActiveS &&
                                        <ArrowDropUpIcon />

                                    }
                                </div>
                                {isActiveS &&
                                    <div className="dropdown-content">
                                        {
                                            optionsS.map(option => {
                                                return <div key={option} onClick={() => { setS(option); setIsActiveS(false) }} className='dropdown-item'>{option}</div>
                                            })
                                        }

                                    </div>
                                }
                            </div>

                            <div className="dropdown-students">
                                <div className="dropdown-btn" onClick={() => { setIsActiveD(!isActiveD) }}> {selectD}
                                    {!isActiveD &&
                                        <ArrowDropDownIcon />
                                    }
                                    {isActiveD &&
                                        <ArrowDropUpIcon />

                                    }
                                </div>
                                {isActiveD &&
                                    <div className="dropdown-content">
                                        {
                                            optionsD.map(option => {
                                                return <div key={option} onClick={() => { setD(option); setIsActiveD(false) }} className='dropdown-item'>{option}</div>
                                            })
                                        }

                                    </div>
                                }
                            </div></>)}
                    {choose === "DeleteStudent" && (
                        <>
                            <div className="dropdown-students">
                                <div className="dropdown-btn" onClick={() => { setIsActiveDelete(!isActiveDelete) }}> {selectDelete}
                                    {!isActiveDelete &&
                                        <ArrowDropDownIcon />
                                    }
                                    {isActiveDelete &&
                                        <ArrowDropUpIcon />

                                    }
                                </div>

                                {isActiveDelete &&
                                    <div className="dropdown-content">
                                        {
                                            studentsIDS.map(option => {
                                                return <div key={option} onClick={() => { setDelete(option); setIsActiveDelete(false) }} className='dropdown-item'>{option}</div>
                                            })
                                        }

                                    </div>
                                }
                            </div>
                        </>
                    )}
                    <div className="make-change" onClick={choose === "AddStudent" ? saveStud : choose==="EditStudent"? updateStud: deleteStud}>
                        Make change
                    </div>
                </div>

            </div>
        </div>
    )
}
