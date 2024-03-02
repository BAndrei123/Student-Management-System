import React, {useState, useEffect,useMemo} from 'react'
import './Groups.css'
import { Sidebar } from '../Components/Sidebar/Sidebar'
import { SidebarAdmin } from '../Components/SidebarAdmin/SidebarAdmin'
import { useTable} from "react-table"
import ArrowDropDownIcon from '@mui/icons-material/ArrowDropDown';
import ArrowDropUpIcon from '@mui/icons-material/ArrowDropUp';
import { useLocation } from 'react-router-dom'
export const Groups = () => {
  const location = useLocation();
  const { search } = location;
  const params = new URLSearchParams(search);

  const role = params.get('role');

    const [studentsList, setStudentsList] = useState([]);

    const [isActiveYear, setIsActiveYear] = useState(false);
    const [selectedbyYear, setselectedByYear] = useState("Filter by year");

    const [isActiveGroup, setIsActiveGroup] = useState(false);
    const [selectedbyGroup, setselectedByGroup] = useState("Filter by group");

    const [isActiveEdit, setIsActiveEdit] = useState(false);
    const [selectEdit, setEdit] = useState("Select ID to Edit");

    const [filterName, setFilterName] = useState('');

    // Fetch students data
    const fetchAllStudents = async () => {
        try {
          const response = await fetch('http://localhost:8080/api/v1/students/get/all');
          const data = await response.json();
          setStudentsList(data);
        } catch (error) {
          console.error('Error fetching students list:', error);
        }
    };
    
    // Fetch data on component mount
    useEffect(() => {
        fetchAllStudents();
    }, []);

    // Memoize columns to avoid unnecessary re-renders
    const columns = useMemo(() => [
        {
          Header: "Nume",
          accessor: "name",
        },
        {
          Header: "Year",
          accessor: "group.groupYear",
        },
        {
          Header: "Group",
          accessor: "group.groupNumber",
        },
        
    ], []);

    const getUniqueGroups = (studentsList) => {
      const uniqueGroupsSet = new Set();
      studentsList.forEach((student) => {
        const group = student.group.groupNumber;
        uniqueGroupsSet.add("Select none");
        if (group) {
          uniqueGroupsSet.add(group);
        }
      });
      
      return Array.from(uniqueGroupsSet);
    };
    const optionsGroup = getUniqueGroups(studentsList);
    
    const getUniqueYear = (studentsList) => {
      const uniqueGroupsSet = new Set();
      studentsList.forEach((student) => {
        const year = student.group.groupYear;
        uniqueGroupsSet.add("Select none");
        if (year) {
          uniqueGroupsSet.add(year);
        }
      });
      
      return Array.from(uniqueGroupsSet);
    };
    
    const optionsYear= getUniqueYear(studentsList);

    // Memoize data passed to useTable
   const data = useMemo(
    () => studentsList.filter(student =>
    (selectedbyYear === "Filter by year" || selectedbyYear === "Select none" || student.group.groupYear === selectedbyYear) &&
    (selectedbyGroup === "Filter by group" || selectedbyGroup === "Select none" || student.group.groupNumber === selectedbyGroup)
    ), [studentsList, selectedbyGroup, selectedbyYear]
    );
    // useTable instance
    const {
        getTableProps,
        getTableBodyProps,
        headerGroups,
        rows,
        prepareRow,
    } = useTable({
        columns,
        data,
    });

  return (
    <div className="page-container">
    <div className="sidebar-container">
    {role==='1' ?<SidebarAdmin/>:<Sidebar/>}
    </div>
    <div className="content-container">
    <div className="dropdown-year">
        <div className="dropdown-btn" onClick={()=>{setIsActiveYear(!isActiveYear)}}> {selectedbyYear}
        {!isActiveYear &&
        <ArrowDropDownIcon/>
        }
        { isActiveYear &&
        <ArrowDropUpIcon/>

        }
        </div>
        { isActiveYear &&
            <div className="dropdown-content">
              {
                optionsYear.map( option=>{
                return <div key={option} onClick={() =>{ setselectedByYear(option); setIsActiveYear(false)}} className='dropdown-item'>{option}</div>
                })
              }
  
            </div>
        }
      </div>
      
    <div className="dropdown-group">
        <div className="dropdown-btn" onClick={()=>{setIsActiveGroup(!isActiveGroup)}}> {selectedbyGroup}
        {!isActiveGroup &&
        <ArrowDropDownIcon/>
        }
        { isActiveGroup &&
        <ArrowDropUpIcon/>

        }
        </div>
        {isActiveGroup &&
            <div className="dropdown-content">
              {
                optionsGroup.map( option=>{
                return <div key={option} onClick={() =>{ setselectedByGroup(option); setIsActiveGroup(false)}} className='dropdown-item'>{option}</div>
                })
              }
  
            </div>
        }
      </div>


      <div className="table-container">
      <table {...getTableProps()}>
          <thead>
            {headerGroups.map((headerGroup) => (
              <tr {...headerGroup.getHeaderGroupProps()}>
                {headerGroup.headers.map((column) => (
                  <th {...column.getHeaderProps()}>
                    {column.render("Header")}
                  </th>
                ))}
              </tr>
            ))}
          </thead>
          <tbody {...getTableBodyProps()}>
            {rows.map((row) => {
              prepareRow(row);
              return (
                <tr {...row.getRowProps()}>
                  {row.cells.map((cell) => (
                    <td {...cell.getCellProps()}> {cell.render("Cell")} </td>
                  ))}
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
      
    </div>
  </div>
  )
}
